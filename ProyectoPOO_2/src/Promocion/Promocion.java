/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Promocion;

import java.util.Date;



/**
 *
 * @author MONTSERRATH
 */
public class Promocion {
    
    String nombre;
    int montoPromocion;       
    String tipoPromocion;      // "porcentaje" o "monto"
    Date inicioVigencia;
    Date finVigencia;

    public Promocion(String nombre, int montoPromocion, String tipoPromocion, Date inicioVigencia, Date finVigencia) {
        this.nombre = nombre;
        this.montoPromocion = montoPromocion;
        this.tipoPromocion = tipoPromocion;
        this.inicioVigencia = inicioVigencia;
        this.finVigencia = finVigencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMontoPromocion() {
        return montoPromocion;
    }

    public void setMontoPromocion(int montoPromocion) {
        this.montoPromocion = montoPromocion;
    }

    public String getTipoPromocion() {
        return tipoPromocion;
    }

    public void setTipoPromocion(String tipoPromocion) {
        this.tipoPromocion = tipoPromocion;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFinVigencia() {
        return finVigencia;
    }

    public void setFinVigencia(Date finVigencia) {
        this.finVigencia = finVigencia;
    }
    
    //Aplicar Descuento
    
    public int aplicarDescuento(int precioBase) {

        if (tipoPromocion.equalsIgnoreCase("porcentaje")) {
            int descuento = (precioBase * montoPromocion) / 100;
            return precioBase - descuento;
        }

        if (tipoPromocion.equalsIgnoreCase("monto")) {
            return precioBase - montoPromocion;
        }

        return precioBase;
    }

    
}
