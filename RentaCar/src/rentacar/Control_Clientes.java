/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

/**
 * @author victoriapenas & josemariahernandez
 * @version 1.0
 * @since 2020-18-05
 */
public class Control_Clientes extends Usuario {

    public Control_Clientes(String nif, String nombre, String ape1, String ape2,
            String tel, String mail, int rol, String pass, String codUsuario) {
       
        super(nif, nombre, ape1, ape2, tel, mail, rol, pass, codUsuario);
        
    }
    /**
     * Método para consultar clientes en la BBDD
     * @return 
     */
    public Object[][] consultarClientes() {
        
        String[] columnas = {"NIF", "nombre", "apellido1", "apellido2", "telefono", "email"};
        Object[][] datos = sql.tablas(columnas, "clientes", "select NIF,nombre,apellido1,apellido2,telefono,email from clientes;");
        return datos;
        
    }
}
