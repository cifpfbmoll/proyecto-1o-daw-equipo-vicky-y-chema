/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.Consultas_BBDD.*;
import static RentaCar.General.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.*;

/**
 *
 * @author victoriapenas
 * @version 1.0
 * @since 2020-05-30
 */
public class Reserva {

    private static AtomicInteger RESERVA = new AtomicInteger(99);
    private String numReserva;
    private String matricula;
    private static final Calendar FECHASOLICITUD = Calendar.getInstance();
    private Calendar fechaHoraRecogida;
    private Calendar fechaHoraDevolucion;
    private String observaciones;
    private Double descuento;

    /**
     * Constructor vacío con un autoincremental
     */
    public Reserva() throws SQLException {
        this.setNumReserva("RES-" + getRESERVA().intValue());
    }

    /**
     * Constructor con parámetros
     *
     * @param matricula matricula del vehiculo reservado
     * @param fechaHoraRecogida fecha y hora de la recogida del vehiculo
     * reservado
     * @param fechaHoraDevolucion fecha y hora de la devolución del vehiculo
     * reservado
     * @param observaciones información facilitada por el cliente en relacion a
     * la reserva
     * @param descuento decuento aplicado en la reserva
     */
    public Reserva(String matricula, Calendar fechaHoraRecogida, Calendar fechaHoraDevolucion, String observaciones, Double descuento) throws SQLException {
        this.setNumReserva("RES-" + getRESERVA().intValue());
        this.setMatricula(matricula);
        this.setFechaHoraRecogida(fechaHoraRecogida);
        this.setFechaHoraDevolucion(fechaHoraDevolucion);
        this.setObservaciones(observaciones);
        this.setDescuento(descuento);
    }

    /**
     * Constructor copia. La fecha de solicitud no puede ser la misma ya que la
     * debe coger automáticamente del sistema. Si se intenta insertar en BBDD
     * una reserva con el mismo numReserva habrá un error por violación de la
     * constraint definida
     *
     * @param r1 r1 es un objeto de tipo Reserva.
     */
    public Reserva(Reserva r1) {
        this.setNumReserva(r1.getNumReserva());
        this.setMatricula(r1.getMatricula());
        this.setFechaHoraRecogida(r1.getFechaHoraRecogida());
        this.setFechaHoraDevolucion(r1.getFechaHoraDevolucion());
        this.setObservaciones(r1.getObservaciones());
        this.setDescuento(r1.getDescuento());
    }

