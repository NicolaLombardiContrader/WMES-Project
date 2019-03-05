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
import it.contrader.wmesspring.service.ClientService;

@Controller
@RequestMapping("/Order")
public class OrderController {


		private final OrderService orderService;
		private final ClientService clientService;
		@Autowired
		private HttpSession session;


		
		@Autowired
		public OrderController(OrderService orderService, ClientService clientService) {
			this.orderService = orderService;
			this.clientService = clientService;
		}
	
		private void visualOrder(HttpServletRequest request) {
			UserDTO userDTO = (UserDTO) session.getAttribute("utente");
			List<OrderDTO> allOrder = this.orderService.findOrderDTOByUser(userDTO);
			request.setAttribute("allOrderDTO", allOrder);
		}

		@RequestMapping(value = "orderManagement", method = RequestMethod.GET)
		public String orderManagement(HttpServletRequest request) {
			visualOrder(request);
			return "order/manageOrder";
		}		
		
		
		@RequestMapping(value = "/delete", method = RequestMethod.GET)
		public String delete(HttpServletRequest request) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			this.orderService.deleteOrderById(id);
			visualOrder(request);
			return "order/manageOrder";	

		}

		@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
		public String insert(HttpServletRequest request, HttpSession session) {
			UserDTO userLogged = (UserDTO) session.getAttribute("utente");
			List<ClientDTO> clientList = orderService.findClientDTOByUser(userLogged);
			request.setAttribute("clientList", clientList);
			return "order/insertOrder";
		}
		
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public String insertOrder(HttpServletRequest request, HttpSession session) {
			UserDTO userLogged = (UserDTO) session.getAttribute("utente");
			int clientInsertId = Integer.parseInt(request.getParameter("client_id").toString());
			String orderDescription = request.getParameter("order_description").toString();
			
			
			ClientDTO insertClientDTO = new ClientDTO();
			insertClientDTO.setClientId(clientInsertId);
			
			OrderDTO orderObj = new OrderDTO();
			orderObj.setOrderDescription(orderDescription);
			orderObj.setUserDTO(userLogged);
			orderObj.setClientDTO(insertClientDTO);
			orderService.insertOrder(orderObj);
			visualOrder(request);
			 

			return "order/manageOrder";
		}
		
		@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
		public String updateRedirect(HttpServletRequest request, HttpSession session) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			UserDTO userLogged = (UserDTO) session.getAttribute("utente");
			OrderDTO orderUpdate = new OrderDTO();
			List<ClientDTO> clientList = orderService.findClientDTOByUser(userLogged);
			orderUpdate = this.orderService.getOrderDTOById(id);
			
			request.setAttribute("orderUpdate", orderUpdate);
			request.setAttribute("clientList", clientList);
			return "order/updateOrder";
		}		
		

		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String update(HttpServletRequest request, HttpSession session) {
			
			Integer orderIdUpdate = Integer.parseInt(request.getParameter("order_id"));

			UserDTO userLogged = (UserDTO) session.getAttribute("utente");

			String orderDescription = request.getParameter("order_description").toString();
			int clientId= Integer.parseInt(request.getParameter("client_id"));

			ClientDTO updateClientDTO = new ClientDTO();
			updateClientDTO.setClientId(clientId);
			
			OrderDTO order = new OrderDTO();
			order.setOrderId(orderIdUpdate);
			order.setOrderDescription(orderDescription);
			order.setUserDTO(userLogged);
			order.setClientDTO(updateClientDTO);

			orderService.updateOrder(order);
			visualOrder(request);
			
			
			return "order/manageOrder";
		}

}
