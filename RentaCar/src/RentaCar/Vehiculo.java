/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Chema
 */
public class Vehiculo {
    
    // Atributos
    private String matricula;
    private String marca;
    private String modelo;
    private double precioDia;
    private char clase;
    private int numeroPuertas;
    private boolean disponible;
    
    // Constructor vacío
    public Vehiculo(){
        
    }
    
    // Constructor
    public Vehiculo(String matricula, String marca, String modelo, double precioDia, char clase, int numeroPuertas, boolean disponible) {
        this.setMatricula(matricula);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPrecioDia(precioDia);
        this.setClase(clase);
        this.setNumeroPuertas(numeroPuertas);
        this.setDisponible(disponible);
    }
    
    // Constructor copia
    public Vehiculo(Vehiculo v1) {
        this.setMatricula(v1.getMatricula());
        this.setMarca(v1.getMarca());
        this.setModelo(v1.getModelo());
        this.setPrecioDia(v1.getPrecioDia());
        this.setClase(v1.getClase());
        this.setNumeroPuertas(v1.getNumeroPuertas());
        this.setDisponible(v1.isDisponible());
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

    public double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

    public char getClase() {
        return clase;
    }

    public void setClase(char clase) {
        this.clase = clase;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public static void listarVehiculos() throws SQLException{
        Conexion_BBDD con = new Conexion_BBDD();
        try (PreparedStatement ps = con.conectado().prepareStatement(selectVehiculos());ResultSet rs = ps.executeQuery()){
            while (rs.next ()) {
            System.out.println("MATRICULA: " + rs.getString(1) + " - MARCA: " + rs.getString(2) + " - MODELO: " + 
            rs.getString(3) + " - CATEGORIA: " + rs.getString(4) + " - PRECIO/DIA: " + rs.getInt(5));
            }
        } finally{
            if (con != null) con.conectado().close (); //cierra el objeto Connection
        }

        /*Connection con = obtenerConexion();        
        try (PreparedStatement ps = con.prepareStatement(selectVehiculos()); ResultSet rs = ps.executeQuery()){
            while (rs.next ()) {
                System.out.println("MATRICULA: " + rs.getString(1) + " - MARCA: " + rs.getString(2) + " - MODELO: " + 
                rs.getString(3) + " - CATEGORIA: " + rs.getString(4) + " - PRECIO/DIA: " + rs.getInt(5));
            }
        } finally{
            if (con != null) con.close ();
        }*/
        
        
    }
    
    public static String selectVehiculos(){
        return "select * from vehiculos";
    }
    
}
