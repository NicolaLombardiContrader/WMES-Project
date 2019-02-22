package wmes.service;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import wmes.main.TestUtils;
import wmes.dto.ClientDTO;
import wmes.dto.UserDTO;


public class ClientServiceDTOTest {

	private ClientDTO clientTest;
	private ClientServiceDTO clientDTO;
	private int clientIdTest;
	private UserServiceDTO userDTO;
	private UserDTO userClient;
	
	@Before
	public void setUp() throws Exception {
	
	userDTO = new UserServiceDTO();
	clientDTO= new ClientServiceDTO();
	
	userClient = new UserDTO("userTest","passTest","bo");
	userDTO.insertUsers(userClient);
	userClient.setId(TestUtils.getLastInsertedID("user"));

	clientTest = new ClientDTO(userClient,"ClientNameTest");
	clientDTO.insertClient(clientTest);
	clientIdTest = TestUtils.getLastInsertedID("client");
	clientTest.setId(clientIdTest);
	}

	@After
	public void tearDown() throws Exception {
		clientDTO.deleteClient(clientTest);
		userDTO.deleteUsers(userClient);
	}

	@Test
	public void testInsertClient() {
		
		//Costruzione oggetti
		UserDTO userInsert = new UserDTO("testuser","pass","usertypt");
		userDTO.insertUsers(userInsert);
		userInsert.setId(TestUtils.getLastInsertedID("user"));
		ClientDTO clientInsert = new ClientDTO(userInsert,"ClientNameTest");
		//Inserimento cliente
		boolean clientInsertedCheck = clientDTO.insertClient(clientInsert);
		int clientInsertIdTest = TestUtils.getLastInsertedID("client");
		clientInsert.setId(clientInsertIdTest);
		//Cancellazione
		clientDTO.deleteClient(clientInsert);
		userDTO.deleteUsers(userInsert);
		
		Assert.assertTrue(clientInsertedCheck);
	}

	
	@Test
	public void testReadtClient() {
		ClientDTO clientDB= clientDTO.readClient(clientTest);
		Assert.assertTrue(clientDB.equals(clientTest));
	}
	
	@Test
	public void testUpdateUser() {
		clientTest.setClientName("ClientNameMod");
		clientDTO.updateClient(clientTest);
		ClientDTO DBClient = clientDTO.readClient(clientTest);
		Assert.assertTrue(DBClient.getClientName().equals("ClientNameMod"));
	}
	
	@Test
	public void testDeleteClient() {
		Assert.assertTrue(clientDTO.deleteClient(clientTest));
		Assert.assertTrue(userDTO.deleteUsers(userClient));
	}
	
	
	
}







