/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import sun.security.util.Password;

public class FXMLCadastroUsuarioController extends DAO.DAOConnection implements Initializable {

    
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

    String nome;
    String apelido;
    String email;    
    String senha;
    String data;
    
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
    
    public void btnCancelarCadastro(ActionEvent event){
        Node source = (Node) event.getSource(); // Pega o evento do botão
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        start(dialogStage);
    }
    
    @FXML
    public void btnEnviarCadastro(ActionEvent event){
        nome = txt_NomeCompleto.getText();        
        apelido = txt_Apelido.getText();
        email = txt_Email.getText();
        senha = txt_senha.getText();
        data = drop_Data.getText();       
                
        try {
            conn = getConnection();
            String _sql = "INSERT INTO aniUser(fullName, nicknameUser, email, password, birthDate) VALUES(?,?,?,?,?)";

            preparedStatement = conn.prepareStatement(_sql);
            preparedStatement.setString(1,nome);
            preparedStatement.setString(2, apelido);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, senha);
            preparedStatement.setString(5, data);
            preparedStatement.executeUpdate();
            
            Node source = (Node) event.getSource(); // Pega o evento do botão
            dialogStage = (Stage) source.getScene().getWindow();
            dialogStage.close();
            start(dialogStage);                          
              
        } catch (Exception err) {
            // messages.infoBoxErr("Não foi possível entrar\nTente novamente", "ERRO!", null);
            System.out.println("Ops, não deu para cadastrar " + err);
        }
       
        System.out.println(nome);       
        System.out.println(apelido);
        System.out.println(email);
        System.out.println(senha);
        System.out.println(data);
    }
   
}
