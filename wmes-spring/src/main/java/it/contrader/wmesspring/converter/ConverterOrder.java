package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.OrderDTO;
import it.contrader.wmesspring.model.Client;
import it.contrader.wmesspring.model.Order;

public class ConverterOrder {

	public static OrderDTO toDTO(Order order) {

		OrderDTO orderDTO = null;
		
		if (order != null) {
			orderDTO = new OrderDTO();
			orderDTO.setUserDTO(ConverterUser.toDTO(order.getUser()));
			orderDTO.setClientDTO(ConverterClient.toDTO(order.getClient()));
			orderDTO.setOrderDescription(order.getOrderDescription());
			orderDTO.setOrderId(order.getOrderId());	
		}
	
	return orderDTO;
	
	}
	
	public static Order toEntity(OrderDTO orderDTO) {
		
		Order order = null;
		
		if (orderDTO != null) {
			order = new Order();
			order.setUser(ConverterUser.toEntity(orderDTO.getUserDTO()));
			order.setClient(ConverterClient.toEntity(orderDTO.getClientDTO()));
			order.setOrderDescription(orderDTO.getOrderDescription());
			order.setOrderId(orderDTO.getOrderId());
		}
		return order;	
		}
	
	public static List<OrderDTO> toListDTO(List<Order> list) {
		List<OrderDTO> listOrderDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Order order : list) {
				listOrderDTO.add(ConverterOrder.toDTO(order));
			}
		}
		return listOrderDTO;
	}

	public static List<Order> toListEntity(List<OrderDTO> listOrderDTO) {
		List<Order> list = new ArrayList<>();
		if (!listOrderDTO.isEmpty()) {
			for (OrderDTO orderDTO : listOrderDTO) {
				list.add(ConverterOrder.toEntity(orderDTO));
			}
		}
		return list;
	}
}
	
