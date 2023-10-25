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
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b15-10m
 */
public class EjercicioCompletoUnidad {

   public static void main(String[] args) {
        try {
            File f = new File("Departamentos2.txt");
            
            RandomAccessFile fich = new RandomAccessFile(f, "rw");
           EjercicioCompletoR1Crear.crearFichDepartamentos(fich,6,"CONTABILIDAD", "DAIMIEL");
           EjercicioCompletoR1Crear.crearFichDepartamentos(fich,4,"MARKETING", "PUERTOLLANO");
           EjercicioCompletoR1Crear.crearFichDepartamentos(fich,9,"FINANCIERO", "MANZANARES");
        
        //EjercicioCompletoR1Modificar.modificarConNum(fich, 9, "LOGISTICA", "ALMAGRO");
        //EjercicioCompletoR1Borrar.borradoLogico(fich, 4);
        
        
        
          fich.close();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
       
    }

public class EjercicioCompletoR1Crear {
    
    public static void escribirCadena(String cad, int tam, RandomAccessFile fich) {
        StringBuffer buffer = null;
        buffer = new StringBuffer(cad);
        buffer.setLength(tam);
        try {
        fich.writeChars(buffer.toString());
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
    
    public static void crearFichDepartamentos(RandomAccessFile fich, int numDepart, String nombre, String localidad){
        try {
       
        fich.writeInt(numDepart);
        escribirCadena(nombre, 20, fich);
        escribirCadena(localidad, 20, fich);
        
    } catch (IOException ioe) {
           System.out.println(ioe); 
        }
}
}

public class EjercicioCompletoR1Modificar {
    public static void modificarConNum(RandomAccessFile fich, int numDepart, String nuevoNombre,
            String nuevaLocalidad) {
        
        try {
             long tam=fich.length();
             boolean existe = false;
             String nombreViejo=null;
             String localidadVieja=null;
             while (fich.getFilePointer()<tam) {
                 int numero = fich.readInt();
                 
                 if (numero==numDepart) {
                     fich.seek(fich.getFilePointer());
                     nombreViejo=leerNombreD(fich);
                     localidadVieja=leerLocalidadD(fich);
                     fich.seek(fich.getFilePointer()-80);
                     EjercicioCompletoR1Crear.escribirCadena(nuevoNombre, 20, fich);
                     EjercicioCompletoR1Crear.escribirCadena(nuevaLocalidad, 20, fich);
                     existe=true;
                 }
             }
             
             if (existe) {
             System.out.println("Antiguo nombre: "+nombreViejo);
             System.out.println("Antigua localidad: "+localidadVieja);
             System.out.println("Nuevo nombre: "+nuevoNombre);
             System.out.println("Nueva localidad: "+nuevaLocalidad);
             } else {
                 System.out.println("No existe el departamento.");
             }
             
             
             fich.close();

        
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
    
    public static String leerNombreD(RandomAccessFile fich) {
        String nueva="";
        try {
            for (int i=0;i<20;i++){
            nueva=nueva+fich.readChar();
            }
            
           // fich.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return nueva;
    }
    
    public static String leerLocalidadD(RandomAccessFile fich) {
        String nueva="";
        try {
            for (int i=0;i<20;i++){
            nueva=nueva+fich.readChar();
            }
            
            //fich.close();
          
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return nueva;
        
    } 
}



public class EjercicioCompletoR1Borrar {
    public static void borradoLogico (RandomAccessFile fich, int numDepart) {
        
        try {      
            long tam=fich.length();
            boolean existe = false;
            //int totalDepart=0;
        
            while (fich.getFilePointer()<tam) {
                 
                 int numero = fich.readInt();
                 
                 if (numero==numDepart) {
                     fich.seek(fich.getFilePointer());
                     fich.writeInt(-1);
                     EjercicioCompletoR1Crear.escribirCadena("", 20, fich);
                     EjercicioCompletoR1Crear.escribirCadena("", 20, fich);
                     existe=true;
                     
                 } 
                 
             }
            
            
            
            if (!existe) {
                System.out.println("No existe el departamento.");
            } else {
                
                System.out.println("Departamento borrado correctamente.");
                //System.out.println("Total departamentos: "+totalDepart);
            }
            
            
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}

