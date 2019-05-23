package DAO;

import Beans.Tchat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marine V
 */
public class DAOTchat extends DAO<Tchat> {

    private final String table = "tchat";

    @Override
    public Tchat find(Integer id) {
        Tchat retObj = null;
        // faut faire attention aux espaces qui doivent entouré le nom de la table
        String sql = "SELECT * FROM " + table + " WHERE id_tchat=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // permet de trouver dans la base de données tous les lignes ayant l'id
            pstmt.setInt(1, id);
            // cette ensemble permet de récuperer tous les objets ayant le bon pstmt
            ResultSet rs = pstmt.executeQuery();

            if (rs.first()) {
                retObj = new Tchat(id,
                        rs.getTimestamp("date_message"),
                        rs.getString("userName"),
                        rs.getString("message")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTchat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    }

    @Override
    public Tchat create(Tchat obj) {
        Tchat rtObj = null;
        String sql = "INSERT INTO " + table + " ( userName, message)" + " VALUES (?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getUserName());
            pstmt.setString(2, obj.getMessage());
            pstmt.executeUpdate();
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.first()) {
                rtObj = this.find(generatedKeys.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTchat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rtObj;
    }

    @Override
    public void delete(Tchat obj) {
        String sql = "DELETE FROM " + table + " WHERE id_tchat=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, obj.getId_tchat());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTchat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Tchat update(Tchat obj) {
        Tchat rtObj = null;
        String sql = "UPDATE " + table + " SET "
                + "userName = ?,"
                + "message = ?"
                + " WHERE id_tchat = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, obj.getId_tchat());
            pstmt.setString(2, obj.getUserName());
            pstmt.setString(3, obj.getMessage());
            pstmt.executeUpdate();
            //réhydrate l'objet a partir de ces nouvelles données
            rtObj = find(obj.getId_tchat());

        } catch (SQLException ex) {
            Logger.getLogger(DAOTchat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rtObj;
    }

    @Override
    public List<Tchat> findAll() {
        ArrayList<Tchat> retObj = new ArrayList<>();
        // faut faire attention aux espaces qui doivent entouré le nom de la table
        String sql = "SELECT * FROM " + table + " ORDER BY date_message DESC";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // cette ensemble permet de récuperer tous les objets ayant le bon pstmt
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                retObj.add(new Tchat(rs.getInt("id_tchat"),
                        rs.getTimestamp("date_message"),
                        rs.getString("userName"),
                        rs.getString("message")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTchat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    }

    public List<Tchat> findLastFiveMinutes() {
        ArrayList<Tchat> retObj = new ArrayList<>();
        // faut faire attention aux espaces qui doivent entouré le nom de la table
        String sql = "SELECT * FROM " + table + " WHERE "
                + "date_message > date_sub(now(), interval 5 minute) ORDER BY date_message DESC";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // cette ensemble permet de récuperer tous les objets ayant le bon pstmt
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                retObj.add(new Tchat(rs.getInt("id_tchat"),
                        rs.getTimestamp("date_message"),
                        rs.getString("userName"),
                        rs.getString("message")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTchat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    }


}
