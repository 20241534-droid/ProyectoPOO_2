/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cotizacion;

import Cliente.Cliente;
import Persona.Empleado;
import Promocion.Promocion;
import Vehiculo.Vehiculo;

/**
 *
 * @author MONTSERRATH
 */
public class GestorCotizacion {
    
    private Cotizacion cotizacion;

    // Crear/registrar una nueva cotización
    public Cotizacion agregarCotizacion(Cliente cliente, Empleado empleado, Promocion promocion, Vehiculo vehiculo, boolean aprobada) {

        cotizacion = new Cotizacion(cliente, empleado, promocion, vehiculo, aprobada);
        return cotizacion;
    }

    // Obtener la cotización registrada
    public Cotizacion obtenerCotizacion() {
        return cotizacion;
    }

    // Eliminar la cotización (dejarla en null)
    public boolean eliminarCotizacion() {
        if (cotizacion != null) {
            cotizacion = null;
            return true;
        }
        return false;
    }

    // Modificar una cotización ya creada
    public Cotizacion modificarCotizacion(Cliente cliente, Empleado empleado, Promocion promocion, Vehiculo vehiculo, Boolean aprobada) {

        if (cotizacion == null) {
            return null;
        }

        if (cliente != null) {
            cotizacion.setCliente(cliente);
        }

        if (empleado != null) {
            cotizacion.setEmpleado(empleado);
        }

        if (promocion != null) {
            cotizacion.setPromocion(promocion);
        }

        if (vehiculo != null) {
            cotizacion.setVehiculo(vehiculo);
        }

        if (aprobada != null) {
            cotizacion.setAprobada(aprobada);
        }

        return cotizacion;
    }
}
