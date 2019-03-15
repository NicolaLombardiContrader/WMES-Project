package it.contrader.wmesspring.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import it.contrader.wmesspring.model.Task;
import it.contrader.wmesspring.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

	
	private int itemId;

	private String itemCode;

	private String itemName;

	private String itemType;

	private UserDTO userDTO;

}
