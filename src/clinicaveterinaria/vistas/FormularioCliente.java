package clinicaveterinaria.vistas;

import accesoDatos.ClienteData;
import clinicaveterinaria.entidades.Cliente;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import javax.swing.JOptionPane;

public class FormularioCliente extends javax.swing.JFrame {

    private boolean editandoCliente;
    private ClienteData clienteData;

    private List<ClienteEventListener> listeners = new ArrayList<>();

    public void addClienteEventListener(ClienteEventListener listener) {
        listeners.add(listener);
    }

    private void notificarActualizacionCliente() {
        for (ClienteEventListener listener : listeners) {
            listener.clienteActualizado();
        }
    }

    public FormularioCliente(boolean editandoCliente) {

        initComponents();
        this.editandoCliente=editandoCliente;
        verificarEstado();
        clienteData = new ClienteData();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelDNI = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        labelApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        labelDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        labelContacto = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        buttonCancelar = new javax.swing.JButton();
        buttonAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clinica veterinaria-Formulario de clientes");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        labelDNI.setText("Documento: ");

        labelNombre.setText("Nombre: ");

        labelApellido.setText("Apellido: ");

        labelDireccion.setText("Dirección: ");

        labelTelefono.setText("Télefono: ");

        labelContacto.setText("Contacto: ");

        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/huellitas.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        buttonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/huellitas.png"))); // NOI18N
        buttonAceptar.setText("Aceptar");
        buttonAceptar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/clientee.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonAceptar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDNI)
                            .addComponent(labelNombre)
                            .addComponent(labelApellido)
                            .addComponent(labelDireccion)
                            .addComponent(labelTelefono)
                            .addComponent(labelContacto))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelContacto)
                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAceptar)
                    .addComponent(buttonCancelar))
                .addGap(42, 42, 42))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        // Cierra el formulario sin realizar cambios
        this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed

        String nombre = txtNom.getText().toUpperCase();
        String apellido = txtApellido.getText().toUpperCase();
        int documento;
        String documentoStr = txtDNI.getText();
        String direccion = txtDireccion.getText().toUpperCase();
        long telefono;
        String telefonoStr = txtTelefono.getText();
        String contacto = txtContacto.getText().toUpperCase();

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

         Cliente cliente = new Cliente(documento, apellido, nombre, direccion, telefono, contacto, true);
           
        if (editandoCliente) {
                cliente.setApellido(apellido);
                cliente.setNombre(nombre);
                cliente.setDireccion(direccion);
                cliente.setTelefono(telefono);
                cliente.setContacto(contacto);
                clienteData.modificarCliente(cliente);

            notificarActualizacionCliente();
            JOptionPane.showMessageDialog(null, "Cambios cargados");
        } else {
                clienteData.altaCliente(cliente);
                JOptionPane.showMessageDialog(null, "Cliente cargado");
                notificarActualizacionCliente();
            
           
        }
        this.dispose();
    }//GEN-LAST:event_buttonAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
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
    
        if (editandoCliente) {
            txtDNI.setEnabled(false);
        } else {
            txtDNI.setEnabled(true);
        }
    }

    public interface ClienteEventListener extends EventListener {

        void clienteActualizado();
    }
    
    public void setDatosCliente(String apellido, String nombre, int documento, String direccion, long telefono, String contacto) {
    txtApellido.setText(apellido);
    txtNom.setText(nombre);
    txtDNI.setText(String.valueOf(documento));
    txtDireccion.setText(direccion);
    txtTelefono.setText(String.valueOf(telefono));
    txtContacto.setText(contacto);
    }

}
