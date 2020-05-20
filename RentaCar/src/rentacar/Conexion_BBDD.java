/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author victoriapenas & josemariahernandez
 * @version 1.0
 * @since 2020-19-05
 */
public class Conexion_BBDD {

    // URL de conexión a la RaspberryPi
    private final String URL = "jdbc:postgresql://81.203.19.183:5432/rentacar";
    Connection con = null;

    public Conexion_BBDD() {
        try {
            // Driver de la BBDD
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(URL, "Admin", "Admin123");
            if (con != null) {
                System.out.println("Conexión realizada con éxito.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
     *
     * @return
     */
    public Connection conectado() {
        return con;
    }
}
