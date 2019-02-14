package wmes.service;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import wmes.model.User;
import wmes.service.UserService;

public class UserServiceTest {

	private User userTest;
	private UserService userService;
	private int USERIDTEST = 100000;

	@Before
	public void setUp() throws Exception {
		userTest = new User("AdminTest", "PasswordTest", "admin");
		userTest.setUserId(USERIDTEST);
		userService = new UserService();

	}

	@After
	public void tearDown() throws Exception {
		userService.deleteUser(USERIDTEST);
	}

	@Test
	public void testInsertUser() {
		userService.insertUser(userTest);
		Assert.assertTrue(userService.insertUser(userTest));
	}

	@Test
	public void testReadtUser() {
		userService.insertUser(userTest);
		User DBuser=userService.readUser(USERIDTEST);
		Assert.assertTrue(DBuser.equals(userTest));
	}

	@Test
	public void testUpdateUser() {
		userService.insertUser(userTest);
		userTest.setUser("Usernamemodificata");
		userService.updateUser(userTest);
		User DBUser = userService.readUser(USERIDTEST);
		Assert.assertTrue(DBUser.getUsername()=="Usernamemodificata");
	}

	@Test
	public void testDeleteUser() {
		userService.deleteUser(USERIDTEST);
	}

}
