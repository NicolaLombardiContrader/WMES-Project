package it.contrader.wmesspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

	private int clientId;

	private String clientName;

	private UserDTO userDTO;

	private List<OrderDTO> ordersDTO;

	

}