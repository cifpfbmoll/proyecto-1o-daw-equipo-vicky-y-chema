/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JLabel;
import static rentacar.RentaCar.obtenerConexion;

/**
 * La clase Usuario se utiliza para crear usuarios en
 * la aplicación.
 * @author victoriapenas
 * @version 1.0
 */
public class Usuario {
    
    //atributos
    private String clienteNIF;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String email;
    private int rol;
    private String password;
    private String codUsuario;
    
    //contructor vacío
    public Usuario() {
    }
    
    //constructor con parámetros
    public Usuario(String clienteNIF, String nombre, String apellido1, String apellido2, String telefono, String email, int rol, String password, String codUsuario) {
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
    
    // contructor copia. El NIF y el codUsuario no puede estar duplicado. Por lo tanto, no se copia.
    public Usuario(Usuario user, String NIF, String codUser){
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
    
    //getters i setters
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
    
    public static int obtenerRolId(String rol){
        int rolId = 0;
        if (rol.equals("Cliente")){
            rolId = 1;
        }
        return rolId;
    }
    
    public static void insertRegistro(String nif,String nombre,String apellido1,
        String apellido2,String telefono,String email, String rol, String user, String pw, JLabel resultado){
            int rolId = obtenerRolId(rol);
            PreparedStatement pst = null;
            Connection con = null;
            try {
                con = obtenerConexion();
                System.out.println("Conectado correctamente a la BBDD");//TODO eliminar
                if (nif.isEmpty() || nombre.isEmpty() || apellido1.isEmpty() || apellido2.isEmpty()
                    || telefono.isEmpty() || email.isEmpty() || rol.isEmpty() || user.isEmpty() || pw.isEmpty()){
                    resultado.setForeground(Color.RED);
                    resultado.setText("Faltan datos por cumplimentar.");
                    
                }else{                
                    con.setAutoCommit(false);
                    //sql insert statement para tabla clientes
                    String queryClientes = " insert into clientes (nif,nombre,apellido1,apellido2,telefono,email)"
                      + " values (?, ?, ?, ?, ?, ?)";
                    pst = con.prepareStatement(queryClientes);
                    pst.setString(1, nif);
                    pst.setString(2, nombre);
                    pst.setString(3, apellido1);
                    pst.setString(4, apellido2);
                    pst.setInt(5, Integer.parseInt(telefono));
                    pst.setString(6,email);
                    pst.executeUpdate();
                    
                    //sql insert statement para tabla usuarios
                    String queryUsuarios = " insert into usuarios (usuario,password,clientenif,rolid)"
                      + " values (?, crypt(?, gen_salt('bf')), ?, ?)";
                    pst = con.prepareStatement(queryUsuarios);
                    pst.setString(1, user);
                    pst.setString(2, pw);
                    pst.setString(3, nif);
                    pst.setInt(4, rolId);
                    pst.executeUpdate();
                    resultado.setForeground(Color.GREEN);
                    resultado.setText("Usuario creado correctamente"); //añado a la label el valor
                    
                    con.commit();
                }
            } catch (SQLException ex) {
                try {
                    con.rollback();
                    resultado.setForeground(Color.RED);
                    if (ex.getSQLState().equals("23505")){
                        resultado.setText("Ya existe un usuario con estos datos.");
                    }else{
                        System.out.println(ex.getSQLState());
                        System.out.println(ex.getMessage());
                        resultado.setText("No se ha podido conectar a la base de datos");
                    }
                } catch (SQLException ex1) {
                    System.out.println("Se ha producido en un error inesperado.");
                }
                
            } finally{
                if (con != null) try{
                    con.close();
                    con.setAutoCommit(true);
                }catch (SQLException ex) {
                    System.out.println(ex.getSQLState());
                    System.out.println(ex.getMessage());
                }
                if (pst != null) try {
                    pst.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getSQLState());
                    System.out.println(ex.getMessage());
                }
            }
        } 
}
