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
public class Interfaz_Vehiculos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Interfaz_Vehiculos
     */

    public Interfaz_Vehiculos() {
        initComponents();
        
        jComboBox_Marca.addItem("Audi");
        jComboBox_Marca.addItem("Nissan");
        jComboBox_Marca.addItem("Fiat");
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Matricula = new javax.swing.JLabel();
        jTextField_Matricula = new javax.swing.JTextField();
        jLabel_Marca = new javax.swing.JLabel();
        jComboBox_Marca = new javax.swing.JComboBox<>();
        jLabel_Modelo = new javax.swing.JLabel();
        jTextField_Modelo = new javax.swing.JTextField();
        jLabel_Clase = new javax.swing.JLabel();
        jComboBox_Clase = new javax.swing.JComboBox<>();
        jLabel_Precio = new javax.swing.JLabel();
        jTextField_Precio = new javax.swing.JTextField();
        jButton_Enviar = new javax.swing.JButton();
        jButton_Limpiar = new javax.swing.JButton();
        jButton_Salir = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 204));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro Vehículos");

        jLabel_Matricula.setText("Matrícula");

        jLabel_Marca.setText("Marca");

        jComboBox_Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_MarcaActionPerformed(evt);
            }
        });

        jLabel_Modelo.setText("Modelo");

        jLabel_Clase.setText("Clase");

        jLabel_Precio.setText("Precio");

        jButton_Enviar.setText("Enviar Formulario");
        jButton_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EnviarActionPerformed(evt);
            }
        });

        jButton_Limpiar.setText("Limpiar");
        jButton_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LimpiarActionPerformed(evt);
            }
        });

        jButton_Salir.setText("Salir");
        jButton_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(407, Short.MAX_VALUE)
                .addComponent(jButton_Enviar)
                .addGap(18, 18, 18)
                .addComponent(jButton_Limpiar)
                .addGap(18, 18, 18)
                .addComponent(jButton_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_Clase, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_Clase, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(211, 211, 211)
                        .addComponent(jLabel_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Clase, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Clase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Salir)
                    .addComponent(jButton_Enviar)
                    .addComponent(jButton_Limpiar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_MarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_MarcaActionPerformed

    private void jButton_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EnviarActionPerformed
        // Recojo datos del botón de enviar formulario
        String mat, mar, mod, strClase;

        mat = jTextField_Matricula.getText();
        mod = jTextField_Modelo.getText();
        
        // Conversión de los ComboBox a toString
        mar = jComboBox_Marca.getSelectedItem().toString();
        strClase = jComboBox_Clase.getSelectedItem().toString();
        // Char de Clase
        char cClase = strClase.charAt(0);

        // Conversión del getText a double
        double precio = Double.parseDouble(jTextField_Precio.getText());

    }//GEN-LAST:event_jButton_EnviarActionPerformed

    private void jButton_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton_LimpiarActionPerformed

    private void jButton_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_SalirActionPerformed
public void limpiar() {
        jTextField_Matricula.setText("");
        jComboBox_Marca.removeAllItems();
        jComboBox_Clase.removeAllItems();
        jTextField_Modelo.setText("");
        jTextField_Precio.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Enviar;
    private javax.swing.JButton jButton_Limpiar;
    private javax.swing.JButton jButton_Salir;
    private javax.swing.JComboBox<String> jComboBox_Clase;
    private javax.swing.JComboBox<String> jComboBox_Marca;
    private javax.swing.JLabel jLabel_Clase;
    private javax.swing.JLabel jLabel_Marca;
    private javax.swing.JLabel jLabel_Matricula;
    private javax.swing.JLabel jLabel_Modelo;
    private javax.swing.JLabel jLabel_Precio;
    private javax.swing.JTextField jTextField_Matricula;
    private javax.swing.JTextField jTextField_Modelo;
    private javax.swing.JTextField jTextField_Precio;
    // End of variables declaration//GEN-END:variables
}
