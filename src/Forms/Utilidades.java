package Forms;

import Entities.*;
import EntradaXProducto.Productos;
import Model.jtableVentaModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
        List<String> linv;
        if (!busqueda.equals("*")) {
            linv = manager.createQuery("SELECT CONCAT(c.nombre,' ',c.apellido) FROM Cliente c WHERE CONCAT(c.nombre,' ',c.apellido) LIKE '%"+busqueda+"%' AND c.nombre <> '"+GenerarVenta.rbAnonimo.getText()+"'")
                    .getResultList();
        }
        else
        {
            linv = manager.createQuery("SELECT CONCAT(c.nombre,' ',c.apellido) FROM Cliente c WHERE c.nombre <> '"+GenerarVenta.rbAnonimo.getText()+"'")
                    .getResultList();
        }
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
                .setParameter("producto", nombreProducto)
                .getSingleResult();
        return prod;
    }
    
    //Metodo getInventarioByNombre obtenemos un entero que representa la cantidad actual de
    //producto mediante su nombre
    public Double getExistenciaByNombre(String nombreProducto) {
        Producto prod = getProductoByNombre(nombreProducto);
        //List<Inventario> inv =  manager.createNamedQuery("Inventario.findByIdProducto")
        //        .setParameter("idProducto", prod.getIdProducto())
        //        .setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH)
        //        .getResultList();
        List<Inventario> inv = Prueba(prod.getIdProducto());
        Double existencia = 0.0;
        if(prod.getProducto().matches("\\b[\\w\\s]*\\.\\s\\(\\w*\\)"))
        {
           return 100.0;
        }
        else {
            for (Inventario inve : inv) {
                existencia += inve.getExistencia();
            }
        }
            
        return existencia;
    }
    //getPrecioByNombre retorna un Double que representa el precio de venta del producto
    public Double getPrecioByNombre(String nombreProducto) {
        Producto prod = getProductoByNombre(nombreProducto);
        return prod.getPrecio();
    }
    
    //Metodo addToJTableVenta() metodo especifico para llenar la tabla venta (Form GenarVenta)
    public void addToJTableVenta(JTable jtable, String nombreProducto, Double cantidad, Double descuento) {
        Producto prod = getProductoByNombre(nombreProducto);
        //El modelo para la tabla solo para crear el objeto que contega, los datos que se quieren ingresar a la tabla
        jtableVentaModel venta = new jtableVentaModel(prod.getIdProducto(),
                cantidad, prod.getProducto(), prod.getPrecio(), descuento);
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        //Verificamos si el objeto temp(contiene todas las entradas a la tabla) ya posee un producto
        int ya = buscarProductoEnTabla(temp, venta.getNombre());
        
        if (ya != -1) {
            if (temp.get(ya).getCantidad() + venta.getCantidad() <= getExistenciaByNombre(nombreProducto)) {
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
            if (venta.getCantidad() <= getExistenciaByNombre(nombreProducto)) {
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
        mostrarAlerta(null,"La Cantidad que intentó ingresar es mayor al inventario "
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
            Double j = Double.parseDouble(i);
            if (j <= 0) {
                mostrarAlerta(cbx,"La cantidad a vender no puede ser menor a 1",
                        "Cantidad no válida");
                return false;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta(cbx ,"El campo cantidad solo acepta números, intente de nuevo.\n \n"
                    + "Error: " + e.toString(), "Ingrese solo numeros (Cantidad)");
            return false;
        }
        return true;
    }
    
    public void mostrarAlerta(Component parent,String mensaje, String titulo) {
        JOptionPane.showMessageDialog(parent, mensaje, titulo,
                JOptionPane.WARNING_MESSAGE);
    }
    
    public boolean login(String usuario, char[] clave) {
        boolean bool = (boolean) manager.createNamedQuery("Usuario.login")
                .setParameter("usser", usuario)
                .setParameter("pssword", clave)
                .getSingleResult();
        if (bool){
        LogIn.usuario = (Usuario) manager.createNamedQuery("Usuario.findByNUsuario")
                .setParameter("nUsuario", usuario)
                    .getResultList().stream().findFirst().orElse(null);
        }
        return bool;
    }
    
    public void setScreenCentered(JFrame jFrame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation(dim.width / 2 - jFrame.getSize().width / 2,
                dim.height / 2 - jFrame.getSize().height / 2);
        jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/imagenes/palmera.png")));
    }
    public void crearVentaFracc(Cliente cliente, int idEmpleado, boolean ventafracc) {
        List<Cliente> clientes = manager.createNamedQuery("Cliente.findAll")
                    .getResultList();
            //Los "recorremos" todos en busca de concidencias
            Cliente cli = clientes.stream()
                    .filter(client -> cliente.getNombre().equals(client.getNombre())
                            && cliente.getApellido().equals(client.getApellido()))
                    .findAny()
                    .orElse(null);
       
        Venta venta = new Venta();
        
        venta.setIdCliente(cli);
        venta.setIdUsuario(LogIn.usuario);
        venta.setFecha(new Date());
        venta.setNula('0');
        //prueba
        venta.setNumeroserial("n/a");
        
         try {
            manager.getTransaction().begin();
            manager.persist(venta);
            manager.flush();
            crearDetalleVenta(venta, true);
         } catch (NumberFormatException e) {
            manager.getTransaction().rollback();
            mostrarAlerta(null,"Algo salio mal, intente de nuevo /n Error: "+e,
                    "Error:");
        }
    }
        
    public void crearVenta(Cliente cliente, int idEmpleado, Date fechaExpedicion, String Serial) {
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
                mostrarAlerta(null,"Cliente nuevo intente ingresarlo primero.",
                        "Error: la venta no puede ser realizada");
                return;
            }
        }
        else {
            mostrarAlerta(null,"Cliente no existente, intente de nuevo", "Error");
            return;
        }
        
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(fechaExpedicion);
        fecha.add(Calendar.HOUR_OF_DAY, new Date().getHours());
        fecha.add(Calendar.MINUTE, new Date().getMinutes());
        fecha.add(Calendar.SECOND, new Date().getSeconds());
        Venta venta = new Venta();
        
        venta.setIdCliente(cli);
        venta.setIdUsuario(LogIn.usuario);
        venta.setFecha(fecha.getTime()); 
        venta.setNula('0');
        venta.setNumeroserial(Serial);
    
        try {
            manager.getTransaction().begin();
            manager.persist(venta);
            manager.flush();
            crearDetalleVenta(venta, false);
        } catch (NumberFormatException e) {
            manager.getTransaction().rollback();
            mostrarAlerta(null,"Algo salio mal, intente de nuevo /n Error: "+e,
                    "Error:");
        }
    }
    
    public boolean AgregarCliente(Cliente cliente)
    {
        try {
            if (cliente.Validar().equals("OK")) {
                List<Telefono> tels = cliente.getTelefonoList();
                manager.getTransaction().begin(); //Iniciamos la transaccion
                //"Insertamos" los telefonos a la DB, pero antes validandolos
                if(tels != null){
                    for (Telefono tel : tels)
                    {
                        if (tel.Validar())
                        {
                            manager.persist(tel);
                        }
                    }
                    //flush sirve por ejemplo para que vaya a la BD y le busque ID a la entidad que deseamos ingresar
                }
                manager.flush();
                //Busca id para el cliente
                manager.persist(cliente);
                manager.flush();
                //Asignamos los telefonos previamente agregados a el cliente correspondiente y asignamos idcliente
                if (tels != null) {
                    for (Telefono tel : tels)
                    {
                        if (tel.Validar())
                        {
                        tel.setIdCliente(cliente);
                    }
                }
                }
                //Hacemos commit a los cambios realizados
                manager.getTransaction().commit();
                GenerarVenta.imgExito(cliente.Validar());
                return true;
            }
            else
            {
                GenerarVenta.imgError(cliente.Validar());
                return false;
            }
        } catch (Exception e) {
            //Si falla en alguno de los pasos anteriores hacemos rollback
            mostrarAlerta(null,"Algo salio mal al ingresar nuevo usuario, porfavor "
                    + "intente de nuevo /n Error: "+e, "Error");
            manager.getTransaction().rollback();
            return false;
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
    
    private void crearDetalleVenta(Venta venta, boolean ventafracc) {
        try {
            for (jtableVentaModel j : temp) {
                //List<Inventario> listado = manager.createNativeQuery("SELECT * FROM inventario i where i.idproducto = ? ORDER BY i.fechavencimiento ASC",Inventario.class)
                //        .setParameter(1, j.getIdProducto())
                //       .getResultList();
                List<Inventario> listado = Prueba(j.getIdProducto());
                cambioLote(listado, j, venta, ventafracc);
            }
            manager.getTransaction().commit();
            GenerarVenta.cliente = null;
            clearJTable(GenerarVenta.dgvPedidos);
            transacionExitosa = true;
            //mostrarAlerta("Venta satisfactoria", "Exito");
        } catch (Exception e) {
            manager.getTransaction().rollback();
            mostrarAlerta(null,"Error: " +e, "Error");
        }
    }
    public void cambioLote(List<Inventario> idLotes, jtableVentaModel j, Venta venta, boolean ventafracc){
        int i=0;
        Historialprecioventa hpv = buscarHistorialPrecioVenta(j.getIdProducto(),j.getPreciounitario());
        while (j.getCantidad()>=1){
            Integer idFechaV = idLotes.get(i).getIdFechavencimiento();
            Detalleventa det = new Detalleventa();
            Producto prod = (Producto) manager.createNamedQuery("Producto.findByIdProducto")
                    .setParameter("idProducto", j.getIdProducto())
                    .getSingleResult();
            //Producto prod = new Producto(j.getIdProducto());
            
            det.setIdProducto(prod);
            det.setIdVenta(venta);
            det.setDescuento(j.getDescuento());
            det.setIdFechaVencimiento((Fechavencimiento)manager.createNamedQuery("Fechavencimiento.findByIdFechavencimiento").setParameter("idFechavencimiento",idFechaV).getSingleResult());
            det.setIdHistorialPrecioVenta(hpv);

            if(prod.getProducto().matches("\\b[\\w\\s]*\\.\\s\\(\\w*\\)"))
            {
                det.setVentaproductofracc(2);
            }
            else if (ventafracc)
            {
                det.setVentaproductofracc(1);
            }
            else 
            {
                det.setVentaproductofracc(0);
            }
            
            Double a = idLotes.get(i).getExistencia();
            Double b = j.getCantidad();
            if ((b-a)>=0) {
                det.setCantidad(a);
            }
            else
            {
                det.setCantidad(b);
            }
            j.setCantidad(b-a);
            if (det.getCantidad()!=0)
            {
                manager.persist(det);
            }
            i++;
        }
    }
        
    private Historialprecioventa buscarHistorialPrecioVenta(Integer idProd, Double precio)
    {
        List<Historialprecioventa> hvpl;
        Producto prod = manager.createNamedQuery("Producto.findByIdProducto",Producto.class)
                .setParameter("idProducto", idProd)
                .setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH)
                .getSingleResult();
        Historialprecioventa hvp;
        try {
            hvpl = prod.getHistorialprecioventaList();
            for (Historialprecioventa historial : hvpl) {
                if(Objects.equals(historial.getPrecio(), precio)) return historial;
            }
        } catch (Exception e) {
        }
        hvp = new Historialprecioventa(prod);
        hvp.setPrecio(precio);
        manager.persist(hvp);
        manager.flush();
        return hvp;
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
        List<Producto> listado = manager.createQuery("SELECT p FROM "+tabla+" p where p."+filtro+" like \"%"+busqueda+"%\"").getResultList();
        DefaultTableModel Modelo = (DefaultTableModel) jtable.getModel();
        Modelo.setRowCount(0);
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
        } catch (NumberFormatException e) {
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
        } catch (NumberFormatException e) {
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
        } catch (NumberFormatException e) {
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
        } catch (NumberFormatException e) {
        }
        return codigo;
    }
    public int findProvbyname(String prov){
        int codigo;
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
        } catch (NumberFormatException e) {
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
        } catch (NumberFormatException e) {
        }
        return insertp;
    }
    public List<Proveedor> fillcomboboxp(){
        List<Proveedor> listado = manager.createNamedQuery("Proveedor.findAll").getResultList();
        return listado;
    }
    
    public int getidcategoriabyn(String cat){
        int inte;
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
    public void setCantidadJtable(JTable jtable,int index, Double cantidad)
    {
        temp.get(index).setCantidad(cantidad);
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0);
        temp.forEach((jtableVentaModel j) -> { //no se como pero java sabe que hacer ¯\_(ツ)_/¯
            model.addRow(j.toArray());
        });
    }
    public void setDescuentoJtable(JTable jtable,int index, double descuento)
    {
        temp.get(index).setDescuento(descuento);
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
            if(M.getMarca() == null ? Marca == null : M.getMarca().equals(Marca)){
                
            }
            else if(M.getMarca() == null ? Marca != null : !M.getMarca().equals(Marca)){
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
            if(c.getCategoria() == null ? catp == null : c.getCategoria().equals(catp)){
            }
            else if(c.getCategoria() == null ? catp != null : !c.getCategoria().equals(catp)){
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
        DateFormat formatoFecha= new SimpleDateFormat("yyyy-MM-dd");
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
        }catch(NumberFormatException e){
            
        }
        return codigo;
    }
    public int crearCompra(int idprov,Date fecha,String representante,String dui,String Serial){
        int insertCompra =0;
        Calendar fechan = Calendar.getInstance();
        fechan.setTime(fecha);
        fechan.add(Calendar.HOUR_OF_DAY, new Date().getHours());
        fechan.add(Calendar.MINUTE, new Date().getMinutes());
        fechan.add(Calendar.SECOND, new Date().getSeconds());
        try{
            StoredProcedureQuery np = manager.createNamedStoredProcedureQuery("Compra.comprar")
                    .setParameter("pidprov",idprov)
                    .setParameter("pfecha",fechan.getTime())
                    .setParameter("prepresentante",representante)
                    .setParameter("pdui",dui)
                    .setParameter("pSerial", Serial);
            np.execute();
            insertCompra=Integer.valueOf(np.getOutputParameterValue("midcompra").toString());
        }catch(NumberFormatException e){
            
        }
        return insertCompra;
    }
    public int crearDetCompra(ArrayList<Productos>lpn,int idprov,Date fecha,String representante,String dui,String Serial){
        int x=-2;
        DateFormat f=new SimpleDateFormat("yyyy-MM-dd");
        
        int codigoCompra=crearCompra(idprov,fecha,representante,dui,Serial);
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
        }catch(NumberFormatException e){
            
        }finally{
            
        }
        return x;
    }
    public Cliente buscarCliente(String aBuscar)
    {
        Cliente Cli = (Cliente) manager.createQuery("SELECT c FROM Cliente c WHERE CONCAT(c.nombre,' ',c.apellido) LIKE '%"+aBuscar+"%'")
                .getSingleResult();
        return Cli;
    }
    public boolean buscarCliente(Cliente cli)
    {
        List<Cliente> clientes = manager.createNamedQuery("Cliente.findAll")
                .getResultList();
        for (Cliente cliente : clientes)
        {
            boolean equals = true;
            if (!cli.getNombre().equals(cliente.getNombre())) equals = false;
            if (!cli.getApellido().equals(cliente.getApellido())) equals = false;
            if (!cli.getDui().trim().isEmpty()) 
            {
                if (!cli.getDui().equals(cliente.getDui())) equals = false;
            }
            if (equals) return true;
        }
        return false;
    }
    
    public List<Inventario> Prueba(int idProducto)
    {
        List<Compraseparada> csgo = manager.createNamedQuery("Compraseparada.findAll")
                .setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH)
                .getResultList();
        List<Compraseparada> valorant = new ArrayList<>();
        List<Ventaseparada> vs =  manager.createNamedQuery("Ventaseparada.findAll")
                .setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH)
                .getResultList();
        List<Ventaseparada> vs2 = new ArrayList<>();
        
        List<Inventario> inv = new ArrayList<>();
        
        vs.stream().filter((v) -> (v.getIdProducto().getIdProducto() == idProducto)).forEach((v) -> {
            vs2.add(v);
        });   
        csgo.stream().filter((csgo1) -> (csgo1.getIdProducto().getIdProducto() == idProducto)).forEach((csgo1) -> {
            valorant.add(csgo1);
        });
        for (Compraseparada valorant1 : valorant) {
            
            Inventario tempo = new Inventario();
            tempo.setCompra(valorant1.getCantidad());
            tempo.setIdProducto(idProducto);
            tempo.setIdFechavencimiento(valorant1.getIdFechavencimiento());
            tempo.setExistencia(0.0);
            
            if (vs2.isEmpty()) {
                tempo.setVenta(0.0);
                tempo.setExistencia(tempo.getExistencia() + valorant1.getCantidad());
            }
            for (Ventaseparada vs21 : vs2) {    
                tempo.setVenta(vs21.getCantidad());              
                if (Objects.equals(valorant1.getIdFechavencimiento(), vs21.getIdfechavencimiento())) {    
                    tempo.setExistencia( valorant1.getCantidad() - vs21.getCantidad());
                    break;
                } else {                  
                    tempo.setExistencia(valorant1.getCantidad());
                }
            }
            inv.add(tempo);
        }
        return inv;
    }
}
