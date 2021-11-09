package com.nerypolar.posgt;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private Connection connection;
    private String usuario = "pos_gt";
    private String password = "123";
    private String url = "jdbc:mysql://192.168.192.212:3306/pos_gt";
    private String driver = "com.mysql.cj.jdbc.Driver";

    public Connection conexion(){

        try{

            Class.forName(driver);

            connection = DriverManager.getConnection(url, usuario, password);

        } catch (Exception e){
            System.out.println("Error al conectar con la base de datos"+e.getMessage());
        }

        return connection;

    }



}
