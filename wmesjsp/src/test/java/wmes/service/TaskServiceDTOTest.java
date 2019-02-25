package wmes.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import wmes.main.TestUtils;
import wmes.dto.ClientDTO;
import wmes.dto.TaskDTO;
import wmes.dto.UserDTO;

public class TaskServiceDTOTest {

	private TaskDTO taskTest;
	private TaskServiceDTO taskServiceDTO;
	private UserServiceDTO userServiceDTO;
	private UserDTO userTest;

	@Before
	public void setUp() throws Exception {

		userServiceDTO = new UserServiceDTO();
		taskServiceDTO = new TaskServiceDTO();

		userTest = new UserDTO("userTest", "passTest", "bo");
		userServiceDTO.insertUsers(userTest);
		userTest.setId(TestUtils.getLastInsertedID("user"));

		taskTest = new TaskDTO(userTest, "TaskDescriptionTest", "TaskActionTest", "TaskInputTest", "TaskOutputTest",
				"TaskResourceTest", 15, 1);
		taskServiceDTO.insertTask(taskTest);
		
		taskTest.setId(TestUtils.getLastInsertedID("task"));

	}

	@After
	public void tearDown() throws Exception {
		taskServiceDTO.deleteTask(taskTest);
		userServiceDTO.deleteUsers(userTest);
	}

	@Test
	public void testInsertTask() {

		// Costruzione oggetti
		//insermento UserDTO
		UserDTO userInsert = new UserDTO("testuser", "pass", "usertypt");
		userServiceDTO.insertUsers(userInsert);
		userInsert.setId(TestUtils.getLastInsertedID("user"));
		

		TaskDTO taskInsert = new TaskDTO(userInsert, "TaskDescriptionTest", "TaskActionTest", "TaskInputTest",
				"TaskOutputTest", "TaskResourceTest", 15, 1);
		// Inserimento Order
		
		boolean taskDaoInsertedCheck = taskServiceDTO.insertTask(taskInsert);
		taskInsert.setId(TestUtils.getLastInsertedID("task"));
		// Cancellazione

		taskServiceDTO.deleteTask(taskInsert);
		userServiceDTO.deleteUsers(userInsert);

		Assert.assertTrue(taskDaoInsertedCheck);
	}

	@Test
	public void testReadClient() {
		TaskDTO DBtask = taskServiceDTO.readTask(taskTest);
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
		taskServiceDTO.updateTask(taskTest);
		TaskDTO DBTask = taskServiceDTO.readTask(taskTest);
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
		Assert.assertTrue(taskServiceDTO.deleteTask(taskTest));
		Assert.assertTrue(userServiceDTO.deleteUsers(userTest));
	}

}
