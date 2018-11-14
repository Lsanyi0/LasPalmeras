package Forms;

import Model.jtableVentaModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class pruebaImpresion extends javax.swing.JFrame {
    int id=0;
    ArrayList<jtableVentaModel> jventafake;
    ReportesEimpresion re;
    Utilidades utilidades ;
    public pruebaImpresion() {
        initComponents();
        this.btImprimir.requestFocus();
        jventafake = new ArrayList<>();
        re = new ReportesEimpresion();
        utilidades = new Utilidades();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btImprimir = new javax.swing.JButton();
        btAgregarProducto = new javax.swing.JButton();
        tbNombreProd = new javax.swing.JTextField();
        tbPrecioUnitario = new javax.swing.JTextField();
        tbCantidad = new javax.swing.JTextField();
        btJasperR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btImprimir.setText("\"Imprimir\"");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        btAgregarProducto.setText("\"Agregar producto\"");
        btAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarProductoActionPerformed(evt);
            }
        });

        tbNombreProd.setText("Nombre");
        tbNombreProd.setToolTipText("Nombre");
        tbNombreProd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbNombreProdFocusGained(evt);
            }
        });

        tbPrecioUnitario.setText("11.26");
        tbPrecioUnitario.setToolTipText("Precio");
        tbPrecioUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbPrecioUnitarioFocusGained(evt);
            }
        });

        tbCantidad.setText("1");
        tbCantidad.setToolTipText("Cantidad");
        tbCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbCantidadFocusGained(evt);
            }
        });

        btJasperR.setText("\"Jasper\"");
        btJasperR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJasperRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbPrecioUnitario)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbNombreProd)
                    .addComponent(tbCantidad, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btAgregarProducto)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btJasperR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAgregarProducto)
                .addGap(1, 1, 1)
                .addComponent(btImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btJasperR))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbNombreProdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbNombreProdFocusGained
        this.tbNombreProd.setText("");
    }//GEN-LAST:event_tbNombreProdFocusGained

    private void tbCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbCantidadFocusGained
        this.tbCantidad.setText("");
    }//GEN-LAST:event_tbCantidadFocusGained

    private void tbPrecioUnitarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbPrecioUnitarioFocusGained
        this.tbPrecioUnitario.setText("");
    }//GEN-LAST:event_tbPrecioUnitarioFocusGained

    private void btAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarProductoActionPerformed
        id+=1;
        jtableVentaModel jvf = new jtableVentaModel(id,Integer.parseInt(tbCantidad.getText())
                ,tbNombreProd.getText(),Double.parseDouble(tbPrecioUnitario.getText()),0.0);
        jventafake.add(jvf);
        System.out.println(jventafake.size());
    }//GEN-LAST:event_btAgregarProductoActionPerformed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        re.crearFactura(jventafake);
    }//GEN-LAST:event_btImprimirActionPerformed

    private void btJasperRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJasperRActionPerformed
        JasperReport reporte;
        String path = ".src\\jReports\\ProductosMasVendidos.jasper";
        try {
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jasperPrint = JasperFillManager.fillReport(path, null);//WIP
            JasperViewer viewer = new JasperViewer(jasperPrint);
        } catch (JRException e) {
            utilidades.mostrarAlerta("Nel prro :V /n Error:" + e, "Error");
        }
    }//GEN-LAST:event_btJasperRActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(pruebaImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pruebaImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pruebaImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pruebaImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pruebaImpresion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregarProducto;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btJasperR;
    private javax.swing.JTextField tbCantidad;
    private javax.swing.JTextField tbNombreProd;
    private javax.swing.JTextField tbPrecioUnitario;
    // End of variables declaration//GEN-END:variables
}
