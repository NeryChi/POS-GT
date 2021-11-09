package com.nerypolar.posgt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Punto de Ventas - POS GT");
        Image icon = new Image(getClass().getResourceAsStream("/img/p.png"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
        }


    public static void main(String[] args) {
        launch();
    }
}