/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.Consultas_BBDD.obtenerConexion;
import static RentaCar.Consultas_BBDD.selectVehiculos;
import java.awt.Color;
import java.sql.Connection;
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
                ventana.getVehiculosEncontrados().append("MATRICULA: " + rs.getString(1) + " - MARCA: " + rs.getString(2) + 
                " - MODELO: " + rs.getString(3) + " - CATEGORIA: " + rs.getString(4) + " - PRECIO: " + rs.getInt(5)
                + " €/DIA.");
                ventana.getVehiculosEncontrados().append("\n");
                count++;
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
}
