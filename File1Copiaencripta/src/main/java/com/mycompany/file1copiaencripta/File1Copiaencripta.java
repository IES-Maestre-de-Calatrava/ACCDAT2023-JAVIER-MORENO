/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file1copiaencripta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author b15-10m
 */
public class File1Copiaencripta {

public static void main(String[] args) {
        File origen=new File("..\\imagen.jpg");
        File destino=new File("..\\encriptado.jpg");
        
        try{
            DataInputStream dis=new DataInputStream(new FileInputStream(origen));
            DataOutputStream dos=new DataOutputStream(new FileOutputStream(destino));
            while(dis.available() > 0){
                dos.writeByte(dis.readByte()+1);
            }
            dis.close();
            dos.close();
        }
        catch(IOException ioe){
            System.out.println(ioe);
        }
        
        origen=new File("..\\encriptado.jpg");
        destino=new File("..\\desencriptado.jpg");
        
        
        try{
            DataInputStream dis=new DataInputStream(new FileInputStream(origen));
            DataOutputStream dos=new DataOutputStream(new FileOutputStream(destino));
            while(dis.available() > 0){
                dos.writeByte(dis.readByte()-1);
            }
            dis.close();
            dos.close();
        }
        catch(IOException ioe){
            System.out.println(ioe);
        }
        
    }

        
        

}
