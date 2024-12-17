package controller;

import CRUD.CRUDUser;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Barang;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class CRUDPageController {

    FileChooser fileChooser = new FileChooser();


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Barang> tableviewCRUD;

    @FXML
    private TableColumn<Barang, String> lokasiColumn;

    @FXML
    private TableColumn<Barang, String> namaBarangColumn;

    @FXML
    private TableColumn<Barang, String> statusColumn;

    @FXML
    private TableColumn<Barang, String> waktuColumn;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField textBarang;

    @FXML
    private TextArea textDeskripsi;

    @FXML
    private TextField textLokasi;

    @FXML
    private DatePicker textWaktu;

    @FXML
    void toMainPage(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/homepage.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/resources/mainPage.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    public void initialize() {


        //selected
        tableviewCRUD.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                textBarang.setText(newValue.getNama_barang());
                textDeskripsi.setText(newValue.getDeskripsi());
                textLokasi.setText(newValue.getLokasi());
                textWaktu.setValue(newValue.getWaktu_kehilangan());
                imageView.setImage(newValue.getImage());
            }

            tableviewCRUD.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2) { // Klik dua kali
                    tableviewCRUD.getSelectionModel().clearSelection();
                    textBarang.clear();
                    textDeskripsi.clear();
                    textLokasi.clear();
                    textWaktu.setValue(null);
                    imageView.setImage(null);
                }
            });

        });

        CRUDUser user = new CRUDUser();

        List<Barang> bList = user.showData();
        //konversi ke observable list
        ObservableList<Barang> observableList = FXCollections.observableArrayList(bList);
        tableviewCRUD.setItems(observableList);



        tableviewCRUD.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Konfigurasi semua kolom agar bisa menyesuaikan ukuran
        namaBarangColumn.setResizable(true);
        namaBarangColumn.setMaxWidth(Double.MAX_VALUE);

        lokasiColumn.setResizable(true);
        lokasiColumn.setMaxWidth(Double.MAX_VALUE);

        statusColumn.setResizable(true);
        statusColumn.setMaxWidth(Double.MAX_VALUE);

        // Description column (readonly)
        namaBarangColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNama_barang()));

        // Lokasi
        lokasiColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLokasi()));

        // Waktu Kehilangan
        waktuColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWaktu_kehilangan().toString()));


    }
    @FXML
    void tambahData(MouseEvent event) {
        CRUDUser user = new CRUDUser();
        LocalDate waktuKehilangan = textWaktu.getValue();
       int result =  user.addData(new Barang(textBarang.getText(),textDeskripsi.getText(),textLokasi.getText(),waktuKehilangan,imageView.getImage()));

        if (result == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informasi");
            alert.setHeaderText(null);
            alert.setContentText("Data telah berhasil ditambahkan!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Kesalahan");
            alert.setHeaderText(null);
            alert.setContentText("Terjadi kesalahan saat menambahkan data!");
            alert.showAndWait();
        }

        List<Barang> bList = user.showData();
        //konversi ke observable list
        ObservableList<Barang> observableList = FXCollections.observableArrayList(bList);
        tableviewCRUD.setItems(observableList);


    }

    @FXML
    void hapusData(MouseEvent event) {
        Barang selected;
        selected = tableviewCRUD.getSelectionModel().getSelectedItem();
        //debug
        //System.out.println(selected);

        CRUDUser user = new CRUDUser();
        int result = user.delData(selected);

        if (result == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informasi");
            alert.setHeaderText(null);
            alert.setContentText("Barang berhasil dihapus!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Kesalahan");
            alert.setHeaderText(null);
            alert.setContentText("Terjadi kesalahan saat menghapus data!");
            alert.showAndWait();
        }

        List<Barang> bList = user.showData();
        ObservableList<Barang> observableList = FXCollections.observableArrayList(bList);
        tableviewCRUD.setItems(observableList);

    }

    @FXML
    void updateData(MouseEvent event) {
        Barang selected;
        selected = tableviewCRUD.getSelectionModel().getSelectedItem();
        System.out.println(selected);

        selected.setNama_barang(textBarang.getText());
        selected.setDeskripsi(textDeskripsi.getText());
        selected.setLokasi(textLokasi.getText());
        LocalDate waktuKehilangan = textWaktu.getValue();
        selected.setWaktu_kehilangan(waktuKehilangan);
        selected.setImage(imageView.getImage());

        CRUDUser user = new CRUDUser();
        int result = user.updateData(selected);

        if (result == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informasi");
            alert.setHeaderText(null);
            alert.setContentText("Barang berhasil diperbaharui!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Kesalahan");
            alert.setHeaderText(null);
            alert.setContentText("Terjadi kesalahan saat memperbaharui data!");
            alert.showAndWait();
        }

        List<Barang> bList = user.showData();
        ObservableList<Barang> observableList = FXCollections.observableArrayList(bList);
        tableviewCRUD.setItems(observableList);

    }





    @FXML
    void uploudGambar(MouseEvent event) {
        File file = fileChooser.showOpenDialog(new Stage());
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        if (file != null) {
            // Buat Image dari file yang dipilih dan tampilkan di ImageView
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    }
}
