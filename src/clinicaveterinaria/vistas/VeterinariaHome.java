/*
 * ESTE SERA EL GESTOR DE LOS MENUS PARA ACCEDER A TODOS LOS METODOS 
 */
package clinicaveterinaria.vistas;

import accesoDatos.ClienteData;
import accesoDatos.MascotaData;
import accesoDatos.TratamientoData;
import clinicaveterinaria.entidades.Cliente;
import clinicaveterinaria.entidades.Mascota;
import clinicaveterinaria.entidades.Tratamiento;
import clinicaveterinaria.vistas.FormularioCliente.ClienteEventListener;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class VeterinariaHome extends javax.swing.JFrame implements ClienteEventListener {

    private DefaultTableModel tablaMascota;
    private DefaultTableModel tablaCliente;
    private DefaultTableModel tablaTratamiento;

    private MascotaData mascotaData;
    private ClienteData clienteData;
    private TratamientoData tratamientoData;

    private boolean editandoCliente = false;

    private boolean editandoTratamiento = false;

    private JFrame formularioMascota;
    private JFrame formularioCliente;
    private JFrame formularioTratamiento;

    @Override
    public void clienteActualizado() {
        cargarClientes(); // Método para cargar clientes en la tabla
    }

    public VeterinariaHome() {
        initComponents();

        setPreferredSize(new Dimension(830, 580));
        setResizable(true);
        setLocationRelativeTo(null);

        // MODELO MASCOTAS
        tablaMascota = new DefaultTableModel(new String[]{"Alias", "Sexo", "Especie", "Raza", "Color", "Nacimiento", "DNI Cuidador"}, 0);
        tablaListaMascotas.setModel(tablaMascota);

        mascotaData = new MascotaData();
        formularioMascota = new FormularioMascota();
        // Cargar mascotas en la tabla al abrir el panel de pacientes
        cargarMascotas();

        // MODELO CLIENTE
        tablaCliente = new DefaultTableModel(new String[]{"Apellido", "Nombre", "Documento", "Direccion", "Telefono", "Contacto"}, 0);
        tablaListaClientes.setModel(tablaCliente);
        clienteData = new ClienteData();
        formularioCliente = new FormularioCliente(editandoCliente);

        cargarClientes();

        //MODELO TRATAMIENTO
        tablaTratamiento = new DefaultTableModel(new String[]{"Tipo", "Descripcion", "Importe"}, 0);
        tablaListaTratamientos.setModel(tablaTratamiento);
        tratamientoData = new TratamientoData();
        formularioTratamiento = new FormularioTratamiento(editandoTratamiento);
        cargarTratamientos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        buttonPacientes = new javax.swing.JButton();
        buttonFacturacion = new javax.swing.JButton();
        buttonTratamientos = new javax.swing.JButton();
        buttonRegistraVisita = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        buttonClientes = new javax.swing.JButton();
        tabbedPane = new javax.swing.JTabbedPane();
        panelPacientes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaListaMascotas = new javax.swing.JTable();
        eliminarPaciente = new javax.swing.JButton();
        buttonGuardarCambios = new javax.swing.JButton();
        buttonCargarPaciente = new javax.swing.JButton();
        panelTratamientos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaListaTratamientos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        buttonEliminarTratamiento = new javax.swing.JButton();
        AgregarTratamiento = new javax.swing.JButton();
        cambiosTratamiento = new javax.swing.JButton();
        panelFacturacion = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
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
        jLabelPeso = new javax.swing.JTextField();
        jDateInicio = new com.toedter.calendar.JDateChooser();
        jDateFin = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        panelClientes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaListaClientes = new javax.swing.JTable();
        titCliente = new javax.swing.JLabel();
        eliminarCliente = new javax.swing.JButton();
        guardarCliente = new javax.swing.JButton();
        CargarCambiosCliente = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        buttonPacientes.setText("Mis pacientes");
        buttonPacientes.setFocusable(false);
        buttonPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPacientesActionPerformed(evt);
            }
        });

        buttonFacturacion.setText("Facturación");
        buttonFacturacion.setFocusable(false);

        buttonTratamientos.setText("Tratamiento");
        buttonTratamientos.setFocusable(false);
        buttonTratamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTratamientosActionPerformed(evt);
            }
        });

        buttonRegistraVisita.setText("Visita");
        buttonRegistraVisita.setFocusable(false);
        buttonRegistraVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistraVisitaActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/Vet.png"))); // NOI18N

        buttonClientes.setText("Mis clientes");
        buttonClientes.setFocusable(false);
        buttonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClientesActionPerformed(evt);
            }
        });

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
                    .addComponent(buttonClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("LISTADO DE PACIENTES");

        tablaListaMascotas.setAutoCreateRowSorter(true);
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaListaMascotas);

        eliminarPaciente.setText("Eliminar");
        eliminarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPacienteActionPerformed(evt);
            }
        });

        buttonGuardarCambios.setText("Cargar Cambios");
        buttonGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarCambiosActionPerformed(evt);
            }
        });

        buttonCargarPaciente.setText("Agregar paciente");
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
                .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelPacientesLayout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelPacientesLayout.createSequentialGroup()
                            .addGap(102, 102, 102)
                            .addComponent(eliminarPaciente)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonCargarPaciente)
                            .addGap(69, 69, 69)
                            .addComponent(buttonGuardarCambios)))
                    .addGroup(panelPacientesLayout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel3)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        panelPacientesLayout.setVerticalGroup(
            panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPacientesLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGuardarCambios)
                    .addComponent(buttonCargarPaciente)
                    .addComponent(eliminarPaciente))
                .addGap(32, 32, 32))
        );

        tabbedPane.addTab("Formulario Pacientes", panelPacientes);

        tablaListaTratamientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo", "Descripcion", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaListaTratamientos);
        if (tablaListaTratamientos.getColumnModel().getColumnCount() > 0) {
            tablaListaTratamientos.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("LISTADO DE TRATAMIENTOS");

        buttonEliminarTratamiento.setText("Eliminar");
        buttonEliminarTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarTratamientoActionPerformed(evt);
            }
        });

        AgregarTratamiento.setText("Agregar tratamiento");
        AgregarTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarTratamientoActionPerformed(evt);
            }
        });

        cambiosTratamiento.setText("Cargar cambios");
        cambiosTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiosTratamientoActionPerformed(evt);
            }
        });

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
                        .addComponent(buttonEliminarTratamiento)
                        .addGap(103, 103, 103)
                        .addComponent(cambiosTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AgregarTratamiento)))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTratamientosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTratamientosLayout.setVerticalGroup(
            panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTratamientosLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEliminarTratamiento)
                    .addComponent(AgregarTratamiento)
                    .addComponent(cambiosTratamiento))
                .addGap(28, 28, 28))
        );

        tabbedPane.addTab("Formulario Tratamientos", panelTratamientos);

        jLabel9.setText("ACA TRAER TODO LO QUE HAY QUE COBRAR ");

        jLabel10.setText("HACER CALCULOS.");

        jLabel11.setText("TAL VEZ AGREGAR UNA TABLA EN LA BASE DE DATOS PARA REGISTRAR PAGOS");

        javax.swing.GroupLayout panelFacturacionLayout = new javax.swing.GroupLayout(panelFacturacion);
        panelFacturacion.setLayout(panelFacturacionLayout);
        panelFacturacionLayout.setHorizontalGroup(
            panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFacturacionLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        panelFacturacionLayout.setVerticalGroup(
            panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFacturacionLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel9)
                .addGap(60, 60, 60)
                .addComponent(jLabel10)
                .addGap(44, 44, 44)
                .addComponent(jLabel11)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Facturación", panelFacturacion);

        buscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/Lupa (2).png"))); // NOI18N
        buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteActionPerformed(evt);
            }
        });

        labelDNICliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelDNICliente.setText("Documento cliente: ");

        txtDNICliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIClienteActionPerformed(evt);
            }
        });

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

        labelContacto.setText("Contacto: ");

        txtContacto.setEditable(false);

        registrarAtencionMascota.setText("Registrar atencion");

        consultarOtraMascota.setText("Nueva consulta");
        consultarOtraMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarOtraMascotaActionPerformed(evt);
            }
        });

        jLabel5.setText("Tratamiento:");

        jLabel6.setText("Fecha inicio:");

        jLabel7.setText("Fecha termino:");

        jLabel8.setText("Peso:");

        jButton2.setText("Historial de visitas");

        javax.swing.GroupLayout panelNuevaVisitaLayout = new javax.swing.GroupLayout(panelNuevaVisita);
        panelNuevaVisita.setLayout(panelNuevaVisitaLayout);
        panelNuevaVisitaLayout.setHorizontalGroup(
            panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(labelDNICliente)
                        .addGap(67, 67, 67)
                        .addComponent(txtDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(labelApellido)
                        .addGap(36, 36, 36)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(labelNombre)
                        .addGap(39, 39, 39)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(labelTelefono)
                        .addGap(31, 31, 31)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(labelContacto)
                        .addGap(29, 29, 29)
                        .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(labelDireccion)
                        .addGap(33, 33, 33)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(labelTitulo))
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel5)
                        .addGap(78, 78, 78)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel8)
                        .addGap(73, 73, 73)
                        .addComponent(jLabelPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel6)
                        .addGap(71, 71, 71)
                        .addComponent(jDateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel7)
                        .addGap(68, 68, 68)
                        .addComponent(jDateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(consultarOtraMascota)
                        .addGap(133, 133, 133)
                        .addComponent(jButton2)
                        .addGap(31, 31, 31)
                        .addComponent(registrarAtencionMascota)))
                .addGap(74, 74, 74))
        );
        panelNuevaVisitaLayout.setVerticalGroup(
            panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(labelTitulo)
                .addGap(6, 6, 6)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabelPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jDateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consultarOtraMascota)
                    .addComponent(jButton2)
                    .addComponent(registrarAtencionMascota)))
        );

        tabbedPane.addTab("Nueva Visita", panelNuevaVisita);

        tablaListaClientes.setAutoCreateRowSorter(true);
        tablaListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Apellido", "Nombre", "Documento", "Dirección", "Teléfono", "Contacto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaListaClientes);
        if (tablaListaClientes.getColumnModel().getColumnCount() > 0) {
            tablaListaClientes.getColumnModel().getColumn(0).setResizable(false);
            tablaListaClientes.getColumnModel().getColumn(1).setResizable(false);
            tablaListaClientes.getColumnModel().getColumn(2).setResizable(false);
            tablaListaClientes.getColumnModel().getColumn(3).setResizable(false);
            tablaListaClientes.getColumnModel().getColumn(4).setResizable(false);
            tablaListaClientes.getColumnModel().getColumn(5).setResizable(false);
        }

        titCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        titCliente.setText("Listado de CLIENTES");

        eliminarCliente.setText("Eliminar");
        eliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarClienteActionPerformed(evt);
            }
        });

        guardarCliente.setText("Agregar Cliente");
        guardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarClienteActionPerformed(evt);
            }
        });

        CargarCambiosCliente.setText("Cargar Cambios");
        CargarCambiosCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarCambiosClienteActionPerformed(evt);
            }
        });

        jButton1.setText("Asignar Mascota");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(titCliente))
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(eliminarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(guardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CargarCambiosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(79, 79, 79))
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(titCliente)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jButton1)
                .addGap(2, 2, 2)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eliminarCliente)
                        .addComponent(guardarCliente))
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(CargarCambiosCliente))))
        );

        tabbedPane.addTab("Formulario Clientes", panelClientes);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("EDITAR ESTA AREA \nAGREGAR UNA IMAGEN \nQUE SEA EL PANEL \nQUE SE ABRA PRIMERO \nCUANDO SE INICIA SESION");
        jScrollPane5.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Principal", jPanel2);

        getContentPane().add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 660, 520));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/portada.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -20, 660, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //PERTENECE AL BUTTON DE "NUEVA CONSULTA": 
    private void buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteActionPerformed
        //Restricciones del txt DNI
        String doc = txtDNICliente.getText();
        if (doc.isEmpty() || doc.length() != 8 || !doc.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "DNI invalido. Debe contener 8 números, sin signos y letras.");
            return; //No cumple, entonces sale. 
        }
        //Convertir DNI a int
        int dni = Integer.parseInt(doc);

        //Buscar cliente en la BD. 
        Cliente cliente = clienteData.consultarClientesPorDNI(dni);

        //Devolver los datos del cliente. 
        if (cliente.getDocumento() != 0) {
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
            int nuevoCliente = JOptionPane.showConfirmDialog(this, "Cliente no encontrado. ¿Desea agregar un Nuevo Cliente?");

            if (nuevoCliente == 0) {
                tabbedPane.setSelectedComponent(panelClientes);

            } else {
                txtDNICliente.setText("");
            }
        }
    }//GEN-LAST:event_buscarClienteActionPerformed

    //PERTENECE A LA TABLA/LISTA DE MASCOTAS/PACIENTES: 
    private void buttonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarCambiosActionPerformed
        int filaSeleccionada = tablaListaMascotas.getSelectedRow();
        if (filaSeleccionada >= 0) {
            abrirFormularioMascota();
            cargarMascotas();
            ordenarTablaPorAlias();
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
            cargarMascotas();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_eliminarPacienteActionPerformed

    //AQUI SE INDICA QUE AL HACER CLICK EN EL BOTON "VISITA" MUESTRA SU PANEL 
    private void buttonRegistraVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistraVisitaActionPerformed
        tabbedPane.setSelectedComponent(panelNuevaVisita);
    }//GEN-LAST:event_buttonRegistraVisitaActionPerformed

    //PERTENECE A LA TABLA/LISTA DE MASCOTAS/PACIENTES: 
    private void buttonCargarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCargarPacienteActionPerformed
        FormularioMascota formulario = new FormularioMascota();
        // Limpia los campos del formulario
        formulario.limpiarCampos();
        abrirFormularioMascota();
        cargarMascotas();
        ordenarTablaPorAlias();
    }//GEN-LAST:event_buttonCargarPacienteActionPerformed

    //PERTENECE A LA TABLA/LISTA DE MASCOTAS/PACIENTES: 
    private void buttonPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPacientesActionPerformed
        tabbedPane.setSelectedComponent(panelPacientes);
    }//GEN-LAST:event_buttonPacientesActionPerformed

    private void consultarOtraMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarOtraMascotaActionPerformed
        //Se borran todos los campos del formulario Nueva Visita
        txtDNICliente.setText("");
        txtApellido.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtContacto.setText("");

        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        jLabelPeso.setText("");
        jDateInicio.getJCalendar();
        jDateFin.getJCalendar();
    }//GEN-LAST:event_consultarOtraMascotaActionPerformed

    //PERTENECE AL PANEL CLIENTE:
    private void guardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarClienteActionPerformed
        editandoCliente = true;
        FormularioCliente formularioCliente = new FormularioCliente(editandoCliente);
        formularioCliente.addClienteEventListener(this); // Registro del oyente
        formularioCliente.setVisible(true);
    }//GEN-LAST:event_guardarClienteActionPerformed

    private void CargarCambiosClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarCambiosClienteActionPerformed
        int filaSeleccionada = tablaListaClientes.getSelectedRow();
        if (filaSeleccionada >= 0) {
            editandoCliente = false;
            FormularioCliente formularioCliente = new FormularioCliente(editandoCliente);
            formularioCliente.addClienteEventListener( this); // Registro del oyente
            formularioCliente.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_CargarCambiosClienteActionPerformed

    //PERTENECE AL PANEL CLIENTE: 
    private void buttonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClientesActionPerformed
        tabbedPane.setSelectedComponent(panelClientes);
    }//GEN-LAST:event_buttonClientesActionPerformed

    //PERTENECE A CLIENTE: 
    private void eliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarClienteActionPerformed
        int filaSeleccionada = tablaListaClientes.getSelectedRow();
        //System.out.println("FILA SELECCIONADA " +filaSeleccionada);

        if (filaSeleccionada >= 0) {
            int dniCliente = (int) tablaListaClientes.getValueAt(filaSeleccionada, 2);

            // Obtener el ID del cliente por DNI
            int idCliente = clienteData.obtenerIdClientePorDNI(dniCliente);

            if (idCliente != 0) {
                // Obtener las mascotas asociadas al cliente
                List<Mascota> mascotas = mascotaData.obtenerMascotasPorIdCliente(idCliente);

                if (mascotas.isEmpty()) {
                    // No hay mascotas asociadas, mostrar confirmación para eliminar al cliente
                    int confirmacionCliente = JOptionPane.showConfirmDialog(this, "¿Desea eliminar al cliente?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (confirmacionCliente == JOptionPane.YES_OPTION) {
                        clienteData.eliminarCliente(idCliente);
                        cargarClientes();
                    }
                } else {
                    // Hay mascotas asociadas, mostrar confirmación
                    int confirmacion = JOptionPane.showConfirmDialog(this, "Este cliente tiene mascotas asociadas. ¿Desea eliminar al cliente y sus mascotas?", "Confirmación", JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.YES_OPTION) {
                        Cliente cliente = clienteData.consultarClientePorId(idCliente);

                        for (Mascota mascota : mascotas) {
                            clienteData.eliminarClienteConMascota(cliente, mascota);
                            cargarClientes();
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_eliminarClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //ESTE BOTON DEBE llevarnos al panel de mascotas PARA ASIGNAR MASCOTA
        // AL CLIENTE SElECCIONADO DE LA TABLA. 
    }//GEN-LAST:event_jButton1ActionPerformed

    //PERTENECE AL PANEL TRATAMIENTOS
    private void AgregarTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarTratamientoActionPerformed
        editandoTratamiento = true;
        abrirFormularioTratamiento();
        cargarTratamientos();
    }//GEN-LAST:event_AgregarTratamientoActionPerformed

    //PERTENECE AL PANEL TRATAMIENTOS
    private void cambiosTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiosTratamientoActionPerformed
        int filaSeleccionada = tablaListaTratamientos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            editandoTratamiento = false;
            abrirFormularioTratamiento();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un tratamiento para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        cargarTratamientos();
    }//GEN-LAST:event_cambiosTratamientoActionPerformed

    private void buttonTratamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTratamientosActionPerformed
        tabbedPane.setSelectedComponent(panelTratamientos);
    }//GEN-LAST:event_buttonTratamientosActionPerformed

    private void buttonEliminarTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarTratamientoActionPerformed
        int filaSeleccionada = tablaListaTratamientos.getSelectedRow();

        if (filaSeleccionada >= 0) {
            String tipoTratamiento = (String) tablaListaTratamientos.getValueAt(filaSeleccionada, 0);

            int idTratamiento = tratamientoData.obtenerIdTratamientoPorTipo(tipoTratamiento);

            if (idTratamiento != -1) {
                // Eliminar el tratamiento de la base de datos usando el ID
                tratamientoData.eliminarTratamiento(idTratamiento);

                // Actualizar la tabla después de eliminar
                cargarTratamientos();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el tratamiento en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un tratamiento para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonEliminarTratamientoActionPerformed

    private void txtDNIClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIClienteActionPerformed

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
    private javax.swing.JButton AgregarTratamiento;
    private javax.swing.JButton CargarCambiosCliente;
    private javax.swing.JButton buscarCliente;
    private javax.swing.JButton buttonCargarPaciente;
    private javax.swing.JButton buttonClientes;
    private javax.swing.JButton buttonEliminarTratamiento;
    private javax.swing.JButton buttonFacturacion;
    private javax.swing.JButton buttonGuardarCambios;
    private javax.swing.JButton buttonPacientes;
    private javax.swing.JButton buttonRegistraVisita;
    private javax.swing.JButton buttonTratamientos;
    private javax.swing.JButton cambiosTratamiento;
    private javax.swing.JButton consultarOtraMascota;
    private javax.swing.JButton eliminarCliente;
    private javax.swing.JButton eliminarPaciente;
    private javax.swing.JButton guardarCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateFin;
    private com.toedter.calendar.JDateChooser jDateInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLabelPeso;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
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
    private javax.swing.JTable tablaListaClientes;
    private javax.swing.JTable tablaListaMascotas;
    private javax.swing.JTable tablaListaTratamientos;
    private javax.swing.JLabel titCliente;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtDNICliente;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    //PERTENECE A LA TABLA/LISTA DE MASCOTAS/PACIENTES: 
    private void abrirFormularioMascota() {
        FormularioMascota formulario = new FormularioMascota();
        formulario.setVisible(true);
        ordenarTablaPorAlias();
    }

    // Método para cargar las mascotas en la tabla de pacientes
    private void cargarMascotas() {
        // Limpia la tabla
        tablaMascota.setRowCount(0);

        // Obtener la lista de mascotas desde la base de datos
        List<Mascota> mascotas = mascotaData.obtenerTodasLasMascotas();

        // Agregar cada mascota a la tabla
        for (Mascota mascota : mascotas) {
            Object[] fila = {
                mascota.getAlias(),
                mascota.getSexo(),
                mascota.getEspecie(),
                mascota.getRaza(),
                mascota.getColor(),
                mascota.getNacimiento(),
                mascota.getDocumento()
            };
            tablaMascota.addRow(fila);
        }
    }

    //PERTENECE A LA TABLA/LISTA DE MASCOTAS/PACIENTES: 
    private void ordenarTablaPorAlias() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tablaMascota);
        tablaListaMascotas.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int aliasColumn = 1;
        sortKeys.add(new RowSorter.SortKey(aliasColumn, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

    //PERTENECE AL PANEL DE CLIENTE: 
    private void abrirFormularioCliente() {
        FormularioCliente formulario = new FormularioCliente(editandoCliente);

        formulario.setVisible(true);

        ordenarTablaClientesPorApellido();
    }

    // Método para ordenar la tabla de clientes por apellido
    private void ordenarTablaClientesPorApellido() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tablaCliente);
        tablaListaClientes.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int apellidoColumn = 1;
        sortKeys.add(new RowSorter.SortKey(apellidoColumn, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
        cargarClientes();
    }

    // Método para cargar los clientes en la tabla de clientes
    public void cargarClientes() {
        // Limpia la tabla
        tablaCliente.setRowCount(0);

        // Obtener la lista de clientes desde la base de datos
        List<Cliente> clientes = clienteData.obtenerTodosLosClientes();

        // Agregar cada cliente a la tabla
        for (Cliente cliente : clientes) {
            Object[] fila = {
                cliente.getApellido(),
                cliente.getNombre(),
                cliente.getDocumento(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getContacto()
            };
            System.out.println(cliente);
            tablaCliente.addRow(fila);
        }
    }

    //PERTENECE AL PANEL TRATAMIENTO 
    private void cargarTratamientos() {
        tablaTratamiento.setRowCount(0);
        List<Tratamiento> tratamientos = tratamientoData.obtenerTodosLosTratamientos();

        for (Tratamiento tratamiento : tratamientos) {
            Object[] fila = {tratamiento.getTipo(), tratamiento.getDescripcion(), tratamiento.getImporte()};
            tablaTratamiento.addRow(fila);
        }
        ordenarTratamientosAlfabeticamente();
    }

    private void ordenarTratamientosAlfabeticamente() {
        List<Tratamiento> tratamientos = tratamientoData.obtenerTodosLosTratamientos();
        Collections.sort(tratamientos, Comparator.comparing(Tratamiento::getTipo));

        tablaTratamiento.setRowCount(0); // Limpiar la tabla antes de cargar los tratamientos ordenados

        for (Tratamiento tratamiento : tratamientos) {
            Object[] fila = {tratamiento.getTipo(), tratamiento.getDescripcion(), tratamiento.getImporte()};
            tablaTratamiento.addRow(fila);
        }

    }

    private void abrirFormularioTratamiento() {

        FormularioTratamiento formulario = new FormularioTratamiento(editandoTratamiento);

        formulario.setVisible(true);

        ordenarTablaClientesPorApellido();
    }
}
