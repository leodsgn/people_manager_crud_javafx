package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import models.Pessoa;

import java.net.URL;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    @FXML
    private TableView<Pessoa> tabelaPessoas;
    @FXML
    private TableColumn<Pessoa,String> nomeCol;
    @FXML
    private TableColumn<Pessoa,Integer> idadeCol;
    @FXML
    private TableColumn<Pessoa, Float> pesoCol;
    @FXML
    private TableColumn<Pessoa, Float> alturaCol;
    @FXML
    private TableColumn<Pessoa, Float> imcCol;


    private PessoaController pessoaController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
