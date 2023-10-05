/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file1lecturasaxemple;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author b15-10m
 */
public class File1LecturaSAXEmple {

    // Realiza un proyecto que utilizando SAX lea el archivo XML de empleados y lo muestre por pantalla.
    public static void main(String[] args) {
       
    try {
        // 1º XMLReader  
  SAXParserFactory parserFactory = SAXParserFactory.newInstance();
  SAXParser parser = parserFactory.newSAXParser();
  XMLReader procesadorXML = parser.getXMLReader();
        
  GestionContenido gestor = new GestionContenido();
    procesadorXML.setContentHandler(gestor);
    InputSource fileXML = new InputSource("Empleados.xml");
    procesadorXML.parse(fileXML);
  

    }   
 
    catch (ParserConfigurationException ex) 
    {    
        Logger.getLogger(File1LecturaSAXEmple.class.getName()).log(Level.SEVERE, null, ex);
    } 
    catch (SAXException ex) 
    {
         Logger.getLogger(File1LecturaSAXEmple.class.getName()).log(Level.SEVERE, null, ex);
    }   
    catch (IOException ex) 
    {    
        Logger.getLogger(File1LecturaSAXEmple.class.getName()).log(Level.SEVERE, null, ex);
    }    
       
    
    
    
    
    }
        
}
