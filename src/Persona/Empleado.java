/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;


public class Empleado extends Informacion {
    private String usuario;
    private String contrasenia;
    private String rol;

    public Empleado(String usuario, String contrasenia, String rol,
                    String DNI, String nombre,
                    String apellidoPaterno, String apellidoMaterno) {
        super(DNI, nombre, apellidoPaterno, apellidoMaterno);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }
    public String getDNI() { return DNI; }
    public String getNombre() { return nombre; }
    public String getApellidoPaterno() { return apellidoPaterno; }
    public String getApellidoMaterno() { return apellidoMaterno; }
    public String getRol() { return rol; }
    public String getUsuario() { return usuario; }
    public String getContrasenia() { return contrasenia; }
    

    public boolean validar(String user, String pass) {
        return this.usuario.equals(user) && this.contrasenia.equals(pass);
    }

    @Override
    public String toString() {
        return nombre + " " + apellidoPaterno + " (" + usuario + ")";
    }

    public void setRol(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
