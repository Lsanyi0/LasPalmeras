package Forms;

import Entities.Categoria;
import Entities.Cliente;
import Entities.Detalleventa;
import Entities.Fechavencimiento;
import Entities.Inventario;
import Entities.Marca;
import Entities.Producto;
import Entities.Proveedor;
import Entities.Telefono;
import Entities.Usuario;
import Entities.Venta;
import EntradaXProducto.Productos;
import Model.jtableVentaModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Utilidades {
    
    private static EntityManager manager;
    
    private static EntityManagerFactory emf;
    
    private static ArrayList<jtableVentaModel> temp;
    
    private final ReportesEimpresion reportes;
    
    public static boolean transacionExitosa = false;
    
    public Utilidades() {
        emf = Persistence.createEntityManagerFactory("AgroServPU");
        manager = emf.createEntityManager();
        temp = new ArrayList<>();
        reportes = new ReportesEimpresion();
    }
    
    //getDate devuelve un String que representa la fecha con formato dia,mes,año
    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dtf.format(LocalDateTime.now());
    }
    
    public void fillJList(JList lista, String tabla) {
        List<String> linv = manager.createQuery("SELECT p.producto FROM " + tabla + " p")
                .getResultList();
        setJListModel(linv, lista);
    }
    public void fillJListC(JList lista, String busqueda) {
        List<String> linv = manager.createQuery("SELECT c FROM Cliente WHERE c.Nombre + ' ' c.Apellido LIKE :nombre")
                .setParameter("nombre", busqueda)
                .getResultList();
        setJListModel(linv, lista);
    }
    public void fillJList(JList lista, String filtro, String busqueda, String tabla) {
        List<String> linv = manager.createQuery("SELECT p.producto FROM " + tabla
                + " p WHERE p." + filtro + " LIKE '%" + busqueda + "%'")
                .getResultList();
        setJListModel(linv, lista);
    }
    
    public void setJListModel(List linv, JList lista) {
        JList listaDeshechable = new JList(linv.toArray());
        lista.setModel(listaDeshechable.getModel());
        if (linv.size() > 0) {
            lista.setSelectedIndex(0);
        }
    }
    
    public Producto getProductoByNombre(String nombreProducto) {
        Producto prod = (Producto) manager.createNamedQuery("Producto.findByProducto")
                .setParameter("producto", "%" + nombreProducto + "%")
                .getSingleResult();
        return prod;
    }
    
    //Metodo getInventarioByNombre obtenemos un entero que representa la cantidad actual de
    //producto mediante su nombre
    public int getExistenciaByNombre(String nombreProducto) {
        Producto prod = getProductoByNombre(nombreProducto);
        List<Inventario> inv =  manager.createNamedQuery("Inventario.findByIdProducto")
                .setParameter("idProducto", prod.getIdProducto())
                .setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH)
                .getResultList();
        Integer existencia = 0;
        for (Inventario inve : inv) {
            existencia += inve.getExistencia();
        }
        return existencia;
    }
    //getPrecioByNombre retorna un Double que representa el precio de venta del producto
    public Double getPrecioByNombre(String nombreProducto) {
        Producto prod = getProductoByNombre(nombreProducto);
        return prod.getPrecio();
    }
    
    //Metodo addToJTableVenta() metodo especifico para llenar la tabla venta (Form GenarVenta)
    public void addToJTableVenta(JTable jtable, String nombreProducto, int cantidad, Double descuento) {
        Producto prod = getProductoByNombre(nombreProducto);
        //El modelo para la tabla solo para crear el objeto que contega, los datos que se quieren ingresar a la tabla
        jtableVentaModel venta = new jtableVentaModel(prod.getIdProducto(),
                cantidad, prod.getProducto(), prod.getPrecio(), descuento);
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        //Verificamos si el objeto temp(contiene todas las entradas a la tabla) ya posee un producto
        int ya = buscarProductoEnTabla(temp, venta.getNombre());
        
        if (ya != -1) {
            if (temp.get(ya).getCantidad() + venta.getCantidad() < getExistenciaByNombre(nombreProducto)) {
                temp.get(ya).setCantidad(cantidad + temp.get(ya).getCantidad());
            } else {
                temp.get(ya).setCantidad(getExistenciaByNombre(nombreProducto));
                cantidadMayorALaDisponible();
            }
            model.setRowCount(0);
            temp.forEach((jtableVentaModel j) -> { //no se como pero java sabe que hacer ¯\_(ツ)_/¯
                model.addRow(j.toArray());
            });
        } else {
            if (venta.getCantidad() < getExistenciaByNombre(nombreProducto)) {
                temp.add(venta);
            }
            else
            {
                venta.setCantidad(getExistenciaByNombre(nombreProducto));
                temp.add(venta);
                cantidadMayorALaDisponible();
            }
            model.addRow(venta.toArray());
        }
    }
    private void cantidadMayorALaDisponible()
    {
        mostrarAlerta("La Cantidad que intentó ingresar es mayor al inventario "
                + "disponible, se colocará la cantidad máxima disponible "
                + "como valor a vender.",
                "Cantidad seleccionada mayor a la disponible");
    }
    //Obtiene el total de la venta, sumando los subtotales de los productos que
    //se encuentran en la tabla
    public Double getTotal() {
        Double total = 0.0;
        for (jtableVentaModel j : temp) {
            total += j.getSubtotal();
        }
        return total;
    }
    
    //Busca un nombre de producto dentro de una tabla y si lo encuentra devuelve
    //la posision en que se encuentra, sino lo encuentra devuelve -1
    public int buscarProductoEnTabla(ArrayList<jtableVentaModel> obj, String prod) {
        for (int i = 0; i < obj.size(); i++) {
            if (obj.get(i).getNombre().equals(prod)) {
                return i;
            }
        }
        return -1;
    }
    public boolean validarComboBox(JComboBox cbx) {
        try {
            String i = cbx.getSelectedItem().toString();
            Integer j = Integer.parseInt(i);
            if (j <= 0) {
                mostrarAlerta("La cantidad a vender no puede ser menor a 1",
                        "Cantidad no válida");
                return false;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("El campo cantidad solo acepta números, intente de nuevo.\n \n"
                    + "Error: " + e.toString(), "Ingrese solo numeros (Cantidad)");
            return false;
        }
        return true;
    }
    
    public void mostrarAlerta(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo,
                JOptionPane.WARNING_MESSAGE);
    }
    
    public boolean login(String usuario, char[] clave) {
        boolean bool = (boolean) manager.createNamedQuery("Usuario.login")
                .setParameter("usser", usuario)
                .setParameter("pssword", clave)
                .getSingleResult();
        LogIn.usuario = (Usuario) manager.createNamedQuery("Usuario.findByNUsuario")
                .setParameter("nUsuario", usuario)
                .getSingleResult();
        return bool;
    }
    
    public void setScreenCentered(JFrame jFrame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation(dim.width / 2 - jFrame.getSize().width / 2,
                dim.height / 2 - jFrame.getSize().height / 2);
        jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/palmera.png")));
    }
    
    public void crearVenta(Cliente cliente, int idEmpleado) {
        //Extraemos todos los clientes en la DB
        List<Cliente> clientes = manager.createNamedQuery("Cliente.findAll")
                .getResultList();
        //Los "recorremos" todos en busca de concidencias
        Cliente cli = clientes.stream()
                .filter(client -> cliente.getNombre().equals(client.getNombre())
                        && cliente.getApellido().equals(client.getApellido()))
                .findAny()
                .orElse(null);
        
        if (cli != null) {
            if (cli.getIdCliente() == null) {
                mostrarAlerta("Cliente nuevo intente ingresarlo primero.",
                        "Error: la venta no puede ser realizada");
                return;
            }
        }
        else {
            mostrarAlerta("Cliente no existente, intente de nuevo", "Error");
            return;
        }
        Venta venta = new Venta();
        
        venta.setIdCliente(cli);
        venta.setIdUsuario(LogIn.usuario);
        venta.setFecha(new Date());
        venta.setNula('0');
        
        try {
            manager.getTransaction().begin();
            manager.persist(venta);
            manager.flush();
            crearDetalleVenta(venta);
        } catch (NumberFormatException e) {
            manager.getTransaction().rollback();
            mostrarAlerta("Algo salio mal, intente de nuevo /n Error: "+e,
                    "Error:");
        }
    }
    
    public void AgregarCliente(Cliente cliente)
    {
        try {
            if (cliente.Validar()) {
                List<Telefono> tels = cliente.getTelefonoList();
                manager.getTransaction().begin(); //Iniciamos la transaccion
                //"Insertamos" los telefonos a la DB, pero antes validandolos
                for (Telefono tel : tels) if (tel.Validar()) manager.persist(tel);
                //flush sirve por ejemplo para que vaya a la BD y le busque ID a la entidad que deseamos ingresar
                manager.flush();
                //Busca id para el cliente
                manager.persist(cliente);
                manager.flush();
                //Asignamos los telefonos previamente agregados a el cliente correspondiente
                for (Telefono tel : tels) tel.setIdCliente(cliente);
                //Hacemos commit a los cambios realizados
                manager.getTransaction().commit();
            }
            else mostrarAlerta("Porfavor ingrese nombre, y apellido validos", "Error");
        } catch (Exception e) {
            //Si falla en alguno de los pasos anteriores hacemos rollback
            mostrarAlerta("Algo salio mal al ingresar nuevo usuario, porfavor "
                    + "intente de nuevo /n Error: "+e, "Error");
            manager.getTransaction().rollback();
        }
    }
    
    private Integer getIdFechaVencimiento(Integer idProducto) {
        List<Integer> fVencimiento = (List<Integer>) manager.createNamedQuery("Inventario.findIdFechaVencimiento")
                .setParameter("idProd", idProducto)
                .getResultList();
        return fVencimiento.get(0);
    }
    
    private Integer getCantidadPorFechaVencimientoById(Integer idProducto) {
        List<Integer> fVencimiento = (List<Integer>) manager.createNamedQuery("Inventario.findExistenciaPorFechaVencimientoById")
                .setParameter("idProd", idProducto)
                .getResultList();
        return fVencimiento.get(0);
    }
    private Integer findIdProductoByNombre(String nombre)
    {
        int id = (int) manager.createNamedQuery("Producto.findByNombreProducto")
                .setParameter("producto",nombre)
                .getSingleResult();
        return id;
    }
    private void saltarLote(jtableVentaModel j,Integer CantidadMaximaLote, Venta venta)
    {
        Detalleventa newLote = new Detalleventa();
        try {
            newLote.setIdProducto(new Producto(j.getIdProducto()));
            newLote.setIdVenta(venta);
            newLote.setIdFechaVencimiento(new Fechavencimiento(getIdFechaVencimiento(j.getIdProducto())));
            newLote.setCantidad(CantidadMaximaLote);
            newLote.setDescuento(j.getDescuento());
            manager.persist(newLote);
            
            manager.flush();
            
            int cantidad = getCantidadPorFechaVencimientoById(findIdProductoByNombre(j.getNombre()));
            j.setCantidad(j.getCantidad()-CantidadMaximaLote);
            saltarLote(j, cantidad, venta, 0.00);
            
        } catch (Exception e) {
            System.out.println("1"+e);
        }
    }
    private void saltarLote(jtableVentaModel j,Integer CantidadMaximaLote, Venta venta,Double descuento)
    {
        Detalleventa newLote = new Detalleventa();
        try {
            newLote.setIdProducto(new Producto(j.getIdProducto()));
            newLote.setIdVenta(venta);
            newLote.setIdFechaVencimiento(new Fechavencimiento(getIdFechaVencimiento(j.getIdProducto())));
            newLote.setCantidad(CantidadMaximaLote);
            newLote.setDescuento(descuento);
            manager.persist(newLote);
            
            manager.flush();
            
            int cantidad = getCantidadPorFechaVencimientoById(findIdProductoByNombre(j.getNombre()));
            j.setCantidad(j.getCantidad()-CantidadMaximaLote);
            if (loteSeAcaba(j, cantidad)){
                saltarLote(j, cantidad, venta, 0.00);
            }
        } catch (Exception e) {
        }
    }
    private void crearDetalleVenta(Venta venta) {
        try {
            for (jtableVentaModel j : temp) {
                Detalleventa det = new Detalleventa();
                det.setIdProducto(new Producto(j.getIdProducto()));
                det.setIdVenta(venta);
                det.setIdFechaVencimiento(null);
                det.setCantidad(j.getCantidad());
                det.setDescuento(j.getDescuento());
                manager.persist(det);
            }
            manager.getTransaction().commit();
            GenerarVenta.cliente = null;
            clearJTable(GenerarVenta.dgvPedidos);
            transacionExitosa = true;
            //mostrarAlerta("Venta satisfactoria", "Exito");
        } catch (Exception e) {
            manager.getTransaction().rollback();
            mostrarAlerta("Error: " +e, "Error");
        }
    }
    private boolean loteSeAcaba(jtableVentaModel j,int cantidadDisponible)
    {
        return cantidadDisponible < j.getCantidad();
    }
    public void clearJTable(JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        jTable.setModel(model);
        temp.clear();
    }
    
    public void persist(Object object) {
        manager.getTransaction().begin();
        try {
            manager.persist(object);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }
    public void fillcombobox(JComboBox CBcat){
        List<Categoria> listado = manager.createNamedQuery("Categoria.findAll").getResultList();
        for(Categoria c : listado){
            CBcat.addItem(c.getCategoria());
        }
    }
    public void fillJTable(JTable jtable, String tabla,String []titulos){
        List<Producto> listado = manager.createQuery("SELECT p FROM "+tabla+" p")
                .setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH)
                .getResultList();
        DefaultTableModel Modelo = new DefaultTableModel(null,titulos);
        for (Producto p : listado) {
            Modelo.addRow(new Object[]{
                Integer.toString(p.getIdProducto()),p.getProducto(),p.getIdMarca().getMarca(),
                p.getIdCategoria().getCategoria(),p.getDescripcion()});
        }
        jtable.setModel(Modelo);
//        jtable.setDefaultEditor(Object.class, null);
    }
    public void fillJTable(JTable jtable,String tabla,String filtro,String busqueda,String []titulos){
//                                                SELECT p FROM Producto p where p.producto like "%a%"
List<Producto> listado = manager.createQuery("SELECT p FROM "+tabla+" p where p."+filtro+" like \"%"+busqueda+"%\"").getResultList();
DefaultTableModel Modelo = new DefaultTableModel(null,titulos);
for (Producto p : listado) {
    Modelo.addRow(new Object[]{Integer.toString(p.getIdProducto()),p.getProducto(),p.getIdMarca().getMarca(),
        p.getIdCategoria().getCategoria(),p.getDescripcion()});
}
jtable.setModel(Modelo);
jtable.setDefaultEditor(Object.class, null);
    }
    public List<Producto> obtenerproducto(String tabla,int id,String filtro){
        List<Producto> listado2 = manager.createQuery("SELECT p FROM "+tabla+" p where p."+filtro+"="+id).getResultList();
        return listado2;
    }
    public int UpdateProd(int idproducto,String categoria,String marca,String producto,String descripcion,Double precio){
        int insert=0;
        try {
            StoredProcedureQuery np=manager.createNamedStoredProcedureQuery("Producto.UpdateProd")
                    .setParameter("pidProducto",idproducto)
                    .setParameter("pidCategoria",insertarcategoria(categoria))
                    .setParameter("pidMarca",insertmarca(marca))
                    .setParameter("pproducto",producto)
                    .setParameter("pdescripcion",descripcion)
                    .setParameter("pprecio",precio);
            np.execute();
            insert = Integer.valueOf(np.getOutputParameterValue("x").toString());
        } catch (Exception e) {
        }
        return insert;
    }
    public int insertmarca(String marca){
        int insert=0;
        int insert2=0;
        try {
            StoredProcedureQuery np=manager.createNamedStoredProcedureQuery("Marca.insertarmarca")
                    .setParameter("pmarca",marca);
            np.execute();
            insert2 = Integer.valueOf(np.getOutputParameterValue("bandera").toString());
            insert = Integer.valueOf(np.getOutputParameterValue("codigo").toString());
        } catch (Exception e) {
        }
        return insert;
    }
    public int insertProveedor(String prov,String dir,String telefono){
        int codigo=0;
        int bandera=-1;
        try {
            StoredProcedureQuery np=manager.createNamedStoredProcedureQuery("Proveedor.insertarproveedor")
                    .setParameter("pproveedor",prov)
                    .setParameter("pdireccion",dir);
            np.execute();
            bandera = Integer.valueOf(np.getOutputParameterValue("bandera").toString());
            codigo = Integer.valueOf(np.getOutputParameterValue("codigo").toString());
        } catch (Exception e) {
        }
        inserttelefono(0,0,codigo,telefono);
        return codigo;
    }
    public int inserttelefono(int usuario,int cliente,int proveedor,String telefono){
        int codigo=-1;
        try {
            StoredProcedureQuery np=manager.createNamedStoredProcedureQuery("Telefono.insertartelefono")
                    .setParameter("pidU",usuario)
                    .setParameter("pidcli",cliente)
                    .setParameter("idprov",proveedor)
                    .setParameter("ptel",telefono);
            np.execute();
            codigo = Integer.valueOf(np.getOutputParameterValue("bandera").toString());
        } catch (Exception e) {
        }
        return codigo;
    }
    public int findProvbyname(String prov){
        int codigo=-1;
        Proveedor p = (Proveedor) manager.createNamedQuery("Proveedor.findByProveedor")
                .setParameter("proveedor",prov)
                .getSingleResult();
        codigo=p.getIdProveedor();
        return codigo;
    }
    public int insertarcategoria(String categ){
        int codigo=0;
        int b=-1;
        try {
            StoredProcedureQuery np=manager.createNamedStoredProcedureQuery("Categoria.insertarcategoria")
                    .setParameter("pcat",categ);
            np.execute();
            b = Integer.valueOf(np.getOutputParameterValue("bandera").toString());
            codigo = Integer.valueOf(np.getOutputParameterValue("codigo").toString());
        } catch (Exception e) {
        }
        return codigo;}
    
    public int crearProducto(String cat,String marc,String prod,String desc,double precio){
        int insertp=-1;
        try {
            StoredProcedureQuery np = manager.createNamedStoredProcedureQuery("Producto.insertprod")
                    .setParameter("pidcat",insertarcategoria(cat))
                    .setParameter("pidmarca",insertmarca(marc))
                    .setParameter("pproducto",prod)
                    .setParameter("pdescripcion",desc)
                    .setParameter("pprecio",precio);
            np.execute();
            insertp = Integer.valueOf(np.getOutputParameterValue("minsert").toString());
        } catch (Exception e) {
        }
        return insertp;
    }
    public List<Proveedor> fillcomboboxp(){
        List<Proveedor> listado = manager.createNamedQuery("Proveedor.findAll").getResultList();
        return listado;
    }
    
    public int getidcategoriabyn(String cat){
        int inte=0;
        Categoria c = (Categoria) manager.createNamedQuery("Categoria.findByCategoria")
                .setParameter("categoria",cat)
                .getSingleResult();
        inte=c.getIdCategoria();
        return inte;
    }
    public String getProductoEnLista(int index)
    {
        return temp.get(index).getNombre();
    }
    public void removeFromJTable(JTable jtable,int index)
    {
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        temp.remove(index);
        model.setRowCount(0);
        temp.forEach((jtableVentaModel j) -> { //no se como pero java sabe que hacer ¯\_(ツ)_/¯
            model.addRow(j.toArray());
        });
    }
    public void setCantidadJtable(JTable jtable,int index, int cantidad)
    {
        temp.get(index).setCantidad(cantidad);
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0);
        temp.forEach((jtableVentaModel j) -> { //no se como pero java sabe que hacer ¯\_(ツ)_/¯
            model.addRow(j.toArray());
        });
    }
    public Usuario getUsuarioByIdUsuario(int idUsuario)
    {
        Usuario usuario = (Usuario) manager.createNamedQuery("Usuario.findByIdUsuario")
                .setParameter("idUsuario", idUsuario)
                .getSingleResult();
        return usuario;
    }
    public void fillcomboboxMarca(JComboBox cbMarca){
        List<Marca> listado = manager.createNamedQuery("Marca.findAll").getResultList();
        cbMarca.removeAllItems();
        for(Marca m : listado){
            cbMarca.addItem(m.getMarca());
        }
    }
    public void fillcomboboxM(JComboBox CBMarca,String Marca){
        List<Marca> listado = manager.createNamedQuery("Marca.findAll").getResultList();
        CBMarca.removeAllItems();
        CBMarca.addItem(Marca);
        for(Marca M : listado){
            if(M.getMarca()==Marca){
                
            }
            else if(M.getMarca()!=Marca){
                CBMarca.addItem(M.getMarca());
            }
        }
    }
    //llena el com    bobox cuando un producto tiene una categoria por si el usuario no desea modificar esa parte, el usuario no culpara al
    //sistema(o al desarrollador) que el le lleno el combobox de manera aleatoria sin poner el que tiene el producto de primero en el combobox
    public void fillcomboboxc(JComboBox CBcat,String catp){
        List<Categoria> listado = manager.createNamedQuery("Categoria.findAll").getResultList();
        CBcat.removeAllItems();
        CBcat.addItem(catp);
        for(Categoria c : listado){
            if(c.getCategoria()==catp){
            }
            else if(c.getCategoria()!=catp){
                CBcat.addItem(c.getCategoria());
            }
        }
    }
    
    public void fillcomboboxcatp(JComboBox CBcat){
        List<Categoria> listado = manager.createNamedQuery("Categoria.findAll").getResultList();
        CBcat.removeAllItems();
        for(Categoria c : listado){
            CBcat.addItem(c.getCategoria());
        }
    }
    //busca si el codigo del producto ya esta en la el arraylist si no lo encuentra devuelve -1
    //si lo encuentra devuelve el codigo del producto   //formulario EntradaxProducto
    public int buscarProdEnArrayEP(ArrayList<Productos> lpn,int idprod){
        int codigo=-1;
        for (int i = 0; i < lpn.size(); i++) {
            if (lpn.get(i).getCodigo()==idprod) {
                codigo=i;
            }
            else if(lpn.get(i).getCodigo()!=idprod){
                codigo =-1;
            }
        }
        return codigo;}
    //llena el grid view con el arraylist de productos //formulario EntradaxProducto
    public void llenarJtablePE(ArrayList<Productos> lpn,JTable jtable,String []titulos){
        DateFormat formatoFecha = null;
        formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        DefaultTableModel Modelo = new DefaultTableModel(null,titulos);
        for (Productos pn : lpn){
            
            String[] registrop =
            {Integer.toString(pn.getCodigo()),pn.getProducto(),pn.getMarca(),pn.getCategoria(),
                pn.getDescripcion(),Double.toString(pn.getPrecio()),Integer.toString(pn.getCantidad()),
                formatoFecha.format(pn.getFechavencimiento())};
            
            Modelo.addRow(registrop);
        }
        jtable.setModel(Modelo);
        jtable.setDefaultEditor(Object.class, null);
    }
    public void eliminarProdPE(ArrayList<Productos> lpn ,int idprod){
        for (int i = 0; i < lpn.size(); i++) {
            if (lpn.get(i).getCodigo()==idprod) {
                lpn.remove(i);
            }
            else if(lpn.get(i).getCodigo()!=idprod){
                
            }
        }
    }
    public int insertFechaVencimiento(String fecha){
        int codigo=-1;
        int b=-1;
        try{
            StoredProcedureQuery np = manager.createNamedStoredProcedureQuery("Fechavencimiento.insertarfechav")
                    .setParameter("pfechavenc",fecha);
            np.execute();
            b=Integer.valueOf(np.getOutputParameterValue("bandera").toString());
            codigo=Integer.valueOf(np.getOutputParameterValue("mfechavenc").toString());
        }catch(Exception e){
            
        }
        return codigo;
    }
    public int crearCompra(int idprov,Date fecha,String representante,String dui){
        int insertCompra =0;
        try{
            StoredProcedureQuery np = manager.createNamedStoredProcedureQuery("Compra.comprar")
                    .setParameter("pidprov",idprov)
                    .setParameter("pfecha",fecha)
                    .setParameter("prepresentante",representante)
                    .setParameter("pdui",dui);
            np.execute();
            insertCompra=Integer.valueOf(np.getOutputParameterValue("midcompra").toString());
        }catch(Exception e){
            
        }
        return insertCompra;
    }
    public int crearDetCompra(ArrayList<Productos>lpn,int idprov,Date fecha,String representante,String dui){
        int x=-2;
        DateFormat f=null;
        f =new SimpleDateFormat("yyyy-MM-dd");
        
        int codigoCompra=crearCompra(idprov,fecha,representante,dui);
        try{
            for (Productos pn : lpn){
                StoredProcedureQuery np = manager.createNamedStoredProcedureQuery("DetalleCompra.InsertDCompra")
                        .setParameter("pidcompra",codigoCompra)
                        .setParameter("pidproducto",pn.getCodigo())
                        .setParameter("pcantidad",pn.getCantidad())
                        .setParameter("ppreciou",pn.getPrecio())
                        .setParameter("pidfechaVencimiento",insertFechaVencimiento(f.format(pn.getFechavencimiento())));
                np.execute();
                x=Integer.valueOf(np.getOutputParameterValue("x").toString());
            }
        }catch(Exception e){
            
        }finally{
            
        }
        
        return x;
    }
}
