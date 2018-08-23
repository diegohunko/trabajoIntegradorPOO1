/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.pedidos;

import controlador.Controlador;
import java.text.ParseException;
import java.text.DateFormat;
import javax.swing.JFrame;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vistas.entregas.VentanaEntrega;
import modelo.Pedido;
import modelo.Entrega;
import java.util.Calendar;
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
    private final Pedido pedidoExtranjero;
    
    
    public VentanaNuevoPedido(Controlador c, JFrame previo) {
        this.controlador = c;
        this.previo = previo;
        this.pedidoExtranjero = null;
        initComponents();
        //this.lblIdPedido.setVisible(true);
        //this.lblIdPedido.setText("HOLA");
    }
    
    public VentanaNuevoPedido(Controlador c, JFrame previo, Pedido p){
        this.controlador = c;
        this.previo = previo;
        this.pedidoExtranjero = p;
        
        String titulo;
        titulo = "Modificación de Pedido: " + Long.toString(this.pedidoExtranjero.getIdPedido());
        initComponents();
        //Cambiar el titulo de la ventana
        this.setTitle(titulo);
        
        //Cargar los elementos de la ventana.
        this.lblIdPedido.setText(Long.toString(this.pedidoExtranjero.getIdPedido()));
        this.txtCuilPropietario.setText(this.pedidoExtranjero.getPropietario().getCuit());
        this.txtTotalDeEntregas.setText(Integer.toString(this.pedidoExtranjero.getTotalDeEntregas()));
        this.cmbxPeriodicidad.setSelectedItem(this.pedidoExtranjero.getPeriodicidad());
        this.lstFechasEntregas.setListData(this.pedidoExtranjero.getEntregas().toArray());
        this.txtFechaPrimerEntrega.setText(this.pedidoExtranjero.getEntregaInicial().toString());
        //DESACTIVAR O DESHABILITAR LOSS COMPONENTES PARA QUE NO SEAN MODIFICADOS.
        freezeForm();
        
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
        txtTotalDeEntregas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbxPeriodicidad = new javax.swing.JComboBox<>();
        btnNuevoPedido = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCuilPropietario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFechasEntregas = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        lblIdPedido = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFechaPrimerEntrega = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NUEVO PEDIDO");

        jLabel1.setText("CUIL/CUIT Cliente");

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

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Fechas de entrega para el pedido");

        lblIdPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel9.setText("ID Pedido");

        txtFechaPrimerEntrega.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaPrimerEntrega.setToolTipText("dd/mm/aaaa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(227, 227, 227))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                        .addComponent(lblIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCuilPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbxPeriodicidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTotalDeEntregas, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtFechaPrimerEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(btnNuevoPedido)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCuilPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtFechaPrimerEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTotalDeEntregas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(cmbxPeriodicidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnNuevoPedido)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        lblIdPedido.getAccessibleContext().setAccessibleName("Id");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPedidoActionPerformed
        try {
            Long codigo = 0x0L;
            final Calendar marcaTemporal;
            marcaTemporal = Calendar.getInstance();
            //GregorianCalendar fp;
            Date fechaPedido;
            /*fp = new GregorianCalendar(Integer.parseInt(this.cmbxAnio.getSelectedItem().toString()),
            this.cmbxMes.getSelectedIndex(),
            Integer.parseInt(this.cmbxDia.getSelectedItem().toString()));*/
            fechaPedido = this.controlador.dateParser(this.txtFechaPrimerEntrega.getText());//fp.getTime();
            int totalEntregas;
            totalEntregas = Integer.parseInt(this.txtTotalDeEntregas.getText());
            char periodicidad = 'x';
            
            switch (this.cmbxPeriodicidad.getSelectedItem().toString()){
            case "Unica vez":
                if (Integer.parseInt(this.txtTotalDeEntregas.getText()) != 1){
                    JOptionPane.showMessageDialog(null, "Que hacemo??!!!"+
                        " 1 entrega", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    periodicidad = 'U';
                }
                break;
            case "Semanalmente":
                periodicidad = 'S';
                break;
            case "Mensualmente":
                periodicidad = 'M';         
                break;
            default:
                JOptionPane.showMessageDialog(null, "Seleccione periodicidad"+
                        " de entrega", "Error", JOptionPane.ERROR_MESSAGE);
                this.cmbxPeriodicidad.grabFocus();
                return;
            }
            codigo = this.controlador.nuevoPedido(this.txtCuilPropietario.getText(), 
                    fechaPedido, 
                    totalEntregas,
                    periodicidad,
                    marcaTemporal);
            if (codigo == 0x0L) {
                JOptionPane.showMessageDialog(null, "NULL", "Error", JOptionPane.ERROR_MESSAGE);
                this.txtCuilPropietario.grabFocus();
            }else if (codigo == 0xffffffffffffffffL){
                JOptionPane.showMessageDialog(null, "Argumento Ilegal", "Error", JOptionPane.ERROR_MESSAGE);
                this.txtCuilPropietario.grabFocus();
            }else if(codigo == 0xfffffffffffffffeL){
                JOptionPane.showMessageDialog(null, "no se encuentran resultados", "Error", JOptionPane.ERROR_MESSAGE);
                this.txtCuilPropietario.grabFocus();
            }else if(codigo == 0xfffffffffffffffdL){
                JOptionPane.showMessageDialog(null, "Puntero a null", "Error", JOptionPane.ERROR_MESSAGE);
                this.txtCuilPropietario.grabFocus();
            }else if(codigo == 0xfffffffffffffffcL){
                JOptionPane.showMessageDialog(null, "Error conocido solo por Dios", "Error", JOptionPane.ERROR_MESSAGE);
                this.txtCuilPropietario.grabFocus();
            }else{
                this.lblIdPedido.setText(Long.toString(codigo));
                this.lstFechasEntregas.setListData(fechasDeEntrega(fechaPedido, codigo,
                    totalEntregas,
                    periodicidad));
            }
            this.btnNuevoPedido.setEnabled(false);
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnNuevoPedidoActionPerformed

    private void lstFechasEntregasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFechasEntregasValueChanged
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_lstFechasEntregasValueChanged

    private void lstFechasEntregasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstFechasEntregasMouseClicked
        // TODO add your handling code here:  
         //SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        if (this.pedidoExtranjero == null) {
            VentanaEntrega ve;
            Pedido p;
            try {
                p = this.controlador.buscarPedido(Long.parseLong(this.lblIdPedido.getText()));
                ve = new VentanaEntrega(this.controlador, this,
                        this.controlador.dateParser((String) this.lstFechasEntregas.getSelectedValue()),
                        p);
                
                ve.setVisible(true);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo Parsear la fecha =(", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                
            }
        } else {
            Entrega unaEntrega = (Entrega) this.lstFechasEntregas.getSelectedValue();
            VentanaEntrega ve1;
            ve1 = new VentanaEntrega(this.controlador, this, this.pedidoExtranjero, unaEntrega);
            ve1.setVisible(true);
        }
    }//GEN-LAST:event_lstFechasEntregasMouseClicked

    private String[] fechasDeEntrega(Date primerFecha, Long codigoPedido,
            int totEnt,
            char period){
        String[] aListFechas; 
        aListFechas = new String[totEnt];
        try{
        //GregorianCalendar primerFecha = new GregorianCalendar(anio, mes, dia);
        Calendar d = Calendar.getInstance();
        d.setTime(primerFecha);
        DateFormat df = DateFormat.getDateInstance();
        aListFechas[0]= df.format(d.getTime());
        this.controlador.nuevaEntrega(codigoPedido, d.getTime());
        switch (period){
            case 'M':
                for (int i=1; i < totEnt; i++){
                    d.add(Calendar.DATE, 30);
                    //d = primerFecha.getTime();
                    aListFechas[i] = df.format(d.getTime());
                    this.controlador.nuevaEntrega(codigoPedido, d.getTime());
                }
                break;
            case 'S':
                for (int i=1; i < totEnt; i++){
                    d.add(Calendar.DATE, 7);
                    //d = primerFecha.getTime();
                    aListFechas[i] = df.format(d.getTime());
                    this.controlador.nuevaEntrega(codigoPedido, d.getTime());
                }
                break;
            case 'U':
                //this.controlador.nuevaEntrega(Long.parseLong(this.lblIdPedido.getText()), d);
                break;
        }

        return aListFechas;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw e;//return aListFechas;
        }
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        // TODO add your handling code here:
        this.previo.setVisible(true);
        this.dispose();
    }  
    
    private void freezeForm(){
        this.txtCuilPropietario.setEditable(false);
        this.txtTotalDeEntregas.setEditable(false);
        this.btnNuevoPedido.setEnabled(false);
        this.cmbxPeriodicidad.setEnabled(false);
        this.txtFechaPrimerEntrega.setEditable(false);
    }

     // <editor-fold defaultstate="collapsed" desc="Elementos de la ventana">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoPedido;
    private javax.swing.JComboBox<String> cmbxPeriodicidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdPedido;
    private javax.swing.JList lstFechasEntregas;
    private javax.swing.JTextField txtCuilPropietario;
    private javax.swing.JTextField txtFechaPrimerEntrega;
    private javax.swing.JTextField txtTotalDeEntregas;
    // End of variables declaration//GEN-END:variables

     // </editor-fold>

}
