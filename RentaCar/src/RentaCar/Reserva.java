/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.Consultas_BBDD.contarReservas;
import static RentaCar.Consultas_BBDD.deleteReserva;
import static RentaCar.Consultas_BBDD.insertDetallesReservas;
import static RentaCar.Consultas_BBDD.insertReservas;
import static RentaCar.Consultas_BBDD.obtenerConexion;
import static RentaCar.Consultas_BBDD.recuperarReserva;
import static RentaCar.Consultas_BBDD.selectReservas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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

    //TODO ¿Tiene sentido este constructor?¿petaria al haber dos instancias con el mismo numero de reserva?
    //la fecha de solicitud no puede ser la misma ya que la debe coger automáticamente del sistema
    /**
     * Constructor copia.
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
        try(Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(contarReservas()); ResultSet rs = pst.executeQuery()) {
            while(rs.next()){
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

    public static JFrame listarReservas() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ModeloTabla modelo = null;
        JTable tabla = null;
        JFrame ventana = crearVentanaReservas();
        JPanel buscar = new JPanel();
        JButton buscarReserva = new JButton("BUSCAR RESERVA");
        try (Connection con = obtenerConexion()) {
            pst = con.prepareStatement(selectReservas(), ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        modelo = new ModeloTabla(rs);
        tabla = new JTable(modelo);
        setearColumnasReservas(tabla);
        ventana.add(new JScrollPane(tabla), BorderLayout.CENTER);

        buscarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = recuperarReserva();
                String reserva = JOptionPane.showInputDialog(null, "Introduce el numero de la reserva:", "BUSCAR RESERVA", JOptionPane.QUESTION_MESSAGE);
                try {
                    if ((reserva != null) && (reserva.trim().length() > 0)) {
                        if (Interfaz_Main.comprobarObj(reserva, query)) {
                            Interfaz_Main.mostrarObj(reserva, query, "RESERVA");
                        } else if (!Interfaz_Main.comprobarObj(reserva, query)) {
                            JOptionPane.showMessageDialog(null, "El número de reserva indicado no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No has indicado ningun numero de reserva.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    ventana.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buscar.add(buscarReserva);
        ventana.add(buscar, BorderLayout.SOUTH);

        return ventana;
    }

    public static JFrame crearVentanaReservas() {
        JFrame ventana = new JFrame();
        ventana.setTitle("LISTADO DE RESERVAS");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        ventana.setSize(1100, 400);
        int x = (int) ((dimension.getWidth() - ventana.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - ventana.getHeight()) / 2);
        ventana.setLocation(x, y);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        return ventana;
    }

    public static void setearColumnasReservas(JTable tabla) {
        tabla.getColumnModel().getColumn(8).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    /**
     * Método para comprobar si una reserva está pasada
     *
     * @param numReserva numero de reserva a verificar
     * @return true si la fecha de recogida no está pasada
     */
    public static boolean comprobarFechaReserva(String numReserva) throws SQLException {
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
                if (year > calendario.get(Calendar.YEAR)) {
                    if (month > calendario.get(Calendar.MONTH)) {
                        if (day > calendario.get(Calendar.DAY_OF_MONTH)) {
                            cancelable = true;
                        }
                    }
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
    public static void cancelarReserva(String numReserva) throws SQLException {
        String query = deleteReserva();
        PreparedStatement pst = null;
        Connection con = null;
        try {
            con = obtenerConexion();
            pst = con.prepareStatement(query);
            pst.setString(1, numReserva);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        } finally {
            con.close();
            pst.close();
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
        } catch (Exception ex) {
            con.rollback();
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

        String fechaSolicitud = year + "-" + (month + 1) + "-" + (day + 1);
        return fechaSolicitud;
    }
}
