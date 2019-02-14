package com.virtualpairprogrammers.servlets;


import com.virtualpairprogrammers.domain.Utente;
import com.virtualpairprogrammers.services.AnnunciService;
import com.virtualpairprogrammers.services.UtenteService;
import com.virtualpairprogrammers.domain.Annunci;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestoreServlet extends HttpServlet {
    private UtenteService utenteService;
    private AnnunciService annunciService;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        utenteService = UtenteService.getService();
        annunciService = AnnunciService.getService();
        switch (scelta) {
            case "Lista Recruiter":
                List<Utente> recruiter = new ArrayList<Utente>();
                recruiter = this.utenteService.ritornaRecruiter();
                session.setAttribute("listRecruiter", recruiter);
                response.sendRedirect("listRecruiter.jsp");
                break;
            case "Lista Candidati":
                List<Utente> candidati = new ArrayList<Utente>();
                candidati = this.utenteService.ritornaCandidati();
                session.setAttribute("listCandidati", candidati);
                response.sendRedirect("listCandidati.jsp");
                break;
            case "Inserisci Recruiter":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String nome = request.getParameter("nome");
                String cognome = request.getParameter("cognome");
                String indirizzo = request.getParameter("indirizzo");
                String Codice_fiscale = request.getParameter("codice_fiscale");
                String email = request.getParameter("email");
                String telefono = request.getParameter("telefono");
                Utente neweRecruiter = new Utente(null, username, password, nome, cognome, indirizzo, Codice_fiscale, telefono, email, "recruiter", null, null);
                this.utenteService.inserisciRecruiter(neweRecruiter);
                response.sendRedirect("homeGestore.jsp");
                break;
            case "Lista annunci":
                List<Annunci> annunci = new ArrayList<Annunci>();
                annunci = this.annunciService.ritornaTuttiAnnunci();
                session.setAttribute("listAnnunci", annunci);
                response.sendRedirect("listAnnunci.jsp");
                break;
            case "Inserisci Annuncio":
                String titolo = request.getParameter("titolo");
                String luogo = request.getParameter("luogo");
                String categoria = request.getParameter("categoria");
                String contratto = request.getParameter("contratto");
                Annunci newAnnuncio = new Annunci(null, titolo, luogo, categoria, contratto);
                this.annunciService.inserisciAnnuncio(newAnnuncio);
                response.sendRedirect("homeGestore.jsp");
                break;
        }
    }
}



