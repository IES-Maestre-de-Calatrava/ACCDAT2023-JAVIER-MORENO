/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accesooracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class AccesoOracle {
          static String driver;
          static Connection conexion;
    
    public static void main(String[] args) {
        
            
        
        try {   
            establecerConexion();
            //insertarExecuteUpdate();
            //insertarExecute();
            //insertarPrepared();
            consultaSencilla();
           
           // añadirCampo();
            
            
            
           // consultaExecute();
            //consultaPrepared();
            conexion.close();
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    
    private static void establecerConexion() throws ClassNotFoundException, SQLException {
        
        String driver = "oracle.jdbc.driver.OracleDriver";
        String urlconnection = "jdbc:oracle:thin:@localhost:1521/ORCL18";
            
            
            Properties propiedades = new Properties();
            
            propiedades.setProperty("user", "dam2");
            propiedades.setProperty("password", "dam2");
             Class.forName(driver);
   
             conexion = DriverManager.getConnection(urlconnection,propiedades);

    }
    
    
    private static void consultaSencilla() throws SQLException
    {
            String sql = "Select * from departamentos";
            Statement sentencia = conexion.createStatement();
            ResultSet resul = sentencia.executeQuery(sql);
            while(resul.next()){
                System.out.print("Número de departamento: "+resul.getInt(1));
                System.out.print("  Nombre de departamento: "+resul.getString(2));
                System.out.println("  Localizacion: "+resul.getString(3));
            }
            resul.close();
            sentencia.close();
            
            System.out.println("Se ha establecido la conexion al usuario: "+conexion.getSchema());
    }
    
    private static void consultaExecute() throws SQLException
    {
        
        String sql = "Select * from departamentos";
        
        // creamos el statement
        Statement sentencia = conexion.createStatement();
    
        // esto devuelve true o false
        Boolean valor = sentencia.execute(sql);
        
        // la recorremos
            if(valor)
            {
                //pillamos haber si hay valor
                ResultSet resul = sentencia.getResultSet();
                
                while(resul.next())
                {
                System.out.print("Número de departamento: "+resul.getInt(1));
                System.out.print("  Nombre de departamento: "+resul.getString(2));
                System.out.println("  Localizacion: "+resul.getString(3));
                }
                    //cierro el resul
                   resul.close();
            }
            // cierro la sentencia
            sentencia.close();
    
    }
    
    
    private static void consultaPrepared() throws SQLException
    {
       String sql = "Select * from departamentos";
        
        // creamos el preparedStatement
       PreparedStatement sentencia = conexion.prepareStatement(sql);
    
        
        int filas = sentencia.executeUpdate();
        
        // ahora lo que hacemos es ver cuantas filas tenemos, si tiene >0 se hace 
            if(filas > 0)
            {
                //pillamos haber si hay valor
                ResultSet resul = sentencia.getResultSet();
                
                while(resul.next())
                {
                System.out.print("Número de departamento: "+resul.getInt(1));
                System.out.print("  Nombre de departamento: "+resul.getString(2));
                System.out.println("  Localizacion: "+resul.getString(3));
                }
                    //cierro el resul
                   resul.close();
            }
            // cierro la sentencia
            sentencia.close();
    }

    
    private static void insertarExecuteUpdate() throws SQLException
    {
        // vamos a insertar un nº departamento
        int dep = 4;
        
        //con los siguientes parametros
        String dnombre = "Suministros";
        String loc = "Sevilla";
    
        //construimos el sql
        String sql="insert into departamentos values ("+dep+",'"+dnombre+"',+'"+loc+"')"; //importante las comillas
        
        //montamos el statement
        Statement sentencia = conexion.createStatement();
        int filas  = sentencia.executeUpdate(sql);
        
        sentencia.close();
    
    }
    
        private static void insertarExecute() throws SQLException
    {
        // vamos a insertar un nº departamento
        int dep = 5;
        
        //con los siguientes parametros
        String dnombre = "Exportacion";
        String loc = "Bilbao";
    
        //construimos el sql
        String sql="insert into departamentos values ("+dep+",'"+dnombre+"',+'"+loc+"')"; //importante las comillas
        
        //montamos el statement
        Statement sentencia = conexion.createStatement();
        
        Boolean valor = sentencia.execute(sql);
        
        // si te devuelve false, significa que no estas haciendo un executequery
        if(!valor)
        {
            int filas = sentencia.getUpdateCount(); //devuelve el nº de filas
            System.out.println("Se ha insertado " +filas+ "filas");
        }
        
        sentencia.close();
    
    }
        
    
    private static void insertarPrepared() throws SQLException
    {
        // vamos a insertar un nº departamento
        int dep = 6;
        
        //con los siguientes parametros
        String dnombre ="Importancia";
        String loc = "Vigo ";
    
        //construimos el sql
        
        //NOVEDAD
        String sql="insert into departamentos values(?,?,?)"; //importante las comillas
        
        //montamos el statement
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        
        //decimos lo que hay en cada interrogacion
        sentencia.setInt(1, dep);
        sentencia.setString(2, dnombre);
        sentencia.setString(3, loc);
        
        int filas  = sentencia.executeUpdate();
        
            if(filas > 0)
            {
                System.out.println("Se han insertado" + filas + "filas");
            }
        
        sentencia.close();
    
    }
    
    private static void añadirCampo() throws SQLException
    {
        // alter table departamentos add(tlfn number(9))
        
        String sql = "alter table departamentos add (tlfn number(9))";
    
        Statement sentencia = conexion.createStatement();
          
      
        int filas = sentencia.executeUpdate(sql); // al ser una instruccion DDL, siempre devolvera un 0
    
    }
    
}
