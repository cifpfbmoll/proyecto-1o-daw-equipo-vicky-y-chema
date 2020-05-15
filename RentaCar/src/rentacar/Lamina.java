/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import static rentacar.RentaCar.obtenerConexion;
import static rentacar.Usuario.insertRegistro;
import static rentacar.Usuario.obtenerRolId;

/**
 *
 * @author victoriapenas
 * @version 1.0
 * @since 2020-05-20
 * 
 * Esta clase la utilizaremos para pintar capas sobre las ventanas.
 */
public class Lamina extends JPanel{
    private JTextField nif = new JTextField(15);
    private JTextField nombre = new JTextField(15);
    private JTextField apellido1 = new JTextField(15);
    private JTextField apellido2 = new JTextField(15);
    private JTextField telefono = new JTextField(15);
    private JTextField email = new JTextField(15);
    private JTextField rol = new JTextField("Cliente",15);
    private JTextField codUsuario = new JTextField(15);
    private JTextField password = new JTextField(15);
    private JLabel resultado;

    public Lamina() {
        super();
    }

    public JTextField getNif() {
        return nif;
    }

    public void setNif(JTextField nif) {
        this.nif = nif;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }

    public JLabel getResultado() {
        return resultado;
    }

    public void setResultado(JLabel resultado) {
        this.resultado = resultado;
    }

    public JTextField getApellido1() {
        return apellido1;
    }

    public void setApellido1(JTextField apellido1) {
        this.apellido1 = apellido1;
    }

    public JTextField getApellido2() {
        return apellido2;
    }

    public void setApellido2(JTextField apellido2) {
        this.apellido2 = apellido2;
    }

    public JTextField getTelefono() {
        return telefono;
    }

    public void setTelefono(JTextField telefono) {
        this.telefono = telefono;
    }

    public JTextField getEmail() {
        return email;
    }

    public void setEmail(JTextField email) {
        this.email = email;
    }

    /**
     * El rol siempre será "Cliente". Es de solo lectura.
     * @return rol no editable.
     */
    public JTextField getRol() {
        this.rol.setEditable(false);
        return rol;
    }

    public void setRol(JTextField rol) {
        this.rol = rol;
    }

    public JTextField getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(JTextField codUsuario) {
        this.codUsuario = codUsuario;
    }

    public JTextField getPassword() {
        return password;
    }

    public void setPassword(JTextField password) {
        this.password = password;
    }

    /**
     * Este método se utiliza para pintar los campos del formulario de registro.
     * 
     * @see java.awt.BorderLayout;
     * @see java.awt.FlowLayout
     * @see javax.swing.JPanel
     * @see javax.swing.JLabel
     * @see javax.swing.JButton
     * 
     */
    public void laminaRegistro(){
        JLabel mensaje = new JLabel("Por favor, rellena todos los campos.",JLabel.CENTER);
        JLabel nif = new JLabel("Introduce tu NIF",JLabel.RIGHT);
        JLabel nombre = new JLabel("Introduce tu nombre",JLabel.RIGHT);
        JLabel apellido1 = new JLabel("Primer apellido",JLabel.RIGHT);
        JLabel apellido2 = new JLabel("Segundo apellido",JLabel.RIGHT);
        JLabel telefono = new JLabel("Teléfono",JLabel.RIGHT);
        JLabel email = new JLabel("E-mail",JLabel.RIGHT);
        JLabel rol = new JLabel("Rol",JLabel.RIGHT);
        JLabel codUsuario = new JLabel("Indica un código de usuario",JLabel.RIGHT);
        JLabel password = new JLabel("Indica una contraseña",JLabel.RIGHT);
        
        
                
        //Capa principal
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(20, 0, 10, 0));
        this.add(mensaje,BorderLayout.NORTH);
        
        //segunda capa
        JPanel capa2 = new JPanel();
        capa2.setBorder(new EmptyBorder(10, 0, 10, 110));
        capa2.setLayout(new GridLayout(9,2));
        capa2.add(nif);
        capa2.add(this.getNif());
        capa2.add(nombre);
        capa2.add(this.getNombre());
        capa2.add(apellido1);
        capa2.add(this.getApellido1());
        capa2.add(apellido2);
        capa2.add(this.getApellido2());
        capa2.add(telefono);
        capa2.add(this.getTelefono());
        capa2.add(email);
        capa2.add(this.getEmail());
        capa2.add(rol);
        capa2.add(this.getRol());
        capa2.add(codUsuario);
        capa2.add(this.getCodUsuario());
        capa2.add(password);
        capa2.add(this.getPassword());
        this.add(capa2,BorderLayout.CENTER);
        
        //tercera capa
        JPanel capa3 = new JPanel();
        capa3.setLayout(new FlowLayout());
        JButton crearUser = new JButton ("Enviar");
        crearUser.setPreferredSize(new Dimension(100, 40));
        recogerDatos eventoBoton = new recogerDatos("crearUser");
        crearUser.addActionListener(eventoBoton);
        capa3.add(crearUser,BorderLayout.SOUTH);
        this.setResultado(new JLabel("",JLabel.CENTER));
        capa3.add(this.getResultado());
        this.add(capa3,BorderLayout.SOUTH);
        
    }
    
    /**
     * Clase interna que ejecuta los diferentes eventos.
     */
    private class recogerDatos implements ActionListener{
        private String emisor;
        //multiples oyente https://www.youtube.com/watch?v=smJg5QjlBpU&t=3s

        /**
         * El constructor recibe por parámetro el nombre del evento que ejecuta la acción
         * @param nombreBoton nombreBoton correspone al nombre del evento desencadenante
         */
        public recogerDatos(String nombreBoton) {
            this.setEmisor(nombreBoton);
        }

        public String getEmisor() {
            return emisor;
        }

        public void setEmisor(String emisor) {
            this.emisor = emisor;
        }
        

        @Override
        public void actionPerformed(ActionEvent e) {
            if (this.getEmisor().equals("crearUser")){
                insertRegistro(nif.getText().trim(),nombre.getText().trim(),
                apellido1.getText().trim(),apellido2.getText().trim(),telefono.getText().trim(),email.getText().trim(),
                rol.getText().trim(),codUsuario.getText().trim(),password.getText().trim(), resultado);
            }
        }
    }  
}
