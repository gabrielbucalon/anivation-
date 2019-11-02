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
import java.time.LocalDate;
import java.util.ResourceBundle;
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
    private DatePicker drop_Data;
    @FXML
    private Button btn_Enviar;
    @FXML
    private Button btn_Cancelar;

    Stage dialogStage = new Stage();
    Scene scene;

    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    //String nome;
    //String apelido;
    //String email;    
    //String senha;
    //String data;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
       String nome = txt_NomeCompleto.getText();
       String senha = txt_senha.getText();
       String apelido = txt_Apelido.getText();
       String email = txt_Email.getText();
       LocalDate data = drop_Data.getValue();
        System.out.println(data);
    }
    
}
