package Forms;

import Entities.Inventario;
import Entities.Producto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JList;

  
public class Utilidades {
    
    private static EntityManager manager;
    
    private static EntityManagerFactory emf; 
    
    public Utilidades()
    {
       emf = Persistence.createEntityManagerFactory("AgroServPU");
       manager = emf.createEntityManager();
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
    
    public int getInventarioByNombre(String nombreProducto)
    {
        Producto prod = (Producto) manager.createNamedQuery("Producto.findByProducto")
                  .setParameter("producto","%"+nombreProducto+"%")
                  .getSingleResult();        
        //System.out.println(prod.getIdProducto());
        Inventario inv = (Inventario)  manager.createNamedQuery("Inventario.findByIdProducto")
                .setParameter("idProducto", prod.getIdProducto())
                .getSingleResult();      
        //System.out.println(inv.getExistencia());
        return inv.getExistencia();
    }
    
    public Double getPrecioByNombre(String nombreProducto)
    {
        Producto prod = (Producto) manager.createNamedQuery("Producto.findByProducto")
                        .setParameter("producto", nombreProducto)
                        .getSingleResult();
        return prod.getPrecio();
    }
    
    public void fillJTable()
    {
        //TODO
    }
}