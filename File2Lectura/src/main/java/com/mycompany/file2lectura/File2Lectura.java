/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file2lectura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author b15-10m
 */
public class File2Lectura {

    public static void main(String[] args) {
               File fichero = new File(".\\fichero.txt");
        
        try {
            FileReader ficheroIn = new FileReader(fichero);
        
            int i;
           
            // 
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
