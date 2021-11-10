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

    @FXML
    private Button btn_usr;

    @FXML
    private Button btn_venta;

    @FXML
    private Button btn_hist;

    @FXML
    private Button btn_invent;

    @FXML
    private Button btn_provee;

    //Panel de usuarios -----------------------------------------------------------------------------------------------

    @FXML
    private Tab usuarios;

   @FXML
    private Button btn_agreg_usr;

            //Panel agregar usuario-------------------------------------------------------------------------------------

            @FXML
            private Tab agregar_usuario;

            @FXML
            private TextField txf_nombre_usr;

            @FXML
            private TextField txf_cod_usr;

            @FXML
            private TextField txf_nameusr_usr;

            @FXML
            private TextField txf_pass_usr;

            @FXML
            private TextField txf_rol_usr;

            @FXML
            private TextField txf_correo_usr;

            @FXML
            private TextField txf_tel_usr;

            @FXML
            private Button btn_acept_usr;

            @FXML
            private Button btn_cancel_usr;

    //--------------------------------------------FIN de usuario--------------------------------------------------------

    //Panel de venta ---------------------------------------------------------------------------------------------------

    @FXML
    private Tab nueva_venta;

    @FXML
    private Button btn_acept_venta;

    @FXML
    private Button btn_cancel_venta;

            //Panel registrar venta-------------------------------------------------------------------------------------

            @FXML
            private Tab registro_venta;

            @FXML
            private Button btn_regist_venta;

            @FXML
            private Button btn_antes_venta;

    //--------------------------------------------Fin venta-------------------------------------------------------------

    //Panel de historial -----------------------------------------------------------------------------------------------

    @FXML
    private Tab historial;

    @FXML
    private Button btn_edit_hist;

    @FXML
    private Button btn_cancel_hist;

    //--------------------------------------------Fin historial---------------------------------------------------------

    //Panel de inventario ---------------------------------------------------------------------------------------------------

    @FXML
    private Tab inventario;

    @FXML
    private Button btn_acept_invent;

    @FXML
    private Button btn_desh_invent;

            //Panel registrar venta-------------------------------------------------------------------------------------

            @FXML
            private Tab registrar_producto;

            @FXML
            private Button btn_regist_invet;

            @FXML
            private Button btn_cancel_invet;

    //--------------------------------------------Fin inventario-------------------------------------------------------------

    //Panel de proveedores ---------------------------------------------------------------------------------------------------

    @FXML
    private Tab proveedores;

    @FXML
    private Button btn_desh_provee;

    @FXML
    private Button btn_acept_provee;

            //Panel registrar venta-------------------------------------------------------------------------------------

            @FXML
            private Tab registrar_proveedor;

            @FXML
            private Button btn_regist_provee;

            @FXML
            private Button btn_cancel_provee;

    //--------------------------------------------Fin proveedores-------------------------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    //Metodos usuario--------------------------------------------------------------------------------------------------

    public void irAggUsuario(){
        madre.getSelectionModel().select(agregar_usuario);
    }

    public void aggUsuario(){

    }

    public void irUsuario(){
        txf_nombre_usr.setText("");
        txf_cod_usr.setText("");
        madre.getSelectionModel().select(usuarios);
    }

    //Metodos venta----------------------------------------------------------------------------------------------------

    public void irAggVenta(){ madre.getSelectionModel().select(registro_venta);}

    public void aggVenta(){

    }

    public void irVenta(){
        madre.getSelectionModel().select(nueva_venta);
    }

    //Metodos historial------------------------------------------------------------------------------------------------

    public void irHistorial(){
        madre.getSelectionModel().select(historial);
    }

    //Metodos inventario-----------------------------------------------------------------------------------------------

    public void irAggProduc(){ madre.getSelectionModel().select(registrar_producto);}

    public void aggProduc(){

    }

    public void irInvent(){
        madre.getSelectionModel().select(inventario);
    }


    //Metodos proveedor------------------------------------------------------------------------------------------------

    public void irAggProvee(){ madre.getSelectionModel().select(registrar_proveedor);}

    public void aggProvee(){

    }

    public void irProvee(){
        madre.getSelectionModel().select(proveedores);
    }
}
