package com.virtualpairprogrammers.domain;

public class Utente {

    private Integer id;
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String indirizzo;
    private String codice_fiscale;
    private String telefono;
    private String email;
    private String ruolo;
    private String valutazione;
    private String commenti;

    public Utente(Integer id, String username, String password, String nome, String cognome, String indirizzo, String codice_fiscale, String telefono, String email, String ruolo, String valutazione, String commenti) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.codice_fiscale = codice_fiscale;
        this.telefono = telefono;
        this.email = email;
        this.ruolo = ruolo;
        this.valutazione = valutazione;
        this.commenti = commenti;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCodice_fiscale() {
        return codice_fiscale;
    }

    public void setCodice_fiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getValutazione() {
        return valutazione;
    }

    public void setValutazione(String valutazione) {
        this.valutazione = valutazione;
    }

    public String getCommenti() {
        return commenti;
    }

    public void setCommenti(String commenti) {
        this.commenti = commenti;
    }
}
