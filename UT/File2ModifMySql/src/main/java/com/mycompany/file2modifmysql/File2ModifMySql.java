/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file2modifmysql;

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
public class File2ModifMySql {
    
    static String driver;
    static Connection conexion;

    public static void main(String[] args) {
       try {
           establecerConexion();
           updateEmpleados(20,100);
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
    
    private static void updateEmpleados(int dep, int sal) throws SQLException {
        String sql = "update empleados set salario=salario+"+sal+"where dept_no="+dep;
        Statement sentencia = conexion.createStatement();
        boolean valor = sentencia.execute(sql);
        
        if (!valor) {
            int filas = sentencia.getUpdateCount();
            System.out.println("Se han actualizado "+filas+" filas.");
        }
        
        //Comprobar el update
        sql="select EMP_NO, APELLIDO, SALARIO, DEPT_NO from empleados where dept_no="+dep;
        sentencia=conexion.createStatement();
        valor=sentencia.execute(sql);
        
        if (valor) {
            ResultSet resul = sentencia.getResultSet();
            while (resul.next()) {
                System.out.println("EMP_NO: "+resul.getInt(1)+" "+
                "APELLIDO: "+resul.getString(2)+" "+
                "SALARIO: "+resul.getInt(3)+" "+
                "DEPT_NO: "+resul.getInt(4));
            }
        }
        sentencia.close();
    }
}
