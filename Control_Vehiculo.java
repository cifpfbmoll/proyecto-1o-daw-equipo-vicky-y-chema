/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

/**
 * @author victoriapenas & josemariahernandez
 * @version 1.0
 * @since 2020-19-05
 */
public class Control_Vehiculo extends Vehiculo {

    private TODOSentencias sent;

    public Control_Vehiculo() {
        sent = new TODOSentencias();
    }

    public boolean registrarVehiculo(String matricula, String marca, String modelo, char clase, Double precioDia) {
        
        // Conversiones antes de insertar en BBDD
        String strClase = String.valueOf(clase);
        String strPrecioDia = String.valueOf(precioDia);
        
        String datos[] = {matricula, marca, modelo, strClase, strPrecioDia};
        return sent.insertSQL(datos, "insert into vehiculo(matricula, marca, modelo, clase, precioDia) values(?,?,?,?,?)");

    }

}
