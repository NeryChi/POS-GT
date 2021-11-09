module com.nerypolar.posgt {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires mysql.connector.java;


    opens com.nerypolar.posgt to javafx.fxml;
    exports com.nerypolar.posgt;
}