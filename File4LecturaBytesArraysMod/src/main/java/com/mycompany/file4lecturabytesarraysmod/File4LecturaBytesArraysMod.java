/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file4lecturabytesarraysmod;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author b15-10m
 */
public class File4LecturaBytesArraysMod {

    public static void main(String[] args) {
       
        File fichero = new File(".//fichero.dat");
        
        try {
            // Crear un objeto FileInputStream para leer el archivo binario
            FileInputStream ficheroIn = new FileInputStream(fichero);
            DataInputStream entrada = new DataInputStream(ficheroIn);

            String nombre;
            String telefono;
            boolean activo;

            
            while(entrada.available() > 0)
            {
                nombre = entrada.readUTF();
                telefono = entrada.readUTF();
                activo = entrada.readBoolean();
                
                System.out.println("Nombre: " + nombre + ", Teléfono: " + telefono + ", Activo Empresa: " +activo);
                      
            }
            ficheroIn.close();
            entrada.close();
        } 
        catch (EOFException eof) {
               System.out.println("fin del fichero");
               
        } 
        catch (IOException ex) {
            System.out.println("Excepcion e/s");
        }
    }
}
