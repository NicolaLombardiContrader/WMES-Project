package wmes.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import wmes.main.TestUtils;
import wmes.model.User;
import wmes.dao.UserDAO;

public class UserDAOTest {
	private User userTest;
	private UserDAO userDAO;
	private int userIdTest;

	@Before
	public void setUp() throws Exception {
		userTest = new User("AdminTest", "PasswordTest", "admin");
		userDAO = new UserDAO();
		userDAO.insertUser(userTest);
		userIdTest = TestUtils.getLastInsertedID("user");
		userTest.setUserId(userIdTest);
	}

	@After
	public void tearDown() throws Exception {
		userDAO.deleteUser(userTest);
	}


	@Test
	public void testInsertUser() {
		User userInsertTest = new User("insertTest", "insertTest", "admin");

		// userService.insertUser(userInsertTest);
		boolean userInsertedCheck = userDAO.insertUser(userInsertTest);

		int userInsertTestId = TestUtils.getLastInsertedID("user");
		boolean userDeletedBool = userDAO.deleteUser(userInsertTest);

		Assert.assertTrue(userInsertedCheck);
	}

	@Test
	public void testReadUser() {
		User DBuser=userDAO.readUser(userTest);
		Assert.assertTrue(DBuser.equals(userTest));
	}

	@Test
	public void testUpdateUser() {
		userTest.setUser("Usernamemodificata");
		userDAO.updateUser(userTest);
		User DBUser = userDAO.readUser(userTest);
		Assert.assertTrue(DBUser.getUsername().equals("Usernamemodificata"));
	}

	@Test
	public void testDeleteUser() {
		Assert.assertTrue(userDAO.deleteUser(userTest));
	}

}
