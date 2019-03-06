package it.contrader.wmesspring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ProjectService;

@RestController 
@RequestMapping("/Project")
public class ProjectController {

	private final ProjectService projectService;
	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	/*
	 * private void visualProject(HttpServletRequest request) { UserDTO userDTO =
	 * (UserDTO) session.getAttribute("utente"); List<ProjectDTO> allProject =
	 * this.projectService.findProjectDTOByUser(userDTO);
	 * request.setAttribute("allProjectDTO", allProject); }
	 */

	@RequestMapping(value = "/projectManagement", method = RequestMethod.GET)
	public List<ProjectDTO> projectManagement(){
		return this.projectService.getListProjectDTO();
	//public String prjectManagement(HttpServletRequest request) {
	//	visualProject(request);
		//return "project/manageProject";
	}

	// Delete
	@RequestMapping(value = "/delete", method = RequestMethod.GET)

	public void delete(@RequestParam(value ="id") int id) {
		this.projectService.deleteProjectById(id);
	}
	//public String delete(HttpServletRequest request) {
		//int id = Integer.parseInt(request.getParameter("id"));
		//request.setAttribute("id", id);
		//this.projectService.deleteProjectById(id);
		//visualProject(request);
		//return "project/manageProject";

	//}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public ProjectDTO updateRedirect(@RequestParam(value = "id") int id) {
		ProjectDTO projectUpdate = new ProjectDTO();
	//public String updateRedirect(HttpServletRequest request, HttpSession session) {
		//int id = Integer.parseInt(request.getParameter("id"));
		//UserDTO userDTO = (UserDTO) session.getAttribute("utente");
		projectUpdate = this.projectService.getProjectDTOById(id);
		//ProjectDTO projectUpdate = this.projectService.getProjectDTOById(id);
		//List<TaskDTO> taskList = projectService.findTaskDTOByUser(userDTO);

		//request.setAttribute("taskList", taskList);
		//request.setAttribute("projectUpdate", projectUpdate);

		//return "project/updateProject";
		return projectUpdate;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public List<ProjectDTO> update(@RequestParam(value = "project_id") int idUpdate,
	@RequestParam (value = "utente") UserDTO userLogged,
	@RequestParam (value = "project_status") int projectStatus){
	//public String update(HttpServletRequest request, HttpSession session) {
		//UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		//Integer idUpdate = Integer.parseInt(request.getParameter("project_id"));
	//	int projectStatus = Integer.parseInt(request.getParameter("project_status"));
	//	String projectProjectName = request.getParameter("project_name");

		/*
		 * List<TaskDTO> taskList = new ArrayList<TaskDTO>(); String taskListString[] =
		 * (String[]) request.getParameterValues("taskList"); for (String taskString :
		 * taskListString) { TaskDTO taskDTO = new TaskDTO();
		 * taskDTO.setTaskId(Integer.parseInt(taskString)); taskList.add(taskDTO); }
		 * 
		 * ProjectDTO project = new ProjectDTO(); project.setUserDTO(userLogged);
		 * project.setProjectId(idUpdate); project.setProjectName(projectProjectName);
		 * project.setTasksDTO(taskList); project.setProjectStatus(projectStatus);
		 * projectService.updateProject(project); visualProject(request); return
		 * "project/manageProject";
		 */
		ProjectDTO projectUpdateDTO = new ProjectDTO();
		projectUpdateDTO.setProjectId(idUpdate);
		projectUpdateDTO.setUserDTO(userLogged);
		projectUpdateDTO.setProjectStatus(projectStatus);
		
		projectService.updateProject(projectUpdateDTO);
		return this.projectService.getListProjectDTO();
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect() {
		return " " ;

	/*
	 * public String insert(HttpServletRequest request, HttpSession session) {
	 * UserDTO userDTO = (UserDTO) session.getAttribute("utente"); List<TaskDTO>
	 * taskList = projectService.findTaskDTOByUser(userDTO);
	 * request.setAttribute("taskList", taskList); return "project/insertProject";
	 */
	}	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public List<ProjectDTO> insert(@RequestParam(value = "project_id") int idUpdate,
			@RequestParam (value = "utente") UserDTO userLogged,
			@RequestParam (value = "project_status") int projectStatus){
	//public String insertProject(HttpServletRequest request, HttpSession session) {
	//	UserDTO userLogged = (UserDTO) session.getAttribute("utente");
	//	String projectname = request.getParameter("project_name").toString();
		
		//List<TaskDTO> taskList = new ArrayList<TaskDTO>();
		//String taskListString[] =(String []) request.getParameterValues("taskList");
		
		/*
		 * for(String taskString : taskListString) { TaskDTO taskDTO=new TaskDTO();
		 * taskDTO.setTaskId(Integer.parseInt(taskString)); taskList.add(taskDTO); }
		 */
		ProjectDTO projectUpdateDTO = new ProjectDTO();
		projectUpdateDTO.setProjectId(idUpdate);
		projectUpdateDTO.setUserDTO(userLogged);
		projectUpdateDTO.setProjectStatus(projectStatus);
		
		projectService.updateProject(projectUpdateDTO);
		return this.projectService.getListProjectDTO();
		
		/*
		 * ProjectDTO projectObj = new ProjectDTO();
		 * projectObj.setProjectName(projectname); projectObj.setUserDTO(userLogged);
		 * projectObj.setProjectStatus(0); projectObj.setTasksDTO(taskList);
		 * 
		 * projectService.insertProject(projectObj); visualProject(request); return
		 * "project/manageProject";
		 */
	}

}
