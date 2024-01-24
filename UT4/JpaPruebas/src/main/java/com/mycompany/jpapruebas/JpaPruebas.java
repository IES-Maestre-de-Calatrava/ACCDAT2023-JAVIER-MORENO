/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jpapruebas;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
/**
 *
 * @author b15-10m
 */
public class JpaPruebas {

    
    static EntityManagerFactory emfactory;
    static EntityManager entitymanager;

    public static void main(String[] args) {

        inicializaFactory();

        int ej = 10;
        //mostrarej1(ej);
        
        int ej2 = 40;
        borrardepart(ej2);
        entitymanager.close();
        emfactory.close();
    }
    
    public static void inicializaFactory()
    {
        emfactory = Persistence.createEntityManagerFactory("com.mycompany_JpaPruebas_jar_1.0-SNAPSHOTPU");
        entitymanager = emfactory.createEntityManager();
        System.out.println("conectado");
    }
    
    
        // practica en casa
    
    //Realiza un programa que solicite el número de departamento y muestre los datos del
    //departamento y los de los empleados que pertenecen a dicho departamento.
    
    private static void mostrarej1(int ndep)
    {
        Query query = entitymanager.createNamedQuery("Departamentos.findByDeptNo");    
        query.setParameter("deptNo", ndep);    
        Departamentos depart = (Departamentos) query.getSingleResult();
        
        System.out.println("depart"+depart.getDnombre());
       // List<Departamentos> depart = query.getResultList();     
        /*
        for (Departamentos d:depart)
        {
            System.out.println("Nombre"+ d.getDnombre());
        }
          */   
        // ahora meto el cliente     
        TypedQuery<Empleados> empleadoquery = entitymanager.createQuery("SELECT e from Empleados e where e.deptNo.deptNo =:deptNo",Empleados.class);
        empleadoquery.setParameter("deptNo", ndep);
        
        List<Empleados> e = empleadoquery.getResultList();
        
        for (Empleados es: e)
        {
            System.out.println("Empleado"+ es.getApellido());
        }      
    } 
    
    
    public static void borrardepart(int ndep)
    {
        entitymanager.getTransaction().begin();
       
        TypedQuery<Departamentos> empleadoquery = entitymanager.createQuery("DELETE FROM Departamentos e where e.deptNo =:deptNo",Departamentos.class);
       
        empleadoquery.setParameter("deptNo", ndep);
        
        int contador = empleadoquery.executeUpdate();
        
        if (contador > 0)
        {
            System.out.println("borrado con exito");
        }
        else{
            System.out.println("sin exito");
        }
        entitymanager.getTransaction().commit();
    }
    
    public static void modificarej1(BigDecimal salario, int departamento)
    {
        Empleados empleado;
        empleado  = entitymanager.find(Empleados.class,99);
        
        entitymanager.getTransaction().begin();
        
        
        empleado.setSalario(salario);
        
        entitymanager.getTransaction().commit();
        
        
        
        
        
    }
    
      
}
