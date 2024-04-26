package org.rafaelcastro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion instance;
    
    private String url = "jdbc:mysql://localhost:3306/superkinalin5cvdb?serverTimezone=GMT-6&useSSL=false";
    private String user = "JoseAguilar";
    private String password = "Aoz07295";
    
    private Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static Conexion getInstance(){
        if(instance == null){
            instance = new Conexion();
        }
        return instance;
    }
    
    public Connection obtenerConexion()throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
}