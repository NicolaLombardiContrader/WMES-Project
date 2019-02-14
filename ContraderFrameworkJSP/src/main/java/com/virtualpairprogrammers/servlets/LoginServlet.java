package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {

    private LoginService loginService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String nameSession = (String) session.getAttribute("nome");
        String cognomeSession = (String) session.getAttribute("cognome");
        String ruoloSession = (String) session.getAttribute("ruolo");
        loginService = LoginService.getService();
        if ((request != null) && (ruoloSession == null) && (nameSession == null) && (cognomeSession == null)) {
            String nome = request.getParameter("user");
            String password = request.getParameter("pwd");
            List<String> result = new ArrayList<String>();
            result = this.loginService.loginUtente(nome, password);
            if (!result.isEmpty()) {
                session.setAttribute("nome", result.get(0));
                session.setAttribute("cognome", result.get(1));
                session.setAttribute("ruolo", result.get(2));
                session.setAttribute("id", result.get(3));
                String ruolo = result.get(2);
                switch (ruolo) {
                    case ("gestore"):
                        response.sendRedirect("homeGestore.jsp");
                        break;
                    case ("recruiter"):
                        response.sendRedirect("homeRecruiter.jsp");
                        break;
                    case ("candidato"):
                        response.sendRedirect("homeCandidato.jsp");
                        break;
                }
            } else {
                session.setAttribute("esitoLogin", "errato");
                response.sendRedirect("index.jsp");
            }
        } else {
            response.sendRedirect("home.jsp");
        }
    }
}
