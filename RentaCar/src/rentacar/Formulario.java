/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

import java.awt.*;
import javax.swing.*;

/**
 * Esta clase la utilizaremos para crear formulario en la aplicación
 * @see http://lineadecodigo.com/java/formulario-basico-con-java-swing/
 * 
 * @author victoriapenas
 * @version 1.0
 * 
 */
public class Formulario extends JFrame{

    public Formulario() {
        super("Formulario Basico");
        setTitle("Formulario de registro");
        getContentPane().setLayout(new FlowLayout());
        JLabel label = new JLabel("Introduce tu nombre:");
        JTextField textfield = new JTextField("nombre",20);
        JButton boton = new JButton("Enviar");
        getContentPane().add(label);
        getContentPane().add(textfield);
        getContentPane().add(boton);
        setSize(400,300);
        setVisible(true);
    }
}
