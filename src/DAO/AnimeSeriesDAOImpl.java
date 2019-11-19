package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Bucalon
 */
public class AnimeSeriesDAOImpl extends DAOConnection implements AnimeSeriesDAO {
    ResultSet rs = null;
    
    public AnimeSeriesDAOImpl(){
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
}
