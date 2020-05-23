/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.Consultas_BBDD.insertarCaravana;
import static RentaCar.Consultas_BBDD.insertarVehiculo;
import static RentaCar.Consultas_BBDD.obtenerConexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JLabel;

/**
 * @version 1.0
 * @since 2020-05-23
 * @author victoriapenas
 */
public class Caravana extends Vehiculo{
    /**
     * Atributos
     */
    private Integer potenciaMotor;
    private boolean wc;

    /**
     * Constructor vacio
     */
    public Caravana() {
        super();
    }

    /**
     * Constructor con parámetros
     * @param potenciaMotor
     * @param wc baño
     * @param matricula
     * @param marca
     * @param modelo
     * @param precioDia
     * @param clase
     */
    public Caravana(Integer potenciaMotor, boolean wc, String matricula, String marca, String modelo, double precioDia, char clase) {
        super(matricula, marca, modelo, precioDia, clase);
        this.setPotenciaMotor(potenciaMotor);
        this.setWc(wc);
    }

    /**
     * Constructor copia
     * @param c1 objeto de tipo Caravana
     * @param v1 objeto de tipo Vehiculo
     */
    public Caravana(Caravana c1, Vehiculo v1) {
        super(v1);
        this.setPotenciaMotor(c1.getPotenciaMotor());
        this.setWc(c1.isWc());
    }

    public Integer getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(Integer potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public boolean isWc() {
        return wc;
    }

    public void setWc(boolean wc) {
        this.wc = wc;
    }

    @Override
    public boolean revisarDatosVehiculo() {
        boolean datosVehiculo = super.revisarDatosVehiculo();
        if (!datosVehiculo || this.getPotenciaMotor() == null){
            return false;
        }
        return true;
    }
    
    @Override
    public void registrarVehiculo(JLabel resultado) throws SQLException {
        PreparedStatement pst = null;
        Connection con = null;
        String queryVehiculos = null;
        String queryCaravana = null;
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
                
                //INSERT tabla especificaciones moto
                queryCaravana = insertarCaravana();
                pst = con.prepareStatement(queryCaravana);
                pst.setString(1, this.getMatricula());
                pst.setInt(2, this.getPotenciaMotor());
                pst.setBoolean(3, this.isWc());
                pst.executeUpdate();
                con.commit();
            }
        }catch (Exception ex){
            con.rollback();
        }finally {
            con.setAutoCommit(true);
            con.close();
            pst.close();
        }
    }
    
}
