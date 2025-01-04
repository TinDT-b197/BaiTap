package com.example.btcuoiki;

import com.example.btcuoiki.Database.OrderDB;
import com.example.btcuoiki.Database.ProductDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
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


    @FXML
    private TableView<Order> orderTable;
    @FXML
    private TableColumn<Order, String> id_or_cl;
    @FXML
    private TableColumn<Order, String> name_cus_cl;
    @FXML
    private TableColumn<Order, String> phone_cl;
    @FXML
    private TableColumn<Order, String> Id_productor_cl;
    @FXML
    private TableColumn<Order, String> name_product_order_cl;
    @FXML
    private TableColumn<Order, Integer> quantity_order_cl;


    @FXML
    private TextField IdOrderText;
    @FXML
    private TextField NameCustomerText;
    @FXML
    private TextField PhoneText;

    @FXML
    private TextField QuantityOrderText;
    @FXML
    private TextField ID_Product_OrderText;
    private ObservableList<Order> orderList;
    private ObservableList<Product> productList;

    @FXML
    private AnchorPane Warehouse;
    @FXML
    private AnchorPane Order;


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productList = FXCollections.observableArrayList(
                ProductDB.GetInstance().selectAll()
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

        orderList = FXCollections.observableArrayList(
                OrderDB.getInstance().selectAll()
        );
        id_or_cl.setCellValueFactory(new PropertyValueFactory<Order, String>("Id"));
        name_cus_cl.setCellValueFactory(new PropertyValueFactory<Order,String>("NameCustomer"));
        phone_cl.setCellValueFactory(new PropertyValueFactory<Order,String>("Phone"));
        Id_productor_cl.setCellValueFactory(new PropertyValueFactory<Order, String>("ProductIdOr"));
        name_product_order_cl.setCellValueFactory(new PropertyValueFactory<Order, String>("productNameOrder"));
        quantity_order_cl.setCellValueFactory(new PropertyValueFactory<Order, Integer>("QuantityOrder"));
        orderTable.setItems(orderList);

        orderTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                IdOrderText.setText(newSelection.getId());
                NameCustomerText.setText(newSelection.getNameCustomer());
                PhoneText.setText(newSelection.getPhone());
                ID_Product_OrderText.setText(newSelection.getProductIdOr());
                QuantityOrderText.setText(String.valueOf(newSelection.getQuantityOrder()));


            }
        });
    }
    public void AddOrder(ActionEvent event) {

        int QuantityOrder;
        String id;
        String name;
        String phone;
        String productIdOr;
        try {

        id = IdOrderText.getText();
        name = NameCustomerText.getText();
        phone = PhoneText.getText();
        productIdOr = ID_Product_OrderText.getText();
        QuantityOrder = Integer.parseInt(QuantityOrderText.getText());
        } catch (NumberFormatException e) {
            showAlert("Đầu vào không hợp lệ", "Vui lòng nhập số lượng hợp lệ!.");
            return;
        }
        Product selectedProduct = findProductByID(productIdOr);

        if(selectedProduct != null) {
            if(selectedProduct.subtractQuantity(QuantityOrder)){
                Order newOrder = new Order(id,name,phone,productIdOr,selectedProduct.getProductName(),QuantityOrder);
                orderList.add(newOrder);
                orderTable.setItems(orderList);
                tableProduct.refresh();
                OrderDB.getInstance().Add(newOrder);
            }
            else{
                showAlert("Hết hàng!", "Không còn hàng tồn kho cho sản phẩm: "+ selectedProduct.getProductName());
            }
        }
        else{
            showAlert("Không tìm thấy sản phẩm","Không tìm thấy sản phẩm với ID: "+ id);
        }
    }
    public void DeleteOrder(ActionEvent event) {
        Order selectedOrder = orderTable.getSelectionModel().getSelectedItem();
        orderList.remove(selectedOrder);
        Product selectedProduct = findProductByID(selectedOrder.getId());
        selectedProduct.addQuantity(selectedOrder.getQuantityOrder());
        tableProduct.refresh();
        OrderDB.getInstance().Remove(selectedOrder);
    }
    public void UpdateOrder(ActionEvent event) {
        Order selectedOrder = orderTable.getSelectionModel().getSelectedItem();
        Product selectedProduct = findProductByID(selectedOrder.getId());

        if (selectedOrder != null) {
            selectedProduct.reduceQuantity(selectedOrder.getQuantityOrder());
            String productID = IdOrderText.getText();
            String name = NameCustomerText.getText();
            String phone = PhoneText.getText();
            String ProductIDOr = ID_Product_OrderText.getText();
            String quantity = QuantityOrderText.getText();
            if (!productID.isEmpty()  && !name.isEmpty() && !phone.isEmpty() && !quantity.isEmpty() && !ProductIDOr.isEmpty() ) {
                selectedOrder.setId(productID);
                selectedOrder.setNameCustomer(name);
                selectedOrder.setPhone(phone);
                selectedOrder.setProductIdOr(ProductIDOr);
                selectedOrder.setQuantityOrder(Integer.parseInt(quantity));
                selectedProduct.subtractQuantity(selectedOrder.getQuantityOrder());
                orderTable.refresh();
                tableProduct.refresh();
                OrderDB.getInstance().Update(selectedOrder);
            }else {
                showAlert("Lỗi", "Vui lòng thử lại!");
            }
        } else {
            showAlert("Lỗi","Không có đơn hàng nào!");
        }
    }
    public void AddProduct(ActionEvent event) {
        Product newProduct = new Product();
        newProduct.setProductID(IdProductText.getText());
        newProduct.setProductName(NameProdcutText.getText());
        newProduct.setPrice(PriceText.getText());
        newProduct.setQuantity(Integer.parseInt(QuantityProductText.getText()));
        productList.add(newProduct);
        ProductDB.GetInstance().Add(newProduct);
    }

    public void DeleteProduct(ActionEvent event) {
        Product selectedProduct = tableProduct.getSelectionModel().getSelectedItem();
        productList.remove(selectedProduct);
        ProductDB.GetInstance().Remove(selectedProduct);
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
                ProductDB.GetInstance().Update(selectedProduct);
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
    public void ShowOrderView(ActionEvent event) {
        Order.setVisible(true);
        Warehouse.setVisible(false);
    }
    public void ShowWarehouseView(ActionEvent event) {
        Warehouse.setVisible(true);
        Order.setVisible(false);
    }
    private Product findProductByID(String productID) {
        for (Product product : productList) {
            if (product.getProductID().equals(productID)) {
                return product;
            }
        }
        return null;
    }

}
