/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;

/**
 *
 * @author Administrador
 */
public interface RepositoryDAO {

    /**
     *
     * @return
     */
    //public Connection getConnection();
    public void getInfTables(String nameTable);
}
