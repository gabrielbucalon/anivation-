/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.User;

/**
 *
 * @author Administrador
 */
public interface UserDAO {
    public boolean create(String query, User user);
}
