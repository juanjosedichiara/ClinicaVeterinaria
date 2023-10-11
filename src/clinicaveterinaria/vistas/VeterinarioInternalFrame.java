/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicaveterinaria.vistas;

import accesoDatos.ClienteData;
import accesoDatos.MascotaData;

import clinicaveterinaria.entidades.Cliente;
import clinicaveterinaria.entidades.Mascota;
import clinicaveterinaria.vistas.FormularioPacientes;
import clinicaveterinaria.vistas.HomeView;
import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import java.util.List;


/**
 *
 * @author borch
 */
public class VeterinarioInternalFrame extends javax.swing.JInternalFrame {
    private JDesktopPane desktopHome;
    private FormularioPacientes formularioPacientes;
    private HistoriaClinica historiaClinica;
    private HomeView parentFrame;
    private int idCliente;
    
    ClienteData clienteData = new ClienteData();
    MascotaData mascotaData = new MascotaData();
    
    /**
     * Creates new form VeterinarioInternalFrame
     * @param desktop
     */
    public VeterinarioInternalFrame(JDesktopPane desktop) {
       initComponents();
       this.desktopHome = desktop;  
       this.parentFrame = null;
       this.formularioPacientes = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneDatos = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        fieldNomCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fieldApeCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDniCliente = new javax.swing.JTextField();
        buttonBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        boxMascotas = new javax.swing.JComboBox<>();
        buttonNuevaBusqueda = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fieldDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fieldContacto = new javax.swing.JTextField();
        fieldTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fieldRaza = new javax.swing.JTextField();
        fieldSexo = new javax.swing.JTextField();
        fielPesoPromedio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fieldEspecie = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        fieldColor = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        buttonAgregarConsulta = new javax.swing.JButton();
        menuVeterinario = new javax.swing.JMenuBar();
        jMenuVeterinario = new javax.swing.JMenu();
        menuPacientes = new javax.swing.JMenuItem();
        menuConfiguracion = new javax.swing.JMenu();
        menuAtencion = new javax.swing.JMenuItem();
        menuTratamiento = new javax.swing.JMenuItem();
        menuCerrarSesion = new javax.swing.JMenu();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setResizable(true);
        setTitle("VETERINARIO- Clinica veterinaria");

        jLabel5.setText("Nombre: ");

        fieldNomCliente.setEditable(false);

        jLabel6.setText("Apellido:");

        fieldApeCliente.setEditable(false);

        jLabel1.setText("Documento del cliente:");

        buttonBuscar.setText("Buscar");
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Alias de la mascota:");

        boxMascotas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonNuevaBusqueda.setText("Nueva busqueda");
        buttonNuevaBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNuevaBusquedaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 11)); // NOI18N
        jLabel3.setText("DATOS CLIENTE");

        jLabel7.setText("Direccion: ");

        fieldDireccion.setEditable(false);

        jLabel9.setText("Contacto:");

        fieldContacto.setEditable(false);

        fieldTelefono.setEditable(false);

        jLabel8.setText("Telefono:");

        jLabel12.setText("Raza:");

        jLabel10.setText("Sexo: ");

        fieldRaza.setEditable(false);

        fieldSexo.setEditable(false);

        fielPesoPromedio.setEditable(false);
        fielPesoPromedio.setText("             ");

        jLabel15.setText("Peso promedio:");

        jLabel14.setText("Fecha de nacimiento:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 11)); // NOI18N
        jLabel4.setText("DATOS MASCOTA");

        jLabel11.setText("Especie:");

        fieldEspecie.setEditable(false);

        jLabel13.setText("Color:");

        fieldColor.setEditable(false);

        buttonAgregarConsulta.setText("Agregar consulta");
        buttonAgregarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarConsultaActionPerformed(evt);
            }
        });

        paneDatos.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(fieldNomCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(fieldApeCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(txtDniCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(buttonBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(boxMascotas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(buttonNuevaBusqueda, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(fieldDireccion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(fieldContacto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(fieldTelefono, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(fieldRaza, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(fieldSexo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(fielPesoPromedio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(fieldEspecie, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(fieldColor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(jDateChooser1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        paneDatos.setLayer(buttonAgregarConsulta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout paneDatosLayout = new javax.swing.GroupLayout(paneDatos);
        paneDatos.setLayout(paneDatosLayout);
        paneDatosLayout.setHorizontalGroup(
            paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDatosLayout.createSequentialGroup()
                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneDatosLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel3))
                    .addGroup(paneDatosLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneDatosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(paneDatosLayout.createSequentialGroup()
                                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(paneDatosLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(buttonNuevaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))))
                    .addGroup(paneDatosLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel4))
                    .addGroup(paneDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneDatosLayout.createSequentialGroup()
                                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldSexo)
                                    .addComponent(fieldNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldRaza)
                                    .addComponent(fielPesoPromedio, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
                            .addComponent(jLabel12)
                            .addGroup(paneDatosLayout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)
                        .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(paneDatosLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(fieldApeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneDatosLayout.createSequentialGroup()
                                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(paneDatosLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel11))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(paneDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAgregarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );
        paneDatosLayout.setVerticalGroup(
            paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDatosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBuscar)
                .addGap(19, 19, 19)
                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(boxMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonNuevaBusqueda)
                .addGap(40, 40, 40)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldApeCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(fieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneDatosLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldRaza)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(fieldSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(37, 37, 37)
                        .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(fielPesoPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE))
                    .addGroup(paneDatosLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(fieldEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(paneDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonAgregarConsulta)
                .addGap(63, 63, 63))
        );

        jMenuVeterinario.setText("Menú");

        menuPacientes.setText("Pacientes");
        menuPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPacientesMouseClicked(evt);
            }
        });
        jMenuVeterinario.add(menuPacientes);

        menuConfiguracion.setText("Configuracion");

        menuAtencion.setText("Atencion");
        menuConfiguracion.add(menuAtencion);

        menuTratamiento.setText("Tratamientos");
        menuConfiguracion.add(menuTratamiento);

        jMenuVeterinario.add(menuConfiguracion);

        menuVeterinario.add(jMenuVeterinario);

        menuCerrarSesion.setText("Salir");
        menuVeterinario.add(menuCerrarSesion);

        setJMenuBar(menuVeterinario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneDatos)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addComponent(paneDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed
       // Obtener el documento ingresado por el usuario
        String documentoCliente = txtDniCliente.getText();
        
            // Validar si el campo está vacío
        if (documentoCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un documento válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

            // Validar que el documento tenga 8 dígitos numéricos
        if (documentoCliente.matches("\\d{8}")) {
            // Realizar la búsqueda del cliente por documento
            Cliente cliente = clienteData.consultarClientesPorDNI(Integer.parseInt(documentoCliente));

            // Verificar si se encontró un cliente con ese documento
            if (cliente != null) {
                // Almacena el ID del cliente encontrado
                int idCliente = cliente.getIdCliente();
                
                // Llenar los campos de información del cliente en el panel
                fieldNomCliente.setText(cliente.getNombre());
                fieldApeCliente.setText(cliente.getApellido());
                fieldDireccion.setText(cliente.getDireccion());
                fieldTelefono.setText(String.valueOf(cliente.getTelefono()));
                fieldContacto.setText(cliente.getContacto());

                // Limpiar el combo box de mascotas antes de cargar las nuevas mascotas
                boxMascotas.removeAllItems();

                List<Mascota> mascotas = mascotaData.obtenerMascotasPorIdCliente(idCliente);
                for (Mascota mascota : mascotas) {
                    boxMascotas.addItem(mascota.getAlias()); 
                }
            } else {
                // Cliente no encontrado
                JOptionPane.showMessageDialog(this, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Documento inválido
            JOptionPane.showMessageDialog(this, "Documento inválido. Debe contener 8 dígitos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void buttonNuevaBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNuevaBusquedaActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_buttonNuevaBusquedaActionPerformed

    private void buttonAgregarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarConsultaActionPerformed
        String aliasMascota = (String) boxMascotas.getSelectedItem();
    if (aliasMascota != null) {
         // Obtener el ID de la mascota seleccionada
        int idMascota = obtenerIdMascotaSeleccionada();
      
        if(idMascota != -1){
            Mascota mascota = mascotaData.consultarMascotaPorId(idMascota);
            
            if (mascota != null) {
                // Actualizar la instancia de HistoriaClinica con la mascota seleccionada
                //historiaClinica.setMascotaSeleccionada(mascota);
                HistoriaClinica historiaClinicaDialog = new HistoriaClinica(null, true, mascota);
                historiaClinicaDialog.setVisible(true); // Mostrar HistoriaClinica
            }
            }
        }
    }//GEN-LAST:event_buttonAgregarConsultaActionPerformed

    private void menuPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPacientesMouseClicked
         if (formularioPacientes == null) {
        formularioPacientes = new FormularioPacientes(desktopHome);
        desktopHome.add(formularioPacientes);
    }
        System.out.println("funciona");
        formularioPacientes.setVisible(true);
        formularioPacientes.toFront();
    }//GEN-LAST:event_menuPacientesMouseClicked

    private int obtenerIdMascotaSeleccionada() {
        String aliasMascota = (String) boxMascotas.getSelectedItem();

        if (aliasMascota != null) {
            // Consultar la mascota por su alias
            Mascota mascota = mascotaData.buscarMascotaPorAlias(aliasMascota, idCliente);

            if (mascota != null) {
                return mascota.getIdMascota();
            }
        }

        return -1; // Retorna -1 si no se encuentra la mascota
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxMascotas;
    private javax.swing.JButton buttonAgregarConsulta;
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonNuevaBusqueda;
    private javax.swing.JTextField fielPesoPromedio;
    private javax.swing.JTextField fieldApeCliente;
    private javax.swing.JTextField fieldColor;
    private javax.swing.JTextField fieldContacto;
    private javax.swing.JTextField fieldDireccion;
    private javax.swing.JTextField fieldEspecie;
    private javax.swing.JTextField fieldNomCliente;
    private javax.swing.JTextField fieldRaza;
    private javax.swing.JTextField fieldSexo;
    private javax.swing.JTextField fieldTelefono;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenuVeterinario;
    private javax.swing.JMenuItem menuAtencion;
    private javax.swing.JMenu menuCerrarSesion;
    private javax.swing.JMenu menuConfiguracion;
    private javax.swing.JMenuItem menuPacientes;
    private javax.swing.JMenuItem menuTratamiento;
    private javax.swing.JMenuBar menuVeterinario;
    private javax.swing.JLayeredPane paneDatos;
    private javax.swing.JTextField txtDniCliente;
    // End of variables declaration//GEN-END:variables

    
    private void limpiarCampos() {
        txtDniCliente.setText("");
        fieldNomCliente.setText("");
        fieldApeCliente.setText("");
        fieldDireccion.setText("");
        fieldTelefono.setText("");
        fieldContacto.setText("");
        boxMascotas.removeAllItems();
        fieldSexo.setText("");
        fieldEspecie.setText("");
        fieldRaza.setText("");
        fieldColor.setText("");
        jDateChooser1.setDate(null);
    }

}
