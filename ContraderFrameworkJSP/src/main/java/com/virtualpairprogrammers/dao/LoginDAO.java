package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

    private final String QUERY = "select * from Utente where username = ? and password = ?";

    public List<String> loginUtente(String username, String password) {
        List dati = new ArrayList<String>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resulset = statement.executeQuery();
            while (resulset.next()) {
                String nome = resulset.getString("nome");
                String cognome = resulset.getString("cognome");
                String ruolo = resulset.getString("ruolo");
                Integer id = resulset.getInt("id");
                dati.add(nome);
                dati.add(cognome);
                dati.add(ruolo);
                dati.add(id);
                return dati;
            }
        } catch (SQLException e) {
            System.out.println("Query fallita");
            return dati;
        }
        return dati;
    }
}
