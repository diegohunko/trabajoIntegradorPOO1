/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.envases;

import controlador.Controlador;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Envase;
import modelo.TipoArticulo;

/**
 *
 * @author Diego Raul Fernandez
 */
public class VentanaEnvase extends javax.swing.JFrame {

    /**
     * Creates new form VentanaEnvase
     */
    private final JFrame vp;
    private final Controlador controlador;
    public VentanaEnvase(Controlador c, JFrame previo) {
        this.controlador = c;
        this.vp = previo;
        initComponents();
        /*Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width/2, height/2);*/
        setLocationRelativeTo(null);
        setVisible(true);
        this.vp.setVisible(false);
        limpiar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblIdEnvase = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        cmbxTipoArticulo = new javax.swing.JComboBox<>();
        btnNuevoEnvase = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEnvases = new javax.swing.JList();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        cmbxCriterio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Envases");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("ID Envase");

        jLabel2.setText("Capacidad");

        jLabel3.setText("Tipo Artículo:");

        lblIdEnvase.setText("jLabel4");

        txtCapacidad.setText("jTextField1");

        btnNuevoEnvase.setIcon(new javax.swing.ImageIcon("C:\\Users\\Diego Raul Fernandez\\Pictures\\UN_MAS.png")); // NOI18N
        btnNuevoEnvase.setText("Nuevo Envase");
        btnNuevoEnvase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEnvaseActionPerformed(evt);
            }
        });

        lstEnvases.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEnvases.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEnvasesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEnvases);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cmbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Capacidad", "Tipo Artículo", "Ambos" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEliminar)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(lblIdEnvase, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbxTipoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNuevoEnvase)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblIdEnvase))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbxTipoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(btnNuevoEnvase)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoEnvaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEnvaseActionPerformed
        // TODO add your handling code here:
        if (this.lstEnvases.isSelectionEmpty()) {
            TipoArticulo ta;
            ta = (TipoArticulo) this.cmbxTipoArticulo.getSelectedItem();
            if (!"".equals(this.txtCapacidad.getText()) && ta != null)  {
                try {
                    this.controlador.agregarNuevoEnvase(Double.parseDouble(this.txtCapacidad.getText()),
                            ta);
                    limpiar();
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, "El valor Ingresado NO ES un NÚMERO", "Error", JOptionPane.ERROR_MESSAGE);
                    this.txtCapacidad.setText("");
                    this.txtCapacidad.grabFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "DEBE seleccionar el tipo de artículo.", "Error", JOptionPane.ERROR_MESSAGE);
                this.cmbxTipoArticulo.grabFocus();
            }
        } else {
            limpiar();
        }
        
    }//GEN-LAST:event_btnNuevoEnvaseActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (!this.lstEnvases.isSelectionEmpty()){
            Envase viejo = (Envase) this.lstEnvases.getSelectedValue();
            this.controlador.eliminarEnvase(viejo);
            limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void lstEnvasesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEnvasesValueChanged
        // TODO add your handling code here:
        if (!this.lstEnvases.isSelectionEmpty()) {
            Envase ta = (Envase) this.lstEnvases.getSelectedValue();
            this.lblIdEnvase.setText(ta.getIdEnvase().toString());
            //System.out.println("en lstCHVal id: " + ta.getIdTipoArticulo());
            this.txtCapacidad.setText(ta.getCapacidad().toString());
            this.cmbxTipoArticulo.setSelectedItem(ta.getTipoArticulo());
        }
    }//GEN-LAST:event_lstEnvasesValueChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.vp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            TipoArticulo ta = (TipoArticulo) this.cmbxTipoArticulo.getSelectedItem();
            switch (this.cmbxCriterio.getSelectedIndex()) {
                case 0:
                    this.lstEnvases.setListData(this.controlador.buscarEnvaseCapacidad(Double.parseDouble(this.txtCapacidad.getText())).toArray());
                    break;
                case 1:
                    this.lstEnvases.setListData(this.controlador.buscarEnvaseTipo(ta).toArray());
                    break;
                case 2:
                    this.lstEnvases.setListData(this.controlador.buscarEnvaseCapacidadTipo(Double.parseDouble(this.txtCapacidad.getText()), ta).toArray());
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Revise los parámetros de netrada y de búsqueda", "Error", JOptionPane.ERROR_MESSAGE);
            this.txtCapacidad.grabFocus();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void limpiar(){
        this.lblIdEnvase.setText("");
        this.txtCapacidad.setText("");
        DefaultComboBoxModel modeloCombo;
        modeloCombo = new DefaultComboBoxModel(this.controlador.listarTipoArticulo().toArray());
        this.cmbxTipoArticulo.setModel(modeloCombo);
        this.cmbxTipoArticulo.setSelectedIndex(-1);
        this.lstEnvases.setListData(this.controlador.listarEnvases().toArray());
        this.lstEnvases.clearSelection();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Componentes de la ventana">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevoEnvase;
    private javax.swing.JComboBox<String> cmbxCriterio;
    private javax.swing.JComboBox<String> cmbxTipoArticulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdEnvase;
    private javax.swing.JList lstEnvases;
    private javax.swing.JTextField txtCapacidad;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
