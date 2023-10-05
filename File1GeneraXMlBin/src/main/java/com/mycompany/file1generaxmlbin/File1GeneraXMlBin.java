/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file1generaxmlbin;

/**
 *
 * @author b15-10m
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;


public class File1GeneraXMlBin {

    public static void main(String args[]) throws EOFException, ParserConfigurationException, TransformerException{
        
        
        
        int cont = 0;
            int tamanoArray = 5;
            
            try{
                       
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(chooser);
            File fichero = chooser.getSelectedFile();
            DataInputStream dis = new DataInputStream(new FileInputStream(fichero));
            String[] nombres = new String [5];
            String[] telefonos = new String[5];
            String nombreLeido;
            String tlfLeido;
             
           int i=0;
           String value  ="Empleados";
           
           Document document = inicializar(value);
           Element nodo;
           
             while (cont<tamanoArray)
             {
                // Leemos los datos 
                nombreLeido = dis.readUTF();
                nombres[i] = nombreLeido;
                tlfLeido = dis.readUTF();
                telefonos[i] = tlfLeido;
                
  
                // Empezamos a montar el documento xml
                nodo = crearNodoPrincipal("empleado",document);
                añadirNodo("nombre", nombres[i], nodo, document);
                añadirNodo("telefono", telefonos[i], nodo, document);
                
                i++;
                cont++;
            }
            generarArchivo(document, "Empleados.xml");
              
            }catch(IOException ioe){
                System.out.println(ioe);
                
            }
        
    }
    static org.w3c.dom.Element añadirNodo (String datoEmple, String texto, org.w3c.dom.Element raíz, org.w3c.dom.Document documento) {
        org.w3c.dom.Element dato = documento.createElement(datoEmple);
        Text textoDato = documento.createTextNode(texto);
        dato.appendChild(textoDato);
        raíz.appendChild(dato);
        return dato;
    }
      static org.w3c.dom.Element añadirNodo (String datoEmple, org.w3c.dom.Element raíz, org.w3c.dom.Document documento) {
        org.w3c.dom.Element dato = documento.createElement(datoEmple);
        raíz.appendChild(dato);
        return dato;
    }
      static org.w3c.dom.Element crearNodoPrincipal(String nombreNodo, org.w3c.dom.Document documento) {
        org.w3c.dom.Element nodoPrincipal = documento.createElement(nombreNodo);
        documento.getDocumentElement().appendChild(nodoPrincipal);
        return nodoPrincipal;
    }
       static org.w3c.dom.Document inicializar (String nombre) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        org.w3c.dom.Document archivo = (org.w3c.dom.Document) implementation.createDocument(null, nombre, null);
        archivo.setXmlVersion("1.0");
        return archivo;
    }
       static void generarArchivo (Document archivo, String nombre) {
        Source source = new DOMSource(archivo);
        Result salida = new StreamResult(new File(nombre));
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, salida);
        } catch (TransformerException te) {
            System.out.println("Excepción del transformer.");
        }
    }
}
