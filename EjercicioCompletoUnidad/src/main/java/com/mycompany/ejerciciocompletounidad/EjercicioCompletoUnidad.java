/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciocompletounidad;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-10m
 */
public class EjercicioCompletoUnidad {

    public static void main(String[] args) {
        
    
    File fichero = new File("Departamentos.dat");
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    public static void escribirdatos(int ndepartamento ,String nombre , String localidad, File ruta)
    {
        try{
            FileOutputStream fos = new FileOutputStream(ruta,true);
            DataOutputStream dos = new DataOutputStream(fos);
            
            dos.writeInt(ndepartamento);
            dos.writeUTF(nombre);
            dos.writeUTF(localidad);
                     
        } 
         
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(EjercicioCompletoUnidad.class.getName()).log(Level.SEVERE, null, ex);
        }
       catch (IOException e)
        {
            
        }     
    }
    
    public static void modificardepartamento(int ndepartamento , String nombrenuevo , String localidadnueva , File ruta)
    {
        //empezamos leyendo 
        try{
            FileInputStream fis = new FileInputStream(ruta);
            DataInputStream dis = new DataInputStream(fis);
            
            
            boolean encontrado = false;
            
            while (true)
            {
             int numero = dis.readInt();
             
                if (numero == ndepartamento)
                {

                }
                 
            }
                     
        } 
         
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(EjercicioCompletoUnidad.class.getName()).log(Level.SEVERE, null, ex);
        }
       catch (IOException e)
        {
            
        }   
    }
}
