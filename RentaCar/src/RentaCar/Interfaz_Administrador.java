/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RentaCar;

import static RentaCar.General.centrarFrame;
import static RentaCar.Reserva.*;
import static RentaCar.Usuario.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static RentaCar.Vehiculo.*;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author victoriapenas y josemariahernandez
 * @version 1.0
 * @since 2020-18-05
 */
public class Interfaz_Administrador extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz_Administrador
     */
    public Interfaz_Administrador() {
        initComponents();
        ImageIcon img = new ImageIcon("src/image/administrator_64px.png");
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
                    imagen = ImageIO.read(new File("src/image/bg_admin.jpg"));
                } catch (IOException ex) {
                    System.out.println("La imagen no se encuentra");
                }

                g.drawImage(imagen, 0, 0, null);
            }
        };
        jLabel_Bienvenida = new javax.swing.JLabel();
        jButton_registrarClientes = new javax.swing.JButton();
        jButton_listarClientes = new javax.swing.JButton();
        jButton_registrarVehiculo = new javax.swing.JButton();
        jButton_listarVehiculos = new javax.swing.JButton();
        jButton_realizarReserva = new javax.swing.JButton();
        jButton_listarReservas = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton_retirarVehiculo = new javax.swing.JButton();
        jButton_modificarPrecio = new javax.swing.JButton();
        jButton_cancelrReservas = new javax.swing.JButton();

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
        setTitle("Panel Administrativo");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        jDesktopPane.setBackground(new java.awt.Color(204, 204, 255));
        jDesktopPane.setForeground(new java.awt.Color(0, 0, 0));
        jDesktopPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jDesktopPane.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        jDesktopPane.setName(""); // NOI18N

        jLabel_Bienvenida.setFont(new java.awt.Font("Heiti TC", 1, 22)); // NOI18N
        jLabel_Bienvenida.setForeground(new java.awt.Color(254, 255, 249));
        jLabel_Bienvenida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/administrative_tools_64px.png"))); // NOI18N
        jLabel_Bienvenida.setText("   BIENVENIDO AL ENTORNO ADMINISTRADOR");

        jButton_registrarClientes.setBackground(new java.awt.Color(55, 59, 62));
        jButton_registrarClientes.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jButton_registrarClientes.setForeground(new java.awt.Color(254, 255, 249));
        jButton_registrarClientes.setText("REGISTRAR CLIENTE");
        jButton_registrarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarClientesActionPerformed(evt);
            }
        });

        jButton_listarClientes.setBackground(new java.awt.Color(55, 59, 62));
        jButton_listarClientes.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jButton_listarClientes.setForeground(new java.awt.Color(254, 255, 249));
        jButton_listarClientes.setText("LISTAR CLIENTES");
        jButton_listarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_listarClientesActionPerformed(evt);
            }
        });

        jButton_registrarVehiculo.setBackground(new java.awt.Color(55, 59, 62));
        jButton_registrarVehiculo.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jButton_registrarVehiculo.setForeground(new java.awt.Color(254, 255, 249));
        jButton_registrarVehiculo.setText("REGISTRAR VEHÍCULO");
        jButton_registrarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarVehiculoActionPerformed(evt);
            }
        });

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
        jButton_listarReservas.setText("LISTAR RESERVAS");
        jButton_listarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_listarReservasActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(45, 45, 45));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sign_out_32px.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusCycleRoot(true);
        jButton1.setFocusPainted(false);
        jButton1.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton_retirarVehiculo.setBackground(new java.awt.Color(55, 59, 62));
        jButton_retirarVehiculo.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jButton_retirarVehiculo.setForeground(new java.awt.Color(254, 255, 249));
        jButton_retirarVehiculo.setText("RETIRAR VEHÍCULO");
        jButton_retirarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_retirarVehiculoActionPerformed(evt);
            }
        });

        jButton_modificarPrecio.setBackground(new java.awt.Color(55, 59, 62));
        jButton_modificarPrecio.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jButton_modificarPrecio.setForeground(new java.awt.Color(254, 255, 249));
        jButton_modificarPrecio.setText("MODIFICAR PRECIO");
        jButton_modificarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificarPrecioActionPerformed(evt);
            }
        });

        jButton_cancelrReservas.setBackground(new java.awt.Color(55, 59, 62));
        jButton_cancelrReservas.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jButton_cancelrReservas.setForeground(new java.awt.Color(254, 255, 249));
        jButton_cancelrReservas.setText("CANCELAR RESERVA");
        jButton_cancelrReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelrReservasActionPerformed(evt);
            }
        });

        jDesktopPane.setLayer(jLabel_Bienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton_registrarClientes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton_listarClientes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton_registrarVehiculo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton_listarVehiculos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton_realizarReserva, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton_listarReservas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton_retirarVehiculo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton_modificarPrecio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton_cancelrReservas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel_Bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_cancelrReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPaneLayout.createSequentialGroup()
                        .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_registrarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_listarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_listarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_realizarReserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(83, 83, 83)
                        .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_registrarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_listarVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_retirarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_modificarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Bienvenida))
                .addGap(24, 24, 24)
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_registrarClientes)
                    .addComponent(jButton_registrarVehiculo))
                .addGap(30, 30, 30)
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_listarClientes)
                    .addComponent(jButton_listarVehiculos))
                .addGap(30, 30, 30)
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_realizarReserva)
                    .addComponent(jButton_retirarVehiculo))
                .addGap(30, 30, 30)
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_listarReservas)
                    .addComponent(jButton_modificarPrecio))
                .addGap(30, 30, 30)
                .addComponent(jButton_cancelrReservas)
                .addContainerGap(220, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(1050, 612));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_listarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_listarClientesActionPerformed
        listarClientesTabla();
    }//GEN-LAST:event_jButton_listarClientesActionPerformed

    private void jButton_registrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarClientesActionPerformed
        Interfaz_RegistroClientes rCli = new Interfaz_RegistroClientes();
        centrarFrame(jDesktopPane, rCli);
        jDesktopPane.add(rCli);
        rCli.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jButton_registrarClientesActionPerformed

    private void jButton_registrarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarVehiculoActionPerformed
        Interfaz_RegistroVehiculos rVehi = new Interfaz_RegistroVehiculos();
        centrarFrame(jDesktopPane, rVehi);
        jDesktopPane.add(rVehi);
        rVehi.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jButton_registrarVehiculoActionPerformed

    private void jButton_listarVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_listarVehiculosActionPerformed
        listarVehiculos();
    }//GEN-LAST:event_jButton_listarVehiculosActionPerformed

    private void jButton_listarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_listarReservasActionPerformed
        try {
            listarReservas("%");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_listarReservasActionPerformed

    private void jButton_realizarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_realizarReservaActionPerformed
        Interfaz_Reservas cRes = null;
        try {
            cRes = new Interfaz_Reservas(null);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        centrarFrame(jDesktopPane, cRes);
        jDesktopPane.add(cRes);
        cRes.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jButton_realizarReservaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Interfaz_Main main = new Interfaz_Main();
        main.setVisible(rootPaneCheckingEnabled);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_retirarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_retirarVehiculoActionPerformed
        try {
            bajaVehiculo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_retirarVehiculoActionPerformed

    private void jButton_modificarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarPrecioActionPerformed
        try {
            modificarPrecio();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_modificarPrecioActionPerformed


    private void jButton_cancelrReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelrReservasActionPerformed
        try {
            cancelarReserva("%");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_cancelrReservasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_cancelrReservas;
    private javax.swing.JButton jButton_listarClientes;
    private javax.swing.JButton jButton_listarReservas;
    private javax.swing.JButton jButton_listarVehiculos;
    private javax.swing.JButton jButton_modificarPrecio;
    private javax.swing.JButton jButton_realizarReserva;
    private javax.swing.JButton jButton_registrarClientes;
    private javax.swing.JButton jButton_registrarVehiculo;
    private javax.swing.JButton jButton_retirarVehiculo;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JFrame jFrame4;
    private javax.swing.JFrame jFrame5;
    private javax.swing.JLabel jLabel_Bienvenida;
    // End of variables declaration//GEN-END:variables
}
