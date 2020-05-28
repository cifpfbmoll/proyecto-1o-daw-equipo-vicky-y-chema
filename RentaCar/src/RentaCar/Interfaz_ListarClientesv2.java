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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author victoriapenas
 */
public class Interfaz_ListarClientesv2 extends JFrame{
    
    private ResultSet rs;
    private Connection con;
    private PreparedStatement pst;
    private ModeloTabla modelo;
    private JButton buscarCliente;
    private JTable tabla;

    public Interfaz_ListarClientesv2() {
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
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                //TODO no puedo cerrar los recursos rs y pst porqué sino no me pintan los datos en el frame
            }
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
