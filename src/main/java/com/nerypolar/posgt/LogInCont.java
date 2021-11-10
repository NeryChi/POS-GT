package com.nerypolar.posgt;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LogInCont implements Initializable {

    @FXML
    private AnchorPane lienzo;

    @FXML
    private AnchorPane logo_anchor;

    @FXML
    private AnchorPane campos_anchor;

    @FXML
    private TextField usuario;

    @FXML
    private PasswordField password;

    @FXML
    private Label prueba_texto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int alto_res = (int) Screen.getPrimary().getBounds().getHeight();
        int ancho_res = (int) Screen.getPrimary().getBounds().getWidth();
        lienzo.setPrefSize(ancho_res-(ancho_res*40/100), alto_res-(alto_res*45/100));


        float ancho = (int) lienzo.getPrefWidth();
        float alto = (int) lienzo.getPrefHeight();
        logo_anchor.setPrefHeight(alto*5/100);
        logo_anchor.setTranslateY(alto*5/100);
        logo_anchor.setTranslateX(ancho-ancho*50/100-(logo_anchor.getPrefWidth()*50/100));
        campos_anchor.setPrefWidth(ancho-ancho*50/100-(campos_anchor.getPrefWidth()*50/100));
        campos_anchor.setTranslateX(ancho-ancho*50/100-(campos_anchor.getPrefWidth()*50/100));



        // Este metodo sirve para escuchar el cambio de anchura de la ventana.
        lienzo.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number n_ancho) {
                System.out.println("Ancho : " + n_ancho);

                float ancho = n_ancho.floatValue();
                logo_anchor.setTranslateX(ancho-ancho*50/100-(logo_anchor.getPrefWidth()*50/100));
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
                logo_anchor.setPrefHeight(alto*5/100);
                logo_anchor.setTranslateY(alto-(alto*90/100));
                campos_anchor.setTranslateY(alto-alto*50/100-(campos_anchor.getPrefHeight()*50/100));
            }
        });


    }

    public void acceder(){

        boolean valido = false;

        try{

            Conexion cc = new Conexion();
            String usuario = this.usuario.getText();
            String password = this.password.getText();

            String sql = "select * from usuarios where nombreUsuario='"+usuario+"' and password='"+password+"'";

            Statement st = cc.conexion().createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()){

                valido = true;

                if (valido == true){
                    System.out.println("Acceso concedido");
                } else{
                    System.out.println("Acceso denegado");
                }

            } else {
                System.out.println("Acceso denegado");
            }

        } catch (Exception e){
            System.out.println("Error en la consulta o validacion del usuario" + e.getMessage());
        }


    }
}
