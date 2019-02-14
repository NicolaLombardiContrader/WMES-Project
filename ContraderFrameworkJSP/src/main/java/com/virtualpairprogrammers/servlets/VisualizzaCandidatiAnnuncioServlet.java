package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.services.CandidatureService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VisualizzaCandidatiAnnuncioServlet extends HttpServlet {

    private CandidatureService candidatureService;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        candidatureService = CandidatureService.getService();
        Integer id = Integer.parseInt(request.getParameter("id"));
        List<String> nominativi = new ArrayList<String>();
        nominativi =  this.candidatureService.visualizzaCandidatureAnnuncio(id);
        session.setAttribute("listCandidatiAnnuncio",nominativi );
        response.sendRedirect("visualizzaCandidatureAnnuncio.jsp");

    }
}