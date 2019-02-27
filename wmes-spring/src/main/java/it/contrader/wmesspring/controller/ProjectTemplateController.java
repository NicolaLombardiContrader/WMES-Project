package it.contrader.wmesspring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.wmesspring.dto.OrderDTO;
import it.contrader.wmesspring.dto.ProjectTemplateDTO;
import it.contrader.wmesspring.service.OrderService;
import it.contrader.wmesspring.service.ProjectTemplateService;

@Controller
@RequestMapping("/ProjectTemplate")
public class ProjectTemplateController {

	
	/*
	 * private int projectId;
	 * 
	 * private String projectName;
	 * 
	 * private UserDTO userDTO;
	 */
	

	private final ProjectTemplateService projectTemplateService;
	private HttpSession session;

	
	@Autowired
	public ProjectTemplateController(ProjectTemplateService projectTemplateService) {
		this.projectTemplateService = projectTemplateService;
	}

	private void visualProjectTemplate(HttpServletRequest request) {
		List<ProjectTemplateDTO> allUser = this.projectTemplateService.getListaProjectTemplateDTO();
		request.setAttribute("allUserDTO", allUser);
	}

	@RequestMapping(value = "projectTemplateManagement", method = RequestMethod.GET)
	public String projectTemplateManagement(HttpServletRequest request) {
		visualProjectTemplate(request);
		return "projectTemplate/manageProjectTemplate";
	}
}
