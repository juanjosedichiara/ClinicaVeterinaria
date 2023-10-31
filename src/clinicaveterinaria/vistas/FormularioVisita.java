/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicaveterinaria.vistas;

import accesoDatos.TratamientoData;
import accesoDatos.VisitaData;
import clinicaveterinaria.entidades.Tratamiento;
import clinicaveterinaria.entidades.Visita;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author borch
 */
public class FormularioVisita extends javax.swing.JDialog {

    private int idMascota;
    private VeterinariaHome parentFrame;
    private LocalDate fechaVisita;
    private String sintomas;
    private String afeccion;
    private String tratamientoString;
    private String duracion;
    private double pesoActual;
    private String formaDePago;
    private String nombreMascota;
    private Tratamiento trat;

    private TratamientoData tratamientoData;
    private VisitaData visitaData;

    public FormularioVisita(VeterinariaHome parent, boolean modal, int idMascota) {
        super(parent, modal);
        initComponents();
        this.parentFrame = parent;
        this.idMascota = idMascota;
        this.tratamientoData = new TratamientoData();
        this.visitaData = new VisitaData();

        cargarComboTratamientos();
        cargarComboFormasDePago();
        
        labelNombreMascota.setText(nombreMascota); //No esta tomando el nombre de la mascota
        
    }

    public FormularioVisita() {
        labelNombreMascota.setText(nombreMascota);
    }


    public LocalDate getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(LocalDate fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public JTextArea getjTextAreaAfeccion() {
        return jTextAreaAfeccion;
    }

    public void setjTextAreaAfeccion(JTextArea jTextAreaAfeccion) {
        this.jTextAreaAfeccion = jTextAreaAfeccion;
    }

    public JTextArea getjTextAreaSintomas() {
        return jTextAreaSintomas;
    }

    public void setjTextAreaSintomas(JTextArea jTextAreaSintomas) {
        this.jTextAreaSintomas = jTextAreaSintomas;
    }

    public JTextField getjTextDuracion() {
        return jTextDuracion;
    }

    public void setjTextDuracion(JTextField jTextDuracion) {
        this.jTextDuracion = jTextDuracion;
    }

    public JDateChooser getJdFechaVisita() {
        return jdFechaVisita;
    }

    public void setJdFechaVisita(JDateChooser jdFechaVisita) {
        this.jdFechaVisita = jdFechaVisita;
    }

    public JLabel getLabelNombreMascota() {
        return labelNombreMascota;
    }

    public void setLabelNombreMascota(String nombreMascota) {
        //this.labelNombreMascota = labelNombreMascota;
        this.nombreMascota = nombreMascota;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        labelNombreMascota = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSintomas = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaAfeccion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxTratamientos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextDuracion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextPesoActual = new javax.swing.JTextField();
        buttonCancelar = new javax.swing.JButton();
        buttonAceptar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcbFormasDePago = new javax.swing.JComboBox<>();
        jdFechaVisita = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        labelNombreMascota.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNombreMascota.setForeground(new java.awt.Color(102, 102, 102));
        labelNombreMascota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombreMascota.setText(labelNombreMascota.getName());

        jLabel1.setText("Fecha visita");

        jLabel2.setText("Sintomas:");

        jTextAreaSintomas.setColumns(1);
        jTextAreaSintomas.setRows(2);
        jScrollPane1.setViewportView(jTextAreaSintomas);

        jLabel3.setText("Afeccion:");

        jTextAreaAfeccion.setColumns(1);
        jTextAreaAfeccion.setRows(2);
        jScrollPane2.setViewportView(jTextAreaAfeccion);

        jLabel4.setText("Tratamiento:");

        jComboBoxTratamientos.setMaximumRowCount(10);

        jLabel5.setText("Duracion:");

        jLabel6.setText("Peso Actual:");

        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/huellitas.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        buttonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/huellitas.png"))); // NOI18N
        buttonAceptar.setText("Guardar");
        buttonAceptar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/tratamiento.png"))); // NOI18N

        jLabel8.setText("día/s");

        jLabel9.setText("Forma de Pago:");

        jcbFormasDePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "... $ ...", "Contado - Efectivo", "Cuenta Corriente", "T. Débito", "T.Crédito", "Billetera Virtual", "Transferencia Bancaria", "Cheque", " " }));

        jdFechaVisita.setMinimumSize(new java.awt.Dimension(40, 20));
        jdFechaVisita.setName("jdFechaVisita"); // NOI18N
        jdFechaVisita.setNextFocusableComponent(jTextAreaSintomas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(buttonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonAceptar)
                        .addGap(68, 68, 68))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextDuracion)
                                    .addComponent(jTextPesoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jcbFormasDePago, 0, 150, Short.MAX_VALUE))
                                .addGap(20, 20, 20))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxTratamientos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jdFechaVisita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(57, 57, 57)
                                        .addComponent(labelNombreMascota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(21, 21, 21)))))
                        .addGap(30, 30, 30)))
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jdFechaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelNombreMascota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTratamientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jTextPesoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbFormasDePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancelar)
                    .addComponent(buttonAceptar))
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed

        if (jdFechaVisita.isEnabled()) {
            String fechaVisitaString = jdFechaVisita.getDate().toString();
            fechaVisita = LocalDate.now();
            jdFechaVisita.getComponents();
            System.out.println("Fecha: " + jdFechaVisita.getDate());

            sintomas = jTextAreaSintomas.getText();
            afeccion = jTextAreaAfeccion.getText();
            tratamientoString = jComboBoxTratamientos.getSelectedItem().toString();
            duracion = jTextDuracion.getText();
            formaDePago = jcbFormasDePago.getSelectedItem().toString();
            pesoActual = Double.parseDouble(jTextPesoActual.getText());

            int idTratamiento = tratamientoData.obtenerIdTratamientoPorTipo(tratamientoString);

            Visita nuevaVisita = new Visita(idTratamiento, fechaVisita, formaDePago, sintomas, afeccion, pesoActual, duracion);

            visitaData.registrarVisita(nuevaVisita, idMascota, idTratamiento);

            JOptionPane.showMessageDialog(null, "Visita Agregada Correctamente");

        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar una fecha válida. Formato: dd/MM/yyyy");
        }
        this.dispose();
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea cancelar la Visita?");
        if (respuesta == 0) {
            this.dispose();
        }


    }//GEN-LAST:event_buttonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JComboBox<String> jComboBoxTratamientos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextArea jTextAreaAfeccion;
    private javax.swing.JTextArea jTextAreaSintomas;
    private javax.swing.JTextField jTextDuracion;
    private javax.swing.JTextField jTextPesoActual;
    private javax.swing.JComboBox<String> jcbFormasDePago;
    public com.toedter.calendar.JDateChooser jdFechaVisita;
    private javax.swing.JLabel labelNombreMascota;
    // End of variables declaration//GEN-END:variables

    private void cargarComboTratamientos() {
        List<Tratamiento> tratamientos = tratamientoData.obtenerTodosLosTratamientos();

        for (Tratamiento tratamiento : tratamientos) {
            if (tratamiento.getEstadoTratamiento() == true) { //Este condicional verifica que sólo se carguen los tratamientos ACTIVOS
                jComboBoxTratamientos.addItem(tratamiento.getTipo());
            }

        }
    }

    private void cargarComboFormasDePago() {
        jcbFormasDePago.getModel();
    }

}
