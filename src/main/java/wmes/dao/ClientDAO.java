package wmes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import wmes.controller.GestoreEccezioni;
import wmes.main.ConnectionSingleton;
import wmes.model.Client;
import wmes.model.User;

public class ClientDAO {

	private final String QUERY_ALL = "select * from client";
	private final String QUERY_INSERT = "insert into client (client_name) values (?)";
	private final String QUERY_READ = "select * from client where client_id=?";

	private final String QUERY_UPDATE = "UPDATE client SET client_name=? WHERE client_id=?";
	private final String QUERY_DELETE = "DELETE from client WHERE client_id=?";

	public ClientDAO() {
	}

	public List<Client> getAllClient() {
		List<Client> clientList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Client client;
			while (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				User userClient=new User(null,null,null);
				userClient.setUserId(userId);
				
				String clientName = resultSet.getString("client_name");
				
				client = new Client(userClient,clientName);
				client.setClientId(resultSet.getInt("client_id"));
				clientList.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientList;
	}
	

	public boolean insertClient(Client client) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, client.getClientName());
			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Client readClient(int clientId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, clientId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String user, clientName;
			
			clientName = resultSet.getString("client_name");
			int userId = resultSet.getInt("user_id");
			User userClient=new User(null,null,null);
			userClient.setUserId(userId);
			
			Client client = new Client(userClient, clientName);

			client.setClientId(resultSet.getInt("client_id"));

			return client;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateClient(Client client) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (client.getClientId() == 0)
			return false;

		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, client.getClientName());
			preparedStatement.setInt(3, client.getClientId());
			int a = preparedStatement.executeUpdate();
			if (a > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}

	
	}

	public boolean deleteClient(Integer id) {
			Connection connection = ConnectionSingleton.getInstance();
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
				preparedStatement.setInt(1, id);
				int n = preparedStatement.executeUpdate();
				if (n != 0)
					return true;
			} catch (SQLException e) {
			}
			return false;
		

	}
	}