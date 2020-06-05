/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.Consultas_BBDD.obtenerConexion;
import static RentaCar.Reserva.setearColumnasReservas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Esta clase, tiene métodos que se utilizan para el funcionamiento de la
 * aplicación a nivel general.
 *
 * @author victoriapenas y josemariahernandez
 * @version 1.0
 * @since 2020-06-03
 */
final public class General {

    /**
     * Método para crear un JFrame centrados en la pantalla en función de la
     * resolución
     * @param tablaGrande booleano para indicar si el JTable a desplegar debe tener un tamaño grande o pequeño
     * @return devuelve el JFrame
     */
    public static JFrame crearVentana(boolean tablaGrande) {
        JFrame ventana = new JFrame();
        ventana.setResizable(false);
        Dimension medidaPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        if (tablaGrande) {
            ventana.setSize(1100, 400);
            int x = (int) ((medidaPantalla.getWidth() - ventana.getWidth()) / 2);
            int y = (int) ((medidaPantalla.getHeight() - ventana.getHeight()) / 2);
            ventana.setLocation(x, y);
            ventana.setVisible(true);
        } else {
            int alturaPantalla = medidaPantalla.height;
            int anchoPantalla = medidaPantalla.width;
            ventana.setSize(anchoPantalla / 2, alturaPantalla / 2);
            ventana.setLocation(anchoPantalla / 4, alturaPantalla / 4);
        }
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        return ventana;
    }

    /**
     * Permite iniciar cualquier internal frame centrado
     *
     * @param pane pane que contiene un JInternalFrame
     * @param frame frame que se debe centrar
     */
    public static void centrarFrame(JDesktopPane pane, JInternalFrame frame) {
        Dimension desktopSize = pane.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    /**
     * Método para comprobar si un objeto existe en bbdd
     *
     * @param info primary key a chequear en la bbdd
     * @param query query a ejecutar
     * @throws SQLException este método lanza una excepcion SQLexception que se debe controlar
     * 
     * @return devuelve tru si el objeto existe en la BBDD
     */
    public static boolean comprobarObj(String info, String query) throws SQLException {
        boolean existe = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = obtenerConexion();
            pst = con.prepareStatement(query);
            pst.setString(1, info);
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
     * Método para generar una JTable con la información exportada de la bbdd
     *
     * @param info primary key a chequear en la bbdd
     * @param query query a ejecutar
     * @param titulo titulo del JFrame
     * @throws SQLException este método lanza una excepcion SQLexception que se debe controlar
     * @throws IOException este método lanza una excepcion IOExceptionn que se debe controlar
     */
    public static void mostrarObj(String info, String query, String titulo) throws SQLException, IOException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ModeloTabla modelo = null;
        JTable tabla = null;
        JFrame ventana = null;
        if (titulo.equals("RESERVA")) {
            ventana = crearVentana(true);
        } else {
            ventana = crearVentana(false);
        }
        try (Connection con = obtenerConexion()) {
            pst = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, info);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        modelo = new ModeloTabla(rs);
        tabla = new JTable(modelo);
        if (titulo.equals("RESERVA")) {
            setearColumnasReservas(tabla);
        }
        ventana.setTitle(titulo);
        ventana.add(new JScrollPane(tabla), BorderLayout.CENTER);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Método para comprobar si una cadena contiene solo números
     *
     * @param strNum recibe una string
     * @return devulve true si es numérica
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null || strNum.contains("-")) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para verificar si un texto contiene números.
     *
     * @param str la cadena a analizar
     * @return true si solo contiene letras
     */
    public static boolean isStringOnlyAlphabet(String str) {
        return ((str != null)
                && (!str.equals(""))
                && (str.matches("^[a-zA-Z]*$")));
    }
}
