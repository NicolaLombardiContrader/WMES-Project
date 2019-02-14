
package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.AnnunciDAO;
import com.virtualpairprogrammers.domain.Annunci;
import java.util.List;

    public class AnnunciService {
    private AnnunciDAO annunciDAO;

    private static AnnunciService reference;

    public static AnnunciService getService()
    {
        if (reference == null)
            reference = new AnnunciService();
        return reference;
    }

    public AnnunciService() {
        this.annunciDAO = new AnnunciDAO();
    }

    public List<Annunci> ritornaTuttiAnnunci () {
        return this.annunciDAO.ritornaTuttiAnnunci();
    }

    public boolean inserisciAnnuncio (Annunci annunci) {
        return this.annunciDAO.inserisciAnnuncio(annunci);
    }

    public boolean cancellaAnnuncio(Integer id) {
        return this.annunciDAO.cancellaAnnuncio(id);
    }

}
