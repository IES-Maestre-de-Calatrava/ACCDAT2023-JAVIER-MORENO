/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.file3eliminando;

import java.io.File;

/**
 *
 * @author b15-10m
 */
public class EliminarRecursivo {
    
    public static void main(String[] args) {
        File fi = new File(".\\carpeta");
        File[] archivos = fi.listFiles();
       
        boolean haycarpeta = false;
        
        
        
        for (File e: archivos)
        { 
            if (e.isDirectory())
            {
                System.out.println("no puede ser eliminado");
                haycarpeta = true;
            }
            else if (e.isFile())
            {
                e.delete();
            }    
        }
        
        if (haycarpeta)
        {
             System.out.println("No se ha podido eliminar la carpeta principal ya que hay otras carpetas dentro");
        }
        else
        {
            fi.delete();
        }
    }
}
