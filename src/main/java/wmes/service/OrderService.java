package wmes.service;

import wmes.dao.OrderDAO;
import wmes.model.Order;

import java.util.List;

public class OrderService {

	private OrderDAO orderDAO;

	public OrderService() {
		this.orderDAO = new OrderDAO();
	}

	public List<Order> getAllOrder() {
		return this.orderDAO.getAllOrder();
	}

	public boolean insertOrder(Order order) {
		return this.orderDAO.insertOrder(order);
	}
	
	public Order readOrder(int orderId) {
		return this.orderDAO.readOrder(orderId);
	}
	
	public boolean updateOrder(Order order) {
		return this.orderDAO.updateOrder(order);
	}
	
	public boolean deleteOrder(int orderId) {
		return this.orderDAO.deleteOrder(orderId);
	}
	
	
}


