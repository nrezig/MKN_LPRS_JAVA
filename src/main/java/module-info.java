module com.example.java_mkn_lprs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.example.java_mkn_lprs to javafx.fxml;
    exports com.example.java_mkn_lprs;
    exports com.example.java_mkn_lprs.appli;
    opens com.example.java_mkn_lprs.appli to javafx.fxml;
    opens com.example.java_mkn_lprs.modele to javafx.base;

}