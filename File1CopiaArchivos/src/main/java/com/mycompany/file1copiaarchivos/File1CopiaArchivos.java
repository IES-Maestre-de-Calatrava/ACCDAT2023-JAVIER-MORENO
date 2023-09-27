/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file1copiaarchivos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-10m
 */
public class File1CopiaArchivos {

 public static void main(String[] args) {
        

     
        File origen = new File("..\\instalador.exe");
        File destino = new File(".\\instalador.exe");
        try{
            
            FileInputStream in = new FileInputStream(origen);
            FileOutputStream out = new FileOutputStream(destino);
            
            byte[] leer = new byte[1024];
            
            int length;
         
            while((length = in.read(leer)) > 0)
            {
            //Va a escribir en el array de byte leer , desde la posicion 0 hasta la posicion que le indique la variable length
                out.write(leer,0,length);
                
            }
            System.out.println("Archivo copiado con exito");
            
            
            in.close();
            out.close();
        }
        catch(IOException ioe)
        {
            System.out.println(ioe);
        }
    }
 
 
 public static void encriptar(File origen , File destino)
    {
        //leer el fichero 
        try
        {
            //abrimos el fichero de origen 
            FileReader fr = new FileReader(origen); 
            
            // abrimos el fichero de destino pa poder escribir
            FileWriter fw = new FileWriter(destino);
            
            int caracter;
            
            while((caracter = fr.read()) != -1)
            {
                fw.write(caracter+3);
            }
            
            fr.close();
            fw.close();
            
        } 
      
        catch (FileNotFoundException ex) {
         
        } catch (IOException ex) {
            
        }
    }
            public static void desencriptar(File encriptado , File destino)
    {
        try{
            
            FileReader fr = new FileReader(encriptado);
            FileWriter fw = new FileWriter(destino);
            
            int caracter;
            while((caracter = fr.read() ) != -1)
            {
                fw.write(caracter -3 );
            }
            
            fr.close();
            fw.close();
            
        } 
        
        catch (FileNotFoundException ex) {
     
        } 
        catch (IOException ex) {
            
        }
    }
}
