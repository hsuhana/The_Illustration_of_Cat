module com.example.assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.net.http;
    requires com.google.gson;


    opens com.example.assignment2 to com.google.gson, javafx.fxml;
    exports com.example.assignment2;
}