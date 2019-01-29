package Forms;

import Entities.Cliente;
import Model.JTableVentaModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class PruebaImpresion extends javax.swing.JFrame {
    int id=0;
    ArrayList<JTableVentaModel> jventafake;
    ReportesEimpresion re;
    Utilidades utilidades ;
    public PruebaImpresion() {
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
        tbDescuento = new javax.swing.JTextField();

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

        tbDescuento.setText("0.01");
        tbDescuento.setToolTipText("Precio");
        tbDescuento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbDescuentoFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tbNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btAgregarProducto)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btJasperR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAgregarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        JTableVentaModel jvf = new JTableVentaModel(id,Integer.parseInt(tbCantidad.getText())
                ,tbNombreProd.getText(),Double.parseDouble(tbPrecioUnitario.getText()),Double.parseDouble(tbDescuento.getText()));
        jventafake.add(jvf);
        System.out.println(jventafake.size());
    }//GEN-LAST:event_btAgregarProductoActionPerformed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        Cliente cli = new Cliente();
        re.crearFactura(jventafake,1,"Luis Albanes",cli.getDireccion());
    }//GEN-LAST:event_btImprimirActionPerformed

    private void btJasperRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJasperRActionPerformed
        JasperReport reporte;
        String path = ".\\src\\jReports\\VentasEnMayoreo.jasper";
        Map params = new HashMap();
        params.put("Fecha1", "2017-01-01");
        params.put("Fecha2", "2018-12-31");
        try {
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, params, utilidades.getConnection());//WIP
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        } catch (JRException e) {
            utilidades.mostrarAlerta(btJasperR,"Nel prro :V /n Error:" + e, "Error");
        }
    }//GEN-LAST:event_btJasperRActionPerformed

    private void tbDescuentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbDescuentoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDescuentoFocusGained
    
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
            java.util.logging.Logger.getLogger(PruebaImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PruebaImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PruebaImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PruebaImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PruebaImpresion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregarProducto;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btJasperR;
    private javax.swing.JTextField tbCantidad;
    private javax.swing.JTextField tbDescuento;
    private javax.swing.JTextField tbNombreProd;
    private javax.swing.JTextField tbPrecioUnitario;
    // End of variables declaration//GEN-END:variables
}
