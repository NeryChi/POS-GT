package com.nerypolar.posgt;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


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
            private TextField txf_name_usr;

            @FXML
            private TextField txf_id_usr;

            @FXML
            private TextField txf_nameusr_usr;

            @FXML
            private TextField txf_pass_usr;

            @FXML
            private TextField txf_rol_usr;

            @FXML
            private TextField txf_email_usr;

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
    private Button btn_agreg_venta;

    @FXML
    private Button btn_cancel_venta;

            //Panel registrar venta-------------------------------------------------------------------------------------

            @FXML
            private Tab registro_venta;

            @FXML
            private TextField txf_name_venta;

            @FXML
            private TextField txf_dir_venta;

            @FXML
            private TextField txf_nit_venta;

            @FXML
            private TextField txf_desc_venta;

            @FXML
            private Label lb_subt_venta;

            @FXML
            private Label lb_total_venta;

            @FXML
            private Button btn_regist_venta;

            @FXML
            private Button btn_antes_venta;

    //--------------------------------------------FIN venta-------------------------------------------------------------




    //Panel de historial -----------------------------------------------------------------------------------------------

    @FXML
    private Tab historial;

    @FXML
    private Button btn_edit_hist;

    @FXML
    private Button btn_cancel_hist;

    //--------------------------------------------FIN historial---------------------------------------------------------




    //Panel de inventario ----------------------------------------------------------------------------------------------

    @FXML
    private Tab inventario;

    @FXML
    private Button btn_acept_invent;

    @FXML
    private Button btn_desh_invent;

            //Panel registrar inventario-------------------------------------------------------------------------------------

            @FXML
            private Tab registrar_producto;

            @FXML
            private TextField txf_name_invent;

            @FXML
            private TextField txf_id_invent;

            @FXML
            private TextField txf_idp_invent;

            @FXML
            private TextField txf_prec_invent;

            @FXML
            private TextField txf_cant_invent;

            @FXML
            private TextField txf_descri_invent;

            @FXML
            private Button btn_regist_invet;

            @FXML
            private Button btn_cancel_invet;

    //--------------------------------------------FIN inventario--------------------------------------------------------




    //Panel de proveedores ---------------------------------------------------------------------------------------------

    @FXML
    private Tab proveedores;

    @FXML
    private TextField txf_name_provee;

    @FXML
    private TextField txf_id_provee;

    @FXML
    private TextField txf_empresa_provee;

    @FXML
    private TextField txf_email_provee;

    @FXML
    private TextField txf_tel_provee;

    @FXML
    private TextField txf_dir_provee;

    @FXML
    private Button btn_desh_provee;

    @FXML
    private Button btn_agreg_provee;

            //Panel registrar proveedor-------------------------------------------------------------------------------------

            @FXML
            private Tab registrar_proveedor;

            @FXML
            private Button btn_regist_provee;

            @FXML
            private Button btn_cancel_provee;

    //--------------------------------------------FIN proveedores-------------------------------------------------------





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }





    //Metodos usuario--------------------------------------------------------------------------------------------------

    public void irAggUsuario(){

        madre.getSelectionModel().select(agregar_usuario);
    }

    public void aggUsuario(){

        boolean registrar = true;
        String id = txf_id_usr.getText();
        String usuario = txf_nameusr_usr.getText();
        String password = txf_pass_usr.getText();
        String nombre = txf_name_usr.getText();
        String correo = txf_email_usr.getText();
        String rol = txf_rol_usr.getText();
        String telefono = txf_tel_usr.getText();

        int rol_num = 0;

        if (id.equals("")){

            txf_id_usr.setPromptText("Llenar ID");
            registrar = false;
            //txf_cod_usr.setC

        } if (usuario.equals("")){

            txf_nameusr_usr.setPromptText("Por favor llene el campo USUARIO");
            registrar = false;
            //Notificar al usuario

        } if (password.equals("")){

            txf_pass_usr.setPromptText("Por favor llene el campo CONTRASEÑA");
            registrar = false;
            //Notificar al usuario

        } if (nombre.equals("")){

            txf_name_usr.setPromptText("Por favor llene el campo NOMBRE");
            registrar = false;
            //Notificar al usuario

        } if (correo.equals("")){

            txf_email_usr.setPromptText("Por favor llene el campo CORREO");
            registrar = false;
            //Notificar al usuario

        } if (rol.equals("...")){

            txf_rol_usr.setPromptText("Por favor elija un ROL para el usuario");
            registrar = false;
            //Notificar al usuario

        } else{

            switch (rol){

                case "Administrador": rol_num = 1;
                    break;

                case "Vendedor": rol_num = 2;
                    break;

                default: txf_rol_usr.setPromptText("Por favor elija un ROL para el usuario");
                            registrar = false;
                    break;

            }

        } if (telefono.equals("")){

            txf_tel_usr.setPromptText("Por favor llene el campo TELEFONO");
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

            txf_id_usr.setText("");
            txf_nameusr_usr.setText("");
            txf_pass_usr.setText("");
            txf_name_usr.setText("");
            txf_email_usr.setText("");
            txf_rol_usr.setText("");
            txf_tel_usr.setText("");
            madre.getSelectionModel().select(usuarios);

        } else {
            System.out.println("Error USUARIO no registrado por falta de datos.");
        }
    }


    public void irUsuario(){

        txf_id_usr.setText("");
        txf_nameusr_usr.setText("");
        txf_pass_usr.setText("");
        txf_name_usr.setText("");
        txf_email_usr.setText("");
        txf_rol_usr.setText("");
        txf_tel_usr.setText("");

        txf_id_usr.setPromptText("");
        txf_nameusr_usr.setPromptText("");
        txf_pass_usr.setPromptText("");
        txf_name_usr.setPromptText("");
        txf_email_usr.setPromptText("");
        txf_rol_usr.setPromptText("");
        txf_tel_usr.setPromptText("");
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

        boolean registro = true;
        String id = txf_id_provee.getText();
        String nombre = txf_name_provee.getText();
        String empresa = txf_empresa_provee.getText();
        String correo = txf_email_provee.getText();
        String telefono = txf_tel_provee.getText();
        String direccion = txf_dir_provee.getText();

        if (id.equals("")){

            txf_id_provee.setPromptText("Llenar ID");
            registro = false;
            //Notificar al usuario

        }if (nombre.equals("")){

            txf_name_provee.setPromptText("Por favor llene el campo NOMBRE");
            registro = false;
            //Notificar al usuario

        }if (empresa.equals("")){

            txf_empresa_provee.setPromptText("Por favor llene el campo EMPRESA");
            registro = false;
            //Notificar al usuario

        }if (correo.equals("")){

            txf_email_provee.setPromptText("Por favor llene el campo CORREO");
            registro = false;
            //Notificar al usuario

        }if (telefono.equals("")){

            txf_tel_provee.setPromptText("Por favor llene el campo TELEFONO");
            registro = false;
            //Notificar al usuario

        }if (direccion.equals("")){
            txf_dir_provee.setPromptText("Por favor llene el campo DIRECCIÓN");
            registro = false;
            //Notificar al usuario

        }

        if (registro == true){
            System.out.println("Sipaso");
            try {

                Conexion cn = new Conexion();
                cn.conexion();
                String sql = "insert into proveedor(id, empresa, nombre, correo, telefono, direccion) values(?,?,?,?,?,?)";
                PreparedStatement ps = cn.conexion().prepareStatement(sql);

                ps.setString(1, id);
                ps.setString(2, empresa);
                ps.setString(3, nombre);
                ps.setString(4, correo);
                ps.setString(5, telefono);
                ps.setString(6, direccion);
                ps.executeUpdate();

                System.out.println("Datos Agregados correctamente");

            } catch (Exception e){
                System.out.println("Error al registrer el proveedor en la base de datos" + e.getMessage());
            }

            txf_id_provee.setText("");
            txf_name_provee.setText("");
            txf_empresa_provee.setText("");
            txf_email_provee.setText("");
            txf_tel_provee.setText("");
            txf_dir_provee.setText("");
            madre.getSelectionModel().select(proveedores);

        }else {
            System.out.println("Error PROVEEDOR no registrado por falta de datos.");
        }

    }

    public void irProvee(){

        txf_id_provee.setText("");
        txf_name_provee.setText("");
        txf_empresa_provee.setText("");
        txf_email_provee.setText("");
        txf_tel_provee.setText("");
        txf_dir_provee.setText("");

        txf_id_provee.setPromptText("");
        txf_name_provee.setPromptText("");
        txf_empresa_provee.setPromptText("");
        txf_email_provee.setPromptText("");
        txf_tel_provee.setPromptText("");
        txf_dir_provee.setPromptText("");
        madre.getSelectionModel().select(proveedores);
    }
}
