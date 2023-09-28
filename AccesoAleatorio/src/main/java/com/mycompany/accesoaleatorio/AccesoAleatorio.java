/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accesoaleatorio;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author b15-10m
 */
public class AccesoAleatorio {
public static int tamaño = 42;
       public static void main(String[] args) throws FileNotFoundException {
        
        File archivo;
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(chooser);
        archivo = chooser.getSelectedFile();
        RandomAccessFile fichero = new RandomAccessFile(archivo, "rw");
        StringBuffer buffer;
        StringBuffer buffer2;
        StringBuffer buffer3 = new StringBuffer("LOPEZ");
        
        try{
            
            fichero.writeInt(33);
            buffer = new StringBuffer("GARCIA");
            buffer.setLength(10);
            fichero.writeChars(buffer.toString());
            fichero.writeDouble(1000.33);
            
            fichero.seek(archivo.length());
            
            fichero.writeInt(65);
            buffer2 = new StringBuffer("DIAZ");
            buffer2.setLength(10);
          
            fichero.writeChars(buffer2.toString());
            fichero.writeDouble(1500);
            
            
        }
        catch(IOException ioe){
            System.out.println(ioe);
        }
        
        /**
        try{
            System.out.println("LLega aqui");
            System.out.println("Tamaño fichero = "+archivo.length());
            leerCompleto(archivo,fichero);
          
            fichero.close();
        }catch(IOException ioe){
            System.out.println(ioe);
        }
        */
                
        try{
            
            /**
            int id = 1;
            double salarioLeido = leerSalario(archivo, fichero,id);
            System.out.println("El salario del id "+id+" es de: "+salarioLeido);
            
            int id2 = 2;
            double salarioLeido2 = leerSalario(archivo, fichero, id2);
            System.out.println("El salario del id "+id+" es de: "+salarioLeido2);
            */
            
            /**
            leerCompleto(archivo, fichero, 1);
            leerCompleto(archivo, fichero, 2);
            * */
            escribirID(archivo, fichero, 7, 5, buffer3, 2500);
            leerCompleto(archivo, fichero, 7);
            
            
        }catch(IOException ioe){
            System.out.println(ioe);
        }
        
    }
  
    public static void leerCompleto(File archivo, RandomAccessFile fichero, int id) throws IOException{
      int pos = (id*32)-32;
     
      if(pos>fichero.length()){
          System.out.println("Este registro no existe");
      }else{
          fichero.seek(pos);
   
     System.out.println("Departamento:"+fichero.readInt());
     String nombre = "";
     for(int i=0;i<10;i++){
         nombre += fichero.readChar();
     }
     System.out.println("Nombre: "+nombre);
     System.out.println("Salario:" +fichero.readDouble());
      }
   
 }
 
    public static void escribirID(File archivo, RandomAccessFile fichero, int id, int depart, StringBuffer nombre,double salario) throws IOException{
     int pos = (id*32)-32;
     fichero.seek(pos);
     fichero.writeInt(depart);
     nombre = new StringBuffer(nombre);
     nombre.setLength(10);
     fichero.writeChars(nombre.toString());
     fichero.writeDouble(salario);
 }
 
    public static double leerSalario(File archivo, RandomAccessFile fichero, int id) throws IOException{
     
     int pos = (id*32)-8;
     
     System.out.println("Pos: "+pos);
     fichero.seek(pos);
     double salario = fichero.readDouble();
     return salario;
      
 }
 
 
    public static void modificarRegistro(int idBuscado, String nuevoNombre, int nuevaEdad, RandomAccessFile archivo) {
        try {
            archivo.seek(0);

            while (archivo.getFilePointer() < archivo.length()) {
                int id = archivo.readInt();
                long posicionInicio = archivo.getFilePointer(); // Guarda la posición de inicio del registro

                String nombre = archivo.readUTF();
                int edad = archivo.readInt();

                if (id == idBuscado) {
                    // Regresar al inicio del registro
                    archivo.seek(posicionInicio);

                    // Sobrescribe los nuevos datos en el registro
                    archivo.writeInt(id);
                    archivo.writeUTF(nuevoNombre);
                    archivo.writeInt(nuevaEdad);

                    // Sal del bucle una vez que se haya encontrado y modificado el registro
                    break;
                }
            }

            System.out.println("Registro modificado con éxito.");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
 
        
    } 

   public static void modificar(RandomAccessFile fichero, int id , double salario) throws IOException{
     
    int pos = (id * tamaño) - tamaño;
    
    fichero.seek(pos);
    fichero.skipBytes(24);
    fichero.writeDouble(salario);
    }

   public static void borradologiico(RandomAccessFile fichero, int id) throws IOException{
     
    int pos = (id * tamaño) - tamaño;
    
    fichero.seek(pos);
    fichero.writeInt(-1);
  
    }
   
      public static void recuperarregistro(RandomAccessFile fichero, int id) throws IOException{
     
    int pos = (id * tamaño) - tamaño;
    
    fichero.seek(pos);
    fichero.writeInt(id);
  
    }
}
