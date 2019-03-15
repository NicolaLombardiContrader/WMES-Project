package it.contrader.wmesspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.wmesspring.converter.ConverterClient;
import it.contrader.wmesspring.converter.ConverterOrder;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dao.ClientRepository;
import it.contrader.wmesspring.dao.OrderRepository;
import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.OrderDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.model.Client;
import it.contrader.wmesspring.model.Order;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	@Autowired
	public ClientRepository clientRepository;

	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<OrderDTO> getListOrderDTO() {
		return ConverterOrder.toListDTO((List<Order>) orderRepository.findAll());
	}

	public OrderDTO getOrderDTOById(Integer id) {
		return ConverterOrder.toDTO(orderRepository.findById(id).get());
	}

	public boolean insertOrder(OrderDTO orderDTO) {
		return orderRepository.save(ConverterOrder.toEntity(orderDTO)) != null;
	}

	public boolean updateOrder(OrderDTO orderDTO) {
		return orderRepository.save(ConverterOrder.toEntity(orderDTO)) != null;
	}

	public void deleteOrderById(Integer id) {
		orderRepository.deleteById(id);
	}

	public List<OrderDTO> findOrderDTOByUser(UserDTO userDTO) {
		final List<Order> listOrder = orderRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<OrderDTO> listOrderDTO = new ArrayList<>();
		listOrder.forEach(i -> listOrderDTO.add(ConverterOrder.toDTO(i)));
		return listOrderDTO;
	}

	public List<ClientDTO> findClientDTOByUser(UserDTO userDTO) {
		final List<Client> listClient = clientRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<ClientDTO> listClientDTO = new ArrayList<>();
		listClient.forEach(i -> listClientDTO.add(ConverterClient.toDTO(i)));
		return listClientDTO;
	}
}