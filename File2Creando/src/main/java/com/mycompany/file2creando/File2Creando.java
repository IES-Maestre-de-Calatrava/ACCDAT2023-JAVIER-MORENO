/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file2creando;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author b15-10m
 */
public class File2Creando {

    public static void main(String[] args) throws IOException 
    {
        File carpeta = new File(".\\carpeta");
        
        //carpeta.mkdir();
        System.out.println(carpeta.getAbsolutePath()) ;
        
        File fichero1 = new File(".\\carpeta\\fichero1.txt");
        fichero1.createNewFile();
        
        File fichero2 = new File(".\\carpeta\\fichero2.txt");
        fichero2.createNewFile();
        
        
        fichero2.delete();
        fichero1.delete();
        carpeta.delete();
    }
}