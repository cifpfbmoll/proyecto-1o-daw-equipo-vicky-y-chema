/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

/**
 * @author victoriapenas & josemariahernandez
 * @version 1.0
 * @since 2020-19-05
 */
public class Usuario {

    // Atributos
    private String clienteNIF;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String email;
    private int rol;
    private String password;
    private String codUsuario;

    // Contructor vacío
    public Usuario() {
    }

    /**
     * Constructor con parámetros
     */ 
    public Usuario(String clienteNIF, String nombre, String apellido1,
            String apellido2, String telefono, String email, int rol,
            String password, String codUsuario) {
        this.setClienteNIF(clienteNIF);
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setTelefono(telefono);
        this.setEmail(email);
        this.setRol(rol);
        this.setPassword(password);
        this.setCodUsuario(codUsuario);
    }

    /** Contructor copia. El NIF y el codUsuario no puede estar duplicado.
     * Por lo tanto, no se copia.
     */
    public Usuario(Usuario user, String NIF, String codUser) {
        this.setClienteNIF(NIF);
        this.setNombre(user.getNombre());
        this.setApellido1(user.getApellido1());
        this.setApellido2(user.getApellido2());
        this.setTelefono(user.getTelefono());
        this.setEmail(user.getEmail());
        this.setRol(user.getRol());
        this.setPassword(user.getPassword());
        this.setCodUsuario(codUser);
    }

    // Getters Y setters
    public String getClienteNIF() {
        return clienteNIF;
    }

    public void setClienteNIF(String clienteNIF) {
        this.clienteNIF = clienteNIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public static int obtenerRolId(String rol) {
        int rolId = 0;
        if (rol.equals("Cliente")) {
            rolId = 1;
        }
        return rolId;
    }
}
