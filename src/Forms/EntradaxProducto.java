package Forms;

import Model.Productos;
import Entities.Producto;
import Entities.Proveedor;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Tejada
 */
public class EntradaxProducto extends javax.swing.JFrame {
    private int LidProducto;
    private final Date fechaActual = new Date();
    private final DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    
    private final Utilidades utilidades = new Utilidades();
    private ArrayList<Productos> lpn = new ArrayList<>();
    
    public EntradaxProducto() {
        initComponents();
        
        lbFecha.setText(formatoFecha.format(fechaActual));
        
        llenarproveedores();
        
        utilidades.fillJTable(TbBProduct);
        
        deshabilitarPP();
        
        dpFechaFactura.setDate(fechaActual);
        dpFechaVencimiento.setDate(fechaActual);
        
        utilidades.setScreenCentered(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProducto = new javax.swing.JPanel();
        tbNombre = new javax.swing.JTextField();
        tbMarca = new javax.swing.JTextField();
        tbPrecioU = new javax.swing.JTextField();
        lbNonbre = new javax.swing.JLabel();
        lbPrecio = new javax.swing.JLabel();
        lbMarca = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDescripcion = new javax.swing.JTextArea();
        lbDescripcion = new javax.swing.JLabel();
        lbFechaVencimiento = new javax.swing.JLabel();
        dpFechaVencimiento = new org.jdesktop.swingx.JXDatePicker();
        lbCantidad = new javax.swing.JLabel();
        btnAgregarProd = new javax.swing.JButton();
        TBCategoria = new javax.swing.JTextField();
        lbFechaVencimiento1 = new javax.swing.JLabel();
        dpFechaFactura = new org.jdesktop.swingx.JXDatePicker();
        lbFechaFactura = new javax.swing.JLabel();
        cbAhora = new javax.swing.JCheckBox();
        tbCantidad = new javax.swing.JTextField();
        lbCantidadEnExistencia = new javax.swing.JLabel();
        panelProveedor = new javax.swing.JPanel();
        CBProveedores = new javax.swing.JComboBox<>();
        tbNombreP = new javax.swing.JTextField();
        tbDireccionP = new javax.swing.JTextField();
        lblNombreP = new javax.swing.JLabel();
        lblDireccionP = new javax.swing.JLabel();
        tbtelefonop = new javax.swing.JTextField();
        lbltelefonoP = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tbRepresentante = new javax.swing.JTextField();
        cbNuevoProv = new javax.swing.JCheckBox();
        tbBuscarProveedor = new javax.swing.JTextField();
        lbBuscarProv = new javax.swing.JLabel();
        PanelBusqueda = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TbBProduct = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btAgregarProducto = new javax.swing.JButton();
        btnBuscarP = new javax.swing.JButton();
        txtBusquedaP = new javax.swing.JTextField();
        lbLogOut = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btGuardarEntrada = new javax.swing.JButton();
        btEliminarProducto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgvEntradas = new javax.swing.JTable();
        lbFecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compras");
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 768));

        panelProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Producto Entrante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        tbNombre.setEditable(false);

        tbMarca.setEditable(false);

