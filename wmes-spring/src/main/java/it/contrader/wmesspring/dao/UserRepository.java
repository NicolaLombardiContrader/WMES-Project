package it.contrader.wmesspring.dao;

import org.springframework.data.repository.CrudRepository;
import it.contrader.wmesspring.model.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findUserByUserUserAndUserPass(String username,String password);
	
	public List<User> findAllByUserUser(String username);
}
