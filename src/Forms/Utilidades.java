package Forms;

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
    
    /*/
    public int getInventario(String nombreProducto)
    {
       String inv =  manager.createNamedQuery("getInventario")
                .setParameter("producto", nombreProducto)
                .getResultList().get(0).toString();       
        return  Integer.parseInt(inv);
    }
    /*/
    
    public void fillJTable()
    {
        //TODO
    }
}