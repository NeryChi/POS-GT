package com.nerypolar.posgt;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.w3c.dom.events.Event;


import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;

public class HomeCont implements Initializable {

    // Se instancia un objeto para llmar la base de datos.
    Conexion cn = new Conexion();

    //Panel izquierdo--------------------------------------------------------------------------------------------------

    @FXML
    private TabPane madre;

    @FXML
    private Button btn_usr, btn_venta, btn_hist, btn_invent, btn_provee;



    //Panel de usuarios -----------------------------------------------------------------------------------------------

    @FXML
    private Tab usuarios;

   @FXML
    private Button btn_delete_usr, btn_edit_usr, btn_agreg_usr;

   @FXML
   private TableView<ClsUsuarios> tbl_usuarios;

   @FXML
   private TableColumn<ClsUsuarios, String> col_id_usr;

    @FXML
    private TableColumn<ClsUsuarios, String> col_name_usr;

    @FXML
    private TableColumn<ClsUsuarios, String> col_usr_usr;

    @FXML
    private TableColumn<ClsUsuarios, String> col_email_usr;

    @FXML
    private TableColumn<ClsUsuarios, String> col_tel_usr;

    @FXML
    private TableColumn<ClsUsuarios, String> col_rol_usr;

    ObservableList<ClsUsuarios> userList = FXCollections.observableArrayList();


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
            private ComboBox<String> cbx_rol_usr;

            @FXML
            private TextField txf_email_usr;

            @FXML
            private TextField txf_tel_usr;

            @FXML
            private Button btn_acept_usr;

            @FXML
            private Button btn_cancel_usr, btn_buscar_usr;

    ObservableList<ClsProductos> usuarioList = FXCollections.observableArrayList();

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
    private Button btn_delete_hist, btn_td_hist;

    @FXML
    private TableView<ClsHistorial> tbl_historial;

    @FXML
    private TableColumn<ClsHistorial, String> col_id_hist;

    @FXML
    private TableColumn<ClsHistorial, String>col_name_hist;

    @FXML
    private TableColumn<ClsHistorial, String>col_dir_hist;

    @FXML
    private TableColumn<ClsHistorial, String>col_nit_hist;

    @FXML
    private TableColumn<ClsProductos, String> col_total_hist;

    ObservableList<ClsHistorial> histList = FXCollections.observableArrayList();


    //--------------------------------------------FIN historial---------------------------------------------------------




    //Panel de inventario ----------------------------------------------------------------------------------------------

    @FXML
    private Tab inventario;

    @FXML
    private Button btn_delete_invent, btn_edit_invent, btn_agg_invent;

    @FXML
    private TableView<ClsProductos> tbl_inventario;

    @FXML
    private TableColumn<ClsProductos, String> col_id_invent;

    @FXML
    private TableColumn<ClsProductos, String> col_name_invent;

    @FXML
    private TableColumn<ClsProductos, String> col_pro_invent;

    @FXML
    private TableColumn<ClsProductos, String> col_descri_invent;

    @FXML
    private TableColumn<ClsProductos, String> col_cant_invent;

    @FXML
    private TableColumn<ClsProductos, String> col_precio_invent;

    ObservableList<ClsProductos> producList = FXCollections.observableArrayList();



            //Panel registrar inventario-------------------------------------------------------------------------------------

            @FXML
            private Tab registrar_producto;

            @FXML
            private TextField txf_name_invent;

            @FXML
            private TextField txf_id_invent;

            @FXML
            private ComboBox<ClsEmpresas> cbx_idp_invent;

            @FXML
            private TextField txf_prec_invent;

            @FXML
            private TextField txf_cant_invent;

            @FXML
            private TextField txf_descri_invent;

            @FXML
            private Button btn_cancel_invet, btn_regist_invet;

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
    private Button btn_delete_provee, btn_agreg_provee, btn_edit_provee;

    @FXML
    private TableView<ClsProveedores> tbl_proveedores;

    @FXML
    private TableColumn<ClsProveedores, String> col_id_provee;

    @FXML
    private TableColumn<ClsProveedores, String> col_empresa_provee;

    @FXML
    private TableColumn<ClsProveedores, String> col_encargado_provee;