        tbPrecioU.setNextFocusableComponent(tbCantidad);
        tbPrecioU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrarDobleCick(evt);
            }
        });
        tbPrecioU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbPrecioUKeyTyped(evt);
            }
        });

        lbNonbre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbNonbre.setText("Nombre:");

        lbPrecio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbPrecio.setText("Precio venta c/u:");

        lbMarca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbMarca.setText("Marca:");

        tbDescripcion.setEditable(false);
        tbDescripcion.setColumns(20);
        tbDescripcion.setRows(5);
        jScrollPane1.setViewportView(tbDescripcion);

        lbDescripcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbDescripcion.setText("Descripcion del producto:");

        lbFechaVencimiento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbFechaVencimiento.setText("Vencimiento:");

        lbCantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbCantidad.setText("Cantidad:");

        btnAgregarProd.setBackground(new java.awt.Color(204, 255, 204));
        btnAgregarProd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/agregaracarro.png"))); // NOI18N
        btnAgregarProd.setText("Agregar A la compra");
        btnAgregarProd.setNextFocusableComponent(txtBusquedaP);
        btnAgregarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProdActionPerformed(evt);
            }
        });

        TBCategoria.setEditable(false);

        lbFechaVencimiento1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbFechaVencimiento1.setText("Categoria:");

        lbFechaFactura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbFechaFactura.setText("Fecha de factura:");

        cbAhora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbAhora.setText("Seleccionar Fecha:");
        cbAhora.setNextFocusableComponent(btnAgregarProd);
        cbAhora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAhoraActionPerformed(evt);
            }
        });

        tbCantidad.setNextFocusableComponent(cbAhora);
        tbCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrarDobleCick(evt);
            }
        });
        tbCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbCantidadKeyTyped(evt);
            }
        });

        lbCantidadEnExistencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbCantidadEnExistencia.setForeground(new java.awt.Color(0, 0, 204));
        lbCantidadEnExistencia.setText("Cantidad en existencia:");

        javax.swing.GroupLayout panelProductoLayout = new javax.swing.GroupLayout(panelProducto);
        panelProducto.setLayout(panelProductoLayout);
        panelProductoLayout.setHorizontalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelProductoLayout.createSequentialGroup()
                            .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbMarca)
                                .addComponent(lbFechaVencimiento1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TBCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addComponent(tbMarca))))
                    .addComponent(lbDescripcion)
                    .addComponent(lbNonbre)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tbCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dpFechaVencimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProductoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelProductoLayout.createSequentialGroup()
                                .addComponent(lbFechaFactura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbAhora, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbCantidad)
                            .addGroup(panelProductoLayout.createSequentialGroup()
                                .addComponent(lbPrecio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tbPrecioU, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCantidadEnExistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelProductoLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(dpFechaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelProductoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnAgregarProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelProductoLayout.setVerticalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNonbre)
                    .addComponent(tbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPrecio)
                    .addComponent(tbPrecioU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMarca)
                    .addComponent(lbCantidad)
                    .addComponent(tbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFechaVencimiento1)
                    .addComponent(lbFechaVencimiento)
                    .addComponent(dpFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescripcion)
                    .addComponent(cbAhora)
                    .addComponent(lbFechaFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductoLayout.createSequentialGroup()
                        .addComponent(dpFechaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCantidadEnExistencia)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarProd, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        lbCantidadEnExistencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        panelProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione el proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 51, 51))); // NOI18N

        CBProveedores.setEnabled(false);

        tbNombreP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbNombrePKeyTyped(evt);
            }
        });

        lblNombreP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombreP.setText("Nombre:");

        lblDireccionP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDireccionP.setText("Descripcion:");

        tbtelefonop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbtelefonopKeyTyped(evt);
            }
        });

        lbltelefonoP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltelefonoP.setText("Telefono:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Seleccione:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Representante del proveedor (Nombre)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 0))); // NOI18N

        tbRepresentante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbRepresentanteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        cbNuevoProv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbNuevoProv.setSelected(true);
        cbNuevoProv.setText("Agregar nuevo proveedor");
        cbNuevoProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNuevoProvActionPerformed(evt);
            }
        });

        tbBuscarProveedor.setEnabled(false);
        tbBuscarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbBuscarProveedorKeyTyped(evt);
            }
        });

        lbBuscarProv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbBuscarProv.setText("Buscar prov:");

        javax.swing.GroupLayout panelProveedorLayout = new javax.swing.GroupLayout(panelProveedor);
        panelProveedor.setLayout(panelProveedorLayout);
        panelProveedorLayout.setHorizontalGroup(
            panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProveedorLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CBProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProveedorLayout.createSequentialGroup()
                        .addComponent(lblDireccionP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbDireccionP, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelProveedorLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(panelProveedorLayout.createSequentialGroup()
                        .addComponent(lbltelefonoP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbtelefonop, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelProveedorLayout.createSequentialGroup()
                        .addComponent(lbBuscarProv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProveedorLayout.createSequentialGroup()
                        .addComponent(lblNombreP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbNuevoProv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(tbNombreP, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        panelProveedorLayout.setVerticalGroup(
            panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProveedorLayout.createSequentialGroup()
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBuscarProv)
                    .addComponent(tbBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(CBProveedores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbNuevoProv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreP)
                    .addComponent(tbNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbDireccionP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccionP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltelefonoP)
                    .addComponent(tbtelefonop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busque productos existentes y seleccione ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 51, 204))); // NOI18N

        TbBProduct.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TbBProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Marca", "Categoria", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbBProduct.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TbBProduct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TbBProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbBProductMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TbBProductMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(TbBProduct);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        btAgregarProducto.setBackground(new java.awt.Color(204, 204, 255));
        btAgregarProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btAgregarProducto.setForeground(new java.awt.Color(0, 0, 255));
        btAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/agregarproducto.png"))); // NOI18N
        btAgregarProducto.setText("Agregar nuevo producto");
        btAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarProductoActionPerformed(evt);
            }
        });

        btnBuscarP.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscarP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/buscar.png"))); // NOI18N
        btnBuscarP.setText("Buscar productos");
        btnBuscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPActionPerformed(evt);
            }
        });

        txtBusquedaP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBusquedaP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrarDobleCick(evt);
            }
        });
        txtBusquedaP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaPKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout PanelBusquedaLayout = new javax.swing.GroupLayout(PanelBusqueda);
        PanelBusqueda.setLayout(PanelBusquedaLayout);
        PanelBusquedaLayout.setHorizontalGroup(
            PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBusquedaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(206, 206, 206))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBusquedaLayout.createSequentialGroup()
                        .addComponent(txtBusquedaP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAgregarProducto)))
                .addContainerGap())
        );
        PanelBusquedaLayout.setVerticalGroup(
            PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBusquedaLayout.createSequentialGroup()
                .addGroup(PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarP, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusquedaP, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/logout.png"))); // NOI18N
        lbLogOut.setToolTipText("Volver atrás");
        lbLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogOutMouseClicked(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos en compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        btGuardarEntrada.setBackground(new java.awt.Color(204, 255, 204));
        btGuardarEntrada.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btGuardarEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/guardar.png"))); // NOI18N
        btGuardarEntrada.setText("Finalizar compra");
        btGuardarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarEntradaActionPerformed(evt);
            }
        });

        btEliminarProducto.setBackground(new java.awt.Color(255, 102, 102));
        btEliminarProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/eliminar.png"))); // NOI18N
        btEliminarProducto.setText("Eliminar Producto en compra");
        btEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarProductoActionPerformed(evt);
            }
        });

        dgvEntradas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dgvEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Marca", "Categoria", "Descripcion", "Precio", "Cantidad", "Caducidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgvEntradas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(dgvEntradas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                        .addComponent(btGuardarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btEliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btGuardarEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFecha.setText("12-12-12");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PanelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbLogOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbFecha)
                    .addComponent(lbLogOut))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(PanelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGuardarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarEntradaActionPerformed
        int x=0;
        if(validarCamposGuardarEnt()){
            if(cbNuevoProv.isSelected()){
                Proveedor prv = new Proveedor();
                prv.setProveedor(tbNombreP.getText().trim());
                prv.setDireccion(tbDireccionP.getText().trim());
                prv.setTelefonoList(utilidades.insertarTelefono(tbtelefonop.getText().trim()));
                
                x=utilidades.crearDetCompra(
                        lpn,utilidades.agregarProveedor(prv),
                        dpFechaFactura.getDate(),tbRepresentante.getText(),"");
                
                llenarproveedores();
            }
            else if(!cbNuevoProv.isSelected()){
                x=utilidades.crearDetCompra(
                        lpn,utilidades.findProvByName(CBProveedores.getSelectedItem().toString()),
                        dpFechaFactura.getDate(),tbRepresentante.getText(),"");
            }
            if(x!=-1){
                JOptionPane.showMessageDialog(null, "Registro existoso","Registro",JOptionPane.INFORMATION_MESSAGE);
                clearforNew();
                deshabilitarPP();
                utilidades.clearJTable(dgvEntradas);
                lpn.clear();
            }
        }
        else if(!validarCamposGuardarEnt()){
            JOptionPane.showMessageDialog(null, "Algun campo esta vacio","Registro",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btGuardarEntradaActionPerformed

    private void btnBuscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPActionPerformed
        if(txtBusquedaP.getText().length()!=0){
            utilidades.fillJTable(TbBProduct,"Producto","producto",txtBusquedaP.getText());
            TbBProduct.setDefaultEditor(Object.class,null);
        }
        else if(txtBusquedaP.getText().length()==0){
            utilidades.fillJTable(TbBProduct);
            TbBProduct.setDefaultEditor(Object.class,null);
        }
    }//GEN-LAST:event_btnBuscarPActionPerformed

    private void btnAgregarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProdActionPerformed
        if(validarCamposAggProd()){
            int existente;
            existente=utilidades.buscarProdEnArrayEP(lpn,LidProducto);
            if(existente==-1){
                
                lpn.add(new Productos(LidProducto,TBCategoria.getText(),tbMarca.getText(),
                        tbNombre.getText(),tbDescripcion.getText(),
                        Double.parseDouble(tbPrecioU.getText()),
                        Integer.parseInt(tbCantidad.getText()),dpFechaVencimiento.getDate()));
                utilidades.llenarJtablePE(lpn, dgvEntradas);
            }else if(existente!=-1){
                int r= JOptionPane.showConfirmDialog(
                        null,"AVISO! Ya tiene ese producto en lista de compra si continua se aumentara el producto, se editara la caducidad y el precio. ¿desea continuar?","CONTINUAR!",JOptionPane.YES_NO_OPTION);
                switch (r) {
                    case JOptionPane.YES_OPTION:
                        lpn.get(existente).
                                setCantidad(lpn.get(existente).getCantidad()+
                                        Integer.parseInt(tbCantidad.getText()));
                        lpn.get(existente).setFechavencimiento(dpFechaVencimiento.getDate());
                        lpn.get(existente).setPrecio(Double.parseDouble(tbPrecioU.getText()));
                        utilidades.llenarJtablePE(lpn, dgvEntradas);
                        break;
                    case JOptionPane.NO_OPTION:
                        break;
                    case JOptionPane.CLOSED_OPTION:
                        break;
                    default:
                        break;
                }
            }
        }
        else if(!validarCamposAggProd()){
            JOptionPane.showMessageDialog(null, "Algun campo esta vacio","Registro",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarProdActionPerformed

    private void btAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarProductoActionPerformed
        FormProducto prod = new FormProducto();
        Object[] options = { "REGRESAR"};
        JOptionPane.showOptionDialog(null,prod.getContentPane(), "Productos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
                null, options, options[0]);
        utilidades.fillJTable(TbBProduct);
    }//GEN-LAST:event_btAgregarProductoActionPerformed

    private void TbBProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbBProductMouseClicked
        habilitarPP();
        int fila = TbBProduct.getSelectedRow();
        if (fila != -1 && fila >= 0){
            int cell = Integer.valueOf(TbBProduct.getModel().getValueAt(fila, 0).toString());
            List<Producto> listado1=utilidades.obtenerproducto("Producto",cell,"idProducto");
            LidProducto=listado1.get(0).getIdProducto();
            tbNombre.setText(listado1.get(0).getProducto());
            tbMarca.setText(listado1.get(0).getIdMarca().getMarca());
            tbPrecioU.setText(Double.toString(listado1.get(0).getPrecio()));
            tbDescripcion.setText(listado1.get(0).getDescripcion());
            TBCategoria.setText(listado1.get(0).getIdCategoria().getCategoria());
            
            lbCantidadEnExistencia.setText("Cantidad en existencia: " + utilidades.getExistenciaByNombre(tbNombre.getText()));
        }
    }//GEN-LAST:event_TbBProductMouseClicked

    private void tbPrecioUKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPrecioUKeyTyped
        if((!Character.isDigit(evt.getKeyChar())&&(evt.getKeyChar()!='.'))) {
            evt.consume();
        }
        if((evt.getKeyChar()=='.')&&(tbPrecioU.getText().contains("."))) {
            evt.consume();
        }
        if(tbPrecioU.getText().length()>10){
            evt.consume();
        }
    }//GEN-LAST:event_tbPrecioUKeyTyped

    private void tbNombrePKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbNombrePKeyTyped
        if(!Character.isAlphabetic(evt.getKeyChar())&&(evt.getKeyChar()!=' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_tbNombrePKeyTyped

    private void tbtelefonopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbtelefonopKeyTyped
        if(!Character.isDigit(evt.getKeyChar())&&(evt.getKeyChar()!='-')&&(evt.getKeyChar()!=',')) {
            evt.consume();
        }
    }//GEN-LAST:event_tbtelefonopKeyTyped

    private void tbRepresentanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbRepresentanteKeyTyped
        if(!Character.isAlphabetic(evt.getKeyChar())&&(evt.getKeyChar()!=' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_tbRepresentanteKeyTyped

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        utilidades.fillJTable(TbBProduct);
        TbBProduct.setDefaultEditor(Object.class,null);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtBusquedaPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaPKeyTyped
        utilidades.fillJTable(TbBProduct,"Producto","producto",txtBusquedaP.getText());
        TbBProduct.setDefaultEditor(Object.class,null);
    }//GEN-LAST:event_txtBusquedaPKeyTyped

    private void btEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarProductoActionPerformed
        if (dgvEntradas.getRowCount() > 0) {
            int r= JOptionPane.showConfirmDialog(null,"confirmar eliminacion de producto","CONTINUAR!",JOptionPane.YES_NO_OPTION);
            switch (r) {
                case JOptionPane.YES_OPTION:
                    int fila = dgvEntradas.getSelectedRow();
                    int idproducto = Integer.parseInt(dgvEntradas.getValueAt(fila,0).toString());
                    utilidades.eliminarProdPE(lpn, idproducto);
                    utilidades.llenarJtablePE(lpn, dgvEntradas);
                    break;
                case JOptionPane.NO_OPTION:
                    break;
                case JOptionPane.CLOSED_OPTION:
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_btEliminarProductoActionPerformed

    private void lbLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseClicked
        if (LogIn.usuario.getIdRol().getIdRol() == 1) new PrincipalAdmin().setVisible(true);
        else new PrincipalEmpleado().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbLogOutMouseClicked

    private void cbAhoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAhoraActionPerformed
        if (cbAhora.isSelected()) {
            dpFechaFactura.setDate(new Date());
            cbAhora.setText("Ahora");
        }
        else cbAhora.setText("Seleccionar fecha");
        dpFechaFactura.setEnabled(!cbAhora.isSelected());
    }//GEN-LAST:event_cbAhoraActionPerformed

    private void cbNuevoProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNuevoProvActionPerformed
        if(cbNuevoProv.isSelected()){
            CBProveedores.setEnabled(false);
            tbBuscarProveedor.setEnabled(false);
            tbNombreP.setEnabled(true);
            tbDireccionP.setEnabled(true);
            tbtelefonop.setEnabled(true);
            lblNombreP.setEnabled(true);
            lblDireccionP.setEnabled(true);
            lbltelefonoP.setEnabled(true);
        }
        else if(!cbNuevoProv.isSelected()){
            CBProveedores.setEnabled(true);
            tbBuscarProveedor.setEnabled(true);
            tbNombreP.setEnabled(false);
            tbDireccionP.setEnabled(false);
            tbtelefonop.setEnabled(false);
            lblNombreP.setEnabled(false);
            lblDireccionP.setEnabled(false);
            lbltelefonoP.setEnabled(false);
        }
    }//GEN-LAST:event_cbNuevoProvActionPerformed

    private void borrarDobleCick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarDobleCick
        if (evt.getClickCount() == 2) {
            javax.swing.JTextField comp = (javax.swing.JTextField) evt.getComponent();
            comp.setText("");
        }
    }//GEN-LAST:event_borrarDobleCick

    private void tbBuscarProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbBuscarProveedorKeyTyped
        if (tbBuscarProveedor.getText().trim().length()>=2) {
            llenarproveedores(tbBuscarProveedor.getText().trim());
        }
        else llenarproveedores();
    }//GEN-LAST:event_tbBuscarProveedorKeyTyped

    private void tbCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbCantidadKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_tbCantidadKeyTyped

    private void TbBProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbBProductMousePressed
        TbBProductMouseClicked(new java.awt.event.MouseEvent(this,0,0,0,0,0,1,false));
    }//GEN-LAST:event_TbBProductMousePressed
    
    private void clearforNew(){
        lpn=null;
        tbNombre.setText("");
        tbDescripcion.setText("");
        tbDireccionP.setText("");
        tbMarca.setText("");
        tbPrecioU.setText("");
        tbRepresentante.setText("");
        TBCategoria.setText("");
        tbNombreP.setText("");
        tbDireccionP.setText("");
        tbtelefonop.setText("");
        lpn=new ArrayList<>();
    }
    private void deshabilitarPP(){
        for(int i=0;i<panelProducto.getComponents().length;i++) {
            panelProducto.getComponent(i).setEnabled(false);
        }
    }
    private void habilitarPP(){
        for(int i=0;i<panelProducto.getComponents().length;i++) {
            panelProducto.getComponent(i).setEnabled(true);
        }
    }
    
    private void llenarproveedores(){
        CBProveedores.removeAllItems();
        for(Proveedor p : utilidades.fillcomboboxp()){
            CBProveedores.addItem(p.getProveedor());
        }
    }
    
    private void llenarproveedores(String proveedor){
        CBProveedores.removeAllItems();
        for(Proveedor p : utilidades.fillcomboboxp(proveedor)){
            CBProveedores.addItem(p.getProveedor());
        }
    }
    
    private boolean validarCamposAggProd(){
        boolean validado=false;
        if((tbNombre.getText().length()!=0)&&(TBCategoria.getText().length()!=0)&&
                (tbDescripcion.getText().length()!=0)&&(tbMarca.getText().length()!=0)&&
                (tbPrecioU.getText().length()!=0)&&(dpFechaVencimiento.getDate()!=null)&&
                (tbCantidad.getText().length()!=0)){
            validado=true;
        }
        else if((tbNombre.getText().length()==0)||(TBCategoria.getText().length()==0)||
                (tbDescripcion.getText().length()==0)||(tbMarca.getText().length()==0)||
                (tbPrecioU.getText().length()==0)||(dpFechaVencimiento.getDate()==null)||
                (tbCantidad.getText().length()==0)){
            validado=false;
        }
        return validado;
    }
    
    private boolean validarCamposGuardarEnt(){
        boolean validado=false;
        if(cbNuevoProv.isSelected())
        {
            if((tbNombreP.getText().length()!=0) && (tbDireccionP.getText().length()!=0) &&
                    (tbtelefonop.getText().length()!=0) && (validarrepresentante()==true) &&
                    (dgvEntradas.getRowCount()>0))
            {
                validado=true;
            }
        }
        else if(!cbNuevoProv.isSelected())
        {
            if((validarrepresentante())&&(dgvEntradas.getRowCount()>0))
            {
                validado=true;
            }
        }
        else validado=false;
        return validado;
    }
    
    private boolean validarrepresentante(){
        boolean validado=false;
        if((tbRepresentante.getText().length()!=0)){
            validado=true;
        }
        else if((tbRepresentante.getText().length()==0)){
            validado=false;
        }
        return validado;
    }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntradaxProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntradaxProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBProveedores;
    private javax.swing.JPanel PanelBusqueda;
    private javax.swing.JTextField TBCategoria;
    private javax.swing.JTable TbBProduct;
    private javax.swing.JButton btAgregarProducto;
    private javax.swing.JButton btEliminarProducto;
    private javax.swing.JButton btGuardarEntrada;
    private javax.swing.JButton btnAgregarProd;
    private javax.swing.JButton btnBuscarP;
    private javax.swing.JCheckBox cbAhora;
    private javax.swing.JCheckBox cbNuevoProv;
    private javax.swing.JTable dgvEntradas;
    private org.jdesktop.swingx.JXDatePicker dpFechaFactura;
    private org.jdesktop.swingx.JXDatePicker dpFechaVencimiento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbBuscarProv;
    private javax.swing.JLabel lbCantidad;
    private javax.swing.JLabel lbCantidadEnExistencia;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbFechaFactura;
    private javax.swing.JLabel lbFechaVencimiento;
    private javax.swing.JLabel lbFechaVencimiento1;
    private javax.swing.JLabel lbLogOut;
    private javax.swing.JLabel lbMarca;
    private javax.swing.JLabel lbNonbre;
    private javax.swing.JLabel lbPrecio;
    private javax.swing.JLabel lblDireccionP;
    private javax.swing.JLabel lblNombreP;
    private javax.swing.JLabel lbltelefonoP;
    private javax.swing.JPanel panelProducto;
    private javax.swing.JPanel panelProveedor;
    private javax.swing.JTextField tbBuscarProveedor;
    private javax.swing.JTextField tbCantidad;
    private javax.swing.JTextArea tbDescripcion;
    private javax.swing.JTextField tbDireccionP;
    private javax.swing.JTextField tbMarca;
    private javax.swing.JTextField tbNombre;
    private javax.swing.JTextField tbNombreP;
    private javax.swing.JTextField tbPrecioU;
    private javax.swing.JTextField tbRepresentante;
    private javax.swing.JTextField tbtelefonop;
    private javax.swing.JTextField txtBusquedaP;
    // End of variables declaration//GEN-END:variables
}
