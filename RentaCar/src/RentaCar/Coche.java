/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.Consultas_BBDD.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author victoriapenas y josemariahernandez
 * @since 2020-05-20
 * @version 1.0
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
     * @param numeroPuertas numero de puertas del coche
     * @param potenciaMotor potencia del motor del coche
     * @param matricula matricula del coche
     * @param marca marca del coche
     * @param modelo modelo del coche
     * @param precioDia precio por dia del coche
     * @param clase clase del coche
     */
    public Coche(Integer numeroPuertas, Integer potenciaMotor, String matricula, String marca, String modelo, double precioDia, char clase) {
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
    public void registrarVehiculo() throws SQLException {
        PreparedStatement pst = null;
        Connection con = null;
        String queryVehiculos = null;
        String queryCoche = null;
        try {
            con = obtenerConexion();
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
        } catch (Exception ex) {
            con.rollback();
        } finally {
            con.setAutoCommit(true);
            con.close();
            pst.close();
        }
    }
}
