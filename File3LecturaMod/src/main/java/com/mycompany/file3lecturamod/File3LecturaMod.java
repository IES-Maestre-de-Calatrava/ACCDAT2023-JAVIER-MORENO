/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file3lecturamod;

import java.io.BufferedReader;
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
public class File3LecturaMod {

    public static void main(String[] args) {
      
        
        lecturafichero("fichero.txt",".\\");

    }
    
    public static void lecturafichero(String fichero , String ubicacion)
    {
        try {
      
            FileReader fichero1 = new FileReader(fichero);
            BufferedReader brfichero1 = new BufferedReader(fichero1);
        
            String linea;
            
            while((linea = brfichero1.readLine()) != null )
            {
                System.out.println(linea);
            }    
        
        
        } 
 
        catch (FileNotFoundException ex) {
            System.out.println("no se encuentra el archivo");
        } 
        
        catch (IOException ex) {
           
            
        } 
    }
}
