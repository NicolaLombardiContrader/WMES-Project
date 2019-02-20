package wmes.service;

import java.util.ArrayList;
import java.util.List;

import wmes.converter.ClientConverter;
import wmes.converter.UserConverter;
import wmes.dao.ClientDAO;
import wmes.dto.ClientDTO;
import wmes.dto.UserDTO;
import wmes.model.Client;



public class ClientServiceDTO {


/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */

	private final ClientDAO clientDAO;

	public ClientServiceDTO() {
		this.clientDAO = new ClientDAO();
	}

	/**
	 * Come vediamo la lista recuperata � di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perch� � sporco e poco efficiente
	 */
	public List<ClientDTO> getAllClient() {

		List<Client> list = clientDAO.getAllClient();
		List<ClientDTO> listDTO = new ArrayList<>();

		for (Client client : list) {
			listDTO.add(ClientConverter.toDTO(client));
		}

		return listDTO;
	}
	

	
	public ClientDTO readClient(ClientDTO clientDTO) {
		return ClientConverter.toDTO(this.clientDAO.readClient(ClientConverter.toEntity(clientDTO)));
	}

	public boolean updateClient(ClientDTO clientDTO) {
		return this.clientDAO.updateClient(ClientConverter.toEntity(clientDTO));
		
}
	
	public boolean deleteClient (ClientDTO clientDTO) {
		return this.clientDAO.deleteClient(ClientConverter.toEntity(clientDTO));
		
}
	
	public boolean insertClient (ClientDTO clientDTO) {
		return this.clientDAO.insertClient(ClientConverter.toEntity(clientDTO));
	
}
		
	
	
}


