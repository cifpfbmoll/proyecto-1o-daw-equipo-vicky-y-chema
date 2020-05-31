/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.Usuario.comprobarRol;
import static RentaCar.Usuario.comprobarUsuario;
import static RentaCar.Vehiculo.listarVehiculos;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author victoriapenas
 */
public class Interfaz_Main extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz_Main
     */
    public Interfaz_Main() {
        initComponents();
        jPanel_Login.setVisible(false);
        ImageIcon img = new ImageIcon("src/image/home_icon_64px.png");
        setIconImage(img.getImage());
    }

    /*@Override
        public Dimension getPreferredSize() {
            return new Dimension(imagen.getWidth(), imagen.getHeight());
        }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane = new javax.swing.JDesktopPane(){
            @Override
            public void paintComponent(Graphics g){
                Image imagen = null;
                super.paintComponent(g);

                try {
                    imagen = ImageIO.read(new File("src/image/bg_car.jpg"));
                } catch (IOException ex) {
                    System.out.println("La imagen no se encuentra");
                }

                g.drawImage(imagen, 0, 0, null);
            }
        };
        jLabel_Mensaje = new javax.swing.JLabel();
        jLabel_verificacionUsuario = new javax.swing.JLabel();
        jPanel_Login1 = new javax.swing.JPanel();
        jButton_ConsultarVeh = new javax.swing.JButton();
        jButton_Registrarse = new javax.swing.JButton();
        jButton_Acceder = new javax.swing.JButton();
        jPanel_Login = new javax.swing.JPanel();
        jLabel_Usuario = new javax.swing.JLabel();
        jTextField_Usuario = new javax.swing.JTextField();
        jLabel_Contraseña = new javax.swing.JLabel();
        jPasswordField_Contraseña = new javax.swing.JPasswordField();
        jButton_Entrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HOME RENTACAR");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        jDesktopPane.setForeground(new java.awt.Color(255, 255, 255));
        jDesktopPane.setToolTipText("");

        jLabel_Mensaje.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel_Mensaje.setForeground(new java.awt.Color(254, 255, 249));
        jLabel_Mensaje.setText("¡Este es el RentaCar de Vicky y Chema!");

        jLabel_verificacionUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_verificacionUsuario.setForeground(new java.awt.Color(255, 0, 0));

        jPanel_Login1.setOpaque(false);

        jButton_ConsultarVeh.setBackground(new java.awt.Color(55, 59, 62));
        jButton_ConsultarVeh.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jButton_ConsultarVeh.setForeground(new java.awt.Color(254, 255, 249));
        jButton_ConsultarVeh.setText("CONSULTAR VEHICULOS");
        jButton_ConsultarVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConsultarVehActionPerformed(evt);
            }
        });

        jButton_Registrarse.setBackground(new java.awt.Color(55, 59, 62));
        jButton_Registrarse.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jButton_Registrarse.setForeground(new java.awt.Color(254, 255, 249));
        jButton_Registrarse.setText("REGISTRARSE");
        jButton_Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarseActionPerformed(evt);
            }
        });

        jButton_Acceder.setBackground(new java.awt.Color(55, 59, 62));
        jButton_Acceder.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jButton_Acceder.setForeground(new java.awt.Color(254, 255, 249));
        jButton_Acceder.setText("LOGIN");
        jButton_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AccederActionPerformed(evt);
            }
        });

        jPanel_Login.setOpaque(false);

        jLabel_Usuario.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jLabel_Usuario.setForeground(new java.awt.Color(55, 59, 62));
        jLabel_Usuario.setText("USUARIO");

        jTextField_Usuario.setBackground(new java.awt.Color(55, 59, 62));
        jTextField_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_UsuarioActionPerformed(evt);
            }
        });

        jLabel_Contraseña.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jLabel_Contraseña.setForeground(new java.awt.Color(55, 59, 62));
        jLabel_Contraseña.setText("CONTRASEÑA");

        jPasswordField_Contraseña.setBackground(new java.awt.Color(55, 59, 62));
        jPasswordField_Contraseña.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jPasswordField_Contraseña.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField_Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField_ContraseñaActionPerformed(evt);
            }
        });

        jButton_Entrar.setBackground(new java.awt.Color(55, 59, 62));
        jButton_Entrar.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jButton_Entrar.setForeground(new java.awt.Color(254, 255, 249));
        jButton_Entrar.setText("ENTRAR");
        jButton_Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EntrarActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/secure_32px.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user_32px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel_LoginLayout = new javax.swing.GroupLayout(jPanel_Login);
        jPanel_Login.setLayout(jPanel_LoginLayout);
        jPanel_LoginLayout.setHorizontalGroup(
            jPanel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_LoginLayout.createSequentialGroup()
                        .addComponent(jLabel_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_LoginLayout.createSequentialGroup()
                        .addComponent(jLabel_Contraseña)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21))
            .addGroup(jPanel_LoginLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jButton_Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_LoginLayout.setVerticalGroup(
            jPanel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LoginLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField_Usuario)
                        .addComponent(jLabel_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jPasswordField_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_Login1Layout = new javax.swing.GroupLayout(jPanel_Login1);
        jPanel_Login1.setLayout(jPanel_Login1Layout);
        jPanel_Login1Layout.setHorizontalGroup(
            jPanel_Login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Login1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_Login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_ConsultarVeh, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_Login1Layout.createSequentialGroup()
                        .addComponent(jButton_Registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Acceder, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel_Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel_Login1Layout.setVerticalGroup(
            jPanel_Login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Login1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_ConsultarVeh, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel_Login1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Acceder, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jPanel_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jDesktopPane.setLayer(jLabel_Mensaje, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jLabel_verificacionUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jPanel_Login1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel_verificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Login1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 605, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneLayout.createSequentialGroup()
                .addComponent(jPanel_Login1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_verificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(jLabel_Mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AccederActionPerformed
        jPanel_Login.setVisible(true);
    }//GEN-LAST:event_jButton_AccederActionPerformed

    private void jButton_RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarseActionPerformed
        Interfaz_RegistroClientes cli = new Interfaz_RegistroClientes();
        centrarFrame(jDesktopPane, cli);
        jDesktopPane.add(cli);
        cli.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jButton_RegistrarseActionPerformed

    private void jButton_ConsultarVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConsultarVehActionPerformed

        //CHEMA --> si llamo directamente a listarVehiculos() salta una excepcion, para que funcione bien lo tengo que que hacer asi
        JFrame ventana = listarVehiculos();
    }//GEN-LAST:event_jButton_ConsultarVehActionPerformed

    private void jPasswordField_ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField_ContraseñaActionPerformed
    }//GEN-LAST:event_jPasswordField_ContraseñaActionPerformed

    private void jTextField_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_UsuarioActionPerformed
    }//GEN-LAST:event_jTextField_UsuarioActionPerformed

    private void jButton_EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EntrarActionPerformed
        int rol;
        try {
            String passText = new String(jPasswordField_Contraseña.getPassword());
            String pass = passText;
            boolean encontrado = comprobarUsuario(jTextField_Usuario.getText(), pass);
            if (encontrado) {
                rol = comprobarRol(jTextField_Usuario.getText());
                if (rol == 1) {
                    Interfaz_Cliente cliente = new Interfaz_Cliente();
                    cliente.setVisible(rootPaneCheckingEnabled);
                    this.dispose();
                } else if (rol == 2) {
                    Interfaz_Administrador admin = new Interfaz_Administrador();
                    admin.setVisible(rootPaneCheckingEnabled);
                    this.dispose();
                }
            } else {
                jLabel_verificacionUsuario.setText("Credenciales incorrectas."
                        + " Inténtalo de nuevo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_EntrarActionPerformed
    /**
     * Permite iniciar cualquier internal frame centrado
     *
     * @param pane
     * @param frame
     */
    public static void centrarFrame(JDesktopPane pane, JInternalFrame frame) {
        Dimension desktopSize = pane.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Acceder;
    private javax.swing.JButton jButton_ConsultarVeh;
    private javax.swing.JButton jButton_Entrar;
    private javax.swing.JButton jButton_Registrarse;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Contraseña;
    private javax.swing.JLabel jLabel_Mensaje;
    private javax.swing.JLabel jLabel_Usuario;
    private javax.swing.JLabel jLabel_verificacionUsuario;
    private javax.swing.JPanel jPanel_Login;
    private javax.swing.JPanel jPanel_Login1;
    private javax.swing.JPasswordField jPasswordField_Contraseña;
    private javax.swing.JTextField jTextField_Usuario;
    // End of variables declaration//GEN-END:variables
}
