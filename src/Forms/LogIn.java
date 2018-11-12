package Forms;



/**
 *
 * @author Tejada
 */
public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    private final Utilidades utilidades = new Utilidades();;
    public LogIn() {
        initComponents();
        utilidades.setScreenCentered(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbInicioSesion = new javax.swing.JLabel();
        btAcceder = new javax.swing.JButton();
        btRegistrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tbUsuario = new javax.swing.JTextField();
        lbClave = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lbImagen = new javax.swing.JLabel();
        noLog = new javax.swing.JCheckBox();
        tbClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbInicioSesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbInicioSesion.setText("INICIO DE SESIÓN");

        btAcceder.setText("Acceder");
        btAcceder.setMaximumSize(new java.awt.Dimension(85, 25));
        btAcceder.setMinimumSize(new java.awt.Dimension(85, 25));
        btAcceder.setPreferredSize(new java.awt.Dimension(85, 25));
        btAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAccederActionPerformed(evt);
            }
        });

        btRegistrar.setText("Registrar");

        jLabel2.setText("¿Olvido su contraseña?");

        tbUsuario.setNextFocusableComponent(tbClave);

        lbClave.setText("Clave");

        lbUsuario.setText("Usuario");

        lbImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        lbImagen.setText(".");

        noLog.setSelected(true);
        noLog.setText("Nolog");

        tbClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbClaveKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(98, 98, 98)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbInicioSesion))
                                    .addGap(24, 24, 24))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(57, 57, 57)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(lbUsuario)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(lbClave)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tbClave, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(noLog)))
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAcceder, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbInicioSesion)
                .addGap(18, 18, 18)
                .addComponent(lbImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbClave)
                    .addComponent(tbClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(noLog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAccederActionPerformed
        if (!noLog.isSelected()) {
            if (!tbUsuario.getText().trim().equals("") && !tbClave.getPassword().equals("")) {
                if (utilidades.login(tbUsuario.getText(), tbClave.getPassword())) {
                    new GenerarVenta().setVisible(true);
                    this.dispose();
                } else {
                    utilidades.mostrarAlerta("Usuario o Clave incorrectos,"
                            + " intente de nuevo porfavor.", 
                            "Inicio de sesion fallido");
                }
            } else {
                utilidades.mostrarAlerta("Porfavor ingrese datos válidos",
                        "Inicio de sesion fallido");
            }
        }
        else {new GenerarVenta().setVisible(true); this.dispose();}
    }//GEN-LAST:event_btAccederActionPerformed

    private void tbClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbClaveKeyPressed
        if (evt.getKeyCode() == 10) {
            btAccederActionPerformed(new java.awt.event.ActionEvent(this, 0,null));
        }
    }//GEN-LAST:event_tbClaveKeyPressed

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAcceder;
    private javax.swing.JButton btRegistrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbClave;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JLabel lbInicioSesion;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JCheckBox noLog;
    private javax.swing.JPasswordField tbClave;
    private javax.swing.JTextField tbUsuario;
    // End of variables declaration//GEN-END:variables
}
