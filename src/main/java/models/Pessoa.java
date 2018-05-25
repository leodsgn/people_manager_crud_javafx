package models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
    private SimpleStringProperty nome;
    private SimpleDateFormat dataNascimento;
    private SimpleDoubleProperty altura;
    private SimpleDoubleProperty peso;

    public Pessoa(String pNome, SimpleDateFormat pDataNacimento, Double pAltura, Double pPeso) {
        this.nome = new SimpleStringProperty(pNome);
        this.dataNascimento = pDataNacimento;
        this.altura = new SimpleDoubleProperty(pAltura);
        this.peso = new SimpleDoubleProperty(pPeso);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public SimpleDateFormat getDataNascimento() {
        return dataNascimento;
    }

    public double getAltura() {
        return altura.get();
    }

    public SimpleDoubleProperty alturaProperty() {
        return altura;
    }

    public double getPeso() {
        return peso.get();
    }

    public SimpleDoubleProperty pesoProperty() {
        return peso;
    }

    public void setNome(String pNome) {
        this.nome.set(pNome);
    }

    public void setDataNascimento(SimpleDateFormat pDataNascimento) {
        this.dataNascimento = pDataNascimento;
    }

    public void setAltura(double pAltura) {
        this.altura.set(pAltura);
    }

    public void setPeso(double pPeso) {
        this.peso.set(pPeso);
    }
}

