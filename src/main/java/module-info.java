module com.nerypolar.posgt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.nerypolar.posgt to javafx.fxml;
    exports com.nerypolar.posgt;
}