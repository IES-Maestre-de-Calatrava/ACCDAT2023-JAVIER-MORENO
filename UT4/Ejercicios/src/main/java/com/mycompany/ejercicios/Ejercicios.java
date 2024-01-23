/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicios;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author b15-20m
 */
public class Ejercicios {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public static void main(String[] args) {
        crearConexion();
        //insercion();
        //findJugadorById(5);
        //findByEdadYPais(14, new String[]{"FRANCIA", "ITALIA", "IRLANDA"});
        //updateEdadByPais("asdfasd");
        //findByPaisYDeporte("ESPAÑA", "Tenis");
        borrarPais("FRANCIA");
        em.close();
        emf.close();
    }
    //EJERCICIOS 1
    private static void crearConexion(){
        emf = Persistence.createEntityManagerFactory("./db/equipos.odb");
        em = emf.createEntityManager();      
    }
    
    
    private static void insercion(){
        em.getTransaction().begin();
        Paises eq1 = new Paises("ESPAÑA");
        em.persist(eq1);
        Paises eq2 = new Paises("FRANCIA");
        em.persist(eq2);
        Paises eq3 = new Paises("ITALIA");
        em.persist(eq3);
        Paises eq4 = new Paises("IRLANDA");
        em.persist(eq4);
        
        
        Jugadores j1 = new Jugadores("Maria","Voleybol", "Madrid", 14 , eq1);
        em.persist(j1);
        Jugadores j2 = new Jugadores("Miguel","Tenis", "Madrid", 15 , eq1);
        em.persist(j2);
        Jugadores j3 = new Jugadores("Mario","Baloncesto", "Guadalajara", 15 , eq1);
        em.persist(j3);
        Jugadores j4 = new Jugadores("Alicia","Tenis", "Madrid", 14 , eq1);
        em.persist(j4);
        Jugadores j5 = new Jugadores("Enzo","Padel", "Paris", 14 , eq2);
        em.persist(j5);
        Jugadores j6 = new Jugadores("Michel","Padel", "Rennes", 16 , eq2);
        em.persist(j6);
        Jugadores j7 = new Jugadores("Pietro","Tenis", "Roma", 14 , eq3);
        em.persist(j7);
        Jugadores j8 = new Jugadores("Sabatini","Tenis", "Roma", 16 , eq3);
        em.persist(j8);
        Jugadores j9 = new Jugadores("Peter","Fútbol", "Dublin", 14 , eq4);
        em.persist(j9);
        
        em.getTransaction().commit();
    }
    
    private static void findJugadorById(int idjugador){
        TypedQuery<Jugadores> query = em.createQuery("select from Jugadores where idjugador=:IDJUGADORP", Jugadores.class);
        query.setParameter("IDJUGADORP", idjugador);
        try{
            Jugadores j = query.getSingleResult();
            System.out.println(j.toString());
        }catch(NoResultException e){
            System.out.println("No existe jugador con ese id");
        }
    }
    
    
    //EJERCICIOS 2
    private static void findByEdadYPais(int edad, String[] paises){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Jugadores> query = cb.createQuery(Jugadores.class);
        Root<Jugadores> j = query.from(Jugadores.class);
        query.select(j);
        query.where(cb.equal(j.get("edad"), edad));
        List<String> paisesAFiltrar = Arrays.asList(paises);
        Predicate filtro = j.get("idequipo").get("nombrepais").in(paisesAFiltrar);
        query.where(filtro);
        
        List<Jugadores> list = em.createQuery(query).getResultList();
        for (Jugadores jugador : list){
            System.out.println(jugador.toString());
        }
    }
    
    private static void updateEdadByPais(String pais){
        TypedQuery<Integer> query = em.createQuery(
                "select idequipo from Paises p where p.nombrepais =:PAISP" , 
                Integer.class); 
        query.setParameter("PAISP",pais);
        try{
            int idpais = query.getSingleResult();
            em.getTransaction().begin();
            Paises p = em.find(Paises.class, idpais);
            int count = 0;
            if (p != null){
                Jugadores j;
                Collection<Jugadores> coleccion = p.getJugadoresCollection();
                count = coleccion.size();
                Iterator<Jugadores> it =coleccion.iterator();
                while (it.hasNext()){
                    j = it.next();
                    j.setEdad(j.getEdad() + 2);
                }
            }
            em.getTransaction().commit();
            if (count == 0){
                System.out.println("No existen jugadores de ese país");
            }else{
                System.out.println("Actualizado con éxito");
            }
        }catch(NoResultException e){
            System.out.println("No existe ese pais");
        }
    }    
    
    //EJERCICIOS MOD y BORRADO
    public static void findByPaisYDeporte(String pais, String deporte){
        String sql = "select j from Jugadores j where j.idequipo.nombrepais = :PAISP and j.deporte = :DEPORTEP";
        TypedQuery<Jugadores> query = em.createQuery(sql, Jugadores.class );
        query.setParameter("PAISP", pais);
        query.setParameter("DEPORTEP", deporte);
        List<Jugadores> jugadores = query.getResultList();
        for (Jugadores j : jugadores){
            System.out.printf("%d, %s, %s, %s, %d%n", j.getIdjugador(), j.getNombre(), j.getDeporte(),j.getCiudad(), j.getEdad());
        }
        if (jugadores.isEmpty()){
            System.out.println("No existe jugadores de ese país que practiquen ese deporte");
        }
    }
    
    
    public static void borrarPais(String pais){
        em.getTransaction().begin();
        String sql = "select j from Jugadores j where j.idequipo.nombrepais = :PAISP";
        TypedQuery<Jugadores> query = em.createQuery(sql, Jugadores.class );
        query.setParameter("PAISP", pais);
        List<Jugadores> jugadores = query.getResultList();
        for (Jugadores j : jugadores){
            j.setEquipo(null);
        }
        Query deleteQuery = em.createQuery("delete from Paises where nombrepais=:PAISP");
        deleteQuery.setParameter("PAISP", pais);
        deleteQuery.executeUpdate();
        em.getTransaction().commit();
    }
}
