package Forms;

import Entities.Usuario;

/**
 *
 * @author Tejada
 */
public class LogIn extends javax.swing.JFrame {
    
    private final Utilidades utilidades = new Utilidades();
    
    public static Usuario usuario = null;
    
    public static boolean cambiarUsuario = false;
    
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
        setTitle("Inicio de Sesion");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(315, 395));

        lbInicioSesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbInicioSesion.setText("INICIO DE SESIÓN");

        btAcceder.setBackground(new java.awt.Color(204, 204, 255));
        btAcceder.setText("Entrar");
        btAcceder.setMaximumSize(new java.awt.Dimension(85, 25));
        btAcceder.setMinimumSize(new java.awt.Dimension(85, 25));
        btAcceder.setPreferredSize(new java.awt.Dimension(85, 25));
        btAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAccederActionPerformed(evt);
            }
        });

        btRegistrar.setBackground(new java.awt.Color(204, 255, 204));
        btRegistrar.setText("Registrar");

        jLabel2.setText("¿Olvidó su contraseña?");

        tbUsuario.setNextFocusableComponent(tbClave);

        lbClave.setText("Clave");

        lbUsuario.setText("Usuario");

        lbImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N

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
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbClave)
                    .addComponent(lbUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbImagen)
                    .addComponent(noLog)
                    .addComponent(tbClave, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbInicioSesion)
                    .addComponent(btAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbInicioSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbClave))
                .addGap(36, 36, 36)
                .addComponent(btAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noLog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAccederActionPerformed
        if (!noLog.isSelected()) { //La variable usuario es setada en el metodo login
            if (!tbUsuario.getText().trim().equals("") && !tbClave.getPassword().equals("")) {
                if (utilidades.login(tbUsuario.getText(), tbClave.getPassword())) {
                    if (cambiarUsuario){
                        cambiarUsuario = false;
                        GenerarVenta.actualizarUsuario();
                        this.dispose();
                    }
                    else if(usuario.getIdRol().getIdRol() == 1)
                    {
                        new PrincipalAdmin().setVisible(true);
                    }
                    else
                    {
                        new PrincipalEmpleado().setVisible(true);
                    }
                    this.dispose();
                } else {
                    utilidades.mostrarAlerta(btAcceder,"Usuario o Clave incorrectos,"
                            + " intente de nuevo porfavor.",
                            "Inicio de sesion fallido");
                }
            } else {
                utilidades.mostrarAlerta(btAcceder,"Porfavor ingrese datos válidos",
                        "Inicio de sesion fallido");
            }
        }
        else
        {
            usuario = utilidades.getUsuarioByIdUsuario(1);
            new PrincipalAdmin().setVisible(true);
            this.dispose();
        }
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
