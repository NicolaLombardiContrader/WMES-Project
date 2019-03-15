package it.contrader.wmesspring.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.wmesspring.model.Resource;
import it.contrader.wmesspring.model.Task;
import it.contrader.wmesspring.model.TaskTemplate;
import it.contrader.wmesspring.model.User;
import java.util.List;

public interface TaskTemplateRepository extends CrudRepository<TaskTemplate, Integer> {

	//public Task findUserByUserUserAndUserPass(String username,String password);
	
	public List<TaskTemplate> findAllByUser(User user);
	
	public List<TaskTemplate> findAllByResource(Resource resource);
	
}