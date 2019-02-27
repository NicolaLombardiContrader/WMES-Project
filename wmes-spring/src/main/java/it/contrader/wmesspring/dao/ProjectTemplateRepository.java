package it.contrader.wmesspring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import it.contrader.wmesspring.model.ProjectTemplate;
import it.contrader.wmesspring.model.User;

public interface ProjectTemplateRepository extends CrudRepository<ProjectTemplate, Integer> {
	
	public List<ProjectTemplate> findAllByUser(User user);

}
