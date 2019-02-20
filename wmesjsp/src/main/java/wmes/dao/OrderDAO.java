package wmes.dao;

import wmes.main.ConnectionSingleton;
import wmes.main.GestoreEccezioni;
import wmes.model.Order;
import wmes.model.User;
import wmes.model.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

	private final String QUERY_ALL = "SELECT * FROM orders";
	private final String QUERY_CREATE = "insert into orders (user_id, client_id, order_description) values (?,?,?)";
	private final String QUERY_READ = "select * from orders where order_id=?";

	private final String QUERY_UPDATE = "UPDATE orders SET user_id=?, client_id=?, order_description=? WHERE order_id=?";
	private final String QUERY_DELETE = "DELETE FROM orders WHERE order_id=?";

	public OrderDAO() {

	}

	public List<Order> getAllOrder() {
		List<Order> ordersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
				
			Order order;
			while (resultSet.next()) {
				int orderId = resultSet.getInt("order_id");
				User userOrder= new User();
				userOrder.setUserId(resultSet.getInt("user_id"));
				Client clientOrder = new Client();
				clientOrder.setClientId(resultSet.getInt("client_id"));		
				String description = resultSet.getString("order_description");
				order = new Order(userOrder, clientOrder, description);
				order.setOrderId(orderId);
		
				ordersList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersList;
	}

	public boolean insertOrder(Order order) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, order.getUser().getUserId());
			preparedStatement.setInt(2, order.getClient().getClientId());
			preparedStatement.setString(3, order.getDescription());
			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Order readOrder(Order order) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, order.getOrderId());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int userId, clientId;
			String description;

			userId = resultSet.getInt("user_id");
			User userOrder = new User();
			userOrder.setUserId(userId);
			
			clientId = resultSet.getInt("client_id");
			Client clientOrder = new Client();
			clientOrder.setClientId(clientId);
			description = resultSet.getString("order_description");
			order = new Order(userOrder, clientOrder, description);
			order.setOrderId(resultSet.getInt("order_id"));

			return order;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}
	
	
	public boolean updateOrder(Order order) {
		Connection connection = ConnectionSingleton.getInstance();
		
		//Check if id is present
		if (order.getOrderId()==0)
			return false;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setInt(1, order.getUser().getUserId());
			preparedStatement.setInt(2, order.getClient().getClientId());
			preparedStatement.setString(3, order.getDescription());
			preparedStatement.setInt(4, order.getOrderId());
			int a = preparedStatement.executeUpdate();
			if (a > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean deleteOrder(Order order) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, order.getOrderId());
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}
}
