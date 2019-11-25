package DAO;

import static DAO.DAOConnection.getConnection;
import java.sql.PreparedStatement;
import model.User;

/**
 *
 * @author Gabriel Bucalon
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public boolean create(String query, User user) {
        System.out.println(user.getData());
        try {
            getConnection();
            PreparedStatement stmt = getConnection().prepareStatement(query);
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
