/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

/**
 * Excepcion personalizada para mostrar diferentes mensajes de error en la aplicación
 * 
 * @author victoriapenas & josemariahernandez
 * @version 1.0
 * @since 2020-05-31
 */
public class RCException extends Exception{
    private String message;

    /**
     * Constructor vacio
     */
    public RCException() {
    }

    /**
     * Constructor con parámetros
     * @param errorMessage 
     */
    public RCException(String errorMessage) {
        this.setMessage(errorMessage);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
