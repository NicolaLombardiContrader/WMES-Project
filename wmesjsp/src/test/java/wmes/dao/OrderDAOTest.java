

package wmes.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import wmes.main.TestUtils;
import wmes.model.Client;
import wmes.model.User;
import wmes.model.Order;

public class OrderDAOTest {

	private User userTest;
	private Client clientTest;
	private Order orderTest;

	private UserDAO userDAO;
	private ClientDAO clientDAO;
	private OrderDAO orderDAO;

	@Before
	public void setUp() throws Exception {

		userDAO = new UserDAO();
		clientDAO = new ClientDAO();
		orderDAO = new OrderDAO();

		// User
		userTest = new User("userTest", "passTest", "bo");
		userDAO.insertUser(userTest);
		userTest.setUserId(TestUtils.getLastInsertedID("user"));

		// Client
		clientTest = new Client(userTest, "ClientNameTest");
		clientDAO.insertClient(clientTest);
		clientTest.setClientId(TestUtils.getLastInsertedID("client"));

		// Order
		orderTest = new Order(userTest, clientTest, "ClientNameTest");
		orderDAO.insertOrder(orderTest);
		orderTest.setOrderId(TestUtils.getLastInsertedID("orders"));
	}

	@After
	public void tearDown() throws Exception {

		orderDAO.deleteOrder(orderTest);
		clientDAO.deleteClient(clientTest);
		userDAO.deleteUser(userTest);

	}

	@Test
	public void testInsertOrder() {

		// Costruzione oggetti
		User userInsert = new User("testuser", "pass", "usertypt");
		userDAO.insertUser(userInsert);
		userInsert.setUserId(TestUtils.getLastInsertedID("user"));
		Client clientInsert = new Client(userInsert, "ClientNameTest");
		clientDAO.insertClient(clientInsert);
		clientInsert.setClientId(TestUtils.getLastInsertedID("client"));

		Order orderInsert = new Order(userInsert, clientInsert, "Test Insert");
		// Inserimento ordine
		boolean orderDAOInsertCheck = orderDAO.insertOrder(orderInsert);
		orderInsert.setOrderId(TestUtils.getLastInsertedID("order"));

		// Cancellazione
		orderDAO.deleteOrder(orderInsert);
		clientDAO.deleteClient(clientInsert);
		userDAO.deleteUser(userInsert);

		Assert.assertTrue(orderDAOInsertCheck);
	}

	@Test
	public void testReadtClient() {
		Order orderDB = orderDAO.readOrder(orderTest);
		Assert.assertTrue(orderDB.equals(orderTest));
	}

	@Test
	public void testUpdateUser() {
		orderTest.setDescription("DescriptionMod");;
		orderDAO.updateOrder(orderTest);
		Order DBOrder = orderDAO.readOrder(orderTest);
		Assert.assertTrue(DBOrder.getDescription().equals("DescriptionMod"));
	}

	@Test
	public void testDeleteClient() {
		Assert.assertTrue(orderDAO.deleteOrder(orderTest));
		Assert.assertTrue(clientDAO.deleteClient(clientTest));
		Assert.assertTrue(userDAO.deleteUser(userTest));
	}

}
