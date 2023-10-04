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

    public static void main(String[] args) {
      
       try {
            // Paso 1: Leer el archivo binario de empleados
            FileInputStream fileInputStream = new FileInputStream("fichero.dat");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            // Paso 2: Crear un documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();

            // Paso 3: Crear el nodo raíz y agregarlo al documento XML
            Element raiz = crearNodoPrincipal("listaEmpleados", documento);

            while (true) {
                try {
                    int id = dataInputStream.readInt();
                    String nombre = readString(dataInputStream);
                    double salario = dataInputStream.readDouble();

                    Element empleado = documento.createElement("empleado");
                    añadirNodo("id", Integer.toString(id), empleado, documento);
                    añadirNodo("nombre", nombre, empleado, documento);
                    añadirNodo("salario", Double.toString(salario), empleado, documento);

                    raiz.appendChild(empleado);
                } catch (EOFException e) {
                    // Se llegó al final del archivo, salir del bucle
                    break;
                }
            }

            // Paso 4: Generar el archivo XML
            System.out.println("Antes de generar el archivo XML");
            generarArchivo(documento, "empleados.xml");
            System.out.println("Después de generar el archivo XML");

            // Cerrar streams
            dataInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String readString(DataInputStream dataInputStream) throws IOException {
        int length = dataInputStream.readInt();
        byte[] bytes = new byte[length];
        dataInputStream.readFully(bytes);
        return new String(bytes, "UTF-8");
    }

    static void mostrarPantalla(Document archivo) {
        Source source = new DOMSource(archivo);
        Result salida = new StreamResult(System.out);
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, salida);
        } catch (TransformerException te) {
            System.out.println("Excepción del transformer.");
        }
    }

    static void generarArchivo(Document archivo, String nombre) {
        Source source = new DOMSource(archivo);
        Result salida = new StreamResult(new File(nombre));
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, salida);
        } catch (TransformerException te) {
            System.out.println("Excepción del transformer.");
        }
    }

    static void añadirNodo(String datoEmple, String texto, Element raíz, Document documento) {
        Element dato = documento.createElement(datoEmple);
        Text textoDato = documento.createTextNode(texto);
        dato.appendChild(textoDato);
        raíz.appendChild(dato);
    }

    static Element crearNodoPrincipal(String nombreNodo, Document documento) {
        Element nodoPrincipal = documento.createElement(nombreNodo);
        documento.appendChild(nodoPrincipal);
        return nodoPrincipal;
    }
}
