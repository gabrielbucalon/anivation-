/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AnimeSeriesDAOImpl;
import DAO.DAOConnection;
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
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AniSeries;
import utils.messagesImpl;

/**
 *
 * @author Gabriel Bucalon
 */
public class FXMLDocumentController extends AnimeSeriesDAOImpl implements Initializable {

    @FXML
    private Label lblAnimes;
    @FXML
    private Pane paneSearchAnimes;
    @FXML
    private Pane panelBestAnimes;
    @FXML
    private Pane panelAllAnimes;
    @FXML
    private TextField txtSearchAnime;
    @FXML
    private Button btnFetchAnime;
    @FXML
    private TableView<AniSeries> table;
    @FXML
    private TableColumn<AniSeries, String> idAniSeries;
    @FXML
    private TableColumn<AniSeries, String> seriesName;
    @FXML
    private TableColumn<AniSeries, String> seriesNote;

    ObservableList<AniSeries> list = FXCollections.observableArrayList();

    Connection conn = null;
    PreparedStatement preparedStatement = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conn = DAOConnection.getConnection();
            fetchData("SELECT * FROM VW_ALL_SERIES;");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fetchData(String _sql) throws ClassNotFoundException {
        ResultSet rs = getInfTables(_sql);
        getAni(rs);
    }
    
    @FXML
    public void onClickEvent(){
        AniSeries a = table.getSelectionModel().getSelectedItem();
        messagesImpl.infoBox(null, "Informações do Anime/Mangá","Nome anime : " + a.getSeriesName() + "\nNota do Anime : " + a.getSeriesNote());
    }

    public void getAni(ResultSet rs) {
        list.clear();
        try {
            int i = 1;
            while (rs.next()) {
                String str = Integer.toString(i++);
                list.add(new AniSeries(str, rs.getString("seriesName"), rs.getString("seriesNote")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        idAniSeries.setCellValueFactory(new PropertyValueFactory<>("idAniSeries"));
        seriesName.setCellValueFactory(new PropertyValueFactory<>("seriesName"));
        seriesNote.setCellValueFactory(new PropertyValueFactory<>("seriesNote"));
        table.setItems(list);
        
    }

    @FXML
    private void actionBtnAllAnimes(ActionEvent event) throws ClassNotFoundException {
        lblAnimes.setText("Todos Animes");
        fetchData("SELECT * FROM VW_ALL_SERIES;");
        lblAnimes.setTextFill(BLUE);
        panelAllAnimes.setStyle("-fx-background-color: #6572bc;");
        paneSearchAnimes.setStyle("-fx-background-color: #d3d3d3;");
        panelBestAnimes.setStyle("-fx-background-color: #d3d3d3;");
        btnFetchAnime.setVisible(false);
        txtSearchAnime.setVisible(false);
    }

    @FXML
    private void actionBestAnimes() throws ClassNotFoundException {
        lblAnimes.setText("Melhores Animes");
        fetchData("SELECT * FROM VW_BEST_SERIES;");
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
    private void actionSearchAnime() throws ClassNotFoundException, SQLException {
        String _sql = "CALL PROC_SEARCH_ANIME(?);";
        preparedStatement = getConnection().prepareStatement(_sql);
        preparedStatement.setString(1, txtSearchAnime.getText());
        ResultSet rs = preparedStatement.executeQuery();
        getAni(rs);
    }

}
