package it.contrader.wmesspring.dao;

import org.springframework.data.repository.CrudRepository;
import it.contrader.wmesspring.model.Task;
import it.contrader.wmesspring.model.User;
import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {

	//public Task findUserByUserUserAndUserPass(String username,String password);
	
	public List<Task> findAllByUser(User user);
}