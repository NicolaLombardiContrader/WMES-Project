package wmes.dao;

import wmes.main.ConnectionSingleton;
import wmes.controller.GestoreEccezioni;
import wmes.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

	private final String QUERY_ALL = "select * from order";
	private final String QUERY_CREATE = "insert into order (user_user, user_pass, user_type) values (?,?,?)";
	private final String QUERY_READ = "select * from order where order_orderId=?";

	private final String QUERY_UPDATE = "UPDATE order SET order_userId=?, order_clientId=?, order_description=? WHERE order_orderId=?";
	private final String QUERY_DELETE = "delete from order where order_orderId=?";

	public OrderDAO() {

	}

	public List<Order> getAllUser() {
		List<Order> ordersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				int userId = resultSet.getInt("order_userId");
				int clientId = resultSet.getInt("order_clientId");
				String description = resultSet.getString("order_description");
				ordersList.add(new Order(userId, clientId, description));
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
			preparedStatement.setInt(1, order.getUserId());
			preparedStatement.setInt(2, order.getClientId());
			preparedStatement.setString(3, order.getDescription());
			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Order readOrder(int orderId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, orderId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int userId, clientId;
			String description;

			userId = resultSet.getInt("order_userId");
			clientId = resultSet.getInt("order_clientId");
			description = resultSet.getString("order_description");
			Order order = new Order(userId, clientId, description);
			order.setOrderId(resultSet.getInt("order_orderId"));

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
			preparedStatement.setInt(1, order.getUserId());
			preparedStatement.setInt(2, order.getClientId());
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

	public boolean deleteOrder(Integer orderId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, orderId);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}
}
