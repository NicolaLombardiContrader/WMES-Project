package it.contrader.wmesspring.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.wmesspring.dto.ResourceDTO;
import it.contrader.wmesspring.dto.UserDTO;
import it.contrader.wmesspring.service.UserService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/User")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/*
	 * private void visualUser(HttpServletRequest request) { //UserDTO userDTO =
	 * (UserDTO) session.getAttribute("utente"); List<UserDTO> allUser =
	 * this.userService.getListaUserDTO(); request.setAttribute("allUserDTO",
	 * allUser); }
	 */

	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public List<UserDTO> userManagement() {
		// UserDTO userDTOUserList = new UserDTO();
		// userDTOUserList.setUserId(userId);
		return this.userService.findAllUserDTO();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "userId") int id) {
		this.userService.deleteUserById(id);
	}

	
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@RequestBody UserDTO user) {
		userService.updateUser(user);
	}

	// TODO da modificare nella view ruolo con usertype
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public List<UserDTO> insert(@RequestParam(value = "user_user") String username,
			@RequestParam(value = "user_pass") String password,
			@RequestParam(value = "user_type") String userType) {
		// String username = request.getParameter("user_user").toString();
		// String password = request.getParameter("user_pass").toString();
		// String userType = request.getParameter("user_type").toString();

		// UserDTO userObj = new UserDTO(0, username, password, ruolo,"");
		UserDTO userObj = new UserDTO();
		userObj.setUserUser(username);
		userObj.setUserPass(password);
		userObj.setUserType(userType);
		userService.insertUser(userObj);

		return this.userService.getListaUserDTO();
		// visualUser(request);
		// return "user/manageUser";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public UserDTO loginControl(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {

		// session = request.getSession();
		// final String username = request.getParameter("username");
		// final String password = request.getParameter("password");
		final UserDTO userDTO = userService.getUserByUserUserAndUserPass(username, password);
		final String userType = userDTO.getUserType();
		if (!StringUtils.isEmpty(userType)) {

			// session.setAttribute("utente", userDTO);

			/*
			 * if (userType.equals("admin")) { return "home"; } else if
			 * (userType.equals("bo")) { return "home"; }
			 */
			/*
			 * switch (userType.toLowerCase()) { case "admin": return
			 * "redirect:/Home/homeAdmin"; case "bo": return "redirect:/Home/homeBO";
			 * default: return "index"; }
			 */

			return userDTO;

		}

		return null;
		// return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logOut() {
		// request.getSession().invalidate();
		// return "index";
	}
}
