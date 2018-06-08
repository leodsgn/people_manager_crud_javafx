package models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class Person extends BaseModel {
    private SimpleStringProperty name;
    private Date dataNascimento;
    private SimpleDoubleProperty altura;
    private SimpleDoubleProperty peso;

    public Person(SimpleStringProperty name, Date dataNascimento, SimpleDoubleProperty altura, SimpleDoubleProperty peso) {
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.peso = peso;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getAltura() {
        return altura.get();
    }

    public SimpleDoubleProperty alturaProperty() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura.set(altura);
    }

    public double getPeso() {
        return peso.get();
    }

    public SimpleDoubleProperty pesoProperty() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso.set(peso);
    }
}
