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
import wmes.dto.UserDTO;
import wmes.service.ClientServiceDTO;


public class ClientServlet extends HttpServlet{

	private final ClientServiceDTO clientServiceDTO = new ClientServiceDTO();
	private List<ClientDTO> allClients = new ArrayList<>();
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		final UserDTO userLogged=(UserDTO) session.getAttribute("utente");
		
		switch (scelta) {

		case "ClientManager":
			allClients = this.clientServiceDTO.getAllClient();
			request.setAttribute("allClient", allClients);
			getServletContext().getRequestDispatcher("/client/manageClient.jsp").forward(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("client/insertClient.jsp");
			break;

		case "insert":
			//final int userId = Integer.parseInt(request.getParameter("user_id"));
			final String clientName = request.getParameter("client_name");
			//UserDTO userInsert = new UserDTO("","","");
			
			//userInsert.setId(userId);
			final ClientDTO clientInsert = new ClientDTO(userLogged, clientName);
			clientServiceDTO.insertClient(clientInsert);
			showAllClient(request, response);
			break;


		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			ClientDTO clientUpdate = new ClientDTO(new UserDTO("","",""), "");
			clientUpdate.setId(id);

			clientUpdate = this.clientServiceDTO.readClient(clientUpdate);
			request.setAttribute("clientUpdate", clientUpdate);
			getServletContext().getRequestDispatcher("/client/updateClient.jsp").forward(request, response);

			break;

		case "update":
			final Integer clientIdUpdate = Integer.parseInt(request.getParameter("client_id"));
			final Integer userIdUpdate = Integer.parseInt(request.getParameter("user_id"));
			final String clientNameUpdate = request.getParameter("client_name");
			UserDTO userUpdate= new UserDTO("","","");
			userUpdate.setId(userIdUpdate);
			final ClientDTO clientDTO = new ClientDTO(userUpdate, clientNameUpdate);
			clientDTO .setId(clientIdUpdate);
			clientServiceDTO.updateClient(clientDTO);
			showAllClient(request, response);
			break;

		case "delete":
			final Integer clientIdDelete = Integer.parseInt(request.getParameter("id"));

			final ClientDTO clientdelete = new ClientDTO(userLogged, "");
			clientdelete.setId(clientIdDelete);
			clientServiceDTO.deleteClient(clientdelete);
			showAllClient(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeBO.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllClient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allClients = this.clientServiceDTO.getAllClient();
		request.setAttribute("allClient", allClients);
		getServletContext().getRequestDispatcher("/client/manageClient.jsp").forward(request, response);
	}
}