    @FXML
    private TableColumn<ClsProveedores, String> col_dir_provee;

    @FXML
    private TableColumn<ClsProveedores, String> col_correo_provee;

    @FXML
    private TableColumn<ClsProveedores, String> col_tel_proveedor;

    ObservableList<ClsProveedores> proveeList = FXCollections.observableArrayList();


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

        ObservableList<String> roles = FXCollections.observableArrayList();
        roles.addAll("Administrador","Vendedor");
        cbx_rol_usr.getItems().addAll(roles);

        loadTableProduc();
        loadTableProvee();
        loadTableHist();
        loadTableUser();

        fillEmpresa();



    }


    //Metodos usuario--------------------------------------------------------------------------------------------------

    public void irAggUsuario(){

        btn_acept_usr.setText("Registrar");
        cbx_rol_usr.setPromptText("");
        madre.getSelectionModel().select(agregar_usuario);
    }

    public void aggUsuario(){

        boolean registrar = true;
        String id = txf_id_usr.getText();
        String usuario = txf_nameusr_usr.getText();
        String password = txf_pass_usr.getText();
        String nombre = txf_name_usr.getText();
        String correo = txf_email_usr.getText();
        String rol = cbx_rol_usr.getSelectionModel().getSelectedItem();
        String telefono = txf_tel_usr.getText();

        int rol_num = 0;

        if (id.equals("")){

            txf_id_usr.setPromptText("Llenar ID");
            registrar = false;
            //Notificar al usuario

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

        } if (rol == null){
            cbx_rol_usr.setPromptText("Por favor seleccione un ROL");
            registrar = false;
            //Notificar al usuario

        } else{

            switch (rol){

                case "Administrador": rol_num = 1;
                    break;

                case "Vendedor": rol_num = 2;
                    break;

                default: cbx_rol_usr.setPromptText("Por favor elija un ROL para el usuario");
                            registrar = false;
                    break;

            }

        } if (telefono.equals("")){
            txf_tel_usr.setPromptText("Por favor llene el campo TELEFONO");
            registrar =false;
            //Notificar al usuario

        }

        if (registrar == true){

            switch (btn_acept_usr.getText()){
                case "Registrar":
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
                        loadTableUser();

                    } catch (Exception e){
                        System.out.println("Error al registrer el usuraio en la base de datos" + e.getMessage());
                    }
                    break;

                case "Actualizar":

                    String passId = tbl_usuarios.getSelectionModel().getSelectedItem().id;

                    try {

                        Conexion cn = new Conexion();
                        cn.conexion();
                        String sql = "UPDATE  usuarios SET " +
                                "id = ?" +
                                ",nombreUsuario = ?" +
                                ",password = ?" +
                                ",nombre = ?" +
                                ",correo = ?" +
                                ",rol = ?" +
                                ",telefono = ?" +
                                "WHERE id=?";
                        PreparedStatement ps = cn.conexion().prepareStatement(sql);

                        ps.setString(1, id);
                        ps.setString(2, usuario);
                        ps.setString(3, password);
                        ps.setString(4, nombre);
                        ps.setString(5, correo);
                        ps.setInt(6, rol_num);
                        ps.setString(7, telefono);
                        ps.setString(8, passId);
                        ps.executeUpdate();


                        System.out.println("Datos Actualizados correctamente");
                        loadTableUser();

                    } catch (Exception e){
                        System.out.println("Error al ACTUALIZAR el usuario en la base de datos" + e.getMessage());
                    }
                    break;

            }

            txf_id_usr.setText("");
            txf_nameusr_usr.setText("");
            txf_pass_usr.setText("");
            txf_name_usr.setText("");
            txf_email_usr.setText("");
            cbx_rol_usr.getSelectionModel().clearSelection();
            txf_tel_usr.setText("");
            madre.getSelectionModel().select(usuarios);

        } else {
            System.out.println("Error USUARIO no registrado por falta de datos.");
        }
    }

    //Ir a la pestaña inicio de usuario
    public void irUsuario(){

        txf_id_usr.setText("");
        txf_nameusr_usr.setText("");
        txf_pass_usr.setText("");
        txf_name_usr.setText("");
        txf_email_usr.setText("");
        cbx_rol_usr.getSelectionModel().clearSelection();
        txf_tel_usr.setText("");

        txf_id_usr.setPromptText("");
        txf_nameusr_usr.setPromptText("");
        txf_pass_usr.setPromptText("");
        txf_name_usr.setPromptText("");
        txf_email_usr.setPromptText("");
        txf_tel_usr.setPromptText("");
        madre.getSelectionModel().select(usuarios);
    }

    //Eliminar un dato de la tabla USER

    public void deleteUser(){

        try {
            //Llamo el item selecionado en la tabla de provedores en este caso el codigo el cual lo usare para buscarlo y eliminarlo

            String deletUser = tbl_usuarios.getSelectionModel().getSelectedItem().id;

            Conexion cn = new Conexion();
            cn.conexion();
            String sql = "DELETE FROM `usuarios` WHERE id = " + "'" + deletUser + "'";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ps.execute();

            loadTableUser();

            System.out.println("Dato eliminado exitosamente");

        }catch (Exception e){

            System.out.println("Error al Eliminar el dato en la base de datos" + e.getMessage());

        }
    }

    //Recargar la tabla del USER
    public void refreshTableUsr(){

        try {

            userList.clear();

            Conexion cn = new Conexion();
            cn.conexion();
            String sql = "SELECT * FROM usuarios";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                userList.addAll( new ClsUsuarios(
                        rs.getString("id"),
                        rs.getString("nombreUsuario"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("rol"),
                        rs.getString("telefono")
                ));
            }

        }catch (Exception e){

            System.out.println("Error al Solicitar en la base de datos" + e.getMessage());

        }
    }


    //Rellenar la tabla usuarios
    private void loadTableUser(){

        refreshTableUsr();

        col_id_usr.setCellValueFactory(new PropertyValueFactory<ClsUsuarios, String>("id"));
        col_usr_usr.setCellValueFactory(new PropertyValueFactory<ClsUsuarios, String>("nombreUsuario"));
        col_name_usr.setCellValueFactory(new PropertyValueFactory<ClsUsuarios, String>("nombre"));
        col_email_usr.setCellValueFactory(new PropertyValueFactory<ClsUsuarios, String>("correo"));
        col_rol_usr.setCellValueFactory(new PropertyValueFactory<ClsUsuarios, String>("rol"));
        col_tel_usr.setCellValueFactory(new PropertyValueFactory<ClsUsuarios, String>("telefono"));

        tbl_usuarios.setItems(userList);

    }

    //Pasar los datos del la tabla a los campos de registro
    public void passUser(){

        String passId = tbl_usuarios.getSelectionModel().getSelectedItem().id;
        txf_id_usr.setText(passId);

        String passUsr = tbl_usuarios.getSelectionModel().getSelectedItem().nombreUsuario;
        txf_nameusr_usr.setText(passUsr);

        String passName = tbl_usuarios.getSelectionModel().getSelectedItem().nombre;
        txf_name_usr.setText(passName);

        String passEmail = tbl_usuarios.getSelectionModel().getSelectedItem().correo;
        txf_email_usr.setText(passEmail);

        String passTel = tbl_usuarios.getSelectionModel().getSelectedItem().telefono;
        txf_tel_usr.setText(passTel);


        btn_acept_usr.setText("Actualizar");
        madre.getSelectionModel().select(agregar_usuario);

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


    //Recargar la tabla del Historial
    public void refreshTableHist(){

        try {

            histList.clear();

            Conexion cn = new Conexion();
            cn.conexion();
            String sql = "SELECT * FROM ventas";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                histList.addAll(new ClsHistorial(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("nit"),
                        rs.getString("total")
                ));
            }

        }catch (Exception e){

            System.out.println("Error al Solicitar en la base de datos" + e.getMessage());

        }
    }

    //Cargar la tabla de Historial
    public void loadTableHist(){

        refreshTableHist();

        col_id_hist.setCellValueFactory(new PropertyValueFactory<ClsHistorial, String>("id"));
        col_name_hist.setCellValueFactory(new PropertyValueFactory<ClsHistorial, String>("nombre"));
        col_dir_hist.setCellValueFactory(new PropertyValueFactory<ClsHistorial, String>("direccion"));
        col_nit_hist.setCellValueFactory(new PropertyValueFactory<ClsHistorial, String>("nit"));
        col_total_hist.setCellValueFactory(new PropertyValueFactory<ClsProductos, String>("total"));

        tbl_historial.setItems(histList);
    }

    //Eliminar un dato de la tabla historial (Es puro relleno)

    public void deleteHist(){

        try {
            //Llamo el item selecionado en la tabla de provedores en este caso el codigo el cual lo usare para buscarlo y eliminarlo

            String deletHist = tbl_historial.getSelectionModel().getSelectedItem().id;

            Conexion cn = new Conexion();
            cn.conexion();
            String sql = "DELETE FROM `ventas` WHERE id = " + "'" + deletHist + "'";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ps.execute();

            loadTableHist();

            System.out.println("Dato eliminado exitosamente");

        }catch (Exception e){

            System.out.println("Error al Eliminar el dato en la base de datos" + e.getMessage());

        }
    }




    //Metodos inventario-----------------------------------------------------------------------------------------------
    //Metodos inventario-----------------------------------------------------------------------------------------------
    //Metodos inventario-----------------------------------------------------------------------------------------------
    //Metodos inventario-----------------------------------------------------------------------------------------------
    //Metodos inventario-----------------------------------------------------------------------------------------------


    //Llama al metodo de consulta de empresas y las llena en el comboBox
    public void fillEmpresa(){
        ClsEmpresas e = new ClsEmpresas();

        ObservableList<ClsEmpresas> obsEmpresa = e.getEmpresaList();

        cbx_idp_invent.setItems(obsEmpresa);

    }

    public void irAggProduc(){

        btn_regist_invet.setText("Registrar");
        cleanProduc();
        fillEmpresa();
        madre.getSelectionModel().select(registrar_producto);
    }

    public void cleanProduc(){

        txf_id_invent.setText("");
        txf_name_invent.setText("");
        cbx_idp_invent.getSelectionModel().clearSelection();
        txf_prec_invent.setText("");
        txf_cant_invent.setText("");
        txf_descri_invent.setText("");

        txf_id_invent.setPromptText("");
        txf_name_invent.setPromptText("");
        cbx_idp_invent.setPromptText("");
        txf_prec_invent.setPromptText("");
        txf_cant_invent.setPromptText("");
        txf_descri_invent.setPromptText("");

    }

    public void aggProduc(){
        boolean registroPro = true;
        String id = txf_id_invent.getText();
        String nombre = txf_name_invent.getText();
        ClsEmpresas idp = cbx_idp_invent.getSelectionModel().getSelectedItem();
        String prec = txf_prec_invent.getText();
        String cant = txf_cant_invent.getText();
        String descri = txf_descri_invent.getText();

        System.out.println(idp);

        if (id.equals("")) {
            txf_id_invent.setPromptText("Por favor llene el campo CÓDIGO");
            registroPro = false;

        }
        if (nombre.equals("")) {
            txf_name_invent.setPromptText("Por favor llene el campo NOMBRE");
            registroPro = false;

        } if (idp == null){
            cbx_idp_invent.setPromptText("Por favor llene elija un proveedor");
            registroPro = false;
        }else {
            registroPro = true;
        }

        if (prec.equals("")) {
            txf_prec_invent.setPromptText("Por favor llene el campo PRECIO");
            registroPro = false;

        }
        if (cant.equals("")) {
            txf_cant_invent.setPromptText("Por favor llene el campo CANTIDAD");
            registroPro = false;

        }
        if (descri.equals("")) {
            txf_descri_invent.setPromptText("Por favor llene el campo DESCRIPCION");
            registroPro = false;
        }

        if (registroPro == true){

            switch (btn_regist_invet.getText()){
                case "Registrar":

                    try {
                        Conexion cn = new Conexion();
                        cn.conexion();
                        String sql = "insert into productos(id, nombre, empresaProveedor, precio_unitario, cantidad, descripcion) values(?,?,?,?,?,?)";
                        PreparedStatement ps = cn.conexion().prepareStatement(sql);

                        ps.setString(1, id);
                        ps.setString(2, nombre);
                        ps.setString(3, String.valueOf(idp));
                        ps.setString(4, prec);
                        ps.setString(5, cant);
                        ps.setString(6, descri);
                        ps.executeUpdate();
                        System.out.println("Datos Agregados correctamente");

                        refreshTable();//RECARGA LA TABLA INVENTARIO

                    }catch (Exception e){

                        System.out.println("Error al registrar el producto en la base de datos" + e.getMessage());

                    }

                    break;

                case "Actualizar":

                    String passId = tbl_inventario.getSelectionModel().getSelectedItem().id;

                    try {

                        Conexion cn = new Conexion();
                        cn.conexion();
                        String sql = "UPDATE  productos SET " +
                                "nombre = ?" +
                                ",empresaProveedor = ?" +
                                ",precio_unitario = ?" +
                                ",cantidad = ?" +
                                ",descripcion = ?" +
                                ",id = ?" +
                                "WHERE id=?";
                        PreparedStatement ps = cn.conexion().prepareStatement(sql);

                        ps.setString(1, nombre);
                        ps.setString(2, String.valueOf(idp));
                        ps.setString(3, prec);
                        ps.setString(4, cant);
                        ps.setString(5, descri);
                        ps.setString(6, id);
                        ps.setString(7, passId);
                        ps.executeUpdate();

                        refreshTableProvee();

                        System.out.println("Datos Actualizados correctamente");

                    } catch (Exception e){
                        System.out.println("Error al ACTUALIZAR el proveedor en la base de datos" + e.getMessage());
                    }

                    break;

                default: System.out.println("No se REGISTRO ni se ACTUALIZO los datos");
            }

            cleanProduc();
            loadTableProduc();
            madre.getSelectionModel().select(inventario);

        }else {
            System.out.println("Error PRODUCTO no registrado por falta de datos.");
        }
    }

    public void irInvent(){
        loadTableProduc();
        madre.getSelectionModel().select(inventario);
    }

    //RECARGA LA TABLA INVENTARIO
    public void refreshTable(){

        try {

            producList.clear();

            Conexion cn = new Conexion();
            cn.conexion();
            String sql = "SELECT * FROM productos";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                producList.addAll(new ClsProductos(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("empresaProveedor"),
                        rs.getString("precio_unitario"),
                        rs.getString("cantidad"),
                        rs.getString("descripcion")
                ));

            }


        }catch (Exception e){

            System.out.println("Error al Solicitar en la base de datos" + e.getMessage());

        }
    }

    //Llena los tabla productos al inicio

    private void loadTableProduc() {

        refreshTable();

        col_id_invent.setCellValueFactory(new PropertyValueFactory<ClsProductos, String>("id"));
        col_name_invent.setCellValueFactory(new PropertyValueFactory<ClsProductos, String>("nombre"));
        col_pro_invent.setCellValueFactory(new PropertyValueFactory<ClsProductos, String>("empresaProveedor"));
        col_descri_invent.setCellValueFactory(new PropertyValueFactory<ClsProductos, String>("descripcion"));
        col_cant_invent.setCellValueFactory(new PropertyValueFactory<ClsProductos, String>("cantidad"));
        col_precio_invent.setCellValueFactory(new PropertyValueFactory<ClsProductos, String>("precio_unitario"));


        tbl_inventario.setItems(producList);

    }

    //ELiminar un dato seleccionado

    public void deleteProduct(){

        try {
            //Llamo el item selecionado en la tabla de provedores en este caso el codigo el cual lo usare para buscarlo y eliminarlo

            String deletInv = tbl_inventario.getSelectionModel().getSelectedItem().id;

            Conexion cn = new Conexion();
            cn.conexion();
            String sql = "DELETE FROM `productos` WHERE id = " + "'" + deletInv + "'";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ps.execute();

            loadTableProduc();

            System.out.println("Dato eliminado exitosamente");

        }catch (Exception e){

            System.out.println("Error al Eliminar el dato en la base de datos" + e.getMessage());

        }

    }

    public void passProduc(){

        String passId = tbl_inventario.getSelectionModel().getSelectedItem().id;
        txf_id_invent.setText(passId);

        String passName = tbl_inventario.getSelectionModel().getSelectedItem().nombre;
        txf_name_invent.setText(passName);

        String passPre = tbl_inventario.getSelectionModel().getSelectedItem().precio_unitario;
        txf_prec_invent.setText(passPre);

        String passCant = tbl_inventario.getSelectionModel().getSelectedItem().cantidad;
        txf_cant_invent.setText(passCant);

        String passDescri = tbl_inventario.getSelectionModel().getSelectedItem().descripcion;
        txf_descri_invent.setText(passDescri);

        btn_regist_invet.setText("Actualizar");
        fillEmpresa();

        madre.getSelectionModel().select(registrar_producto);

    }



    //--------------------------------------------FIN de inventario--------------------------------------------------------
    //--------------------------------------------FIN de inventario--------------------------------------------------------
    //--------------------------------------------FIN de inventario--------------------------------------------------------
    //--------------------------------------------FIN de inventario--------------------------------------------------------
    //--------------------------------------------FIN de inventario--------------------------------------------------------


    //Metodos proveedor------------------------------------------------------------------------------------------------


    //Lleva a la agregar un nuevo proveedor
    public void irAggProvee(){
        btn_regist_provee.setText("Registrar");
        txf_id_provee.setEditable(true);
        madre.getSelectionModel().select(registrar_proveedor);
    }

    public void cleanProvee(){

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

    }


    //Registra un nuevo proveedor
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

                switch (btn_regist_provee.getText()){
                    case "Registrar":
                        try {

                            Conexion cn = new Conexion();
                            cn.conexion();
                            String sql = "insert into proveedor(empresa, codigo, encargado, correo, telefono, direccion) values(?,?,?,?,?,?)";
                            PreparedStatement ps = cn.conexion().prepareStatement(sql);

                            ps.setString(1, empresa);
                            ps.setString(2, id);
                            ps.setString(3, nombre);
                            ps.setString(4, correo);
                            ps.setString(5, telefono);
                            ps.setString(6, direccion);
                            ps.executeUpdate();

                            refreshTableProvee();

                            System.out.println("Datos Agregados correctamente");

                        } catch (Exception e){
                            System.out.println("Error al registrer el proveedor en la base de datos" + e.getMessage());
                        }

                        break;

                    case "Actualizar":

                        String passId = tbl_proveedores.getSelectionModel().getSelectedItem().codigo;

                        try {

                            Conexion cn = new Conexion();
                            cn.conexion();
                            String sql = "UPDATE  proveedor SET " +
                                    "empresa = ?" +
                                    ",encargado = ?" +
                                    ",correo = ?" +
                                    ",telefono = ?" +
                                    ",direccion = ?" +
                                    ",codigo = ?" +
                                    " WHERE codigo = ?";
                            PreparedStatement ps = cn.conexion().prepareStatement(sql);

                            ps.setString(1, empresa);
                            ps.setString(2, nombre);
                            ps.setString(3, correo);
                            ps.setString(4, telefono);
                            ps.setString(5, direccion);
                            ps.setString(6, id);
                            ps.setString(7,passId);
                            ps.executeUpdate();

                            refreshTableProvee();

                            System.out.println("Datos Actualizados correctamente");

                        } catch (Exception e){
                            System.out.println("Error al ACTUALIZAR el proveedor en la base de datos" + e.getMessage());
                        }

                        break;

                    default: System.out.println("No se REGISTRO ni se ACTUALIZO los datos");

                }
                cleanProvee();
                madre.getSelectionModel().select(proveedores);

            }else {
                System.out.println("Error PROVEEDOR no registrado por falta de datos.");
            }

    }

    public void irProvee(){
        cleanProvee();
       madre.getSelectionModel().select(proveedores);
    }

    //REFRESCAR TABLA PROVEEDORES
    public void refreshTableProvee(){

        try {

            proveeList.clear();

            Conexion cn = new Conexion();
            cn.conexion();
            String sql = "SELECT * FROM proveedor";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                proveeList.addAll(new ClsProveedores(
                        rs.getString("empresa"),
                        rs.getString("codigo"),
                        rs.getString("encargado"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                ));

            }

        }catch (Exception e){

            System.out.println("Error al Solicitar en la base de datos" + e.getMessage());

        }
    }

    //LLENA LA TABLA PROVEEDORES AL INICIO
    private void loadTableProvee() {

        refreshTableProvee();

        col_id_provee.setCellValueFactory(new PropertyValueFactory<ClsProveedores, String>("codigo"));
        col_empresa_provee.setCellValueFactory(new PropertyValueFactory<ClsProveedores, String>("empresa"));
        col_encargado_provee.setCellValueFactory(new PropertyValueFactory<ClsProveedores, String>("encargado"));
        col_dir_provee.setCellValueFactory(new PropertyValueFactory<ClsProveedores, String>("direccion"));
        col_correo_provee.setCellValueFactory(new PropertyValueFactory<ClsProveedores, String>("correo"));
        col_tel_proveedor.setCellValueFactory(new PropertyValueFactory<ClsProveedores, String>("telefono"));

        tbl_proveedores.setItems(proveeList);

    }

    //ELiminar un dato seleccionado

    public void deleteProvee(){

        try {
            //Llamo el item selecionado en la tabla de provedores en este caso el codigo el cual lo usare para buscarlo y eliminarlo

            String deletPro = tbl_proveedores.getSelectionModel().getSelectedItem().codigo;

            Conexion cn = new Conexion();
            cn.conexion();
            String sql = "DELETE FROM `proveedor` WHERE codigo = " + "'" + deletPro + "'";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ps.execute();

            loadTableProvee();

            System.out.println("Dato eliminado exitosamente");

        }catch (Exception e){

            System.out.println("Error al Eliminar el dato en la base de datos" + e.getMessage());

        }

    }

    //Pasar datos de la tabla a los campos
    public void passProvee(){

        String passId = tbl_proveedores.getSelectionModel().getSelectedItem().codigo;
        txf_id_provee.setText(passId);

        String passName = tbl_proveedores.getSelectionModel().getSelectedItem().encargado;
        txf_name_provee.setText(passName);

        String passEmp = tbl_proveedores.getSelectionModel().getSelectedItem().empresa;
        txf_empresa_provee.setText(passEmp);

        String passEmail = tbl_proveedores.getSelectionModel().getSelectedItem().correo;
        txf_email_provee.setText(passEmail);

        String passTel = tbl_proveedores.getSelectionModel().getSelectedItem().telefono;
        txf_tel_provee.setText(passTel);

        String passDir = tbl_proveedores.getSelectionModel().getSelectedItem().direccion;
        txf_dir_provee.setText(passDir);

        btn_regist_provee.setText("Actualizar");

        madre.getSelectionModel().select(registrar_proveedor);

    }


    /* Inicia Filtro de busquedas************************************************************************************************************
    *****************************************************************************************************************************************/

    // Estos metodos son utilizados para filtro_out_usr y filtro_in_usr
    @FXML
    private TextField filtro_in_usr, filtro_out_usr;

    public void filtroInUsr(){

        try {

            cn.conexion();
            String sql = "SELECT * FROM usuarios WHERE nombre LIKE '%" +filtro_in_usr.getText()+ "%'";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){

                if (!filtro_in_usr.getText().equals("")) {

                    filtro_out_usr.setText(rs.getString("nombre"));

                } else {
                    filtro_out_usr.setText("");
                }

            } else {
                filtro_out_usr.setText("");
            }

        } catch (SQLException e) {
            System.out.println("Error al filtrar la busqueda" + e.getMessage());
        }

    }


    public void accionUsr(){

        try {

            userList.clear();
            cn.conexion();
            String sql = "SELECT * FROM usuarios WHERE nombre LIKE '%" +filtro_out_usr.getText()+ "%'";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                userList.addAll( new ClsUsuarios(
                        rs.getString("id"),
                        rs.getString("nombreUsuario"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("rol"),
                        rs.getString("telefono")
                ));
            }

        } catch (Exception e){
            System.out.println("Error al agregar a la tabla el elemento filtrado" + e.getMessage());
        }
        filtro_in_usr.setText("");
    }




    // Estos metodos son utilizados para filtro_out_nuev y filtro_in_nuev
    @FXML
    private TextField filtro_out_nuev, filtro_in_nuev;

    public void filtroInNuev() {

        try {

            cn.conexion();
            String sql = "SELECT * FROM productos WHERE nombre LIKE '%" + filtro_in_nuev.getText() + "%'";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                if (!filtro_in_nuev.getText().equals("")) {

                    filtro_out_nuev.setText(rs.getString("nombre"));

                } else {
                    filtro_out_nuev.setText("");
                }

            } else {
                filtro_out_nuev.setText("");
            }


        } catch (SQLException e) {
            System.out.println("Error al filtrar la busqueda" + e.getMessage());
        }
    }

    @FXML
    private TableColumn<ClsProductos, String> col_id_nuevo, col_name_nuevo, col_pro_nuevo, col_descri_nuevo, col_cant_nuevo, col_precio_nuevo;
    private TableView<ClsProductos> tbl_nuevo;

    ObservableList<ClsProductos> nuevoList = FXCollections.observableArrayList();

    public void accionNuev(){

        try {


            cn.conexion();
            String sql = "SELECT * FROM productos WHERE nombre LIKE '%" +filtro_out_nuev.getText()+ "%'";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){

                nuevoList.addAll( new ClsProductos(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("empresaProveedor"),
                        rs.getString("precio_unitario"),
                        rs.getString("cantidad"),
                        rs.getString("descripcion")
                ));



            }

            col_id_nuevo.setCellValueFactory(new PropertyValueFactory<ClsProductos, String>("id"));

            tbl_nuevo.setItems(nuevoList);

        } catch (Exception e){
            System.out.println("Error al agregar a la tabla el elemento filtrado" + e.getMessage());
        }
        filtro_in_nuev.setText("");
        System.out.println(nuevoList);

    }




    // Estos metodos son utilizados para filtro_out_inv y filtro_in_inv
    @FXML
    private TextField filtro_out_inv, filtro_in_inv;

    public void filtroInInv(){

        try {

            cn.conexion();
            String sql = "SELECT * FROM productos WHERE nombre LIKE '%" +filtro_in_inv.getText()+ "%'";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){

                if (!filtro_in_inv.getText().equals("")) {

                    filtro_out_inv.setText(rs.getString("nombre"));

                } else {
                    filtro_out_inv.setText("");
                }

            } else {
                filtro_out_inv.setText("");
            }

        } catch (SQLException e) {
            System.out.println("Error al filtrar la busqueda" + e.getMessage());
        }
    }


    public void accionInv(){

        try {

            producList.clear();
            cn.conexion();
            String sql = "SELECT * FROM productos WHERE nombre LIKE '%" +filtro_out_inv.getText()+ "%'";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                producList.addAll( new ClsProductos(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("empresaProveedor"),
                        rs.getString("precio_unitario"),
                        rs.getString("cantidad"),
                        rs.getString("descripcion")
                ));
            }

        } catch (Exception e){
            System.out.println("Error al agregar a la tabla el elemento filtrado" + e.getMessage());
        }
        filtro_in_inv.setText("");
    }




    // Estos metodos son utilizados para filtro_out_prov y filtro_in_prov
    @FXML
    private TextField filtro_out_prov, filtro_in_prov;

    public void filtroInProv(){

        try {

            cn.conexion();
            String sql = "SELECT * FROM proveedor WHERE empresa LIKE '%" +filtro_in_prov.getText()+ "%'";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){

                if (!filtro_in_prov.getText().equals("")) {

                    filtro_out_prov.setText(rs.getString("empresa"));

                } else {
                    filtro_out_prov.setText("");
                }

            } else {
                filtro_out_prov.setText("");
            }

        } catch (SQLException e) {
            System.out.println("Error al filtrar la busqueda" + e.getMessage());
        }
    }

    public void accionProv(){

        try {

            proveeList.clear();
            cn.conexion();
            String sql = "SELECT * FROM proveedor WHERE empresa LIKE '%" +filtro_out_prov.getText()+ "%'";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                proveeList.addAll( new ClsProveedores(
                        rs.getString("empresa"),
                        rs.getString("codigo"),
                        rs.getString("encargado"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                ));
            }

        } catch (Exception e){
            System.out.println("Error al agregar a la tabla el elemento filtrado" + e.getMessage());
        }
        filtro_in_prov.setText("");
    }
}





