package com.nerypolar.posgt;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private Connection connection;
    private String usuario = "sql5450305";
    private String password = "8SJQzUmE7X";
    private String url = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql5450305";
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
