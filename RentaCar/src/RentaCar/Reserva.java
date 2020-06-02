/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.Consultas_BBDD.deleteReserva;
import static RentaCar.Consultas_BBDD.modificarPrecioSQL;
import static RentaCar.Consultas_BBDD.obtenerConexion;
import static RentaCar.Consultas_BBDD.recuperarReserva;
import static RentaCar.Consultas_BBDD.selectReservas;
import static RentaCar.Interfaz_Main.crearVentana;
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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private static final AtomicInteger RESERVA = new AtomicInteger(99);
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
    public Reserva() {
        this.setNumReserva("RES-" + getRESERVA().incrementAndGet());
    }

    /**
     * Constructor con parámetros
     * @param matricula matricula del vehiculo reservado
     * @param fechaHoraRecogida fecha y hora de la recogida del vehiculo reservado
     * @param fechaHoraDevolucion fecha y hora de la devolución del vehiculo reservado
     * @param observaciones información facilitada por el cliente en relacion a la reserva
     * @param descuento decuento aplicado en la reserva
     */
    public Reserva(String matricula, Calendar fechaHoraRecogida, Calendar fechaHoraDevolucion, String observaciones,Double descuento) {
        this.setNumReserva("RES-" + getRESERVA().incrementAndGet());
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
    
    public static AtomicInteger getRESERVA() {
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
     * @param nif es el nif del cliente por el que se podrá filtrar los resultados
     * @return devuelve una tabla con el listado de reservas
     */
    public static JFrame listarReservas(String nif) throws RCException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        ModeloTabla modelo = null;
        JTable tabla = null;
        JFrame ventana = crearVentana(true);
        ventana.setTitle("LISTADO DE RESERVAS");
        JPanel buscar = new JPanel();
        JButton buscarReserva = new JButton("BUSCAR RESERVA");
        try (Connection con = obtenerConexion()){                      
            pst = con.prepareStatement(selectReservas(),ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, nif);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
        modelo = new ModeloTabla(rs);
        tabla = new JTable(modelo);
        if (tabla.getRowCount()>0){
            setearColumnasReservas(tabla);
            ventana.add(new JScrollPane(tabla),BorderLayout.CENTER);
        }else{
            ventana.dispose();
            throw new RCException("No se ha encontrado ninguna reserva activa.");
        }
        
        buscarReserva.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String query = recuperarReserva();
            String reserva = JOptionPane.showInputDialog(null, "Introduce el numero de la reserva:", "BUSCAR RESERVA", JOptionPane.QUESTION_MESSAGE);
            try {
                if ((reserva != null) && (reserva.trim().length() > 0)){
                    if (Interfaz_Main.comprobarObj(reserva,query)){
                        Interfaz_Main.mostrarObj(reserva,query,"RESERVA");
                    }else if (!Interfaz_Main.comprobarObj(reserva,query)){
                        throw new RCException("El número de reserva indicado no existe.");
                    }
                }else{
                    
                    throw new RCException("No has indicado ningun numero de reserva.");
                }
                ventana.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        });
        buscar.add(buscarReserva);
        ventana.add(buscar,BorderLayout.SOUTH);
        
        return ventana;
    }
    
    
    public static void setearColumnasReservas(JTable tabla){
        tabla.getColumnModel().getColumn(8).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(100);
    }
    
    /**
     * Método para comprobar si una reserva está pasada
     * @param numReserva numero de reserva a verificar
     * @return true si la fecha de recogida no está pasada
     */
    public static boolean comprobarFechaReserva(String numReserva) throws SQLException, RCException{
        boolean cancelable = false;
        Calendar calendario = Calendar.getInstance();
        String query = recuperarReserva();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = obtenerConexion();
            pst = con.prepareStatement(query);
            pst.setString(1,numReserva);
            rs = pst.executeQuery();
            if (rs.next ()) {
                String [] fecha = rs.getString("fecharecogida").split("-");
                int year = Integer.parseInt(fecha[0]);
                int month = Integer.parseInt(fecha[1]);
                int day = Integer.parseInt(fecha[2]);
                if (year >= calendario.get(Calendar.YEAR)){
                    if (month >= calendario.get(Calendar.MONTH)){
                        if (day > calendario.get(Calendar.DAY_OF_MONTH)){
                            cancelable = true;
                        }
                    }
                }else{
                    throw new RCException("Las reservas pasadas no se pueden cancelar.");
                }
            }
        } finally{
            rs.close();
            pst.close();
            con.close();
        }
        return cancelable;
    }
        
    /**
     * Método para cancelar una eliminar/cancelar una reserva
     * @param numReserva numero de la reserva
     * @throws SQLException 
     */
    public static void cancelarReserva(String nif) throws SQLException, RCException{
        String query = deleteReserva();
        PreparedStatement pst = null;
        Connection con = null;
        int reply = 0;
        JFrame ventana = null;
        ventana = listarReservas(nif);
        String reserva = JOptionPane.showInputDialog(null, "Introduce el número de la reserva que quieres cancelar",
                "CANCELAR RESERVA", JOptionPane.QUESTION_MESSAGE);
        if ((reserva != null) && (reserva.trim().length() > 0)){
            if (Interfaz_Main.comprobarObj(reserva,recuperarReserva())){
                    if(comprobarFechaReserva(reserva)){
                        reply = JOptionPane.showConfirmDialog(null, "¿estás seguro?");
                        if (reply == JOptionPane.YES_OPTION) {
                            try {
                                con = obtenerConexion();
                                pst = con.prepareStatement(query);
                                pst.setString(1, reserva);
                                pst.setString(2, nif);
                                pst.executeUpdate();
                            }finally{
                                con.close();
                                pst.close();
                            }  
                        JOptionPane.showMessageDialog(null, "Reserva " + reserva + " cancelada.","RESERVA CANCELADA"
                                , JOptionPane.DEFAULT_OPTION);
                        }
                    }
            }else{
                throw new RCException("El número de reserva indicado no es correcto.");
            }
        }
        ventana.dispose();
    }

}
