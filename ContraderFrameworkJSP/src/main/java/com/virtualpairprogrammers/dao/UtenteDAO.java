package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.domain.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO {

    public List<Utente> ritornaRecruiter() {
        String Query = "select * from utente where ruolo = 'recruiter' ";
        List<Utente> utenti = new ArrayList<>();
        try {
            Connection connection = ConnectionSingleton.getInstance();
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(Query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String Username = resultSet.getString("Username");
                String Password = resultSet.getString("Password");
                String Nome = resultSet.getString("Nome");
                String Cognome = resultSet.getString("Cognome");
                String Indirizzo = resultSet.getString("Indirizzo");
                String Codice_fiscale = resultSet.getString("Codice_fiscale");
                String Telefono = resultSet.getString("Telefono");
                String Email = resultSet.getString("Email");
                String Ruolo = resultSet.getString("Ruolo");
                utenti.add(new Utente(id, Username, Password, Nome, Cognome, Indirizzo, Codice_fiscale, Telefono, Email, Ruolo, null, null));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utenti;
    }

    public List<Utente> ritornaCandidati() {
        String Query = "select * from utente where ruolo = 'candidato'";
        List<Utente> utenti = new ArrayList<>();
        try {
            Connection connection = ConnectionSingleton.getInstance();
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(Query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Integer Id = resultSet.getInt("Id");
                String Username = resultSet.getString("Username");
                String Password = resultSet.getString("Password");
                String Nome = resultSet.getString("Nome");
                String Cognome = resultSet.getString("Cognome");
                String Indirizzo = resultSet.getString("Indirizzo");
                String Codice_fiscale = resultSet.getString("Codice_fiscale");
                String Email = resultSet.getString("Email");
                String Telefono = resultSet.getString("Telefono");
                String Ruolo = resultSet.getString("Ruolo");
                String Valutazione = resultSet.getString("valutazione");
                String Commenti = resultSet.getString("commenti");
                utenti.add(new Utente(Id, Username, Password, Nome, Cognome, Indirizzo, Codice_fiscale, Email, Telefono, Ruolo, Valutazione, Commenti));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utenti;
    }

    public boolean inserisciRecruiter(Utente recruiter) {
        String QUERY_INSERT = "INSERT INTO recruitmentplatform.utente (ruolo, nome, cognome, indirizzo, codice_fiscale, telefono, email, username, password) VALUES ('recruiter', ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, recruiter.getNome());
            preparedStatement.setString(2, recruiter.getCognome());
            preparedStatement.setString(3, recruiter.getIndirizzo());
            preparedStatement.setString(4, recruiter.getCodice_fiscale());
            preparedStatement.setString(5, recruiter.getTelefono());
            preparedStatement.setString(6, recruiter.getEmail());
            preparedStatement.setString(7, recruiter.getUsername());
            preparedStatement.setString(8, recruiter.getPassword());
            int a = preparedStatement.executeUpdate();
            if (a > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean registrazioneCandidato(Utente candidato) {
        String QUERY_INSERT = "INSERT INTO recruitmentplatform.utente (ruolo, nome, cognome, indirizzo, codice_fiscale, telefono, email, username, password) VALUES ('candidato', ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, candidato.getNome());
            preparedStatement.setString(2, candidato.getCognome());
            preparedStatement.setString(3, candidato.getIndirizzo());
            preparedStatement.setString(4, candidato.getCodice_fiscale());
            preparedStatement.setString(5, candidato.getTelefono());
            preparedStatement.setString(6, candidato.getEmail());
            preparedStatement.setString(7, candidato.getUsername());
            preparedStatement.setString(8, candidato.getPassword());
            int a = preparedStatement.executeUpdate();
            if (a > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean valutacommentaCandidati(String valutazione, String commento, Integer id) {
        String QUERY_UPDATE = "UPDATE recruitmentplatform.utente SET valutazione = ? ,commenti = ? WHERE id = ?";
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setString(1, valutazione);
            preparedStatement.setString(2, commento);
            preparedStatement.setInt(3, id);
            int a = preparedStatement.executeUpdate();
            if (a > 0) return true;
            else return false;
        } catch (SQLException e) {
            return false;
        }
    }
}





