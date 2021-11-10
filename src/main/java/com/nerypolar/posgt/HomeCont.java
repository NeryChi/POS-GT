package com.nerypolar.posgt;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.PreparedStatement;
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




    //Panel de inventario ----------------------------------------------------------------------------------------------

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

    //--------------------------------------------Fin inventario--------------------------------------------------------




    //Panel de proveedores ---------------------------------------------------------------------------------------------

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

    //--------------------------------------------Fin proveedores-------------------------------------------------------





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }





    //Metodos usuario--------------------------------------------------------------------------------------------------

    public void irAggUsuario(){
        madre.getSelectionModel().select(agregar_usuario);
    }

    public void aggUsuario(){

        boolean registrar = true;
        String id = txf_cod_usr.getText();
        String usuario = txf_nameusr_usr.getText();
        String password = txf_pass_usr.getText();
        String nombre = txf_nombre_usr.getText();
        String correo = txf_correo_usr.getText();
        String rol = txf_rol_usr.getText();
        String telefono = txf_tel_usr.getText();

        int rol_num = 0;

        if (id.equals("")){

            System.out.println("Por favor llene el campo ID");
            registrar = false;
            //txf_cod_usr.setC

        } if (usuario.equals("")){

            System.out.println("Por favor llene el campo USUARIO");
            registrar = false;
            //Notificar al usuario

        } if (password.equals("")){

            System.out.println("Por favor llene el campo PASSWORD");
            registrar = false;
            //Notificar al usuario

        } if (nombre.equals("")){

            System.out.println("Por favor llene el campo NOMBRE");
            registrar = false;
            //Notificar al usuario

        } if (correo.equals("")){

            System.out.println("Por favor llene el campo CORREO");
            registrar = false;
            //Notificar al usuario

        } if (rol.equals("...")){

            System.out.println("Por favor elija un ROL para el usuario");
            registrar = false;
            //Notificar al usuario

        } else{

            switch (rol){

                case "Administrador": rol_num = 1;
                    break;

                case "Vendedor": rol_num = 2;
                    break;

                default: System.out.println("Por favor elija un ROL para el usuario");
                            registrar = false;
                    break;

            }

        } if (telefono.equals("")){

            System.out.println("Por favor llene el campo TELEFONO");
            registrar =false;
            //Notificar al usuario

        }

        if (registrar == true){

            try{

                Conexion cn = new Conexion();
                cn.conexion();
                String sql = "insert into usuarios(id, nombreUsuario, password, nombre, correo, rol, telefono) values(?,?,?,?,?,?,?)";
                PreparedStatement ps = cn.conexion().prepareStatement(sql);

                ps.setString(1, id);
                ps.setString(2, usuario);
                ps.setString(3, password);
                ps.setString(4, nombre);
                ps.setString(5, correo);
                ps.setInt(6, rol_num);
                ps.setString(7, telefono);
                ps.executeUpdate();

                System.out.println("Datos Agregados correctamente");

            } catch (Exception e){
                System.out.println("Error al registrer el usuraio en la base de datos" + e.getMessage());
            }

            txf_cod_usr.setText("");
            txf_nameusr_usr.setText("");
            txf_pass_usr.setText("");
            txf_nombre_usr.setText("");
            txf_correo_usr.setText("");
            txf_rol_usr.setText("");
            txf_tel_usr.setText("");
            madre.getSelectionModel().select(usuarios);

        } else {
            System.out.println("Error USUARIO no registrado por flata de datos.");
        }
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
