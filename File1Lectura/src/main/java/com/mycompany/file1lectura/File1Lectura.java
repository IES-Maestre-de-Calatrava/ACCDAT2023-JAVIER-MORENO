/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file1lectura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-10m
 */
public class File1Lectura {

    public static void main(String[] args) {
        
        
        File fichero = new File(".\\ejercicio.txt");
        
        try {
      
         FileReader ficheroIn = new FileReader(fichero);   
                
          int i = ficheroIn.read();
           
            while(i != -1)
            {
                System.out.print((char)i);
                i= ficheroIn.read();
            }
         
          ficheroIn.close();
        }
        
        catch (FileNotFoundException ex)
        {
             System.out.println("no se ha encontrado el fichero"); 
        } 
        
        catch (IOException ex) 
        {
            System.out.println(ex);
        }
        
    }
}
