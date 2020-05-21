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

public class Consultas_BBDD {
    
    public static Connection obtenerConexion() throws SQLException {
        String url = "jdbc:postgresql://81.203.19.183:5432/rentacar";
        return DriverManager.getConnection (url, "Admin", "Admin123");
    }
    
    /**
     * método para recuperar todos los vehiculos 
     * @return query
     */
    public static String selectVehiculos(){
        return "select * from vehiculos";
    }
    
}
