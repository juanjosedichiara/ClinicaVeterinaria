package clinicaveterinaria.vistas;

import accesoDatos.ClienteData;
import clinicaveterinaria.entidades.Cliente;
import javax.swing.JOptionPane;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clinica veterinaria-Formulario de clientes");
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);

        labelNombre.setText("Nombre: ");

        labelApellido.setText("Apellido: ");

        labelDNI.setText("Documento: ");

        labelDireccion.setText("Dirección: ");

        labelTelefono.setText("Télefono: ");

        labelContacto.setText("Contacto: ");

        buttonAceptar.setText("Aceptar");
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelDNI, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelApellido, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelDireccion, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelTelefono, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(labelContacto)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(buttonCancelar)
                        .addGap(75, 75, 75)
                        .addComponent(buttonAceptar)))
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNombre)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelContacto))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCancelar)
                    .addComponent(buttonAceptar))
                .addContainerGap(48, Short.MAX_VALUE))
        );

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
