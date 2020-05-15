/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 * <h1> RENT A CAR </h1>
 * Aplicación para realizar alquiler de vechiculos.
 * 
 * @author victoriapenas & josemariahernandez
 * @version 1.0
 * @since 2020-06-05
 */
public class RentaCar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Formulario form = new Formulario();
        form.formularioRegistro();
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public static Connection obtenerConexion() throws SQLException {
        String url = "jdbc:postgresql://81.203.19.183:5432/rentacar";
        return DriverManager.getConnection (url, "Admin", "Admin123");
    }
    
}
