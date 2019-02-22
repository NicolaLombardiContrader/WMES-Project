package wmes.service;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import wmes.main.TestUtils;

import wmes.dto.TaskDTO;
import wmes.dto.UserDTO;

public class TaskServiceDTOTest {

	private TaskDTO taskTest;
	private TaskServiceDTO taskDTO;
	private int taskIdTest;
	private UserServiceDTO userDTO;
	private UserDTO userTask;

	@Before
	public void setUp() throws Exception {

		userDTO = new UserServiceDTO();
		taskDTO = new TaskServiceDTO();

		userTask = new UserDTO("userTest", "passTest", "bo");
		userDTO.insertUsers(userTask);
		userTask.setId(TestUtils.getLastInsertedID("user"));

		taskTest = new TaskDTO(userTask, "TaskDescriptionTest", "TaskActionTest", "TaskInputTest", "TaskOutputTest",
				"TaskResourceTest", 15, 1);
		taskDTO.insertTask(taskTest);
		taskIdTest = TestUtils.getLastInsertedID("client");
		taskTest.setId(taskIdTest);
	}

	@After
	public void tearDown() throws Exception {
		taskDTO.deleteTask(taskTest);
		userDTO.deleteUsers(userTask);
	}

	@Test
	public void testInsertTask() {

		// Costruzione oggetti
		//insermento UserDTO
		UserDTO userInsert = new UserDTO("testuser", "pass", "usertypt");
		userDTO.insertUsers(userInsert);
		userInsert.setId(TestUtils.getLastInsertedID("user"));
		

		TaskDTO taskInsert = new TaskDTO(userInsert, "TaskDescriptionTest", "TaskActionTest", "TaskInputTest",
				"TaskOutputTest", "TaskResourceTest", 15, 1);
		// Inserimento Order
		
		boolean taskInsertedCheck = taskDTO.insertTask(taskInsert);
		taskInsert.setId(TestUtils.getLastInsertedID("task"));
		
		
		// Cancellazione
		taskDTO.deleteTask(taskInsert);
		userDTO.deleteUsers(userInsert);

		Assert.assertTrue(taskInsertedCheck);
	}

	@Test
	public void testReadtClient() {
		TaskDTO taskDB = taskDTO.readTask(taskTest);
		Assert.assertTrue(taskDB.equals(taskTest));
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
		taskDTO.updateTask(taskTest);
		TaskDTO DBTask = taskDTO.readTask(taskTest);
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
		Assert.assertTrue(taskDTO.deleteTask(taskTest));
		Assert.assertTrue(userDTO.deleteUsers(userTask));
	}

}


