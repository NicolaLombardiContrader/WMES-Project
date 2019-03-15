package it.contrader.wmesspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.wmesspring.dto.ItemDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ItemService;

@CrossOrigin
@RestController
@RequestMapping("/Item")
public class ItemController {
	
	private ItemService itemService;
	
	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@RequestMapping(value = "/listItem", method = RequestMethod.GET)
	public List<ItemDTO> listItem(@RequestParam(value = "userId") int userId) {
		UserDTO userDTOResourceList = new UserDTO();
		userDTOResourceList.setUserId(userId);
		return this.itemService.getListaItemDTOByUser(userDTOResourceList);
	}
	
	@RequestMapping(value = "listItemByItemType", method = RequestMethod.GET)
	public List<ItemDTO> listItemByItemType(@RequestParam(value = "userId") int userId,
			@RequestParam(value = "itemType") String itemType) {
		UserDTO userDTOResourceList = new UserDTO();
		userDTOResourceList.setUserId(userId);
		
		return this.itemService.getItemDTOByUserAndItemType(userDTOResourceList, itemType);
	}
}
