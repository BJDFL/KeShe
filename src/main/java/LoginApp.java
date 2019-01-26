package main.java;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.java.service.ChangeService;

public class LoginApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ChangeService.stage = primaryStage;
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/fxml/login.fxml"));
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            ChangeService.stage.setScene(scene);
            ChangeService.stage.setTitle("picture-system 1.0");
            ChangeService.stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}