package it.contrader.wmesspring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.wmesspring.model.Order;
import it.contrader.wmesspring.model.User;

public interface OrderRepository extends CrudRepository<Order, Integer > {
	
	public List<Order> findAllByUser(User user);

}
