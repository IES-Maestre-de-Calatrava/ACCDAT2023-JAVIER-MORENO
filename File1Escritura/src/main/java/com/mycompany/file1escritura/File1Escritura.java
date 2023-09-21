/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file1escritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-10m
 */
public class File1Escritura {

    public static void main(String[] args)
    {
            File fichero = new File(".\\ejemplo.txt");
        try {
            
            
            FileWriter ficheroOut = new FileWriter(fichero);

            char[] array = {'H','O','L','A'};
            ficheroOut.write(array);
            ficheroOut.write('\n');
            
            
            //otra alternativa
                for(int i = 0 ; i<array.length ; i++)
                {
                    ficheroOut.write(array[i]);
                }
                
             ficheroOut.close();
        } 
        catch (IOException ex) {
            System.out.println(ex);
        }
        
        
        
    }
        
        
        
    
}
