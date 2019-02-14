package com.virtualpairprogrammers.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.services.AnnunciService;


import java.io.IOException;

public class CancellaAnnuncioServlet extends HttpServlet {

    private AnnunciService annunciService;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        annunciService = AnnunciService.getService();
        Integer id = Integer.parseInt(request.getParameter("id"));
        this.annunciService.cancellaAnnuncio(id);
        response.sendRedirect("homeGestore.jsp");
    }
}


