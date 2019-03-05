package it.contrader.wmesspring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.OrderDTO;
import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.ProjectTemplateDTO;
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.OrderService;
import it.contrader.wmesspring.service.ProjectService;
import it.contrader.wmesspring.service.ProjectTemplateService;
import it.contrader.wmesspring.service.TaskService;

@Controller
@RequestMapping("/ProjectTemplate")
public class ProjectTemplateController {

	private final ProjectTemplateService projectTemplateService;
	
	@Autowired
	private HttpSession session;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private TaskService taskService;

	@Autowired
	public ProjectTemplateController(ProjectTemplateService projectTemplateService) {
		this.projectTemplateService = projectTemplateService;
	}

	private void visualProjectTemplate(HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) session.getAttribute("utente");
		List<ProjectTemplateDTO> allProjectTemplate = this.projectTemplateService.findProjectTemplateDTOByUser(userDTO);
		request.setAttribute("allProjectTemplateDTO", allProjectTemplate);
	}

	@RequestMapping(value = "projectTemplateManagement", method = RequestMethod.GET)
	public String projectTemplateManagement(HttpServletRequest request) {
		visualProjectTemplate(request);
		return "projectTemplate/manageProjectTemplate";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.projectTemplateService.deleteProjectTemplateById(id);
		visualProjectTemplate(request);
		return "projectTemplate/manageProjectTemplate";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request, HttpSession session) {
		UserDTO userDTO = (UserDTO) session.getAttribute("utente");
		List<TaskDTO> taskList = projectTemplateService.findTaskDTOByUser(userDTO);
		request.setAttribute("taskList", taskList);
		return "projectTemplate/insertProjectTemplate";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertProjectTemplate(HttpServletRequest request, HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		String projectTemplateProjectName = request.getParameter("project_name").toString();

		List<TaskDTO> taskList = new ArrayList<TaskDTO>();
		String taskListString[] = (String[]) request.getParameterValues("taskList");

		for (String taskString : taskListString) {
			TaskDTO taskDTO = new TaskDTO();
			taskDTO.setTaskId(Integer.parseInt(taskString));
			taskList.add(taskDTO);
		}

		ProjectTemplateDTO projectTemplateObj = new ProjectTemplateDTO();
		projectTemplateObj.setProjectName(projectTemplateProjectName);
		projectTemplateObj.setUserDTO(userLogged);
		projectTemplateObj.setTasksDTO(taskList);

		projectTemplateService.insertProjectTemplate(projectTemplateObj);
		visualProjectTemplate(request);

		return "projectTemplate/manageProjectTemplate";
	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request, HttpSession session) {
		int id = Integer.parseInt(request.getParameter("id"));
		UserDTO userDTO = (UserDTO) session.getAttribute("utente");

		ProjectTemplateDTO projectTemplateUpdate = this.projectTemplateService.getProjectTemplateDTOById(id);
		List<TaskDTO> taskList = projectTemplateService.findTaskDTOByUser(userDTO);

		request.setAttribute("taskList", taskList);
		request.setAttribute("projectTemplateUpdate", projectTemplateUpdate);

		return "projectTemplate/updateProjectTemplate";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {

		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		Integer idUpdate = Integer.parseInt(request.getParameter("project_id"));
		String projectTemplateProjectName = request.getParameter("project_name");

		List<TaskDTO> taskList = new ArrayList<TaskDTO>();
		String taskListString[] = (String[]) request.getParameterValues("taskList");
		for (String taskString : taskListString) {
			TaskDTO taskDTO = new TaskDTO();
			taskDTO.setTaskId(Integer.parseInt(taskString));
			taskList.add(taskDTO);
		}

		ProjectTemplateDTO projectTemplate = new ProjectTemplateDTO();
		projectTemplate.setUserDTO(userLogged);
		projectTemplate.setProjectId(idUpdate);
		projectTemplate.setProjectName(projectTemplateProjectName);
		projectTemplate.setTasksDTO(taskList);

		projectTemplateService.updateProjectTemplate(projectTemplate);
		visualProjectTemplate(request);
		return "projectTemplate/manageProjectTemplate";
	}

	@RequestMapping(value = "/clone", method = RequestMethod.GET)
	public String clone(HttpServletRequest request, HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		Integer projectTemplateId = Integer.parseInt(request.getParameter("id"));
		ProjectTemplateDTO projectTemplate = projectTemplateService.getProjectTemplateDTOById(projectTemplateId);
		 
		/*
		 * List<TaskDTO> taskList = new ArrayList<TaskDTO>(); List<TaskDTO>
		 * taskListProjectTemplate = projectTemplate.getTasksDTO(); for (TaskDTO
		 * taskDTOTemplate: taskListProjectTemplate) { TaskDTO taskDTOProject = new
		 * TaskDTO(); taskDTOProject.setUserDTO(taskDTOTemplate.getUserDTO());
		 * taskDTOProject.setTaskDescription(taskDTOTemplate.getTaskDescription()+
		 * "_fromTP"); taskDTOProject.setTaskAction(taskDTOTemplate.getTaskAction());
		 * taskDTOProject.setTaskInput(taskDTOTemplate.getTaskInput());
		 * taskDTOProject.setTaskOutput(taskDTOTemplate.getTaskOutput());
		 * taskDTOProject.setTaskState(taskDTOTemplate.getTaskState());
		 * taskDTOProject.setTaskTime(taskDTOTemplate.getTaskTime());
		 * taskDTOProject.setResourceDTO(taskDTOTemplate.getResourceDTO());
		 * //taskService.insertTask(taskDTOProject); taskList.add(taskDTOProject); }
		 */
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectName(projectTemplate.getProjectName() + "_fromTP");
		projectDTO.setProjectStatus(0);
		projectDTO.setTasksDTO(projectTemplate.getTasksDTO());
		//projectDTO.setTasksDTO(taskList);
		projectDTO.setUserDTO(userLogged);

		projectService.insertProject(projectDTO);
		// visualProjectTemplate(request);

		return "redirect:/Project/projectManagement";
	}

}
