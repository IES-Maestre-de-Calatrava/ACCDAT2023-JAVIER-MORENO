/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file3eliminando;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author usuario
 */
public class File3Eliminando {

    public static void main(String[] args) throws IOException {
        
        File carpeta = new File(".\\carpeta");
        
        //carpeta.mkdir();
       // System.out.println(carpeta.getAbsolutePath()) ;
        
        File fichero1 = new File(".\\carpeta\\fichero1.txt");
        fichero1.delete();
        
        File fichero2 = new File(".\\carpeta\\fichero2.txt");
        fichero2.delete();
        
        carpeta.delete();
        
        //  FileUtils.deleteDirectory();
        
        
        
    }
}
