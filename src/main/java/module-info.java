module com.nerypolar.posgt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens com.nerypolar.posgt to javafx.fxml;
    exports com.nerypolar.posgt;
}