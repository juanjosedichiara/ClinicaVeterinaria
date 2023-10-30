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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.swing.JTable;
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
    private String tratamiento;
    private String duracion;
    private double pesoActual;
    private Tratamiento trat;
    
    private TratamientoData tratamientoData;
    private VisitaData visitaData;
    

    public FormularioVisita(VeterinariaHome parent, boolean modal, int idMascota) {
        super(parent, modal);
        this.parentFrame=parent;
        this.idMascota = idMascota;
        this.tratamientoData= new TratamientoData();
        this.visitaData = new VisitaData();
        initComponents();
        
        List<Tratamiento> tratamientos = tratamientoData.obtenerTodosLosTratamientos();
        jComboBoxTratamientos.removeAllItems();
        for (Tratamiento tratamiento : tratamientos) {
            jComboBoxTratamientos.addItem(tratamiento.getTipo());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
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
        jButton2 = new javax.swing.JButton();
        buttonAceptar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        fVisita = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setText("Fecha visita");

        jLabel2.setText("Sintomas");

        jTextAreaSintomas.setColumns(20);
        jTextAreaSintomas.setRows(5);
        jScrollPane1.setViewportView(jTextAreaSintomas);

        jLabel3.setText("Afeccion");

        jTextAreaAfeccion.setColumns(20);
        jTextAreaAfeccion.setRows(5);
        jScrollPane2.setViewportView(jTextAreaAfeccion);

        jLabel4.setText("Tratamiento");

        jComboBoxTratamientos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTratamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTratamientosActionPerformed(evt);
            }
        });

        jLabel5.setText("Duracion");

        jLabel6.setText("Peso ");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/huellitas.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(fVisita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(113, 113, 113))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(buttonAceptar)
                        .addGap(68, 68, 68))
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxTratamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextPesoActual, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(jTextDuracion))))
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(fVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxTratamientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextPesoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(buttonAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.Date selectedDate = fVisita.getDate();

            if(selectedDate != null){
               LocalDate fechaVisita = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    
            sintomas = jTextAreaSintomas.getText();
            afeccion = jTextAreaAfeccion.getText();
            tratamiento = jComboBoxTratamientos.getSelectedItem().toString();
            duracion = jTextDuracion.getText();
            pesoActual = Double.parseDouble(jTextPesoActual.getText());

            int idTratamiento = tratamientoData.obtenerIdTratamientoPorTipo(tratamiento);
            Visita nuevaVisita = new Visita();
            nuevaVisita.setFechaVisita(fechaVisita);
            visitaData.registrarVisita(new Visita(), idMascota,idTratamiento);
            }
            this.dispose();
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxTratamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTratamientosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTratamientosActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private com.toedter.calendar.JDateChooser fVisita;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxTratamientos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextArea jTextAreaAfeccion;
    private javax.swing.JTextArea jTextAreaSintomas;
    private javax.swing.JTextField jTextDuracion;
    private javax.swing.JTextField jTextPesoActual;
    // End of variables declaration//GEN-END:variables

}
