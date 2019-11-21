/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAOConnection.getConnection;
import java.sql.PreparedStatement;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.User;

/**
 *
 * @author Administrador
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public boolean create(String query, User user) {
        try {
            getConnection();
            PreparedStatement stmt = getConnection().prepareStatement(query);
            System.out.println(user.getNome());
            System.out.println(user.getApelido());
            System.out.println(user.getEmail());
            System.out.println(user.getSenha());
            System.out.println(user.getData());

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getApelido());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getSenha());
            stmt.setString(5, user.getData());
            stmt.executeUpdate();

            return true;
        } catch (Exception err) {
            // messages.infoBoxErr("Não foi possível entrar\nTente novamente", "ERRO!", null);
            System.out.println("Ops, não deu para cadastrar " + err);
        }
        return false;
    }

}
