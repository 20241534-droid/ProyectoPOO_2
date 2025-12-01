/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculo;

/**
 *
 * @author Jimena
 */
public class Vehiculo {
    
    public static class TipoVehiculo {
        public static final String SEDAN = "Sedan";
        public static final String SUV = "SUV";
        public static final String PICK_UP = "Pick Up";
    }
    
    public static class Disponibilidad {
        public static final String DISPONIBLE = "Disponible";
        public static final String VENDIDO = "Vendido";
        public static final String RESERVADO = "Reservado";
    }
    
    private Integer codigo;
    private String marca;
    private String modelo;
    private String color;
    private int fechaFabricacion;
    private TipoVehiculo tipo;
    private Integer precioBase;
    private Disponibilidad disponibilidad;

    public Vehiculo(Integer codigo, String marca, String modelo, String color, int fechaFabricacion, TipoVehiculo tipo, Integer precioBase, Disponibilidad disponibilidad) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.fechaFabricacion = fechaFabricacion;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.disponibilidad = disponibilidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(int fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    public Integer getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Integer precioBase) {
        this.precioBase = precioBase;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
    
}
