/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accesooracle;

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
    
          // para lo que ns que es
          static DatabaseMetaData dbmd;
    public static void main(String[] args) {
        
            
        
        try
        {   
            establecerConexion();
            dbmd = conexion.getMetaData();
            //obtenerInformacionDeConexion();
          //  practicarinsertarExecute();
           // insertarExecuteprueba2();
            //añadircampo2();
           // obtenerinformaciondeCONEXION2();

           obtenerinformaciontablas2();
            System.out.println("--------");
           obtenerInformacionColumnas2();
            System.out.println("----");
           obtenerInformacionResultSet2();
//obtenerInformacionDeLasTablas();
            System.out.println("--------------------------------------");
          //obtenerInformacionDeLasColumnas();
          
            System.out.println("--------------------------------------------------");
          //obtenerNumeroFilasDevueltas();
            //insertarExecuteUpdate();
           //insertarExecute();
           //insertarPrepared();
           // consultaSencilla();
           
           // ejecutarProcedimiento();
           // añadirCampo();
           // ejecturarFuncion(10);            
            
           // consultaExecute();
            //consultaPrepared();
            conexion.close();
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    
    private static void obtenerInformacionResultSet2() throws SQLException
    {
        
        Statement sentencia = conexion.createStatement();
        ResultSet resul = sentencia.executeQuery("SELECT * FROM DEPARTAMENTOS");
        
        ResultSetMetaData rsmd = resul.getMetaData();
        
        
        int numColumnas = rsmd.getColumnCount();
        
        String nombre_columna = rsmd.getColumnName(2);
        String tipo_columna = rsmd.getColumnTypeName(2);
        
        //devuelve 1 si la columna puede contener nulos
        
        int valores_nulos = rsmd.isNullable(2);
        
        int tamaño_columnas = rsmd.getColumnDisplaySize(2);
        
        System.out.println(numColumnas);
        System.out.println(nombre_columna);
        System.out.println(tipo_columna);
        System.out.println(tamaño_columnas);
        System.out.println("ACEPTA NULOS"+ ((valores_nulos == 1)? "SI" : "NO"));
        
        
    }
    private static void obtenerinformaciontablas2() throws SQLException
    {
        ResultSet resul = null;
        
        String[] tipos = {"TABLE"};
        
        String nombre_usuario;
        String nombre_tabla;

        resul = dbmd.getTables("ORCL18", "DAM2", null, tipos);
        
        while(resul.next())
        {
            nombre_usuario = resul.getString("TABLE_SCHEM");
            nombre_tabla = resul.getString("TABLE_NAME");
        
            System.out.println(nombre_usuario);
            System.out.println(nombre_tabla);
        }    
    }
    
    private static void obtenerInformacionColumnas2() throws SQLException
    {
        ResultSet resul = null;
        
        resul = dbmd.getColumns("ORCL18", "DAM2", "DEPARTAMENTOS", null);
        
        String nombre_tabla;
        String nombre_columna;
        while (resul.next())
        {
            nombre_tabla = resul.getString("TABLE_NAME");
            nombre_columna = resul.getString("COLUMN_NAME");
            
            System.out.println(nombre_tabla);
            System.out.println(nombre_columna);
        }
        
        
    }
    
    private static void obtenerNumerosFilasDevueltas2() throws SQLException
    {
        Statement sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = sentencia.executeQuery("SELECT * FROM DEPARTAMENTOS");
        
        int filas = 0;
        
        if(rs.last())
        {
            filas = rs.getRow();
            rs.beforeFirst();
        }
        rs.close();
        sentencia.close();
        
        System.out.println("filas " + filas);
    }
    
    private static void obtenerinformaciondeCONEXION2() throws SQLException
    {
        
        //nombre SGBD
        
        String nombre = dbmd.getDatabaseProductName();
        
        //driver
        String driver = dbmd.getDriverName();
        
        //direccion acceder a url 
        String url = dbmd.getURL();
        
        //nombre usuario
        String nombreusuario = dbmd.getUserName();
        
        System.out.println(nombre);
        System.out.println(driver);
        System.out.println(url);
        System.out.println(nombreusuario);
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
    
    private static void insertarExecuteprueba2() throws SQLException
    {
        // valores
      
        String dnombre = "CIUSEGUR";
        String loc = "VALDEPEÑAS";
        
        String sql = "DELETE FROM DEPARTAMENTOS WHERE DEPT_NO = 6";
        Statement sentencia = conexion.createStatement();
        
        Boolean valor = sentencia.execute(sql);
        
        if(!valor)
        {
            int filas = sentencia.getUpdateCount(); // devuelve nº de filas 
            System.out.println("se han borrado " + filas);
        }
        sentencia.close();
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

    private static void practicarinsertarExecute() throws SQLException
    {
        int dep = 15;
        String dnombre = "Exportacion";
        String loc = "Bilbao";
        
        String sql = "INSERT INTO DEPARTAMENTOS VALUES ("+dep+",'"+dnombre+"',+'"+loc+"')";
                
        Statement sentencia = conexion.createStatement();
        Boolean valor = sentencia.execute(sql);
        
        if(!valor)
        {
          int filas = sentencia.getUpdateCount();
            System.out.println("se han insertados " + filas);
            
        }
        sentencia.close();
    }
    
    // MODIFICAR AÑADIR CAMPO
    
    private static void añadircampo2() throws SQLException
    {
        String sql = "ALTER TABLE DEPARTAMENTOS ADD (tlfn number(9))";
        
        Statement sentencia = conexion.createStatement();
        
        int filas = sentencia.executeUpdate(sql); 
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
    
    
    private static void ejecutarProcedimiento() throws SQLException
    {
        String sql = "{call nombre_depart(?,?)}";
        
        CallableStatement llamada = conexion.prepareCall(sql); // esto es una especie de inicializar
                
                int dep = 10;
            llamada.setInt(1, dep);
            llamada.registerOutParameter(2, Types.VARCHAR);
            
            
        try{
                 llamada.executeUpdate();
            
            String salida_return = llamada.getString(2);
            
            System.out.println("El nombre del departamento es:" +salida_return); 
        }
        catch(SQLException e)
        {
            if(e.getErrorCode()==1403)
            {
                System.out.println("el nº de departamentono existe");
            }
            else
            {
                throw e;
            }
        } 
    }
    
    private static void ejecutarFuncion(int dept) throws SQLException 
    {
        String sql ="?=call nombre_depart_f (?))";
        
        CallableStatement llamada = conexion.prepareCall(sql);
        
        llamada.registerOutParameter(1, Types.VARCHAR);
        
        llamada.setInt(2,dept);
        
        llamada.executeUpdate();
        String salida_return = llamada.getString(1);
        
        System.out.println("el nombre de departamento es " +salida_return);
    }
    
    private static void ejecturarFuncion(int dept) throws SQLException{
        String sql="{?=call nombre_depart_f(?)}";
         CallableStatement llamada=conexion.prepareCall(sql);
         
         llamada.registerOutParameter(1, Types.VARCHAR);
         
         llamada.setInt(2, dept);
         
         llamada.executeUpdate();
         
         String salida_return=llamada.getString(1);
         
         System.out.println("El nombre del departamento es: "+salida_return);
    }

    // ns que es esto
    private static void obtenerInformacionDeConexion() throws SQLException
    {
        // Nombre del SGBD
        String nombre = dbmd.getDatabaseProductName();
        
        // Driver utilizado 
        String driver = dbmd.getDriverName();
        // Direccion para acceder a la BBDD
        
        String url = dbmd.getURL();
        
        //nombre usuario
        String usuario = dbmd.getUserName();
        
        System.out.println("Nombre del SGBD " + nombre);
        System.out.println("Driver " + driver);
        System.out.println("URL: " + url);
        System.out.println("Usuario " + usuario);
        
    }
    
    private static void obtenerInformacionDeLasTablas() throws SQLException
    {
        ResultSet resul = null;
        String[] tipos = {"TABLE"};
        String nombre_usuario;
        String nombre_tabla;
        resul = dbmd.getTables("ORCL18", "DAM2", null, tipos);
        
        while (resul.next())
        {
            nombre_usuario=resul.getString("TABLE_SCHEM");
            nombre_tabla = resul.getString("TABLE_NAME");
            
            System.out.println("USUARIO:" +nombre_usuario + " TABLA " + nombre_tabla);
        }
    }
    
    private static void obtenerInformacionDeLasColumnas() throws SQLException
    {
        ResultSet resul = null;
        
        resul = dbmd.getColumns("ORCL18", "DAM2", "DEPARTAMENTOS", null);
        
        String nombre_tabla;
        String nombre_columna;
        
        while (resul.next())
        {
            nombre_tabla = resul.getString("TABLE_NAME");
            nombre_columna = resul.getString("COLUMN_NAME");
            
            System.out.println("TABLA " + nombre_tabla + " COLUMNA" + nombre_columna);
        }
    }
    private static void obtenerInformacionDelResultSet() throws SQLException
    {
        Statement sentencia = conexion.createStatement();
        ResultSet rs = sentencia.executeQuery("Select * from departamentos");
        
        ResultSetMetaData rsmd = rs.getMetaData();
        
        int numColumnas = rsmd.getColumnCount();
        
        //devuelve el nombre de la columna de la posicion "i"
        
        String nombre_columna = rsmd.getColumnName(2);
        
        String tipo_columna = rsmd.getColumnTypeName(2);
        
        // devuelve 1 si la columna puede contener nulos 
        int valores_nulos = rsmd.isNullable(2);
    
    
           // devuelve el maximo numero de caracteres de la columna de la posicion i
           int tamaño_columnas = rsmd.getColumnDisplaySize(2);
           
           System.out.println("NUMEROS COLUMNAS DEVUELTAS "+ numColumnas);
           System.out.println("NOMBRE DEL CAMPO DE LA POSICION 2" + nombre_columna);
           System.out.println("TIPO DE LA COLUMNA "+ tipo_columna);
           System.out.println("TAMAÑO DE LA COLUMNA " + tamaño_columnas);
           System.out.println("ACEPTA NULOS" + ((valores_nulos == 1)? "Si" :"No"));
    }
    
    private static void obtenerNumeroFilasDevueltas() throws SQLException
    {
        Statement sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = sentencia.executeQuery("Select * from departamentos");
    
        int rows = 0;
        if (rs.last())
        {
           rows = rs.getRow();
           rs.beforeFirst();
        }
        rs.close();
        sentencia.close();
    
        System.out.println("El nº de filas devueltas es:" +rows);
    }
}
    
    
    
