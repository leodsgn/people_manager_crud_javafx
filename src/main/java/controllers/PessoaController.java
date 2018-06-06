package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Pessoa;
import services.PessoaServiceArquivo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class PessoaController {
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtPeso;
    @FXML
    private TextField txtAltura;
    @FXML
    private DatePicker dataNascimento;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnAtualizar;
    @FXML
    private Button btnApagar;
    @FXML
    private Button btnLimpar;
    private PessoaServiceArquivo pessoaService;


    public TextField getTxtNome() {
        return txtNome;
    }

    public TextField getTxtPeso() {
        return txtPeso;
    }

    public TextField getTxtAltura() {
        return txtAltura;
    }

    public DatePicker getDataNascimento() {
        return dataNascimento;
    }

    public void salvar(TableView<Pessoa> listPessoa) {
        Pessoa pessoa = getDadosPessoa(null);
        pessoaService.salvar(pessoa);
        atualizaDadosTabela(listPessoa);
    }

    public void atualizar(TableView<Pessoa> listPessoa) {
        Pessoa pessoaSelected = listPessoa.getSelectionModel().getSelectedItem();
        getDadosPessoa(pessoaSelected);
        pessoaService.atualizar(pessoaSelected);
        atualizaDadosTabela(listPessoa);
    }

    private void atualizaDadosTabela(TableView<Pessoa> listPessoa) {
        listPessoa.getItems().setAll(pessoaService.getListaPessoa());
        limpar(listPessoa);
    }

    public void limpar(TableView<Pessoa> listPessoa) {
        listPessoa.getSelectionModel().select(null);
        this.getTxtNome().setText("");
        this.getTxtAltura().setText("");
        this.getTxtPeso().setText("");
        this.getDataNascimento().setValue(null);
    }



    public Pessoa getDadosPessoa(Pessoa pPessoa){
        if(pPessoa == null){
            pPessoa = new Pessoa(this.getTxtNome().getText(), getDataAtual(this.getDataNascimento()),
                    Double.parseDouble(this.getTxtAltura().getText()),
                    Double.parseDouble(this.getTxtPeso().getText()));
        }else{
            pPessoa.setNome(this.getTxtNome().getText());
            pPessoa.setDataNascimento(getDataAtual(this.getDataNascimento()));
            pPessoa.setAltura(Double.parseDouble(this.getTxtAltura().getText()));
            pPessoa.setPeso(Double.parseDouble(this.getTxtPeso().getText()));
        }

        return pPessoa;
    }

    private Date getDataAtual(DatePicker pDate) {
        LocalDateTime time = pDate.getValue().atStartOfDay();
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }
}
