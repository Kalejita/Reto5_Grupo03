/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.*;

/**
 *
 * @author Monsters Family
 */
public class Conexion {
    
    private static final String UBICACION_DB = "ProyectosConstruccion.db";
    
    String url = "jdbc:sqlite:" + UBICACION_DB;
    
    String strConexionDB = url;
    
    Connection conn = null;
    
    public Conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionDB);
            System.out.println("Conexión establecida");
        } catch (Exception e) {
            System.out.println("Error de conexion " + e);
        }
    
    }
    
    public ResultSet consultarRegistros(String strSentenciaSQL){
        try{
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    
    
    }
    
}
