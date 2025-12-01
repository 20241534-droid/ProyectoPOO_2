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
public class Cotizacion {
    
    private Cliente cliente;
    private Empleado empleado;
    private Promocion promocion;
    private Vehiculo vehiculo;
    private boolean aprobada;
    

    public Cotizacion(Cliente cliente, Empleado empleado, Promocion promocion, Vehiculo vehiculo, boolean aprobada) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.promocion = promocion;
        this.vehiculo = vehiculo;
        this.aprobada = aprobada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public boolean isAprobada() {
        return aprobada;
    }

    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }
    
}
    


    
