module com.example.java_mkn_lprs {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java_mkn_lprs to javafx.fxml;
    exports com.example.java_mkn_lprs;
}