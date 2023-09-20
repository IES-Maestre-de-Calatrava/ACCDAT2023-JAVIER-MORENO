/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file2escritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author b15-10m
 */
public class File2Escritura {

    public static void main(String[] args) {
        
         File fichero = new File(".\\fichero.txt");
        try {
            
            FileWriter ficheroOut = new FileWriter(fichero);

            String contenido = "Hola que tal";
            
            ficheroOut.write(contenido);
            ficheroOut.close();
              
              
        } 
        
        
        catch (IOException ex) {
            System.out.println(ex);
        }
        
        
        
    }
}
