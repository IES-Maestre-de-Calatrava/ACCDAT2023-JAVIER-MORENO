/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file5desencripta;

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
public class File5Desencripta {

    public static void main(String[] args) {
       
        File fichero = new File(".\\ficheroencriptado.txt");
        File destino = new File(".\\ficherodesencriptado.txt");
        
        desencriptar(fichero , destino);
        
    }
    
    public static void desencriptar(File encriptado , File destino)
    {
        try{
            
            FileReader fr = new FileReader(encriptado);
            FileWriter fw = new FileWriter(destino);
            
            int caracter;
            while((caracter = fr.read() ) != -1)
            {
                fw.write(caracter -3 );
            }
            
            fr.close();
            fw.close();
            
        } 
        
        catch (FileNotFoundException ex) {
     
        } 
        catch (IOException ex) {
            
        }
    }
}
