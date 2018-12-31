package Forms;

import Entities.Cliente;
import Entities.Telefono;
import java.awt.Color;
import java.util.List;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.ArrayList;


public class GenerarVenta extends javax.swing.JFrame {
    
    Utilidades utilidades = new Utilidades();
    DecimalFormat df = new DecimalFormat("$ 0.00");
    public static Cliente cliente;
    private final String totalAPagar = "Total a pagar: ";
    
    public GenerarVenta() {
        initComponents();
        utilidades.setScreenCentered(this);
              
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
        jScrollPane4 = new javax.swing.JScrollPane();
        lsBuscarCliente = new javax.swing.JList<>();
        tbBuscarCliente = new javax.swing.JTextField();
        lbFactura5 = new javax.swing.JLabel();
        lbFactura6 = new javax.swing.JLabel();
        tbTelefono = new javax.swing.JTextField();
        btAgregarNuevoCliente = new javax.swing.JButton();
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
        lbDescuento = new javax.swing.JLabel();
        tbDescuento = new javax.swing.JTextField();
        feedbackCorrecto = new javax.swing.JLabel();
        feedbackError = new javax.swing.JLabel();
        lbFeedback = new javax.swing.JLabel();
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
        btCerrarSesion = new javax.swing.JLabel();

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
        setTitle("Ventas");
        setSize(new java.awt.Dimension(1360, 768));

        panelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        tbNombreCliente.setNextFocusableComponent(tbApellidoCliente);

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

        tbApellidoCliente.setNextFocusableComponent(tbDireccion);

        tbDireccion.setEnabled(false);
        tbDireccion.setNextFocusableComponent(tbDUICliente);

        tbDUICliente.setEnabled(false);
        tbDUICliente.setNextFocusableComponent(tbDUICliente);

        lbFactura1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFactura1.setText("Nombre:");

        lbFactura2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFactura2.setText("Direccion:");

        lbFactura3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFactura3.setText("Apellido:");

        lbFactura4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFactura4.setText("DUI:");

        lsBuscarCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lsBuscarCliente.setToolTipText("");
        jScrollPane4.setViewportView(lsBuscarCliente);

        tbBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbBuscarClienteKeyTyped(evt);
            }
        });

        lbFactura5.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFactura5.setText("Buscar:");

        lbFactura6.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFactura6.setText("Telefono/s:");

        tbTelefono.setToolTipText("Si son multiples telefonos coloque una coma para separarlos");
        tbTelefono.setEnabled(false);
        tbTelefono.setNextFocusableComponent(tbBuscarCliente);

        btAgregarNuevoCliente.setText("Agregar Nuevo Ciente");
        btAgregarNuevoCliente.setEnabled(false);
        btAgregarNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarNuevoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(panelClienteLayout.createSequentialGroup()
                        .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelClienteLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelClienteLayout.createSequentialGroup()
                                        .addComponent(lbFactura5)
                                        .addGap(28, 28, 28)
                                        .addComponent(tbBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelClienteLayout.createSequentialGroup()
                                        .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(panelClienteLayout.createSequentialGroup()
                                                .addComponent(lbFactura1)
                                                .addGap(28, 28, 28))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelClienteLayout.createSequentialGroup()
                                                .addComponent(lbFactura3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tbNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                            .addComponent(tbApellidoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)))))
                            .addGroup(panelClienteLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(rbAnonimo)
                                .addGap(31, 31, 31)
                                .addComponent(rbExistente)
                                .addGap(34, 34, 34)
                                .addComponent(rbNuevo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelClienteLayout.createSequentialGroup()
                                .addComponent(btAgregarNuevoCliente)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelClienteLayout.createSequentialGroup()
                                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbFactura6)
                                    .addComponent(lbFactura2)
                                    .addComponent(lbFactura4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbDUICliente, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tbDireccion, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAnonimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbExistente)
                    .addComponent(rbNuevo)
                    .addComponent(btAgregarNuevoCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClienteLayout.createSequentialGroup()
                        .addComponent(tbDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbDUICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelClienteLayout.createSequentialGroup()
                        .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFactura2)
                            .addComponent(lbFactura1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFactura4)
                            .addComponent(lbFactura3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFactura6)
                    .addComponent(tbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFactura5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        panelProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));
        panelProducto.setToolTipText("");

        tbBuscar.setText("Buscar Producto");
        tbBuscar.setNextFocusableComponent(lsBuscar);
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
        btAgregar.setNextFocusableComponent(btVender);
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });
        btAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btAgregarKeyPressed(evt);
            }
        });

        lbExistencia.setText("Existencia: 0");

        cbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Producto", "Marca", "Categoria" }));
        cbBuscar.setEnabled(false);
        cbBuscar.setNextFocusableComponent(cbBuscar);

        cbCantidad.setEditable(true);
        cbCantidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1" }));
        cbCantidad.setNextFocusableComponent(tbDescuento);
        llenarComboBox();

        lsBuscar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lsBuscar.setNextFocusableComponent(cbCantidad);
        lsBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsBuscarMouseClicked(evt);
            }
        });
        lsBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lsBuscarKeyPressed(evt);
            }
        });
        lsBuscar.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lsBuscarValueChanged(evt);
            }
        });
        utilidades.fillJList(lsBuscar,"Producto");
        jScrollPane3.setViewportView(lsBuscar);

        lbCantidad.setText("Cantidad:");

        lbPrecio.setText("Precio: $ 0.00");

        lbDescuento.setText("Descuento:");
        lbDescuento.setToolTipText("Descuento al precio unitario del producto");

        tbDescuento.setText("0.00");
        tbDescuento.setToolTipText("Dejar en blanco si no se aplicara desuento");

        feedbackCorrecto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        feedbackCorrecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gr_chk.png"))); // NOI18N
        feedbackCorrecto.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/error.png"))); // NOI18N

        feedbackError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        feedbackError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/error.png"))); // NOI18N
        feedbackError.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lbFeedback.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbFeedback.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbFeedback.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelProductoLayout = new javax.swing.GroupLayout(panelProducto);
        panelProducto.setLayout(panelProductoLayout);
        panelProductoLayout.setHorizontalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelProductoLayout.createSequentialGroup()
                                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbExistencia)
                                    .addComponent(cbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbCantidad)
                                    .addComponent(lbDescuento))
                                .addGap(11, 11, 11)
                                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tbBuscar, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCantidad, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbPrecio, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbDescuento))
                                .addGap(44, 44, 44))
                            .addGroup(panelProductoLayout.createSequentialGroup()
                                .addComponent(btAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                    .addGroup(panelProductoLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(feedbackError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(feedbackCorrecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52))
                    .addGroup(panelProductoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(lbDescuento)
                    .addComponent(tbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbExistencia)
                    .addComponent(lbPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAgregar)
                .addGap(28, 28, 28)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(feedbackCorrecto)
                    .addComponent(feedbackError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(lbFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbRegistro.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro"));
        lbRegistro.setToolTipText("");

        lbFecha.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFecha.setText("Fecha De Expedicion");

        lbFechaExpedicion.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFechaExpedicion.setText(utilidades.getDate());

        lbFactura.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lbFactura.setText("No. Venta");

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbRegistroLayout.createSequentialGroup()
                        .addComponent(lbNumeroFactura)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbRegistroLayout.createSequentialGroup()
                        .addComponent(lbFactura)
                        .addContainerGap())))
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
        btVender.setNextFocusableComponent(btCancelar);
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
        lbEmpleado.setText("Empleado: "+LogIn.usuario.getNombre()+" "+LogIn.usuario.getApellido());
        lbEmpleado.setToolTipText("Cambiar de usuario");
        lbEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEmpleadoMouseClicked(evt);
            }
        });

        dgvPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CANTIDAD", "NOMBRE", "PRECIO UNITARIO", "DESCUENTO", "SUBTOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);

        dgvPedidos.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        dgvPedidos.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        jScrollPane2.setViewportView(dgvPedidos);

        lbPedidos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbPedidos.setText("Productos a vender:");
        lbPedidos.setToolTipText("");

        btCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
        btCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCerrarSesionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btVender, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(lbPedidos)
                    .addComponent(btVender)
                    .addComponent(lbEmpleado)
                    .addComponent(lbTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbEmpleado.getAccessibleContext().setAccessibleName("");
        lbEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

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
            Double desc = Double.valueOf(tbDescuento.getText());
            if (evt.getClickCount() == 2 && list.getModel().getSize() > 0 &&
                    utilidades.getExistenciaByNombre(lsBuscar.getSelectedValue())>0)
            {
                utilidades.addToJTableVenta(dgvPedidos, lsBuscar.getSelectedValue(),cbx,desc);
                dgvPedidos.setDefaultEditor(Object.class, null);
                dgvPedidos.setRowSelectionAllowed(true);
                lbTotal.setText(totalAPagar + df.format(utilidades.getTotal()));
                tbDescuento.setText("0.00");
            }
        }
    }//GEN-LAST:event_lsBuscarMouseClicked
    private void actualizarCantidadInventario(JList list)
    {
        String existencia = String.valueOf(utilidades.getExistenciaByNombre(
                list.getSelectedValue().toString()));
        String precio = String.valueOf(df.format(utilidades.getPrecioByNombre(
                list.getSelectedValue().toString())));
        toggleExistencia(Integer.valueOf(existencia));
        lbExistencia.setText("Existencia: " + existencia);
        lbPrecio.setText("Precio: " + precio);
    }
    private void btVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVenderActionPerformed
        if (dgvPedidos.getRowCount() >= 1) {
            if (cliente == null) cliente = new Cliente();
            if (rbAnonimo.isSelected()) {
                cliente.setNombre(rbAnonimo.getText());
                cliente.setApellido("");
            } else if (rbExistente.isSelected()) {
                cliente.setNombre(tbNombreCliente.getText());
                cliente.setApellido(tbApellidoCliente.getText());
            }
            
            try {
                utilidades.crearVenta(cliente, LogIn.usuario.getIdUsuario());
            } catch (Exception e) {
                utilidades.mostrarAlerta(e + "", "Error");
            } finally {
                actualizarCantidadInventario(lsBuscar);
                focusRb();
                imgExito();
            }
        } else {
            utilidades.mostrarAlerta("No puede vender si no se han agregado productos",
                    "Error");
        }
    }//GEN-LAST:event_btVenderActionPerformed

    private void rbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNuevoActionPerformed
        tbNombreCliente.setEnabled(true);
        tbApellidoCliente.setEnabled(true);
        tbDUICliente.setEnabled(true);
        tbDireccion.setEnabled(true);
        tbTelefono.setEnabled(true);
        lsBuscarCliente.setVisible(false);
        tbBuscarCliente.setVisible(false);
        lbFactura5.setVisible(false);
        btAgregarNuevoCliente.setEnabled(true);
    }//GEN-LAST:event_rbNuevoActionPerformed

    private void rbExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbExistenteActionPerformed
        tbNombreCliente.setEnabled(true);
        tbApellidoCliente.setEnabled(true);
        tbDUICliente.setEnabled(false);
        tbDireccion.setEnabled(false);
        tbTelefono.setEnabled(false);
        lsBuscarCliente.setVisible(true);
        tbBuscarCliente.setVisible(true);
        lbFactura5.setVisible(true);
        btAgregarNuevoCliente.setEnabled(false);
    }//GEN-LAST:event_rbExistenteActionPerformed

    private void rbAnonimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAnonimoActionPerformed
        tbNombreCliente.setEnabled(false);
        tbApellidoCliente.setEnabled(false);
        tbDUICliente.setEnabled(false);
        tbDireccion.setEnabled(false);
        tbTelefono.setEnabled(false);
        lsBuscarCliente.setVisible(false);
        tbBuscarCliente.setVisible(false);
        lbFactura5.setVisible(false);
        btAgregarNuevoCliente.setEnabled(false);
    }//GEN-LAST:event_rbAnonimoActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        java.awt.event.MouseEvent evts = new java.awt.event.MouseEvent(lsBuscar, 0, 0, 0, 0, 0, 2, true);
        this.lsBuscarMouseClicked(evts);
    }//GEN-LAST:event_btAgregarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        utilidades.clearJTable(dgvPedidos);
        lbTotal.setText(totalAPagar + "$ 0.00");
    }//GEN-LAST:event_btCancelarActionPerformed

    private void dgvPedidosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvPedidosMouseReleased
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
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
                    .getExistenciaByNombre((String) dgvPedidos
                            .getModel()
                            .getValueAt(dgvPedidos.getSelectedRow(), 1)))
            {
                num = -1;
                utilidades.mostrarAlerta("La cantidad ingresada exede la cantidad"
                        + " disponible, intente de nuevo.", "Cantidad no válida!");
            }
        }
        utilidades.setCantidadJtable(dgvPedidos, dgvPedidos.getSelectedRow(), num);
        lbTotal.setText(totalAPagar + df.format(utilidades.getTotal()));
    }//GEN-LAST:event_miModificarCantidadActionPerformed

    private void lsBuscarValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lsBuscarValueChanged
        if (lsBuscar.getModel().getSize() > 0 && lsBuscar.getSelectedIndex() > -1)
        {
            actualizarCantidadInventario(lsBuscar);
        }
        else if (lsBuscar.getModel().getSize() <= 0) {
            lbExistencia.setText("Existencia: 0");
            lbPrecio.setText("Precio: $ 0.00");
        }
    }//GEN-LAST:event_lsBuscarValueChanged

    private void lsBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lsBuscarKeyPressed
        if (evt.getKeyCode() == 10) {
            java.awt.event.MouseEvent evts = new java.awt.event.MouseEvent(lsBuscar, 0, 0, 0, 0, 0, 2, true);
            this.lsBuscarMouseClicked(evts);
        }      
    }//GEN-LAST:event_lsBuscarKeyPressed

    private void btAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btAgregarKeyPressed
        if (evt.getKeyCode() == 10) {
            java.awt.event.MouseEvent evts = new java.awt.event.MouseEvent(lsBuscar, 0, 0, 0, 0, 0, 2, true);
            this.lsBuscarMouseClicked(evts);
        } 
    }//GEN-LAST:event_btAgregarKeyPressed

    private void lbEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEmpleadoMouseClicked
        int opcion = JOptionPane.showConfirmDialog(panelCliente,
                "¿Estas seguro que deseas cambiar de usuario?",
                "Cambiar usuario",
                JOptionPane.OK_CANCEL_OPTION);
        if (opcion == 0) {
            new LogIn().setVisible(true);
            LogIn.usuario = null;
            this.dispose();
        }
    }//GEN-LAST:event_lbEmpleadoMouseClicked

    private void btAgregarNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarNuevoClienteActionPerformed
        List<Telefono> telefonos = new ArrayList<>();
        cliente = new Cliente();
        if (tbTelefono.getText().contains(",")) {
            String[] tels = tbTelefono.getText().split(",");
            for (String tel : tels) {
                if (!tel.trim().isEmpty()) {
                    Telefono telefono = new Telefono();
                    telefono.setTelefono(tel.trim());
                    telefonos.add(telefono);
                }
            }
        } else {
            if (!tbTelefono.getText().trim().isEmpty()) {
                Telefono tel = new Telefono();
                tel.setTelefono(tbTelefono.getText().trim());
                telefonos.add(tel);
            }
        }
        cliente.setNombre(tbNombreCliente.getText());
        cliente.setApellido(tbApellidoCliente.getText());
        cliente.setDui(tbDUICliente.getText());
        cliente.setDireccion(tbDireccion.getText());
        if (!telefonos.isEmpty()) {
            cliente.setTelefonoList(telefonos);
        }
        utilidades.AgregarCliente(cliente);
    }//GEN-LAST:event_btAgregarNuevoClienteActionPerformed

    private void tbBuscarClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbBuscarClienteKeyTyped
        Integer cantidad = tbBuscarCliente.getText().length();
        if (cantidad >=2) {
            utilidades.fillJList(lsBuscar, "Nombre", tbBuscarCliente.getText(), "cliente");
        }
        else ;
    }//GEN-LAST:event_tbBuscarClienteKeyTyped

    private void btCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCerrarSesionMouseClicked
        if (LogIn.usuario.getIdRol().getIdRol() == 1) {
            new PrincipalAdmin().setVisible(true);
        }
        else
        {
            LogIn.usuario = null;
            new LogIn().setVisible(true);
        }       
        this.dispose();
    }//GEN-LAST:event_btCerrarSesionMouseClicked
    private static int stringToInt(String string) {
        try {
            int var = Integer.parseInt(string);
            if (var >= 1) return var;
            else return -1;
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "El numero que ingresó no es válido, porfavor intente de nuevo",
                    "Ingrese un numero valido",
                    JOptionPane.WARNING_MESSAGE);
            return -1;
        }
    }
    public void toggleExistencia(int existencia)
    {
        if (existencia == 0)
        {
            lbExistencia.setForeground(Color.RED);
            imgError("Sin exitencia");
        }
        else
        {
            lbExistencia.setForeground(Color.BLACK);
            imgNada();
        }
    }
    public void imgNada()
    {
        feedbackError.setVisible(false);
        feedbackCorrecto.setVisible(false);
        lbFeedback.setText("");
    }
    public void imgError(String txt)
    {
        feedbackCorrecto.setVisible(false);
        feedbackError.setVisible(true);
        lbFeedback.setText(txt);
        lbFeedback.setForeground(Color.RED);
    }
    public void imgExito()
    {
        if (Utilidades.transacionExitosa)
        {
            feedbackError.setVisible(false);
            feedbackCorrecto.setVisible(true);
            lbFeedback.setText("Venta satisfactoria");
            lbFeedback.setForeground(Color.GREEN);
            Utilidades.transacionExitosa = false;
            lbTotal.setText(totalAPagar + "$ 0.00");
        }
    }
    public void focusRb()
    {
        rbAnonimo.setSelected(true);
        java.awt.event.ActionEvent evt =  new java.awt.event.ActionEvent(this, 0, "");
        rbExistenteActionPerformed(evt);
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
    private javax.swing.JButton btAgregarNuevoCliente;
    private javax.swing.JButton btCancelar;
    private javax.swing.JLabel btCerrarSesion;
    private javax.swing.JButton btVender;
    private javax.swing.JComboBox<String> cbBuscar;
    private javax.swing.JComboBox cbCantidad;
    public static javax.swing.JTable dgvPedidos;
    private javax.swing.JLabel feedbackCorrecto;
    private javax.swing.JLabel feedbackError;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lbCantidad;
    private javax.swing.JLabel lbDescuento;
    private javax.swing.JLabel lbEmpleado;
    private javax.swing.JLabel lbExistencia;
    private javax.swing.JLabel lbFactura;
    private javax.swing.JLabel lbFactura1;
    private javax.swing.JLabel lbFactura2;
    private javax.swing.JLabel lbFactura3;
    private javax.swing.JLabel lbFactura4;
    private javax.swing.JLabel lbFactura5;
    private javax.swing.JLabel lbFactura6;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbFechaExpedicion;
    private javax.swing.JLabel lbFeedback;
    private javax.swing.JLabel lbNumeroFactura;
    private javax.swing.JLabel lbPedidos;
    private javax.swing.JLabel lbPrecio;
    private javax.swing.JPanel lbRegistro;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JList<String> lsBuscar;
    private javax.swing.JList<String> lsBuscarCliente;
    private javax.swing.JMenuItem miEliminarElemento;
    private javax.swing.JMenuItem miModificarCantidad;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JPanel panelProducto;
    private javax.swing.JPopupMenu ppmDataGrid;
    public static javax.swing.JRadioButton rbAnonimo;
    private javax.swing.JRadioButton rbExistente;
    private javax.swing.ButtonGroup rbGrupo1;
    private javax.swing.JRadioButton rbNuevo;
    private javax.swing.JTextField tbApellidoCliente;
    private javax.swing.JTextField tbBuscar;
    private javax.swing.JTextField tbBuscarCliente;
    private javax.swing.JTextField tbDUICliente;
    private javax.swing.JTextField tbDescuento;
    private javax.swing.JTextField tbDireccion;
    private javax.swing.JTextField tbNombreCliente;
    private javax.swing.JTextField tbTelefono;
    // End of variables declaration//GEN-END:variables
}
