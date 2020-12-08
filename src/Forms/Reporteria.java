package Forms;

import Entities.Inventario;
import resources.reports.MysqlConnection;
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
import java.util.List;

public class Reporteria extends javax.swing.JFrame {
    
    public Utilidades utilidades;
    public final SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd");
    
    public Reporteria() {
        initComponents();
        utilidades = new Utilidades();
        dpDesde.setDate(new Date());
        dpHasta.setDate(new Date());
        utilidades.setScreenCentered(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        btProductosMasVendidos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btVentasMayoreo = new javax.swing.JButton();
        dpDesde = new org.jdesktop.swingx.JXDatePicker();
        dpHasta = new org.jdesktop.swingx.JXDatePicker();
        lbDesde = new javax.swing.JLabel();
        lbHasta = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btReporteDiario = new javax.swing.JButton();
        btCerrarSesion = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reportes");
        setSize(new java.awt.Dimension(830, 320));

        btProductosMasVendidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/masvendidos.png"))); // NOI18N
        btProductosMasVendidos.setText("Mas Vendidos");
        btProductosMasVendidos.setActionCommand("");
        btProductosMasVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProductosMasVendidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btProductosMasVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btProductosMasVendidos)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        btVentasMayoreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/mayoreo.png"))); // NOI18N
        btVentasMayoreo.setText("Ventas Mayoreo");
        btVentasMayoreo.setActionCommand("");
        btVentasMayoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVentasMayoreoActionPerformed(evt);
            }
        });

        lbDesde.setText("Desde:");

        lbHasta.setText("hasta:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDesde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dpDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbHasta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dpHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btVentasMayoreo, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDesde)
                    .addComponent(lbHasta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVentasMayoreo)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btReporteDiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/diario.png"))); // NOI18N
        btReporteDiario.setText("Generar Reporte");
        btReporteDiario.setActionCommand("");
        btReporteDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReporteDiarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(btReporteDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btReporteDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/logout.png"))); // NOI18N
        btCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCerrarSesionMouseClicked(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 476, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(73, 73, 73))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btProductosMasVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProductosMasVendidosActionPerformed
        JasperReport reporte;
        try {
            reporte = (JasperReport) JRLoader.loadObject(getClass().getClassLoader().getResource("resources/reports/ProductosMasVendidos.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, MysqlConnection.MysqlConnection());//WIP
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        } catch (JRException e) {
            utilidades.mostrarAlerta(btProductosMasVendidos ,"Algo salio mal /nError:" + e, "Error");
        }
    }//GEN-LAST:event_btProductosMasVendidosActionPerformed

    private void btVentasMayoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVentasMayoreoActionPerformed
        if (dpDesde.getDate()!=null && dpHasta.getDate()!=null) {
            JasperReport reporte;
            Map params = new HashMap();
            params.put("Fecha1",frm.format(dpDesde.getDate()));
            params.put("Fecha2",frm.format(dpHasta.getDate()));
            try {
                reporte = (JasperReport) JRLoader.loadObject(getClass().getClassLoader().getResource("resources/reports/VentasEnMayoreo.jasper"));
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, params, MysqlConnection.MysqlConnection());//WIP
                JasperViewer viewer = new JasperViewer(jasperPrint, false);
                viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                viewer.setVisible(true);
            } catch (JRException e) {
                utilidades.mostrarAlerta(btVentasMayoreo ,"Algo salio mal /nError:" + e, "Error");
            }
        }
    }//GEN-LAST:event_btVentasMayoreoActionPerformed

    private void btReporteDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReporteDiarioActionPerformed
        JasperReport reporte;
        Map params = new HashMap();
        Date hoy = new Date();
        
        params.put("Fecha1", frm.format(hoy.getTime()-86400000));
        params.put("Fecha2", frm.format(new Date()));
        try {
            reporte = (JasperReport) JRLoader.loadObject(getClass().getClassLoader().getResource("resources/reports/ReporteDiario.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, MysqlConnection.MysqlConnection());//WIP
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        } catch (JRException e) {
            utilidades.mostrarAlerta(btReporteDiario,"Algo salio mal /nError:" + e, "Error");
        }
    }//GEN-LAST:event_btReporteDiarioActionPerformed

    private void btCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCerrarSesionMouseClicked
        new PrincipalAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btCerrarSesionMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       List<Inventario> asd =  utilidades.Prueba(5);
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
    private javax.swing.JLabel btCerrarSesion;
    private javax.swing.JButton btProductosMasVendidos;
    private javax.swing.JButton btReporteDiario;
    private javax.swing.JButton btVentasMayoreo;
    private org.jdesktop.swingx.JXDatePicker dpDesde;
    private org.jdesktop.swingx.JXDatePicker dpHasta;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbDesde;
    private javax.swing.JLabel lbHasta;
    // End of variables declaration//GEN-END:variables
}
