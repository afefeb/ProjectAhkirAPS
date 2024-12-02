import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.EventObject;

public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ListView<User> listView;


    @FXML
    private Button tambahData;


    @FXML
    private TextField textNama;

    @FXML
    private TextField textPass;

    @FXML
    void tambahData(MouseEvent event) {
        UserDAO userDAO = new UserDAO();
        userDAO.addData(new User(textNama.getText(),textPass.getText()));
        ObservableList<User> uList = userDAO.showData();
        listView.setItems(uList);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informasi");
        alert.setHeaderText(null);
        alert.setContentText("Data telah berhasil ditambahkan!");
        alert.showAndWait(); // Menampilkan pop-up dan menunggu hingga ditutup
    }

    public void  initialize(){
        UserDAO uDao = new UserDAO();
        ObservableList<User> uList = uDao.showData();
        listView.setItems(uList);
    }

    @FXML
    void deleteData(MouseEvent event) {
        User selected;
        selected = listView.getSelectionModel().getSelectedItem();
        System.out.println(selected);

        UserDAO dao = new UserDAO();
        int result =  dao.delData(selected);
        if(result != 0){
            System.out.println("Delete Berhasil");
        }
        ObservableList<User> uList = dao.showData();
        listView.setItems(uList);
    }

    @FXML
    void updateData(MouseEvent event) {
        User selected;
        selected = listView.getSelectionModel().getSelectedItem();
        System.out.println(selected);

        selected.setPassword(textPass.getText());
        System.out.println(selected);

        UserDAO dao = new UserDAO();
        int result = dao.updateData(selected);
        if(result !=0){
            System.out.println("Berhasil Update");
        }
        ObservableList<User> uList = dao.showData();
        listView.setItems(uList);



    }



    public void switchToScene2(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("second.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
