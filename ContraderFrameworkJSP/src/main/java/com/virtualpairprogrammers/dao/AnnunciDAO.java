package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtualpairprogrammers.domain.Annunci;

public class AnnunciDAO {

    static public List<Annunci> ritornaTuttiAnnunci() {
        String Query = "select * from annunci";
        List<Annunci> annunci = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement ps = connection.prepareStatement(Query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Integer Id = resultSet.getInt("id");
                String Titolo = resultSet.getString("titolo");
                String Luogo = resultSet.getString("luogo");
                String Categoria = resultSet.getString("categoria");
                String Contratto = resultSet.getString("contratto");
                annunci.add(new Annunci(Id, Titolo, Luogo, Categoria, Contratto));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annunci;
    }

    public boolean inserisciAnnuncio(Annunci annunci) {
        String QUERY_INSERT = "INSERT INTO recruitmentplatform.annunci (titolo, luogo, categoria, contratto) VALUES (?, ?, ?, ?)";
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, annunci.getTitolo());
            preparedStatement.setString(2, annunci.getLuogo());
            preparedStatement.setString(3, annunci.getCategoria());
            preparedStatement.setString(4, annunci.getContratto());
            int a = preparedStatement.executeUpdate();
            if (a > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean cancellaAnnuncio(Integer id) {
        String QUERY_DELETE = "DELETE FROM recruitmentplatform.annunci WHERE id = ?";
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, id);
            int n = preparedStatement.executeUpdate();
            if (n != 0)
                return true;
        } catch (SQLException e) {
        }
        return false;
    }
}
