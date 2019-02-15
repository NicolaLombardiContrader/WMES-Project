package wmes.service;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import wmes.main.TestUtils;
import wmes.model.User;
import wmes.service.UserService;

public class UserServiceTest {

	private User userTest;
	private UserService userService;
	private int userIdTest;
	
	@Before
	public void setUp() throws Exception {
		userTest = new User("AdminTest", "PasswordTest", "admin");
		userService = new UserService();
		userService.insertUser(userTest);
		userIdTest = TestUtils.getLastInsertedID("user");
		userTest.setUserId(userIdTest);
	}

	@After
	public void tearDown() throws Exception {
		userService.deleteUser(userIdTest);
	}

	@Test
	public void testInsertUser() {
		User userInsertTest = new User("insertTest","insertTest","admin");
		
		//userService.insertUser(userInsertTest);
		boolean userInsertedCheck = userService.insertUser(userInsertTest);
		
		int userInsertTestId = TestUtils.getLastInsertedID("user");
		userService.deleteUser(userInsertTestId);
		
		Assert.assertTrue(userInsertedCheck);
	}

	@Test
	public void testReadtUser() {
		User DBuser=userService.readUser(userIdTest);
		Assert.assertTrue(DBuser.equals(userTest));
	}

	@Test
	public void testUpdateUser() {
		userTest.setUser("Usernamemodificata");
		userService.updateUser(userTest);
		User DBUser = userService.readUser(userIdTest);
		Assert.assertTrue(DBUser.getUsername().equals("Usernamemodificata"));
	}

	@Test
	public void testDeleteUser() {
		userService.deleteUser(userIdTest);
	}

}
