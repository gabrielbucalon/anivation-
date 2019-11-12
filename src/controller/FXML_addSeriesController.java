/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Gabriel Bucalon
 */
public class FXML_addSeriesController implements Initializable {

    @FXML
    private TextField txtSearchtxtAnimeGenre;
    @FXML
    private TextField txtAnimeName;
    @FXML
    private TextField txtAnimeEpisodes;
    @FXML
    private TextArea txtAnimeSynopsis;
    @FXML
    private TextArea txtAnimeComment;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void createAnime(){
        
    }
    
    @FXML
    private void backToPage(){
            
    }
    
    @FXML
    private void clearFields(){
       
    }

}
