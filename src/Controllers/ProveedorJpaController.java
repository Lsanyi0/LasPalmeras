/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Compra;
import Entities.Proveedor;
import java.util.ArrayList;
import java.util.List;
import Entities.Telefono;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class ProveedorJpaController implements Serializable {

    public ProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedor proveedor) {
        if (proveedor.getCompraList() == null) {
            proveedor.setCompraList(new ArrayList<Compra>());
        }
        if (proveedor.getTelefonoList() == null) {
            proveedor.setTelefonoList(new ArrayList<Telefono>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Compra> attachedCompraList = new ArrayList<Compra>();
            for (Compra compraListCompraToAttach : proveedor.getCompraList()) {
                compraListCompraToAttach = em.getReference(compraListCompraToAttach.getClass(), compraListCompraToAttach.getIdCompra());
                attachedCompraList.add(compraListCompraToAttach);
            }
            proveedor.setCompraList(attachedCompraList);
            List<Telefono> attachedTelefonoList = new ArrayList<Telefono>();
            for (Telefono telefonoListTelefonoToAttach : proveedor.getTelefonoList()) {
                telefonoListTelefonoToAttach = em.getReference(telefonoListTelefonoToAttach.getClass(), telefonoListTelefonoToAttach.getIdTelefono());
                attachedTelefonoList.add(telefonoListTelefonoToAttach);
            }
            proveedor.setTelefonoList(attachedTelefonoList);
            em.persist(proveedor);
            for (Compra compraListCompra : proveedor.getCompraList()) {
                Proveedor oldIdProveedorOfCompraListCompra = compraListCompra.getIdProveedor();
                compraListCompra.setIdProveedor(proveedor);
                compraListCompra = em.merge(compraListCompra);
                if (oldIdProveedorOfCompraListCompra != null) {
                    oldIdProveedorOfCompraListCompra.getCompraList().remove(compraListCompra);
                    oldIdProveedorOfCompraListCompra = em.merge(oldIdProveedorOfCompraListCompra);
                }
            }
            for (Telefono telefonoListTelefono : proveedor.getTelefonoList()) {
                Proveedor oldIdProveedorOfTelefonoListTelefono = telefonoListTelefono.getIdProveedor();
                telefonoListTelefono.setIdProveedor(proveedor);
                telefonoListTelefono = em.merge(telefonoListTelefono);
                if (oldIdProveedorOfTelefonoListTelefono != null) {
                    oldIdProveedorOfTelefonoListTelefono.getTelefonoList().remove(telefonoListTelefono);
                    oldIdProveedorOfTelefonoListTelefono = em.merge(oldIdProveedorOfTelefonoListTelefono);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedor proveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor persistentProveedor = em.find(Proveedor.class, proveedor.getIdProveedor());
            List<Compra> compraListOld = persistentProveedor.getCompraList();
            List<Compra> compraListNew = proveedor.getCompraList();
            List<Telefono> telefonoListOld = persistentProveedor.getTelefonoList();
            List<Telefono> telefonoListNew = proveedor.getTelefonoList();
            List<Compra> attachedCompraListNew = new ArrayList<Compra>();
            for (Compra compraListNewCompraToAttach : compraListNew) {
                compraListNewCompraToAttach = em.getReference(compraListNewCompraToAttach.getClass(), compraListNewCompraToAttach.getIdCompra());
                attachedCompraListNew.add(compraListNewCompraToAttach);
            }
            compraListNew = attachedCompraListNew;
            proveedor.setCompraList(compraListNew);
            List<Telefono> attachedTelefonoListNew = new ArrayList<Telefono>();
            for (Telefono telefonoListNewTelefonoToAttach : telefonoListNew) {
                telefonoListNewTelefonoToAttach = em.getReference(telefonoListNewTelefonoToAttach.getClass(), telefonoListNewTelefonoToAttach.getIdTelefono());
                attachedTelefonoListNew.add(telefonoListNewTelefonoToAttach);
            }
            telefonoListNew = attachedTelefonoListNew;
            proveedor.setTelefonoList(telefonoListNew);
            proveedor = em.merge(proveedor);
            for (Compra compraListOldCompra : compraListOld) {
                if (!compraListNew.contains(compraListOldCompra)) {
                    compraListOldCompra.setIdProveedor(null);
                    compraListOldCompra = em.merge(compraListOldCompra);
                }
            }
            for (Compra compraListNewCompra : compraListNew) {
                if (!compraListOld.contains(compraListNewCompra)) {
                    Proveedor oldIdProveedorOfCompraListNewCompra = compraListNewCompra.getIdProveedor();
                    compraListNewCompra.setIdProveedor(proveedor);
                    compraListNewCompra = em.merge(compraListNewCompra);
                    if (oldIdProveedorOfCompraListNewCompra != null && !oldIdProveedorOfCompraListNewCompra.equals(proveedor)) {
                        oldIdProveedorOfCompraListNewCompra.getCompraList().remove(compraListNewCompra);
                        oldIdProveedorOfCompraListNewCompra = em.merge(oldIdProveedorOfCompraListNewCompra);
                    }
                }
            }
            for (Telefono telefonoListOldTelefono : telefonoListOld) {
                if (!telefonoListNew.contains(telefonoListOldTelefono)) {
                    telefonoListOldTelefono.setIdProveedor(null);
                    telefonoListOldTelefono = em.merge(telefonoListOldTelefono);
                }
            }
            for (Telefono telefonoListNewTelefono : telefonoListNew) {
                if (!telefonoListOld.contains(telefonoListNewTelefono)) {
                    Proveedor oldIdProveedorOfTelefonoListNewTelefono = telefonoListNewTelefono.getIdProveedor();
                    telefonoListNewTelefono.setIdProveedor(proveedor);
                    telefonoListNewTelefono = em.merge(telefonoListNewTelefono);
                    if (oldIdProveedorOfTelefonoListNewTelefono != null && !oldIdProveedorOfTelefonoListNewTelefono.equals(proveedor)) {
                        oldIdProveedorOfTelefonoListNewTelefono.getTelefonoList().remove(telefonoListNewTelefono);
                        oldIdProveedorOfTelefonoListNewTelefono = em.merge(oldIdProveedorOfTelefonoListNewTelefono);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = proveedor.getIdProveedor();
                if (findProveedor(id) == null) {
                    throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor proveedor;
            try {
                proveedor = em.getReference(Proveedor.class, id);
                proveedor.getIdProveedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.", enfe);
            }
            List<Compra> compraList = proveedor.getCompraList();
            for (Compra compraListCompra : compraList) {
                compraListCompra.setIdProveedor(null);
                compraListCompra = em.merge(compraListCompra);
            }
            List<Telefono> telefonoList = proveedor.getTelefonoList();
            for (Telefono telefonoListTelefono : telefonoList) {
                telefonoListTelefono.setIdProveedor(null);
                telefonoListTelefono = em.merge(telefonoListTelefono);
            }
            em.remove(proveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedor> findProveedorEntities() {
        return findProveedorEntities(true, -1, -1);
    }

    public List<Proveedor> findProveedorEntities(int maxResults, int firstResult) {
        return findProveedorEntities(false, maxResults, firstResult);
    }

    private List<Proveedor> findProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedor.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Proveedor findProveedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedor> rt = cq.from(Proveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
