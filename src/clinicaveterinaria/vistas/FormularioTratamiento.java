package clinicaveterinaria.vistas;

import accesoDatos.TratamientoData;
import clinicaveterinaria.entidades.Tratamiento;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import javax.swing.JOptionPane;

public class FormularioTratamiento extends javax.swing.JFrame {

    private boolean modoNuevo;
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

    public FormularioTratamiento(boolean modoNuevo) {
        initComponents();

        this.modoNuevo = modoNuevo;
        tratamientoData = new TratamientoData();
        this.setLocationRelativeTo(null);
        verificarEstado(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        buttonConfirmar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        chekBoxActivo = new javax.swing.JCheckBox();

        setTitle("Clinica veterinaria-Formulario de tratamientos");

        jLabel1.setText("Tipo:");

        jLabel2.setText("Descripción:");

        jLabel3.setText("Importe:");

        txtArea.setColumns(20);
        txtArea.setLineWrap(true);
        txtArea.setRows(5);
        txtArea.setWrapStyleWord(true);
        txtArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(txtArea);

        buttonConfirmar.setText("Confirmar");
        buttonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        chekBoxActivo.setText("Activo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(buttonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonConfirmar)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(chekBoxActivo))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(chekBoxActivo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonConfirmar)
                    .addComponent(buttonCancelar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmarActionPerformed
        String tipo = txtTipo.getText();
        String descripcion = txtArea.getText();
        String importestr = txtImporte.getText();

        if (tipo.isEmpty() || descripcion.isEmpty() || importestr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double importe = Double.parseDouble(importestr);
        if (importe >= 100000) {
            JOptionPane.showMessageDialog(this, "El importe no debe superar los 99999.99", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un nuevo tratamiento y establecer sus atributos
        Tratamiento nuevoTratamiento = new Tratamiento();
        nuevoTratamiento.setTipo(tipo);
        nuevoTratamiento.setDescripcion(descripcion);
        nuevoTratamiento.setImporte(importe);

        //Condicional para cambiar el Estado del Tratamiento
        if (chekBoxActivo.isSelected()) {
            nuevoTratamiento.setEstadoTratamiento(true);
        } else {
            nuevoTratamiento.setEstadoTratamiento(false);
        }

        if (modoNuevo) {

            tratamientoData.agregarTratamiento(nuevoTratamiento);
            notificarActualizacionTratamiento();
            JOptionPane.showMessageDialog(null, "Tratamiento cargado");
        } else {
            nuevoTratamiento.setIdTratamiento(tratamientoData.obtenerIdTratamientoPorTipo(tipo));
            tratamientoData.modificarTratamiento(nuevoTratamiento);
            notificarActualizacionTratamiento();
            JOptionPane.showMessageDialog(null, "Tratamiento modificado con éxito");
        }

        this.dispose();

    }//GEN-LAST:event_buttonConfirmarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonConfirmar;
    private javax.swing.JCheckBox chekBoxActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

    public void verificarEstado(boolean modoNuevo) {
        if (modoNuevo) {
            // Modo nuevo: Vaciar el formulario
            txtTipo.setText("");
            txtArea.setText("");
            txtImporte.setText("");
        } else {
            // Modo edición: Cargar datos del tratamiento seleccionado
            if (tratamiento != null) {
                txtTipo.setText(tratamiento.getTipo());
                txtArea.setText(tratamiento.getDescripcion());
                txtImporte.setText(String.valueOf(tratamiento.getImporte()));
                chekBoxActivo.isSelected();
            } else {
                JOptionPane.showMessageDialog(this, "Error al cargar el tratamiento.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    void setTxtTipo(String tipo) {
        txtTipo.setText(tipo);
    }

    void setTxtArea(String descripcion) {
        txtArea.setText(descripcion);
    }

    void setChekBoxActivo(boolean estado) {
        if (estado) {
            chekBoxActivo.isSelected();
        }
    }

    void setTxtImporte(double importe) {
        txtImporte.setText(String.valueOf(importe));
    }

    String getTxtTipo() {
        return txtTipo.getText();
    }

    String getTxtArea() {
        return txtArea.getText();
    }

    double getImporte() {
        return Double.parseDouble(txtImporte.getText());
    }

    boolean getEstado() {
        return chekBoxActivo.isSelected();
    }

    public interface TratamientoEventListener extends EventListener {

        void tratamientoActualizado();
    }
}
