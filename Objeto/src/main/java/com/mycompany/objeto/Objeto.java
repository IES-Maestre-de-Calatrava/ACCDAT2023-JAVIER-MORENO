/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.objeto;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author b15-10m
 */
public class Objeto {

     public static void main(String[] args) {
        // Crear instancias de personas
        Persona persona1 = new Persona("Juan Pérez", "+123456789");
        Persona persona2 = new Persona("María Rodríguez", "+987654321");
        Persona persona3 = new Persona("Pedro García", "+555555555");
        
        // Array de personas
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);

        // Escribir las personas en un archivo .dat
        File nombreArchivo = new File("personas.dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) 
        {
            oos.writeObject(personas);
            System.out.println("Las personas se han escrito en el archivo '" + nombreArchivo + "'");
        } 
        catch (IOException e) 
        {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        
        // Leer las personas desde el archivo .dat
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) 
        {
            ArrayList<Persona> personasLeidas = (ArrayList<Persona>) ois.readObject();
            for (Persona persona : personasLeidas) 
            {
                System.out.println(persona);
            }
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
