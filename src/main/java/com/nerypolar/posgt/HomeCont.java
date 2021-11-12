package com.nerypolar.posgt;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            private ComboBox<String> cbx_rol_usr;

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
    private Button btn_acept_invent, btn_desh_invent;

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
    private TableColumn<ClsProductos, Integer> col_cant_invent;

    @FXML
    private TableColumn<ClsProductos, Double> col_precio_invent;

    ObservableList<ClsProductos> producList = FXCollections.observableArrayList();



            //Panel registrar inventario-------------------------------------------------------------------------------------

            @FXML
            private Tab registrar_producto;

            @FXML
            private TextField txf_name_invent;

            @FXML
            private TextField txf_id_invent;

            @FXML
            private ComboBox<String> cbx_idp_invent;

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
    private Button btn_desh_provee, btn_agreg_provee;

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
    }


    //Metodos usuario--------------------------------------------------------------------------------------------------

    public void irAggUsuario(){

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
            cbx_rol_usr.getSelectionModel().clearSelection();
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
    //Metodos inventario-----------------------------------------------------------------------------------------------
    //Metodos inventario-----------------------------------------------------------------------------------------------
    //Metodos inventario-----------------------------------------------------------------------------------------------
    //Metodos inventario-----------------------------------------------------------------------------------------------


    //TRAE EL ID DEL PROVEEDOR Y TAMBIEN NOMBRE DE LA EMPRESA
    public void idProveedor() {

        try {
            Conexion cn = new Conexion();
            cn.conexion();
            String sql = "SELECT A.codigo, A.empresa FROM proveedor A";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                String id = rs.getString("codigo");
                String empresa = rs.getString("empresa");
                cbx_idp_invent.getItems().addAll(id + " | " +empresa);
            }

        }catch (Exception e){

            System.out.println("Error al Solicitar en la base de datos" + e.getMessage());

        }

    }

    public void irAggProduc(){
        idProveedor();
        madre.getSelectionModel().select(registrar_producto);
    }

    public void aggProduc(){
        boolean registroPro = true;
        String id = txf_id_invent.getText();
        String nombre = txf_name_invent.getText();
        String idp = cbx_idp_invent.getSelectionModel().getSelectedItem();
        String prec = txf_prec_invent.getText();
        String cant = txf_cant_invent.getText();
        String descri = txf_descri_invent.getText();

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

            try {
                Conexion cn = new Conexion();
                cn.conexion();
                String sql = "insert into productos(id, nombre, empresaProveedor, precio_unitario, cantidad, descripcion) values(?,?,?,?,?,?)";
                PreparedStatement ps = cn.conexion().prepareStatement(sql);

                ps.setString(1, id);
                ps.setString(2, nombre);
                ps.setString(3, idp);
                ps.setString(4, prec);
                ps.setString(5, cant);
                ps.setString(6, descri);
                ps.executeUpdate();
                System.out.println("Datos Agregados correctamente");

                refreshTable();//RECARGA LA TABLA INVENTARIO

            }catch (Exception e){

                System.out.println("Error al registrar el producto en la base de datos" + e.getMessage());

            }

            txf_id_invent.setText("");
            txf_name_invent.setText("");
            cbx_idp_invent.setPromptText("");
            txf_prec_invent.setText("");
            txf_cant_invent.setText("");
            txf_descri_invent.setText("");
            madre.getSelectionModel().select(inventario);

        }else {
            System.out.println("Error PRODUCTO no registrado por falta de datos.");
        }
    }

    public void irInvent(){
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
                        rs.getDouble("precio_unitario"),
                        rs.getInt("cantidad"),
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
        col_cant_invent.setCellValueFactory(new PropertyValueFactory<ClsProductos, Integer>("cantidad"));
        col_precio_invent.setCellValueFactory(new PropertyValueFactory<ClsProductos, Double>("precio_unitario"));

        tbl_inventario.setItems(producList);

    }


    //--------------------------------------------FIN de usuario--------------------------------------------------------
    //--------------------------------------------FIN de usuario--------------------------------------------------------
    //--------------------------------------------FIN de usuario--------------------------------------------------------
    //--------------------------------------------FIN de usuario--------------------------------------------------------
    //--------------------------------------------FIN de usuario--------------------------------------------------------


    //Metodos proveedor------------------------------------------------------------------------------------------------


    //Lleva a la agregar un nuevo proveedor
    public void irAggProvee(){ madre.getSelectionModel().select(registrar_proveedor);}


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
}






