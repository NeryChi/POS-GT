package com.nerypolar.posgt;

public class ClsUsuarios {

    String id;
    String nombreUsuario;
    String nombre;
    String correo;
    String rol;
    String telefono;


    public ClsUsuarios(String id, String nombreUsuario, String nombre, String correo, String rol, String telefono) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {

        switch (rol){
            case "1":

                this.rol = "Administrador";
                System.out.println("Admin");

                break;

            case "2":

                this.rol = "Vendedor";
                System.out.println("Vendedor");

                break;

            default: System.out.println("Error de roles");

        }
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
