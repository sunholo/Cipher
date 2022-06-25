module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens caesar_cipher to javafx.fxml;
    exports caesar_cipher;

}