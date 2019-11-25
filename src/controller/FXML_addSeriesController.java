package controller;

import DAO.AnimeSeriesDAOImpl;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import model.AnimeReSeries;

/**
 * FXML Controller class
 *
 * @author Gabriel Bucalon
 */
public class FXML_addSeriesController extends AnimeSeriesDAOImpl implements Initializable {

    @FXML
    private TextField txtAnimeGenre;
    @FXML
    private TextField txtAnimeName;
    @FXML
    private TextField txtAnimeEpisodes;
    @FXML
    private TextArea txtAnimeSynopsis;
    @FXML
    private TextArea txtAnimeComment;
    @FXML
    private ComboBox combNoteSeries;

    Stage dialogStage = new Stage();
    Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getNoteAnime();
    }

    @FXML
    private void createOneAnime(ActionEvent event) {
        AnimeReSeries ani = new AnimeReSeries();
        ani.setComments(txtAnimeComment.getText());
        ani.setEpisodes(txtAnimeEpisodes.getText());
        ani.setGender(txtAnimeGenre.getText());
        ani.setNameAimeSeries(txtAnimeName.getText());
        ani.setNote((String) combNoteSeries.getValue());
        ani.setSinopse(txtAnimeSynopsis.getText());
        ani.setIdUser(FXMLDocumentController.userIdInferno);
        System.out.println("ani.getId" + ani.getIdUser());
        boolean save = createAnime("SELECT FUNC_REGISTER_SERIES(?, ?, ?, ?, ?, ?,?)", ani);
        if (save) {
            backToPage(event);
            utils.messagesImpl.infoBox("Salvo", "Salvo!", "Cadastro Realizado com suceeso");
        } else {
            utils.messagesImpl.infoBox("Erro", "Erro!", "Problemas ao salvar o formulario");
        }
    }

    @FXML
    private void backToPage(ActionEvent event) {
        Node source = (Node) event.getSource(); // Pega o evento do botão
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
    }

    private void getNoteAnime() {
        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "1",
                        "2",
                        "3",
                        "4",
                        "5",
                        "6",
                        "7",
                        "8",
                        "9",
                        "10"
                );
        combNoteSeries.setItems(options);
    }
    
    private void getGenderAnime(){
            ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Shoujo",
                        "Bishoujo",
                        "Shounen",
                        "Bishounen",
                        "Kemono",
                        "Mecha",
                        "Ecchi",
                        "Gender Blender",
                        "Hentai",
                        "Gore",
                        "Aniparô",
                        "Vida Escolar",
                        "Harem"
                );
    }

    @FXML
    private void clearFields() {
        txtAnimeComment.clear();
        txtAnimeEpisodes.clear();
        txtAnimeName.clear();
        txtAnimeSynopsis.clear();
        txtAnimeGenre.clear();
    }

}
