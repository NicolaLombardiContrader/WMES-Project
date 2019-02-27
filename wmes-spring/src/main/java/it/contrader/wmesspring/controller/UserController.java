package it.contrader.wmesspring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {

	private final UserService userService;
	private HttpSession session;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	private void visualUser(HttpServletRequest request) {
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
	}

	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		visualUser(request);
		return "user/manageUser";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.userService.deleteUserById(id);
		visualUser(request);
		return "user/manageUser";
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		return "user/insertUser";
	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		UserDTO userUpdate = new UserDTO();
		// userUpdate.setUserId(id);

		userUpdate = this.userService.getUserDTOById(id);
		request.setAttribute("userUpdate", userUpdate);
		return "user/updateUser";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request) {
		Integer idUpdate = Integer.parseInt(request.getParameter("user_id"));
		String usernameUpdate = request.getParameter("user_user");
		String passwordUpdate = request.getParameter("user_pass");
		String usertypeUpdate = request.getParameter("user_type");
		
		UserDTO user = new UserDTO();
		user.setUserUser(usernameUpdate);
		user.setUserPass(passwordUpdate);
		user.setUserType(usertypeUpdate);
		user.setUserId(idUpdate);

		userService.updateUser(user);
		visualUser(request);
		return "user/manageUser";
	}

	@RequestMapping(value = "/cercaUser", method = RequestMethod.GET)
	public String cercaUser(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<UserDTO> allUser = this.userService.findUserDTOByUserUser(content);
		request.setAttribute("allUserDTO", allUser);

		return "homeUser";

	}

	// TODO da modificare nella view ruolo con usertype
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertUser(HttpServletRequest request) {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String userType = request.getParameter("usertype").toString();

		// UserDTO userObj = new UserDTO(0, username, password, ruolo,"");
		UserDTO userObj = new UserDTO();
		userObj.setUserUser(username);
		userObj.setUserPass(password);
		userObj.setUserType(userType);
		userService.insertUser(userObj);

		visualUser(request);
		return "homeUser";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final UserDTO userDTO = userService.getUserByUserUserAndUserPass(username, password);
		final String userType = userDTO.getUserType();
		if (!StringUtils.isEmpty(userType)) {

			session.setAttribute("utente", userDTO);

			/*
			 * if (userType.equals("admin")) { return "home"; } else if
			 * (userType.equals("bo")) { return "home"; }
			 */
			switch (userType.toLowerCase()) {
			case "admin":
				return "redirect:/Home/homeAdmin";
			case "bo":
				return "redirect:/Home/homeBO";
			case "resource":
				return "redirect:/Home/homeResource";
			default:
				return "index";
			}

		}
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
}
