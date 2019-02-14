package com.virtualpairprogrammers.servlets;
import com.virtualpairprogrammers.domain.Annunci;
import com.virtualpairprogrammers.domain.Candidature;
import com.virtualpairprogrammers.services.CandidatureService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IscrizioneAnnuncioServlet extends HttpServlet {

    private CandidatureService candidatureService;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        candidatureService = CandidatureService.getService();
        Integer ID_Annunci = Integer.parseInt(request.getParameter("id"));
        Integer ID_Candidati = Integer.parseInt(request.getParameter("idca"));
        Candidature newCandidatura = new Candidature(ID_Annunci, ID_Candidati);
        this.candidatureService.iscrizioneAnnuncio(newCandidatura);
        response.sendRedirect("homeCandidato.jsp");
    }
}