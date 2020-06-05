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
 * @version 1.0
 * @since 2020-05-23
 * @author victoriapenas
 */
public class Moto extends Vehiculo {

    /**
     * Atributos
     */
    private Integer cilindrada;

    /**
     * Constructor vacío
     */
    public Moto() {
        super();
    }

    /**
     * Construtor con parámetros
     *
     * @param cilindrada cilindrada de la moto
     * @param matricula matricula de la moto
     * @param marca marca de la moto
     * @param modelo modelo de la moto
     * @param precioDia precio del alquiler diario de la moto
     * @param clase clase a la que pertenece la moto
     */
    public Moto(Integer cilindrada, String matricula, String marca, String modelo, double precioDia, char clase) {
        super(matricula, marca, modelo, precioDia, clase);
        this.cilindrada = cilindrada;
    }

    /**
     * Constructor copia
     *
     * @param m1 recibe un objeto de tipo Moto
     * @param v1 recibe un objeto de tipo Vehiculo
     */
    public Moto(Moto m1, Vehiculo v1) {
        super(v1);
        this.setCilindrada(m1.getCilindrada());
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    /**
     * Método para insertar motos en la BBDD
     * @throws SQLException este método lanza una SQLException que se debe controlar
     */
    @Override
    public void registrarVehiculo() throws SQLException {
        PreparedStatement pst = null;
        Connection con = null;
        String queryVehiculos = null;
        String queryMoto = null;
        try {
            con = obtenerConexion();
            con.setAutoCommit(false);
            //INSERT tabla vehiculos
            queryVehiculos = insertarVehiculo(this.getMatricula(), this.getMarca(),
                    this.getModelo(), this.getClase(), this.getPrecioDia());
            pst = con.prepareStatement(queryVehiculos);
            pst.executeUpdate();
            //INSERT tabla especificaciones moto
            queryMoto = insertarMoto();
            pst = con.prepareStatement(queryMoto);
            pst.setString(1, this.getMatricula());
            pst.setInt(2, this.getCilindrada());
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
