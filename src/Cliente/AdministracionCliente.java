/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

/**
 *
 * @author Jimena
 */
public class AdministracionCliente {

    public static Cliente[] listaClientes = new Cliente[100];
    public static int contador = 0; 

    // -------------------------
    // AGREGAR CLIENTE
    // -------------------------
    public static Cliente agregarCliente(String DNI, String nombre, String apellido_paterno,
            String apellido_materno, String direccion, String telefono, String correo) {

        if (obtenerCliente(DNI) != null) {
            return null; 
        }

        if (contador >= listaClientes.length) {
            return null; 
        }

        Cliente cliente = new Cliente(DNI, nombre, apellido_paterno, apellido_materno,
                direccion, telefono, correo);

        listaClientes[contador] = cliente;
        contador++;

        return cliente;
    }

    // -------------------------
    // OBTENER CLIENTE POR DNI (String)
    // -------------------------
    public static Cliente obtenerCliente(String DNI) {
        for (int i = 0; i < contador; i++) {
            if (listaClientes[i].getDNI().equals(DNI)) {
                return listaClientes[i];
            }
        }
        return null;
    }

    // -------------------------
    // OBTENER CLIENTE POR NOMBRE
    // -------------------------
    public static Cliente obtenerClientePorNombre(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (listaClientes[i].getNombre().equals(nombre)) {
                return listaClientes[i];
            }
        }
        return null;
    }

    // -------------------------
    // ELIMINAR CLIENTE
    // -------------------------
    public static void eliminarCliente(String DNI) {
        for (int i = 0; i < contador; i++) {

            if (listaClientes[i].getDNI().equals(DNI)) {

                for (int j = i; j < contador - 1; j++) {
                    listaClientes[j] = listaClientes[j + 1];
                }

                listaClientes[contador - 1] = null;
                contador--;
                return;
            }
        }
    }

    // -------------------------
    // MODIFICAR CLIENTE
    // -------------------------
    public static Cliente modificarCliente(String DNI, String nombre, String apellido_pa,
            String apellido_ma, String direccion, String telefono, String correo) {

        Cliente cliente = obtenerCliente(DNI);
        if (cliente == null) return null;

        if (nombre != null && !nombre.isEmpty()) cliente.setNombre(nombre);
        if (apellido_pa != null && !apellido_pa.isEmpty()) cliente.setApellidoPaterno(apellido_pa);
        if (apellido_ma != null && !apellido_ma.isEmpty()) cliente.setApellidoMaterno(apellido_ma);
        if (direccion != null && !direccion.isEmpty()) cliente.setDireccion(direccion);
        if (telefono != null && !telefono.isEmpty()) cliente.setTelefono(telefono);
        if (correo != null && !correo.isEmpty()) cliente.setCorreo(correo);

        return cliente;
    }
}