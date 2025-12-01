/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Promocion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MONTSERRATH
 */
public class GestorPromociones {
    
    private static Promocion[] lista = new Promocion[10]; // máximo 10 promociones
    private static int contador = 0;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // AGREGAR
    public static Promocion agregarPromocion(String nombre, int montoPromocion, String tipoPromocion,
                                             Date inicioVigencia, Date finVigencia) {

        if (contador >= lista.length) return null; // lleno

        if (buscarPromocion(nombre) != -1) return null; // ya existe

        Promocion p = new Promocion(nombre, montoPromocion, tipoPromocion, inicioVigencia, finVigencia);

        lista[contador] = p;
        contador++;

        return p;
    }

    // BUSCAR (retorna posición)
    public static int buscarPromocion(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (lista[i].getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    // OBTENER por nombre
    public static Promocion obtenerPromocion(String nombre) {
        int pos = buscarPromocion(nombre);
        if (pos != -1) return lista[pos];
        return null;
    }

    // OBTENER por índice
    public static Promocion obtenerPromocionPorIndice(int i) {
        if (i >= 0 && i < contador) {
            return lista[i];
        }
        return null;
    }

    // ELIMINAR
    public static boolean eliminarPromocion(String nombre) {
        int pos = buscarPromocion(nombre);
        if (pos == -1) return false;

        // mover elementos
        for (int i = pos; i < contador - 1; i++) {
            lista[i] = lista[i + 1];
        }

        lista[contador - 1] = null;
        contador--;

        return true;
    }

    // MODIFICAR
    public static Promocion modificarPromocion(String nombre, String nuevoNombre, int nuevoMonto,
                                               String nuevoTipo, Date nuevaInicio, Date nuevaFin) {

        Promocion p = obtenerPromocion(nombre);
        if (p == null) return null;

        if (nuevoNombre != null && !nuevoNombre.isEmpty())
            p.setNombre(nuevoNombre);

        if (nuevoMonto > 0)
            p.setMontoPromocion(nuevoMonto);

        if (nuevoTipo != null && !nuevoTipo.isEmpty())
            p.setTipoPromocion(nuevoTipo);

        if (nuevaInicio != null)
            p.setInicioVigencia(nuevaInicio);

        if (nuevaFin != null)
            p.setFinVigencia(nuevaFin);

        return p;
    }

    // PASAR FECHA
    public static Date parseFecha(String texto) {
        try {
            return sdf.parse(texto);
        } catch (Exception e) {
            return null; // deja null si no es válido
        }
    }
}