package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.OrderDTO;
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.model.Client;
import it.contrader.wmesspring.model.Order;
import it.contrader.wmesspring.model.Task;



public class ConverterClient {
	 
	public static ClientDTO toDTO(Client client) {

			ClientDTO clientDTO = null;
			
			if (client != null) {
				clientDTO = new ClientDTO();
				clientDTO.setUserDTO(ConverterUser.toDTO(client.getUser()));
				
				clientDTO.setClientName(client.getClientName());

				clientDTO.setClientId(client.getClientId());	
				
				List<Order> orderList= client.getOrders();
				List<OrderDTO> orderListDTO= new ArrayList<OrderDTO>();
				
				for (Order order: orderList) {
					orderListDTO.add(ConverterOrder.toDTO(order));
				}
				
				clientDTO.setOrdersDTO(orderListDTO);
				
				
			}
		
		return clientDTO;
	}
	 
	public static Client toEntity(ClientDTO clientDTO) {
		
		Client client = null;
		
		if (clientDTO != null) {
			client = new Client();
			client.setUser(ConverterUser.toEntity(clientDTO.getUserDTO()));

			client.setClientId(clientDTO.getClientId());
			client.setClientName(clientDTO.getClientName());
			
			
			List<OrderDTO> orderListDTO= clientDTO.getOrdersDTO();
			List<Order> orderList= new ArrayList<Order>();
			
			for (OrderDTO orderDTO: orderListDTO) {
				orderList.add(ConverterOrder.toEntity(orderDTO));
			}
		
			client.setOrders(orderList); 
			
		}
		return client;	
		}
	
	public static List<ClientDTO> toListDTO(List<Client> list) {
		List<ClientDTO> listClientDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Client client : list) {
				listClientDTO.add(ConverterClient.toDTO(client));
			}
		}
		return listClientDTO;
	}

	public static List<Client> toListEntity(List<ClientDTO> listClientDTO) {
		List<Client> list = new ArrayList<>();
		if (!listClientDTO.isEmpty()) {
			for (ClientDTO clientDTO : listClientDTO) {
				list.add(ConverterClient.toEntity(clientDTO));
			}
		}
		return list;
	}
	}
	
	
