/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.Consultas_BBDD.*;
import static RentaCar.General.crearVentana;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 * Clase abstracta Vehiculo
 *
 * @version 2.0
 * @author victoriapenas y josemariahernandez
 */
public abstract class Vehiculo implements Consultas_BBDD {

    /*Atributos precioDia es Double para poder checkear si está a nulo*/
    private String matricula;
    private String marca;
    private String modelo;
    private Double precioDia;
    private char clase;

    /**
     * Constructor vacío
     */
    public Vehiculo() {

    }

    /**
     * Constructor con parametros
     *
     * @param matricula matricula del vehiculo
     * @param marca marca del vehiculo
     * @param modelo modelo del vehiculo
     * @param precioDia coste por dia de alquiler
     * @param clase categoria del vehiculo
     */
    public Vehiculo(String matricula, String marca, String modelo, double precioDia, char clase) {
        this.setMatricula(matricula);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPrecioDia(precioDia);
        this.setClase(clase);
    }

    /**
     * Constructor copia
     *
     * @param v1 Vehiculo recibido
     */
    public Vehiculo(Vehiculo v1) {
        this.setMatricula(v1.getMatricula());
        this.setMarca(v1.getMarca());
        this.setModelo(v1.getModelo());
        this.setPrecioDia(v1.getPrecioDia());
        this.setClase(v1.getClase());
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(Double precioDia) {
        this.precioDia = precioDia;
    }

    public char getClase() {
        return clase;
    }

    public void setClase(char clase) {
        this.clase = clase;
    }

    /**
     * Este metodo se encarga de listar los vehiculos existentes en una JTable
     *
     * @see javax.swing.JTable
     * @see javax.swing.table.AbstractTableModel
     * @return devuelve el JFrame con el listado de vehiculos
     */
    public static JFrame listarVehiculos() {
        String query = recuperarVehiculo();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ModeloTabla modelo = null;
        JTable tabla = null;
        JFrame ventana = crearVentana(false);
        JPanel buscar = new JPanel();
        JButton buscarVehiculo = new JButton("BUSCAR VEHICULO");
        ventana.setTitle("LISTADO DE VEHICULOS");
        try (Connection con = obtenerConexion()) {
            pst = con.prepareStatement(selectVehiculos(), ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        modelo = new ModeloTabla(rs);
        tabla = new JTable(modelo);
        ventana.add(new JScrollPane(tabla), BorderLayout.CENTER);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        buscarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricula = JOptionPane.showInputDialog(null, "Introduce la matricula del vehiculo", "BUSCAR VEHICULO", JOptionPane.QUESTION_MESSAGE);
                try {
                    buscarTipoVehiculo(matricula, query);
                    ventana.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buscar.add(buscarVehiculo);
        ventana.add(buscar, BorderLayout.SOUTH);

        return ventana;
    }

    /**
     * Método para mostrar las especificaciones del vehiculo en función del tipo
     *
     * @param matricula matricula del vehiculo
     * @param query query para comprobar si la matricula existe como activa en
     * la BBDD
     * @throws SQLException este método lanza una excepcion SQLexception que se debe controlar
     */
    public static void buscarTipoVehiculo(String matricula, String query) throws SQLException {
        int tipo = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try (Connection con = obtenerConexion()) {
            if ((matricula != null) && (matricula.trim().length() > 0)) {
                if (General.comprobarObj(matricula, query)) {
                    pst = con.prepareStatement(selectTipoVehiculo(), ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
                    pst.setString(1, matricula);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        tipo = rs.getInt(1);
                    }
                    switch (tipo) {
                        case 0:
                            General.mostrarObj(matricula, datosCoche(), "COCHE");
                            break;
                        case 1:
                            General.mostrarObj(matricula, datosCaravana(), "CARAVANA");
                            break;
                        case 2:
                            General.mostrarObj(matricula, datosMoto(), "MOTO");
                            break;
                        default:
                            break;
                    }
                } else if (!General.comprobarObj(matricula, query)) {
                    throw new RCException("La matricula indicada no existe o no está activa.");
                }
            } else {
                throw new RCException("No has indicado ninguna matricula.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para rellenar el desplegable de marcas Interfaz_RegistroVehiculos
     * con datos de las BBDD
     *
     * @param marcas marcas es el JCombobox a rellenar
     * @throws SQLException este método lanza una excepcion SQLexception que se debe controlar
     */
    public static void extraerMarcas(JComboBox marcas) throws SQLException {
        Connection con = obtenerConexion();
        try (PreparedStatement ps = con.prepareStatement(listarMarcas()); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                marcas.addItem(rs.getString(1));
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * Método para rellenar el desplegable de clases Interfaz_RegistroVehiculos
     * con datos de las BBDD
     *
     * @param clases clases es el JCombobox a rellenar
     * @throws SQLException este método lanza una excepcion SQLexception que se debe controlar
     */
    public static void extraerClases(JComboBox clases) throws SQLException {
        Connection con = obtenerConexion();
        try (PreparedStatement ps = con.prepareStatement(listarClases()); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                clases.addItem(rs.getString(1));
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * Método para recuperar la PK de la clase seleccionada
     * @throws SQLException este método lanza una excepcion SQLexception que se debe controlar
     */
    public abstract void registrarVehiculo() throws SQLException;

    /**
     * Método para obtener el codigo de una clase en función de su nombre
     *
     * @param nombre nombre de la clase que se quiere recuperar
     * @return devuelve el codigo de la clase
     * @throws SQLException este método lanza una excepcion SQLexception que se debe controlar
     */
    public static char obtenerClasePK(String nombre) throws SQLException {
        char cod = 0;
        String query = recuperarPKClase();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = obtenerConexion();
            pst = con.prepareStatement(query);
            pst.setString(1, nombre);
            rs = pst.executeQuery();
            while (rs.next()) {
                cod = rs.getString(1).charAt(0);
            }
        } finally {
            con.close();
            pst.close();
            rs.close();
        }
        return cod;
    }

    /**
     * Método para saber si el vehiculo está disponible
     *
     * @param disponible valor true/false disponibilidad
     * @return valor disponibilidad
     */
    public static boolean estaDisponible(JCheckBox disponible) {
        if (!disponible.isSelected()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Método para modificar un vehiculo de la BBDD a retirado = true
     *
     * @throws SQLException este método lanza una excepcion SQLexception que se debe controlar
     * @throws RCException este método lanza una excepcion personalizada RCException que se debe controlar
     */
    public static void bajaVehiculo() throws SQLException, RCException {
        int reply = 0;
        JFrame ventana = listarVehiculos();
        String query = eliminarVehiculo();
        PreparedStatement pst = null;
        Connection con = null;
        String matricula = JOptionPane.showInputDialog(null, "Introduce la matrícula", "BAJA VEHICULO", JOptionPane.QUESTION_MESSAGE);
        if ((matricula != null) && (matricula.trim().length() > 0)) {
            if (General.comprobarObj(matricula, recuperarVehiculo())) {
                reply = JOptionPane.showConfirmDialog(null, "¿estás seguro?");
                if (reply == JOptionPane.YES_OPTION) {
                    try {
                        con = obtenerConexion();
                        pst = con.prepareStatement(query);
                        pst.setString(1, matricula);
                        pst.executeUpdate();
                    } finally {
                        con.close();
                        pst.close();
                    }
                    JOptionPane.showMessageDialog(null, "Vehiculo con matrícula " + matricula + " eliminado.", "VEHICULO ELIMINADO", JOptionPane.DEFAULT_OPTION);
                }
            } else {
                throw new RCException("La matrícula indicada no existe o no está activa.");
            }
            ventana.dispose();
        }
    }

    /**
     * Método para modificar el precio de un vehiculo
     *
     * @throws SQLException este método lanza una excepcion SQLexception que se debe controlar
     * @throws RCException este método lanza una excepcion RCException que se debe controlar
     */
    public static void modificarPrecio() throws SQLException, RCException {
        int reply = 0;
        JFrame ventana = listarVehiculos();
        String query = modificarPrecioSQL();
        PreparedStatement pst = null;
        Connection con = null;
        String matricula = JOptionPane.showInputDialog(null, "Introduce la matrícula",
                "MODIFICAR PRECIO", JOptionPane.QUESTION_MESSAGE);
        if ((matricula != null) && (matricula.trim().length() > 0)) {
            if (General.comprobarObj(matricula, recuperarVehiculo())) {
                String precio = JOptionPane.showInputDialog(null, "Introduce el nuevo precio",
                        "MODIFICAR PRECIO", JOptionPane.QUESTION_MESSAGE);
                if ((precio != null) && (precio.trim().length() > 0)) {
                    if (Double.parseDouble(precio) < 0) {
                        throw new RCException("El precio debe ser mayor a 0€.");
                    } else {
                        reply = JOptionPane.showConfirmDialog(null, "¿estás seguro?");
                        if (reply == JOptionPane.YES_OPTION) {
                            try {
                                con = obtenerConexion();
                                pst = con.prepareStatement(query);
                                pst.setDouble(1, Double.parseDouble(precio));
                                pst.setString(2, matricula);
                                pst.executeUpdate();
                            } finally {
                                con.close();
                                pst.close();
                            }
                            JOptionPane.showMessageDialog(null, "Vehiculo con matrícula "
                                    + matricula + " actualizado.", "VEHICULO ACTUALIZADO", JOptionPane.DEFAULT_OPTION);
                        }
                    }
                }
            } else {
                throw new RCException("La matrícula indicada no existe o no está activa.");
            }
        }
        ventana.dispose();
    }

    /**
     * @deprecated sustituido por comprobarObj(String info, String query)
     *
     * Método para comprobar si un vehiculo existe y está operativo
     * @param matricula matricula para localizar el vehiculo en la BBDD
     * @return booleano con el resultado
     * @throws SQLException este método lanza una excepcion SQLexception que se debe controlar
     */
    public static boolean comprobarVehiculo(String matricula) throws SQLException {
        boolean existe = false;
        String query = recuperarVehiculo();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = obtenerConexion();
            pst = con.prepareStatement(query);
            pst.setString(1, matricula);
            rs = pst.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } finally {
            rs.close();
            pst.close();
            con.close();
        }
        return existe;
    }

    /**
     * @deprecated sustituido por mostrarObj(String info, String query, String
     * titulo)
     * @param matricula matricula del vehiculo
     * @throws SQLException este método lanza una excepcion SQLexception que se debe controlar
     */
    public static void mostrarVehiculo(String matricula) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ModeloTabla modelo = null;
        JTable tabla = null;
        JFrame ventana = crearVentana(false);
        try (Connection con = obtenerConexion()) {
            ventana.setTitle("VEHICULO");
            pst = con.prepareStatement(buscarVehiculo(), ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, matricula);
            rs = pst.executeQuery();
        }
        modelo = new ModeloTabla(rs);
        tabla = new JTable(modelo);
        ventana.add(new JScrollPane(tabla), BorderLayout.CENTER);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
