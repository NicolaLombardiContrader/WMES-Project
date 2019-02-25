package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.model.User;

public class ConverterUser {

	public static UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO();
			userDTO.setIdUser(user.getUserId());
			userDTO.setUsername(user.getUserUser());
			userDTO.setPassword(user.getUserPass());
			//userDTO.setEmail(user.getEmail());
			userDTO.setUsertype(user.getUserType());
		}
		return userDTO;
	}

	public static User toEntity(UserDTO userDTO) {
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
