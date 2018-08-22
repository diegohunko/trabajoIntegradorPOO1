/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.pedidos;
import controlador.Controlador;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Pedido_;
/**
 *
 * @author Acer
 */
public class ABMPedidos extends javax.swing.JFrame {

    /**
     * Creates new form ABMPedidos
     */
    private final Controlador contro;
    private final JFrame previo;
    public ABMPedidos(Controlador c, JFrame p) {
        this.contro = c;
        this.previo = p;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMostrarPedidos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstVistaPedidos = new javax.swing.JList();
        cmbxCriterio = new javax.swing.JComboBox<>();
        txtCriterio = new javax.swing.JTextField();
        btnBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar la felicidad!!! o pedidos.");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnMostrarPedidos.setText("Mostrar");
        btnMostrarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarPedidosActionPerformed(evt);
            }
        });

        lstVistaPedidos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstVistaPedidosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstVistaPedidos);

        cmbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "CUIT", "Fecha" }));

        btnBorrar.setText("Borar?");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addComponent(btnMostrarPedidos)
                        .addGap(16, 16, 16)
                        .addComponent(btnBorrar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMostrarPedidos)
                        .addComponent(btnBorrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarPedidosActionPerformed
        // TODO add your handling code here:
        //
        try{
            
            if (!"".equals(this.txtCriterio.getText())) {
                switch (this.cmbxCriterio.getSelectedIndex()) {
                    //ID Pedido
                    case 0:
                        //do something
                        this.lstVistaPedidos.setListData(this.contro.buscarPedidos(Pedido_.idPedido, Long.parseLong(this.txtCriterio.getText())).toArray());
                        break;
                    //CUIT propietario
                    case 1:
                        Cliente propietario;
                        propietario = this.contro.buscarClienteCUIT(this.txtCriterio.getText());
                        this.lstVistaPedidos.setListData(this.contro.buscarPedidos(Pedido_.propietario, propietario).toArray());
                        break;
                    //FECHA PRIMER ENTREGA
                    case 2:
                        
                        Date d = this.contro.dateParser(this.txtCriterio.getText());
                        this.lstVistaPedidos.setListData(this.contro.buscarPedidos(Pedido_.entregaInicial, d).toArray());
                        break;
                }
            } else {
                this.lstVistaPedidos.setListData(this.contro.mostrarPedidos().toArray());
            }
        }catch (ParseException | NumberFormatException e){
            System.out.println("Hubo un error, pero no te preocupes. :D");
        }
    }//GEN-LAST:event_btnMostrarPedidosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.previo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Pronto...", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void lstVistaPedidosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstVistaPedidosValueChanged
        // Cuando se hace click en un resultado, se abre una ventana para poder ver
        // las entregas que dorresponden a ese pedido.
        if (!this.lstVistaPedidos.isSelectionEmpty()){
            Pedido unPedido = (Pedido) this.lstVistaPedidos.getSelectedValue();
            VentanaNuevoPedido vnp;
            vnp = new VentanaNuevoPedido(this.contro, this, unPedido);
            vnp.setVisible(true);
        }
    }//GEN-LAST:event_lstVistaPedidosValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnMostrarPedidos;
    private javax.swing.JComboBox<String> cmbxCriterio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstVistaPedidos;
    private javax.swing.JTextField txtCriterio;
    // End of variables declaration//GEN-END:variables
}
