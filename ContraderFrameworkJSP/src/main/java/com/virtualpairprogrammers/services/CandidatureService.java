package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.CandidatureDAO;
        import com.virtualpairprogrammers.domain.Candidature;
import com.virtualpairprogrammers.domain.Utente;

import java.util.List;

public class CandidatureService {

    private CandidatureDAO candidatureDAO;
    private static CandidatureService reference;

    public static CandidatureService getService()
    {
        if (reference == null)
            reference = new CandidatureService();
        return reference;
    }

    public CandidatureService() {
        this.candidatureDAO = new CandidatureDAO();
    }

    public boolean iscrizioneAnnuncio(Candidature candidatura) {
        return this.candidatureDAO.iscrizioneAnnuncio(candidatura);
    }

    public List<String> visualizzaCandidatureAnnuncio (Integer id) { return this.candidatureDAO.visualizzaCandidatureAnnuncio(id);
    }

}
