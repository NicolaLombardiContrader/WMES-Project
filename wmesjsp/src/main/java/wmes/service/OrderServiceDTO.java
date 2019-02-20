package wmes.service;

import java.util.ArrayList;
import java.util.List;

import wmes.converter.OrderConverter;
import wmes.dao.OrderDAO;
import wmes.dto.OrderDTO;
import wmes.model.Order;

public class OrderServiceDTO {
	
	private final OrderDAO orderDAO;

	public OrderServiceDTO() {
		this.orderDAO = new OrderDAO();
	}

	public List<OrderDTO> getAllOrders() {

		List<Order> list = orderDAO.getAllOrder();
		List<OrderDTO> listDTO = new ArrayList<>();

		for (Order order : list) {
			listDTO.add(OrderConverter.toDTO(order));
		}

		return listDTO;
	}
	
	/*
	public OrderDTO getUserByUsernameAndPasword(String username, String password) {
		return UserConverter.toDTO(userDAO.login(username, password));
	}
	*/
	
	public OrderDTO readOrder(OrderDTO orderDTO) {
		return OrderConverter.toDTO(this.orderDAO.readOrder(OrderConverter.toEntity(orderDTO)));
	}
	
	public boolean updateOrder(OrderDTO orderDTO) {
		return this.orderDAO.updateOrder(OrderConverter.toEntity(orderDTO));
		
}
	
	public boolean deleteOrder (OrderDTO orderDTO) {
		return this.orderDAO.deleteOrder(OrderConverter.toEntity(orderDTO));
		
}
	
	public boolean insertOrder (OrderDTO orderDTO) {
		return this.orderDAO.insertOrder(OrderConverter.toEntity(orderDTO));
	
}	
	
}
