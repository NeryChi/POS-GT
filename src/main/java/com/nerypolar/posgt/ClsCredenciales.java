package com.nerypolar.posgt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClsCredenciales {

    String nombreUsuario;
    String password;
    String rol;

    public ClsCredenciales() {
    }

    public ClsCredenciales(String nombreUsuario, String password, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
