package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.model.Resource;

public class ConverterResource {
	
	
	public static UserDTO toDTO(User resource) {
		UserDTO resourceDTO = null;
		if (resource != null) {
			resourceDTO = new UserDTO();
			resourceDTO.setIdUser(resource.getUserId());
			resourceDTO.setUsername(resource.getUserUser());
			resourceDTO.setPassword(resource.getUserPass());
			//userDTO.setEmail(user.getEmail());
			resourceDTO.setUsertype(resource.getUserType());
		}
		return resourceDTO;
	}

	public static User toEntity(UserDTO resourceDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User();
			user.setUserId(userDTO.getIdUser());
			user.setUserUser(userDTO.getUsername());
			user.setUserPass(userDTO.getPassword());
			//user.setEmail(userDTO.getEmail());
			user.setUserType(userDTO.getUsertype());
		}
		return user;
	}

	public static List<UserDTO> toListDTO(List<User> list) {
		List<UserDTO> listUserDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (User user : list) {
				listUserDTO.add(ConverterUser.toDTO(user));
			}
		}
		return listUserDTO;
	}

	public static List<User> toListEntity(List<UserDTO> listUserDTO) {
		List<User> list = new ArrayList<>();
		if (!listUserDTO.isEmpty()) {
			for (UserDTO userDTO : listUserDTO) {
				list.add(ConverterUser.toEntity(userDTO));
			}
		}
		return list;
	}

}
