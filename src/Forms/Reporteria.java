package Forms;

import jReports.MysqlConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reporteria extends javax.swing.JFrame {
    
    public Utilidades utilidades;
    public final SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd");
    
    public Reporteria() {
        initComponents();
        utilidades = new Utilidades();
        dpDesde.setDate(new Date());
        dpHasta.setDate(new Date());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        lbVenta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btProductosMasVendidos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btVentasMayoreo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dpDesde = new org.jdesktop.swingx.JXDatePicker();
        dpHasta = new org.jdesktop.swingx.JXDatePicker();
        lbDesde = new javax.swing.JLabel();
        lbHasta = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btVentasMayoreo1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        dpDesde1 = new org.jdesktop.swingx.JXDatePicker();
        dpHasta1 = new org.jdesktop.swingx.JXDatePicker();
        lbDesde1 = new javax.swing.JLabel();
        lbHasta1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btProductosMasVendidos1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 768));

        lbVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbVenta.setText("REPORTES");
        lbVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btProductosMasVendidos.setText("Generar Reporte");
        btProductosMasVendidos.setActionCommand("");
        btProductosMasVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProductosMasVendidosActionPerformed(evt);
            }
        });

        jLabel1.setText("Productos Mas Vendidos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btProductosMasVendidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(71, 71, 71))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(btProductosMasVendidos, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        btVentasMayoreo.setText("Generar Reporte");
        btVentasMayoreo.setActionCommand("");
        btVentasMayoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVentasMayoreoActionPerformed(evt);
            }
        });

        jLabel2.setText("Ventas Mayoreo");

        lbDesde.setText("Desde:");

        lbHasta.setText("hasta:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbDesde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dpDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbHasta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dpHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btVentasMayoreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(71, 71, 71))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDesde)
                    .addComponent(lbHasta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVentasMayoreo, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addContainerGap())
        );

        btVentasMayoreo1.setText("Generar Reporte");
        btVentasMayoreo1.setActionCommand("");
        btVentasMayoreo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVentasMayoreo1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Ventas Mayoreo");

        lbDesde1.setText("Desde:");

        lbHasta1.setText("hasta:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbDesde1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(dpDesde1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(lbHasta1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dpHasta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btVentasMayoreo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(71, 71, 71))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpDesde1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpHasta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDesde1)
                    .addComponent(lbHasta1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVentasMayoreo1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        btProductosMasVendidos1.setText("Generar Reporte");
        btProductosMasVendidos1.setActionCommand("");
        btProductosMasVendidos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProductosMasVendidos1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Reporte Diario");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btProductosMasVendidos1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addGap(71, 71, 71))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(33, 33, 33)
                .addComponent(btProductosMasVendidos1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(lbVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(412, 412, 412))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 97, Short.MAX_VALUE))
        );

        lbVenta.getAccessibleContext().setAccessibleName("Reopotes");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btProductosMasVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProductosMasVendidosActionPerformed
        JasperReport reporte;
        String path = ".\\src\\jReports\\ProductosMasVendidos.jasper";
        try {
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, MysqlConnection.MysqlConnection());//WIP
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        } catch (JRException e) {
            utilidades.mostrarAlerta("Algo salio mal /nError:" + e, "Error");
        }
    }//GEN-LAST:event_btProductosMasVendidosActionPerformed

    private void btVentasMayoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVentasMayoreoActionPerformed
        if (dpDesde.getDate()!=null && dpHasta.getDate()!=null) {
            JasperReport reporte;
            String path = ".\\src\\jReports\\VentasEnMayoreo.jasper";
            Map params = new HashMap();
            params.put("Fecha1",frm.format(dpDesde.getDate()));
            params.put("Fecha2",frm.format(dpHasta.getDate()));
            try {
                reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, params, MysqlConnection.MysqlConnection());//WIP
                JasperViewer viewer = new JasperViewer(jasperPrint, false);
                viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                viewer.setVisible(true);
            } catch (JRException e) {
                utilidades.mostrarAlerta("Algo salio mal /nError:" + e, "Error");
            }
        }
    }//GEN-LAST:event_btVentasMayoreoActionPerformed

    private void btVentasMayoreo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVentasMayoreo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btVentasMayoreo1ActionPerformed

    private void btProductosMasVendidos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProductosMasVendidos1ActionPerformed
        JasperReport reporte;
        String path = ".\\src\\jReports\\ReporteDiario.jasper";
        Map params = new HashMap();
        Date hoy = new Date();
        
        params.put("Fecha1", frm.format(hoy.getTime()-86400000));
        params.put("Fecha2", frm.format(new Date()));
        try {
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, MysqlConnection.MysqlConnection());//WIP
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        } catch (JRException e) {
            utilidades.mostrarAlerta("Algo salio mal /nError:" + e, "Error");
        }
    }//GEN-LAST:event_btProductosMasVendidos1ActionPerformed

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
            java.util.logging.Logger.getLogger(Reporteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporteria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btProductosMasVendidos;
    private javax.swing.JButton btProductosMasVendidos1;
    private javax.swing.JButton btVentasMayoreo;
    private javax.swing.JButton btVentasMayoreo1;
    private org.jdesktop.swingx.JXDatePicker dpDesde;
    private org.jdesktop.swingx.JXDatePicker dpDesde1;
    private org.jdesktop.swingx.JXDatePicker dpHasta;
    private org.jdesktop.swingx.JXDatePicker dpHasta1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbDesde;
    private javax.swing.JLabel lbDesde1;
    private javax.swing.JLabel lbHasta;
    private javax.swing.JLabel lbHasta1;
    private javax.swing.JLabel lbVenta;
    // End of variables declaration//GEN-END:variables
}
