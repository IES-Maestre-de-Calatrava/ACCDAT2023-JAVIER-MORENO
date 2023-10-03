/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manejoarchivosxml1;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.DoubleStream.builder;
import static java.util.stream.IntStream.builder;
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

/**
 *
 * @author b15-10m
 */
public class ManejoArchivosXML1 {
public static void main(String[] args) {
       
       
       
        try {
            Document archivoEmpleados = inicializar("Empleados");
           
            Element nodo = crearNodoPrincipal("Empleado", archivoEmpleados);
            // nodo = añadirNodo("Empleado", nodo, archivoEmpleados);
            añadirNodo("id", "1", nodo, archivoEmpleados);
            añadirNodo("id", "2", nodo, archivoEmpleados);
           
            nodo = crearNodoPrincipal("Empleado", archivoEmpleados);
            añadirNodo("id", "2", nodo, archivoEmpleados);
           

            mostrarPantalla(archivoEmpleados);
            //generarArchivo(archivoEmpleados, "Empleados.xml");
           
            
            Document archivoEmples = inicializar("Empleados");
            Element nodo2 = crearNodoPrincipal("Empleado",archivoEmples);
            añadirNodo("id","",nodo2,archivoEmples);
            añadirNodo("descripcion","",nodo2,archivoEmples);
            
            System.out.println("");
            mostrarPantalla(archivoEmples);
        } 
        
        
        
        
        catch (ParserConfigurationException pce) {
            System.out.println("Excepción.");
        }  
        
       
        
    }
   
    static void mostrarPantalla (Document archivo) {
        Source source = new DOMSource(archivo);
        Result salida = new StreamResult(System.out);
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, salida);
        } catch (TransformerException te) {
            System.out.println("Excepción del transformer.");
        }
        
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
   
    static void añadirNodo (String datoEmple, String texto, Element raíz, Document documento) {
        Element dato = documento.createElement(datoEmple);
        Text textoDato = documento.createTextNode(texto);
        dato.appendChild(textoDato);
        raíz.appendChild(dato);
    }
   
    static Element añadirNodo (String datoEmple, Element raíz, Document documento) {
        Element dato = documento.createElement(datoEmple);
        raíz.appendChild(dato);
        return dato;
    }
   
    static Element crearNodoPrincipal(String nombreNodo, Document documento) {
        Element nodoPrincipal = documento.createElement(nombreNodo);
        documento.getDocumentElement().appendChild(nodoPrincipal);
        return nodoPrincipal;
    }
   
    static Document inicializar (String nombre)throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document archivo = (Document) implementation.createDocument(null, nombre, null);
        archivo.setXmlVersion("1.0");
        return archivo;
    }
}




