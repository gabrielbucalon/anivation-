/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AniSeries;

/**
 *
 * @author Administrador
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
