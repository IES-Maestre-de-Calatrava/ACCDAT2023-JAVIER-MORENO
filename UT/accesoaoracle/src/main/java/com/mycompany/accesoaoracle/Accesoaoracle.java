/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accesoaoracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-01m
 */
public class Accesoaoracle {
    
    static String driver;
    static Connection conexion;
    static DatabaseMetaData dbmd;

    public static void main(String[] args) {
        
        
        try {
            establecerConexion();
            
            //System.out.println("Se ha establecido la conexión al usuario: "+conexion.getSchema());
            
            //consultaSencilla();
            
            //consultaExecute();
            
            //consultaPrepared();
            
            //insertarExecuteUpdate();
            
            //insertarExecute();
            
            //insertarPrepared();
            //consultaSencilla();
            
            //añadirCampo();
            
            //ejecutarProcedimiento(10);
            
            //ejecutarFuncion(10);
            
            dbmd = conexion.getMetaData();
            //obtenerInformacionDeConexion();
            //obtenerInformacionDeLasTablas();
            //obtenerInformacionDeLasColumnas();
            //obtenerInformacionDelResultSet();
            obtenerNumeroFilasDevueltas();
            
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Accesoaoracle.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private static void consultaSencilla() throws SQLException {
        //Ejecutar sentencia SQL y obtener los resultados
            Statement sentencia = conexion.createStatement();
            String sql = "select * from departamentos";
            ResultSet resul = sentencia.executeQuery(sql);
            
            while (resul.next()) {
                System.out.println("Número de departamento: "+resul.getInt(1)+ " "+
                "Nombre departamento: "+resul.getString(2)+" "+
                "Localidad: "+resul.getString(3));
            }
            resul.close();
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
            resul.close();
                
        }
        sentencia.close();
    }
    
    private static void consultaPrepared() throws SQLException {
        String sql = "select * from departamentos";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        int filas = sentencia.executeUpdate();
        
        if (filas > 0) {
            ResultSet resul = sentencia.getResultSet();
            
            while (resul.next()) {
                System.out.println("Número de departamento: "+resul.getInt(1)+ " "+
                "Nombre departamento: "+resul.getString(2)+" "+
                "Localidad: "+resul.getString(3));
            }
            resul.close();
                
        }
        sentencia.close();
    }
    
    private static void insertarExecuteUpdate() throws SQLException {
        int dep = 4;
        String dnombre = "Suministros";
        String loc = "Sevilla";
        //insert into departamentos values (4, 'Suministros', 'Sevilla')"
        String sql = "insert into departamentos values (" + dep +",'"+dnombre+"','"+loc+"')";
        
        Statement sentencia = conexion.createStatement();
        int filas = sentencia.executeUpdate(sql);
        
        sentencia.close();
    }
    
    private static void insertarExecute() throws SQLException {
        int dep = 5;
        String dnombre = "Exportación";
        String loc = "Bilbao";
        //insert into departamentos values (4, 'Suministros', 'Sevilla')"
        String sql = "insert into departamentos values (" + dep +",'"+dnombre+"','"+loc+"')";
        
        Statement sentencia = conexion.createStatement();
        boolean valor = sentencia.execute(sql);
       
        if (!valor) {
            int filas = sentencia.getUpdateCount();
            System.out.println("Se ha insertado "+filas+" filas.");
        }
        
        sentencia.close();
    }
    
    private static void insertarPrepared() throws SQLException {
        int dep = 6;
        String dnombre = "Importación";
        String loc = "Vigo";
        //insert into departamentos values (4, 'Suministros', 'Sevilla')"
        String sql = "insert into departamentos values (?,?,?)";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        
        sentencia.setInt(1, dep);
        sentencia.setString(2, dnombre);
        sentencia.setString(3, loc);
        
        int filas = sentencia.executeUpdate();
        
        if (filas > 0) {
            System.out.println("Se han insertado "+filas+" filas.");
        }
        
        sentencia.close();
    }
    
    private static void añadirCampo() throws SQLException {
        //alter table departamentos add (tlfn number(9))
        String sql = "alter table departamentos add (tlfn number(9))";
        Statement sentencia = conexion.createStatement();
        int filas = sentencia.executeUpdate(sql); //Al ser una instrucción DDL, siempre devolverá un 0
    }
    
    private static void ejecutarProcedimiento(int dept) throws SQLException {
        String sql = "{call nombre_depart_p(?,?)}";
        CallableStatement llamada = conexion.prepareCall(sql);
        
        llamada.setInt(1,dept);
        llamada.registerOutParameter(2, Types.VARCHAR);
        
        try {
        llamada.executeUpdate();
        String salida_return =  llamada.getString(2);
        System.out.println("El nombre del departamento es: "+salida_return);
        } catch (SQLException e) {
            if (e.getErrorCode() == 1403) {
                System.out.println("El número del departamento no existe.");
            } else {
                throw e;
            }
        }
    }
    
    private static void ejecutarFuncion(int dept) throws SQLException {
        String sql ="{?= call nombre_depart_f(?)}";
        CallableStatement llamada = conexion.prepareCall(sql);
        llamada.registerOutParameter(1, Types.VARCHAR);
        llamada.setInt(2, dept);
        try {
        llamada.executeUpdate();
        String salida_return = llamada.getString(1);
        System.out.println("El nombre del departamento es: "+salida_return);
    } catch (SQLException e) {
            if (e.getErrorCode() == 1403) {
                System.out.println("El número del departamento no existe.");
            } else {
                throw e;
            }
        }
}
    
    private static void obtenerInformacionDeConexion() throws SQLException {
        //Nombre del SGBD
        String nombre = dbmd.getDatabaseProductName();
        
        //Driver utilizado
        String driver = dbmd.getDriverName();
        
        //Dirección para acceder a la BBDD
        String url = dbmd.getURL();
        
        //Nombre del usuario
        String usuario = dbmd.getUserName();
        
        System.out.println("Nombre del SGBD: "+nombre);
        System.out.println("Nombre del driver: "+driver);
        System.out.println("URL de la BBDD: "+url);
        System.out.println("Nombre del usuario: "+usuario);
    }
    
    private static void obtenerInformacionDeLasTablas() throws SQLException {
        ResultSet resul = null;
        String[] tipos = {"TABLE"};
        String nombre_usuario;
        String nombre_tabla;
        
        resul = dbmd.getTables("ORCL18","DAM2", null, tipos);
        
        while (resul.next()) {
            nombre_usuario = resul.getString("TABLE_SCHEM");
            nombre_tabla = resul.getString("TABLE_NAME");
            System.out.println("USUARIO: "+nombre_usuario+" TABLA: "+nombre_tabla);
        }
    }
    
    private static void obtenerInformacionDeLasColumnas() throws SQLException {
        ResultSet resul = null;
        resul = dbmd.getColumns("ORCL18", "DAM2", "DEPARTAMENTOS", null);
        String nombre_tabla;
        String nombre_columna;
        
        while (resul.next()) {
            nombre_tabla = resul.getString("TABLE_NAME");
             nombre_columna = resul.getString("COLUMN_NAME");
            System.out.println("TABLA: "+nombre_tabla+" COLUMNA: "+nombre_columna);
        }
    }
    
    private static void obtenerInformacionDelResultSet() throws SQLException {
        Statement sentencia = conexion.createStatement();
        ResultSet rs = sentencia.executeQuery("select * from departamentos");
        
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
    
    private static void obtenerNumeroFilasDevueltas() throws SQLException {
        Statement sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = sentencia.executeQuery("select * from departamentos");
        int rows = 0;
        
        if (rs.last()) {
            rows = rs.getRow();
            rs.beforeFirst();
        }
        
        rs.close();
        sentencia.close();
        
        System.out.println("El número de filas devueltas es "+rows);
    }
}


