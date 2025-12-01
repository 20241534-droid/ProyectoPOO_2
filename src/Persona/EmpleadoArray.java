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
    public static Empleado[] vendedores = new Empleado[100];
    public static int contador = 0;
    public static int contadorVendedores = 0;

    // ================= AGREGAR =================
    public static boolean agregar(Empleado emp) {

        if (contador >= empleados.length) return false;

        empleados[contador] = emp;
        contador++;

        // ➜ Si es vendedor, lo guardamos también en el arreglo de vendedores
        if (emp.getRol().equalsIgnoreCase("Vendedor")) {
            vendedores[contadorVendedores] = emp;
            contadorVendedores++;
        }

        return true;
    }

    // ================= MODIFICAR =================
    public static void modificar(int index, Empleado nuevo) {
        if (index < 0 || index >= contador) return;

        empleados[index] = nuevo;

        // ➜ Actualizar lista de vendedores
        recargarVendedores();
    }

    // ================= ELIMINAR =================
    public static void eliminar(int index) {
        if (index < 0 || index >= contador) return;

        for (int i = index; i < contador - 1; i++) {
            empleados[i] = empleados[i + 1];
        }

        contador--;
        empleados[contador] = null;

        // ➜ Actualizar vendedores
        recargarVendedores();
    }

    // ================= RECARGAR VENDEDORES =================
    private static void recargarVendedores() {
        contadorVendedores = 0;

        for (int i = 0; i < contador; i++) {
            if (empleados[i].getRol().equalsIgnoreCase("Vendedor")) {
                vendedores[contadorVendedores] = empleados[i];
                contadorVendedores++;
            }
        }
    }
}