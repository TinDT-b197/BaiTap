package com.example.cuoiki;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerDashboard implements Initializable {
    public Text user_name;
    public Label login_date;
    public Label checking_bal;
    public Label checking_acc_num;
    public Label saving_bal;
    public Label saving_acc_num;
    public Label Income_lbl;
    public Label Expenses_lbl;
    public ListView transactions_list;
    public TextField payee_address;
    public TextField amount_sent;
    public TextField message;
    public Button sent_money;

    public void initialize(URL url, ResourceBundle rb) {}
}

