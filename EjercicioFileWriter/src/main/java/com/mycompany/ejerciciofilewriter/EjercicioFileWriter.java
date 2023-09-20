/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciofilewriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-10m
 */
public class EjercicioFileWriter {

    public static void main(String[] args)
    {
           File ficheroprueba = new File(".\\ejemplo.txt");
        try {
            FileWriter ficheroOut = new FileWriter(ficheroprueba);
            char i = 'A';
            ficheroOut.write(i);
            ficheroOut.write('\n');
            
            // escribir el array caracteres
            
            char[] array = {'H','O','L','A'};
            ficheroOut.write(array);
            ficheroOut.write('\n');
            
            
            // añadimos un String va
               String cadena = "Viva España";
               ficheroOut.write(cadena);
              // 
            
              
              
              ficheroOut.close();
        } 
        catch (IOException ex) {
            System.out.println(ex);
        }
 
    }
 
   
    }

