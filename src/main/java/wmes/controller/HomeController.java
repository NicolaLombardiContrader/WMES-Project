package wmes.controller;

import wmes.main.MainDispatcher;
import wmes.service.LoginService;

public class HomeController implements Controller {

    private LoginService loginService;

    public HomeController() {
        loginService = new LoginService();
    }

    public void doControl(Request request) {
        if (request != null) {
            String nomeUtente = request.get("nomeUtente").toString();
            String password = request.get("password").toString();
            
            //Change view according userType
            String userType= loginService.login(nomeUtente, password);
            if(userType==null)
                MainDispatcher.getInstance().callAction("Login", "doControl", request);
            
            if (userType.equals("admin"))
                MainDispatcher.getInstance().callView("HomeAdmin", request);
            
            if (userType.equals("user"))
            	MainDispatcher.getInstance().callView("HomeBO", request);
           
        }
        else MainDispatcher.getInstance().callView("Login", null);

    }
}
