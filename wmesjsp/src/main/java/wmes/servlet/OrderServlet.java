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
import wmes.service.OrderServiceDTO;

/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi far� User dovr� anche occuparsi del Login che abbiamo lasciato come
 * struttura e va modificata in modo opportuno
 *
 */
public class OrderServlet extends HttpServlet {

	private final OrderServiceDTO orderServiceDTO = new OrderServiceDTO();
	private List<OrderDTO> allOrder = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "OrderManager":
			allOrder = this.orderServiceDTO.getAllOrders();
			request.setAttribute("allOrder", allOrder);
			getServletContext().getRequestDispatcher("/order/manageOrder.jsp").forward(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("order/insertOrder.jsp");
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("user_id"));
			final int userid = Integer.parseInt(request.getParameter("user_id"));
			final int clientid = Integer.parseInt(request.getParameter("client_id"));
			final String orderdescription = request.getParameter("order_description");
			final UserDTO insertUserDTO = new UserDTO("","","");
			insertUserDTO.setId(userid);
			final ClientDTO insertClientDTO = new ClientDTO(insertUserDTO,"");
			final OrderDTO orders = new OrderDTO(insertUserDTO, insertClientDTO, orderdescription);
			orderServiceDTO.insertOrder(orders);
			showAllOrder(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			UserDTO updateRedirectUser = new UserDTO("","","");
			OrderDTO orderUpdate = new OrderDTO(updateRedirectUser,new ClientDTO(updateRedirectUser,""),"");
			orderUpdate.setId(id);

			orderUpdate = this.orderServiceDTO.readOrder(orderUpdate);
			request.setAttribute("orderUpdate", orderUpdate);
			getServletContext().getRequestDispatcher("/order/updateOrder.jsp").forward(request, response);

			break;

		case "update":

			final Integer orderIdUpdate = Integer.parseInt(request.getParameter("order_id"));
			final Integer userIdUpdate = Integer.parseInt(request.getParameter("user_id"));
			final Integer clientIdUpdate = Integer.parseInt(request.getParameter("client_id"));
			final String orderDesUpdate = request.getParameter("order_description");
			UserDTO updateUser = new UserDTO("","","");
			updateUser.setId(userIdUpdate);
			ClientDTO updateClient = new ClientDTO(updateUser,"");
			updateClient.setId(clientIdUpdate);
			final OrderDTO updateOrder = new OrderDTO(updateUser, updateClient, orderDesUpdate);
			updateOrder.setId(orderIdUpdate);

			orderServiceDTO.updateOrder(updateOrder);
			showAllOrder(request, response);
			break;

		case "delete":
			final Integer orderdeleteId = Integer.parseInt(request.getParameter("id"));
			
			UserDTO deleteOrderUser = new UserDTO("","","");
			OrderDTO orderDelete = new OrderDTO(deleteOrderUser,new ClientDTO(deleteOrderUser,""),"");
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
		allOrder = this.orderServiceDTO.getAllOrders();
		request.setAttribute("allOrder", allOrder);
		getServletContext().getRequestDispatcher("/order/manageOrder.jsp").forward(request, response);
	}
}