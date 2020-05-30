/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.Automovil.selectAutomoviles;
import static RentaCar.Consultas_BBDD.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victoriapenas
 */
public class Coche extends Vehiculo {

    /**
     * Atributos
     */
    private Integer numeroPuertas;
    private Integer potenciaMotor;

    /**
     * Contructor
     */
    public Coche() {
        super();
    }

    /**
     * Constructor con parámetros
     *
     * @param numeroPuertas
     * @param potenciaMotor
     * @param matricula
     * @param marca
     * @param modelo
     * @param precioDia
     * @param clase
     */
    public Coche(Integer numeroPuertas, Integer potenciaMotor, String matricula, String marca, String modelo, double precioDia, char clase, boolean disponible) {
        super(matricula, marca, modelo, precioDia, clase);
        this.setNumeroPuertas(numeroPuertas);
        this.setPotenciaMotor(potenciaMotor);
    }

    /**
     * Contructor copia
     *
     * @param c1 objeto de tipo Coche
     * @param v1 objeto de tipo Vehiculo
     */
    public Coche(Coche c1, Vehiculo v1) {
        super(v1);
        this.setNumeroPuertas(c1.getNumeroPuertas());
        this.setPotenciaMotor(c1.potenciaMotor);
    }

    public Integer getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(Integer numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public Integer getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(Integer potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    @Override
    public boolean revisarDatosVehiculo() {
        boolean datosVehiculo = super.revisarDatosVehiculo();
        if (!datosVehiculo || this.getNumeroPuertas() == null || this.getPotenciaMotor() == null) {
            return false;
        }
        return true;
    }

    @Override
    public void registrarVehiculo(JLabel resultado) throws SQLException {
        PreparedStatement pst = null;
        Connection con = null;
        String queryVehiculos = null;
        String queryCoche = null;
        try {
            con = obtenerConexion();
            if (!this.revisarDatosVehiculo()) {
                resultado.setForeground(Color.RED);
                resultado.setText("Faltan datos por cumplimentar.");
            } else {
                con.setAutoCommit(false);
                //INSERT tabla vehiculos
                queryVehiculos = insertarVehiculo(this.getMatricula(), this.getMarca(),
                        this.getModelo(), this.getClase(), this.getPrecioDia());
                pst = con.prepareStatement(queryVehiculos);
                pst.executeUpdate();

                //INSERT tabla especificaciones coche
                queryCoche = insertarCoche();
                pst = con.prepareStatement(queryCoche);
                pst.setString(1, this.getMatricula());
                pst.setInt(2, this.getNumeroPuertas());
                pst.setInt(3, this.getPotenciaMotor());
                pst.executeUpdate();

                con.commit();
            }
        } catch (Exception ex) {
            con.rollback();
        } finally {
            con.setAutoCommit(true);
            con.close();
            pst.close();
        }
    }

    /**
     * //*************PENDIENTE*************
     */
    public static void mostrarVehiculosRes() {
        ResultSet rs;
        Connection con;
        PreparedStatement pst;
        
        ArrayList<Moto> listaMotos = new ArrayList<>();
        ArrayList<Coche> listaCoches = new ArrayList<>();
        ArrayList<Caravana> listaCaravana = new ArrayList<>();
        /*try {
            con = obtenerConexion();
            pst = con.prepareStatement(selectAutomoviles(), ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();
            Vehiculo vehi;
            while (rs.next()) {
                vehi = new Vehiculo(rs.getString("matricula"), rs.getString("marca"),
                        rs.getString("modelo"), rs.getDouble("precioDia"), rs.getString("clase"));
                vehiLista.add(vehi);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        ArrayList<Vehiculo> lista = vehiLista();
        DefaultTableModel model = (DefaultTableModel) jTable_Vehiculos.getModel();
        Object[] row = new Object[5];
        for (int i = 0;
                i < lista.size();
                i++) {
            row[0] = lista.get(i).getMatricula();
            row[1] = lista.get(i).getMarca();
            row[2] = lista.get(i).getModelo();
            row[3] = lista.get(i).getPrecioDia();
            row[4] = lista.get(i).getClase();
            model.addRow(row);
        }*/
    }
}