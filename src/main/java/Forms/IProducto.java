package Forms;

import Entities.Producto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tejada
 */
public class IProducto extends javax.swing.JFrame {
        public int LidProducto=0;

    Utilidades utilidades = new Utilidades();
    public IProducto() {
        initComponents();
        utilidades.fillcomboboxcatp(this.CBCategoria);
        utilidades.fillcomboboxMarca(this.CBMarca);
        this.TBNuevaMarca.setEnabled(false);
        this.TBNuevaCategoria.setEnabled(false);
         String []titulos = {"codigo","producto","marca","categoria","descripcion"};
            DefaultTableModel Modelo = new DefaultTableModel(null,titulos);
        utilidades.fillJTable(this.tablaProd,"Producto",titulos);
        this.tablaProd.setDefaultEditor(Object.class,null);
        utilidades.setScreenCentered(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProd = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        RBNuevaMarca = new javax.swing.JRadioButton();
        TBNuevaMarca = new javax.swing.JTextField();
        CBMarca = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        CBCategoria = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TBNuevaCategoria = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TADescricpionP = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        TBPrecioP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TBnombreP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BtnEditar = new javax.swing.JButton();
        BTNAgregarP = new javax.swing.JButton();
        rbNuevaCategoria = new javax.swing.JRadioButton();
        btnNuevo = new javax.swing.JButton();
        TBBusqueda = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Productos");

        tablaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProdMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProd);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        RBNuevaMarca.setText("Agregue una nueva marca");
        RBNuevaMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBNuevaMarcaActionPerformed(evt);
            }
        });

        CBMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBMarcaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Seleccione una Marca");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Seleccione una Categoria");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("o");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("o");

        TADescricpionP.setColumns(20);
        TADescricpionP.setRows(5);
        jScrollPane1.setViewportView(TADescricpionP);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Descripcion :");

        TBPrecioP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TBPrecioPKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Precio :");

        TBnombreP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TBnombrePKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nombre del Producto :");

        BtnEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnEditar.setText("Editar Producto");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });

        BTNAgregarP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTNAgregarP.setText("Guardar Producto");
        BTNAgregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAgregarPActionPerformed(evt);
            }
        });

        rbNuevaCategoria.setText("Agregue una nueva categoria");
        rbNuevaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNuevaCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 385, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(BTNAgregarP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(CBMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RBNuevaMarca)
                                    .addComponent(TBNuevaMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(CBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbNuevaCategoria)
                                    .addComponent(TBNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TBPrecioP, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TBnombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TBnombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TBPrecioP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNAgregarP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(rbNuevaCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TBNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(RBNuevaMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TBNuevaMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setText("+ Agregar un nuevo producto");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        TBBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBBusquedaMouseClicked(evt);
            }
        });
        TBBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TBBusquedaKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("BUSCAR:");

        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNuevo)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(TBBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(244, 244, 244))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(307, 307, 307))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TBBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBMarcaActionPerformed

    }//GEN-LAST:event_CBMarcaActionPerformed

    private void RBNuevaMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBNuevaMarcaActionPerformed
        if(this.RBNuevaMarca.isSelected()){
        this.TBNuevaMarca.setEnabled(true);
        this.CBMarca.setEnabled(false);
        }
        else if(this.RBNuevaMarca.isSelected()==false){
        this.TBNuevaMarca.setEnabled(false);
        this.CBMarca.setEnabled(true);
        }
    }//GEN-LAST:event_RBNuevaMarcaActionPerformed

    private void BTNAgregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAgregarPActionPerformed
        if(validar()==true){
        String Categoria="";
        String Marca="";
        int x=0;
        if(this.rbNuevaCategoria.isSelected()){
            Categoria=this.TBNuevaCategoria.getText();
        }else if(this.rbNuevaCategoria.isSelected()==false){
            Categoria =this.CBCategoria.getSelectedItem().toString();
        }
        if(this.RBNuevaMarca.isSelected()){
            Marca=this.TBNuevaMarca.getText();
        }else if(this.RBNuevaMarca.isSelected()==false){
            Marca=this.CBMarca.getSelectedItem().toString();
        }
        
            x=utilidades.crearProducto(Categoria,
                Marca,this.TBnombreP.getText(),
                this.TADescricpionP.getText(),Double.parseDouble(this.TBPrecioP.getText()));
            if(x!=-1){
            JOptionPane.showMessageDialog(null, "Registro exitoso","Registro",JOptionPane.INFORMATION_MESSAGE);
                    String []titulos = {"codigo","producto","marca","categoria","descripcion"};
            DefaultTableModel Modelo = new DefaultTableModel(null,titulos);
            utilidades.fillJTable(this.tablaProd,"Producto",titulos);
            clear();
            }
        }else if(validar()==false){
        JOptionPane.showMessageDialog(null, "Algun campo esta vacio","Registro",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BTNAgregarPActionPerformed

    private void TBnombrePKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBnombrePKeyTyped

    }//GEN-LAST:event_TBnombrePKeyTyped

    private void TBPrecioPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBPrecioPKeyTyped
        if((!Character.isDigit(evt.getKeyChar())&&(evt.getKeyChar()!='.'))) {
            evt.consume();
        }
        if((evt.getKeyChar()=='.')&&(this.TBPrecioP.getText().contains("."))) {
            evt.consume();
        }
    }//GEN-LAST:event_TBPrecioPKeyTyped

    private void rbNuevaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNuevaCategoriaActionPerformed
        if(this.rbNuevaCategoria.isSelected()==true){
        this.CBCategoria.setEnabled(false);
        this.TBNuevaCategoria.setEnabled(true);
        }
        else if(this.rbNuevaCategoria.isSelected()==false){
        this.CBCategoria.setEnabled(true);
        this.TBNuevaCategoria.setEnabled(false);        
        }
    }//GEN-LAST:event_rbNuevaCategoriaActionPerformed

    private void TBBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBBusquedaKeyTyped

    }//GEN-LAST:event_TBBusquedaKeyTyped

    private void TBBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBBusquedaMouseClicked
        String []titulos = {"codigo","producto","marca","categoria","descripcion"};
        utilidades.fillJTable(this.tablaProd,"Producto","producto",this.TBBusqueda.getText(), titulos);
        this.tablaProd.setDefaultEditor(Object.class,null);
    }//GEN-LAST:event_TBBusquedaMouseClicked

    private void tablaProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProdMouseClicked
        this.BtnEditar.setEnabled(true);
        this.BTNAgregarP.setEnabled(false);
        int fila = this.tablaProd.getSelectedRow();
        int id=Integer.parseInt(this.tablaProd.getValueAt(fila,0).toString());
        List<Producto> listado1=utilidades.obtenerproducto("Producto",id,"idProducto");
        LidProducto=listado1.get(0).getIdProducto();
        this.TBnombreP.setText(listado1.get(0).getProducto());
        this.TBPrecioP.setText(Double.toString(listado1.get(0).getPrecio()));
        this.TADescricpionP.setText(listado1.get(0).getDescripcion());
        utilidades.fillcomboboxc(this.CBCategoria,listado1.get(0).getIdCategoria().getCategoria());
        utilidades.fillcomboboxM(CBMarca,listado1.get(0).getIdMarca().getMarca());
    }//GEN-LAST:event_tablaProdMouseClicked

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
        if(validar()==true){
            String Categoria="";
            String Marca="";
            int x=0;
            if(this.rbNuevaCategoria.isSelected()){
                Categoria=this.TBNuevaCategoria.getText();
            }else if(this.rbNuevaCategoria.isSelected()==false){
                Categoria =this.CBCategoria.getSelectedItem().toString();
            }
            if(this.RBNuevaMarca.isSelected()){
                Marca=this.TBNuevaMarca.getText();
            }else if(this.RBNuevaMarca.isSelected()==false){
                Marca=this.CBMarca.getSelectedItem().toString();
            }
            utilidades.UpdateProd(LidProducto,Categoria,Marca,this.TBnombreP.getText(),this.TADescricpionP.getText(),Double.parseDouble(this.TBPrecioP.getText()));
            String []titulos = {"codigo","producto","marca","categoria","descripcion"};
            DefaultTableModel Modelo = new DefaultTableModel(null,titulos);
            utilidades.fillJTable(this.tablaProd,"Producto",titulos);
            this.tablaProd.setDefaultEditor(Object.class,null);
        }else if(validar()==false){
            JOptionPane.showMessageDialog(null, "Algun campo esta vacio","Registro",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.BtnEditar.setEnabled(false);
        this.BTNAgregarP.setEnabled(true);
        clear();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        String []titulos = {"codigo","producto","marca","categoria","descripcion"};
        utilidades.fillJTable(this.tablaProd,"Producto", titulos);
        this.tablaProd.setDefaultEditor(Object.class,null);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing
public void ShowTable(){
 String []titulos = {"codigo","producto","marca","categoria","descripcion"};
            DefaultTableModel Modelo = new DefaultTableModel(null,titulos);
        utilidades.fillJTable(this.tablaProd,"Producto",titulos);
}
public boolean validar(){
    boolean validado=false;
            if((validarcomboboxCateg()==true)&&(validarcomboboxMarca()==true)&&(this.TBnombreP.getText().length()!=0)&&
                    (this.TADescricpionP.getText().length()!=0)&&
                    (this.TBPrecioP.getText().length()!=0)){
                validado=true;
            }
            if((validarcomboboxCateg()==false)||(validarcomboboxMarca()==false)||(this.TBnombreP.getText().length()==0)||
                (this.TADescricpionP.getText().length()==0)||
                (this.TBPrecioP.getText().length()==0)){
            validado=false;
            }
return validado;
}
public boolean validarcomboboxCateg(){
    boolean validar=false;
    if(this.rbNuevaCategoria.isSelected()){
        if(this.rbNuevaCategoria.getText().length()!=0){
            validar=true;
        }
    }
    else if(this.rbNuevaCategoria.isSelected()==false){
        validar=true;
    }
    else {validar=false;}
return validar;}
public boolean validarcomboboxMarca(){
    boolean validar=false;
    if(this.RBNuevaMarca.isSelected()){
        if(this.TBNuevaMarca.getText().length()!=0){
            validar=true;
        }
    }
    else if(this.RBNuevaMarca.isSelected()==false){
        validar=true;
    }
    else {validar=false;}
return validar;
}
public void clear(){
    this.TBNuevaCategoria.setText("");
    this.TBNuevaMarca.setText("");
    this.TBPrecioP.setText("");
    this.TBnombreP.setText("");
    this.TADescricpionP.setText("");
    utilidades.fillcomboboxcatp(this.CBCategoria);
    utilidades.fillcomboboxMarca(this.CBMarca);
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNAgregarP;
    private javax.swing.JButton BtnEditar;
    private javax.swing.JComboBox<String> CBCategoria;
    private javax.swing.JComboBox<String> CBMarca;
    private javax.swing.JRadioButton RBNuevaMarca;
    private javax.swing.JTextArea TADescricpionP;
    private javax.swing.JTextField TBBusqueda;
    private javax.swing.JTextField TBNuevaCategoria;
    private javax.swing.JTextField TBNuevaMarca;
    private javax.swing.JTextField TBPrecioP;
    private javax.swing.JTextField TBnombreP;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbNuevaCategoria;
    private javax.swing.JTable tablaProd;
    // End of variables declaration//GEN-END:variables
}
