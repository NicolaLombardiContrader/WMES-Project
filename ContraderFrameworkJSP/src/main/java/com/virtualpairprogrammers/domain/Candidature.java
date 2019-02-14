package com.virtualpairprogrammers.domain;

public class Candidature {

    private Integer ID_Annunci;
    private Integer ID_Candidati;

    public Candidature(Integer ID_Annunci, Integer ID_Candidati) {
        this.ID_Annunci = ID_Annunci;
        this.ID_Candidati = ID_Candidati;
    }

    public Integer getID_Annunci() {
        return ID_Annunci;
    }

    public void setID_Annunci(int ID_Annunci) {
        this.ID_Annunci = ID_Annunci;
    }

    public Integer getID_Candidati() {
        return ID_Candidati;
    }

    public void setID_Candidati(int ID_Candidati) {
        this.ID_Candidati = ID_Candidati;
    }
}
