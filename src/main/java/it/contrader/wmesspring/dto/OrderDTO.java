package it.contrader.wmesspring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO  {
	
	private int orderId;

	private String orderDescription;

	private ClientDTO clientDTO;
	
	private UserDTO userDTO;


}