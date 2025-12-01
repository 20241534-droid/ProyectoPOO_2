/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;
import Persona.Informacion;

/**
 *
 * @author Jimena
 */
public class Cliente extends Informacion {

    private String direccion;
    private String telefono;
    private String correo;

    // Constructor vacío (necesario para instancias rápidas)
    public Cliente() {
        super("", "", "", "");
        this.direccion = "";
        this.telefono = "";
        this.correo = "";
    }

    // Constructor completo
    public Cliente(String direccion, String telefono, String correo,
                   String DNI, String nombre, String apellidoPaterno, String apellidoMaterno) {
        super(DNI, nombre, apellidoPaterno, apellidoMaterno);
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Actualizar datos desde el formulario
    public void actualizar(String dni, String nombre, String apellidoPaterno, String apellidoMaterno,
                           String direccion, String telefono, String correo) {

        setDNI(dni);
        setNombre(nombre);
        setApellidoPaterno(apellidoPaterno);
        setApellidoMaterno(apellidoMaterno);
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }
    
    
    // Getters y setters
    public String getDireccion() { 
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() { 
        return telefono; 
    }
    public void setTelefono(String telefono) { 
        this.telefono = telefono; 
    }

    public String getCorreo() { 
        return correo; 
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Devuelve los datos en arreglos para mostrarlos en JTable
    public Object[] toArray() {
        return new Object[]{
                getDNI(),
                getNombre(),
                getApellidoPaterno(),
                getApellidoMaterno(),
                direccion,
                telefono,
                correo,
        };
    }
    

    
}
