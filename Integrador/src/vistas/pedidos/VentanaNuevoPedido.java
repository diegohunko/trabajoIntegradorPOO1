/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.pedidos;

import controlador.Controlador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import vistas.entregas.VentanaEntrega;
import modelo.Pedido;
/**
 *
 * @author Diego Raul Fernandez
 */
public class VentanaNuevoPedido extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPedido
     */
    private final JFrame previo;
    private final Controlador controlador;
    public VentanaNuevoPedido(Controlador c, JFrame previo) {
        this.controlador = c;
        this.previo = previo;
        initComponents();
        this.lblIdPedido.setVisible(true);
        this.lblIdPedido.setText("HOLA");
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
        cmbxDia = new javax.swing.JComboBox<>();
        cmbxMes = new javax.swing.JComboBox<>();
        cmbxAnio = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtTotalDeEntregas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbxPeriodicidad = new javax.swing.JComboBox<>();
        btnNuevoPedido = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCuilPropietario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFechasEntregas = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblIdPedido = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NUEVO PEDIDO");

        jLabel1.setText("CUIL/CUIT Cliente");

        cmbxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cmbxAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2017", "2018" }));

        jLabel2.setText("Fecha primer entrega");

        jLabel3.setText("Total de entregas");

        cmbxPeriodicidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciones periodicidad", "Unica vez", "Semanalmente", "Mensualmente" }));

        btnNuevoPedido.setText("Crear pedido");
        btnNuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPedidoActionPerformed(evt);
            }
        });

        jLabel4.setText("Periodicidad");

        txtCuilPropietario.setToolTipText("Ingrese CUIL/CUIT sin guiones ni puntos");

        lstFechasEntregas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "18/12/2017", "19/01/2018", "18/02/2018" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstFechasEntregas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstFechasEntregas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstFechasEntregasMouseClicked(evt);
            }
        });
        lstFechasEntregas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFechasEntregasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstFechasEntregas);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Día");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Mes");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Año");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Fechas de entrega para el pedido");

        lblIdPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIdPedido.setText("Fechas");

        jLabel9.setText("ID Pedido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(btnNuevoPedido)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCuilPropietario)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(cmbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(cmbxAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(59, 59, 59)
                                .addComponent(txtTotalDeEntregas, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(87, 87, 87)
                                .addComponent(cmbxPeriodicidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(lblIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(txtCuilPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbxAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(txtTotalDeEntregas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel4))
                            .addComponent(cmbxPeriodicidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(btnNuevoPedido)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPedidoActionPerformed
        // TODO add your handling code here:
        Long codigo = null;
        SimpleDateFormat formatoFecha;
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        //char periodicidad = this.cmbxPeriodicidad.getSelectedItem().toString();
        String fecha; 
        fecha = this.cmbxDia.getSelectedItem().toString() + 
                "/" + this.cmbxMes.getSelectedItem().toString() +
                "/" + this.cmbxAnio.getSelectedItem().toString();
        try{
            codigo = this.controlador.nuevoPedido(this.txtCuilPropietario.getText(), 
                    formatoFecha.parse(fecha), 
                    Integer.parseInt(this.txtTotalDeEntregas.getText()),
                    (char) this.cmbxPeriodicidad.getSelectedIndex());
            
        }catch(ParseException ex){
            
        }finally{
            if (codigo != -1L) {
                this.lblIdPedido.setText(codigo.toString());
            }
        }
        
        
    }//GEN-LAST:event_btnNuevoPedidoActionPerformed

    private void lstFechasEntregasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFechasEntregasValueChanged
        // TODO add your handling code here:
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        VentanaEntrega ve;
        Pedido p;
        p = this.controlador.buscarPedido(Long.parseLong(this.lblIdPedido.getText()));
        try {
            ve = new VentanaEntrega(this.controlador, this, 
                    formatoFecha.parse(this.lstFechasEntregas.getSelectedValue()),
                    p); //? ver como pasar el pedido al que corresponde la entrega.
            
            ve.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(VentanaNuevoPedido.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//GEN-LAST:event_lstFechasEntregasValueChanged

    private void lstFechasEntregasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstFechasEntregasMouseClicked
        // TODO add your handling code here:  
    }//GEN-LAST:event_lstFechasEntregasMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        // TODO add your handling code here:
        this.previo.setVisible(true);
        this.dispose();
    }                                  

     // <editor-fold defaultstate="collapsed" desc="Elementos de la ventana">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoPedido;
    private javax.swing.JComboBox<String> cmbxAnio;
    private javax.swing.JComboBox<String> cmbxDia;
    private javax.swing.JComboBox<String> cmbxMes;
    private javax.swing.JComboBox<String> cmbxPeriodicidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdPedido;
    private javax.swing.JList<String> lstFechasEntregas;
    private javax.swing.JTextField txtCuilPropietario;
    private javax.swing.JTextField txtTotalDeEntregas;
    // End of variables declaration//GEN-END:variables

     // </editor-fold>

}
