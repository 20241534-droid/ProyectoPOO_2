/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

/**
 *
 * @author Jimena
 */
public class Registro_empleado {
    
    

    private static Empleado[] empleados = new Empleado[100];
    private static int contador = 0;

    public static boolean registrar(Empleado emp) {
        for (int i = 0; i < contador; i++) {
            if (empleados[i].getUsuario().equals(emp.getUsuario())) {
                return false;
            }
        }
        empleados[contador] = emp;
        contador++;
        return true;
    }

    public static Empleado login(String user, String pass) {
        for (int i = 0; i < contador; i++) {
            if (empleados[i].validar(user, pass)) {
                return empleados[i];
            }
        }
        return null;
    }
}
    

