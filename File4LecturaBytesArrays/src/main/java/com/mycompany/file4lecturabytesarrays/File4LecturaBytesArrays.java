/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file4lecturabytesarrays;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author usuario
 */
public class File4LecturaBytesArrays {

    public static void main(String[] args) {
     
       
        File fichero = new File(".//fichero.dat");
        try {
            // Crear un objeto FileInputStream para leer el archivo binario
            FileInputStream ficheroIn = new FileInputStream(fichero);
            DataInputStream entrada = new DataInputStream(ficheroIn);

            String nombre;
            String telefono;

            
            while (true) {
                nombre = entrada.readUTF(); 
                telefono = entrada.readUTF(); // 
                System.out.println("Nombre: " + nombre + ", Teléfono: " + telefono);
            }

        } catch (EOFException eof) {
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
}
