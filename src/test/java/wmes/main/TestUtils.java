package wmes.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestUtils {

	public static int getLastInsertedID(String table) {

		try {
			String LASTID = "SELECT LAST_INSERT_ID() as last_id FROM " + table;
			Connection connection = ConnectionSingleton.getInstance();
			PreparedStatement statement = connection.prepareStatement(LASTID);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			return resultSet.getInt("last_id");
		} catch (SQLException e) {
			return -1;
		}

	}
}
