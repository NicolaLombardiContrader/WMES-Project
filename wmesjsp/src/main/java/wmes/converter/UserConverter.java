package wmes.converter;

import wmes.dto.UserDTO;
import wmes.model.User;

/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class UserConverter {

	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static User toEntity(UserDTO userDTO) {

		User user = null;
		if (userDTO != null) {
			user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getUsertype());

			if (userDTO.getId() != null)
				user.setUserId(userDTO.getId());
		}

		
		return user;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */

	public static UserDTO toDTO(User user) {

		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO(user.getUsername(), user.getPassword(), user.getUsertype());
			userDTO.setId(user.getUserId());
			// userDTO.setId(user.getUserId());
		}

		return userDTO;
	}

}