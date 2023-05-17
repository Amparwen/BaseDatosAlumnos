/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1bdjenmadp;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jennifer Madrigal
 */
public class gesAlumnos {
    private static final String BBDD="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USUARIO="JENN";
    private static final String PASSWORD="1234";
    public static Connection conn;
    
    /**
     * 
     * @return 
     */
    public static Connection conexionBBDD(){
        
        try {
            DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver());
            
            conn=DriverManager.getConnection(BBDD, USUARIO, PASSWORD);
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion");
        }
        return conn;
    }
    
    public static void cerrarConexion(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión");
        }
       
    }
   
    
    
    /**
     * Este método se encargará de crear la tabla datos, con 
     *   los campos: id, nombre, edad y tasa matrícula
     */
    public static void crearTablas(){ 
        try {
            Statement stm= conn.createStatement();
           if(stm.execute("CREATE TABLE DATOS_ALUMNOS (ID NUMBER(4) PRIMARY KEY, NOMBRE VARCHAR2(40), EDAD NUMBER (2), TASA_MATRICULA NUMBER (4))")){
               System.out.println("La tabla se ha creado correctamente");
           }
        } catch (SQLException ex) {
            System.out.println("Se ha producido un error al crear la tabla");
        }
    }
    
    
    /**
     * Esté método se encargará de añadir 
     *  información de un alumno de la BBDD. Alumnos será una clase con 4 atributos 
     *  que corresponden a los 4 campos definidos anteriormente (id, nombre, edad, 
     *   tasaMat)
     * @param alum 
     */
    public static void grabarDatos (Alumno alum){
        
        if (alum!=null){
            
            String sql="INSERT INTO DATOS_ALUMNOS VALUES(?,?,?,?)";
       
            try {
                PreparedStatement pstm=conn.prepareStatement(sql);
                pstm.setInt(1,alum.getId());
                pstm.setString(2, alum.getNombre());
                pstm.setInt(3, alum.getEdad());
                pstm.setInt(4, alum.getTasaMat());
                if(pstm.executeUpdate()==1)
                    System.out.println("Alumno insertado");

            } catch (SQLException ex) {
                System.out.println("Error al insertar");
            }
        } 
    }
    
   
    /**
     * Esté método se encargará de eliminar una alumno por el nombre
     * @param nombre 
     */
    public static void borrarDatos (String nombre){
      String sql=("DELETE FROM DATOS_ALUMNOS WHERE NOMBRE='"+nombre+"'");
      try {
           
            Statement stm= conn.createStatement();
            if(stm.executeUpdate(sql)==1){
                System.out.println("Alumno eliminado");
            }
                
        } catch (SQLException ex) {
            System.out.println("Error al eliminar");
        }
    }
    
   
    /**
     * Esté método se encargará de modificar la edad de un alumno
     * @param id
     * @param edad 
     */
    public static void modificarEdad(int id, int edad){
        String sql=("UPDATE DATOS_ALUMNOS SET EDAD=? WHERE ID=?");
      try {
         
            PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setInt(1, edad);
            pstm.setInt(2, id);
                
            if(pstm.executeUpdate()==1)
               System.out.println("Edad modificada");
                
        } catch (SQLException ex) {
            System.out.println("Error al modificar la edad");
        }
    }
    
    
   
    /**
     * Esté método se encargará de 
    modificar la tasa de un alumno por el nombre
     * @param nombre
     * @param tasa 
     */
    public static void modificarTasa(String nombre, int tasa){
         String sql=("UPDATE DATOS_ALUMNOS SET TASA_MATRICULA=? WHERE NOMBRE=?");
      try {
           
            PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setInt(1, tasa);
            pstm.setString(2, nombre);
                
            if(pstm.executeUpdate()==1)
               System.out.println("Tasa matricula modificada");
                
        } catch (SQLException ex) {
            System.out.println("Error al modificar la tasa de la matricula");
        }
    }
    

    /**
     * Este método se encargará de listar la tabla datos, con los campos: id, nombre, edad y 
     * tasa de matricula
     */
  
    public static void listaAlumnos(){
        String sql=("SELECT * FROM DATOS_ALUMNOS");
      try {
            
            Statement stm= conn.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while(rs.next()){
                System.out.println("Alumno: id "+rs.getInt(1)+" nombre "+rs.getString(2)+" edad "+rs.getInt(3)+" tasa matricula "+rs.getInt(4));
            }  
                
        } catch (SQLException ex) {
            System.out.println("Error al mostrar");
        }
    }
    
  
    /**
     * Este método se encargará de mostrar los 
    datos de los alumnos que tengan menor edad que la indicada en el parámetro
     * @param edad 
     */
    public static void consultaEdad(int edad){
        String sql=("SELECT * FROM DATOS_ALUMNOS WHERE EDAD <"+edad);
      try {
            
            Statement stm= conn.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while(rs.next()){
                System.out.println("Alumno: id "+rs.getInt(1)+" nombre "+rs.getString(2)+" edad "+rs.getInt(3)+" tasa matricula "+rs.getInt(4));
            }  
                
        } catch (SQLException ex) {
            System.out.println("Error al mostrar");
        }
    }
    
    /**
     * Actualice: Incrementar un porcentaje introducido por teclado, la 
       tasa matrícula de todos los alumnos cuya edad sea mayor de 31.
     * @param porcentaje 
     */
    public static void aumPorcentajePorEdad (double porcentaje){
        double por=(porcentaje/100)+1;
     
        String sql="UPDATE DATOS_ALUMNOS SET TASA_MATRICULA=(TASA_MATRICULA*"+por+") WHERE EDAD > 31";
         try {
            Statement stm = conn.createStatement();
            int filas=stm.executeUpdate(sql);
            if (filas>0){
                System.out.println(filas+" filas modificadas");
            }
        } catch (SQLException ex) {
             System.out.println("Error al hacer el aumento del porcentaje");
        } 
    }
    
    /**
     * Borre de la tabla a los mayores de una edad introducida por teclado.
     * @param edad 
     */
       public static void borrarPorEdad (int edad){
      String sql=("DELETE FROM DATOS_ALUMNOS WHERE EDAD >"+edad);
      try {
           
            Statement stm= conn.createStatement();
            if(stm.executeUpdate(sql)==1){
                System.out.println("Alumno eliminado");
            }
                
        } catch (SQLException ex) {
            System.out.println("Error al eliminar");
        }
    }
    
}
