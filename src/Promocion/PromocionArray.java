/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Promocion;

/**
 *
 * @author MONTSERRATH
 */
public class PromocionArray {

    // arreglo estático público (igual que usaste en ClienteArray)
    public static Promocion[] listaPromociones = new Promocion[100];
    public static int contador = 0;

    // método auxiliar opcional para agregar promociones (no obligatorio)
    public static Promocion agregarPromocion(Promocion p) {
        if (contador >= listaPromociones.length) return null;
        listaPromociones[contador++] = p;
        return p;
    }
}

    

