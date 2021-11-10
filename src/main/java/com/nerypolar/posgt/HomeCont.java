package com.nerypolar.posgt;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeCont implements Initializable {

    @FXML
    private ComboBox cmbProveedor;

    @FXML
    private ObservableList listaProveedores;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbProveedor.setItems(listaProveedores);

    }
}
