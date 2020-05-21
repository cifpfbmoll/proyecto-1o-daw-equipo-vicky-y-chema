/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Interfaz con métodos para recuperar todas las consultas que
 * se lanzan a BBDD en la aplicación
 * 
 * @author victoriapenas & josemariahernandez
 * @version 1.0
 * @since 2020-19-05
 */

public interface Consultas_BBDD {
    
    /**
     * Método para recuperar la conexión a la BBDD
     * @return devuelve la conexión a la BBDD
     * @throws SQLException 
     */
    public static Connection obtenerConexion() throws SQLException {
        String url = "jdbc:postgresql://81.203.19.183:5432/rentacar";
        return DriverManager.getConnection (url, "Admin", "Admin123");
    }
    
    /**
     * método para recuperar todos los vehiculos 
     * @return devuelve la query para recuperar los vehiculos
     */
    public static String selectVehiculos(){
        return "select * from vehiculos";
    }
    
    /**
     * Query para insertar nuevos clientes a la BBDD
     * @return devuelve el insert
     */
    public static String insertClientes(){
        return "insert into clientes (nif,nombre,apellido1,apellido2,telefono,email)"
                      + " values (?, ?, ?, ?, ?, ?)";
    }
    
    /**
     * Query para insertar nuevos usuarios a la BBDD
     * @return devuelve el insert 
     */
    public static String insertUsuarios(){
        return "insert into usuarios (usuario,password,clientenif,rolid)" + 
                "values (?, crypt(?, gen_salt('bf')), ?, ?)";
    }
    
}
