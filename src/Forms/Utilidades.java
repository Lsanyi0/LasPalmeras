package Forms;

import Entities.Cliente;
import Entities.Inventario;
import Entities.Producto;
import Model.jtableVentaModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
    
    public Utilidades() {
        emf = Persistence.createEntityManagerFactory("AgroServPU");
        manager = emf.createEntityManager();
        temp = new ArrayList<>();
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
    
    public void fillJList(JList lista, String filtro, String busqueda, String tabla) {
        List<String> linv = manager.createQuery("SELECT p.producto FROM " + tabla
                + " p WHERE p." + filtro + " LIKE '%" + busqueda + "%'")
                .getResultList();
        setJListModel(linv, lista);
    }
    
    private void setJListModel(List linv, JList lista) {
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
    public int getInventarioByNombre(String nombreProducto) {
        Producto prod = getProductoByNombre(nombreProducto);
        Inventario inv = (Inventario) manager.createNamedQuery("Inventario.findByIdProducto")
                .setParameter("idProducto", prod.getIdProducto())
                .getSingleResult();
        return inv.getExistencia();
    }
    
    //getPrecioByNombre retorna un Double que representa el precio de venta del producto
    public Double getPrecioByNombre(String nombreProducto) {
        Producto prod = getProductoByNombre(nombreProducto);
        return prod.getPrecio();
    }
    
    //Metodo addToJTableVenta() metodo especifico para llenar la tabla venta (Form GenarVenta)
    public void addToJTableVenta(JTable jtable, String nombreProducto, int cantidad) {
        Producto prod = getProductoByNombre(nombreProducto);
        //El modelo para la tabla solo para crear el objeto que contega, los datos que se quieren ingresar a la tabla
        jtableVentaModel venta = new jtableVentaModel(prod.getIdProducto(),
                cantidad, prod.getProducto(), prod.getPrecio());
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        //Verificamos si el objeto temp(contiene todas las entradas a la tabla) ya posee un producto
        int ya = buscarProductoEnTabla(temp, venta.getNombre());
        
        if (ya != -1) {
            if (temp.get(ya).getCantidad() + venta.getCantidad() < getInventarioByNombre(nombreProducto)) {
                temp.get(ya).setCantidad(cantidad + temp.get(ya).getCantidad());
            } else {
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
        } else {
            temp.add(venta);
            model.addRow(venta.toArray());
        }
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
    
    public boolean login(String usuario, String clave) {
        boolean bool = (boolean) manager.createNamedQuery("Usuario.login")
                .setParameter("usser", usuario)
                .setParameter("pssword", clave)
                .getSingleResult();
        return bool;
    }
    
    public void setScreenCentered(JFrame jFrame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation(dim.width / 2 - jFrame.getSize().width / 2,
                dim.height / 2 - jFrame.getSize().height / 2);
    }
    
    public void crearVenta(String nCliente, String aCliente) {
        try {
            Cliente cli = (Cliente) manager.createQuery("SELECT c FROM Cliente c"
                    + " WHERE c.nombre LIKE :nombre AND c.apellido LIKE :apellido")
                    .setParameter("nombre", "%" + nCliente + "%")
                    .setParameter("apellido", "%" + aCliente + "%")
                    .getSingleResult();
            
            StoredProcedureQuery nq = manager.createNamedStoredProcedureQuery("Venta.vender")
                    .setParameter("pidc", cli.getIdCliente())
                    .setParameter("pidempleado", 1)
                    .setParameter("piva", 0.20)
                    .setParameter("pdesc", 0.0);
            nq.execute();
            int idFactura = Integer.valueOf(nq.getOutputParameterValue("idventx")
                    .toString());
            crearDetalleVenta(idFactura);
        } catch (NumberFormatException e) {
            mostrarAlerta("No se encontro al cliente en la base de datos intente"
                    + " de nuevo\nError:\n" + e.toString(), "Error!");
        }
    }
    
    private void crearDetalleVenta(int idFactura) {
        for (jtableVentaModel j : temp) {
            StoredProcedureQuery nq = manager.createNamedStoredProcedureQuery("Detalleventa.detalleventa")
                    .setParameter("pidprod", j.getIdProducto())
                    .setParameter("pidventa", idFactura)
                    .setParameter("pcantidad", j.getCantidad());
            nq.execute();
        }
        mostrarAlerta("Venta satisfactoria", "Exito");
    }
    
    public void clearJTable(JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        jTable.setModel(model);
        temp.clear();
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
}