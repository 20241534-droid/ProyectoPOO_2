/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

/**
 *
 * @author Jimena
 */


public class ClienteArray {

    // Arreglo para almacenar los clientes
    public static Cliente[] clientes = new Cliente[100];

    // Cantidad actual de clientes almacenados
    public static int contador = 0;

    // ===============================
    // MÉTODO PARA AGREGAR CLIENTES
    // ===============================
    public static void agregarCliente(Cliente cli) {
        if (contador < clientes.length) {
            clientes[contador] = cli;
            contador++;
        } else {
            System.out.println("ERROR: Límite de clientes alcanzado.");
        }
    }

    // ===============================
    // OBTENER CLIENTE POR ÍNDICE
    // ===============================
    public static Cliente obtenerCliente(int index) {
        if (index >= 0 && index < contador) {
            return clientes[index];
        }
        return null;
    }

    // ===============================
    // ELIMINAR CLIENTE POR ÍNDICE
    // ===============================
    public static void eliminarCliente(int index) {
        if (index >= 0 && index < contador) {
            for (int i = index; i < contador - 1; i++) {
                clientes[i] = clientes[i + 1];
            }
            clientes[contador - 1] = null;
            contador--;
        }
    }
}
