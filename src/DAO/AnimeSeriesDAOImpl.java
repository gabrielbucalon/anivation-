package DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AnimeReSeries;

/**
 *
 * @author Gabriel Bucalon
 */
public class AnimeSeriesDAOImpl extends DAOConnection implements AnimeSeriesDAO {

    ResultSet rs = null;

    public AnimeSeriesDAOImpl() {
        getConnection();
    }

    @Override
    public ResultSet getInfTables(String nameTable) {
        try {
            return rs = getConnection().createStatement().executeQuery(nameTable);
        } catch (SQLException ex) {
            Logger.getLogger(AnimeSeriesDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean createAnime(String query, AnimeReSeries ani) {
        try {
            int ep = Integer.parseInt(ani.getEpisodes());
            CallableStatement cs = getConnection().prepareCall(query);
            cs.setString(1, ani.getNameAimeSeries());
            cs.setString(2, ani.getGender());
            cs.setInt(3, ep);
            cs.setString(4, ani.getSinopse());
            cs.setString(5, ani.getNote());
            cs.setString(6, ani.getComments());
            cs.executeQuery();
            return true;
        } catch (NumberFormatException | SQLException e) {
            System.out.println("CREATE ANIME, DAO" + e);
        }
        return false;
    }
}
