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
    private TextField txtAnimeSynopsis;
    @FXML
    private TextField txtAnimeComment;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
