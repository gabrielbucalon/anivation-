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
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddSeriesController extends DAO.DAOConnection implements Initializable {
    
    Stage dialogStage = new Stage();
    Scene scene;

    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
