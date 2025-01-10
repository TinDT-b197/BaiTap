package com.example.btcuoiki;

import com.example.btcuoiki.Database.OrderDB;
import com.example.btcuoiki.Database.ProductDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private ImageView logo;
    @FXML
    private ImageView logo1;

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
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField order_search;
    @FXML
    private TextField product_search;


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        ImageView XIcon = new ImageView(new Image("D:/CODE/JAVA/BTCuoi KI/picture/X.png"));
        XIcon.setFitWidth(48);
        XIcon.setFitHeight(48);
        alert.setGraphic(XIcon);
        alert.showAndWait();
    }

    private void showAlertSuccesss(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        ImageView tickIcon = new ImageView(new Image("D:/CODE/JAVA/BTCuoi KI/picture/tick.png"));
        tickIcon.setFitWidth(48);
        tickIcon.setFitHeight(48);
        alert.setGraphic(tickIcon);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logo.setImage(new Image("D:/CODE/JAVA/BTCuoi KI/picture/t.png"));
        logo1.setImage(new Image("D:/CODE/JAVA/BTCuoi KI/picture/t.png"));

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
        name_cus_cl.setCellValueFactory(new PropertyValueFactory<Order, String>("NameCustomer"));
        phone_cl.setCellValueFactory(new PropertyValueFactory<Order, String>("Phone"));
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
        rootPane.setOnMouseClicked(event -> {
            if (!orderTable.equals(event.getTarget()) &&
                    !(event.getTarget() instanceof TableRow) &&
                    !(event.getTarget() instanceof TableCell) &&
                    !(event.getTarget() instanceof TextField)) {
                clearOrderTextFields();
            }
            if (!tableProduct.equals(event.getTarget()) &&
                    !(event.getTarget() instanceof TableRow) && !(event.getTarget() instanceof TableCell) && !(event.getTarget() instanceof TextField)) {
                clearProductTextFields();
            }
        });
        ProductSearch();
        OrderSearch();
    }

    private void clearOrderTextFields() {
        IdOrderText.clear();
        NameCustomerText.clear();
        PhoneText.clear();
        ID_Product_OrderText.clear();
        QuantityOrderText.clear();
        orderTable.getSelectionModel().clearSelection();
    }

    private void clearProductTextFields() {
        IdProductText.clear();
        NameProdcutText.clear();
        PriceText.clear();
        QuantityProductText.clear();
        tableProduct.getSelectionModel().clearSelection();
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
            if (id.isEmpty() || name.isEmpty() || phone.isEmpty() || productIdOr.isEmpty()) {
                showAlert("Lỗi", "Vui lòng kiểm tra lại đầu vào!");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Đầu vào không hợp lệ", "Vui lòng nhập số lượng hợp lệ!.");
            return;
        }
        for (Order existingOrder : orderList) {
            if (existingOrder.getId().equals(id)) {
                showAlert("Đơn hàng đã tồn tại!", "ID đơn hàng đã tồn tại: " + id);
                return;
            }
        }

        Product selectedProduct = findProductByID(productIdOr);
        if (selectedProduct == null) {
            showAlert("Không tìm thấy sản phẩm", "Không tìm thấy sản phẩm với ID: " + productIdOr);
            return;
        }
        if (selectedProduct.subtractQuantity(QuantityOrder)) {
            Order newOrder = new Order(id, name, phone, productIdOr, selectedProduct.getProductName(), QuantityOrder);
            orderList.add(newOrder);
            orderTable.setItems(orderList);
            tableProduct.refresh();
            OrderDB.getInstance().Add(newOrder);
            ProductDB.GetInstance().Update(selectedProduct);
        } else {
            showAlert("Hết hàng!", "Không còn hàng tồn kho cho sản phẩm: " + selectedProduct.getProductName());
        }

    }

    public void DeleteOrder(ActionEvent event) {
        Order selectedOrder = orderTable.getSelectionModel().getSelectedItem();
        orderList.remove(selectedOrder);
        Product selectedProduct = findProductByID(selectedOrder.getId());
        selectedProduct.addQuantity(selectedOrder.getQuantityOrder());
        tableProduct.refresh();
        OrderDB.getInstance().Remove(selectedOrder);
        ProductDB.GetInstance().Update(selectedProduct);
    }

    public void UpdateOrder(ActionEvent event) {
        String name;
        String phone;
        String ProductIDOr;
        String quantity;

        Order selectedOrder = orderTable.getSelectionModel().getSelectedItem();
        if (selectedOrder == null) {
            showAlert("Lỗi", "Không có đơn hàng nào!");
            return;
        }
        try {
            name = NameCustomerText.getText();
            phone = PhoneText.getText();
            ProductIDOr = ID_Product_OrderText.getText();
            quantity = QuantityOrderText.getText();

            if (name.isEmpty() || phone.isEmpty() || quantity.isEmpty() || ProductIDOr.isEmpty()) {
                showAlert("Lỗi", "Vui lòng kiểm tra lại đầu vào!");
                return;
            }
            int newquantity = Integer.parseInt(quantity);

            Product oldProduct = findProductByID(selectedOrder.getProductIdOr());
            if (oldProduct != null) {
                oldProduct.addQuantity(selectedOrder.getQuantityOrder());
            }

            Product newProduct = findProductByID(ProductIDOr);
            if(newProduct == null) {
                showAlert("Lỗi","Không tìm thấy sản phẩm với id: " + ProductIDOr);
                return;
            }
            if (!newProduct.subtractQuantity(newquantity)) {
                showAlert("Hết hàng", "Không còn hàng tồn kho cho sản phẩm " + newProduct.getProductName());
                if (oldProduct != null) {
                    oldProduct.subtractQuantity(selectedOrder.getQuantityOrder());
                }
                return;
            }
            selectedOrder.setNameCustomer(name);
            selectedOrder.setPhone(phone);
            selectedOrder.setProductIdOr(ProductIDOr);
            selectedOrder.setProductNameOrder(newProduct.getProductName());
            selectedOrder.setQuantityOrder(newquantity);
            orderTable.refresh();
            tableProduct.refresh();
            OrderDB.getInstance().Update(selectedOrder);
            ProductDB.GetInstance().Update(newProduct);
            showAlertSuccesss("Thành công!", "Bạn đã thay đổi đơn hàng thành công!");

            if (oldProduct != null) {
                ProductDB.GetInstance().Update(oldProduct);
            }
        } catch (NumberFormatException e) {
            showAlert("Đầu vào không hợp lệ", "Vui lòng nhập số lượng hợp lệ!.");
        }
    }

    public void AddProduct(ActionEvent event) {
        String productID;
        String name;
        String price;
        int quantity;
        try {
            productID = IdProductText.getText();
            name = NameProdcutText.getText();
            price = PriceText.getText();
            quantity = Integer.parseInt(QuantityProductText.getText());
            if (productID.isEmpty() || name.isEmpty() || price.isEmpty()) {
                showAlert("Lỗi", "Vui lòng kiểm tra lại đầu vào!");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Lỗi", "Đầu vào không hợp lệ!");
            return;
        }
        for (Product existingProduct : productList) {
            if (existingProduct.getProductID().equals(productID)) {
                showAlert("Lỗi!", "Đã tồn tại sản phẩm với ID: " + productID);
                return;
            }
        }
        Product newProduct = new Product(productID, name, price, quantity);
        productList.add(newProduct);
        ProductDB.GetInstance().Add(newProduct);
        tableProduct.refresh();
    }

    public void DeleteProduct(ActionEvent event) {
        Product selectedProduct = tableProduct.getSelectionModel().getSelectedItem();
        productList.remove(selectedProduct);
        ProductDB.GetInstance().Remove(selectedProduct);
    }

    public void UpdateProduct(ActionEvent event) {
        String productName;
        String price;
        String quantity;
        try {
            productName = NameProdcutText.getText();
            price = PriceText.getText();
            quantity = QuantityProductText.getText();
        } catch (NumberFormatException e) {
            showAlert("Lỗi", "Đầu vào không hợp lệ!");
            return;
        }
        Product selectedProduct = tableProduct.getSelectionModel().getSelectedItem();
        if (selectedProduct == null) {
            showAlert("Lỗi", "Không có sản phẩm nào!");
            return;
        }
        if (productName.isEmpty() || price.isEmpty() || quantity.isEmpty()) {
            showAlert("Lỗi", "Vui lòng kiểm tra lại đầu vào!");
            return;
        }
        selectedProduct.setProductName(productName);
        selectedProduct.setPrice(price);
        selectedProduct.setQuantity(Integer.parseInt(quantity));
        tableProduct.refresh();
        ProductDB.GetInstance().Update(selectedProduct);
        showAlertSuccesss("Thành công", "Bạn đã thay đổi sản phẩm thành công!");
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
    public void ProductSearch(){
        FilteredList<Product> productFilteredList = new FilteredList<>(productList, e -> true);
        product_search.textProperty().addListener((observable, oldValue, newValue) -> {
            productFilteredList.setPredicate(product -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String ProductName = newValue.toLowerCase();
                if(product.getProductName().toLowerCase().contains(ProductName)){
                    return true;
                }
                else {
                    return false;
                }
            });
        });
        tableProduct.setItems(productFilteredList);
    }
    public void OrderSearch() {
        FilteredList<Order> orderFileredList = new FilteredList<>(orderList, e -> true);
        order_search.textProperty().addListener((observable, oldValue, newValue) -> {
            orderFileredList.setPredicate(order -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();
                if (order.getId().toLowerCase().contains(searchKey)) {
                    return true;
                }else {
                    return false;
                }
            });
        });
        orderTable.setItems(orderFileredList);
    }
}
