package it.contrader.wmesspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.wmesspring.converter.ConverterClient;
import it.contrader.wmesspring.converter.ConverterItem;
import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dao.ItemRepository;
import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.ItemDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.model.Client;
import it.contrader.wmesspring.model.Item;

@Service
public class ItemService {

	private final ItemRepository itemRepository;

	@Autowired
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public List<ItemDTO> getListaItemDTOByUser(UserDTO userDTO) {
		return ConverterItem.toListDTO((List<Item>) itemRepository.findAllByUser(ConverterUser.toEntity(userDTO)));

	}

	public List<ItemDTO> getItemDTOByUserAndItemType(UserDTO userDTO, String itemType) {
		return ConverterItem
				.toListDTO(itemRepository.findAllByUserAndItemType(ConverterUser.toEntity(userDTO), itemType));
	}

}
