package it.contrader.wmesspring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.wmesspring.model.Resource;
import it.contrader.wmesspring.model.TaskModel;
import it.contrader.wmesspring.model.User;

public interface TaskModelRepository extends CrudRepository<TaskModel, Integer> {

	public List<TaskModel> findAllByUser(User user);

	public List<TaskModel> findAllByResource(Resource resource);
}
