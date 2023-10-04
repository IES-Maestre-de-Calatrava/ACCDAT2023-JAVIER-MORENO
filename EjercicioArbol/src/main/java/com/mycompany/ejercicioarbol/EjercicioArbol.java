/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicioarbol;

/**
 *
 * @author b15-07m
 */
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class EjercicioArbol {

    public static void main(String[] args) {
       
       
       
        try {
            Document archivoEmpleados = inicializar("Empleados");
           
            Element nodo = crearNodoPrincipal("Empleado", archivoEmpleados);
            nodo = añadirNodo("id", "1", nodo, archivoEmpleados);
            añadirNodo("direccion", nodo, archivoEmpleados);
            añadirNodo("calle", "Toledo", nodo, archivoEmpleados);
           

            mostrarPantalla(archivoEmpleados);
            generarArchivo(archivoEmpleados, "Empleados.xml");
           
        } catch (ParserConfigurationException pce) {
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
   
    static Element añadirNodo (String datoEmple, String texto, Element raíz, Document documento) {
        Element dato = documento.createElement(datoEmple);
        Text textoDato = documento.createTextNode(texto);
        dato.appendChild(textoDato);
        raíz.appendChild(dato);
        return dato;
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
   
    static Document inicializar (String nombre) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document archivo = (Document) implementation.createDocument(null, nombre, null);
        archivo.setXmlVersion("1.0");
        return archivo;
    }
}
