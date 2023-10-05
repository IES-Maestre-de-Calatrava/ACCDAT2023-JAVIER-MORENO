/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pasarxmlahtml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author b15-10m
 */
public class PasarXMLaHTML {

    public static void main(String[] args) throws IOException {
    
         String hojaEstilo = "alumnosPlantilla.xsl";
         String hojadatos = "Empleados.xml";
         String hojadatos2 = "alumnos.xml";
         pasarXMLaHTML(hojaEstilo , hojadatos );
         pasarXMLaHTML(hojaEstilo , hojadatos2, "pagina2.html");
         
        /*
    String hojaEstilo = "alumnosPlantilla.xsl";
    String datosAlumnos = "alumnos.xml";
    File pagHTML  = new File("Mipagina.html");
    
    // CREAR FICHERO HTML
    FileOutputStream os = new FileOutputStream(pagHTML);
    Source estilos = new StreamSource(hojaEstilo);
    Source datos = new StreamSource(datosAlumnos);
    
    //resultado del trasnformer
    Result result = new StreamResult(os);
    
    try {
        Transformer transformer = TransformerFactory.newInstance().newTransformer(estilos);
        transformer.transform(datos, result);
    }
    catch(Exception e)
    {
        
    }
    os.close();
    */
    }
    public static void pasarXMLaHTML(String hojaEstilo , String hojadatos) throws FileNotFoundException, IOException
    {
        
    File pagHTML  = new File("Mipagina.html");
    
    // CREAR FICHERO HTML
    FileOutputStream os = new FileOutputStream(pagHTML);
    
    // COGEMOS LA HOJA DE ESTILO QUE QUERAMOS UTILIZAR 
    Source estilos = new StreamSource(hojaEstilo);
    Source datos = new StreamSource(hojadatos);
    
    //resultado del trasnformer
    Result result = new StreamResult(os);
    
    try {
        Transformer transformer = TransformerFactory.newInstance().newTransformer(estilos);
        transformer.transform(datos, result);
    }
    catch(Exception e)
    {
        
    }
    os.close();
    }
 
    
     public static void pasarXMLaHTML(String hojaEstilo , String hojadatos , String nombrehtml) throws FileNotFoundException, IOException
    {
        
   
    
    // CREAR FICHERO HTML
    FileOutputStream os = new FileOutputStream(nombrehtml);
    Source estilos = new StreamSource(hojaEstilo);
    Source datos = new StreamSource(hojadatos);
    
    //resultado del trasnformer
    Result result = new StreamResult(os);
    
    try {
        Transformer transformer = TransformerFactory.newInstance().newTransformer(estilos);
        transformer.transform(datos, result);
    }
    catch(Exception e)
    {
        
    }
    os.close();
    }
}
