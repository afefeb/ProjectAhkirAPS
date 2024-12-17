package controller;

import CRUD.CRUDUser;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import model.Barang;

import java.util.List;

public class TableViewController {
    @FXML
    private TableView<Barang> tableView;
    @FXML
    private TableColumn<Barang, Image> imageColumn;
    @FXML
    private TableColumn<Barang, String> descriptionColumn;
    @FXML
    private TableColumn<Barang, String> namaBarangColumn;
    @FXML
    private TableColumn<Barang, String> lokasiColumn;
    @FXML
    private TableColumn<Barang, String> waktuKehilanganColumn;
    @FXML
    private TableColumn<Barang, String> statusColumn;

    @FXML
    public void initialize() {

        CRUDUser user = new CRUDUser();
        List<Barang> bList = user.showData();
        //konversi ke observable list
        ObservableList<Barang> observableList = FXCollections.observableArrayList(bList);
        tableView.setItems(observableList);



        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Konfigurasi semua kolom agar bisa menyesuaikan ukuran
        namaBarangColumn.setResizable(true);
        namaBarangColumn.setMaxWidth(Double.MAX_VALUE);

        descriptionColumn.setResizable(true);
        descriptionColumn.setMaxWidth(Double.MAX_VALUE);

        lokasiColumn.setResizable(true);
        lokasiColumn.setMaxWidth(Double.MAX_VALUE);

        waktuKehilanganColumn.setResizable(true);
        waktuKehilanganColumn.setMaxWidth(Double.MAX_VALUE);

        statusColumn.setResizable(true);
        statusColumn.setMaxWidth(Double.MAX_VALUE);

        // Description column (readonly)
        namaBarangColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNama_barang()));

        descriptionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDeskripsi()));
        // Lokasi
        lokasiColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLokasi()));

        // Waktu Kehilangan
        waktuKehilanganColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWaktu_kehilangan().toString()));

        imageColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getImage()));

//      statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        // Image column (readonly)
        imageColumn.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Barang, Image> call(TableColumn<Barang, Image> param) {
                return new TableCell<>() {
                    private final ImageView imageView = new ImageView();

                    @Override
                    protected void updateItem(Image image, boolean empty) {
                        super.updateItem(image, empty);
                        if (empty || image == null) {
                            setGraphic(null);
                        } else {
                            imageView.setImage(image);
                            imageView.setFitWidth(50);
                            imageView.setFitHeight(50);
                            setGraphic(imageView);
                        }
                    }
                };
            }
        });

    }

}
