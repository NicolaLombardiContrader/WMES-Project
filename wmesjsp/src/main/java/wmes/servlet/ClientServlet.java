package wmes.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wmes.dto.ClientDTO;
import wmes.service.ClientServiceDTO;


public class ClientServlet extends HttpServlet{

	private final ClientServiceDTO clientServiceDTO = new ClientServiceDTO();
	private List<ClientDTO> allClients = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "ClientManager":
			allClients = this.clientServiceDTO.getAllClient();
			request.setAttribute("allClient", allClients);
			getServletContext().getRequestDispatcher("/client/manageClient.jsp").forward(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("/client/insertClient.jsp");
			break;

		case "insert":
			final int userId = Integer.parseInt(request.getParameter("user_id"));
			final String clientName = request.getParameter("client_name");
			User userInsert = new User();
			userInsert.setUserId(userId);
			final ClientDTO client = new ClientDTO(userInsert, clientName);
			clientServiceDTO.insertClient(client);
			showAllUsers(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			ClientDTO clientUpdate = new ClientDTO(new User(), "");
			clientUpdate.setId(id);

			clientUpdate = this.clientServiceDTO.readClient(clientUpdate);
			request.setAttribute("clientUpdate", clientUpdate);
			getServletContext().getRequestDispatcher("/client/updateClient.jsp").forward(request, response);

			break;

		case "update":
			//System.out.println("ID: " + Integer.parseInt(request.getParameter("client_id")));
			//System.out.println("Id Utente: " + request.getParameter("user_id"));
			//System.out.println("Nome Cliente: " + request.getParameter("client_name"));

			final Integer idUpdate = Integer.parseInt(request.getParameter("client_id"));
			final Integer iduserUpdate = Integer.parseInt(request.getParameter("user_id"));
			final String clientNameUpdate = request.getParameter("client_name");
			final ClientDTO clientDTO = new ClientDTO(new User(), "");
			clientDTO .setId(idUpdate); 

			clientServiceDTO.updateClient(clientDTO);
			showAllUsers(request, response);
			
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));

			final ClientDTO clientdelete = new ClientDTO(new User(), "");
			clientdelete.setId(deleteId);
			showAllUsers(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeBO.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allClients = this.clientServiceDTO.getAllClient();
		request.setAttribute("allUser", allClients);
		getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);
	}
}
