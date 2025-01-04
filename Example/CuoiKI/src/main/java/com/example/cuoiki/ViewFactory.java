package com.example.cuoiki;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {
    private AnchorPane dashboardView;

    public ViewFactory() {}

    public AnchorPane getDashboardView() {
        if(dashboardView == null) {
            try{
                dashboardView = new FXMLLoader(getClass().getResource("Dashboard.fxml" )).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return dashboardView;
    }
    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        createStage(loader);
    }
    public void showClientWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Mama BANK");
        stage.show();
    }
}
