package wmes.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import wmes.main.TestUtils;
import wmes.dto.ClientDTO;
import wmes.dto.UserDTO;
import wmes.dto.OrderDTO;

public class OrderServiceDTOTest {

	private UserDTO userTest;
	private ClientDTO clientTest;
	private OrderDTO orderTest;

	private UserServiceDTO userDAO;
	private ClientServiceDTO clientDAO;
	private OrderServiceDTO orderDAO;

	@Before
	public void setUp() throws Exception {

		userDAO = new UserServiceDTO();
		clientDAO = new ClientServiceDTO();
		orderDAO = new OrderServiceDTO();

		// UserDTO
		userTest = new UserDTO("userTest", "passTest", "bo");
		userDAO.insertUsers(userTest);
		userTest.setId(TestUtils.getLastInsertedID("user"));

		// ClientDTO
		clientTest = new ClientDTO(userTest, "ClientNameTest");
		clientDAO.insertClient(clientTest);
		clientTest.setId(TestUtils.getLastInsertedID("client"));

		// OrderDTO
		orderTest = new OrderDTO(userTest, clientTest, "ClientNameTest");
		orderDAO.insertOrder(orderTest);
		orderTest.setId(TestUtils.getLastInsertedID("orders"));
	}

	@After
	public void tearDown() throws Exception {

		orderDAO.deleteOrder(orderTest);
		clientDAO.deleteClient(clientTest);
		userDAO.deleteUsers(userTest);

	}

	@Test
	public void testInsertClient() {

		// Costruzione oggetti
		UserDTO userInsert = new UserDTO("testuser", "pass", "usertypt");
		userDAO.insertUsers(userInsert);
		userInsert.setId(TestUtils.getLastInsertedID("user"));
		ClientDTO clientInsert = new ClientDTO(userInsert, "ClientNameTest");
		clientDAO.insertClient(clientInsert);
		clientInsert.setId(TestUtils.getLastInsertedID("client"));

		OrderDTO orderInsert = new OrderDTO(userInsert, clientInsert, "Test Insert");
		// Inserimento ordine
		boolean orderDAOInsertCheck = orderDAO.insertOrder(orderInsert);
		orderInsert.setId(TestUtils.getLastInsertedID("orders"));

		// Cancellazione
		orderDAO.deleteOrder(orderInsert);
		clientDAO.deleteClient(clientInsert);
		userDAO.deleteUsers(userInsert);

		Assert.assertTrue(orderDAOInsertCheck);
	}

	@Test
	public void testReadtClient() {
		OrderDTO DBOrder = orderDAO.readOrder(orderTest);
		Assert.assertTrue(DBOrder.equals(orderTest));
	}

	@Test
	public void testUpdateUser() {
		orderTest.setDescription("DescriptionMod");;
		orderDAO.updateOrder(orderTest);
		OrderDTO DBOrder = orderDAO.readOrder(orderTest);
		Assert.assertTrue(DBOrder.getDescription().equals("DescriptionMod"));
	}

	@Test
	public void testDeleteClient() {
		Assert.assertTrue(orderDAO.deleteOrder(orderTest));
		Assert.assertTrue(clientDAO.deleteClient(clientTest));
		Assert.assertTrue(userDAO.deleteUsers(userTest));
	}

}
