package Forms;

import Entities.Categoria;
import Entities.Cliente;
import Entities.Inventario;
import Entities.Marca;
import Entities.Producto;
import Entities.Proveedor;
import Model.jtableVentaModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
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
    
    private static ArrayList<jtableVentaModel> temp ;
     
    public Utilidades()
    {
       emf = Persistence.createEntityManagerFactory("AgroServPU");
       manager = emf.createEntityManager();
       temp = new ArrayList<>();      
    }
    
    public String getDate()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    
    public void fillJList(JList lista,String tabla)
    {   
       List<String> linv = manager.createQuery("SELECT p.producto FROM "+tabla+" p").getResultList();
       setJListModel(linv,lista);
    }
    
    public void fillJList(JList lista,String filtro, String busqueda, String tabla)
    {
     List<String> linv = manager.createQuery("SELECT p.producto FROM "+tabla+" p WHERE p."+filtro+" LIKE '%"+busqueda+"%'").getResultList();
     setJListModel(linv,lista);
    }
    
    private void setJListModel(List linv,JList lista)
    {
     JList listaDeshechable = new JList(linv.toArray());
     lista.setModel(listaDeshechable.getModel());
    }
    public Producto getProductoByNombre(String nombreProducto)
    {
        Producto prod = (Producto) manager.createNamedQuery("Producto.findByProducto")
                        .setParameter("producto","%"+nombreProducto+"%")
                        .getSingleResult();   
        return prod;
    }
    
    public int getInventarioByNombre(String nombreProducto)
    {
        Producto prod = getProductoByNombre(nombreProducto);
        Inventario inv = (Inventario)  manager.createNamedQuery("Inventario.findByIdProducto")
                        .setParameter("idProducto", prod.getIdProducto())
                        .getSingleResult();      
        return inv.getExistencia();
    }
    
    public Double getPrecioByNombre(String nombreProducto)
    {
        Producto prod = getProductoByNombre(nombreProducto);
        return prod.getPrecio();
    }
    
    public void addToJTableVenta(JTable jtable,String nombreProducto,int cantidad)
    {
        Producto prod = getProductoByNombre(nombreProducto);
        jtableVentaModel venta = new jtableVentaModel(prod.getIdProducto(),cantidad, prod.getProducto() //El modelo para la tabla solo para crear el objeto que contega 
                                    , prod.getPrecio());                           //los datos que se quieren ingresar a la tabla
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        
        int ya = buscarProductoEnTabla(temp, venta.getNombre());//Verificamos si el objeto temp(contiene todas las entradas a la tabla) ya posee un producto
        
        if (ya != -1) {            
            if (temp.get(ya).getCantidad() + venta.getCantidad() < getInventarioByNombre(nombreProducto)) {
                temp.get(ya).setCantidad(cantidad+temp.get(ya).getCantidad());               
            }
            else
            {
                temp.get(ya).setCantidad(getInventarioByNombre(nombreProducto));                
                mostrarAlerta("La Cantidad que intento ingresar es mayor al inventario "
                                    + "disponible, se colocara el total de inventario "
                                    + "como valor a vender.", 
                                "Cantidad seleccionada mayor a la disponible");
            }
            model.setRowCount(0);
            temp.forEach((jtableVentaModel j) -> { //no se como pero java sabe que hacer ¯\_(ツ)_/¯
                model.addRow(j.toArray());
            });
        }
        else
        {
            temp.add(venta);
            model.addRow(venta.toArray());
        }
    }
    
    public Double getTotal()
    {
        Double total = 0.0;
        for (jtableVentaModel j : temp) {
            total+=j.getSubtotal();
        }
        return total;
    }
    
    public int buscarProductoEnTabla(ArrayList<jtableVentaModel> obj,String prod)
    {
        for (int i = 0; i < obj.size(); i++) {
           if (obj.get(i).getNombre().equals(prod)) {
                return i;
            } 
        }
        return -1;
    }
    
    public boolean validarComboBox(JComboBox cbx)
    {
        try {
            String i = cbx.getSelectedItem().toString();
            Integer j = Integer.parseInt(i);
            if (j <= 0) {
                mostrarAlerta("La cantidad a vender no puede ser menor a 1", "Cantidad"
                              + " no válida");
                return false;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("El campo cantidad solo acepta números, intente de nuevo.\n \n"
                        + "Error: " + e.toString(), 
                          "Ingrese solo numeros (Cantidad)");
            return false;
        }
        return true;
    }
    public void mostrarAlerta(String mensaje, String titulo)
    {
        JOptionPane.showMessageDialog(null,mensaje,titulo,
                                      JOptionPane.WARNING_MESSAGE);
    }
    public boolean login(String usuario, String clave)
    {
        boolean bool = (boolean) manager.createNamedQuery("Usuario.login")
                                 .setParameter("usser", usuario)
                                 .setParameter("pssword", clave)
                                 .getSingleResult();
        return bool;
    }
    public void setScreenCentered(JFrame jFrame)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation(dim.width/2-jFrame.getSize().width/2, dim.height/2-jFrame.getSize().height/2);
    }
