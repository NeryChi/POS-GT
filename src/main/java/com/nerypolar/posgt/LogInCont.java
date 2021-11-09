package com.nerypolar.posgt;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInCont implements Initializable {

    @FXML
    private AnchorPane lienzo;

    @FXML
    private AnchorPane campos_anchor;


    @FXML
    private Label prueba_texto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int alto_res = (int) Screen.getPrimary().getBounds().getHeight();
        int ancho_res = (int) Screen.getPrimary().getBounds().getWidth();
        lienzo.setPrefSize(ancho_res-(ancho_res*40/100), alto_res-(alto_res*45/100));


        float ancho = (int) lienzo.getPrefWidth();
        campos_anchor.setPrefWidth(ancho-ancho*50/100-(campos_anchor.getPrefWidth()*50/100));
        campos_anchor.setTranslateX(ancho-ancho*50/100-(campos_anchor.getPrefWidth()*50/100));



        // Este metodo sirve para escuchar el cambio de anchura de la ventana.
        lienzo.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number n_ancho) {
                System.out.println("Ancho : " + n_ancho);

                float ancho = n_ancho.floatValue();
                campos_anchor.setPrefWidth(ancho-ancho*50/100-(campos_anchor.getPrefWidth()*50/100));
                campos_anchor.setTranslateX(ancho-ancho*50/100-(campos_anchor.getPrefWidth()*50/100));

            }
        });


        // Este metodo sirve para escuchar el cambio de altura de la ventana.
        lienzo.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number n_alto) {
                System.out.println("Ancho : " + n_alto);

                float alto = n_alto.floatValue();
                campos_anchor.setTranslateY(alto-alto*50/100-(campos_anchor.getPrefHeight()*50/100));
            }
        });


    }
}
