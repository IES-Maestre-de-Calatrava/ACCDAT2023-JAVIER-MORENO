/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file3escriturabytesarrays;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author usuario
 */
public class File3EscrituraBytesArrays {

    public static void main(String[] args) {

        File fichero = new File(".//fichero.dat");
        String[] nombres = {"Sofia","Javier","Sebastian"};
        String[] numeros = {"69103181","69103182","69103183"};
    
        try{
            FileOutputStream fos = new FileOutputStream(fichero);
            DataOutputStream dos = new DataOutputStream(fos);
            
            for(int i = 0; i<nombres.length ;i++)
            {
                dos.writeUTF(nombres[i]);
                dos.writeUTF(numeros[i]);
            }
            
            fos.close();
            dos.close();
            
        }
        catch(IOException ioe)
        {
            
        }
    }
}
