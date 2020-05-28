/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.Consultas_BBDD.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * Clase abstracta Vehiculo
 * 
 * @version 2.0
 * @author Chema
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
    public Vehiculo(){
        
    }
    
    /**
     * Constructor con parametros
     * @param matricula
     * @param marca
     * @param modelo
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
     * Este metodo se encarga de listar los vehiculos existentes en el sistema
     * @param ventana ventana es el internalFrame donde se listarán los vehiculos
     * @throws SQLException 
     */
    public static void listarVehiculos(Interfaz_ListarVehiculos ventana) throws SQLException{
        int count = 0;
        Connection con = obtenerConexion();        
        try (PreparedStatement ps = con.prepareStatement(selectVehiculos()); ResultSet rs = ps.executeQuery()){
            while (rs.next ()) {
                if (!rs.getBoolean("retirado")){
                    ventana.getVehiculosEncontrados().append("MATRICULA: " + rs.getString(1) + " - MARCA: " + rs.getString(2) + 
                    " - MODELO: " + rs.getString(3) + " - CATEGORIA: " + rs.getString(4) + " - PRECIO: " + rs.getInt(5)
                    + " €/DIA.");
                    ventana.getVehiculosEncontrados().append("\n");
                    count++;
                }
            }
            if (count > 0){
                ventana.getTotalVehiculos().setText("Se han econtrado " + count + " vehiculos.");
            }else{
                ventana.getTotalVehiculos().setText("No se han encontrado vehiculos");
                ventana.getTotalVehiculos().setForeground(Color.RED);
            }
        } finally{
            if (con != null) con.close ();
        }
    }
    
    public static void extraerMarcas(JComboBox marcas) throws SQLException{
        Connection con = obtenerConexion();        
        try (PreparedStatement ps = con.prepareStatement(listarMarcas()); ResultSet rs = ps.executeQuery()){
            while (rs.next ()) {
                marcas.addItem(rs.getString(1));
            }
        }finally{
            if (con != null) con.close ();
        }
    }
    
    public static void extraerClases(JComboBox clases) throws SQLException{
        Connection con = obtenerConexion();        
        try (PreparedStatement ps = con.prepareStatement(listarClases()); ResultSet rs = ps.executeQuery()){
            while (rs.next ()) {
                clases.addItem(rs.getString(1));
            }
        }finally{
            if (con != null) con.close ();
        }
    }
    
    /**
     * Método para comprobar si todos los campos de alta de un usuario están
     * completados
     *
     * @return devuelve un booleano con el resultado
     */
    public boolean revisarDatosVehiculo() {
        boolean camposCompletos = true;
        if (this.getMatricula().isEmpty() || this.getMatricula() == null || this.getMarca().isEmpty()
                || this.getMarca() == null || this.getMarca() == " " || this.getModelo().isEmpty()
                || this.getModelo() == null || this.getClase() == 0 || this.getPrecioDia() == 0) {

            camposCompletos = false;
        }
        
        return camposCompletos;
    }
    
    /**
     * Método para recuperar la PK de la clase seleccionada
     */
    public abstract void registrarVehiculo(JLabel resultado) throws SQLException;
    
    public static char obtenerClasePK(String nombre) throws SQLException{
        char cod = 0;
        String query = reuperarPKClase();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = obtenerConexion();
            pst = con.prepareStatement(query);
            pst.setString(1, nombre);
            rs = pst.executeQuery();
            while (rs.next ()) {
                cod = rs.getString(1).charAt(0);
            }
        }finally{
            con.close();
            pst.close();
            rs.close();
        }
        return cod;
    }
    
    /**
     * Método para saber si el vehiculo está disponible
     * @param disponible valor true/false disponibilidad
     * @return valor disponibilidad
     */
    public static boolean estaDisponible(JCheckBox disponible){
        if (!disponible.isSelected()){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * Método para modificar un vehiculo de la BBDD a retirado = true
     * @param matricula matricula para filtrar el vehiculo en la BBDD
     * @throws SQLException 
     */
    public static void bajaVehiculo(String matricula) throws SQLException{
        String query = eliminarVehiculo();
        PreparedStatement pst = null;
        Connection con = null;
        try {
            con = obtenerConexion();
            pst = con.prepareStatement(query);
            pst.setString(1, matricula);
            pst.executeUpdate();
        }finally{
            con.close();
            pst.close();
        }
    }
    
    public static void modificarPrecio(Double precio, String matricula) throws SQLException{
        String query = modificarPrecioSQL();
        PreparedStatement pst = null;
        Connection con = null;
        try {
            con = obtenerConexion();
            pst = con.prepareStatement(query);
            pst.setDouble(1, precio);
            pst.setString(2, matricula);
            pst.executeUpdate();
        }finally{
            con.close();
            pst.close();
        }
    }
    
    /**
     * Método para comprobar si un vehiculo existe y está operativo
     * @param matricula matricula para localizar el vehiculo en la BBDD
     * @return booleano con el resultado
     * @throws SQLException 
     */
    public static boolean comprobarVehiculo(String matricula) throws SQLException{
        boolean existe = false;
        String query = recuperarVehiculo();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = obtenerConexion();
            pst = con.prepareStatement(query);
            pst.setString(1,matricula);
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
}
