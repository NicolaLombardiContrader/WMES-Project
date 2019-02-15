/**
 * Manage a Business Owner view
 */

package wmes.view;

import wmes.main.MainDispatcher;
import wmes.controller.Request;
//import sun.applet.Main;

import java.util.Scanner;

public class HomeAdminView implements View {

    private String choice;

    public void showResults(Request request) {
    	System.out.println("Benvenuto in WMES "+request.get("nomeUtente").toString());
    }


    public void showOptions() {
        System.out.println("-------MENU-------\n");
        System.out.println("Seleziona cosa vuoi gestire:");
        System.out.println("[U]tenti [L]ogout");
        this.choice = this.getInput();
    }

    public void submit() {
        if (choice.equals("U"))
            MainDispatcher.getInstance().callAction("User", "doControl", null);
        if (choice.equals("L"))
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
        else {
            Request request = new Request();
            request.put("choice", choice);
            MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
