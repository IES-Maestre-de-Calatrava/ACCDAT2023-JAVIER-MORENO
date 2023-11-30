/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file2descriporacle;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-01m
 */
public class File2DescripOracle {
    static String driver;
    static Connection conexion;
    static DatabaseMetaData dbmd;

    public static void main(String[] args) {
         try {
            establecerConexion();
            dbmd = conexion.getMetaData();
            
            obtenerInformacion();
            
            
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(File2DescripOracle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(File2DescripOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
     private static void obtenerInformacion() throws SQLException {
        //Producto
        String nombre = dbmd.getDatabaseProductName();
        
        //Driver
        String driver = dbmd.getDriverName();
        
        //URL
        String url = dbmd.getURL();
        
        //Nombre de usuario
        String usuario = dbmd.getUserName();
        
        ResultSet resul = null;
        String[] tipos = {"TABLE"};
        String nombre_tabla;
        
        resul = dbmd.getTables("ORCL18","DAM2", null, tipos);
        
        System.out.println("Nombre del SGBD: "+nombre);
        System.out.println("Nombre del driver: "+driver);
        System.out.println("URL de la BBDD: "+url);
        System.out.println("Nombre del usuario: "+usuario);
        
        while (resul.next()) {
            nombre_tabla = resul.getString("TABLE_NAME");
            System.out.println("TABLA: "+nombre_tabla);
            obtenerPK(nombre_tabla);
            obtenerFKSalientes(nombre_tabla);
            obtenerFKHaciaTabla(nombre_tabla);
        }
  
    }
     
     private static void obtenerPK(String nombreTabla) throws SQLException {
        ResultSet pk = dbmd.getPrimaryKeys(null, "DAM2", nombreTabla);
        
        while (pk.next()) {
            String nombre_tabla = pk.getString("TABLE_NAME");
            String nombre_columna = pk.getString("COLUMN_NAME");
            System.out.println("Tabla: " + nombre_tabla + ", PK Columna: " + nombre_columna);
        }
     }
     
     private static void obtenerFKSalientes(String nombreTabla) throws SQLException {
        ResultSet fk = dbmd.getImportedKeys(null, "DAM2", nombreTabla);
        
        while (fk.next()) {
            String nombre_tabla = fk.getString("FKTABLE_NAME");
            String nombre_columna = fk.getString("FKCOLUMN_NAME");
            System.out.println("Tabla: " + nombre_tabla + ", FK Saliente: " + nombre_columna);
        }
     }
     
     private static void obtenerFKHaciaTabla(String nombreTabla) throws SQLException {
        ResultSet fk = dbmd.getExportedKeys(null, "DAM2", nombreTabla);
        
        while (fk.next()) {
            String nombre_tabla = fk.getString("FKTABLE_NAME");
            String nombre_columna = fk.getString("FKCOLUMN_NAME");
            System.out.println("Tabla: " + nombre_tabla + ", FK Apuntando a tabla: " + nombre_columna);
        }
     }
     
    
}
