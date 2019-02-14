package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.domain.Utente;
import com.virtualpairprogrammers.services.UtenteService;
import com.virtualpairprogrammers.domain.Annunci;
import com.virtualpairprogrammers.services.AnnunciService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CandidatoServlet extends HttpServlet {

    private UtenteService utenteService;
    private AnnunciService annunciService;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        utenteService = UtenteService.getService();
        annunciService = AnnunciService.getService();
        switch (scelta) {
            case "Registrati":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String nome = request.getParameter("nome");
                String cognome = request.getParameter("cognome");
                String indirizzo = request.getParameter("indirizzo");
                String Codice_fiscale = request.getParameter("codice_fiscale");
                String email = request.getParameter("email");
                String telefono = request.getParameter("telefono");
                Utente newCandidato = new Utente(null, username, password, nome, cognome, indirizzo, Codice_fiscale, telefono, email, "candidato", null, null);
                this.utenteService.registrazioneCandidato(newCandidato);
                response.sendRedirect("index.jsp");
                break;
            case "Lista annunci":
                List<Annunci> annunci = new ArrayList<Annunci>();
                annunci = this.annunciService.ritornaTuttiAnnunci();
                session.setAttribute("listAnnunci", annunci);
                response.sendRedirect("listAnnunci.jsp");
                break;
        }
    }
}
