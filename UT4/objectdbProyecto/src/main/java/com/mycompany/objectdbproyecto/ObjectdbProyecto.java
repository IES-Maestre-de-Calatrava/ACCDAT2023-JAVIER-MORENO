/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.objectdbproyecto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author b15-04m
 */
public class ObjectdbProyecto {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    
       public static void main(String[] args) {
        crearConexion();
        
     // consultaJugadoresPorPaisYEdad(14, "Irlanda", "Francia", "Italia");
      consultarjugadores14años();
        // insertarpaises();
        
        

        
        
        
        //insertarDatos();
        //consultaDatosUsuarioConPedidos(1);
        //borrarDatos(1);
        //consultaDatosUsuario(1);
        //modificarDatos(1,"Miguel");
        //consultaDatosUsuariosConJPQL(8);
        //consultaDatosUsuariosConJPQLMuchos();
        //borrarDatosConJPQL(1);
        //modificarDatosConJPQL(2,"AMAI");
        //consultaDatosUsuariosConJPQLMuchos();
        //consultaVariosCamposConJPQL();
        //consultaDatosUsuariosCoNAMED(2);
        //consultaDatosUsuariosConNamedMuchos();
        //consultaUsuarioCriteriaQuery();
        //consultaVariosCamposConCriteriaQuery();
        //consultaVariosCamposConCriteriaQuery(3);
        //consultaDatosProductosCoNAMED(2);
        //consultaDatosProductosCoNAMEDMuchos();
        
        em.close();
        emf.close();
    }
    
    
    
    
    
    
    private static void crearConexion(){
        //Cadena de conexión a Docker
        //emf=Persistence.createEntityManagerFactory("objectdb://localhost/proyecto.odb;user=admin;password=admin");
        //em=emf.createEntityManager();
        
        //Conexion a archivo en local
        emf=Persistence.createEntityManagerFactory("./db/equipos.odb");
        em=emf.createEntityManager();
        System.out.println("conectado :)");
    }
   
    private static void insertarpaises()
    {
        em.getTransaction().begin();       
        Paises eq1 = new Paises("ESPAÑA",1);
        em.persist(eq1);
    
        Paises eq2 = new Paises("Francia",2);
        em.persist(eq2);
        
        Paises eq3 = new Paises("Italia",3);
        em.persist(eq3);
        
        Paises eq4 = new Paises("Irlanda",4);
        em.persist(eq4);
        
        Jugadores jug1 = new Jugadores("Maria","voleibol","Madrid",14,eq1);
        em.persist(jug1);
        
        Jugadores jug2 = new Jugadores("Miguel","tenis","Madrid",15,eq1);
        em.persist(jug2);
        
        Jugadores jug3 = new Jugadores("Mario","baloncesto","Guadalajara",15,eq1);
        em.persist(jug3);
        
        Jugadores jug4 = new Jugadores("Alicia","tenis","Madrid",14,eq1);
        em.persist(jug4);
        
        Jugadores jug5 = new Jugadores("Enzo","padel","Paris",14,eq2);
        em.persist(jug5);
        
        Jugadores jug6 = new Jugadores("Michel","padel","Rennes",16,eq2);
        em.persist(jug6);

        Jugadores jug7 = new Jugadores("Pietro","padel","Rennes",14,eq3);
        em.persist(jug7);
        
        Jugadores jug8 = new Jugadores("Sabatini","tenis","Roma",16,eq3);
        em.persist(jug8);
        
        Jugadores jug9 = new Jugadores("Peter","futbol","Dublin",14,eq4);
        em.persist(jug9);
        
        em.getTransaction().commit();
    
}
   

