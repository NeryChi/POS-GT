package com.nerypolar.posgt;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class NuevoCont implements Initializable {

    @FXML
    private Button aceptar;

    @FXML
    private Tab pestana;

    @FXML
    private TabPane panel;

    @FXML
    private Label texto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    public void cambiarTabla(){

        panel.getSelectionModel().select(pestana);


    }


}
