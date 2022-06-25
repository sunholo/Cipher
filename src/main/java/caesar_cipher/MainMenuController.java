package caesar_cipher;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {
    private Stage stage;
    private Scene scene;

    @FXML
    void onHelloButtonClick1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("encoding.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Caesar cipher");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onHelloButtonClick2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("decoding.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Caesar cipher");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onHelloButtonClick3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("brut_force.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Caesar cipher");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
    }



}