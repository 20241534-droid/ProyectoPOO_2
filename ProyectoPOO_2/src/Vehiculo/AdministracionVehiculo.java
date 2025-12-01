/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculo;

/**
 *
 * @author Jimena
 */
public class AdministracionVehiculo extends Vehiculo{

    public AdministracionVehiculo(Integer codigo, String marca, String modelo, String color, Integer fechaFabricacion, String tipo, Integer precioBase, String disponibilidad) {
        super(codigo, marca, modelo, color, fechaFabricacion, tipo, precioBase, disponibilidad);
    }

    

    public static Vehiculo[] listaVehiculos = new Vehiculo[100];
    public static int contador = 0;

    // ---- MÉTODO PARA AGREGAR VEHÍCULO ----
    public static Vehiculo agregarVehiculo(Integer codigo, String marca, String modelo, String color,
                                           int anioFabricacion, String tipo,
                                           double precioBase, String disponibilidad) {

        if (obtenerVehiculo(codigo) != null) {
            return null; // ya existe
        }

        Vehiculo vehiculo = new Vehiculo(codigo, marca, modelo, color,
                                         anioFabricacion, tipo, precioBase, disponibilidad);

        listaVehiculos[contador] = vehiculo;
        contador++;

        return vehiculo;
    }

    // ---- MÉTODO PARA BUSCAR VEHÍCULO ----
    public static Vehiculo obtenerVehiculo(Integer codigo) {
        for (int i = 0; i < contador; i++) {
            if (listaVehiculos[i].getCodigo().equals(codigo)) {
                return listaVehiculos[i];
            }
        }
        return null;
    }

    // ---- MÉTODO PARA ELIMINAR VEHÍCULO ----
    public static void eliminarVehiculo(Integer codigo) {
        for (int i = 0; i < contador; i++) {
            if (listaVehiculos[i].getCodigo().equals(codigo)) {
                for (int j = i; j < contador - 1; j++) {
                    listaVehiculos[j] = listaVehiculos[j + 1];
                }
                listaVehiculos[contador - 1] = null;
                contador--;
                break;
            }
        }
    }

    // ---- MÉTODO PARA MODIFICAR VEHÍCULO ----
    public static Vehiculo modificarVehiculo(Integer codigo, String marca, String modelo, String color,
                                             int fechaFabricacion, String tipo,
                                             double precioBase, String disponibilidad) {

        Vehiculo vehiculo = obtenerVehiculo(codigo);
        if (vehiculo == null) return null;

        vehiculo.setMarca(marca);
        vehiculo.setModelo(modelo);
        vehiculo.setColor(color);
        vehiculo.setFechaFabricacion(fechaFabricacion);
        vehiculo.setTipo(tipo);
        vehiculo.setPrecioBase(precioBase);
        vehiculo.setDisponibilidad(disponibilidad);

        return vehiculo;
    }
    
}
