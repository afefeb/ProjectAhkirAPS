package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    private Stage stage;
    private Scene scene;
    private Parent root;

//    @FXML
//    void toCRUDPage(ActionEvent actionEvent) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("/view/CRUDPage.fxml"));
//        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

//    @FXML
//    void toCRUDPage(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("/view/CRUDPage.fxml"));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    @FXML
//    void toCRUDPage(MouseEvent event) throws IOException  {
//
//    }

    @FXML
    private Button EditListButton;

    @FXML
    void toCRUDPage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CRUDPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toLoginPage(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/Loginpage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
