package com.nerypolar.posgt;

public class ClsProductos {

    String id;
    String nombre;
    String empresaProveedor;
    String precio_unitario;
    String cantidad;
    String descripcion;

    public ClsProductos(String id, String nombre, String empresaProveedor, String precio_unitario, String cantidad, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.empresaProveedor = empresaProveedor;
        this.precio_unitario = precio_unitario;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresaProveedor() {
        return empresaProveedor;
    }

    public void setEmpresaProveedor(String empresaProveedor) {
        this.empresaProveedor = empresaProveedor;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
