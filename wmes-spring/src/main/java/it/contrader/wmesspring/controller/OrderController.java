package it.contrader.wmesspring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.OrderDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.OrderService;

@Controller
@RequestMapping("/Order")
public class OrderController {


		private final OrderService orderService;
		private HttpSession session;


		
		@Autowired
		public OrderController(OrderService orderService) {
			this.orderService = orderService;
		}
	
		private void visualOrder(HttpServletRequest request) {
			List<OrderDTO> allUser = this.orderService.getListOrderDTO();
			request.setAttribute("allUserDTO", allUser);
		}

		@RequestMapping(value = "orderManagement", method = RequestMethod.GET)
		public String userManagement(HttpServletRequest request) {
			visualOrder(request);
			return "order/manageOrder";
		}		
		
		
		@RequestMapping(value = "/delete", method = RequestMethod.GET)
		public String delete(HttpServletRequest request) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			this.orderService.deleteOrderById(id);
			visualOrder(request);
			return "homeOrder";	

		}

		@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
		public String insert(HttpServletRequest request) {
			return "order/insertOrder";
		}
		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public String insertOrder(HttpServletRequest request) {
			UserDTO userLogged = (UserDTO) session.getAttribute("utente");
			int clientId= Integer.parseInt(request.getParameter("client_id"));
			String orderDescription = request.getParameter("order_description").toString();
			
			
			ClientDTO insertClientDTO = new ClientDTO();
			insertClientDTO.setClientId(clientId);

			OrderDTO orderObj = new OrderDTO();
			orderObj.setOrderDescription(orderDescription);
			orderObj.setUserDTO(userLogged);
			orderObj.setClientDTO(insertClientDTO);
			orderService.insertOrder(orderObj);
			visualOrder(request);
			 

			return "order/insertOrder";
		}
		
		@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
		public String updateRedirect(HttpServletRequest request) {
			int id = Integer.parseInt(request.getParameter("id"));
			OrderDTO orderUpdate = new OrderDTO();

			orderUpdate = this.orderService.getOrderDTOById(id);
			request.setAttribute("orderUpdate", orderUpdate);
			return "order/updateOrder";
		}		
		

		@RequestMapping(value = "/update", method = RequestMethod.GET)
		public String update(HttpServletRequest request) {
			
			Integer idUpdate = Integer.parseInt(request.getParameter("order_id"));

			UserDTO userLogged = (UserDTO) session.getAttribute("utente");

			String orderDescription = request.getParameter("order_description").toString();
			int clientId= Integer.parseInt(request.getParameter("client_id"));


			ClientDTO updateClientDTO = new ClientDTO();
			updateClientDTO.setClientId(clientId);
			
			OrderDTO order = new OrderDTO();
			order.setOrderDescription(orderDescription);
			order.setUserDTO(userLogged);
			order.setClientDTO(updateClientDTO);

			
			orderService.updateOrder(order);
			visualOrder(request);
			
			
			return "order/manageOrder";
		}

		
		
		
		
		
		
		
		
		
}
