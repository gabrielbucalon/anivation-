/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import model.AnimeReSeries;

/**
 *
 * @author Administrador
 */
public interface AnimeSeriesDAO {

    /**
     *
     * @param nameTable
     * @return
     */
    public ResultSet getInfTables(String nameTable);
    
    public boolean createAnime(String query, AnimeReSeries ani);
}
