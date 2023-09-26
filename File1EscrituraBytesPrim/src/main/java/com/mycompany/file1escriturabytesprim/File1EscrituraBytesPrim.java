/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file1escriturabytesprim;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author usuario
 */
public class File1EscrituraBytesPrim {

    public static void main(String[] args) 
    {
          File fichero = new File(".//archivo.dat");  
          System.out.println(fichero.getAbsolutePath());
          int i = 3;
          char caracter = 'A';
          boolean prueba = true;
       try{
           FileOutputStream ficheroOut = new FileOutputStream(fichero);
           DataOutputStream salida = new DataOutputStream(ficheroOut);
           
           salida.writeInt(i);
           salida.writeBoolean(prueba);
           salida.writeChar(caracter);
           
           ficheroOut.close();
           salida.close();
        } 
        
        catch (FileNotFoundException ex) {
     
        } 
        catch (IOException ex) {
            
        }
       
       
    }
}
