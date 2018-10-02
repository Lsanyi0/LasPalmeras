package Forms;

import javax.swing.JList;

public class GenerarVenta extends javax.swing.JFrame {

    Utilidades utilidades = new Utilidades();
            
    public GenerarVenta() {
        initComponents();
        utilidades.fillJList(lsBuscar,"Producto");
        lbFechaExpedicion.setText(utilidades.getDate());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGrupo1 = new javax.swing.ButtonGroup();
        panelCliente = new javax.swing.JPanel();
        tbBuscarCliente = new javax.swing.JTextField();
        rbAnonimo = new javax.swing.JRadioButton();
        rbExistente = new javax.swing.JRadioButton();
        btAgregarCliente = new javax.swing.JButton();
        rbExistente1 = new javax.swing.JRadioButton();
        tbBuscarCliente1 = new javax.swing.JTextField();
        lbVenta = new javax.swing.JLabel();
        panelProducto = new javax.swing.JPanel();
        tbBuscar = new javax.swing.JTextField();
        btAgregar = new javax.swing.JButton();
        lbExistencia = new javax.swing.JLabel();
        lbPrecio = new javax.swing.JLabel();
        cbBuscar = new javax.swing.JComboBox<>();
        cbCantidad = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsBuscar = new javax.swing.JList<>();
        lbRegistro = new javax.swing.JPanel();
        lbFecha = new javax.swing.JLabel();
        lbFechaExpedicion = new javax.swing.JLabel();
        lbFactura = new javax.swing.JLabel();
        lbNumeroFactura = new javax.swing.JLabel();
        btImprimir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        lbTotal = new javax.swing.JLabel();
        lbEmpleado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgvPedidos = new javax.swing.JTable();
        lbPedidos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        panelCliente.setToolTipText("Cliente");

        tbBuscarCliente.setText("Nombre");

        rbGrupo1.add(rbAnonimo);
        rbAnonimo.setText("Anonimo");
        rbAnonimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAnonimoActionPerformed(evt);
            }
        });

        rbGrupo1.add(rbExistente);
        rbExistente.setSelected(true);
        rbExistente.setText("Existente");
        rbExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbExistenteActionPerformed(evt);
            }
        });

        btAgregarCliente.setText("Agregar Nuevo Cliente");

        rbGrupo1.add(rbExistente1);
        rbExistente1.setText("Nuevo");
        rbExistente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbExistente1ActionPerformed(evt);
            }
        });

        tbBuscarCliente1.setText("Apellido");

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btAgregarCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClienteLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbBuscarCliente)
                    .addGroup(panelClienteLayout.createSequentialGroup()
                        .addComponent(rbAnonimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbExistente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                        .addComponent(rbExistente1))
                    .addComponent(tbBuscarCliente1))
                .addContainerGap())
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAnonimo)
                    .addComponent(rbExistente)
                    .addComponent(rbExistente1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(tbBuscarCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btAgregarCliente)
                .addContainerGap())
        );

        lbVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbVenta.setText("VENTA");

        panelProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));
        panelProducto.setToolTipText("Cliente");

        tbBuscar.setText("Buscar Producto");
        tbBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBuscarMouseClicked(evt);
            }
        });
        tbBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbBuscarKeyTyped(evt);
            }
        });

        btAgregar.setText("Agregar");
        btAgregar.setName(""); // NOI18N
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });

        lbExistencia.setText("Existencia: 000");

        lbPrecio.setText("Precio: $00.00");

        cbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Producto", "Marca", "Categoria" }));

        cbCantidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cantidad" }));

        lsBuscar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lsBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsBuscarMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lsBuscar);

        javax.swing.GroupLayout panelProductoLayout = new javax.swing.GroupLayout(panelProducto);
        panelProducto.setLayout(panelProductoLayout);
        panelProductoLayout.setHorizontalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelProductoLayout.createSequentialGroup()
                            .addComponent(lbExistencia)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(cbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelProductoLayout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addComponent(tbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelProductoLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(btAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelProductoLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(cbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelProductoLayout.setVerticalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbExistencia)
                    .addComponent(lbPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAgregar)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProductoLayout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        lbRegistro.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro"));
        lbRegistro.setToolTipText(".");

        lbFecha.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFecha.setText("Fecha De Expedicion");

        lbFechaExpedicion.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFechaExpedicion.setText("12-12-12");

        lbFactura.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFactura.setText("No. Factura");

        lbNumeroFactura.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbNumeroFactura.setText("000000");

        javax.swing.GroupLayout lbRegistroLayout = new javax.swing.GroupLayout(lbRegistro);
        lbRegistro.setLayout(lbRegistroLayout);
        lbRegistroLayout.setHorizontalGroup(
            lbRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbRegistroLayout.createSequentialGroup()
                .addGroup(lbRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbRegistroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbFecha))
                    .addGroup(lbRegistroLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(lbFechaExpedicion)))
                .addGap(18, 18, 18)
                .addGroup(lbRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbRegistroLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbNumeroFactura))
                    .addComponent(lbFactura))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lbRegistroLayout.setVerticalGroup(
            lbRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbRegistroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lbRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFecha)
                    .addComponent(lbFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaExpedicion)
                    .addComponent(lbNumeroFactura)))
        );

        btImprimir.setText("Imprimir venta");

        btCancelar.setText("Cancelar venta");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        lbTotal.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbTotal.setText("Total a pagar: $00.00");

        lbEmpleado.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbEmpleado.setText("Empleado: empleado ");

        dgvPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CANTIDAD", "NOMBRE", "PRECIO UNITARIO", "SUBTOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        dgvPedidos.setEnabled(false);
        dgvPedidos.getTableHeader().setResizingAllowed(false);
        dgvPedidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(dgvPedidos);

        lbPedidos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbPedidos.setText("Venta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(lbEmpleado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbVenta))
                                    .addComponent(panelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 115, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbPedidos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btCancelar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbTotal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(panelCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEmpleado)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbVenta)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPedidos)
                    .addComponent(btImprimir)
                    .addComponent(btCancelar)
                    .addComponent(lbTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbAnonimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAnonimoActionPerformed

    }//GEN-LAST:event_rbAnonimoActionPerformed

    private void rbExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbExistenteActionPerformed

    }//GEN-LAST:event_rbExistenteActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed

    }//GEN-LAST:event_btCancelarActionPerformed

    private void rbExistente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbExistente1ActionPerformed

    }//GEN-LAST:event_rbExistente1ActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        
    }//GEN-LAST:event_btAgregarActionPerformed

    private void tbBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBuscarMouseClicked
        tbBuscar.setText("");
    }//GEN-LAST:event_tbBuscarMouseClicked

    private void tbBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbBuscarKeyTyped
        Integer bs = tbBuscar.getText().length();
        if ( bs >= 1) {
            String filtro = cbBuscar.getSelectedItem().toString().toLowerCase();
            String busqueda = tbBuscar.getText();
            utilidades.fillJList(lsBuscar, filtro, busqueda,"Producto");
        }
        else if ( bs == 0) {
          utilidades.fillJList(lsBuscar,"Producto");
        }
    }//GEN-LAST:event_tbBuscarKeyTyped

    private void lsBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsBuscarMouseClicked
        JList list = (JList)evt.getSource();
        if (evt.getClickCount() == 2 && list.getModel().getSize() > 0) 
        {
            int index = list.locationToIndex(evt.getPoint());
            utilidades.addToJTableVenta(dgvPedidos, lsBuscar.getSelectedValue(), 1);
            lbTotal.setText("Total a pagar: $" + utilidades.getTotal());
        }
        else if (list.getModel().getSize() > 0)
        {
          String existencia = String.valueOf(utilidades.getInventarioByNombre(
                              list.getSelectedValue().toString()));
          String precio = String.valueOf(utilidades.getPrecioByNombre(
                              list.getSelectedValue().toString()));
          
          lbExistencia.setText("Existencia: " + existencia);
          lbPrecio.setText("Precio: $" + precio);
          
        }
    }//GEN-LAST:event_lsBuscarMouseClicked

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(GenerarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerarVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btAgregarCliente;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btImprimir;
    private javax.swing.JComboBox<String> cbBuscar;
    private javax.swing.JComboBox cbCantidad;
    private javax.swing.JTable dgvPedidos;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbEmpleado;
    private javax.swing.JLabel lbExistencia;
    private javax.swing.JLabel lbFactura;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbFechaExpedicion;
    private javax.swing.JLabel lbNumeroFactura;
    private javax.swing.JLabel lbPedidos;
    private javax.swing.JLabel lbPrecio;
    private javax.swing.JPanel lbRegistro;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbVenta;
    private javax.swing.JList<String> lsBuscar;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JPanel panelProducto;
    private javax.swing.JRadioButton rbAnonimo;
    private javax.swing.JRadioButton rbExistente;
    private javax.swing.JRadioButton rbExistente1;
    private javax.swing.ButtonGroup rbGrupo1;
    private javax.swing.JTextField tbBuscar;
    private javax.swing.JTextField tbBuscarCliente;
    private javax.swing.JTextField tbBuscarCliente1;
    // End of variables declaration//GEN-END:variables
}
