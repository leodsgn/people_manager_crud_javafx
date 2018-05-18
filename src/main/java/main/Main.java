package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello world");
        Group root = new Group();

        Label label = new Label("Hello world");

        root.getChildren().addAll(label);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);

        primaryStage.show();
    }
}
