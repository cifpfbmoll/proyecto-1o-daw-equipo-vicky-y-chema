/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.Consultas_BBDD.*;
import static RentaCar.General.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

/**
 * @author victoriapenas & josemariahernandez
 * @version 2.0
 * @since 2020-05-25
 */
public class Usuario implements Consultas_BBDD {

    private String clienteNIF;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String email;
    private int rol;
    private String password;
    private String codUsuario;

    /**
     * Contructor vacío
     */
    public Usuario() {
    }

    /**
     * Constructor con parámetros
     */
    public Usuario(String clienteNIF, String nombre, String apellido1,
            String apellido2, String telefono, String email, int rol,
            String password, String codUsuario) throws RCException {
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

    /**
     * Contructor copia. El NIF y el codUsuario no puede estar duplicado. Por lo
     * tanto, no se copia.
     */
    public Usuario(Usuario user, String NIF, String codUser) throws RCException {
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

    public String getClienteNIF() {
        return clienteNIF;
    }

    public void setClienteNIF(String clienteNIF) {
        this.clienteNIF = clienteNIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws RCException {
        boolean valido = isStringOnlyAlphabet(nombre);
        if (valido){
            this.nombre = nombre;
        } else{
            throw new RCException("Por favor, indica un nombre válido.");
        }
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) throws RCException {
        boolean valido = isStringOnlyAlphabet(apellido1);
        if (valido){
            this.apellido1 = apellido1;
        } else{
            throw new RCException("El primer apellido es incorrecto.");
        }
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) throws RCException {
        boolean valido = isStringOnlyAlphabet(apellido2);
        if (valido){
            this.apellido2 = apellido2;
        } else{
            throw new RCException("El segundo apellido es incorrecto.");
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws RCException {
        boolean valido = isNumeric(telefono);
        if(telefono.length() < 9 || !valido){
            throw new RCException("Por favor, indica un número de teléfono válido.");
        }else{
            this.telefono = telefono;
        }
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

    public void setPassword(String password) throws RCException {
        if(password.length() < 6 ){
            throw new RCException("La contraseña debe contener al menos 6 caracteres.");
        }else{
            this.password = password;
        }
        
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    /**
     * Método para recuperar el id del rol en función de su nombre
     *
     * @param rol recibe el nombre del rol
     * @return devuelve el codigo del rol
     */
    public static int obtenerRolId(String rol) {
        int rolId = 0;
        if (rol.equals("Cliente")) {
            rolId = 1;
        }
        return rolId;
    }
    
    /**
     * Método para obtener el rol de un usuario
     * @param user recibe el codigo de usuario
     * @return devuelve el codigo del rol
     * @throws SQLException 
     */
    public static int comprobarRol(String user) throws SQLException{
        int rol = 1;
        try (Connection con = obtenerConexion();PreparedStatement ps = con.prepareStatement(recuperarUsuario(user));
                ResultSet rs = ps.executeQuery()){
            while (rs.next ()) {
                rol = rs.getInt(1);
            }
        }
        return rol;
    }

    /**
     * Método para crear nuevos usuarios.
     *
     * @param nif del cliente
     * @param nombre del cliente
     * @param apellido1 del cliente
     * @param apellido2 del cliente
     * @param telefono del cliente
     * @param email correo electronico del cliente
     * @param rol tipo de perfil en la aplicación del cliente
     * @param user usuario de login del cliente
     * @param pw contraseña del cliente
     * @param resultado etiqueta para informar si se ha realizado con éxito la
     * creación del usuario
     * @throws SQLException TODO ELEVAR EXCEPTION!!-------------------------VICKY
     */
    public void insertRegistro(JLabel resultado) {
        PreparedStatement pst = null;
        Connection con = null;
        try {
            con = obtenerConexion();
            if(!revisarCampos()){
                throw new RCException("Faltan datos por cumplimentar.");
            }
            if (!comprobarEmail()){
                throw new RCException("El email indicado no es válido.");
            }else {
                con.setAutoCommit(false);
                //sql insert statement para tabla clientes
                String queryClientes = insertClientes();
                pst = con.prepareStatement(queryClientes);
                pst.setString(1, this.getClienteNIF());
                pst.setString(2, this.getNombre());
                pst.setString(3, this.getApellido1());
                pst.setString(4, this.getApellido2());
                pst.setString(5, this.getTelefono());
                pst.setString(6, this.getEmail());
                pst.executeUpdate();

                //sql insert statement para tabla usuarios
                String queryUsuarios = insertUsuarios();
                pst = con.prepareStatement(queryUsuarios);
                pst.setString(1, this.getCodUsuario());
                pst.setString(2, this.getPassword());
                pst.setString(3, this.getClienteNIF());
                pst.setInt(4, this.getRol());
                pst.executeUpdate();
                resultado.setForeground(Color.GREEN);
                resultado.setText("Usuario creado correctamente");

                con.commit();
            }
        } catch (SQLException ex) {
            try {
                con.rollback();
                resultado.setForeground(Color.RED);
                if (ex.getSQLState().equals("23505")) {
                    resultado.setText("Ya existe un usuario con estos datos.");
                } else {
                    resultado.setText(ex.getSQLState() + ex.getMessage());
                }
            } catch (SQLException ex1) {
                resultado.setForeground(Color.RED);
                resultado.setText("Se ha producido en un error inesperado.");
            }
        } catch (Exception ex){
            try {
                con.rollback();
            } catch (SQLException ex1) {
                resultado.setForeground(Color.RED);
                resultado.setText(ex.getMessage());
            }
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                    con.close();
                } catch (SQLException ex) {
                    resultado.setForeground(Color.RED);
                    resultado.setText(ex.getSQLState() + ex.getMessage());
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    resultado.setForeground(Color.RED);
                    resultado.setText(ex.getSQLState() + ex.getMessage());
                }
            }
        }
    }

    /**
     * Método para comprobar si todos los campos de alta de un usuario están
     * completados
     *
     * @return devuelve un booleano con el resultado
     */
    public boolean revisarCampos() {
        boolean camposCompletos = true;
        if (this.getClienteNIF().isEmpty() || this.getClienteNIF() == null
                || this.getNombre().isEmpty() || this.getNombre() == null || this.getApellido1().isEmpty()
                || this.getApellido1() == null || this.getApellido2().isEmpty() || this.getApellido2() == null
                || this.getTelefono().isEmpty() || this.getTelefono() == null || this.getEmail().isEmpty()
                || this.getEmail() == null || this.getRol() == 0 || this.getCodUsuario().isEmpty()
                || this.getCodUsuario() == null || this.getPassword().isEmpty() || this.getPassword() == null) {

            camposCompletos = false;
        }
        return camposCompletos;
    }
    
    /**
     * Método para validar el acceso de un usuario
     * @param user codigo de usuario que se ha introducido
     * @param pw contraseña que se ha introducido
     * @return devuelve true si el usuario existe en ls BBDD
     * @throws SQLException 
     */
    public static boolean comprobarUsuario(String user, String pw) throws SQLException{
        boolean encontrado = false;
        Connection con = obtenerConexion();   
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(comprobarPw());
            ps.setString(1, pw);
            ps.setString(2, user);
            rs = ps.executeQuery();
            while (rs.next ()) {
                if (rs.getBoolean(1)){
                    encontrado = true;
                }
            }       
        }finally{
            con.close();
            ps.close();
            rs.close();
        }
        return encontrado;
    }
    
    /**
     * Método para comprobar que el email especificado es válido
     * @param email recibe el email
     * @return devuelve true si es correcto
     */
    public boolean comprobarEmail(){
        if (this.getEmail().contains("@")){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Este metodo se encarga de listar los clientes registrados en una JTable
     * 
     * @see javax.swing.JTable
     * @see javax.swing.table.AbstractTableModel
     */    
    public static void listarClientesTabla(){
        String query = buscarCliente();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ModeloTabla modelo = null;
        JTable tabla = null; 
        JFrame ventana = crearVentana(false);
        JPanel buscar = new JPanel();
        JButton buscarCliente = new JButton("BUSCAR CLIENTE");
        ventana.setTitle("LISTADO DE CLIENTES");
        try (Connection con = obtenerConexion()){
            pst = con.prepareStatement(listarClientes(),ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        modelo = new ModeloTabla(rs);
        tabla = new JTable(modelo);
        ventana.add(new JScrollPane(tabla),BorderLayout.CENTER);
        ventana.validate();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        buscarCliente.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String nif = JOptionPane.showInputDialog(null, "Introduce el NIF del cliente", "BUSCAR CLIENTE", JOptionPane.QUESTION_MESSAGE);
            try {
                if ((nif != null) && (nif.trim().length() > 0)){
                    if (General.comprobarObj(nif,query)){
                        General.mostrarObj(nif,query,"CLIENTE");
                    }else if (!General.comprobarObj(nif,query)){
                        throw new RCException("El NIF indicado no existe.");
                    }
                }else{
                    throw new RCException("No has indicado ningun NIF.");
                }
                ventana.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        });
        buscar.add(buscarCliente);
        ventana.add(buscar,BorderLayout.SOUTH);
    }
    
    /**
     * Método para recuperar el nif de un cliente a partir de su usuario de login
     * @param usuario usuario es el usuario de login
     * @return devuelve el nif asociado al usuario
     * @throws SQLException 
     */
    public static String recuperarNIF(String usuario) throws SQLException{
        String nif = "";
        ResultSet rs = null;
        try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(listarClienteNIF())){
            pst.setString(1, usuario);
            rs = pst.executeQuery();
            if (rs.next()){
                nif = rs.getString(1);
            }
        } finally {
            rs.close();
        }
        return nif;
    }
    
    /**
     * @deprecated sustituido por comprobarObj(String info, String query)
     * @param nif
     * @return
     * @throws SQLException 
     */
    public static boolean comprobarCliente(String nif) throws SQLException{
        boolean existe = false;
        String query = buscarCliente();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = obtenerConexion();
            pst = con.prepareStatement(query);
            pst.setString(1,nif);
            rs = pst.executeQuery();
            if (rs.next ()) {
                existe = true;
            }
        }finally{
            rs.close();
            pst.close();
            con.close();
        }
        return existe;
    }
    
    /**
     * @deprecated sustituido por mostrarObj(String info, String query, String titulo)
     * Método para listar los datos de un cliente en función del nif
     * @param nif nif del cliente
     * @throws SQLException 
     */
    public static void mostrarCliente(String nif) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ModeloTabla modelo = null;
        JTable tabla = null;
        JFrame ventana = crearVentana(false);
        try (Connection con = obtenerConexion()){            
            ventana.setTitle("DATOS DE CLIENTE");
            pst = con.prepareStatement(buscarCliente(),ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            pst.setString(1,nif);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
        modelo = new ModeloTabla(rs);
        tabla = new JTable(modelo);
        ventana.add(new JScrollPane(tabla),BorderLayout.CENTER);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
