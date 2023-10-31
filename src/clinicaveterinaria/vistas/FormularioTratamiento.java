package clinicaveterinaria.vistas;

import accesoDatos.TratamientoData;
import clinicaveterinaria.entidades.Tratamiento;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import javax.swing.JOptionPane;

public class FormularioTratamiento extends javax.swing.JFrame {

    private boolean editandoTratamiento;
    private TratamientoData tratamientoData;
    private Tratamiento tratamiento;
    
    
    private List<TratamientoEventListener> listeners = new ArrayList<>();

    public void addTratamientoEventListener(TratamientoEventListener listener) {
        listeners.add(listener);
    }

    private void notificarActualizacionTratamiento() {
        for (TratamientoEventListener listener : listeners) {
            listener.tratamientoActualizado();
        }
    }

    public FormularioTratamiento(boolean editandoTratamiento) {
        initComponents();

        this.editandoTratamiento = editandoTratamiento;
        tratamientoData = new TratamientoData();
        tratamiento = new Tratamiento();
        
        this.setLocationRelativeTo(null);

        txtCodigoTratamiento.setVisible(editandoTratamiento);
        txtCodigoTratamiento.setEnabled(false);
        verificarEstado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextArea();
        buttonCancelar = new javax.swing.JButton();
        buttonConfirmar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JLabel();
        txtCodigoTratamiento = new javax.swing.JTextField();

        setTitle("Clinica veterinaria-Formulario de tratamientos");

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Tipo:");

        jLabel3.setText("Importe:");

        jLabel2.setText("Descripción:");

        txtArea.setColumns(20);
        txtArea.setLineWrap(true);
        txtArea.setRows(5);
        txtArea.setWrapStyleWord(true);
        txtArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/huellitas.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        buttonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/huellitas.png"))); // NOI18N
        buttonConfirmar.setText("Confirmar");
        buttonConfirmar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/For_Tratamiento.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clinicaveterinaria/recursos/For_Tratamiento.png"))); // NOI18N

        labelCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCodigo.setText("CÓDIGO: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(buttonConfirmar)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtArea)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelCodigo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCodigoTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                            .addComponent(txtImporte, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))))
                                .addGap(8, 8, 8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(labelCodigo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCodigoTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonConfirmar)
                    .addComponent(buttonCancelar))
                .addGap(21, 21, 21))
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmarActionPerformed
        
        String tipo = txtTipo.getText();
        String descripcion = txtArea.getText();
        String importestr = txtImporte.getText();

        
        double importe = Double.parseDouble(importestr);
        
        if (importe >= 100000) {
            JOptionPane.showMessageDialog(this, "El importe no debe superar los 99999.99", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(tipo.isEmpty() || descripcion.isEmpty() || importestr.isEmpty()) {
           JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
           return;
        }
            
                if (editandoTratamiento) {
                   // no se, deberia obtener el id. tratamiento = new Tratamiento(int codigo);
                    tratamientoData.modificarTratamiento(tratamiento);
                    System.out.println("ingresa"+ tratamiento);
                    JOptionPane.showMessageDialog(this, "Tratamiento modificado con éxito");
                
                } else {
                    
                Tratamiento tratamientoNuevo = new Tratamiento();
                tratamientoNuevo.setTipo(tipo);
                tratamientoNuevo.setDescripcion(descripcion);
                tratamientoNuevo.setImporte(importe);
                
                tratamientoData.agregarTratamiento(tratamientoNuevo);
                JOptionPane.showMessageDialog(this, "Tratamiento cargado");
                }
                
                notificarActualizacionTratamiento();
                this.dispose();
            
    
    }//GEN-LAST:event_buttonConfirmarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtCodigoTratamiento;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

    public void verificarEstado(){

        if(editandoTratamiento){
            System.out.println("id:"+tratamiento);
            int codigo;
            labelCodigo.setVisible(true);
            txtCodigoTratamiento.setVisible(true);
            txtCodigoTratamiento.setEnabled(false);
        }else{
            if(!editandoTratamiento){
                System.out.println("nuevo"+tratamiento);
            labelCodigo.setVisible(false);
            txtCodigoTratamiento.setVisible(false);
            txtCodigoTratamiento.setEnabled(false);
         }
        }
    }
    
    public void setDatosTratamiento( int codigo, String tipo, String descripcion, double importe){
        txtCodigoTratamiento.setText(String.valueOf(codigo));
        txtTipo.setText(tipo);
        txtArea.setText(descripcion);
        txtImporte.setText(String.valueOf(importe));
    }
    
    public interface TratamientoEventListener extends EventListener {

        void tratamientoActualizado();
    }
}
