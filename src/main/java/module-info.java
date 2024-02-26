module com.example.java_mkn_lprs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires charm.glisten;
    requires mysql.connector.j;
    opens com.example.java_mkn_lprs to javafx.fxml;
    opens com.example.java_mkn_lprs.appli to javafx.fxml;
    exports com.example.java_mkn_lprs;
    exports com.example.java_mkn_lprs.appli;
    exports BDD;
    opens BDD to javafx.fxml;
    opens com.example.java_mkn_lprs.modele to javafx.base;
}