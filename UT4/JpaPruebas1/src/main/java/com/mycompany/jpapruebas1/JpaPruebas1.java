/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jpapruebas1;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author b15-10m
 */
public class JpaPruebas1 {

    
    static EntityManagerFactory emfactory;
    static EntityManager entitymanager;

    public static void main(String[] args) {

        inicializaFactory();

        entitymanager.close();
        emfactory.close();
    }
    
    public static void inicializaFactory()
    {
        emfactory = Persistence.createEntityManagerFactory("com.mycompany_JpaPruebas1_jar_1.0-SNAPSHOTPU");
        entitymanager = emfactory.createEntityManager();
        System.out.println("conectado");
    }
    
    

    
    
}
