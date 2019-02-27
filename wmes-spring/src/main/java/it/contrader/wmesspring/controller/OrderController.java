package it.contrader.wmesspring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.OrderDTO;
import it.contrader.wmesspring.dto.ProjectDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.ClientService;
import it.contrader.wmesspring.service.OrderService;

@Controller
@RequestMapping("/Order")
public class OrderController {


		private final OrderService orderService;
		private HttpSession session;

//		private final ClientService clientService;
//		private UserDTO userLogged;
		
		
		@Autowired
		public OrderController(OrderService orderService) {
			this.orderService = orderService;
//			this.userLogged = (UserDTO) session.getAttribute("utente");
		}
	
		private void visualOrder(HttpServletRequest request) {
			List<OrderDTO> allUser = this.orderService.getListOrderDTO();
			request.setAttribute("allUserDTO", allUser);
		}

		@RequestMapping(value = "orderManagement", method = RequestMethod.GET)
		public String userManagement(HttpServletRequest request) {
			visualOrder(request);
			return "order/managmentOrder";
		}		
		
		
		@RequestMapping(value = "/delete", method = RequestMethod.GET)
		public String delete(HttpServletRequest request) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			this.orderService.deleteOrderById(id);
			visualOrder(request);
			return "homeOrder";

			
			
			

		}


		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public String insertOrder(HttpServletRequest request) {
			UserDTO userLogged = (UserDTO) session.getAttribute("utente");
			String ClientId= request.getParameter("client_id");
			String orderDescription = request.getParameter("order_description").toString();
			
			int clientid = Integer.parseInt(request.getParameter("client_id").toString());

//			ClientDTO insertClientDTO = new ClientDTO("");
//			insertClientDTO.setId(clientid);

			OrderDTO orderObj = new OrderDTO();
			orderObj.setOrderDescription(orderDescription);
			orderObj.setUserDTO(userLogged);
//			orderObj.setClientDTO(clientid);
			orderService.insertOrder(orderObj);
			visualOrder(request);
			
			
/*			@RequestMapping(value = "/creaProject", method = RequestMethod.POST)
			public String insertProject(HttpServletRequest request) {
				String projectname = request.getParameter("projectname").toString();
				int projectStatus = 0;
				

				
				ProjectDTO projectObj = new ProjectDTO();
				projectObj.setProjectName(projectname);
				projectObj.setProjectStatus(projectStatus);
				projectObj.setUserDTO(userLogged);
				projectObj.setProjectStatus(0);
				projectService.insertProject(projectObj);

				visualProject(request);
				return "homeProject";
			}*/
			
			

			return "order/insertOrder";
		}
		
		
		
	

		
		
		
		
		
		
		
		
		
}
