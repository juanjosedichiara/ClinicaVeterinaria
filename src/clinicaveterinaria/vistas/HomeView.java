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
        setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/Vet.png"))); // NOI18N
        logo.setText("jLabel1");

        labelUsser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelUsser.setText("Usuario:");

        buttonIngresar.setText("Ingresar");
        buttonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelUsser)))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonIngresar)))))
                .addContainerGap())
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo)
                .addGap(16, 16, 16)
                .addComponent(labelUsser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonIngresar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 220, 210));

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
