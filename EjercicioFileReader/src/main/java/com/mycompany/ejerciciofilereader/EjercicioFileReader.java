/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciofilereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-10m
 */
public class EjercicioFileReader 
{

    public static void main(String[] args) 
    {
        
        File ficheroPrueba = new File(".\\ejemplo.txt");
        
            EjercicioFileReader.lecturacaracteres(ficheroPrueba);
            System.out.println("");
             EjercicioFileReader.lecturacadena(ficheroPrueba);

     }    
        // esto seria un programa para leer caracter a caracter
        
        
        
        public static void lecturacaracteres(File ficheroPrueba)
        {
        try {
            FileReader ficheroIn = new FileReader(ficheroPrueba);
        
            int i;
            char letra;
          
    
            i = ficheroIn.read();

                while(i != -1)
                {
                    System.out.print((char)i);
                    letra = (char) i;
                    i = ficheroIn.read();
                }
            ficheroIn.close();
        } 
        
        catch(FileNotFoundException e){
            System.out.println("no se encuentra el archivo");
        }
       catch (IOException ex) {
           System.out.println(ex);
        }
           
        }
        
        public static void lecturacadena(File ficheroPrueba){
            try {
            FileReader ficheroIn = new FileReader(ficheroPrueba);
        
            int i;
           
            // asi lo unico que nos va a devolver son los primeros 20 caracteres que lea 
            char [] cadena =  new char[20];
            
            i = ficheroIn.read(cadena);
            String frase = "";
                    while(i != -1 )
                    {
                        frase =  frase + String.valueOf(cadena);
                         Arrays.fill(cadena, '\u0000');
                         
                         i = ficheroIn.read(cadena);
                    }
                    System.out.print(frase);

                
            ficheroIn.close();
        } 
        
        catch(FileNotFoundException e){
            System.out.println("no se encuentra el archivo");
        }
       catch (IOException ex) {
           System.out.println(ex);
        }

            
        }
}
