package com.nerypolar.posgt;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
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

    }

    public void validarUsuario(){

        boolean valido = false;

        try {

            Conexion cc = new Conexion();
            String usuario = this.usuario.getText();
            String password = this.password.getText();

            String sql = "select * from usuarios where nombreUsuario='" + usuario + "' and password='" + password + "'";

            Statement st = cc.conexion().createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                valido = true;

                if (valido == true) {


                    System.out.println("Acceso concedido");
                    close();
                    home();
                } else {
                    System.out.println("Acceso denegado");
                }

            } else {
                System.out.println("Acceso denegado");
            }

        } catch (Exception e) {
            System.out.println("Error en la consulta o validacion del usuario" + e.getMessage());
        }
    }

    public void home(){

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root = loader.load();

            HomeCont controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("");
            Image icon = new Image(getClass().getResourceAsStream("/img/p.png"));
            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    Stage stage;

    public void close(){

         stage = (Stage) lienzo.getScene().getWindow();
;
         stage.close();
        }
    }
