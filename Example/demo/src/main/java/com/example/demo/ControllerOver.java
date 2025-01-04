package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.text.TabableView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerOver {
    @FXML
    private TableView<Student> table;
    @FXML
    private TableColumn<Student, String> nameCl;
    @FXML
    private TableColumn<Student, String> yearCl;
    @FXML
    private TableColumn<Student, String> genderCl;
    @FXML
    private TableColumn<Student, String> gradeCl;

    public void setStudent(Student student) {
        nameCl.setText(student.getName());
        yearCl.setText(student.getYear());
        genderCl.setText(student.getGender());
        gradeCl.setText(student.getGrade());
    }

    public void AddNV(ActionEvent e) throws IOException {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("NhapTen.fxml"));
        Parent NhapTen = fxmlLoader.load();
        Scene scene = new Scene(NhapTen);
        stage.setScene(scene);
        stage.show();
    }
    public void EditNV(ActionEvent e) throws IOException {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Edit.fxml"));
        Parent Edit = fxmlLoader.load();
        Scene scene = new Scene(Edit);
        stage.setScene(scene);
        stage.show();
    }
    public void DeleteNV(ActionEvent e) throws IOException {
        
    }

}
