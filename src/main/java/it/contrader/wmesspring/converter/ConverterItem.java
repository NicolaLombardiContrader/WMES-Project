package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.wmesspring.dto.ItemDTO;
import it.contrader.wmesspring.model.Item;
public class ConverterItem {
	
	
	public static ItemDTO toDTO(Item item) {
		ItemDTO itemDTO = null;
		if (item != null) {
			itemDTO = new ItemDTO();
			itemDTO.setItemId(item.getItemId());
			itemDTO.setUserDTO(ConverterUser.toDTO(item.getUser()));
			itemDTO.setItemCode(item.getItemCode());
			itemDTO.setItemName(item.getItemName());
			itemDTO.setItemType(item.getItemType());

		}
		return itemDTO;
	}

	public static Item toEntity(ItemDTO itemDTO) {
		Item item = null;
		if (itemDTO != null) {
			item = new Item();
			item.setItemId(itemDTO.getItemId());
			item.setUser(ConverterUser.toEntity(itemDTO.getUserDTO()));
			item.setItemCode(itemDTO.getItemCode());
			item.setItemName(itemDTO.getItemName());
			item.setItemType(itemDTO.getItemType());
		}
		return item;
	}
	
	public static List<ItemDTO> toListDTO(List<Item> list) {
		List<ItemDTO> listItemDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Item resource : list) {
				listItemDTO.add(ConverterItem.toDTO(resource));
			}
		}
		return listItemDTO;
	}

	public static List<Item> toListEntity(List<ItemDTO> listItemDTO) {
		List<Item> list = new ArrayList<>();
		if (!listItemDTO.isEmpty()) {
			for (ItemDTO resourceDTO : listItemDTO) {
				list.add(ConverterItem.toEntity(resourceDTO));
			}
		}
		return list;
	}

}
