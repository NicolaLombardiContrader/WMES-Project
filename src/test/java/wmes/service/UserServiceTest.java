package wmes.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import wmes.model.User;

public class UserServiceTest {

	@Before
	public void setUp() throws Exception {
		User user= new User("userTestAdmin", "userTestPass", "admin");
		UserService userService= new UserService();
		userService.insertUser(user);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	
}
