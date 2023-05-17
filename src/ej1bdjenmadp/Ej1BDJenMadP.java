/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej1bdjenmadp;

/**
 *
 * @author Jennifer
 */
public class Ej1BDJenMadP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Alumno jennifer= new Alumno(1,"Jennifer",30,1000);
        Alumno nerea= new Alumno(2,"Nerea",25,2000);
        Alumno lucinio= new Alumno(3,"Lucinio",58,3000);
        Alumno jose= new Alumno(4,"Jose",30,4000);
        Alumno naima= new Alumno(5,"Naima",35,5000);
        
        
        //gesAlumnos.conexionBBDD();
        //gesAlumnos.crearTablas();
        
       
       
        gesAlumnos.grabarDatos(jennifer);
        gesAlumnos.grabarDatos(nerea);
        gesAlumnos.grabarDatos(lucinio);
        gesAlumnos.grabarDatos(jose);
        gesAlumnos.grabarDatos(naima);
        gesAlumnos.listaAlumnos();
        
        //2. Consulte: alumnos cuya edad sea menor que una dada. 
        
        gesAlumnos.consultaEdad(50);
        
        //3. Actualice: Incrementar un porcentaje introducido por teclado, la tasa matrícula de todos los alumnos cuya edad sea mayor de 31.
       
        gesAlumnos.aumPorcentajePorEdad(10);
        
        //4. Borre de la tabla a los mayores de una edad introducida por teclado.
        
        gesAlumnos.borrarPorEdad(50);
        
       //5.Consulte: Todos los alumnos
        
        gesAlumnos.listaAlumnos();
        
        //6. Borre los datos de un alumno dado el nombre
        
        gesAlumnos.borrarDatos("Jennifer");
        
        //7. Modifique la edad de un alumno dando el id y la nueva edad
        
        gesAlumnos.modificarEdad(4, 25);
        
        //8. Modifique la tasa de un alumno dado su nombre y la nueva tasa
        
        gesAlumnos.modificarTasa("Naima", 2000);
        
       
      
       
      //gesAlumnos.cerrarConexion();
         
    }
    
}
