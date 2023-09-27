/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accesoaleatorio;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-10m
 */
public class AccesoAleatorio {

    public static void main(String[] args) {
        
        
     File ficheroPrueba = new File(".\\fichero.dat");   
      StringBuffer buffer = null;
        try { 
            RandomAccessFile fichero = new RandomAccessFile(ficheroPrueba ,"rw");
            
            fichero.writeInt(33);
            /* buffer = new StringBuffer("GARCIA");
            fichero.writeChars(buffer.toString());
            buffer.setLength(5);
            
            buffer = new StringBuffer("GUILLERMO");
            fichero.writeChars(buffer.toString());
            
            buffer.setLength(5);
            buffer = new StringBuffer("PACO");
           
            fichero.writeChars(buffer.toString());
            buffer.setLength(5);
            
           
            */
            fichero.writeDouble(1000.33);
            fichero.close();
            
        } 

        catch (FileNotFoundException ex) 
        {
            
        } 
        
        catch (IOException ex) {
            Logger.getLogger(AccesoAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // LEER COMPLETO
        try{
            RandomAccessFile fichero = new RandomAccessFile(ficheroPrueba ,"rw");
            
            int record = 33;
            
            
        }
        catch(IOException ioe){
            
        }
        
      
    
    
  
    }
    
    
}
