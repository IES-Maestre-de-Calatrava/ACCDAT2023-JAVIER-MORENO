/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lecturaxml;

import java.io.File;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author b15-10m
 */
public class LecturaXML {

    public static void main(String[] args)  
    {
        
        File fichero = new File("Empleados.xml");
        mostrarconsolaelementoraiz(fichero);
        
        
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            Document document = builder.parse(fichero);
            
            document.getDocumentElement().normalize();
            
            NodeList empleados = document.getElementsByTagName("Empleado");
            
                for(int i = 0 ; i<empleados.getLength() ; i++)
                {
                    Node emple = empleados.item(i);
                    if (emple.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element elemento = (Element) emple;
                        
                        // NodeList nodo = elemento.getElementsByTagName("id").item(0).getChildNodes();
                        //Node valornodo = (Node) nodo.item(0);
                        //System.out.println(valornodo.getNodeValue());
                        
                        System.out.println(elemento.getElementsByTagName("id").item(0).getTextContent());
                       
                    }
                }    
            }
          
            catch(ParserConfigurationException | SAXException | IOException ex)
            {
             System.out.println(ex);
            }
  }
    
    public static void mostrarconsolaelementoraiz(File fichero)
    {
            try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            Document document = builder.parse(fichero);
            
            document.getDocumentElement().normalize();
            
            document.getDocumentElement().getNodeName();
            
                System.out.println("la raiz es " + document.getDocumentElement().getNodeName());
        }
            
        catch(ParserConfigurationException | SAXException | IOException ex)
        {
             System.out.println(ex);
        }
    }
    
    public static void sacaratributoXml(File fichero,String id)
    {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            Document document = builder.parse(id);
            
            document.getDocumentElement().normalize();
            
            NodeList empleados = document.getElementsByTagName("Empleado");
            
                for(int i = 0 ; i<empleados.getLength() ; i++)
                {
                    Node emple = empleados.item(i);
                    if (emple.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element elemento = (Element) emple;
                        NodeList nodo = elemento.getElementsByTagName("id").item(0).getChildNodes();
                        Node valornodo = (Node) nodo.item(0);
                        System.out.println(valornodo.getNodeValue());
                       
                    }
                }
        }
        catch(ParserConfigurationException | SAXException | IOException ex)
        {
             System.out.println(ex);
        }
    }
}
