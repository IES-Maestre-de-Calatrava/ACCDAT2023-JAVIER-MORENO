/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file1insertmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-01m
 */
public class File1InsertMySql {
    
    static String driver;
    static Connection conexion;

    public static void main(String[] args) {
        try {
            establecerConexion();
            
           // insertarExecute();
           // eliminarExecute(15);
           consultaExecute();
       
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
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
    
    private static void insertarExecute() throws SQLException {
        int dep = 15;
        String dnombre = "INFORMÁTICA";
        String loc = "MADRID";
        //insert into departamentos values (4, 'Suministros', 'Sevilla')"
        String sql = "insert into departamentos values (" + dep +",'"+dnombre+"','"+loc+"')";
        
        Statement sentencia = conexion.createStatement();
        boolean valor = sentencia.execute(sql);
        
        if (!valor) {
            int filas = sentencia.getUpdateCount();
            System.out.println("Se han insertado "+filas+" filas.");
        }
        sentencia.close();
        
        String sql2="select * from departamentos";
        Statement sentencia2=conexion.createStatement();
        ResultSet resul = sentencia2.executeQuery(sql2);
        while (resul.next()) {
            System.out.println("Número de departamento: "+resul.getInt(1)+ " "+
                "Nombre departamento: "+resul.getString(2)+" "+
                "Localidad: "+resul.getString(3));
        }
        resul.close();
        sentencia2.close();
    }
    
    
    
    private static void eliminarExecute(int dep) throws SQLException {
    String sql = "DELETE FROM departamentos WHERE dept_no = " + dep;

    Statement sentencia = conexion.createStatement();
    int filasEliminadas = sentencia.executeUpdate(sql);
    sentencia.close();

    if (filasEliminadas > 0) {
        int filas = sentencia.getUpdateCount();
        System.out.println("Se han borrado "+filas+" filas.");
    }
    sentencia.close();
}
    
    private static void consultaExecute() throws SQLException {
        String sql = "select * from departamentos";
        Statement sentencia = conexion.createStatement();
        boolean valor = sentencia.execute(sql);
        
        if (valor) {
            ResultSet resul = sentencia.getResultSet();
            while (resul.next()) {
                System.out.println("Número de departamento: "+resul.getInt(1)+ " "+
                "Nombre departamento: "+resul.getString(2)+" "+
                "Localidad: "+resul.getString(3));
            }
        }
    }

}
