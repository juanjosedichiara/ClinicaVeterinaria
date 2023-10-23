package clinicaveterinaria.vistas;

import accesoDatos.ClienteData;
import clinicaveterinaria.entidades.Cliente;
import javax.swing.JOptionPane;
import clinicaveterinaria.vistas.*;

public class FormularioCliente extends javax.swing.JFrame {

    private boolean modoNuevo;
    private ClienteData clienteData;

    public FormularioCliente(boolean modoNuevo) {
        
        initComponents();
        this.modoNuevo = modoNuevo;
        clienteData = new ClienteData();
        verificarEstado();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        labelApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        labelDNI = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        labelDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        labelContacto = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        buttonAceptar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setTitle("Agregar Nuevo Cliente");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNombre.setText("Nombre: ");
        getContentPane().add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 63, -1, -1));
        getContentPane().add(txtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 60, 117, -1));

        labelApellido.setText("Apellido: ");
        getContentPane().add(labelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 94, -1, -1));
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 91, 117, -1));

        labelDNI.setText("Documento: ");
        getContentPane().add(labelDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 37, -1, -1));
        getContentPane().add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 34, 117, -1));

        labelDireccion.setText("Dirección: ");
        getContentPane().add(labelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 156, -1, -1));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 153, 117, -1));

        labelTelefono.setText("Télefono: ");
        getContentPane().add(labelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 187, -1, -1));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 184, 117, -1));

        labelContacto.setText("Contacto: ");
        getContentPane().add(labelContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 215, -1, -1));
        getContentPane().add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 215, 117, -1));

        buttonAceptar.setText("Aceptar");
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 288, -1, -1));

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 288, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        // Cierra el formulario sin realizar cambios
        this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed

        String nombre = txtNom.getText();
        String apellido = txtApellido.getText();
        int documento;
        String documentoStr = txtDNI.getText();
        String direccion = txtDireccion.getText();
        long telefono;
        String telefonoStr = txtTelefono.getText();
        String contacto = txtContacto.getText();

        // Valida que el documento y el teléfono sean números válidos
        if (!documentoStr.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(this, "El DNI debe contener 8 números.");
            return;
        }
        if (!telefonoStr.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "El teléfono debe contener 10 números.");
            return;
        }
        documento = Integer.parseInt(documentoStr);
        telefono = Long.parseLong(telefonoStr);

        // Crea un nuevo cliente
        Cliente nuevoCliente = new Cliente(documento, apellido, nombre, direccion, telefono, contacto, true);

        if (modoNuevo) {
            clienteData.altaCliente(nuevoCliente);
            JOptionPane.showMessageDialog(null, "Cliente cargado");

            // ACA SE DEBERÍA AGREGAR EL CODIGO PARA QUE REGENERE EL FORMULARIO EN BLANCO DE NUEVA VISITA
        } else {
            clienteData.modificarCliente(nuevoCliente);
        }
        this.dispose();
    }//GEN-LAST:event_buttonAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelContacto;
    private javax.swing.JLabel labelDNI;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    public void verificarEstado() {

        if (modoNuevo) {
            txtDNI.setEnabled(true);
        } else {
            txtDNI.setEnabled(false);
        }
    }

}
