package wmes.view;
import wmes.main.MainDispatcher;
import wmes.controller.Request;
import wmes.model.User;
import wmes.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserView implements View {

    private UserService userService;
    private String mode;

  public UserView () {
      this.userService = new UserService();
      this.mode = "all";
  }

    @Override
    public void showResults(Request request) {
       this.mode  = (String) request.get("mode");
    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "all":
                List<User> gomme = userService.getAllUser();
                System.out.println("----- Utenti disponibili -----");
                System.out.println();
                gomme.forEach(user -> System.out.println(user));
                break;
            case "insert":
                //Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci i dati del nuovo utente:");
                System.out.println("Username:");
                String username = getInput();
                System.out.println("Password:");
                String password = getInput();
                System.out.println("Tipo utente:");
                String tipoUtente = getInput();
                userService.insertUser(new User(username,password,tipoUtente));
        }
    }

    @Override
    public String getInput() {
    	
        Scanner scanner = new Scanner(System.in);
        
        return scanner.nextLine();
  }

    @Override
    public void submit() {
        MainDispatcher.getInstance().callAction("Home", "doControl", null);
    }



}
