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
import wmes.dto.UserDTO;
import wmes.service.UserServiceDTO;


/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi far� User dovr� anche occuparsi del Login che abbiamo lasciato come struttura e va modificata in modo opportuno
 *
 */
public class UserServlet extends HttpServlet {

	private final UserServiceDTO userServiceDTO = new UserServiceDTO();
	private List<UserDTO> allUsers= new ArrayList<>();

	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "UserManager":
			allUsers = this.userServiceDTO.getAllUsers();
			request.setAttribute("allUser", allUsers);
			getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);
			break;			

		case "insert":
			//final Integer id = Integer.parseInt(request.getParameter("user_id"));
			final String username = request.getParameter("user_user");
			final String password = request.getParameter("user_pass");
			final String usertype = request.getParameter("user_type");
			final UserDTO users = new UserDTO(username, password, usertype);
			userServiceDTO.insertUsers(users);
			showAllUsers(request, response);
			break;
					
		case "update":
			System.out.println("ID: "+Integer.parseInt(request.getParameter("user_id")));
			System.out.println("username: "+request.getParameter("user_user"));
			System.out.println("password: "+request.getParameter("user_pass"));
			System.out.println("Tipo utente: "+request.getParameter("user_type"));

		     	
			final Integer idUpdate = Integer.parseInt(request.getParameter("user_id"));
			final String usernameUpdate = request.getParameter("user_user");
			final String passwordUpdate = request.getParameter("user_pass");
			final String ruoloUpdate = request.getParameter("user_type");
			final UserDTO user = new UserDTO(usernameUpdate,passwordUpdate, ruoloUpdate);
			user.setId(idUpdate);
					
				
					
			userServiceDTO.updateUser(user);
			showAllUsers(request, response);
			break;

		case "delete":
			final Integer idUpdat = Integer.parseInt(request.getParameter("user_id"));
			
			final UserDTO use = new UserDTO("" ,"","");
			use.setId(idUpdat);
			userServiceDTO.deleteUsers(use);
			showAllUsers(request, response);
			break;

		case "Indietro":
			response.sendRedirect("homeAdmin.jsp");
			break;

		case "LogsMenu":
			response.sendRedirect("index.jsp");
			break;

				}

			}

	

private void showAllUsers(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	allUsers = this.userServiceDTO.getAllUsers();
	request.setAttribute("allUser", allUsers);
	getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);
}
}