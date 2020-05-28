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
    
    //---------------QUERIES CLIENTES/USUARIOS---------------------------
    
    /**
     * Query para buscar un cliente por NIF
     * @return devuelve la query
     */
    public static String buscarCliente(){
        return "select * from clientes where nif = ?";
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
    
    /**
     * query para validar contraseñas
     * @return devuelve la query de validación
     */
    public static String comprobarPw(){
        return "SELECT (password = crypt(?, password)) AS pswmatch FROM USUARIOS where usuario = ?";
    }
    
    /**
     * query para validar contraseñas
     * @return devuelve la query de validación
     */
    public static String recuperarUsuario(String user){
        return "SELECT rolid from usuarios where usuario = '" + user + "'";
    }
    
    /**
     * query para recuperar todos los clientes existentes
     * @return query de clientes
     */
    public static String listarClientes(){
        return "select * from clientes";
    }
    
    //---------------------QUERIES VEHICULOS--------------------------------
    
    /**
     * query para recuperar todos los vehiculos 
     * @return devuelve la query para recuperar los vehiculos
     */
    public static String selectVehiculos(){
        return "SELECT *, CASE WHEN EXISTS (SELECT matricula FROM especificaciones_coches c WHERE c.matricula = v.matricula) THEN 'coche'" +
                "WHEN EXISTS (SELECT matricula FROM especificaciones_caravanas c WHERE c.matricula = v.matricula) THEN 'caravana'" +
                "WHEN EXISTS (SELECT matricula FROM especificaciones_motos c WHERE c.matricula = v.matricula) THEN 'moto'" +
                "end as tipo FROM vehiculos v;";
    }
    
    /**
     * query para recuperar las marcas de los vehiculos existentes
     * @return devuelve la query
     */
    public static String listarMarcas(){
        return "select distinct marca from vehiculos";
    }
    
    /**
     * query para recuperar las marcas de las clases existentes
     * @return devuelve la query
     */
    public static String listarClases(){
        return "select distinct nombre from clases_vehiculos";
    }
    
    public static String reuperarPKClase(){
        return "select cod from clases_vehiculos where nombre = ?";
    }
    /**
     * Query para insertar en la tabla vehiculos
     * @param matricula
     * @param marca
     * @param modelo
     * @param clase
     * @param precioDia
     * @return devuelve la query
     */
    public static String insertarVehiculo(String matricula, String marca, String modelo, char clase, Double precioDia){
        return "insert into vehiculos values ('" + matricula + "','" + marca + "','" + 
                modelo + "','" + clase + "'," + precioDia + ")";
    }
    
    /**
     * query para insertar especificaciones de un coche
     * @return devuelve la query
     */
    public static String insertarCoche(){
        return "insert into especificaciones_coches values (?,?,?)";
    }
    
    /**
     * query para insertar especificaciones de una caravana
     * @return devuelve la query
     */
    public static String insertarCaravana(){
        return "insert into especificaciones_caravanas values (?,?,?)";
    }
    
    /**
     * query para insertar especificaciones de una caravana
     * @return devuelve la query
     */
    public static String insertarMoto(){
        return "insert into especificaciones_motos values (?,?)";
    }
    
    /**
     * Método para dar de baja vehiculos
     * @return devuelve la query
     */
    public static String eliminarVehiculo(){
        return "update vehiculos set retirado = true where matricula=?";
    }
    
    /**
     * Método para obtener un solo vehiculo por num de matricula
     * @return devuelve la query
     */
    public static String recuperarVehiculo(){
        return "select * from vehiculos where matricula=? and retirado=false";
    }
    
    /**
     * Método para modificar el precio de un vehiculo
     * @return devuelve la query
     */
    public static String modificarPrecioSQL(){
        return "update vehiculos set preciodia = ? where matricula = ?";
    }
    
    //---------------------QUERIES RESERVAS--------------------------------
    
    public static String cancelarReserva(){
        return "";
    }
}
