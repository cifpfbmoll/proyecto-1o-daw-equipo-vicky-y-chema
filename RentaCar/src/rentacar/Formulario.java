/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

import java.awt.*;
import static java.awt.Toolkit.getDefaultToolkit;
import javax.swing.*;

/**
 * 
 * @author victoriapenas
 * @version 1.0
 * @since 2020-05-20
 * 
 * Esta clase la utilizaremos para crear formulario en la aplicación
 * 
 */
public class Formulario extends JFrame{

    /**
     * <h1>Constructor vacío.</h1>
     * Formularios centrados dependiendo de la resolución de la pantalla.
     * 
     * Se utilizan las siguientes clases:
     * @see java.awt.Toolkit.getDefaultToolkit
     * @see java.awt.Dimension
     */
    public Formulario() {
        super();
        //obtenemos la resolución de la pantalla que ejecuta el programa
        Toolkit miPantalla = getDefaultToolkit();   
        Dimension medidaPantalla = miPantalla.getScreenSize();   
        int alturaPantalla = medidaPantalla.height;
        int anchoPantalla = medidaPantalla.width;
        /*asignamos un tamaño a la ventana que se corresponde a la mitad del
        tamaño del monitor que ejecuta el programa*/
        setSize(anchoPantalla/2,alturaPantalla/2);
        
        //Centramos la ventana en el monitor.
        setLocation(anchoPantalla/4,alturaPantalla/4);
        
        //Asignamos logo
        Image icono = miPantalla.getImage("rentacar_logo_400.jpeg");
        setIconImage(icono);
    }
    
    /**
     * Éste método se utilizará para el registro de usuarios nuevos en la aplicación.
     * 
     * @see rentacar.Lamina
     * 
     */
    public void formularioRegistro(){
        this.setTitle("Formulario de Registro");
        Lamina form = new Lamina();
        form.laminaRegistro();
        this.add(form);
        this.setVisible(true);
    }
}
