/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file5moviendo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author usuario
 */
public class File5Moviendo {

    public static void main(String[] args) {
        String rutaOrigen = ".\\fichero.txt";
        String rutaDestino = ".\\carpeta\\fichero.txt";

        moverArchivo(rutaOrigen, rutaDestino);

        System.out.println("Se ha movido con exito ");
    }

    public static void moverArchivo(String rutaOrigen, String rutaDestino) {
        File archivoOrigen = new File(rutaOrigen);
        File archivoDestino = new File(rutaDestino);

        try {
            
            Path origen = archivoOrigen.toPath();
            Path destino = archivoDestino.toPath();
            
            Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            
        
        } 
        
        catch (IOException e) {
            e.printStackTrace();
        }
}
}

