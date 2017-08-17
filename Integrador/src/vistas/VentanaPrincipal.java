/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;
import vistas.articulos.VentanaArticulo;
import vistas.envases.VentanaEnvase;
import vistas.clientes.VentanaCliente;
import vistas.pedidos.VentanaPedido;
import controlador.Controlador;
/**
 *
 * @author Diego Raul Fernandez
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Bienvenida
     */
    private final Controlador controlador;
    public VentanaPrincipal(Controlador c) {
        this.controlador = c;
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

        btnVentClientes = new javax.swing.JButton();
        btnVentPedidos = new javax.swing.JButton();
        btnVentEnvases = new javax.swing.JButton();
        btnVentArticulos = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVentClientes.setText("Customers' Management");
        btnVentClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentClientesMouseClicked(evt);
            }
        });
        btnVentClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentClientesActionPerformed(evt);
            }
        });

        btnVentPedidos.setText("Customers' orders' Management");
        btnVentPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentPedidosActionPerformed(evt);
            }
        });

        btnVentEnvases.setText("Packaging");
        btnVentEnvases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentEnvasesActionPerformed(evt);
            }
        });

        btnVentArticulos.setText("Products");
        btnVentArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentArticulosActionPerformed(evt);
            }
        });

        btnCerrar.setText("Toquemos los tarros");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        btnCerrar.setName("btnCerrarAplicacion"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVentEnvases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVentPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVentClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVentArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnVentClientes)
                .addGap(18, 18, 18)
                .addComponent(btnVentPedidos)
                .addGap(18, 18, 18)
                .addComponent(btnVentEnvases)
                .addGap(18, 18, 18)
                .addComponent(btnVentArticulos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVentClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentClientesMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnVentClientesMouseClicked

    private void btnVentClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentClientesActionPerformed
        // TODO add your handling code here:
        VentanaCliente vc = new VentanaCliente(this.controlador, this);
        vc.setVisible(true);
    }//GEN-LAST:event_btnVentClientesActionPerformed

    private void btnVentPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentPedidosActionPerformed
        // TODO add your handling code here:
        VentanaPedido vPedido = new VentanaPedido(this.controlador, this);
        vPedido.setVisible(true);
    }//GEN-LAST:event_btnVentPedidosActionPerformed

    private void btnVentEnvasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentEnvasesActionPerformed
        // TODO add your handling code here:
        VentanaEnvase vEnv;
        vEnv = new VentanaEnvase(this.controlador, this);
        vEnv.setVisible(true);
    }//GEN-LAST:event_btnVentEnvasesActionPerformed

    private void btnVentArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentArticulosActionPerformed
        // TODO add your handling code here:
        VentanaArticulo vArt = new VentanaArticulo(this.controlador, this);
        vArt.setVisible(true);
    }//GEN-LAST:event_btnVentArticulosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnVentArticulos;
    private javax.swing.JButton btnVentClientes;
    private javax.swing.JButton btnVentEnvases;
    private javax.swing.JButton btnVentPedidos;
    // End of variables declaration//GEN-END:variables
}
