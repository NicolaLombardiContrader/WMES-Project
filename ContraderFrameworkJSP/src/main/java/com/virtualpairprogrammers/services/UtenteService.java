package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.UtenteDAO;
import com.virtualpairprogrammers.domain.Utente;
import com.virtualpairprogrammers.dao.AnnunciDAO;
import java.util.List;

public class UtenteService{

    private UtenteDAO utenteDAO;
    private AnnunciDAO annunciDAO;
    private static UtenteService reference;

    public static UtenteService getService()
    {
        if (reference == null)
            reference = new UtenteService();
        return reference;
    }

    public UtenteService() {
        this.utenteDAO = new UtenteDAO();
    }

    public List<Utente> ritornaRecruiter() {
        return this.utenteDAO.ritornaRecruiter();
    }

    public List<Utente> ritornaCandidati() {
            return this.utenteDAO.ritornaCandidati();
    }

    public boolean inserisciRecruiter(Utente recruiter){
        return this.utenteDAO.inserisciRecruiter(recruiter);
    }

    public boolean registrazioneCandidato(Utente candidato){
        return this.utenteDAO.registrazioneCandidato(candidato);
    }

    public boolean valutacommentaCandidati(String valutazione, String commenti, Integer id) {
        return this.utenteDAO.valutacommentaCandidati(valutazione, commenti, id);
    }

}
