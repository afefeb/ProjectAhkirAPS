package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterPageController {

    private Scene scene;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnRegister"
    private Button btnRegister; // Value injected by FXMLLoader

    @FXML // fx:id="linkLogin"
    private Hyperlink linkLogin; // Value injected by FXMLLoader

    @FXML // fx:id="txtEmail"
    private TextField txtEmail; // Value injected by FXMLLoader

    @FXML // fx:id="txtPassword1"
    private PasswordField txtPassword1; // Value injected by FXMLLoader

    @FXML // fx:id="txtPassword2"
    private PasswordField txtPassword2; // Value injected by FXMLLoader

    @FXML // fx:id="txtUsername"
    private TextField txtUsername; // Value injected by FXMLLoader


    @FXML
    void toLoginPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void userRegister(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnRegister != null : "fx:id=\"btnRegister\" was not injected: check your FXML file 'RegisterPage.fxml'.";
        assert linkLogin != null : "fx:id=\"linkLogin\" was not injected: check your FXML file 'RegisterPage.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'RegisterPage.fxml'.";
        assert txtPassword1 != null : "fx:id=\"txtPassword1\" was not injected: check your FXML file 'RegisterPage.fxml'.";
        assert txtPassword2 != null : "fx:id=\"txtPassword2\" was not injected: check your FXML file 'RegisterPage.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'RegisterPage.fxml'.";

    }

}

