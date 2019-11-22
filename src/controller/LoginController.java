/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

public class LoginController extends DAO.DAOConnection implements Initializable {

    @FXML
    private TextField txt_Usuario;
    @FXML
    private PasswordField txt_senha;
    @FXML
    private Button btn_entrar;

    Stage dialogStage = new Stage();
    Scene scene;

    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    String usuario;
    String senha;

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
        conn = getConnection();
    }

    public void start(Stage primaryStage, int i) {
        if (i == 1) {
            try {
                primaryStage.close();
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/FXMLDocument.fxml"));
                Scene scene = new Scene(root, 600, 600);
                //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
                //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
            //lblRequiredUser.setVisible(true); // Caso ele não digite os dois, mostrara as duas labels
            //lblRequiredPassword.setVisible(true);
        } else if (txt_senha.getText().equals("")) {
            //lblRequiredPassword.setVisible(true); // Caso usuário não digitar a senha, mostrara essa label
        } else if (txt_Usuario.getText().equals("")) {
            System.out.println("entrou nos dois nulos");
            //lblRequiredUser.setVisible(true); // Mesma coisa na condição do usuário
        } else {
            // Label's fica invisível
            //lblRequiredUser.setVisible(false);
            //lblRequiredPassword.setVisible(false);
            try {
                preparedStatement = conn.prepareStatement(_sql);
                preparedStatement.setString(1, usuario);
                preparedStatement.setString(2, senha);
                resultSet = preparedStatement.executeQuery();
                //Caso ele não encontre o usuario, entrara nessa condição
                if (!resultSet.next()) {
                    //lblUserNotFound.setVisible(true);
                } else {

                    // System.out.println("porra" + resultSet.getString("email"));
                    User user = new User();
                    user.setEmail(resultSet.getString("email"));
                    FXMLDocumentController.getUser(user);
                    System.out.println("oi");
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
