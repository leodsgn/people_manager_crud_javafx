package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InitApp extends Application{
    public static void main(String[] args) {
        launch(InitApp.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/initappview.fxml"));
        Scene scene = new Scene(root, 645, 500);
        stage.setScene(scene);
        stage.setTitle("CRUD Pessoa");
        stage.show();
    }

}