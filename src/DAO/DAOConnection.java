package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gabriel Bucalon
 */
public class DAOConnection{

    public static Connection getConnection() { // metodo para conexão com banco de dados
        Connection conn = null;
        try { // Tentando conectar com banco de dados
            //Passagem de parametros para conexão com banco de dados
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anivation?useTimezone=true&serverTimezone=UTC", "root", "123456");
        } catch (SQLException err) {
            System.out.println("Erro" + err); // mensagem no console com erro
        }
        return conn; // retornando a conexão, mesmo certo ou errado.
    }
}
