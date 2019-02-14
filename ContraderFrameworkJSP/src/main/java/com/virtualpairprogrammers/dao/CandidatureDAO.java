package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.domain.Candidature;
import com.virtualpairprogrammers.domain.Utente;
import com.virtualpairprogrammers.utils.ConnectionSingleton;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatureDAO {

    public boolean iscrizioneAnnuncio(Candidature candidatura) {
        String QUERY_INSERT = "INSERT INTO recruitmentplatform.candidature (ID_Annunci, ID_Candidati) VALUES (?, ?)";
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, candidatura.getID_Annunci());
            preparedStatement.setInt(2, candidatura.getID_Candidati());
            int a = preparedStatement.executeUpdate();
            if (a > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<String> visualizzaCandidatureAnnuncio(Integer id) {
        String Query = "SELECT utente.cognome, utente.nome FROM utente INNER JOIN candidature ON utente.id = candidature.ID_Candidati WHERE candidature.ID_Annunci ="+id+"";
        List<String> nominativi = new ArrayList<String>();
        String nominativo="";

        try {
            Connection connection = ConnectionSingleton.getInstance();
            PreparedStatement ps = connection.prepareStatement(Query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String Cognome = resultSet.getString("cognome");
                String Nome = resultSet.getString("nome");
                nominativo= Cognome +" "+ Nome;
                nominativi.add(nominativo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nominativi;
    }
}