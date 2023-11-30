/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accesoaobjetosoracle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-10m
 */
public class AccesoaObjetosOracle {
    static String driver;
    static DatabaseMetaData dbmd; 
    static Connection conexion;
    
    
    public static void main(String[] args) {
        
        try
        {
            conectarBBDD();
            
            Statement stmt = conexion.createStatement();
            
            //obtengo los datos de la tabla
            ResultSet rset = stmt.executeQuery("select codigo,nombre,direc from alumno2");
            
            while (rset.next())
            {
                String codigo = rset.getString(1);
                String nombre = rset.getString(2);
                
                java.sql.Struct objeto = (java.sql.Struct) rset.getObject(3);
                
                //saco sus atributos
                Object[] atributos = objeto.getAttributes();
                
                String ciudad = (String) atributos[0];
                System.out.println("Codigo:"+codigo+ "NOMBRE:" +nombre+ "DIRECCION:"+ciudad);
            
            }
            rset.close();
            conexion.close();
                    
        }
        
        
         catch (SQLException ex) {
            Logger.getLogger(AccesoaObjetosOracle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoaObjetosOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private static void conectarBBDD() throws SQLException, ClassNotFoundException
    {
        driver = "oracle.jdbc.driver.OracleDriver";
        
        String url = "jdbc:oracle:thin:@localhost:1521/ORCL18";
        
        Properties propiedades = new Properties();
        Class.forName(driver);
        propiedades.setProperty("user","dam2");
        propiedades.setProperty("password", "dam2");
           
        conexion = DriverManager.getConnection(url,propiedades);
       
        System.out.println("Conectado correctamente");
       
    } 
}

