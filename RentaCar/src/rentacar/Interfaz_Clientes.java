/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar;

import javax.swing.JOptionPane;

/**
 * @author victoriapenas & josemariahernandez
 * @version 1.0
 * @since 2020-18-05
 */
public class Interfaz_Clientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form Interfaz_Clientes
     */
    ComboBox cbx = new ComboBox();
    /**
     * 
     */
    public Interfaz_Clientes() {
        initComponents();
        limpiar();
        limpiar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_clienteNIF = new javax.swing.JLabel();
        jTextField_clienteNIF = new javax.swing.JTextField();
        jLabel_nombre = new javax.swing.JLabel();
        jTextField_nombre = new javax.swing.JTextField();
        jLabel_apellido1 = new javax.swing.JLabel();
        jTextField_apellido1 = new javax.swing.JTextField();
        jLabel_apellido2 = new javax.swing.JLabel();
        jTextField_apellido2 = new javax.swing.JTextField();
        jLabel_telefono = new javax.swing.JLabel();
        jTextField_telefono = new javax.swing.JTextField();
        jLabel_email = new javax.swing.JLabel();
        jTextField_email = new javax.swing.JTextField();
        jButton_Enviar = new javax.swing.JButton();
        jButton_Salir = new javax.swing.JButton();
        jLabel_password = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel_codUser = new javax.swing.JLabel();
        jTextField_codUser = new javax.swing.JTextField();
        jButton_Limpiar = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 204));
        setIconifiable(true);
        setResizable(true);
        setTitle("Registro de Clientes");

        jLabel_clienteNIF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_clienteNIF.setText("Doc. NIF");

        jLabel_nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_nombre.setText("Nombre");

        jLabel_apellido1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_apellido1.setText("1º Apellido");

        jLabel_apellido2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_apellido2.setText("2º Apellido");

        jTextField_apellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_apellido2ActionPerformed(evt);
            }
        });

        jLabel_telefono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_telefono.setText("Teléfono");

        jTextField_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_telefonoActionPerformed(evt);
            }
        });

        jLabel_email.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_email.setText("E-mail");

        jButton_Enviar.setText("Enviar Formulario");
        jButton_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EnviarActionPerformed(evt);
            }
        });

        jButton_Salir.setText("Salir");
        jButton_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalirActionPerformed(evt);
            }
        });

        jLabel_password.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_password.setText("Contraseña");

        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });

        jLabel_codUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_codUser.setText("Código Cliente");

        jTextField_codUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_codUserActionPerformed(evt);
            }
        });

        jButton_Limpiar.setText("Limpiar");
        jButton_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_Enviar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Limpiar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_apellido1)
                                .addGap(45, 45, 45)
                                .addComponent(jTextField_apellido1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_clienteNIF)
                                    .addComponent(jLabel_telefono)
                                    .addComponent(jLabel_codUser))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_telefono)
                                            .addComponent(jTextField_codUser)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                        .addComponent(jTextField_clienteNIF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_nombre)
                                    .addComponent(jLabel_apellido2))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_password)
                                    .addComponent(jLabel_email))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_email)
                                    .addComponent(jPasswordField))))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_apellido1)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_telefono)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_nombre)
                            .addComponent(jTextField_clienteNIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_clienteNIF))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_apellido2)
                            .addComponent(jTextField_apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_email))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_codUser)
                    .addComponent(jTextField_codUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_password)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Salir)
                    .addComponent(jButton_Enviar)
                    .addComponent(jButton_Limpiar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   // Método para limpiar los jTextField

    public void limpiar() {
        jTextField_clienteNIF.setText("");
        jTextField_nombre.setText("");
        jTextField_apellido1.setText("");
        jTextField_apellido2.setText("");
        jTextField_telefono.setText("");
        jTextField_email.setText("");

    }
    /**
     * Esto sirve para ocultar la ventana sin necesidad
     * de cerrar el programa entero.
     * @param evt 
     */
    private void jButton_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_SalirActionPerformed

    private void jButton_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EnviarActionPerformed
        // Recojo datos del botón de enviar formulario
        String nif, nom, ape1, ape2, tel, mail, pass, codUser;

        // Datos recogidos del formulario
        nif = jTextField_clienteNIF.getText();
        nom = jTextField_nombre.getText();
        ape1 = jTextField_apellido1.getText();
        ape2 = jTextField_apellido2.getText();
        tel = jTextField_telefono.getText();
        mail = jTextField_email.getText();
        codUser = jTextField_codUser.getText();

        // Stringify un char extraído del passwordfield
        String passText = new String(jPasswordField.getPassword());
        pass = passText;

        // Rol fijado manualmente
        int rol = 1;

        // Control de clientes y mensajes informativos
        Control_Clientes control = new Control_Clientes(nif, nom, ape1, ape2, tel, mail, rol, pass, codUser);
        if (!nif.isEmpty() && !nom.isEmpty() && !ape1.isEmpty() && !ape2.isEmpty() && !tel.isEmpty() && !mail.isEmpty()
                && !pass.isEmpty() && codUser.isEmpty()) {
            if (control.registrarDatosCliente("clientes") && control.registrarDatosUsuario("usuarios")) {
                JOptionPane.showMessageDialog(null, "Cliente registrado con éxito.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                limpiar();

            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el cliente");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hay campos obligatorios");
        }
    }//GEN-LAST:event_jButton_EnviarActionPerformed

    private void jTextField_apellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_apellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_apellido2ActionPerformed

    private void jTextField_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_telefonoActionPerformed

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

    private void jTextField_codUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_codUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_codUserActionPerformed

    private void jButton_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton_LimpiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Enviar;
    private javax.swing.JButton jButton_Limpiar;
    private javax.swing.JButton jButton_Salir;
    private javax.swing.JLabel jLabel_apellido1;
    private javax.swing.JLabel jLabel_apellido2;
    private javax.swing.JLabel jLabel_clienteNIF;
    private javax.swing.JLabel jLabel_codUser;
    private javax.swing.JLabel jLabel_email;
    private javax.swing.JLabel jLabel_nombre;
    private javax.swing.JLabel jLabel_password;
    private javax.swing.JLabel jLabel_telefono;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextField_apellido1;
    private javax.swing.JTextField jTextField_apellido2;
    private javax.swing.JTextField jTextField_clienteNIF;
    private javax.swing.JTextField jTextField_codUser;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_nombre;
    private javax.swing.JTextField jTextField_telefono;
    // End of variables declaration//GEN-END:variables
}
