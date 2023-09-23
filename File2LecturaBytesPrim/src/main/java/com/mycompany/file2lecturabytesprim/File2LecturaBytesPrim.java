/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file2lecturabytesprim;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author usuario
 */
public class File2LecturaBytesPrim {

    public static void main(String[] args) {
        
         File fichero = new File(".//archivo.dat");  
         System.out.println("hola");
         try{
             
             FileInputStream ficheroIn = new FileInputStream(fichero);
             DataInputStream entrada = new DataInputStream(ficheroIn); 
         
            int entero = entrada.readInt();
            boolean prueba = entrada.readBoolean();
            char caracter = entrada.readChar();
      
            
             System.out.println(entero);
             System.out.println(prueba);
             System.out.println(caracter);
             ficheroIn.close();
             entrada.close();
         }
         catch (EOFException ex)
         {
             System.out.println(ex);
         }
         catch (IOException ex) 
         {
             System.out.println(ex);
         }
        
        
    }
}
