package it.contrader.wmesspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.contrader.wmesspring.service.UserService;

@SpringBootApplication
public class WmesSpringApplication {

	static UserService userService;
/*
	@Autowired
	public WmesApplication(UserService userService) {
		//this.nodoService = nodoService;
		this.userService = userService;
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(WmesSpringApplication.class, args);
	}

}
