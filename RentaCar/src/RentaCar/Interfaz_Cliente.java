/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.Interfaz_Main.centrarFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static RentaCar.Interfaz_ListarVehiculos.listarVehiculos;
import javax.swing.ImageIcon;

/**
 * @author victoriapenas & josemariahernandez
 * @version 1.0
 * @since 2020-18-05
 */
public class Interfaz_Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz_Cliente
     */
    public Interfaz_Cliente() {
        initComponents();
        ImageIcon img = new ImageIcon("src/image/customer_64px.png");
        setIconImage(img.getImage());
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jFrame4 = new javax.swing.JFrame();
        jFrame5 = new javax.swing.JFrame();
        jDesktopPane = new javax.swing.JDesktopPane(){
            @Override
            public void paintComponent(Graphics g) {
                Image imagen = null;
                super.paintComponents(g);

                try {
                    imagen = ImageIO.read(new File("src/image/bg_customer.jpg"));
                } catch (IOException ex) {
                    System.out.println("La imagen no se encuentra");
                }

                g.drawImage(imagen, 0, 0, null);
            }
        };
        jLabel_Bienvenida = new javax.swing.JLabel();
        jButton_listarVehiculos = new javax.swing.JButton();
        jButton_realizarReserva = new javax.swing.JButton();
        jButton_listarReservas = new javax.swing.JButton();
        jButton_cerrarSesion = new javax.swing.JButton();
        jButton_cancelarReservas = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame4Layout = new javax.swing.GroupLayout(jFrame4.getContentPane());
        jFrame4.getContentPane().setLayout(jFrame4Layout);
        jFrame4Layout.setHorizontalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame4Layout.setVerticalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame5Layout = new javax.swing.GroupLayout(jFrame5.getContentPane());
        jFrame5.getContentPane().setLayout(jFrame5Layout);
        jFrame5Layout.setHorizontalGroup(
            jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame5Layout.setVerticalGroup(
            jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel Cliente");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jDesktopPane.setBackground(new java.awt.Color(204, 204, 255));
        jDesktopPane.setForeground(new java.awt.Color(0, 0, 0));
        jDesktopPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jDesktopPane.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        jDesktopPane.setName(""); // NOI18N

        jLabel_Bienvenida.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel_Bienvenida.setForeground(new java.awt.Color(254, 255, 249));
        jLabel_Bienvenida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sale_64px.png"))); // NOI18N
        jLabel_Bienvenida.setText("         BIENVENIDO AL ENTORNO CLIENTE");

        jButton_listarVehiculos.setBackground(new java.awt.Color(55, 59, 62));
        jButton_listarVehiculos.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jButton_listarVehiculos.setForeground(new java.awt.Color(254, 255, 249));
        jButton_listarVehiculos.setText("LISTAR VEHÍCULOS");
        jButton_listarVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_listarVehiculosActionPerformed(evt);
            }
        });

        jButton_realizarReserva.setBackground(new java.awt.Color(55, 59, 62));
        jButton_realizarReserva.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jButton_realizarReserva.setForeground(new java.awt.Color(254, 255, 249));
        jButton_realizarReserva.setText("REALIZAR RESERVA");
        jButton_realizarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_realizarReservaActionPerformed(evt);
            }
        });

        jButton_listarReservas.setBackground(new java.awt.Color(55, 59, 62));
        jButton_listarReservas.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jButton_listarReservas.setForeground(new java.awt.Color(254, 255, 249));
        jButton_listarReservas.setText("LISTAR RESERVAS (SOON)");
        jButton_listarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_listarReservasActionPerformed(evt);
            }
        });

        jButton_cerrarSesion.setBackground(new java.awt.Color(45, 45, 45));
        jButton_cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sign_out_32px.png"))); // NOI18N
        jButton_cerrarSesion.setBorderPainted(false);
        jButton_cerrarSesion.setContentAreaFilled(false);
        jButton_cerrarSesion.setFocusCycleRoot(true);
        jButton_cerrarSesion.setFocusPainted(false);
        jButton_cerrarSesion.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton_cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cerrarSesionActionPerformed(evt);
            }
        });

        jButton_cancelarReservas.setBackground(new java.awt.Color(55, 59, 62));
        jButton_cancelarReservas.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jButton_cancelarReservas.setForeground(new java.awt.Color(254, 255, 249));
        jButton_cancelarReservas.setText("CANCELAR RESERVAS (SOON)");
        jButton_cancelarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarReservasActionPerformed(evt);
            }
        });

        jDesktopPane.setLayer(jLabel_Bienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton_listarVehiculos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton_realizarReserva, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton_listarReservas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton_cerrarSesion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton_cancelarReservas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_cancelarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_listarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_realizarReserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_listarVehiculos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jDesktopPaneLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel_Bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                        .addComponent(jButton_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_Bienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addComponent(jButton_listarVehiculos)
                .addGap(30, 30, 30)
                .addComponent(jButton_realizarReserva)
                .addGap(30, 30, 30)
                .addComponent(jButton_listarReservas)
                .addGap(28, 28, 28)
                .addComponent(jButton_cancelarReservas)
                .addContainerGap(199, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(1066, 629));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_listarVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_listarVehiculosActionPerformed
        Interfaz_ListarVehiculos lisVehi = new Interfaz_ListarVehiculos();
        centrarFrame(jDesktopPane, lisVehi);
        jDesktopPane.add(lisVehi);
        lisVehi.setVisible(rootPaneCheckingEnabled);
        listarVehiculos(lisVehi);
    }//GEN-LAST:event_jButton_listarVehiculosActionPerformed

    private void jButton_listarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_listarReservasActionPerformed
        /**
         * TODO pendiente de listar reservas
         */

    }//GEN-LAST:event_jButton_listarReservasActionPerformed

    private void jButton_realizarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_realizarReservaActionPerformed
        Interfaz_Reservas cRes = new Interfaz_Reservas();
        centrarFrame(jDesktopPane, cRes);
        jDesktopPane.add(cRes);
        cRes.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jButton_realizarReservaActionPerformed

    private void jButton_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cerrarSesionActionPerformed
        Interfaz_Main main = new Interfaz_Main();
        main.setVisible(rootPaneCheckingEnabled);
        this.dispose();
    }//GEN-LAST:event_jButton_cerrarSesionActionPerformed

    private void jButton_cancelarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarReservasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_cancelarReservasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cancelarReservas;
    private javax.swing.JButton jButton_cerrarSesion;
    private javax.swing.JButton jButton_listarReservas;
    private javax.swing.JButton jButton_listarVehiculos;
    private javax.swing.JButton jButton_realizarReserva;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JFrame jFrame4;
    private javax.swing.JFrame jFrame5;
    private javax.swing.JLabel jLabel_Bienvenida;
    // End of variables declaration//GEN-END:variables
}
