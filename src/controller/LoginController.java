package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;

public class LoginController extends FXMLDocumentController implements Initializable {

    @FXML
    private TextField txt_Usuario;
    @FXML
    private PasswordField txt_senha;

    Stage dialogStage = new Stage();
    Scene scene;

    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //BD_URL = "jdbc:mysql://localhost:port/bd_name?useTimezone=true&serverTimezone=UTC;;;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LoginController() throws ClassNotFoundException {
        DAO.DAOConnection.getConnection();
    }

    public void start(Stage primaryStage, int i) {
        if (i == 1) {
            try {
                primaryStage.close();
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/FXMLDocument.fxml"));
                Scene scene = new Scene(root, 600, 600);
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (i == 2) {
            try {
                primaryStage.close();
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/FXMLCadastroUsuario.fxml"));
                Scene scene = new Scene(root, 600, 600);
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void actionLogar(ActionEvent event) {
        //Recebendo o que usuario digitou
        String usuario = txt_Usuario.getText();
        String senha = txt_senha.getText();

        //Consulta dos funcionarios
        String _sql = "SELECT * FROM aniUser WHERE nicknameUser = ? AND password = ?";

        if (txt_Usuario.getText().equals("") && txt_senha.getText().equals("")) {
        } else if (txt_senha.getText().equals("")) {
        } else if (txt_Usuario.getText().equals("")) {
            System.out.println("entrou nos dois nulos");
        } else {
            try {
                preparedStatement = DAO.DAOConnection.getConnection().prepareStatement(_sql);
                preparedStatement.setString(1, usuario);
                preparedStatement.setString(2, senha);
                resultSet = preparedStatement.executeQuery();
                //Caso ele não encontre o usuario, entrara nessa condição
                if (!resultSet.next()) {
                    //lblUserNotFound.setVisible(true);
                } else {
                    User user = new User();
                    user.setIdUser(resultSet.getString("idAniUser"));
                    setUser(user);
                    Node source = (Node) event.getSource(); // Pega o evento do botão
                    dialogStage = (Stage) source.getScene().getWindow();
                    dialogStage.close();
                    start(dialogStage, 1);
                }
            } catch (Exception err) {

                // messages.infoBoxErr("Não foi possível entrar\nTente novamente", "ERRO!", null);
                System.out.println("Ops, não deu para logar " + err);
            }
        }
    }

    public void linkCadastrarNovoUsuario(ActionEvent event) {
        Node source = (Node) event.getSource(); // Pega o evento do botão
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        start(dialogStage, 2);
    }

}
