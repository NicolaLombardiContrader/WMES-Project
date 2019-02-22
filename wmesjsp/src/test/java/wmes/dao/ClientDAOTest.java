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
	
	
	@Before
	public void setUp() throws Exception {
	user userClient = new 
	clientTest = new Client(("ds","sd",""),"ClientNameTest");
	clientDAO = new ClientDAO();
	clientDAO.insertClient(clientTest);
	clientIdTest = TestUtils.getLastInsertedID("client");
	clientTest.setClientId(clientIdTest);
	}

	@After
	public void tearDown() throws Exception {
		clientDAO.deleteClient(clientTest);
	}

	@Test
	public void testInsertClient() {
		Client clientInsertTest = new Client(("","",""), "InsertTest");
		
		boolean clientInsertedCheck = clientDAO.insertClient(clientInsertTest);
		
		int  clientInsertTestId = TestUtils.getLastInsertedID("client");
		clientDAO.deleteClient(clientInsertTest);
		
		Assert.assertTrue(clientInsertedCheck);
	}

	
	@Test
	public void testReadtClient() {
		Client DBuser=ClientDAO.readClient(clientTest);
		Assert.assertTrue(DBuser.equals(clientTest));
	}
	
	
	
	
	
	
}







