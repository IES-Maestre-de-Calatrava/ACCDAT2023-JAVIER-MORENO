/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lecturayescrituradeobjetos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author b15-10m
 */
public class LecturaYEscrituradeObjetos {

    public static void main(String[] args) {
        
    File fichero = new File(".//fichero.txt");

      
    }
    
        public static Object leerObjeto(String archivo) {
        Object objeto = null;
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
            objeto = entrada.readObject();
            System.out.println("Objeto leído del archivo: " + archivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objeto;
        
        
    }
        
        public static void escribirObjeto(Object objeto, String archivo) 
        {
            try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo))) 
            {
                salida.writeObject(objeto);
                System.out.println("Objeto guardado en el archivo: " + archivo);
            } 
            catch (IOException e) 
            {
            System.out.println("error e/s");
            } 
        }
}
