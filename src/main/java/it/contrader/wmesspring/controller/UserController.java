package it.contrader.wmesspring.controller;

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

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public UserDTO read(@RequestParam(value = "userId") int id) {
		UserDTO readUser = new UserDTO();
		readUser = this.userService.getUserDTOById(id);
		return readUser;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "userId") int id) {
		this.userService.deleteUserById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody UserDTO user) {
		userService.updateUser(user);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody UserDTO user) {
		userService.insertUser(user);
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
