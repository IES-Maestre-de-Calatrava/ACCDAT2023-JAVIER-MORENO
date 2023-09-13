/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file1mostrando;

import java.io.File;

/**
 *
 * @author b15-10m
 */
public class File1Mostrando {

    public static void main(String[] args) {
        System.out.println("Ficheros en el directorio del proyecto");
        
        File fi = new File(".");
        File[] archivos = fi.listFiles();
        
        for (int i=0;i<archivos.length;i++) 
        {
            if (archivos[i].isDirectory() )
            {
                System.out.println(archivos[i].getName()+"es un directorio");
           
            }
            else 
            {
            System.out.println(archivos[i].getName()+"es un fichero"); 
            }
        }
    }
}
