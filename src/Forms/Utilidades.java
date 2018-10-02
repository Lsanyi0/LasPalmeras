package Forms;

import Entities.Inventario;
import Entities.Producto;
import Model.jtableVentaModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JList;
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
        jtableVentaModel venta = new jtableVentaModel(cantidad, prod.getProducto()
                                    , prod.getPrecio());              
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        
        int ya = buscarProductoEnTabla(temp, venta.getNombre());
        
        if (ya != -1) {
            temp.get(ya).setCantidad(cantidad+temp.get(ya).getCantidad());
            model.setRowCount(0);
            temp.forEach((j) -> { //no se como pero java sabe que hacer ¯\_(ツ)_/¯
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
}