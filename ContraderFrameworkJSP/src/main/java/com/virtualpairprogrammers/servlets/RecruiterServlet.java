package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.domain.Utente;
import com.virtualpairprogrammers.services.AnnunciService;
import com.virtualpairprogrammers.services.UtenteService;
import com.virtualpairprogrammers.services.CandidatureService;
import com.virtualpairprogrammers.domain.Annunci;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecruiterServlet extends HttpServlet {

    private UtenteService utenteService;
    private AnnunciService annunciService;
    private CandidatureService candidatureService;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        utenteService = UtenteService.getService();
        annunciService = AnnunciService.getService();
        candidatureService = CandidatureService.getService();
        switch (scelta) {
            case "Lista Candidati":
                List<Utente> candidati = new ArrayList<Utente>();
                candidati = this.utenteService.ritornaCandidati();
                session.setAttribute("listCandidati", candidati);
                response.sendRedirect("listCandidati.jsp");
                break;
            case "Lista annunci":
                List<Annunci> annunci = new ArrayList<Annunci>();
                annunci = this.annunciService.ritornaTuttiAnnunci();
                session.setAttribute("listAnnunci", annunci);
                response.sendRedirect("listAnnunci.jsp");
                break;
            case "Commenta e valuta candidato":
                String valutazione = request.getParameter("valutazione");
                String commento = request.getParameter("commento");
                Integer id = Integer.parseInt(request.getParameter("id"));
                this.utenteService.valutacommentaCandidati(valutazione, commento, id);
                response.sendRedirect("homeRecruiter.jsp");
                break;



        }
    }
}