package clinicaveterinaria.vistas;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class HomeView extends javax.swing.JFrame {
    int intentos = 3;

    public HomeView() {
        initComponents();
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        JDesktopPane desktopHome = new JDesktopPane();
        getContentPane().add(desktopHome, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        labelUsser = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        buttonIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clinica Veterinaria");
        setLocationByPlatform(true);
        setResizable(false);

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        panelLogin.setPreferredSize(new java.awt.Dimension(220, 220));
        panelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/Vet.png"))); // NOI18N
        logo.setText("jLabel1");
        panelLogin.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 13, 82, -1));

        labelUsser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelUsser.setText("Usuario:");
        panelLogin.add(labelUsser, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 108, -1, -1));
        panelLogin.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 133, 196, -1));

        buttonIngresar.setText("Ingresar");
        buttonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIngresarActionPerformed(evt);
            }
        });
        panelLogin.add(buttonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 164, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIngresarActionPerformed
        String usuarioMaster = "@veterinario";
        String usuarioEmpleado = "@empleado";

        if (txtUsuario.getText().equalsIgnoreCase(usuarioMaster)) {
            VeterinariaHome.main(); //Llama al metodo main de la clase VeterinariaHome para ejecutar la ventana principal
            txtUsuario.setText("");
        } else if (txtUsuario.getText().equalsIgnoreCase(usuarioEmpleado)) {
            VeterinariaHome.main();
            txtUsuario.setText("");
        } else if (txtUsuario.getText().length() != 0) {
            intentos = intentos - 1;
            JOptionPane.showMessageDialog(null, "Usuario Incorrecto!!. Le quedan " + intentos + " intentos.");
            txtUsuario.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de Usuario");
        }
        if (intentos == 0) {
            System.exit(intentos);
        }

    }//GEN-LAST:event_buttonIngresarActionPerformed

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
    private javax.swing.JButton buttonIngresar;
    private javax.swing.JLabel labelUsser;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
