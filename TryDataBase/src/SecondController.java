import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SecondController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView panelGambar;


    public void switchToScene1(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void  initialize(){
        GambarDAO gambarDAO = new GambarDAO();
        Gambar gambar = gambarDAO.getGambarById(2); // ID gambar yang ingin ditampilkan

        if (gambar != null && gambar.getImageData() != null) {
            // Konversi byte array menjadi Image
            ByteArrayInputStream inputStream = new ByteArrayInputStream(gambar.getImageData());
            Image image = new Image(inputStream);

            // Set gambar ke ImageView
            panelGambar.setImage(image);
        } else {
            System.out.println("Gambar tidak ditemukan atau data gambar kosong.");
        }
    }
}
