/*
 * ESTE SERA EL GESTOR DE LOS MENUS PARA ACCEDER A TODOS LOS METODOS 
 */
package clinicaveterinaria.vistas;

import accesoDatos.ClienteData;
import accesoDatos.MascotaData;
import accesoDatos.TratamientoData;
import accesoDatos.VisitaData;
import clinicaveterinaria.entidades.Cliente;
import clinicaveterinaria.entidades.Mascota;
import clinicaveterinaria.entidades.Tratamiento;
import clinicaveterinaria.entidades.Visita;
import clinicaveterinaria.vistas.FormularioCliente.ClienteEventListener;
import clinicaveterinaria.vistas.FormularioMascota.MascotaEventListener;
import clinicaveterinaria.vistas.FormularioTratamiento.TratamientoEventListener;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class VeterinariaHome extends javax.swing.JFrame implements ClienteEventListener, MascotaEventListener, TratamientoEventListener {

    private DefaultTableModel tablaMascota;
    private DefaultTableModel tablaCliente;
    private DefaultTableModel tablaTratamiento;
    private DefaultTableModel mascotasCliente;
    private DefaultTableModel historialVisita;
    private DefaultTableModel tablaFacturacion;

    private MascotaData mascotaData;
    private ClienteData clienteData;
    private TratamientoData tratamientoData;
    private VisitaData visitaData;
    private FormularioVisita formularioVisita;

    private boolean editandoCliente = false;
    private boolean editandoMascota = false;

    private boolean editandoTratamiento = false;

    private int idMascotaSeleccionada;
    private String aliasMascotaSeleccionada;
    private String documentoCliente;
    private static int nroFactura = 1;

    private JFrame formularioMascota;
    private JFrame formularioCliente;
    private JFrame formularioTratamiento;

    @Override
    public void clienteActualizado() {
        cargarClientes();
    }

    @Override
    public void mascotaActualizado() {
        cargarMascotas();
    }

    @Override
    public void tratamientoActualizado() {
        cargarTratamientos();
    }

    public VeterinariaHome() {
        initComponents();

        setPreferredSize(new Dimension(829, 517));
        setResizable(false);
        setLocationRelativeTo(null);

        // MODELO MASCOTAS
        tablaMascota = new DefaultTableModel(new String[]{"Alias", "Sexo", "Especie", "Raza", "Color", "Nacimiento", "DNI Cuidador"}, 0);
        tablaListaMascotas.setModel(tablaMascota);
        mascotaData = new MascotaData();
        formularioMascota = new FormularioMascota(editandoMascota);
        // Cargar mascotas en la tabla al abrir el panel de pacientes
        cargarMascotas();

        // MODELO CLIENTE
        tablaCliente = new DefaultTableModel(new String[]{"Apellido", "Nombre", "Documento", "Direccion", "Telefono", "Contacto"}, 0);
        tablaListaClientes.setModel(tablaCliente);
        clienteData = new ClienteData();
        formularioCliente = new FormularioCliente(editandoCliente);

        cargarClientes();

        //MODELO TRATAMIENTO
        tablaTratamiento = new DefaultTableModel(new String[]{"Código", "Tipo", "Descripcion", "Importe"}, 0);
        tablaListaTratamientos.setModel(tablaTratamiento);
        tratamientoData = new TratamientoData();
        formularioTratamiento = new FormularioTratamiento(editandoTratamiento);
        cargarTratamientos();

        //MODELO VISITA
        mascotasCliente = new DefaultTableModel(new String[]{"Alias", "Especie", "Raza", "Sexo", "Color", "Fecha de nacimiento"}, 0);
        tablaMascotasCliente.setModel(mascotasCliente);

        //MODELO HISTORIAL VISITA
        historialVisita = new DefaultTableModel(new String[]{"Fecha visita", "Sintomas", "Afeccion", "Tratamiento", "Duracion", "Peso actual", "Peso promedio"}, 0);
        tablaHistorialVisita.setModel(historialVisita);
        visitaData = new VisitaData();
        //  formularioVisita = new FormularioVisita();

        //MODELO FACTURACION
        cargarComboClientes();
        tablaFacturacion = new DefaultTableModel(new String[]{"Cantidad", "Descripción", "Precio Unitario", "SubTotal"}, 0);
        jTablaFacturacion.setModel(tablaFacturacion);
        textFieldFechaNow.setText(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        textFieldFechaNow.setEnabled(false);
        jtFNroFactura.setText("000-000" + String.valueOf(generarNroFactura()));
        jtFNroFactura.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelButtonsIzq = new javax.swing.JPanel();
        buttonPacientes = new javax.swing.JButton();
        buttonFacturacion = new javax.swing.JButton();
        buttonTratamientos = new javax.swing.JButton();
        buttonRegistraVisita = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        buttonClientes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonPanelHistorialVisitas = new javax.swing.JButton();
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
        buttonOtraConsulta = new javax.swing.JButton();
        buttonHistorialVisitas = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaMascotasCliente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        panelClientes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaListaClientes = new javax.swing.JTable();
        titCliente = new javax.swing.JLabel();
        eliminarCliente = new javax.swing.JButton();
        guardarCliente = new javax.swing.JButton();
        CargarCambiosCliente = new javax.swing.JButton();
        jToggleButtonClientesInactivos = new javax.swing.JToggleButton();
        panelFacturacion = new javax.swing.JPanel();
        jLCliente = new javax.swing.JLabel();
        jLMiFactura = new javax.swing.JLabel();
        jLDni = new javax.swing.JLabel();
        jcbClientes = new javax.swing.JComboBox<>();
        jtFDni = new javax.swing.JTextField();
        jLDomicilio = new javax.swing.JLabel();
        jtFDomicilio = new javax.swing.JTextField();
        jLFecha = new javax.swing.JLabel();
        jLFactura = new javax.swing.JLabel();
        jcbSituacionFiscal = new javax.swing.JComboBox<>();
        jtFNroFactura = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTablaFacturacion = new javax.swing.JTable();
        textFieldFechaNow = new javax.swing.JTextField();
        jbAgregarVenta = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jtFTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jbTerminarVenta = new javax.swing.JButton();
        jTextDescripcion = new javax.swing.JTextField();
        jTextCantidad = new javax.swing.JTextField();
        jTextPrecioUnitario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelPacientes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaListaMascotas = new javax.swing.JTable();
        eliminarPaciente = new javax.swing.JButton();
        buttonGuardarCambios = new javax.swing.JButton();
        buttonCargarPaciente = new javax.swing.JButton();
        jToggleButtonPacientesInactivos = new javax.swing.JToggleButton();
        panelTratamientos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaListaTratamientos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        buttonEliminarTratamiento = new javax.swing.JButton();
        AgregarTratamiento = new javax.swing.JButton();
        cambiosTratamiento = new javax.swing.JButton();
        panelRegistrarVisita = new javax.swing.JPanel();
        labelClienteVisita = new javax.swing.JLabel();
        labelAliasVisita = new javax.swing.JLabel();
        txtClienteVisita = new javax.swing.JTextField();
        txtMascotaVisita = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaHistorialVisita = new javax.swing.JTable();
        buttonVolverVisita = new javax.swing.JButton();
        buttonRegistrarVisita = new javax.swing.JButton();
        buttonNuevaConsultaHistorialVisitas = new javax.swing.JButton();
        buttonBuscarVisitas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clinica veterinaria");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelButtonsIzq.setBackground(new java.awt.Color(153, 255, 255));
        panelButtonsIzq.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelButtonsIzq.setEnabled(false);
        panelButtonsIzq.setMaximumSize(null);

        buttonPacientes.setText("Pacientes");
        buttonPacientes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonPacientes.setFocusable(false);
        buttonPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPacientesActionPerformed(evt);
            }
        });

        buttonFacturacion.setText("Facturación");
        buttonFacturacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonFacturacion.setFocusable(false);
        buttonFacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFacturacionActionPerformed(evt);
            }
        });

        buttonTratamientos.setText("Tratamientos");
        buttonTratamientos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonTratamientos.setFocusable(false);
        buttonTratamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTratamientosActionPerformed(evt);
            }
        });

        buttonRegistraVisita.setText("Visita");
        buttonRegistraVisita.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonRegistraVisita.setFocusable(false);
        buttonRegistraVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistraVisitaActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/Vet.png"))); // NOI18N

        buttonClientes.setText("Clientes");
        buttonClientes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonClientes.setFocusable(false);
        buttonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClientesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Administración");

        buttonPanelHistorialVisitas.setText("Historial visitas");
        buttonPanelHistorialVisitas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonPanelHistorialVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPanelHistorialVisitasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonsIzqLayout = new javax.swing.GroupLayout(panelButtonsIzq);
        panelButtonsIzq.setLayout(panelButtonsIzqLayout);
        panelButtonsIzqLayout.setHorizontalGroup(
            panelButtonsIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsIzqLayout.createSequentialGroup()
                .addGroup(panelButtonsIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelButtonsIzqLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelButtonsIzqLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsIzqLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelButtonsIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonPanelHistorialVisitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonTratamientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonFacturacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonRegistraVisita, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        panelButtonsIzqLayout.setVerticalGroup(
            panelButtonsIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsIzqLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(logo)
                .addGap(61, 61, 61)
                .addComponent(buttonRegistraVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonFacturacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPanelHistorialVisitas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(buttonClientes)
                .addGap(18, 18, 18)
                .addComponent(buttonPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonTratamientos)
                .addGap(104, 104, 104))
        );

        panelButtonsIzqLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonClientes, buttonFacturacion, buttonPacientes, buttonRegistraVisita, buttonTratamientos});

        getContentPane().add(panelButtonsIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 550));

        tabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabbedPane.setEnabled(false);

        panelNuevaVisita.setBackground(new java.awt.Color(153, 255, 255));

        buscarCliente.setText("Buscar");
        buscarCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteActionPerformed(evt);
            }
        });

        labelDNICliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        labelContacto.setText("Contacto: ");

        txtContacto.setEditable(false);

        buttonOtraConsulta.setText("Nueva consulta");
        buttonOtraConsulta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonOtraConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOtraConsultaActionPerformed(evt);
            }
        });

        buttonHistorialVisitas.setText("Historial de visitas");
        buttonHistorialVisitas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonHistorialVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHistorialVisitasActionPerformed(evt);
            }
        });

        tablaMascotasCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Alias", "Especie", "Raza", "Sexo", "Color", "Fecha de nacimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tablaMascotasCliente);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/vistas1.png"))); // NOI18N

        javax.swing.GroupLayout panelNuevaVisitaLayout = new javax.swing.GroupLayout(panelNuevaVisita);
        panelNuevaVisita.setLayout(panelNuevaVisitaLayout);
        panelNuevaVisitaLayout.setHorizontalGroup(
            panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(buttonOtraConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonHistorialVisitas)
                .addGap(124, 124, 124))
            .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(labelTitulo))
                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTelefono)
                                    .addComponent(labelApellido))
                                .addGap(29, 29, 29)
                                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(labelNombre)
                                        .addGap(28, 28, 28)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(labelContacto)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                                .addComponent(labelDNICliente)
                                .addGap(27, 27, 27)
                                .addComponent(txtDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(buscarCliente))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNuevaVisitaLayout.createSequentialGroup()
                                .addComponent(labelDireccion)
                                .addGap(29, 29, 29)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(219, 219, 219)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNuevaVisitaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelNuevaVisitaLayout.setVerticalGroup(
            panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaVisitaLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(panelNuevaVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOtraConsulta)
                    .addComponent(buttonHistorialVisitas))
                .addGap(41, 41, 41))
        );

        tabbedPane.addTab("a.1", null, panelNuevaVisita, "");

        panelClientes.setBackground(new java.awt.Color(204, 255, 255));

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
        titCliente.setText("LISTADO DE MIS CLIENTES");

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

        jToggleButtonClientesInactivos.setText("Inactivos");
        jToggleButtonClientesInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonClientesInactivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(panelClientesLayout.createSequentialGroup()
                                .addComponent(eliminarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                .addGap(219, 219, 219)
                                .addComponent(CargarCambiosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62))
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addComponent(jToggleButtonClientesInactivos)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(titCliente)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(titCliente)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(jToggleButtonClientesInactivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guardarCliente)
                    .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eliminarCliente)
                        .addComponent(CargarCambiosCliente)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tabbedPane.addTab("c", panelClientes);

        panelFacturacion.setBackground(new java.awt.Color(204, 255, 255));

        jLCliente.setText("Cliente:");

        jLMiFactura.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLMiFactura.setText("Mi Factura");

        jLDni.setText("DNI: ");

        jcbClientes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbClientesItemStateChanged(evt);
            }
        });

        jtFDni.setEditable(false);

        jLDomicilio.setText("Domicilio:");

        jtFDomicilio.setEditable(false);

        jLFecha.setText("Fecha:");

        jLFactura.setText("FACTURA N°:");

        jcbSituacionFiscal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Situación Fiscal---", "Consumidor Final", "IVA Exento", "Resp. Inscripto", "Resp. Monotributo", "Resp. No Inscripto" }));

        jtFNroFactura.setEditable(false);

        jTablaFacturacion.setBackground(new java.awt.Color(153, 204, 255));
        jTablaFacturacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cantidad", "Descripción", "Precio Unitario", "Sub Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTablaFacturacion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTablaFacturacion.setColumnSelectionAllowed(true);
        jScrollPane5.setViewportView(jTablaFacturacion);

        textFieldFechaNow.setEditable(false);

        jbAgregarVenta.setBackground(new java.awt.Color(153, 255, 153));
        jbAgregarVenta.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jbAgregarVenta.setText("AGREGAR VENTA");
        jbAgregarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarVentaActionPerformed(evt);
            }
        });

        jtFTotal.setEditable(false);
        jtFTotal.setBackground(new java.awt.Color(204, 255, 255));
        jtFTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("TOTAL $");

        jbTerminarVenta.setBackground(new java.awt.Color(255, 153, 153));
        jbTerminarVenta.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jbTerminarVenta.setText("FINALIZAR VENTA");
        jbTerminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTerminarVentaActionPerformed(evt);
            }
        });

        jTextDescripcion.setToolTipText("Descripcion del Producto");

        jTextCantidad.setToolTipText("Cantidad");

        jTextPrecioUnitario.setToolTipText("Precio Unitario");

        jLabel6.setText("Cantidad:");

        jLabel7.setText("Precio Unitario:");

        jLabel8.setText("Descripción:");

        javax.swing.GroupLayout panelFacturacionLayout = new javax.swing.GroupLayout(panelFacturacion);
        panelFacturacion.setLayout(panelFacturacionLayout);
        panelFacturacionLayout.setHorizontalGroup(
            panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFacturacionLayout.createSequentialGroup()
                .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFacturacionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFacturacionLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbTerminarVenta)))
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFacturacionLayout.createSequentialGroup()
                .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFacturacionLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFacturacionLayout.createSequentialGroup()
                                .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLDomicilio)
                                    .addComponent(jLCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelFacturacionLayout.createSequentialGroup()
                                        .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLDni)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtFDni, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtFDomicilio)))
                            .addGroup(panelFacturacionLayout.createSequentialGroup()
                                .addComponent(jLMiFactura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                                .addComponent(jLFactura))))
                    .addGroup(panelFacturacionLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLFecha)))
                .addGap(18, 18, 18)
                .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcbSituacionFiscal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtFNroFactura)
                    .addComponent(textFieldFechaNow))
                .addGap(43, 43, 43))
            .addGroup(panelFacturacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFacturacionLayout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFacturacionLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFacturacionLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(166, 166, 166)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelFacturacionLayout.createSequentialGroup()
                                .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextDescripcion)
                                .addGap(18, 18, 18)
                                .addComponent(jTextPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jbAgregarVenta)
                        .addGap(22, 22, 22))))
        );
        panelFacturacionLayout.setVerticalGroup(
            panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFacturacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLMiFactura)
                    .addComponent(jLFactura)
                    .addComponent(jtFNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLFecha)
                    .addComponent(textFieldFechaNow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCliente)
                    .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDni)
                    .addComponent(jtFDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSituacionFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDomicilio)
                    .addComponent(jtFDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbTerminarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(38, 38, 38))
        );

        tabbedPane.addTab("b", panelFacturacion);

        panelPacientes.setBackground(new java.awt.Color(204, 255, 255));

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

        jToggleButtonPacientesInactivos.setText("Inactivos");
        jToggleButtonPacientesInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonPacientesInactivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPacientesLayout = new javax.swing.GroupLayout(panelPacientes);
        panelPacientes.setLayout(panelPacientesLayout);
        panelPacientesLayout.setHorizontalGroup(
            panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPacientesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonGuardarCambios)
                .addGap(18, 18, 18)
                .addComponent(buttonCargarPaciente)
                .addGap(82, 82, 82))
            .addGroup(panelPacientesLayout.createSequentialGroup()
                .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPacientesLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPacientesLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jToggleButtonPacientesInactivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelPacientesLayout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel3)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelPacientesLayout.setVerticalGroup(
            panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPacientesLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jToggleButtonPacientesInactivos)
                .addGap(18, 18, 18)
                .addGroup(panelPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarPaciente)
                    .addComponent(buttonCargarPaciente)
                    .addComponent(buttonGuardarCambios))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tabbedPane.addTab("d", panelPacientes);

        panelTratamientos.setBackground(new java.awt.Color(204, 255, 255));

        tablaListaTratamientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Tipo", "Descripcion", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaListaTratamientos);
        if (tablaListaTratamientos.getColumnModel().getColumnCount() > 0) {
            tablaListaTratamientos.getColumnModel().getColumn(0).setResizable(false);
            tablaListaTratamientos.getColumnModel().getColumn(2).setResizable(false);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTratamientosLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTratamientosLayout.createSequentialGroup()
                        .addComponent(buttonEliminarTratamiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cambiosTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AgregarTratamiento)
                        .addGap(57, 57, 57))
                    .addGroup(panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTratamientosLayout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTratamientosLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(267, 267, 267)))))
        );
        panelTratamientosLayout.setVerticalGroup(
            panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTratamientosLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addGroup(panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgregarTratamiento)
                    .addComponent(cambiosTratamiento)
                    .addComponent(buttonEliminarTratamiento))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        tabbedPane.addTab("e", panelTratamientos);

        panelRegistrarVisita.setBackground(new java.awt.Color(204, 255, 255));

        labelClienteVisita.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelClienteVisita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelClienteVisita.setText("Cliente:");

        labelAliasVisita.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelAliasVisita.setText("Mascota:");

        txtClienteVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteVisitaActionPerformed(evt);
            }
        });

        tablaHistorialVisita.setAutoCreateRowSorter(true);
        tablaHistorialVisita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha visita", "Sintomas", "Afeccion", "Tratamiento", "Duración", "Peso actual", "Peso prom"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaHistorialVisita.setCellSelectionEnabled(true);
        jScrollPane7.setViewportView(tablaHistorialVisita);

        buttonVolverVisita.setText("Atras");
        buttonVolverVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverVisitaActionPerformed(evt);
            }
        });

        buttonRegistrarVisita.setText("Registrar visita");
        buttonRegistrarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarVisitaActionPerformed(evt);
            }
        });

        buttonNuevaConsultaHistorialVisitas.setText("Nueva consulta");
        buttonNuevaConsultaHistorialVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNuevaConsultaHistorialVisitasActionPerformed(evt);
            }
        });

        buttonBuscarVisitas.setText("Buscar");
        buttonBuscarVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarVisitasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRegistrarVisitaLayout = new javax.swing.GroupLayout(panelRegistrarVisita);
        panelRegistrarVisita.setLayout(panelRegistrarVisitaLayout);
        panelRegistrarVisitaLayout.setHorizontalGroup(
            panelRegistrarVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistrarVisitaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelRegistrarVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistrarVisitaLayout.createSequentialGroup()
                        .addGroup(panelRegistrarVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonRegistrarVisita)
                            .addGroup(panelRegistrarVisitaLayout.createSequentialGroup()
                                .addComponent(buttonBuscarVisitas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelClienteVisita)
                                .addGap(27, 27, 27)
                                .addComponent(txtClienteVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(labelAliasVisita)
                                .addGap(48, 48, 48)
                                .addComponent(txtMascotaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58))
                    .addGroup(panelRegistrarVisitaLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(panelRegistrarVisitaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonVolverVisita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNuevaConsultaHistorialVisitas)
                        .addGap(302, 302, 302))))
        );
        panelRegistrarVisitaLayout.setVerticalGroup(
            panelRegistrarVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistrarVisitaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelRegistrarVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelClienteVisita)
                    .addComponent(txtClienteVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAliasVisita)
                    .addComponent(txtMascotaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBuscarVisitas))
                .addGap(18, 18, 18)
                .addComponent(buttonRegistrarVisita)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(panelRegistrarVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonVolverVisita)
                    .addComponent(buttonNuevaConsultaHistorialVisitas))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        tabbedPane.addTab("a.2", panelRegistrarVisita);

        getContentPane().add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 730, 550));

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
        documentoCliente = doc;

        //Buscar cliente en la BD. 
        Cliente cliente = clienteData.consultarClientesPorDNI(dni);

        //Devolver los datos del cliente. 
        if (cliente.getDocumento() != 0 && cliente.getEstadoCliente()== true) {
            
            txtNombre.setText(cliente.getNombre());
            txtApellido.setText(cliente.getApellido());
            txtDireccion.setText(cliente.getDireccion());
            txtContacto.setText(cliente.getContacto());
            txtTelefono.setText(String.valueOf(cliente.getTelefono()));

            //Cargar mascotas a la tabla 
            List<Mascota> mascotas = mascotaData.obtenerMascotasPorIdCliente(cliente.getIdCliente());

            DefaultTableModel model = (DefaultTableModel) mascotasCliente;
            model.setRowCount(0);

            for (Mascota mascota : mascotas) {
                model.addRow(new Object[]{
                    mascota.getAlias(),
                    mascota.getEspecie(),
                    mascota.getRaza(),
                    mascota.getSexo(),
                    mascota.getColor(),
                    mascota.getNacimiento(),});
            }

        } else {
            int nuevoCliente = JOptionPane.showConfirmDialog(this, "Cliente inactivo o inexistente. ¿Desea agregar un Nuevo Cliente?");

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
            String alias = (String) tablaMascota.getValueAt(filaSeleccionada, 0);

            int idMascota = mascotaData.obtenerIdMascotaPorAlias(alias);

            if (idMascota > 0) {
                String sexo = (String) tablaMascota.getValueAt(filaSeleccionada, 1);
                String especie = (String) tablaMascota.getValueAt(filaSeleccionada, 2);
                String raza = (String) tablaMascota.getValueAt(filaSeleccionada, 3);
                String color = (String) tablaMascota.getValueAt(filaSeleccionada, 4);
                LocalDate nacimiento = (LocalDate) tablaMascota.getValueAt(filaSeleccionada, 5);
                int dniCuidador = (int) tablaMascota.getValueAt(filaSeleccionada, 6);

                editandoMascota = true;
                FormularioMascota formularioMascota = new FormularioMascota(editandoMascota);
                formularioMascota.setDatosMascota(idMascota, alias, sexo, especie, raza, color, nacimiento, dniCuidador);
                formularioMascota.addMascotaEventListener(this);
                formularioMascota.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo encontrar la mascota con el alias especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_buttonGuardarCambiosActionPerformed

    //PERTENECE A LA TABLA/LISTA DE MASCOTAS/PACIENTES: 
    private void eliminarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPacienteActionPerformed
        //Seleccionar una lista de la tablaPacientes y clickear el boton eliminar
        int filaSeleccionada = tablaListaMascotas.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String alias = tablaMascota.getValueAt(filaSeleccionada, 0).toString();

            int idMascota = mascotaData.obtenerIdMascotaPorAlias(alias);

            if (idMascota != -1) {
                // Llamar al método eliminarMascota 
                mascotaData.eliminarMascota(idMascota);
                // Quitar la fila seleccionada de la tabla
                cargarMascotas();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna mascota con el alias: " + alias, "Error", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_eliminarPacienteActionPerformed

    //AQUI SE INDICA QUE AL HACER CLICK EN EL BOTON "VISITA" MUESTRA SU PANEL 
    private void buttonRegistraVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistraVisitaActionPerformed
        tabbedPane.setSelectedComponent(panelNuevaVisita);
        // Limpia los campos y la tabla
        txtDNICliente.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtNombre.setText("");
        txtContacto.setText("");
        DefaultTableModel model = (DefaultTableModel) tablaMascotasCliente.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_buttonRegistraVisitaActionPerformed

    //PERTENECE A LA TABLA/LISTA DE MASCOTAS/PACIENTES: 
    private void buttonCargarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCargarPacienteActionPerformed
        editandoMascota = false;
        FormularioMascota formularioMascota = new FormularioMascota(editandoMascota);
        formularioMascota.addMascotaEventListener(this);
        formularioMascota.setVisible(true);

    }//GEN-LAST:event_buttonCargarPacienteActionPerformed

    //PERTENECE A LA TABLA/LISTA DE MASCOTAS/PACIENTES: 
    private void buttonPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPacientesActionPerformed
        tabbedPane.setSelectedComponent(panelPacientes);
    }//GEN-LAST:event_buttonPacientesActionPerformed

    private void buttonOtraConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOtraConsultaActionPerformed
        //Se borran todos los campos del formulario Nueva Visita
        txtDNICliente.setText("");
        txtApellido.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtContacto.setText("");

        //Agregar para que vacie la tabla
        mascotasCliente.setRowCount(0);
    }//GEN-LAST:event_buttonOtraConsultaActionPerformed

    //PERTENECE AL PANEL CLIENTE:
    private void guardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarClienteActionPerformed
        editandoCliente = false;
        FormularioCliente formularioCliente = new FormularioCliente(editandoCliente);
        formularioCliente.addClienteEventListener(this); // Registro del oyente
        formularioCliente.setVisible(true);
    }//GEN-LAST:event_guardarClienteActionPerformed

    private void CargarCambiosClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarCambiosClienteActionPerformed
        int filaSeleccionada = tablaListaClientes.getSelectedRow();
        if (filaSeleccionada >= 0) {

            String apellido = (String) tablaCliente.getValueAt(filaSeleccionada, 0);
            String nombre = (String) tablaCliente.getValueAt(filaSeleccionada, 1);
            int documento = (int) tablaCliente.getValueAt(filaSeleccionada, 2);
            String direccion = (String) tablaCliente.getValueAt(filaSeleccionada, 3);
            long telefono = (long) tablaCliente.getValueAt(filaSeleccionada, 4);
            String contacto = (String) tablaCliente.getValueAt(filaSeleccionada, 5);

            editandoCliente = true;
            FormularioCliente formularioCliente = new FormularioCliente(editandoCliente);

            formularioCliente.setDatosCliente(apellido, nombre, documento, direccion, telefono, contacto);
            formularioCliente.addClienteEventListener(this); // Registro del oyente
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
                            
                        }
                        cargarClientes();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_eliminarClienteActionPerformed

    //PERTENECE AL PANEL TRATAMIENTOS
    private void AgregarTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarTratamientoActionPerformed
        editandoTratamiento = false;

        FormularioTratamiento formularioTratamiento = new FormularioTratamiento(editandoTratamiento);
        formularioTratamiento.addTratamientoEventListener(this);
        formularioTratamiento.setVisible(true);
    }//GEN-LAST:event_AgregarTratamientoActionPerformed

    //PERTENECE AL PANEL TRATAMIENTOS
    private void cambiosTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiosTratamientoActionPerformed
        int filaSeleccionada = tablaListaTratamientos.getSelectedRow();

        if (filaSeleccionada >= 0) {

            int codigo = (int) tablaTratamiento.getValueAt(filaSeleccionada, 0);
            String tipo = (String) tablaTratamiento.getValueAt(filaSeleccionada, 1);
            String descripcion = (String) tablaTratamiento.getValueAt(filaSeleccionada, 2);
            double importe = (double) tablaTratamiento.getValueAt(filaSeleccionada, 3);

            editandoTratamiento = true;
            FormularioTratamiento formularioTratamiento = new FormularioTratamiento(editandoTratamiento);

            formularioTratamiento.setDatosTratamiento(codigo, tipo, descripcion, importe);
            formularioTratamiento.addTratamientoEventListener(this); // Registro del oyente
            formularioTratamiento.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un tratamiento para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cambiosTratamientoActionPerformed

    private void buttonTratamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTratamientosActionPerformed
        tabbedPane.setSelectedComponent(panelTratamientos);
    }//GEN-LAST:event_buttonTratamientosActionPerformed

    private void buttonEliminarTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarTratamientoActionPerformed
        int filaSeleccionada = tablaListaTratamientos.getSelectedRow();

        if (filaSeleccionada >= 0) {
            int idTratamiento = (int) tablaListaTratamientos.getValueAt(filaSeleccionada, 0);

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

    private void buttonFacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFacturacionActionPerformed
        tabbedPane.setSelectedComponent(panelFacturacion);
    }//GEN-LAST:event_buttonFacturacionActionPerformed

    private void buttonHistorialVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHistorialVisitasActionPerformed

        int filaSeleccionada = tablaMascotasCliente.getSelectedRow();
        if (filaSeleccionada >= 0) {
            if (filaSeleccionada != -1) {
                String alias = (String) tablaMascotasCliente.getValueAt(filaSeleccionada, 0);
                int idMascota = mascotaData.obtenerIdMascotaPorAlias(alias);

                if (idMascota != -1) {
                    idMascotaSeleccionada = idMascota;
                    aliasMascotaSeleccionada = alias;

                    txtClienteVisita.setText(documentoCliente);
                    txtMascotaVisita.setText(aliasMascotaSeleccionada);

                    cargarTablaHistorial();

                    tabbedPane.setSelectedComponent(panelRegistrarVisita);

                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo encontrar la mascota seleccionada.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un paciente para registrar una visita.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonHistorialVisitasActionPerformed

    private void txtClienteVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteVisitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteVisitaActionPerformed

    private void buttonRegistrarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarVisitaActionPerformed

        String alias = txtMascotaVisita.getText();

        int idMascota = mascotaData.obtenerIdMascotaPorAlias(alias);

        formularioVisita = new FormularioVisita(VeterinariaHome.this, true, idMascota);
        formularioVisita.setLocationRelativeTo(null);

        formularioVisita.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                actualizarTablaHistorialVisitas();
            }
        });

        formularioVisita.setVisible(true);

    }//GEN-LAST:event_buttonRegistrarVisitaActionPerformed

    private void buttonNuevaConsultaHistorialVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNuevaConsultaHistorialVisitasActionPerformed
        txtMascotaVisita.setText("");
        txtClienteVisita.setText("");
        historialVisita.setRowCount(0);
        tablaHistorialVisita.setModel(historialVisita);
    }//GEN-LAST:event_buttonNuevaConsultaHistorialVisitasActionPerformed

    private void buttonVolverVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolverVisitaActionPerformed
        tabbedPane.setSelectedComponent(panelNuevaVisita);
    }//GEN-LAST:event_buttonVolverVisitaActionPerformed

    private void buttonPanelHistorialVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPanelHistorialVisitasActionPerformed
        tabbedPane.setSelectedComponent(panelRegistrarVisita);
        txtClienteVisita.setText("");
        txtMascotaVisita.setText("");
        DefaultTableModel model = (DefaultTableModel) tablaHistorialVisita.getModel();
        model.setRowCount(0);

    }//GEN-LAST:event_buttonPanelHistorialVisitasActionPerformed

    private void jToggleButtonClientesInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonClientesInactivosActionPerformed
        if (jToggleButtonClientesInactivos.isSelected()) {
            cargarClientesInactivos();
            tablaListaClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int filaSeleccionada = tablaListaClientes.getSelectedRow();
                        if (filaSeleccionada != -1) {
                            int documentoCliente = (int) tablaCliente.getValueAt(filaSeleccionada, 2);
                            int estadoCliente = clienteData.obtenerEstadoClientePorDocumento(documentoCliente);
                            if (estadoCliente == 0) {
                                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea activar este cliente?", "Confirmación", JOptionPane.YES_NO_OPTION);
                                if (respuesta == JOptionPane.YES_OPTION) {
                                    clienteData.activarCliente(documentoCliente);

                                    tablaCliente.removeRow(filaSeleccionada);
                                }

                            }
                        }
                    }
                }
            });

        } else {
            cargarClientes();
        }

    }//GEN-LAST:event_jToggleButtonClientesInactivosActionPerformed

    private void buttonBuscarVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarVisitasActionPerformed
        String alias = txtMascotaVisita.getText();
        String documento = txtClienteVisita.getText();
        if(!alias.isEmpty() && !documento.isEmpty()){
            int idMascota = mascotaData.obtenerIdMascotaPorAlias(alias);
            int idCliente = clienteData.obtenerIdClientePorDNI(Integer.parseInt(documento));

            if (idMascota != -1 && idCliente != -1) {
                List<Visita> visitas = visitaData.historialDeVisitasPorId(idMascota);
                DefaultTableModel model = (DefaultTableModel) tablaHistorialVisita.getModel();
                model.setRowCount(0);

                for (Visita visita : visitas) {
                    String tratamiento = obtenerNombreTratamientoPorId(visita.getIdTratamiento());
                    double nuevoPesoPromedio = mascotaData.actualizarPesoPromedio(idMascota);

                    model.addRow(new Object[]{
                        visita.getFechaVisita(),
                        visita.getSintomas(),
                        visita.getAfeccion(),
                        tratamiento,
                        visita.getDuracion(),
                        visita.getPesoActual(),
                        nuevoPesoPromedio
                    });

                    txtClienteVisita.setText(documento);
                    txtMascotaVisita.setText(alias);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Mascota o cliente no encontrados.", "Error", JOptionPane.ERROR_MESSAGE);
             }
        }else{
                JOptionPane.showMessageDialog(this, "Debe llenar ambos campos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_buttonBuscarVisitasActionPerformed

    private void jToggleButtonPacientesInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonPacientesInactivosActionPerformed
        if (jToggleButtonPacientesInactivos.isSelected()) {
            cargarMascotasInactivos();
            tablaListaMascotas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int filaSeleccionada = tablaListaMascotas.getSelectedRow();
                        if (filaSeleccionada != -1) {
                            String aliasMascota = (String) tablaMascota.getValueAt(filaSeleccionada, 0);
                            int idMascota = mascotaData.obtenerIdMascotaPorAlias(aliasMascota);
                            int estadoMascota = mascotaData.obtenerEstadoMascotaPorId(idMascota);
                            if (estadoMascota == 0) {
                                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea activar al paciente?", "Confirmación", JOptionPane.YES_NO_OPTION);
                                if (respuesta == JOptionPane.YES_OPTION) {
                                    mascotaData.activarMascota(idMascota);

                                    tablaMascota.removeRow(filaSeleccionada);
                                }

                            }
                        }
                    }
                }
            });

        } else {
            cargarMascotas();
        }
    }//GEN-LAST:event_jToggleButtonPacientesInactivosActionPerformed

    private void jbTerminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTerminarVentaActionPerformed
        double total = sumarTotal();
        jtFTotal.setText(String.valueOf(total));

        ///ACA HABRIA QUE PONER EL CODIGO PARA QUE GENERE EL PDF
    }//GEN-LAST:event_jbTerminarVentaActionPerformed

    private void jbAgregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarVentaActionPerformed
        try {
            double cantidad = Double.parseDouble(jTextCantidad.getText());
            String descripcion = jTextDescripcion.getText();
            double precioUnitario = Double.parseDouble(jTextPrecioUnitario.getText());
            double subTotal = cantidad * precioUnitario;
            tablaFacturacion.addRow(new Object[]{
                cantidad,
                descripcion,
                precioUnitario,
                subTotal});

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese números para Cantidad y Precio Unitario");
        }

        jTextCantidad.setText("");
        jTextDescripcion.setText("");
        jTextPrecioUnitario.setText("");
    }//GEN-LAST:event_jbAgregarVentaActionPerformed

    private void jcbClientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbClientesItemStateChanged
        String clienteSeleccionado = (String) jcbClientes.getSelectedItem();
        String apellido = "";
        String nombre = "";

        if (clienteSeleccionado != null) {
            String[] partes = clienteSeleccionado.split(",");
            if (partes.length == 2) {
                apellido = partes[0];
                nombre = partes[1];
            }
        }
        for (Cliente cliente : clienteData.consultarClientesPorNombreApellido(nombre, apellido)) {
            jtFDni.setText(String.valueOf(cliente.getDocumento()));
            jtFDomicilio.setText(String.valueOf(cliente.getDireccion()));
        }
    }//GEN-LAST:event_jcbClientesItemStateChanged

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
    private javax.swing.JButton buttonBuscarVisitas;
    private javax.swing.JButton buttonCargarPaciente;
    private javax.swing.JButton buttonClientes;
    private javax.swing.JButton buttonEliminarTratamiento;
    private javax.swing.JButton buttonFacturacion;
    private javax.swing.JButton buttonGuardarCambios;
    private javax.swing.JButton buttonHistorialVisitas;
    private javax.swing.JButton buttonNuevaConsultaHistorialVisitas;
    private javax.swing.JButton buttonOtraConsulta;
    private javax.swing.JButton buttonPacientes;
    private javax.swing.JButton buttonPanelHistorialVisitas;
    private javax.swing.JButton buttonRegistraVisita;
    private javax.swing.JButton buttonRegistrarVisita;
    private javax.swing.JButton buttonTratamientos;
    private javax.swing.JButton buttonVolverVisita;
    private javax.swing.JButton cambiosTratamiento;
    private javax.swing.JButton eliminarCliente;
    private javax.swing.JButton eliminarPaciente;
    private javax.swing.JButton guardarCliente;
    private javax.swing.JLabel jLCliente;
    private javax.swing.JLabel jLDni;
    private javax.swing.JLabel jLDomicilio;
    private javax.swing.JLabel jLFactura;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLMiFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTablaFacturacion;
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JTextField jTextDescripcion;
    private javax.swing.JTextField jTextPrecioUnitario;
    private javax.swing.JToggleButton jToggleButtonClientesInactivos;
    private javax.swing.JToggleButton jToggleButtonPacientesInactivos;
    private javax.swing.JButton jbAgregarVenta;
    private javax.swing.JButton jbTerminarVenta;
    private javax.swing.JComboBox<String> jcbClientes;
    private javax.swing.JComboBox<String> jcbSituacionFiscal;
    private javax.swing.JTextField jtFDni;
    private javax.swing.JTextField jtFDomicilio;
    private javax.swing.JTextField jtFNroFactura;
    private javax.swing.JTextField jtFTotal;
    private javax.swing.JLabel labelAliasVisita;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelClienteVisita;
    private javax.swing.JLabel labelContacto;
    private javax.swing.JLabel labelDNICliente;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelButtonsIzq;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelFacturacion;
    private javax.swing.JPanel panelNuevaVisita;
    private javax.swing.JPanel panelPacientes;
    private javax.swing.JPanel panelRegistrarVisita;
    private javax.swing.JPanel panelTratamientos;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tablaHistorialVisita;
    private javax.swing.JTable tablaListaClientes;
    private javax.swing.JTable tablaListaMascotas;
    private javax.swing.JTable tablaListaTratamientos;
    private javax.swing.JTable tablaMascotasCliente;
    private javax.swing.JTextField textFieldFechaNow;
    private javax.swing.JLabel titCliente;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtClienteVisita;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtDNICliente;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtMascotaVisita;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    // Método para cargar las mascotas en la tabla de pacientes
    private void cargarMascotas() {
        // Limpia la tabla
        tablaMascota.setRowCount(0);

        // Obtener la lista de mascotas desde la base de datos
        List<Mascota> mascotas = mascotaData.obtenerMascotasActivas();

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

    private void cargarMascotasInactivos() {
        tablaMascota.setRowCount(0);
        List<Mascota> mascotasInactivos = mascotaData.obtenerMascotasInactivas();
        Collections.sort(mascotasInactivos, Comparator.comparing(Mascota::getAlias));

        for (Mascota mascota : mascotasInactivos) {
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

    // Método para cargar los clientes en la tabla de clientes
    public void cargarClientes() {
        // Limpia la tabla
        tablaCliente.setRowCount(0);

        // Obtener la lista de clientes desde la base de datos
        List<Cliente> clientes = clienteData.obtenerClientesActivos();
        Collections.sort(clientes, Comparator.comparing(Cliente::getApellido));
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
            //  System.out.println(cliente);
            tablaCliente.addRow(fila);
        }
    }

    public void cargarClientesInactivos() {
        tablaCliente.setRowCount(0);

        // Obtener la lista de clientes inactivos desde la base de datos
        List<Cliente> clientesInactivos = clienteData.obtenerClientesInactivos();
        Collections.sort(clientesInactivos, Comparator.comparing(Cliente::getApellido));

        // Agregar cada cliente inactivo a la tabla
        for (Cliente cliente : clientesInactivos) {
            Object[] fila = {
                cliente.getApellido(),
                cliente.getNombre(),
                cliente.getDocumento(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getContacto()
            };
            tablaCliente.addRow(fila);
        }

    }

    //PERTENECE AL PANEL TRATAMIENTO 
    private void cargarTratamientos() {
        tablaTratamiento.setRowCount(0);
        List<Tratamiento> tratamientos = tratamientoData.obtenerTodosLosTratamientos();

        for (Tratamiento tratamiento : tratamientos) {
            Object[] fila = {
                tratamiento.getIdTratamiento(),
                tratamiento.getTipo(),
                tratamiento.getDescripcion(),
                tratamiento.getImporte()
            };
            tablaTratamiento.addRow(fila);
        }

    }

    private void cargarComboClientes() {
        for (Cliente obtenerClientes : clienteData.obtenerTodosLosClientes()) {
            String apellido = obtenerClientes.getApellido();
            String nombre = obtenerClientes.getNombre();
            String cliente = apellido + ", " + nombre;
            jcbClientes.addItem(cliente);
        }
        jcbClientes.setSelectedItem(-1);

    }

    private void cargarTablaHistorial() {

        if (idMascotaSeleccionada != -1) {
            double nuevoPesoPromedio = mascotaData.actualizarPesoPromedio(idMascotaSeleccionada);
            String alias = aliasMascotaSeleccionada;

            List<Visita> historialVisitas = visitaData.historialDeVisitasPorId(idMascotaSeleccionada);

            DefaultTableModel historialVisita = new DefaultTableModel();
            historialVisita.addColumn("Fecha visita");
            historialVisita.addColumn("Síntomas");
            historialVisita.addColumn("Afección");
            historialVisita.addColumn("Tratamiento");
            historialVisita.addColumn("Duracion");
            historialVisita.addColumn("Peso actual");
            historialVisita.addColumn("Peso Promedio");

            for (Visita visita : historialVisitas) {
//                int fila = tablaHistorialVisita.getSelectedRow();
//                if( fila != -1){
//                    int id = historialVisita.getValueAt(fila,0);
//                }

                Tratamiento tratamiento = tratamientoData.consultarTratamientoPorId(visita.getIdTratamiento());

                System.out.println("encoontro: " + tratamiento);
                historialVisita.addRow(new Object[]{
                    visita.getFechaVisita(),
                    visita.getSintomas(),
                    visita.getAfeccion(),
                    tratamiento.getTipo(),
                    visita.getDuracion(),
                    visita.getPesoActual(),
                    nuevoPesoPromedio
                });
                txtClienteVisita.setText(documentoCliente);
                txtMascotaVisita.setText(alias);
            }
            tablaHistorialVisita.setModel(historialVisita);

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado una mascota.");
        }
    }

    private String obtenerNombreTratamientoPorId(int idTratamiento) {
        Tratamiento tratamiento = tratamientoData.consultarTratamientoPorId(idTratamiento);
        if (tratamiento != null) {
            return tratamiento.getTipo();
        } else {
            return "Tratamiento desconocido";
        }
    }

    //ESTO ES DEL JDIALOG DEBE ACTUALIZAR LA TABLA AL CERRARSE
    private void actualizarTablaHistorialVisitas() {
        if (idMascotaSeleccionada != -1) {
            List<Visita> historialVisitas = visitaData.historialDeVisitasPorId(idMascotaSeleccionada);

            DefaultTableModel historialVisita = new DefaultTableModel();
            historialVisita.addColumn("Fecha visita");
            historialVisita.addColumn("Síntomas");
            historialVisita.addColumn("Afección");
            historialVisita.addColumn("Tratamiento");
            historialVisita.addColumn("Duración");
            historialVisita.addColumn("Peso actual");
            historialVisita.addColumn("Peso Promedio");

            for (Visita visita : historialVisitas) {
                String tratamiento = obtenerNombreTratamientoPorId(visita.getIdTratamiento());

                historialVisita.addRow(new Object[]{
                    visita.getFechaVisita(),
                    visita.getSintomas(),
                    visita.getAfeccion(),
                    tratamiento,
                    visita.getDuracion(),
                    visita.getPesoActual(), //      visita.getPesoPromedio()
                });
            }

            tablaHistorialVisita.setModel(historialVisita);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado una mascota.");
        }
    }

    //Método para generar un número de factura en el menú Facturación
    private static int generarNroFactura() {
        int facturaGenerada = nroFactura;
        nroFactura++;
        return facturaGenerada;
    }

    //Método para Sumar los subtotales de la tablaFactuacion
    private double sumarTotal() {
        double total = 0;
        DefaultTableModel modelo = (DefaultTableModel) jTablaFacturacion.getModel();

        for (int fila = 0; fila < modelo.getRowCount(); fila++) {
            double subtotal = (double) modelo.getValueAt(fila, 3); // El nro 3 es el índice de la columna de subtotales
            total += subtotal;
        }

        return total;
    }

}