   public static void consultarjugadores14años() {
    TypedQuery<Jugadores> query = em.createQuery(
        "SELECT j FROM Jugadores j WHERE j.dorsal = 14 AND j.pais.nombre IN ('Irlanda', 'Francia', 'Italia')", 
        Jugadores.class);

    try {
        List<Jugadores> jugadores = query.getResultList();

        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores de 14 años en los países especificados.");
        } else {
            for (Jugadores jugador : jugadores) {
                System.out.println(jugador.getNombre() + ", País: " + jugador.getPais().getNombrepais());
            }
        }
    } catch (NoResultException e) {
        System.out.println("No hay datos");
    }
}
   
    
    private static void consultaJugadoresPorPaisYEdad(int edad, String... nombresPaises) {
    em.getTransaction().begin();

    String jpql = "SELECT j FROM Jugador j WHERE j.edad = :edad AND j.pais.nombre IN :nombresPaises";
    TypedQuery<Jugadores> query = em.createQuery(jpql, Jugadores.class);
    query.setParameter("edad", edad);
    query.setParameter("nombresPaises", Arrays.asList(nombresPaises));
    
    List<Jugadores> jugadores = query.getResultList();

    if (!jugadores.isEmpty()) {
        for (Jugadores jugador : jugadores) {
            System.out.println("JUGADOR: " + jugador.getNombre());
            System.out.println("PAIS: " + jugador.getPais().getNombrepais());
            System.out.println("EDAD: " + jugador.getEdad());
            // Aquí puedes agregar más detalles si lo deseas
        }
    } else {
        System.out.println("No se encontraron jugadores con los criterios especificados.");
    }

    em.getTransaction().commit();
}
  
  
    
    

    private static void insertarDatos(){
        em.getTransaction().begin();
        Usuarios usu1=new Usuarios(1,"ESPARTACO","ESPARTACO2014");
        em.persist(usu1);
        
        Usuarios usu2=new Usuarios(2,"GONZALO","GONZALO7");
        em.persist(usu2);
        
        Usuarios usu3=new Usuarios(3,"ALBERTO","ALBERTO10");
        em.persist(usu3);
        
        Usuarios usu4=new Usuarios(4,"MIGUEL","MIGUEL10");
        em.persist(usu4);
        
        
        Productos prod1=new Productos(1,"TABLET",150);
        em.persist(prod1);
        Productos prod2=new Productos(2,"RELOJ",60);
        em.persist(prod2);
        Productos prod3=new Productos(3,"GAMEPAD",40);
        em.persist(prod3);
        Productos prod4=new Productos(4,"CAJA CPU",80);
        em.persist(prod4);
        Productos prod5=new Productos(5,"PORTATIL",1500);
        em.persist(prod5);
        Productos prod6=new Productos(6,"RATON",25);
        em.persist(prod6);
        
        Pedidos ped1=new Pedidos(1,150,Metodos.convertirDate("01/01/24"),prod1,usu1);
        em.persist(ped1);
        
        Pedidos ped2=new Pedidos(2,60,Metodos.convertirDate("12/02/24"),prod2,usu1);
        em.persist(ped2);

        Pedidos ped3=new Pedidos(3,40,Metodos.convertirDate("01/01/24"),prod3,usu1);
        em.persist(ped3);

        Pedidos ped4=new Pedidos(4,80,Metodos.convertirDate("01/01/24"),prod4,usu1);
        em.persist(ped4);

        em.getTransaction().commit();
        
    }
    
    //Consultas sin JPQL
    private static void consultaDatosUsuario(int idUsuario){
        em.getTransaction().begin();
        
        Usuarios usuario=em.find(Usuarios.class, idUsuario,LockModeType.PESSIMISTIC_READ);
        
        if (usuario != null){
            System.out.print("USUARIO \t");
            System.out.print("CONTRASEÑA");
            System.out.println();
            
            System.out.print(usuario.getNombre()+"\t");
            System.out.print(usuario.getContra()+"\t");
        }
        else{
            System.out.println("No existe el usuario con ese ID");
        }
        em.getTransaction().commit();
    }
    
    
    
    private static void consultaDatosUsuarioConPedidos(int idUsuario){
        em.getTransaction().begin();
        
        Usuarios usuario=em.find(Usuarios.class, idUsuario,LockModeType.PESSIMISTIC_READ);
        
        if (usuario != null){
            System.out.print("USUARIO \t");
            System.out.print("CONTRASEÑA");
            System.out.println();
            
            System.out.print(usuario.getNombre()+"\t");
            System.out.print(usuario.getContra()+"\t");
            
            Pedidos p;
            Collection<Pedidos> coleccion=usuario.getPedidosCollection();
            //Para recorrer los pedidos utilizaremos un Iterator
            Iterator<Pedidos> it=coleccion.iterator();
            
            while (it.hasNext()){
                p=it.next();
                System.out.println("PEDIDO:");
                System.out.println(p.getIdpedido());
                System.out.println("FECHA DE ENTREGA:");
                System.out.println(p.getFechaEntrega());
                System.out.println("PRECIO TOTAL");
                System.out.println(p.getPrecioTotal());
            }
        }
        else{
            System.out.println("No existe el usuario con ese ID");
        }
        em.getTransaction().commit();
    }
    
     //Operaciones sin JPQL
    private static void borrarDatos(int idUsuario){
        em.getTransaction().begin();
        Usuarios usuario=em.find(Usuarios.class, idUsuario,LockModeType.PESSIMISTIC_READ);
        em.remove(usuario);
        em.getTransaction().commit();
    }
    
    private static void modificarDatos(int idUsuario,String nombre){
        consultaDatosUsuario(idUsuario);
        
        em.getTransaction().begin();
        Usuarios usuario=em.find(Usuarios.class, idUsuario,LockModeType.PESSIMISTIC_READ);
        
        usuario.setNombre(nombre);
        em.getTransaction().commit();
        
        consultaDatosUsuario(idUsuario);
    }
    
    //Named Queries
    private static void consultaDatosUsuariosCoNAMED(int idUsuario){
        Usuarios usuario=null;
        
        TypedQuery<Usuarios> query = em.createNamedQuery("USUARIOS.findById",Usuarios.class);
        
        query.setParameter("IDUSUARIOP", idUsuario);
        
        //Controlamos la excepcion por si no existe
        try{
        //Solo devuelve un valor
            usuario=query.getSingleResult();
            
            System.out.print("USUARIO \t");
            System.out.print("CONTRASEÑA");
            System.out.println();

            System.out.print(usuario.getNombre()+"\t");
            System.out.print(usuario.getContra()+"\t");
        }
        catch(NoResultException e){
            System.out.println("No existe el usuario con ese ID");
        }
    }
    
    
    private static void consultaDatosProductosCoNAMED(int idProducto){
        Productos producto=null;
        
        TypedQuery<Productos> query = em.createNamedQuery("PRODUCTOS.findById",Productos.class);
        
        query.setParameter("IDPRODUCTOP", idProducto);
        
        //Controlamos la excepcion por si no existe
        try{
        //Solo devuelve un valor
            producto=query.getSingleResult();
            
            System.out.print("NOMBRE \t");
            System.out.print("PRECIO");
            System.out.println();

            System.out.print(producto.getNombre()+"\t");
            System.out.print(producto.getPrecio()+"\t");
        }
        catch(NoResultException e){
            System.out.println("No existe el usuario con ese ID");
        }
    }
    
    private static void consultaDatosUsuariosConNamedMuchos(){
        Usuarios usuario;
        TypedQuery<Usuarios> query = em.createNamedQuery("USUARIOS.findAll",Usuarios.class);
        
        try{
            Collection<Usuarios> coleccion=query.getResultList();
            Iterator<Usuarios> it=coleccion.iterator();
            
            System.out.print("USUARIO \t");
            System.out.print("CONTRASEÑA");
            System.out.println();
                    
            while (it.hasNext()){
                usuario=it.next();
                System.out.print(usuario.getNombre()+"\t");
                System.out.println("\t"+usuario.getContra());
            }
        }
        catch(NoResultException e){
            System.out.println("No hay datos");
        } 
    }
    
    private static void consultaDatosProductosCoNAMEDMuchos(){
        Productos producto=null;
        
        TypedQuery<Productos> query = em.createNamedQuery("PRODUCTOS.findAll",Productos.class);
        
        
        //Controlamos la excepcion por si no existe
        try{
            Collection<Productos> coleccion = query.getResultList();
            Iterator<Productos> it = coleccion.iterator();
            
            System.out.print("NOMBRE \t");
            System.out.print("PRECIO");
            System.out.println();
            
            while(it.hasNext()){
                producto=it.next();
                System.out.println(producto.getNombre()+" "+producto.getPrecio());
            }
        }
        catch(NoResultException e){
            System.out.println("No existe el usuario con ese ID");
        }
    }
    
    //Consultas con CriteriaQuery
    private static void consultaUsuarioCriteriaQuery(){
        //Equivale a Select u from Usuarios u
        CriteriaBuilder cb=em.getCriteriaBuilder(); //Fabrica de criterios
        CriteriaQuery<Usuarios> query=cb.createQuery(Usuarios.class);
        
        Root<Usuarios> u=query.from(Usuarios.class);
        query.select(u);
        
        List<Usuarios> list= em.createQuery(query).getResultList();
        
        for (Usuarios e:list){
            System.out.println("Nombre usuario:"+e.getNombre());
        }
    }
    
    
    private static void consultaVariosCamposConCriteriaQuery(){
        //Select nombre, contra from Usuarios
        CriteriaBuilder cb=em.getCriteriaBuilder(); //Fabrica de criterios
        CriteriaQuery<Object[]> query=cb.createQuery(Object[].class);
        
        Root<Usuarios> u=query.from(Usuarios.class);
        query.select(cb.array(u.get("nombre"),u.get("contra")));
        
        List<Object[]> list=em.createQuery(query).getResultList();
        
        for (Object[] e:list){
            System.out.println("Nombre usuario: "+e[0]);
            System.out.println("Contraseña: "+e[1]);
        }
    }
    
    private static void consultaVariosCamposConCriteriaQuery(int idUsuario){
        //Select nombre, contra from Usuarios where usuarios.idUsuario=:idUsuario
        CriteriaBuilder cb=em.getCriteriaBuilder(); //Fabrica de criterios
        CriteriaQuery<Object[]> query=cb.createQuery(Object[].class);
        
        Root<Usuarios> u=query.from(Usuarios.class);
        query.select(cb.array(u.get("nombre"),u.get("contra")));
        query.where(cb.equal(u.get("idusuario"),idUsuario));
        List<Object[]> list=em.createQuery(query).getResultList();
        
        for (Object[] e:list){
            System.out.println("Nombre usuario: "+e[0]);
            System.out.println("Contraseña: "+e[1]);
        }
    }
    
    //Consultas con JPQL
    private static void consultaDatosUsuariosConJPQL(int idUsuario){
        Usuarios usuario=null;
        
        TypedQuery<Usuarios> query = em.createQuery("SELECT usu from Usuarios usu where usu.idusuario=:IDUSUARIOP",Usuarios.class);
        
        query.setParameter("IDUSUARIOP", idUsuario);
        
        //Controlamos la excepcion por si no existe
        try{
        //Solo devuelve un valor
            usuario=query.getSingleResult();
            
            System.out.print("USUARIO \t");
            System.out.print("CONTRASEÑA");
            System.out.println();

            System.out.print(usuario.getNombre()+"\t");
            System.out.print(usuario.getContra()+"\t");
        }
        catch(NoResultException e){
            System.out.println("No existe el usuario con ese ID");
        }
    }
    
    private static void consultaDatosUsuariosConJPQLMuchos(){
        Usuarios usuario;
        TypedQuery<Usuarios> query = em.createQuery("SELECT from Usuarios",Usuarios.class);
        
        try{
            Collection<Usuarios> coleccion=query.getResultList();
            Iterator<Usuarios> it=coleccion.iterator();
            
            System.out.print("USUARIO \t");
            System.out.print("CONTRASEÑA");
            System.out.println();
                    
            while (it.hasNext()){
                usuario=it.next();
                System.out.print(usuario.getNombre()+"\t");
                System.out.println("\t"+usuario.getContra());
            }
        }
        catch(NoResultException e){
            System.out.println("No hay datos");
        } 
    }
    
    private static void consultaVariosCamposConJPQL(){
        TypedQuery<Object[]> query=em.createQuery("Select idusuario,nombre from Usuarios",Object[].class);
        
        List<Object[]> list=query.getResultList();
        
        System.out.print("ID USUARIO \t");
        System.out.println("NOMBRE USUARIO");
        System.out.println();
        
        for (Object[] e:list){
            System.out.print(e[0]+"\t");
            System.out.println("\t"+e[1]);
        }
    }
    
    //Operaciones con JPQL
    private static void borrarDatosConJPQL(int idUsuario){
        Query query=em.createQuery("delete from Usuarios where idusuario=:idUsuarioV");
        query.setParameter("idUsuarioV", idUsuario);
        
        em.getTransaction().begin();
        //Numero de filas borradas
        int deleteCount = query.executeUpdate();
        em.getTransaction().commit();
        
        System.out.println("Se han borrado "+deleteCount+" usuarios");
    }
    
    private static void modificarDatosConJPQL(int idUsuario, String nuevonombre){
        Query query=em.createQuery("update from Usuarios set nombre=:nombreV where idusuario=:idUsuarioV");
        query.setParameter("idUsuarioV", idUsuario);
        query.setParameter("nombreV", nuevonombre);
        
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}
