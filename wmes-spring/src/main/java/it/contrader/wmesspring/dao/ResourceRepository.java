package it.contrader.wmesspring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import it.contrader.wmesspring.model.Resource;
import it.contrader.wmesspring.model.User;

public interface ResourceRepository extends CrudRepository<Resource, Integer> {
	
	public List<Resource> findAllByUser(User user);
	
	
	

}
