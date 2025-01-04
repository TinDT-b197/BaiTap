package com.example.demo;

import com.almasb.fxgl.core.collection.Array;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class ControllerApp {
    @FXML
    private TextField Name;
    @FXML
    private TextField Year;
    @FXML
    private TextField Sdt;
    @FXML
    private TextField Note;

    ArrayList<Student>studentsList=new ArrayList<>();

    public void XacNhan(ActionEvent event) {
        Student student = new Student();
        student.setName(Name.getText());
        student.setYear(Year.getText());
        student.setGender(Sdt.getText());
        student.setGrade(Note.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Bạn đã thêm nhân viên thành công!");
        alert.show();
        studentsList.add(new Student());
    }

    public void goBack(ActionEvent e) throws IOException {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Overview.fxml"));
        Parent Overview = fxmlLoader.load();
        Scene scene = new Scene(Overview);
        ControllerOver controller = fxmlLoader.getController();
        stage.setScene(scene);
        stage.show();
    }
    public void XacNhan1(ActionEvent event) {
        String name = Name.getText();
        String year = Year.getText();
        String sdt = Sdt.getText();
        String note = Note.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Bạn đã chỉnh sửa nhân viên thành công!");
        alert.show();
    }
}
