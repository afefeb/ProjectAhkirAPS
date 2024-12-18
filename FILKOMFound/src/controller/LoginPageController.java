package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import util.MySQLConnection;

public class LoginPageController {

    private Scene scene;


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnLogin"
    private Button btnLogin; // Value injected by FXMLLoader

    @FXML // fx:id="linkForgotPassword"
    private Hyperlink linkForgotPassword; // Value injected by FXMLLoader

    @FXML // fx:id="linkRegister"
    private Hyperlink linkRegister; // Value injected by FXMLLoader


    @FXML
    private Label loginMessageLabel;

    @FXML // fx:id="txtPassword"
    private PasswordField txtPassword; // Value injected by FXMLLoader

    @FXML // fx:id="txtUsername"
    private TextField txtUsername; // Value injected by FXMLLoader


    @FXML
    void toForgotPwdPage(ActionEvent event) {

    }

    @FXML
    void toRegisterPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/RegisterPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void userLogin(ActionEvent event) throws SQLException {
        if(txtUsername.getText().isBlank() == false && txtPassword.getText().isBlank() == false){
            validateLogin(event);
        } else{
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    void validateLogin(ActionEvent event) throws SQLException {
        MySQLConnection connectNow = new MySQLConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM pengguna WHERE username = '" + txtUsername.getText() + "' AND password = '" + txtPassword.getText() + "'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt(1) == 1){
                    loginMessageLabel.setText("Login Success");
                    toMainPage(event);
                } else{
                    loginMessageLabel.setText("Invalid Login. Please try again.");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    void toMainPage(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/homepage.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/resources/mainPage.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'LoginPage.fxml'.";
        assert linkForgotPassword != null : "fx:id=\"linkForgotPassword\" was not injected: check your FXML file 'LoginPage.fxml'.";
        assert linkRegister != null : "fx:id=\"linkRegister\" was not injected: check your FXML file 'LoginPage.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'LoginPage.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'LoginPage.fxml'.";

    }

}


