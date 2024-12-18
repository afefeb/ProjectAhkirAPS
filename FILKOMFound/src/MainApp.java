import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/homepage.fxml"));
//        Scene scene = new Scene(loader.load());
//        stage.setScene(scene);
//        scene.getStylesheets().add(getClass().getResource("/resources/mainPage.css").toExternalForm());
//        stage.setTitle("FILKOMFound");
//        stage.show();
//    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Registerpage.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("FILKOMFound");
        stage.show();
    }
}
