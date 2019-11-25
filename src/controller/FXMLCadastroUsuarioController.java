package controller;

import DAO.UserDAOImpl;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import utils.messagesImpl;

public class FXMLCadastroUsuarioController extends UserDAOImpl implements Initializable {

    @FXML
    private TextField txt_NomeCompleto;
    @FXML
    private TextField txt_Apelido;
    @FXML
    private TextField txt_Email;
    @FXML
    private PasswordField txt_senha;
    @FXML
    private TextField drop_Data;
    @FXML
    private Button btn_Enviar;
    @FXML
    private Button btn_Cancelar;

    Stage dialogStage = new Stage();
    Scene scene;

    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLCadastroUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/FXML_Login.fxml"));
            Scene scene = new Scene(root, 600, 600);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnCancelarCadastro(ActionEvent event) {
        Node source = (Node) event.getSource(); // Pega o evento do botão
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        start(dialogStage);
    }

    @FXML
    public void btnEnviarCadastro(ActionEvent event) {
        User user = new User();
        user.setNome(txt_NomeCompleto.getText());
        user.setApelido(txt_Apelido.getText());
        user.setData(txt_Email.getText());
        user.setEmail(txt_senha.getText());
        user.setSenha(drop_Data.getText());
        boolean save = create("INSERT INTO aniUser(fullName, nicknameUser, email, password, birthDate) VALUES(?,?,?,?,?)", user);
        if (save) {
            messagesImpl.infoBox("Sucesso", "Cadastro realizado com sucesso", user.getNome() + "  Cadastro com sucesso" );
            Node source = (Node) event.getSource(); // Pega o evento do botão
            dialogStage = (Stage) source.getScene().getWindow();
            dialogStage.close();
            start(dialogStage);
            
        }else {
            messagesImpl.infoBoxErr("ERRO", "ERRO", "Não foi possivel realizar cadastro do usuário");
        }
    }
}
