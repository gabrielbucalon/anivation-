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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.ORANGE;
import static javafx.scene.paint.Color.PURPLE;

/**
 *
 * @author Administrador
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label lblAnimes;
    @FXML
    private Pane paneSearchAnimes;
    @FXML
    private Pane panelBestAnimes;
    @FXML
    private Pane panelAllAnimes;
    @FXML
    private Pane searchAnime;
    @FXML
    private Button btnAllAnimes;
    @FXML
    private Button btnSearchAnime;
    @FXML
    private Button btnBestAnimes;
    @FXML
    private TextField txtSearchAnime;
    @FXML
    private Button btnFetchAnime;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void actionBtnAllAnimes(ActionEvent event) {
        lblAnimes.setText("Todos Animes");
        lblAnimes.setTextFill(BLUE);
        panelAllAnimes.setStyle("-fx-background-color: #6572bc;");
        paneSearchAnimes.setStyle("-fx-background-color: #d3d3d3;");
        panelBestAnimes.setStyle("-fx-background-color: #d3d3d3;");
        btnFetchAnime.setVisible(false);
        txtSearchAnime.setVisible(false);
    }

    @FXML
    private void actionBestAnimes() {
        lblAnimes.setText("Melhores Animes");
        lblAnimes.setTextFill(ORANGE);
        panelAllAnimes.setStyle("-fx-background-color: #d3d3d3;");
        paneSearchAnimes.setStyle("-fx-background-color: #d3d3d3;");
        panelBestAnimes.setStyle("-fx-background-color: #ffa500;");
        btnFetchAnime.setVisible(false);
        txtSearchAnime.setVisible(false);
    }

    @FXML
    private void actionSearchAnimes() {
        lblAnimes.setText("Buscar Anime");
        lblAnimes.setTextFill(PURPLE);
        panelAllAnimes.setStyle("-fx-background-color: #d3d3d3;");
        paneSearchAnimes.setStyle("-fx-background-color: #ad75ad;");
        panelBestAnimes.setStyle("-fx-background-color: #d3d3d3;");
        btnFetchAnime.setVisible(true);
        txtSearchAnime.setVisible(true);
    }

    @FXML
    private void actionSearchAnime() {
        
    }

}
