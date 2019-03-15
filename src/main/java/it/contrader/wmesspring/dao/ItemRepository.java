package it.contrader.wmesspring.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.wmesspring.model.Item;
import it.contrader.wmesspring.model.User;
import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {

	public List<Item> findAllByUser(User user);
	
	public List<Item> findAllByUserAndItemType(User user, String itemType);
	
}