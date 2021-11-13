package com.nerypolar.posgt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClsEmpresas {

    String empresa;

    public ClsEmpresas() {

    }

    public ClsEmpresas(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString(){
        return empresa;
    }

    //Metodo de consulta de empresas
    public ObservableList<ClsEmpresas> getEmpresaList(){

        ObservableList<ClsEmpresas> empresaList = FXCollections.observableArrayList();

        try {

            empresaList.clear();

            Conexion cn = new Conexion();
            cn.conexion();
            String sql = "SELECT empresa FROM proveedor";
            PreparedStatement ps = cn.conexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                String EMPRESA = rs.getString("empresa");

                ClsEmpresas e = new ClsEmpresas(EMPRESA);

                empresaList.add(e);

            }

        }catch (Exception e){

            System.out.println("Error al Solicitar en la base de datos" + e.getMessage());

        }
        return empresaList;
    }

}
