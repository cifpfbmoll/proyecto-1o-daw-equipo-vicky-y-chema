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
 * Esta clase es el modelo que se utiliza para construir todas las JTable de la aplicación.
 * 
 * @author victoriapenas
 * @version 1.0
 * @since 2020-05-27
 */
public class ModeloTabla extends AbstractTableModel{

    private ResultSet rsRegistros;
    private ResultSetMetaData rsmd;

    public ModeloTabla(ResultSet rs) {
        rsRegistros = rs;
        try {
            rsmd = rs.getMetaData();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int getRowCount() {
        try {
            rsRegistros.last(); //movemos el cursor al final y de esa forma obtenemos el total de filas que hay
            return rsRegistros.getRow(); //devolvemos la posición de la ultima fila
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        try {
            return rsmd.getColumnCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rsRegistros.absolute(rowIndex+1);
            return rsRegistros.getObject(columnIndex+1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String getColumnName(int c){
        try {
            return rsmd.getColumnName(c+1);
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
