package com.example.btcuoiki;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dashboard.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Quản lí cửa hàng");
        stage.getIcons().add(new Image("D:/CODE/JAVA/BTCuoi KI/picture/t.png"));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
