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
public class ComboBox {

    private TODOSentencias sen;

    public ComboBox() {
        sen = new TODOSentencias();
    }

    public Object[] combox(String tabla, String campo) {
        return sen.rellenarComboBox(tabla, campo, "select " + campo + " from " + tabla + ";");
    }

    public Object[][] ingresa_cod(String campo, String id_campo, String tabla, String col) {
        String[] columnas = {id_campo};
        Object[][] result = sen.tablas(columnas, tabla, "select * from " + tabla + " where " + col + "='" + campo + "';");
        return result;
    }

}
