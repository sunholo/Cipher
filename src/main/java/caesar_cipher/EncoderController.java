package caesar_cipher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EncoderController {
    @FXML
    private TextArea cipher;
    @FXML
    private Button enterButtonEncoder;
    @FXML
    private TextArea inputLinkDecoder;
    @FXML
    private TextArea outputLinkDecoder;

    @FXML
    void onHelloButtonClick1(ActionEvent event) {
        String linkInput = inputLinkDecoder.getText();
        String linkOutput = outputLinkDecoder.getText();
        Integer cip = Integer.parseInt(cipher.getText());
        if ((new File(linkInput)).exists() && (new File(linkOutput)).exists() && cip > 0 && cip < 41) {

            ArrayList<Character> characterArrayList = new ArrayList<>();
            Encoder.readFileInArray(linkInput, characterArrayList);
            Encoder.cipher(characterArrayList, Cryptographer.getALPHABET(), cip);
            Encoder.writeInFile(linkOutput, characterArrayList);

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("finish.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Caesar cipher");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("error.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Caesar cipher");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    @FXML
    void initialize() {

    }

}