/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

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

    Stage dialogStage = new Stage();
    Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void createAnime() {

    }

    @FXML
    private void backToPage(ActionEvent event) {
        Node source = (Node) event.getSource(); // Pega o evento do botão
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
    }

    @FXML
    private void clearFields() {
        txtAnimeComment.clear();
        txtAnimeEpisodes.clear();
        txtAnimeName.clear();
        txtAnimeSynopsis.clear();
        txtSearchtxtAnimeGenre.clear();
    }

}
