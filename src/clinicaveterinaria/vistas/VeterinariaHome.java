/*
 * ESTE SERA EL GESTOR DE LOS MENUS PARA ACCEDER A TODOS LOS METODOS 
 */
package clinicaveterinaria.vistas;

import accesoDatos.ClienteData;
import accesoDatos.MascotaData;
import clinicaveterinaria.entidades.Cliente;
import clinicaveterinaria.entidades.Mascota;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class VeterinariaHome extends javax.swing.JFrame {

    // TABLA LISTA PACIENTES/MASCOTA (ABM)
    private DefaultTableModel tablaMascota;

    private MascotaData mascotaData;
    private ClienteData clienteData;

    private JInternalFrame formularioMascota;

    public VeterinariaHome() {
        initComponents();
        // Crear un modelo de tabla personalizado
        tablaMascota = new DefaultTableModel(new String[]{"Alias", "Sexo", "Especie", "Raza", "Color", "Nacimiento", "DNI Cuidador"}, 0);
        tablaListaMascotas.setModel(tablaMascota);

        mascotaData = new MascotaData();

        formularioMascota = new FormularioMascota();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonPacientes = new javax.swing.JButton();
        buttonFacturacion = new javax.swing.JButton();
        buttonTratamientos = new javax.swing.JButton();
        buttonRegistraVisita = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        buttonClientes = new javax.swing.JButton();
        tabbedPane = new javax.swing.JTabbedPane();
        panelNuevaVisita = new javax.swing.JPanel();
        buscarCliente = new javax.swing.JButton();
        labelDNICliente = new javax.swing.JLabel();
        txtDNICliente = new javax.swing.JTextField();
        labelTitulo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        labelApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        labelDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        labelContacto = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        registrarAtencionMascota = new javax.swing.JButton();
        consultarOtraMascota = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        panelClientes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        titCliente = new javax.swing.JLabel();
        eliminarCliente = new javax.swing.JButton();
        guardarCliente = new javax.swing.JButton();
        panelPacientes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaListaMascotas = new javax.swing.JTable();
        eliminarPaciente = new javax.swing.JButton();
        buttonGuardarCambios = new javax.swing.JButton();
        buttonCargarPaciente = new javax.swing.JButton();
        panelTratamientos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        panelFacturacion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        buttonPacientes.setText("Mis pacientes");
        buttonPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPacientesActionPerformed(evt);
            }
        });

        buttonFacturacion.setText("Facturación");

        buttonTratamientos.setText("Tratamiento");

        buttonRegistraVisita.setText("Visita");
        buttonRegistraVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistraVisitaActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/Vet.png"))); // NOI18N

        buttonClientes.setText("Mis clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonTratamientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonFacturacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonRegistraVisita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(43, 43, 43)
                .addComponent(buttonRegistraVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(buttonClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPacientes)
                .addGap(45, 45, 45)
                .addComponent(buttonFacturacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonTratamientos)
                .addGap(107, 107, 107))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 550));

        buscarCliente.setText("Buscar");
        buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteActionPerformed(evt);
            }
        });

        labelDNICliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelDNICliente.setText("Documento cliente: ");

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelTitulo.setText("MASCOTAS DEL CLIENTE");

        labelNombre.setText("Nombre:");

        txtNombre.setEditable(false);

        labelApellido.setText("Apellido: ");

        txtApellido.setEditable(false);

        labelDireccion.setText("Dirección:");

        txtDireccion.setEditable(false);

        labelTelefono.setText("Teléfono: ");

        txtTelefono.setEditable(false);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        labelContacto.setText("Contacto: ");

        txtContacto.setEditable(false);

        registrarAtencionMascota.setText("Registrar atencion");

        consultarOtraMascota.setText("Nueva consulta");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Tratamiento:");

        jLabel6.setText("Fecha inicio:");

        jLabel7.setText("Fecha termino:");

        jLabel8.setText("Peso:");

        javax.swing.GroupLayout panelNuevaVisitaLayout = new javax.swing.GroupLayout(panelNuevaVisita);
        panelNuevaVisita.setLayout(panelNuevaVisitaLayout);
        panelNuevaVisitaLayout.setHorizontalGroup(
            panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscarCliente)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelNuevaVisitaLayout.createSequentialGroup()
                        .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                                    .addGap(124, 124, 124)
                                    .addComponent(labelTitulo))
                                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                                                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel5))
                                                .addGap(114, 114, 114)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                                            .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel7))
                                            .addGap(142, 142, 142)
                                            .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(54, 54, 54))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelNuevaVisitaLayout.createSequentialGroup()
                                            .addComponent(consultarOtraMascota)
                                            .addGap(146, 146, 146)
                                            .addComponent(registrarAtencionMascota)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNuevaVisitaLayout.createSequentialGroup()
                                        .addGap(189, 189, 189)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(92, 92, 92))))
                            .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelDNICliente)
                                    .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                                            .addComponent(labelTelefono)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelNuevaVisitaLayout.createSequentialGroup()
                                            .addGap(4, 4, 4)
                                            .addComponent(labelApellido)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(34, 34, 34)
                                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                                        .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(labelNombre)
                                            .addComponent(labelContacto))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtContacto)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addComponent(labelDireccion)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        panelNuevaVisitaLayout.setVerticalGroup(
            panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDNICliente)
                    .addComponent(txtDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(labelDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelApellido)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelContacto)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTelefono))
                .addGap(77, 77, 77)
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consultarOtraMascota)
                    .addComponent(registrarAtencionMascota))
                .addGap(175, 175, 175))
        );

        tabbedPane.addTab("NuevaVisita", panelNuevaVisita);

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Apellido", "Nombre", "Dirección", "Teléfono", "Contacto"
            }
        ));
        jScrollPane3.setViewportView(tableClientes);
        if (tableClientes.getColumnModel().getColumnCount() > 0) {
            tableClientes.getColumnModel().getColumn(0).setResizable(false);
            tableClientes.getColumnModel().getColumn(1).setResizable(false);
            tableClientes.getColumnModel().getColumn(2).setResizable(false);
            tableClientes.getColumnModel().getColumn(3).setResizable(false);
            tableClientes.getColumnModel().getColumn(4).setResizable(false);
        }

        titCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        titCliente.setText("Listado de CLIENTES");

        eliminarCliente.setText("Eliminar");

        guardarCliente.setText("Guardar");

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(eliminarCliente)
                        .addGap(153, 153, 153)
                        .addComponent(guardarCliente))
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(titCliente)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(titCliente)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarCliente)
                    .addComponent(guardarCliente))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Formulario Clientes", panelClientes);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Listado de PACIENTES");

        tablaListaMascotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Alias", "Sexo", "Especie", "Raza", "Color", "Nacimiento", "DNI Cuidador"
            }
        ));
        jScrollPane4.setViewportView(tablaListaMascotas);
        if (tablaListaMascotas.getColumnModel().getColumnCount() > 0) {
            tablaListaMascotas.getColumnModel().getColumn(0).setResizable(false);
            tablaListaMascotas.getColumnModel().getColumn(1).setResizable(false);
            tablaListaMascotas.getColumnModel().getColumn(2).setResizable(false);
            tablaListaMascotas.getColumnModel().getColumn(3).setResizable(false);
            tablaListaMascotas.getColumnModel().getColumn(4).setResizable(false);
            tablaListaMascotas.getColumnModel().getColumn(5).setResizable(false);
            tablaListaMascotas.getColumnModel().getColumn(6).setResizable(false);
        }

        eliminarPaciente.setText("Eliminar");
        eliminarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPacienteActionPerformed(evt);
            }
        });

        buttonGuardarCambios.setText("Guardar cambios");
        buttonGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarCambiosActionPerformed(evt);
            }
        });

        buttonCargarPaciente.setText("Cargar paciente");
        buttonCargarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCargarPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPacientesLayout = new javax.swing.GroupLayout(panelPacientes);
        panelPacientes.setLayout(panelPacientesLayout);
        panelPacientesLayout.setHorizontalGroup(
            panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPacientesLayout.createSequentialGroup()
                .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelPacientesLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(eliminarPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCargarPaciente)
                        .addGap(18, 18, 18)
                        .addComponent(buttonGuardarCambios))
                    .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPacientesLayout.createSequentialGroup()
                            .addGap(240, 240, 240)
                            .addComponent(jLabel3))
                        .addGroup(panelPacientesLayout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        panelPacientesLayout.setVerticalGroup(
            panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPacientesLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGuardarCambios)
                    .addComponent(eliminarPaciente)
                    .addComponent(buttonCargarPaciente))
                .addGap(53, 53, 53))
        );

        tabbedPane.addTab("Formulario Pacientes", panelPacientes);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo", "Descripcion", "Importe"
            }
        ));
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Lista de TRATAMIENTOS");

        jButton5.setText("Eliminar");

        jButton6.setText("Guardar");

        javax.swing.GroupLayout panelTratamientosLayout = new javax.swing.GroupLayout(panelTratamientos);
        panelTratamientos.setLayout(panelTratamientosLayout);
        panelTratamientosLayout.setHorizontalGroup(
            panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTratamientosLayout.createSequentialGroup()
                .addGroup(panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTratamientosLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel4))
                    .addGroup(panelTratamientosLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTratamientosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(117, 117, 117)
                .addComponent(jButton6)
                .addGap(215, 215, 215))
        );
        panelTratamientosLayout.setVerticalGroup(
            panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTratamientosLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addGap(103, 103, 103))
        );

        tabbedPane.addTab("Formulario Tratamientos", panelTratamientos);

        javax.swing.GroupLayout panelFacturacionLayout = new javax.swing.GroupLayout(panelFacturacion);
        panelFacturacion.setLayout(panelFacturacionLayout);
        panelFacturacionLayout.setHorizontalGroup(
            panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );
        panelFacturacionLayout.setVerticalGroup(
            panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Caja", panelFacturacion);

        getContentPane().add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 660, 530));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/portada.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -20, 660, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    //PERTENECE AL BUTTON DE "NUEVA CONSULTA": 
    private void buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteActionPerformed
        //Restricciones del txt DNI
        String doc = txtDNICliente.getText().trim();
        if (doc.isEmpty() || doc.length() != 8 || !doc.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "DNI invalido. Debe contener 8 números, sin signos y letras.");
            return; //No cumple, entonces sale. 
        }
        //Convertir DNI a int
        int dni = Integer.parseInt(doc);

        //Buscar cliente en la BD. 
        Cliente cliente = clienteData.consultarClientesPorDNI(dni);

        //Devolver los datos del cliente. 
        if (cliente.getIdCliente() != 0) {
            txtNombre.setText(cliente.getNombre());
            txtApellido.setText(cliente.getApellido());
            txtDireccion.setText(cliente.getDireccion());
            txtContacto.setText(cliente.getContacto());
            txtTelefono.setText(String.valueOf(cliente.getTelefono()));

            //Cargar mascotas al ComboBox.
            List<Mascota> mascotas = mascotaData.obtenerMascotasPorIdCliente(cliente.getIdCliente());
            //Limpiar ComboBox
            jComboBox1.removeAllItems();
            for (Mascota mascota : mascotas) {
                jComboBox1.addItem(mascota.getAlias());
            }

        } else {
            JOptionPane.showConfirmDialog(this, "Cliente no encontrado.");
        }
    }//GEN-LAST:event_buscarClienteActionPerformed

    //PERTENECE A LA TABLA/LISTA DE MASCOTAS/PACIENTES: 
    private void buttonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarCambiosActionPerformed
        int filaSeleccionada = tablaListaMascotas.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // De la fila seleccionada de la tabla y cargar el FormularioMascota
            cargarDatosFormularioMascota(tablaMascota, filaSeleccionada);
            abrirFormularioMascota();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonGuardarCambiosActionPerformed

    //PERTENECE A LA TABLA/LISTA DE MASCOTAS/PACIENTES: 
    private void eliminarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPacienteActionPerformed
        //Seleccionar una lista de la tablaPacientes y clickear el boton eliminar
        int filaSeleccionada = tablaListaMascotas.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Obtener el ID de la mascota de la fila seleccionada 
            int idMascota = Integer.parseInt(tablaMascota.getValueAt(filaSeleccionada, 0).toString());
            // Llamar al método eliminarMascota 
            mascotaData.eliminarMascota(idMascota);
            // Quitar la fila seleccionada de la tabla
            tablaMascota.removeRow(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_eliminarPacienteActionPerformed

    //AQUI SE INDICA QUE AL HACER CLICK EN EL BOTON "VISITA" MUESTRA SU PANEL 
    private void buttonRegistraVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistraVisitaActionPerformed
        tabbedPane.setSelectedComponent(panelNuevaVisita);
    }//GEN-LAST:event_buttonRegistraVisitaActionPerformed

    private void buttonCargarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCargarPacienteActionPerformed
        limpiarCamposFormularioMascota();
        abrirFormularioMascota();
    }//GEN-LAST:event_buttonCargarPacienteActionPerformed

    private void buttonPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPacientesActionPerformed
        tabbedPane.setSelectedComponent(panelPacientes);
    }//GEN-LAST:event_buttonPacientesActionPerformed


    public static void main() {
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
            java.util.logging.Logger.getLogger(VeterinariaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeterinariaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeterinariaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeterinariaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VeterinariaHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarCliente;
    private javax.swing.JButton buttonCargarPaciente;
    private javax.swing.JButton buttonClientes;
    private javax.swing.JButton buttonFacturacion;
    private javax.swing.JButton buttonGuardarCambios;
    private javax.swing.JButton buttonPacientes;
    private javax.swing.JButton buttonRegistraVisita;
    private javax.swing.JButton buttonTratamientos;
    private javax.swing.JButton consultarOtraMascota;
    private javax.swing.JButton eliminarCliente;
    private javax.swing.JButton eliminarPaciente;
    private javax.swing.JButton guardarCliente;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelContacto;
    private javax.swing.JLabel labelDNICliente;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelFacturacion;
    private javax.swing.JPanel panelNuevaVisita;
    private javax.swing.JPanel panelPacientes;
    private javax.swing.JPanel panelTratamientos;
    private javax.swing.JButton registrarAtencionMascota;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tablaListaMascotas;
    private javax.swing.JTable tableClientes;
    private javax.swing.JLabel titCliente;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtDNICliente;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void abrirFormularioMascota() {
        // Abre el FormularioMascota
        formularioMascota.setVisible(true);
        if (!formularioMascota.isShowing()) {
            tabbedPane.add(formularioMascota);
        }
        try {
            formularioMascota.setSelected(true);
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }
    }

    public void limpiarCamposFormularioMascota() {
        // formularioMascota.limpiarCampos();
    }

    public void cargarDatosFormularioMascota(DefaultTableModel tablaListaMascota, int filaSeleccionada) {
        //  formularioMascota.cargarDatosDesdeTabla(tablaListaMascota, filaSeleccionada);
    }

    private void ordenarTablaPorAlias() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tablaMascota);
        tablaListaMascotas.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int aliasColumn = 0;
        sortKeys.add(new RowSorter.SortKey(aliasColumn, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

}
