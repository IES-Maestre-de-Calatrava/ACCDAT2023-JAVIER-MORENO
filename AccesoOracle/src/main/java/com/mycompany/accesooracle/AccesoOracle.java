/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accesooracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-10m
 */
public class AccesoOracle {

    public static void main(String[] args) {

        try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            String urlconnection = "jdbc:oracle:thin:@localhost:1521/ORCL18";
            
            
            Properties propiedades = new Properties();
            
            propiedades.setProperty("user", "dam2");
            propiedades.setProperty("password", "dam2");
            
            
            Class.forName(driver);
            try 
            {
                Connection conexion = DriverManager.getConnection(urlconnection,propiedades);
            } 
            
            catch (SQLException ex) 
            {
                Logger.getLogger(AccesoOracle.class.getName()).log(Level.SEVERE, null, ex);
            }
            } 
                catch (ClassNotFoundException ex) 
                {
                    Logger.getLogger(AccesoOracle.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            

    }
}
