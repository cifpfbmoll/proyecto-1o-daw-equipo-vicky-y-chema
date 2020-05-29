/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.Consultas_BBDD.*;
import static RentaCar.Usuario.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author victoriapenas
 */
public class Interfaz_ListarClientes extends JFrame{
    
    private ResultSet rs;
    private Connection con;
    private PreparedStatement pst;
    private ModeloTabla modelo;
    private JButton buscarCliente;
    private JTable tabla;

    public Interfaz_ListarClientes() {
        JPanel buscar = new JPanel();
    
        this.setTitle("LISTADO DE CLIENTES");
        this.setBounds(300, 300, 600, 400);
        try {
            con = obtenerConexion();
            pst = con.prepareStatement(listarClientes(),ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();
            modelo = new ModeloTabla(rs);
            tabla = new JTable(modelo);
            this.add(new JScrollPane(tabla),BorderLayout.CENTER);
            validate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        this.setVisible(true);
        
        buscarCliente = new JButton("BUSCAR CLIENTE");
        buscarCliente.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String nif = JOptionPane.showInputDialog(null, "Introduce el NIF del cliente", "BUSCAR CLIENTE", JOptionPane.QUESTION_MESSAGE);
            try {
                if (comprobarCliente(nif)){
                    mostrarCliente(nif);
                }else{
                    JOptionPane.showMessageDialog(null, "El NIF indicado no existe.","ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        });
        
        buscar.add(buscarCliente);
        this.add(buscar,BorderLayout.SOUTH);
    }
}
