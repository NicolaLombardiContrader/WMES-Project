package wmes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import wmes.main.ConnectionSingleton;
import wmes.main.GestoreEccezioni;
import wmes.model.Client;
import wmes.model.Task;
import wmes.model.User;

public class TaskDAO {
	


	private final String QUERY_ALL = "select * from task";
	private final String QUERY_INSERT = "insert into task (user_id, task_description, task_action, task_input, task_output, task_resource, task_time, task_state) values (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String QUERY_READ = "select * from task where task_id=?";

	private final String QUERY_UPDATE = "UPDATE task SET user_id=?, task_description=?, task_action=?, task_input=?, task_output=?, task_resource=?, task_time=?, task_state=? WHERE task_id=?";
	private final String QUERY_DELETE = "DELETE from task WHERE task_id=?";

	public TaskDAO() {
	}

	public List<Task> getAllTask() {
		List<Task> taskList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Task task;
			while (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				User userTask = new User(null, null, null);
				userTask.setUserId(userId);

				String taskDescription = resultSet.getString("task_description");
				String taskAction = resultSet.getString("task_action");
				String taskInput = resultSet.getString("task_input");
				String taskOutput = resultSet.getString("task_output");
				String taskResource = resultSet.getString("task_resource"); 
				int taskTime = resultSet.getInt("task_time");
				int taskState = resultSet.getInt("task_state");
			 

				task = new Task(userTask, taskDescription, taskAction, taskInput, taskOutput, taskResource, taskTime, taskState);
				task.setTaskId(resultSet.getInt("task_id"));
				taskList.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taskList;
	}

	public boolean insertTask(Task task) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setInt(1, task.getUser().getUserId());
			preparedStatement.setString(2, task.getTaskDescription());
			preparedStatement.setString(3, task.getTaskAction());
			preparedStatement.setString(4, task.getTaskInput());
			preparedStatement.setString(5, task.getTaskOutput());
			preparedStatement.setString(6, task.getTaskResource());
			preparedStatement.setInt(7, task.getTaskTime());
			preparedStatement.setInt(8, task.getTaskState());
			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Task readTask(Task task) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int taskId = task.getTaskId();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, taskId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int taskTime, taskState; 
			String taskDescription, taskAction, taskInput, taskOutput, taskResource;
			
			taskDescription=resultSet.getString("task_description");
			taskAction=resultSet.getString("task_action");
			taskInput=resultSet.getString("task_input");
			taskOutput=resultSet.getString("task_output");
			taskResource=resultSet.getString("task_resource");
			taskTime = resultSet.getInt("task_time");
			taskState = resultSet.getInt("task_state");
			
			
			int userId = resultSet.getInt("user_id");
			User userTask = new User(null, null, null);
			userTask.setUserId(userId);

			task = new Task(userTask, taskDescription, taskAction, taskInput, taskOutput, taskResource, taskTime, taskState);

			task.setTaskId(resultSet.getInt("task_id"));
			
			
			return task;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateTask(Task taskToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (taskToUpdate.getTaskId() == 0)
			return false;

		// Client clientRead = readClient(clientToUpdate);
		// if (!clientRead.equals(clientToUpdate)) {

		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setInt(1, taskToUpdate.getUser().getUserId());
			preparedStatement.setString(2, taskToUpdate.getTaskDescription());
			preparedStatement.setString(3, taskToUpdate.getTaskAction());
			preparedStatement.setString(4, taskToUpdate.getTaskInput());
			preparedStatement.setString(5, taskToUpdate.getTaskOutput());
			preparedStatement.setString(6, taskToUpdate.getTaskResource());
			preparedStatement.setInt(7, taskToUpdate.getTaskTime());
			preparedStatement.setInt(8, taskToUpdate.getTaskState());
			preparedStatement.setInt(9, taskToUpdate.getTaskId());

			int a = preparedStatement.executeUpdate();

			
			if (a > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}

	}

	public boolean deleteTask(Task task) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			int taskId = task.getTaskId();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, taskId);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;

	}

}
