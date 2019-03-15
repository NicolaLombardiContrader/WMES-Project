package it.contrader.wmesspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import it.contrader.wmesspring.model.Resource;
import it.contrader.wmesspring.model.Task;
import it.contrader.wmesspring.model.User;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	//public Task findUserByUserUserAndUserPass(String username,String password);
	
	public List<Task> findAllByUser(User user);
	
	public List<Task> findAllByResource(Resource resource);
	
}