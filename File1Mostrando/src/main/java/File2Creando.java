
import java.io.File;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author b15-10m
 */
public class File2Creando 
{
    public static void main(String[] args) throws IOException 
    {
        File carpeta = new File(".");
        
        carpeta.mkdir();
        carpeta.getAbsolutePath();
                
    }
}
