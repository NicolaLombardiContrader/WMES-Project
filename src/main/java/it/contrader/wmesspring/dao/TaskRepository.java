package it.contrader.wmesspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.contrader.wmesspring.model.Project;
import it.contrader.wmesspring.model.Resource;
import it.contrader.wmesspring.model.Task;
import it.contrader.wmesspring.model.User;
import java.util.List;

import javax.transaction.Transactional;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	//public Task findUserByUserUserAndUserPass(String username,String password);
	
	public List<Task> findAllByUser(User user);
	
	public List<Task> findAllByResource(Resource resource);
	
	//Tree methods
	public Task findAllByProjectAndTaskFatherIsNull(Project project);
	
	@Modifying
	@Transactional
	@Query(value= "INSERT INTO Tasks (task_action, task_description, task_state, task_time, project_id, resource_id, father_id, user_id) VALUES (:taskAction, :taskDescription,:taskState, :taskTime, :projectId, :resourceId, :fatherId, :userId)", nativeQuery=true)
	public void insertTask(@Param("taskAction") String taskAction, 
			@Param("taskDescription") String taskDescription,
			@Param("taskState") int taskState,
			@Param("taskTime") int taskTime,
			@Param("projectId") int projectId,
			@Param("resourceId") int resourceId,
			@Param("fatherId") Integer fatherId,
			@Param("userId") int userId);
}