package wmes.dao;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import wmes.main.TestUtils;
import wmes.model.Client;
import wmes.model.User;

public class ClientDAOTest {

	private Client clientTest;
	private ClientDAO clientDAO;
	private int clientIdTest;
	private UserDAO userDAO;
	private User userClient;
	
	@Before
	public void setUp() throws Exception {
	
	userDAO = new UserDAO();
	clientDAO= new ClientDAO();
	
	userClient = new User("userTest","passTest","bo");
	userDAO.insertUser(userClient);
	userClient.setUserId(TestUtils.getLastInsertedID("user"));

	clientTest = new Client(userClient,"ClientNameTest");
	clientDAO.insertClient(clientTest);
	clientIdTest = TestUtils.getLastInsertedID("client");
	clientTest.setClientId(clientIdTest);
	}

	@After
	public void tearDown() throws Exception {
		clientDAO.deleteClient(clientTest);
		userDAO.deleteUser(userClient);
	}

	@Test
	public void testInsertClient() {
		
		//Costruzione oggetti
		User userInsert = new User("testuser","pass","usertypt");
		userDAO.insertUser(userInsert);
		userInsert.setUserId(TestUtils.getLastInsertedID("user"));
		Client clientInsert = new Client(userInsert,"ClientNameTest");
		//Inserimento cliente
		boolean clientInsertedCheck = clientDAO.insertClient(clientInsert);
		int clientInsertIdTest = TestUtils.getLastInsertedID("client");
		clientInsert.setClientId(clientInsertIdTest);
		//Cancellazione
		clientDAO.deleteClient(clientInsert);
		userDAO.deleteUser(userInsert);
		
		Assert.assertTrue(clientInsertedCheck);
	}

	
	@Test
	public void testReadtClient() {
		Client clientDB= clientDAO.readClient(clientTest);
		Assert.assertTrue(clientDB.equals(clientTest));
	}
	
	@Test
	public void testUpdateUser() {
		clientTest.setClientName("ClientNameMod");
		clientDAO.updateClient(clientTest);
		Client DBClient = clientDAO.readClient(clientTest);
		Assert.assertTrue(DBClient.getClientName().equals("ClientNameMod"));
	}
	
	@Test
	public void testDeleteClient() {
		Assert.assertTrue(clientDAO.deleteClient(clientTest));
		Assert.assertTrue(userDAO.deleteUser(userClient));
	}
	
	
	
}







