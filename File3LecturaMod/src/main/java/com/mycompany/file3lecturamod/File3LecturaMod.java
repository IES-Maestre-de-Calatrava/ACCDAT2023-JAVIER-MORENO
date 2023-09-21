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
import javax.swing.JFileChooser;

/**
 *
 * @author b15-10m
 */
public class File3LecturaMod {

    public static void main(String[] args) {
      
        //llamamos el metodo
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(null);
        
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        
         String rutaarchivo = null;
        if (result == JFileChooser.APPROVE_OPTION) 
        {
        // El usuario seleccionó un archivo
             rutaarchivo = fileChooser.getSelectedFile().getAbsolutePath();
             System.out.println("Archivo seleccionado: " + rutaarchivo);
        }
        
        lecturafichero("fichero.txt", rutaarchivo);

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
        
        
            fichero1.close();
            brfichero1.close();
        } 
 
        catch (FileNotFoundException ex) {
            System.out.println("no se encuentra el archivo");
        } 
        
        catch (IOException ex) {
           
            
        } 
    }
}
