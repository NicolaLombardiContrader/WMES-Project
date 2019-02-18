package wmes.controller;

import java.util.List;

import wmes.main.MainDispatcher;
import wmes.model.Order;
import wmes.model.User;
import wmes.service.OrderService;

public class OrderController implements Controller {

	private static String sub_package = "order.";
	private OrderService orderService;
	private Request request;
	
	public OrderController() {
        this.orderService = new OrderService();
    }
	
	public List<Order> getAllOrder() {
		return this.orderService.getAllOrder();
	}
	
	public Order readUser(int orderId) {
		return this.orderService.readOrder(orderId);
	}
	
	public boolean insertOrder(Order order) {
	    return this.orderService.insertOrder(order);
	}

    public boolean updateOrder(Order order) {
        return this.orderService.updateOrder(order);
    }
    
    public boolean deleteOrder(Integer orderId) {
    	return this.orderService.deleteOrder(orderId);
    }
	    
	@Override
    public void doControl(Request request) {
        String mode = (String) request.get("mode");
        String choice =(String) request.get("choice");
   
        
        if(mode == "menu"){
        		MainDispatcher.getInstance().callView("Order", request);
        }  else {
        switch (choice.toUpperCase()) {
		case "L":
			MainDispatcher.getInstance().callView(sub_package + "OrderRead", null);
			break;
		case "I":
			MainDispatcher.getInstance().callView(sub_package + "OrderInsert", null);
			break;
		case "M":
			MainDispatcher.getInstance().callView(sub_package + "OrderUpdate", null);
			break;
		case "C":
			MainDispatcher.getInstance().callView(sub_package + "OrderDelete", null);
			break;
		default:
        	MainDispatcher.getInstance().callView("Login", null);
			break;
        }}
    }


}
