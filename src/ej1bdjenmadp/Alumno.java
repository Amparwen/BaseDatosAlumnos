/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1bdjenmadp;

/**
 *
 * @author Jennifer
 */
public class Alumno {
    private int id;
    private String nombre;
    private int edad;
    private int tasaMat;

    
    public Alumno(int id, String nombre, int edad, int tasaMat) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.tasaMat = tasaMat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTasaMat() {
        return tasaMat;
    }

    public void setTasaMat(int tasaMat) {
        this.tasaMat = tasaMat;
    }

    @Override
    public String toString() {
        return "Alumnos{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", Tasa Matricula=" + tasaMat + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        return this.id == other.id;
    }
    
    
    
}