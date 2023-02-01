package EjemploHQL;

import Conexion.Conexion;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Principal {
    private static Conexion conexion;
    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        LogManager.getLogManager().reset();
        Logger globalLogger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
        globalLogger.setLevel(java.util.logging.Level.OFF);
        String respuesta = "";
        conexion = new Conexion();
        conexion.IniciarConexión();

        do {
            System.out.println("Escoja la opcion");
            System.out.println("1. Insertar Profesores");
            System.out.println("2. Listar profesores");
            System.out.println("3. Insertar Asignaturas");
            System.out.println("4. Insertar Dptos");
            int opcion = s.nextInt();

            switch (opcion){
                case 1:
                    insertarObjeto(new tProfesores("Javier", "Sequera", "Benitez"));
                    break;
                case 2:
                    listarProfesorado();
                    break;
                case 3:
                    tProfesores profesor = new tProfesores("Manolo", "Pérez", "Rodríguez");
                    tAsignatura asignatura = new tAsignatura(2023, 300, "Lengua", profesor);
                    insertarObjeto(asignatura);
                    break;
                case 4:
                    asociarProfesorDpto();
                    break;
                default:
                    break;
            }
            System.out.println("Desea elegir otra opción s/n");
            respuesta = s.next();
        }while (respuesta.equals("s"));

        conexion.CerrarConexión();
    }

    private static void insertarObjeto(Object objeto){
        Session session = conexion.ObtenerSesion();
        Transaction transaction = session.beginTransaction();
        session.save(objeto);
        transaction.commit();
        session.close();
    }

    private static void listarProfesorado(){
        Session session = conexion.ObtenerSesion();
        try{
            List lista = session.getNamedQuery("listaProfesores").getResultList();
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        session.close();
    }

    private static void asociarProfesorDpto(){
        int id = 1;
        Session session = conexion.ObtenerSesion();
        Transaction transaction = session.beginTransaction();
        tDpto dpto = session.load(tDpto.class, id);
        tProfesores profesor2 = new tProfesores("Carmen", "Martin", "Gaite");
        profesor2.setDpto(dpto);
        transaction.commit();
        session.close();
        insertarObjeto(profesor2);
    }

}
