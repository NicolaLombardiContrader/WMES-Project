package wmes.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import wmes.main.TestUtils;
import wmes.model.Client;
import wmes.model.Task;
import wmes.model.User;

public class TaskDAOTest {

	private Task taskTest;
	private TaskDAO taskDAO;
	private UserDAO userDAO;
	private User userTest;

	@Before
	public void setUp() throws Exception {

		userDAO = new UserDAO();
		taskDAO = new TaskDAO();

		userTest = new User("userTest", "passTest", "bo");
		userDAO.insertUser(userTest);
		userTest.setUserId(TestUtils.getLastInsertedID("user"));

		taskTest = new Task(userTest, "TaskDescriptionTest", "TaskActionTest", "TaskInputTest", "TaskOutputTest",
				"TaskResourceTest", 15, 1);
		taskDAO.insertTask(taskTest);
		
		taskTest.setTaskId(TestUtils.getLastInsertedID("task"));

	}

	@After
	public void tearDown() throws Exception {
		taskDAO.deleteTask(taskTest);
		userDAO.deleteUser(userTest);
	}

	@Test
	public void testInsertTask() {

		// Costruzione oggetti
		//insermento User
		User userInsert = new User("testuser", "pass", "usertypt");
		userDAO.insertUser(userInsert);
		userInsert.setUserId(TestUtils.getLastInsertedID("user"));
		

		Task taskInsert = new Task(userInsert, "TaskDescriptionTest", "TaskActionTest", "TaskInputTest",
				"TaskOutputTest", "TaskResourceTest", 15, 1);
		// Inserimento Order
		
		boolean taskDaoInsertedCheck = taskDAO.insertTask(taskInsert);
		taskInsert.setTaskId(TestUtils.getLastInsertedID("task"));
		// Cancellazione

		taskDAO.deleteTask(taskInsert);
		userDAO.deleteUser(userInsert);

		Assert.assertTrue(taskDaoInsertedCheck);
	}

	@Test
	public void testReadClient() {
		Task DBtask = taskDAO.readTask(taskTest);
		Assert.assertTrue(DBtask.equals(taskTest));
	}
	


	@Test
	public void testUpdateUser() {
		taskTest.setTaskDescription("taskDescriptionMod");
		taskTest.setTaskAction("taskActionMod");
		taskTest.setTaskInput("taskInputMod");
		taskTest.setTaskOutput("taskOutputMod");
		taskTest.setTaskResource("taskResourceMod");
		taskTest.setTaskTime(10);
		taskTest.setTaskState(2);
		taskDAO.updateTask(taskTest);
		Task DBTask = taskDAO.readTask(taskTest);
		Assert.assertTrue(DBTask.getTaskDescription().equals("taskDescriptionMod"));
		Assert.assertTrue(DBTask.getTaskAction().equals("taskActionMod"));
		Assert.assertTrue(DBTask.getTaskInput().equals("taskInputMod"));
		Assert.assertTrue(DBTask.getTaskOutput().equals("taskOutputMod"));
		Assert.assertTrue(DBTask.getTaskResource().equals("taskResourceMod"));
		Assert.assertTrue(DBTask.getTaskTime() == 10);
		Assert.assertTrue(DBTask.getTaskState() == 2);

	}

	@Test
	public void testDeleteClient() {
		Assert.assertTrue(taskDAO.deleteTask(taskTest));
		Assert.assertTrue(userDAO.deleteUser(userTest));
	}

}
