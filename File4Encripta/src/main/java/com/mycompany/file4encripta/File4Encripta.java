/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file4encripta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class File4Encripta {

    public static void main(String[] args) {
        //fichero para encriptar 
        
        
        File fichero = new File(".\\fichero.txt");
        File fichero2 = new File(".\\ficheroencriptado.txt");
        encriptar(fichero ,fichero2);
        
        
    }
    
    public static void encriptar(File origen , File destino)
    {
        //leer el fichero 
        try
        {
            //abrimos el fichero de origen 
            FileReader fr = new FileReader(origen); 
            
            // abrimos el fichero de destino pa poder escribir
            FileWriter fw = new FileWriter(destino);
            
            int caracter;
            
            while((caracter = fr.read()) != -1)
            {
                fw.write(caracter+3);
            }
            
            fr.close();
            fw.close();
            
        } 
        
        
        
        
        
        
        catch (FileNotFoundException ex) {
         Logger.getLogger(File4Encripta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(File4Encripta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    
    
    
}
