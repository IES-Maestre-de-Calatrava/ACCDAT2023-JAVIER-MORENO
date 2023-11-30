/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file3vistamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Patricia
 */
public class File3VistaMySql {

    static String driver;
    static Connection conexion;
    
    public static void main(String[] args) {
        try {
           establecerConexion();
           crearVista();
           consultarVista();
           conexion.close();
       } catch (ClassNotFoundException ex) {
           System.out.println(ex);
       } catch (SQLException ex) {
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
    
    private static void crearVista() throws SQLException {
        String sql ="CREATE VIEW VISTADEPARTS AS "
                +"SELECT D.DEPT_NO \"DEPT_NO\", D.NOMBRE \"DNOMBRE\", COUNT(E.EMP_NO) \"NUMEMPS\", AVG(E.SALARIO) \"MEDIA SALARIOS\" "
                +"FROM DEPARTAMENTOS D, EMPLEADOS E "
                +"WHERE D.DEPT_NO=E.DEPT_NO "
                +"GROUP BY D.DEPT_NO, D.DNOMBRE";
        
        Statement sentencia = conexion.createStatement();
        boolean valor = sentencia.execute(sql);
        if (valor) {
            System.out.println("Vista creada.");
        }
        sentencia.close();
    }
    
    private static void consultarVista() throws SQLException{
        String sql = "SELECT * FROM VISTADEPARTS";
        Statement sentencia = conexion.createStatement();
        boolean valor = sentencia.execute(sql);
        
        if (valor) {
            ResultSet resul = sentencia.getResultSet();
            while (resul.next()) {
                System.out.println("Número de departamento: "+resul.getInt(1)+ " "+
                "Nombre departamento: "+resul.getString(2)+" "+
                "Número de empleados: "+resul.getInt(3)+" "+
                "Media de los salarios: "+resul.getDouble(4));
            }
            resul.close();
        }
        sentencia.close();
    }
}
