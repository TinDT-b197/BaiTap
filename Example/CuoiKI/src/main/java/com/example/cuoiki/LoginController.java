package com.example.cuoiki;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private ChoiceBox type_select;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button login;


    public void initialize(URL url, ResourceBundle rb) {
        login.setOnAction(event -> Model.getInstance().getViewFactory().showClientWindow());
    }
}
