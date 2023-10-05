/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.file1lecturasaxemple;

import java.util.jar.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author b15-10m
 */
public class GestionContenido extends DefaultHandler {
    
    public GestionContenido() {

    super();

    }
    public void startDocument() 
    {
    System.out.println("Comienzo documento");
    }
    public void endDocument() 
    {

    System.out.println("Final documento");

    }
    public void startElement(String uri, String nombre, String nombreC,  Attributes atts) 
    {

    System.out.printf("\tComienzo elemento: %s %n", nombre);

    }
    public void endElement(String uri, String nombre, String nombreC) {
    System.out.printf("\tFin elemento: %s %n", nombre);

    }
    public void characters(char[] ch, int inicio, int longitud) throws SAXException 
    {

    String car = new String(ch, inicio, longitud);
    car = car.replaceAll("[\t\n]","");
    System.out.printf("\tCaracteres: %s %n", car);

    }
    
}
