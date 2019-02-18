/**
 * Manage a Business Owner view
 */

package wmes.view;

import wmes.main.MainDispatcher;
import wmes.controller.Request;
//import sun.applet.Main;

import java.util.Scanner;

public class HomeBOView implements View {

    private String choice;

    public void showResults(Request request) {
    	System.out.println("Benvenuto in WMES "+request.get("nomeUtente").toString());
    }
//mod

    public void showOptions() {
        System.out.println("-------MENU-------\n");
        System.out.println("Seleziona cosa vuoi gestire:");
        System.out.println("[C]lienti [O]rdini [E]sci ");
        this.choice = this.getInput();
    }

    public void submit() {
        if (choice.equalsIgnoreCase("C"))
        	MainDispatcher.getInstance().callView("Client", null);
            //MainDispatcher.getInstance().callAction("Client", "doControl", null);
        else if (choice.equalsIgnoreCase("O"))
        	MainDispatcher.getInstance().callView("Order", null);
            //MainDispatcher.getInstance().callAction("Order", "doControl", null);
        else {
            Request request = new Request();
            request.put("choice", choice);
            MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
        
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }


}
