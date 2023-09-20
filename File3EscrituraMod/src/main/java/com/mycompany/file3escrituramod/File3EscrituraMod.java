/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file3escrituramod;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author b15-10m
 */
public class File3EscrituraMod {

    public static void main(String[] args) {
             String linea = "hola que tal";
    try {
            // Abre el archivo en modo escritura
            FileWriter fileWriter = new FileWriter(".\\fichero.txt",true); 

            // Crea un BufferedWriter para escribir en el archivo
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            // Escribe la línea en el archivo
            bufferedWriter.write(linea);
            bufferedWriter.newLine();
            
           
            bufferedWriter.close();
            
            System.out.println("Se ha escrito la línea en el archivo con éxito.");
        } 
    catch (IOException e) {
            e.printStackTrace();
        }
    }
}
