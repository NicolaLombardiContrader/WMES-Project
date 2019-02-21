package wmes.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import wmes.converter.NodeConverter;
import wmes.dto.NodesDTO;
import wmes.dto.OrderDTO;
import wmes.dto.UserDTO;
import wmes.dto.ClientDTO;
import wmes.service.ClientServiceDTO;
import wmes.service.OrderServiceDTO;

/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi far� User dovr� anche occuparsi del Login che abbiamo lasciato
 * come struttura e va modificata in modo opportuno
 *
 */
public class OrderServlet extends HttpServlet {

	private final OrderServiceDTO orderServiceDTO = new OrderServiceDTO();
	private final ClientServiceDTO clientServiceDTO = new ClientServiceDTO();
	private List<OrderDTO> allOrder = new ArrayList<>();
	private List<OrderDTO> filteredOrders = new ArrayList<OrderDTO>();
	private UserDTO userLogged;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		this.userLogged = (UserDTO) session.getAttribute("utente");

		switch (scelta) {

		case "OrderManager":
			showAllOrder(request, response);
			break;

		case "insertRedirect":
			request.setAttribute("clientsByUser", getListClientByUser());
			//response.sendRedirect("order/insertOrder.jsp");
			getServletContext().getRequestDispatcher("/order/insertOrder.jsp").forward(request, response);
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("user_id"));
			// final int userid = Integer.parseInt(request.getParameter("user_id"));
			final int clientid = Integer.parseInt(request.getParameter("client_id"));
			final String orderdescription = request.getParameter("order_description");
			// final UserDTO insertUserDTO = new UserDTO("","","");
			// insertUserDTO.setId(userid);
			final ClientDTO insertClientDTO = new ClientDTO(this.userLogged, "");
			insertClientDTO.setId(clientid);
			final OrderDTO orderInsert = new OrderDTO(this.userLogged, insertClientDTO, orderdescription);
			orderServiceDTO.insertOrder(orderInsert);
			showAllOrder(request, response);

			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			OrderDTO orderUpdate = new OrderDTO(userLogged, new ClientDTO(userLogged, ""), "");
			orderUpdate.setId(id);
			orderUpdate = this.orderServiceDTO.readOrder(orderUpdate);
			
			request.setAttribute("clientsByUser", getListClientByUser());
			request.setAttribute("orderUpdate", orderUpdate);
			
			getServletContext().getRequestDispatcher("/order/updateOrder.jsp").forward(request, response);

			break;

		case "update":

			final Integer orderIdUpdate = Integer.parseInt(request.getParameter("order_id"));
			final Integer clientIdUpdate = Integer.parseInt(request.getParameter("client_id"));
			final String orderDesUpdate = request.getParameter("order_description");
			
			ClientDTO updateClient = new ClientDTO(this.userLogged, "");
			updateClient.setId(clientIdUpdate);
			final OrderDTO updateOrder = new OrderDTO(this.userLogged, updateClient, orderDesUpdate);
			updateOrder.setId(orderIdUpdate);

			orderServiceDTO.updateOrder(updateOrder);
			showAllOrder(request, response);
			break;

		case "delete":
			final Integer orderdeleteId = Integer.parseInt(request.getParameter("id"));

			// UserDTO deleteOrderUser = new UserDTO("","","");
			OrderDTO orderDelete = new OrderDTO(userLogged, new ClientDTO(userLogged, ""), "");
			orderDelete.setId(orderdeleteId);

			orderServiceDTO.deleteOrder(orderDelete);
			showAllOrder(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeBO.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allOrder.clear();
		filteredOrders.clear();
		allOrder = this.orderServiceDTO.getAllOrders();
		// HttpSession session = request.getSession(true);
		// UserDTO userLogged=(UserDTO) session.getAttribute("utente");
		ClientDTO clientDTO;
		for (OrderDTO orderDTO : allOrder) {
			if (orderDTO.getUserDTO().getId() == userLogged.getId()) {
				clientDTO = new ClientDTO(userLogged, "");
				clientDTO.setId(orderDTO.getClientDTO().getId());
				clientDTO = clientServiceDTO.readClient(clientDTO);
				orderDTO.setClientDTO(clientDTO);
				filteredOrders.add(orderDTO);
			}

		}

		request.setAttribute("allOrder", filteredOrders);
		getServletContext().getRequestDispatcher("/order/manageOrder.jsp").forward(request, response);
	}

	
	private List<ClientDTO> getListClientByUser() {
		List<ClientDTO> listAllClients = new ArrayList<>();
		List<ClientDTO> listAllClientsByUser = new ArrayList<>();
		listAllClients = this.clientServiceDTO.getAllClient();

		for (ClientDTO clientDTO : listAllClients) {
			if (clientDTO.getUserDTO().getId() == userLogged.getId())
				listAllClientsByUser.add(clientDTO);
		}
		
		return listAllClientsByUser;
	}
}