/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objectdbproyecto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author b15-04m
 */
public class Metodos {
       public static Date convertirDate(String fecha){
           Date date = null;
           try{
               date=new SimpleDateFormat("dd/MM/yy").parse(fecha);
           }
           catch(ParseException pe){
               
           }
           return date;
       }
}
