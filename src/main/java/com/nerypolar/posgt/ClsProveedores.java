package com.nerypolar.posgt;

public class ClsProveedores {

    String empresa;
    String codigo;
    String encargado;
    String correo;
    String telefono;
    String direccion;

    public ClsProveedores(String empresa, String codigo, String encargado, String correo, String telefono, String direccion) {
        this.empresa = empresa;
        this.codigo = codigo;
        this.encargado = encargado;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
