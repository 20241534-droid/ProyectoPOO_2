package Persona;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jimena
 */


public class EmpleadoArray {

    public static Empleado[] empleados = new Empleado[100];
    public static int contador = 0;

    // Agregar empleado
    public static boolean agregar(Empleado emp) {
        if (contador >= empleados.length)
            return false;

        empleados[contador] = emp;
        contador++;
        return true;
    }

    // Buscar por DNI
    public static int buscar(String dni) {
        for (int i = 0; i < contador; i++) {
            if (empleados[i].getDNI().equals(dni)) {
                return i;
            }
        }
        return -1;
    }

    // Modificar empleado
    public static void modificar(int index, Empleado empModificado) {
        empleados[index] = empModificado;
    }

    // Eliminar empleado
    public static void eliminar(int index) {
        for (int i = index; i < contador - 1; i++) {
            empleados[i] = empleados[i + 1];
        }
        contador--;
    }
}