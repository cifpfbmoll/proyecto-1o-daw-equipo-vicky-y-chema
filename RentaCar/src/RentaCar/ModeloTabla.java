/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/**
 * Esta clase es el modelo que se utiliza para construir todas las JTable de la
 * aplicación.
 *
 * @author victoriapenas
 * @version 1.0
 * @since 2020-05-27
 */
public class ModeloTabla extends AbstractTableModel {

    private ResultSet rsRegistros;
    private ResultSetMetaData rsmd;

    /**
     * Contructor que recibe el cursor con el que rellenará la JTable
     *
     * @param rs
     */
    public ModeloTabla(ResultSet rs) {
        rsRegistros = rs;
        try {
            rsmd = rs.getMetaData();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método para obtener el número total de filas. Movemos el cursor al final
     * y de esa forma obtenemos el total de filas que hay
     *
     * @return devolvemos la posición de la ultima fila
     */
    @Override
    public int getRowCount() {
        try {
            rsRegistros.last();
            return rsRegistros.getRow();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    /**
     * Método para obtener el número total de columnas
     *
     * @return devuelve el número total de columnas obtenidas
     */
    @Override
    public int getColumnCount() {
        try {
            return rsmd.getColumnCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    /**
     * Método mediante el cual el cursor rellena la tabla con todos los datos
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rsRegistros.absolute(rowIndex + 1);
            return rsRegistros.getObject(columnIndex + 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Método para obtener el nombre de las columnas de la base de datos y
     * seteralo en la JTable
     *
     * @param c indice
     * @return
     */
    @Override
    public String getColumnName(int c) {
        try {
            return rsmd.getColumnName(c + 1);
        } catch (SQLException ex) {
            return null;
        }
    }

}
