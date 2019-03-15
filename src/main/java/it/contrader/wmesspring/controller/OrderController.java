package it.contrader.wmesspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.wmesspring.converter.ConverterUser;
import it.contrader.wmesspring.dto.ClientDTO;
import it.contrader.wmesspring.dto.OrderDTO;
import it.contrader.wmesspring.dto.TaskDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.OrderService;
import it.contrader.wmesspring.service.ClientService;

@CrossOrigin
@RestController
@RequestMapping("/Order")
public class OrderController {

	private final OrderService orderService;
	// private final ClientService clientService;

	@Autowired
	public OrderController(OrderService orderService, ClientService clientService) {
		this.orderService = orderService;
		// this.clientService = clientService;
	}

	@RequestMapping(value = "orderManagement", method = RequestMethod.GET)
	public List<OrderDTO> orderManagement(@RequestParam(value = "userId") int userId) {
		UserDTO userDTOOrderList = new UserDTO();
		userDTOOrderList.setUserId(userId);
		// return
		// this.orderService.findOrderDTOByUser(ConverterUser.toEntity(userDTOOrderList));
		return this.orderService.findOrderDTOByUser(userDTOOrderList);
		// visualOrder(request);
		// return "order/manageOrder";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "orderId") int id) {
		this.orderService.deleteOrderById(id);
	}
	
	

	/*
	 * @RequestMapping(value = "/insertRedirect", method = RequestMethod.GET) public
	 * String insertRedirect(){ return " "; }
	 * 
	 * public String insert(HttpServletRequest request, HttpSession session) {
	 * UserDTO userLogged = (UserDTO) session.getAttribute("utente");
	 * List<ClientDTO> clientList = orderService.findClientDTOByUser(userLogged);
	 * request.setAttribute("clientList", clientList); return "order/insertOrder"; }
	 */

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody OrderDTO orderDTO) {
		this.orderService.insertOrder(orderDTO);
	}
	/*
	 * @RequestMapping(value = "/updateRedirect", method = RequestMethod.GET) public
	 * OrderDTO updateRedirect(@RequestParam(value = "id") int id) { // int id =
	 * Integer.parseInt(request.getParameter("id"));
	 * 
	 * // UserDTO userLogged = (UserDTO) session.getAttribute("utente"); OrderDTO
	 * orderUpdate = new OrderDTO(); // List<ClientDTO> clientList =
	 * orderService.findClientDTOByUser(userLogged); orderUpdate =
	 * this.orderService.getOrderDTOById(id);
	 * 
	 * // request.setAttribute("orderUpdate", orderUpdate); //
	 * request.setAttribute("clientList", clientList); // return
	 * "order/updateOrder"; return orderUpdate; }
	 */

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public OrderDTO read(@RequestParam(value = "orderId") int id) {
		OrderDTO orderUpdate = new OrderDTO();
		orderUpdate = this.orderService.getOrderDTOById(id);
		return orderUpdate;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public List<OrderDTO> update(@RequestParam(value = "order_id") int idUpdate,
			@RequestParam(value = "utente") UserDTO userLogged,
			@RequestParam(value = "order_description") String orderDescription,
			@RequestParam(value = "client_id") ClientDTO clientId) {

		OrderDTO order = new OrderDTO();
		order.setOrderId(idUpdate);
		order.setOrderDescription(orderDescription);
		order.setUserDTO(userLogged);
		order.setClientDTO(clientId);
		orderService.updateOrder(order);
//			visualOrder(request);

		return this.orderService.getListOrderDTO();
	}

}
