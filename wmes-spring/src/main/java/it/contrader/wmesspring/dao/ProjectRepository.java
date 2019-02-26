package it.contrader.wmesspring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.wmesspring.model.Project;
import it.contrader.wmesspring.model.User;

public interface ProjectRepository extends CrudRepository<Project,  Integer> {

	public List<Project> findAllByUser(User user);

}