//    public void crearVenta()
//    {
//        StoredProcedureQuery nq = manager.createNamedStoredProcedureQuery("Venta.vender")
//                    .setParameter("pidc", 1)
//                    .setParameter("pidempleado",1)
//                    .setParameter("piva",0.20)
//                    .setParameter("pdesc", 0.0);
//        nq.execute();
//        System.out.println(nq.getOutputParameterValue("idventx"));
//        //int idFactura = (int) nq.getOutputParameterValue("idventx");        
//        //crearDetalleVenta(idFactura);
//    }
    public void crearVenta(String nCliente, String aCliente)
    { 
        try {
            Cliente cli = (Cliente) manager.createQuery("SELECT c FROM Cliente c WHERE c.nombre = :nombre AND c.apellido = :apellido")
                .setParameter("nombre", nCliente)
                .setParameter("apellido",aCliente)
                .getSingleResult();
            
            StoredProcedureQuery nq = manager.createNamedStoredProcedureQuery("Venta.vender")
                        .setParameter("pidc", cli.getIdCliente())
                        .setParameter("pidempleado",1)
                        .setParameter("piva",0.20)
                        .setParameter("pdesc", 0.0);
            nq.execute();
            int idFactura = Integer.valueOf(nq.getOutputParameterValue("idventx").toString());        
            crearDetalleVenta(idFactura);
        } catch (Exception e) {
            mostrarAlerta("No se encontro al cliente en la base de datos intente de nuevo\nError:\n" +e.toString(), "Error!");
        }    
    }
    public void crearDetalleVenta(int idFactura)
    {
        for (jtableVentaModel j : temp) {
            StoredProcedureQuery nq = manager.createNamedStoredProcedureQuery("Detalleventa.detalleventa")
                    .setParameter("pidprod", j.getIdProducto())
                    .setParameter("pidventa",idFactura)
                    .setParameter("pcantidad",j.getCantidad());
            nq.execute();
        }
        mostrarAlerta("Venta satisfactoria", "Exito");
    }
    public void clearJTable(JTable jTable)
    {
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
    List<Producto> listado = manager.createQuery("SELECT p FROM "+tabla+" p").getResultList();
    DefaultTableModel Modelo = new DefaultTableModel(null,titulos);
        for (Producto p : listado) {
            Modelo.addRow(new Object[]{p.getIdProducto(),p.getProducto(),p.getDescripcion(),p.getIdMarca().getMarca()});
        }
        jtable.setModel(Modelo);
    }
    public void fillJTable(JTable jtable,String tabla,String filtro,String busqueda,String []titulos){
    List<Producto> listado = manager.createQuery("SELECT p FROM "+tabla+" p where p."+filtro+" like %"+busqueda+"%").getResultList();
    DefaultTableModel Modelo = new DefaultTableModel(null,titulos);
        for (Producto p : listado) {
            Modelo.addRow(new Object[]{p.getProducto(),p.getDescripcion()});
        }
        jtable.setModel(Modelo);
    }
    public List<Producto> obtenerproducto(String tabla,int id,String filtro){
        List<Producto> listado2 = manager.createQuery("SELECT p FROM "+tabla+" p where p."+filtro+"="+id).getResultList();
        return listado2;
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
    public int insertProveedor(String prov,String dir){
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
    return codigo;}
    
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
       int insertmarca=0;
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
    public void crearCompra(String proveedor,String dir,Date fecha,String representante,String dui){
        int insertCompra =0;
        try{
            Proveedor p = (Proveedor) manager.createNamedQuery("Proveedor.findByProveedor")
                    .setParameter("proveedor","%"+proveedor+"%")
                    .getSingleResult();
            StoredProcedureQuery np = manager.createNamedStoredProcedureQuery("Compra.comprar")
                    .setParameter("pidprov",insertProveedor(proveedor,dir))
                    .setParameter("pfecha",fecha)
                    .setParameter(("prepresentante"),representante)
                    .setParameter("pdui",dui);
                    np.execute();
                    insertCompra=Integer.valueOf(np.getOutputParameterValue("midcompra").toString());
            }catch(Exception e){
            
            }
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
}