package Forms;

import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;


public class GenerarVenta extends javax.swing.JFrame {
    
    Utilidades utilidades = new Utilidades();
    DecimalFormat df = new DecimalFormat("$ 0.00");
    
    public GenerarVenta() {
        initComponents();
        utilidades.setScreenCentered(this);
        utilidades.fillJList(lsBuscar,"Producto");
        lbFechaExpedicion.setText(utilidades.getDate());
        llenarComboBox();
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        dgvPedidos.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        dgvPedidos.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGrupo1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        ppmDataGrid = new javax.swing.JPopupMenu();
        miEliminarElemento = new javax.swing.JMenuItem();
        miModificarCantidad = new javax.swing.JMenuItem();
        panelCliente = new javax.swing.JPanel();
        tbNombreCliente = new javax.swing.JTextField();
        rbAnonimo = new javax.swing.JRadioButton();
        rbExistente = new javax.swing.JRadioButton();
        rbNuevo = new javax.swing.JRadioButton();
        tbApellidoCliente = new javax.swing.JTextField();
        tbDireccion = new javax.swing.JTextField();
        tbDUICliente = new javax.swing.JTextField();
        lbFactura1 = new javax.swing.JLabel();
        lbFactura2 = new javax.swing.JLabel();
        lbFactura3 = new javax.swing.JLabel();
        lbFactura4 = new javax.swing.JLabel();
        lbVenta = new javax.swing.JLabel();
        panelProducto = new javax.swing.JPanel();
        tbBuscar = new javax.swing.JTextField();
        btAgregar = new javax.swing.JButton();
        lbExistencia = new javax.swing.JLabel();
        cbBuscar = new javax.swing.JComboBox<>();
        cbCantidad = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsBuscar = new javax.swing.JList<>();
        lbCantidad = new javax.swing.JLabel();
        lbPrecio = new javax.swing.JLabel();
        lbRegistro = new javax.swing.JPanel();
        lbFecha = new javax.swing.JLabel();
        lbFechaExpedicion = new javax.swing.JLabel();
        lbFactura = new javax.swing.JLabel();
        lbNumeroFactura = new javax.swing.JLabel();
        btVender = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        lbTotal = new javax.swing.JLabel();
        lbEmpleado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgvPedidos = new javax.swing.JTable();
        lbPedidos = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        miEliminarElemento.setText("Quitar producto");
        miEliminarElemento.setActionCommand("Quitar Producto");
        miEliminarElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEliminarElementoActionPerformed(evt);
            }
        });
        ppmDataGrid.add(miEliminarElemento);

        miModificarCantidad.setText("Cambiar cantidad");
        miModificarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miModificarCantidadActionPerformed(evt);
            }
        });
        ppmDataGrid.add(miModificarCantidad);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1360, 768));

        panelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        panelCliente.setToolTipText("Cliente");

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

        rbGrupo1.add(rbNuevo);
        rbNuevo.setText("Nuevo");
        rbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNuevoActionPerformed(evt);
            }
        });

        tbDireccion.setEnabled(false);

        tbDUICliente.setEnabled(false);

        lbFactura1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFactura1.setText("Nombre:");

        lbFactura2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFactura2.setText("Direccion:");

        lbFactura3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFactura3.setText("Apellido:");

        lbFactura4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFactura4.setText("DUI:");

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClienteLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(rbAnonimo)
                        .addGap(31, 31, 31)
                        .addComponent(rbExistente)
                        .addGap(34, 34, 34)
                        .addComponent(rbNuevo))
                    .addGroup(panelClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFactura1)
                            .addComponent(lbFactura2)
                            .addComponent(lbFactura4)
                            .addComponent(lbFactura3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbDUICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(313, Short.MAX_VALUE))
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAnonimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbExistente)
                    .addComponent(rbNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFactura1))
                .addGap(18, 18, 18)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFactura3))
                .addGap(18, 18, 18)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFactura2)
                    .addComponent(tbDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFactura4)
                    .addComponent(tbDUICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(163, 163, 163))
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

        cbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Producto", "Marca", "Categoria" }));

        cbCantidad.setEditable(true);
        cbCantidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1" }));

        lsBuscar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lsBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsBuscarMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lsBuscar);

        lbCantidad.setText("Cantidad:");

        lbPrecio.setText("Precio: $ 0.00");

        javax.swing.GroupLayout panelProductoLayout = new javax.swing.GroupLayout(panelProducto);
        panelProducto.setLayout(panelProductoLayout);
        panelProductoLayout.setHorizontalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductoLayout.createSequentialGroup()
                        .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbExistencia)
                            .addComponent(cbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCantidad))
                        .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelProductoLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tbBuscar, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCantidad, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelProductoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbPrecio))))
                    .addComponent(btAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelProductoLayout.setVerticalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProductoLayout.createSequentialGroup()
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPrecio)
                    .addComponent(lbExistencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAgregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(lbFecha)
                    .addGroup(lbRegistroLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lbFechaExpedicion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lbRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFactura, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbRegistroLayout.createSequentialGroup()
                        .addComponent(lbNumeroFactura)
                        .addGap(20, 20, 20))))
        );
        lbRegistroLayout.setVerticalGroup(
            lbRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbRegistroLayout.createSequentialGroup()
                .addGroup(lbRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFecha)
                    .addComponent(lbFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaExpedicion)
                    .addComponent(lbNumeroFactura)))
        );

        btVender.setForeground(new java.awt.Color(0, 133, 99));
        btVender.setText("Vender");
        btVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVenderActionPerformed(evt);
            }
        });

        btCancelar.setForeground(new java.awt.Color(204, 0, 0));
        btCancelar.setText("Cancelar venta");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        lbTotal.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(191, 94, 0));
        lbTotal.setText("Total a pagar: $ 0.00");

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
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        dgvPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dgvPedidos.setName("dgvPedidos"); // NOI18N
        dgvPedidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dgvPedidos.getTableHeader().setResizingAllowed(false);
        dgvPedidos.getTableHeader().setReorderingAllowed(false);
        dgvPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dgvPedidosMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(dgvPedidos);

        lbPedidos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbPedidos.setText("Venta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lbEmpleado)
                        .addGap(165, 165, 165)
                        .addComponent(lbVenta)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btVender, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmpleado)
                    .addComponent(lbVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btCancelar)
                        .addComponent(lbPedidos)
                        .addComponent(btVender)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    private void llenarComboBox()
    {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbCantidad.getModel();
        model.removeAllElements();
        for (int i = 1; i <= 25 ; i++) {
            model.addElement(i);
        }
        cbCantidad.setModel(model);
    }

    private void lsBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsBuscarMouseClicked
        JList list = (JList)evt.getSource();
        if (utilidades.validarComboBox(cbCantidad)) {
            int cbx = Integer.valueOf(cbCantidad.getSelectedItem().toString());
            if (evt.getClickCount() == 2 && list.getModel().getSize() > 0 &&
                    utilidades.getInventarioByNombre(lsBuscar.getSelectedValue())>0)
            {
                utilidades.addToJTableVenta(dgvPedidos, lsBuscar.getSelectedValue(),cbx);
                dgvPedidos.setDefaultEditor(Object.class, null);
                dgvPedidos.setRowSelectionAllowed(true);
                lbTotal.setText("Total a pagar: " + df.format(utilidades.getTotal()));
            }
            else if (list.getModel().getSize() > 0 && list.getSelectedValue() != null)
            {
                actualizarCantidadInventario(list);
            }
        }
    }//GEN-LAST:event_lsBuscarMouseClicked
    private void actualizarCantidadInventario(JList list)
    {
        String existencia = String.valueOf(utilidades.getInventarioByNombre(
                list.getSelectedValue().toString()));
        String precio = String.valueOf(df.format(utilidades.getPrecioByNombre(
                list.getSelectedValue().toString())));
        
        lbExistencia.setText("Existencia: " + existencia);
        lbPrecio.setText("Precio: $" + precio);
    }
    private void btVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVenderActionPerformed
        if (dgvPedidos.getRowCount() >= 1) {
            if(rbAnonimo.isSelected())
            {
                utilidades.crearVenta("Anonimo", "");
                utilidades.clearJTable(dgvPedidos);
            }
            else if(rbExistente.isSelected())
            {
                utilidades.crearVenta(tbNombreCliente.getText(),
                        tbApellidoCliente.getText());
                utilidades.clearJTable(dgvPedidos);
            }
            else
            {
                utilidades.mostrarAlerta("Nada","No hara nada");
                
            }
            actualizarCantidadInventario(lsBuscar);
        }
        else utilidades.mostrarAlerta("No puede vender si no se han agregado productos",
                "Error");
    }//GEN-LAST:event_btVenderActionPerformed

    private void rbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNuevoActionPerformed
        tbDUICliente.setEnabled(true);
        tbDireccion.setEnabled(true);
        //btAgregarCliente.setEnabled(true);
    }//GEN-LAST:event_rbNuevoActionPerformed

    private void rbExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbExistenteActionPerformed
        tbDUICliente.setEnabled(false);
        tbDireccion.setEnabled(false);
        //btAgregarCliente.setEnabled(false);
    }//GEN-LAST:event_rbExistenteActionPerformed

    private void rbAnonimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAnonimoActionPerformed
        tbDUICliente.setEnabled(false);
        tbDireccion.setEnabled(false);
        //btAgregarCliente.setEnabled(false);
    }//GEN-LAST:event_rbAnonimoActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        java.awt.event.MouseEvent evts = new java.awt.event.MouseEvent(lsBuscar, WIDTH, WIDTH, ICONIFIED, WIDTH, WIDTH, 2, rootPaneCheckingEnabled);
        this.lsBuscarMouseClicked(evts);
    }//GEN-LAST:event_btAgregarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        utilidades.clearJTable(dgvPedidos);
        lbTotal.setText("Total a pagar: $0.00");
    }//GEN-LAST:event_btCancelarActionPerformed

    private void dgvPedidosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvPedidosMouseReleased
        if (evt.getButton() == MouseEvent.BUTTON1) {
            int seleccion = dgvPedidos.getSelectedRow();
            String concat = "("+utilidades.getProductoEnLista(seleccion)+")";
            
            miEliminarElemento.setText("Quitar producto "+concat);
            miModificarCantidad.setText("Cambiar cantidad "+concat);
            
            ppmDataGrid.show(dgvPedidos, evt.getX(), evt.getY());
        }     
    }//GEN-LAST:event_dgvPedidosMouseReleased

    private void miEliminarElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEliminarElementoActionPerformed
        utilidades.removeFromJTable(dgvPedidos, dgvPedidos.getSelectedRow());
        lbTotal.setText("Total a pagar: " + df.format(utilidades.getTotal()));
    }//GEN-LAST:event_miEliminarElementoActionPerformed

    private void miModificarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miModificarCantidadActionPerformed
        String valor;
	int num = -1;      
        while (num == -1) {
            valor = JOptionPane.showInputDialog("Cantidad:",
                    dgvPedidos
                            .getModel()
                            .getValueAt(dgvPedidos
                                    .getSelectedRow(), 0));
            if (valor == null) 
            {
                return;
            }
            num = stringToInt(valor);
            if (num > utilidades
                    .getInventarioByNombre((String) dgvPedidos
                            .getModel()
                            .getValueAt(dgvPedidos.getSelectedRow(), 1)))
            {
                num = -1;
                utilidades.mostrarAlerta("La cantidad ingresada exede la cantidad"
                        + " disponible, intente de nuevo.", "Cantidad no válida!");
            }
        }
        utilidades.setCantidadJtable(dgvPedidos, dgvPedidos.getSelectedRow(), num);
        lbTotal.setText("Total a pagar: " + df.format(utilidades.getTotal()));
    }//GEN-LAST:event_miModificarCantidadActionPerformed
    private static int stringToInt(String string) {       
        try {
            int var = Integer.parseInt(string);
            if (var >= 1) return var;
            else return -1;
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "El numero que ingresó no es valido, porfavor intente de nuevo",
                    "Ingrese un numero valido",
                    JOptionPane.WARNING_MESSAGE);
            return -1;
        }
    }
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
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btVender;
    private javax.swing.JComboBox<String> cbBuscar;
    private javax.swing.JComboBox cbCantidad;
    private javax.swing.JTable dgvPedidos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lbCantidad;
    private javax.swing.JLabel lbEmpleado;
    private javax.swing.JLabel lbExistencia;
    private javax.swing.JLabel lbFactura;
    private javax.swing.JLabel lbFactura1;
    private javax.swing.JLabel lbFactura2;
    private javax.swing.JLabel lbFactura3;
    private javax.swing.JLabel lbFactura4;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbFechaExpedicion;
    private javax.swing.JLabel lbNumeroFactura;
    private javax.swing.JLabel lbPedidos;
    private javax.swing.JLabel lbPrecio;
    private javax.swing.JPanel lbRegistro;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbVenta;
    private javax.swing.JList<String> lsBuscar;
    private javax.swing.JMenuItem miEliminarElemento;
    private javax.swing.JMenuItem miModificarCantidad;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JPanel panelProducto;
    private javax.swing.JPopupMenu ppmDataGrid;
    private javax.swing.JRadioButton rbAnonimo;
    private javax.swing.JRadioButton rbExistente;
    private javax.swing.ButtonGroup rbGrupo1;
    private javax.swing.JRadioButton rbNuevo;
    private javax.swing.JTextField tbApellidoCliente;
    private javax.swing.JTextField tbBuscar;
    private javax.swing.JTextField tbDUICliente;
    private javax.swing.JTextField tbDireccion;
    private javax.swing.JTextField tbNombreCliente;
    // End of variables declaration//GEN-END:variables
}
