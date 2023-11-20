/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file3descriporacle;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-01m
 */
public class File3DescripOracle {

    static String driver;
    static Connection conexion;
    static DatabaseMetaData dbmd;
    public static void main(String[] args) {
       try {
            establecerConexion();
            dbmd = conexion.getMetaData();
            
            obtenerInfoDelResultSet();
            
            
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(File3DescripOracle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(File3DescripOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void obtenerInfoDelResultSet() throws SQLException {
        Statement sentencia = conexion.createStatement();
        ResultSet rs = sentencia.executeQuery("select * from empleados");
        
        ResultSetMetaData rsmd = rs.getMetaData();
        
        //Devuelve el número de columnas devueltas por la tabla
        int numColumnas = rsmd.getColumnCount();
        
        //Devuelve el nombre de la columna de la posición "i"
        String nombre_columna = rsmd.getColumnName(2);
        
        //Devuelve el tipo de la columna de la posición "i"
        String tipo_columna = rsmd.getColumnTypeName(2);
        
        //Devuelve 1 si la columna puede contener nulos
        int valoresNulos = rsmd.isNullable(2);
        
        //Devuelve el máximo de caracteres de la columna de la posición "i"
        int tam_columna = rsmd.getColumnDisplaySize(2);
        
        System.out.println("NÚMERO DE CAMPOS DEVUELTOS: "+numColumnas);
        System.out.println("NOMBRE DEL CAMPO DE LA POSICIÓN 2: "+nombre_columna);
        System.out.println("TIPO DEL CAMPO: "+tipo_columna);
        System.out.println("TAMAÑO DEL CAMPO: "+tam_columna);
        System.out.println("ACEPTA NULOS: "+((valoresNulos==1)?"SÍ":"NO"));
    }
    
    private static void establecerConexion() throws ClassNotFoundException, SQLException {
            driver = "oracle.jdbc.driver.OracleDriver";
            String urlconnection = "jdbc:oracle:thin:@localhost:1521/ORCL18";
            
            Properties propiedades = new Properties();
            propiedades.setProperty("user", "dam2");
            propiedades.setProperty("password", "dam2");
            
            Class.forName(driver);
            conexion = DriverManager.getConnection(urlconnection, propiedades);
    }
}
