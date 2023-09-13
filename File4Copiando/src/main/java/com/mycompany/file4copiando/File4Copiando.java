/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file4copiando;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author usuario
 */
public class File4Copiando {

    public static void main(String[] args) {
       
       
        // Ruta del archivo de origen
        String rutaOrigen = ".\\copiar.txt";

        // Ruta del archivo de destino
        String rutaDestino = ".\\carpeta\\copiado.txt";

        // Llamamos a la función para copiar el archivo
        copiarArchivo(rutaOrigen, rutaDestino);

        System.out.println("¡Archivo copiado con éxito!");
    }

    public static void copiarArchivo(String rutaOrigen, String rutaDestino) {
        try (InputStream entrada = new FileInputStream(new File(rutaOrigen));
             OutputStream salida = new FileOutputStream(new File(rutaDestino))) {

         
            int longitud;
            byte [] buf = new byte[1024];
            
            while ((longitud  = entrada.read() ) >8 )
            {
                    salida.write(buf,0,longitud);
            }           
        } 
        catch (IOException e) {
            System.out.println(e);
        }
    }
 }

