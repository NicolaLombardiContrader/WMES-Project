package it.contrader.wmesspring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ResourceService;

import java.util.List;

@Controller
@RequestMapping("/Resource")
public class ResourceController {

	private final ResourceService resourceService;
	private HttpSession session;
	
	@Autowired
	public ResourceController(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	private void visualResource(HttpServletRequest request) {
		List<ResourceDTO> allResource = this.resourceService.getListaResourceDTO();
		request.setAttribute("allResourceDTO", allResource);
	}

	@RequestMapping(value = "/resourceManagement", method = RequestMethod.GET)
	public String resourceManagement(HttpServletRequest request) {
		visualResource(request);
		return "resource/manageResource";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int deleteResourceId = Integer.parseInt(request.getParameter("id"));
		//request.setAttribute("id", Id);
		this.resourceService.deleteResourceById(deleteResourceId);
		visualResource(request);
		return "resource/manageResource";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		return "resource/insertResource";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
		String resourceName = request.getParameter("resource_name");
		String resourceUsername = request.getParameter("resource_username");
		String resourcePass = request.getParameter("resource_pass");
		
		ResourceDTO resourceDTO = new ResourceDTO();
		resourceDTO.setUserDTO(userLogged);
		resourceDTO.setResourceName(resourceName);
		resourceDTO.setResourceUsername(resourceUsername);
		resourceDTO.setResourcePass(resourcePass);
		resourceService.insertResource(resourceDTO);
		visualResource(request);
		 

		return "resource/manageResource";
	}
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int resourceUpdateId = Integer.parseInt(request.getParameter("id"));
		ResourceDTO resourceUpdate = new ResourceDTO();

		resourceUpdate = this.resourceService.getResourceDTOById(resourceUpdateId);
		request.setAttribute("resourceUpdate", resourceUpdate);
		return "resource/updateResource";
	}		
	

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request) {
		
		Integer idUpdate = Integer.parseInt(request.getParameter("resource_id"));

		UserDTO userLogged = (UserDTO) session.getAttribute("utente");

		String resourceName = request.getParameter("resource_name");
		String resourceUsername = request.getParameter("resource_username");
		String resourcePass = request.getParameter("resource_pass");
		
		ResourceDTO resourceUpdateDTO = new ResourceDTO();
		resourceUpdateDTO.setUserDTO(userLogged);
		resourceUpdateDTO.setResourceName(resourceName);
		resourceUpdateDTO.setResourceUsername(resourceUsername);
		resourceUpdateDTO.setResourcePass(resourcePass);
		
		resourceService.updateResource(resourceUpdateDTO);
		visualResource(request);
		
		
		return "resource/manageResource";
	}
}
