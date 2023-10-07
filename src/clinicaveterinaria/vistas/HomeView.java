/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicaveterinaria.vistas;

import clinicaveterinaria.vistas.VeterinarioInternalFrame;
import clinicaveterinaria.vistas.EmpleadoInternalFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author borch
 */
public class HomeView extends javax.swing.JFrame {

    /**
     * Creates new form HomeView
     */
    public HomeView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopHome = new javax.swing.JDesktopPane();
        labelUsuario = new javax.swing.JLabel();
        fieldUsuario = new javax.swing.JTextField();
        bIniciarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopHome.setBackground(new java.awt.Color(204, 255, 204));

        labelUsuario.setText("Usuario");

        bIniciarSesion.setText("Iniciar Sesion");
        bIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniciarSesionActionPerformed(evt);
            }
        });

        desktopHome.setLayer(labelUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopHome.setLayer(fieldUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopHome.setLayer(bIniciarSesion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopHomeLayout = new javax.swing.GroupLayout(desktopHome);
        desktopHome.setLayout(desktopHomeLayout);
        desktopHomeLayout.setHorizontalGroup(
            desktopHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopHomeLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(labelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(fieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(desktopHomeLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(bIniciarSesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        desktopHomeLayout.setVerticalGroup(
            desktopHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopHomeLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(desktopHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario)
                    .addComponent(fieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(bIniciarSesion)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIniciarSesionActionPerformed
        // TODO add your handling code here:
         String usuario = fieldUsuario.getText();
 
    boolean esVeterinario = true; 
                
    if (usuario.equals("veterinario@clinicaveterinaria.com")) {
        VeterinarioInternalFrame veterinarioFrame = new VeterinarioInternalFrame();
        desktopHome.add(veterinarioFrame);
        veterinarioFrame.setVisible(true);
    }
    else if (usuario.equals("empleado@clinicaveterinaria.com")) {
        EmpleadoInternalFrame empleadoFrame = new EmpleadoInternalFrame();
        desktopHome.add(empleadoFrame);
        empleadoFrame.setVisible(true);
    }
    else {
        JOptionPane.showMessageDialog(this, "Usuario no válido", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_bIniciarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bIniciarSesion;
    private javax.swing.JDesktopPane desktopHome;
    private javax.swing.JTextField fieldUsuario;
    private javax.swing.JLabel labelUsuario;
    // End of variables declaration//GEN-END:variables
}

