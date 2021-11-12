package com.nerypolar.posgt;

public class ClsProductos {

    String id;
    String nombre;
    String empresaProveedor;
    double precio_unitario;
    int cantidad;
    String descripcion;

    public ClsProductos(String id, String nombre, String empresaProveedor, double precio_unitario, int cantidad, String descripcion) {
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

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
