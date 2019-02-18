package wmes.view;

import wmes.main.MainDispatcher;
import wmes.controller.Request;
import wmes.model.Order;
import wmes.controller.OrderController;

import java.util.List;
import java.util.Scanner;

public class OrderView implements View {

	private OrderController orderController;
	private Request request;
	private String choice;
	
	public OrderView() {
		this.orderController = new OrderController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Gestione ordini -------\n");
		
		System.out.println("ID\tUserId\tClientId\tDescrizione");
		System.out.print("------------------------------------------------------");
		List<Order> orders = orderController.getAllOrder();
		System.out.println();
		orders.forEach(order -> System.out.println(order.toString()));
		System.out.println();
		
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[I]nserisci [M]odifica [C]ancella [L]ogout");
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "");
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		    MainDispatcher.getInstance().callAction("Order", "doControl", this.request);
	}

}
