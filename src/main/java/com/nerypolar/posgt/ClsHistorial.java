package com.nerypolar.posgt;

public class ClsHistorial {

    String id;
    String nombre;
    String direccion;
    String nit;
    String total;

    public ClsHistorial() {
    }

    public ClsHistorial(String id, String nombre, String direccion, String nit, String total) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        this.total = total;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
