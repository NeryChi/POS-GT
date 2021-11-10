package com.nerypolar.posgt;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeCont implements Initializable {


    //Panel izquierdo--------------------------------------------------------------------------------------------------

    @FXML
    private TabPane madre;

    /*@FXML
    private Button btn_usr;*/


    //Panel de usuarios -----------------------------------------------------------------------------------------------

    @FXML
    private Tab usuarios;

   /*@FXML
    private Button btn_agreg_usr;*/

        //Panel agregar usuario----------------------------------------------------------------------------------------

        @FXML
        private Tab agregar_usuario;

        @FXML
        private TextField txf_nombre_usr;

        /*@FXML
        private Button btn_acept_usr;

        @FXML
        private Button btn_cancel_usr;*/

    //-----------------------------------------------------------------------------------------------------------------





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    public void irAggUsuario(){
        madre.getSelectionModel().select(agregar_usuario);
    }

    public void aggUsuario(){

    }

    public void irUsuarios(){
        txf_nombre_usr.setText("");
        madre.getSelectionModel().select(usuarios);
    }

}