    public static AtomicInteger getRESERVA() throws SQLException {
        try (Connection con = obtenerConexion();
                PreparedStatement pst = con.prepareStatement(contarReservas());
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                RESERVA.addAndGet(rs.getInt(1));
            }
        }
        return RESERVA;
    }

    public String getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(String numReserva) {
        this.numReserva = numReserva;
    }

    public Calendar getFECHASOLICITUD() {
        return FECHASOLICITUD;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Calendar getFechaHoraRecogida() {
        return fechaHoraRecogida;
    }

    public void setFechaHoraRecogida(Calendar fechaHoraRecogida) {
        this.fechaHoraRecogida = fechaHoraRecogida;
    }

    public Calendar getFechaHoraDevolucion() {
        return fechaHoraDevolucion;
    }

    public void setFechaHoraDevolucion(Calendar fechaHoraDevolucion) {
        this.fechaHoraDevolucion = fechaHoraDevolucion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    /**
     * Método para listar las reservas del sistema
     *
     * @param nif es el nif del cliente por el que se podrá filtrar los
     * resultados
     * @return devuelve una tabla con el listado de reservas
     */
    public static JFrame listarReservas(String nif) throws RCException, SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ModeloTabla modelo = null;
        JTable tabla = null;
        JFrame ventana = crearVentana(true);
        ventana.setTitle("LISTADO DE RESERVAS");
        JPanel buscar = new JPanel();
        JButton buscarReserva = new JButton("BUSCAR RESERVA");
        try (Connection con = obtenerConexion()) {
            pst = con.prepareStatement(selectReservas(), ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, nif);
            rs = pst.executeQuery();
        }
        modelo = new ModeloTabla(rs);
        tabla = new JTable(modelo);
        if (tabla.getRowCount() > 0) {
            setearColumnasReservas(tabla);
            ventana.add(new JScrollPane(tabla), BorderLayout.CENTER);
        } else {
            ventana.dispose();
            throw new RCException("No se ha encontrado ninguna reserva activa.");
        }

        buscarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = recuperarReserva();
                String reserva = JOptionPane.showInputDialog(null, "Introduce el numero de la reserva:", "BUSCAR RESERVA", JOptionPane.QUESTION_MESSAGE);
                try {
                    if ((reserva != null) && (reserva.trim().length() > 0)) {
                        if (General.comprobarObj(reserva, query)) {
                            General.mostrarObj(reserva, query, "RESERVA");
                        } else if (!General.comprobarObj(reserva, query)) {
                            throw new RCException("El número de reserva indicado no existe.");
                        }
                    } else {

                        throw new RCException("No has indicado ningun numero de reserva.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buscar.add(buscarReserva);
        ventana.add(buscar, BorderLayout.SOUTH);

        return ventana;

    }

    /**
     * Método para modificar el ancho de las columnas de la JTable de Reservas
     *
     * @param tabla tabla que se debe setear.
     */
    public static void setearColumnasReservas(JTable tabla) {
        tabla.getColumnModel().getColumn(8).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    /**
     * Método para comprobar si una reserva está pasada
     *
     * @param numReserva numero de reserva a verificar
     * @return true si la fecha de recogida no está pasada
     */
    public static boolean comprobarFechaReserva(String numReserva) throws SQLException, RCException {
        boolean cancelable = false;
        Calendar calendario = Calendar.getInstance();
        String query = recuperarReserva();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = obtenerConexion();
            pst = con.prepareStatement(query);
            pst.setString(1, numReserva);
            rs = pst.executeQuery();
            if (rs.next()) {
                String[] fecha = rs.getString("fecharecogida").split("-");
                int year = Integer.parseInt(fecha[0]);
                int month = Integer.parseInt(fecha[1]);
                int day = Integer.parseInt(fecha[2]);
                if (year >= calendario.get(Calendar.YEAR)) {
                    if (month >= calendario.get(Calendar.MONTH)) {
                        if (day > calendario.get(Calendar.DAY_OF_MONTH)) {
                            cancelable = true;
                        } else {
                            throw new RCException("No se pueden cancelar reservas de días anteriores.");
                        }
                    } else {
                        throw new RCException("No se pueden cancelar reservas de meses anteriores.");
                    }
                } else {
                    throw new RCException("No se pueden cancelar reservas de años anteriores.");
                }
            }
        } finally {
            rs.close();
            pst.close();
            con.close();
        }
        return cancelable;
    }

    /**
     * Método para cancelar una eliminar/cancelar una reserva
     *
     * @param numReserva numero de la reserva
     * @throws SQLException
     */
    public static void cancelarReserva(String nif) {
        String query = deleteReserva();
        PreparedStatement pst = null;
        Connection con = null;
        int reply = 0;
        JFrame ventana = null;
        try {
            ventana = listarReservas(nif);
            String reserva = JOptionPane.showInputDialog(null, "Introduce el número de la reserva que quieres cancelar",
                    "CANCELAR RESERVA", JOptionPane.QUESTION_MESSAGE);
            if ((reserva != null) && (reserva.trim().length() > 0)) {
                if (General.comprobarObj(reserva, recuperarReserva())) {
                    if (comprobarFechaReserva(reserva)) {
                        reply = JOptionPane.showConfirmDialog(null, "¿estás seguro?");
                        if (reply == JOptionPane.YES_OPTION) {
                            try {
                                con = obtenerConexion();
                                pst = con.prepareStatement(query);
                                pst.setString(1, reserva);
                                pst.setString(2, nif);
                                pst.executeUpdate();
                            } finally {
                                con.close();
                                pst.close();
                            }
                            JOptionPane.showMessageDialog(null, "Reserva " + reserva + " cancelada.", "RESERVA CANCELADA",
                                    JOptionPane.DEFAULT_OPTION);
                        }
                    }
                } else {
                    throw new RCException("El número de reserva indicado no es correcto.");
                }
            }
            ventana.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            ventana.dispose();
        }
    }

    public void registrarReserva(String horaRecogida, String horaDevolucion, String NIF, Double precio) throws SQLException {
        PreparedStatement pst = null;
        Connection con = null;
        String queryReserva = insertReservas();
        String queryDetalles = insertDetallesReservas();

        try {
            con = obtenerConexion();
            con.setAutoCommit(false);
            //INSERT tabla reservas
            pst = con.prepareStatement(queryReserva);
            pst.setString(1, this.getNumReserva());
            pst.setString(2, crearFecha(this.getFECHASOLICITUD()));
            pst.setString(3, crearFecha(this.getFechaHoraRecogida()));
            pst.setString(4, horaRecogida);
            pst.setString(5, crearFecha(this.getFechaHoraDevolucion()));
            pst.setString(6, horaDevolucion);
            pst.setString(7, this.getObservaciones());
            pst.setString(8, NIF);
            pst.executeUpdate();
            //INSERT tabla detalles_reserva
            pst = con.prepareStatement(queryDetalles);
            pst.setString(1, this.getNumReserva());
            pst.setString(2, this.getMatricula());
            pst.setDouble(3, precio);
            pst.setDouble(4, this.getDescuento());
            pst.executeUpdate();

            con.commit();
            JOptionPane.showMessageDialog(null, "Reserva creada correctamente", "RESERVA CREADA", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            con.rollback();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.setAutoCommit(true);
            con.close();
            pst.close();
        }
    }

    public static String crearFecha(Calendar cal) {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        String fechaSolicitud = year + "-" + (month + 1) + "-" + day;
        return fechaSolicitud;
    }
}
