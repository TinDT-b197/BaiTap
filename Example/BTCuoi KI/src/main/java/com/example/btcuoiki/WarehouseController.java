package com.example.btcuoiki;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class WarehouseController implements Initializable {
    @FXML
    private TableView<Product> tableProduct;
    @FXML
    private TableColumn<Product, String> id_prodcut_cl;
    @FXML
    private TableColumn<Product, String> name_product_cl;
    @FXML
    private TableColumn<Product, String> price_cl;
    @FXML
    private TableColumn<Product, Integer> quantity_prodcut_cl;
    @FXML
    private TextField IdProductText;
    @FXML
    private TextField NameProdcutText;
    @FXML
    private TextField PriceText;
    @FXML
    private TextField QuantityProductText;

    private ObservableList<Product> productList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productList = FXCollections.observableArrayList(
                new Product("1", "Áo thun", "50000", 10),
                new Product("2", "QUần", "3000", 10)
        );
        id_prodcut_cl.setCellValueFactory(new PropertyValueFactory<Product, String>("productID"));
        name_product_cl.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        price_cl.setCellValueFactory(new PropertyValueFactory<Product, String>("Price"));
        quantity_prodcut_cl.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Quantity"));
        tableProduct.setItems(productList);

        tableProduct.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                IdProductText.setText(newSelection.getProductID());
                NameProdcutText.setText(newSelection.getProductName());
                PriceText.setText(newSelection.getPrice());
                QuantityProductText.setText((String.valueOf(newSelection.getQuantity())));
            }
        });
    }

    public void AddProduct(ActionEvent event) {
        Product newProduct = new Product();
        newProduct.setProductID(IdProductText.getText());
        newProduct.setProductName(NameProdcutText.getText());
        newProduct.setPrice(PriceText.getText());
        newProduct.setQuantity(Integer.parseInt(QuantityProductText.getText()));
        productList.add(newProduct);
    }

    public void DeleteProduct(ActionEvent event) {
        Product selectedProduct = tableProduct.getSelectionModel().getSelectedItem();
        productList.remove(selectedProduct);
    }

    public void UpdateProduct(ActionEvent event) {
        Product selectedProduct = tableProduct.getSelectionModel().getSelectedItem();

        if (selectedProduct != null) {
            String productID = IdProductText.getText();
            String productName = NameProdcutText.getText();
            String price = PriceText.getText();
            String quantity = QuantityProductText.getText();
            if (!productID.isEmpty() && !productName.isEmpty() && !price.isEmpty() && !quantity.isEmpty()) {
                selectedProduct.setProductID(productID);
                selectedProduct.setProductName(productName);
                selectedProduct.setPrice(price);
                selectedProduct.setQuantity(Integer.parseInt(quantity));
                tableProduct.refresh();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Input Error");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Selection Error No person selected!");
        }
    }
}
