package wmes.service;


import java.util.ArrayList;
import java.util.List;

import wmes.converter.UserConverter;
import wmes.dao.UserDAO;
import wmes.dto.UserDTO;
//import wmes.model.Nodes;
import wmes.model.User;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class UserServiceDTO {

	private final UserDAO userDAO;

	public UserServiceDTO() {
		this.userDAO = new UserDAO();
	}

	/**
	 * Come vediamo la lista recuperata � di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perch� � sporco e poco efficiente
	 */
	public List<UserDTO> getAllUsers() {

		List<User> list = userDAO.getAllUser();
		List<UserDTO> listDTO = new ArrayList<>();

		for (User user : list) {
			listDTO.add(UserConverter.toDTO(user));
		}

		return listDTO;
	}
	
	public UserDTO getUserByUsernameAndPasword(String username, String password) {
		return UserConverter.toDTO(userDAO.login(username, password));
	}

	public boolean updateUser(UserDTO userDTO) {
		return this.userDAO.updateUser(UserConverter.toEntity(userDTO));
		
}
	
	public boolean deleteUsers (UserDTO userDTO) {
		return this.userDAO.deleteUser(UserConverter.toEntity(userDTO));
		
}
	
	public boolean insertUsers (UserDTO usersDTO) {
		return this.userDAO.insertUser(UserConverter.toEntity(usersDTO));
	
}
		
	
	
}
