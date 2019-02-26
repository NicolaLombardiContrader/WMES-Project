package it.contrader.wmesspring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.wmesspring.model.Client;
import it.contrader.wmesspring.model.User;

public interface ClientRepository extends CrudRepository<Client, Integer> {

	public List<Client> findAllByUser(User user);
}
