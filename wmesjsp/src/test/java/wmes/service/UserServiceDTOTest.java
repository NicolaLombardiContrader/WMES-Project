package wmes.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import wmes.main.TestUtils;
import wmes.dto.UserDTO;
import wmes.service.UserServiceDTO;

public class UserServiceDTOTest {
	private UserDTO userTest;
	private UserServiceDTO userService;
	private int userIdTest;

	@Before
	public void setUp() throws Exception {
		userTest = new UserDTO("AdminTest", "PasswordTest", "admin");
		userService = new UserServiceDTO();
		userService.insertUsers(userTest);
		userIdTest = TestUtils.getLastInsertedID("user");
		userTest.setId(userIdTest);
	}

	@After
	public void tearDown() throws Exception {
		userService.deleteUsers(userTest);
	}


	@Test
	public void testInsertUsers() {
		UserDTO userInsertTest = new UserDTO("insertTest", "insertTest", "admin");

		// userService.insertUser(userInsertTest);
		boolean userInsertedCheck = userService.insertUsers(userInsertTest);

		int userInsertTestId = TestUtils.getLastInsertedID("user");
		boolean userDeletedBool = userService.deleteUsers(userInsertTest);

		Assert.assertTrue(userInsertedCheck);
	}

	@Test
	public void testReadUser() {
		UserDTO DBuser=userService.readUser(userTest);
		Assert.assertTrue(DBuser.equals(userTest));
	}

	@Test
	public void testUpdateUser() {
		userTest.setUsername("Usernamemodificata");
		userService.updateUser(userTest);
		UserDTO DBUser = userService.readUser(userTest);
		Assert.assertTrue(DBUser.getUsername().equals("Usernamemodificata"));
	}

	@Test
	public void testDeleteUser() {
		Assert.assertTrue(userService.deleteUsers(userTest));
	}

}
