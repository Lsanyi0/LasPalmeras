/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.exceptions.NonexistentEntityException;
import Entities.Compra;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Proveedor;
import Entities.Detallecompra;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Luis
 */
public class CompraJpaController implements Serializable {

    public CompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Compra compra) {
        if (compra.getDetallecompraList() == null) {
            compra.setDetallecompraList(new ArrayList<Detallecompra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor idProveedor = compra.getIdProveedor();
            if (idProveedor != null) {
                idProveedor = em.getReference(idProveedor.getClass(), idProveedor.getIdProveedor());
                compra.setIdProveedor(idProveedor);
            }
            List<Detallecompra> attachedDetallecompraList = new ArrayList<Detallecompra>();
            for (Detallecompra detallecompraListDetallecompraToAttach : compra.getDetallecompraList()) {
                detallecompraListDetallecompraToAttach = em.getReference(detallecompraListDetallecompraToAttach.getClass(), detallecompraListDetallecompraToAttach.getIdDetalleCompra());
                attachedDetallecompraList.add(detallecompraListDetallecompraToAttach);
            }
            compra.setDetallecompraList(attachedDetallecompraList);
            em.persist(compra);
            if (idProveedor != null) {
                idProveedor.getCompraList().add(compra);
                idProveedor = em.merge(idProveedor);
            }
            for (Detallecompra detallecompraListDetallecompra : compra.getDetallecompraList()) {
                Compra oldIdCompraOfDetallecompraListDetallecompra = detallecompraListDetallecompra.getIdCompra();
                detallecompraListDetallecompra.setIdCompra(compra);
                detallecompraListDetallecompra = em.merge(detallecompraListDetallecompra);
                if (oldIdCompraOfDetallecompraListDetallecompra != null) {
                    oldIdCompraOfDetallecompraListDetallecompra.getDetallecompraList().remove(detallecompraListDetallecompra);
                    oldIdCompraOfDetallecompraListDetallecompra = em.merge(oldIdCompraOfDetallecompraListDetallecompra);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Compra compra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra persistentCompra = em.find(Compra.class, compra.getIdCompra());
            Proveedor idProveedorOld = persistentCompra.getIdProveedor();
            Proveedor idProveedorNew = compra.getIdProveedor();
            List<Detallecompra> detallecompraListOld = persistentCompra.getDetallecompraList();
            List<Detallecompra> detallecompraListNew = compra.getDetallecompraList();
            if (idProveedorNew != null) {
                idProveedorNew = em.getReference(idProveedorNew.getClass(), idProveedorNew.getIdProveedor());
                compra.setIdProveedor(idProveedorNew);
            }
            List<Detallecompra> attachedDetallecompraListNew = new ArrayList<Detallecompra>();
            for (Detallecompra detallecompraListNewDetallecompraToAttach : detallecompraListNew) {
                detallecompraListNewDetallecompraToAttach = em.getReference(detallecompraListNewDetallecompraToAttach.getClass(), detallecompraListNewDetallecompraToAttach.getIdDetalleCompra());
                attachedDetallecompraListNew.add(detallecompraListNewDetallecompraToAttach);
            }
            detallecompraListNew = attachedDetallecompraListNew;
            compra.setDetallecompraList(detallecompraListNew);
            compra = em.merge(compra);
            if (idProveedorOld != null && !idProveedorOld.equals(idProveedorNew)) {
                idProveedorOld.getCompraList().remove(compra);
                idProveedorOld = em.merge(idProveedorOld);
            }
            if (idProveedorNew != null && !idProveedorNew.equals(idProveedorOld)) {
                idProveedorNew.getCompraList().add(compra);
                idProveedorNew = em.merge(idProveedorNew);
            }
            for (Detallecompra detallecompraListOldDetallecompra : detallecompraListOld) {
                if (!detallecompraListNew.contains(detallecompraListOldDetallecompra)) {
                    detallecompraListOldDetallecompra.setIdCompra(null);
                    detallecompraListOldDetallecompra = em.merge(detallecompraListOldDetallecompra);
                }
            }
            for (Detallecompra detallecompraListNewDetallecompra : detallecompraListNew) {
                if (!detallecompraListOld.contains(detallecompraListNewDetallecompra)) {
                    Compra oldIdCompraOfDetallecompraListNewDetallecompra = detallecompraListNewDetallecompra.getIdCompra();
                    detallecompraListNewDetallecompra.setIdCompra(compra);
                    detallecompraListNewDetallecompra = em.merge(detallecompraListNewDetallecompra);
                    if (oldIdCompraOfDetallecompraListNewDetallecompra != null && !oldIdCompraOfDetallecompraListNewDetallecompra.equals(compra)) {
                        oldIdCompraOfDetallecompraListNewDetallecompra.getDetallecompraList().remove(detallecompraListNewDetallecompra);
                        oldIdCompraOfDetallecompraListNewDetallecompra = em.merge(oldIdCompraOfDetallecompraListNewDetallecompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = compra.getIdCompra();
                if (findCompra(id) == null) {
                    throw new NonexistentEntityException("The compra with id " + id + " no longer exists.");
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
            Compra compra;
            try {
                compra = em.getReference(Compra.class, id);
                compra.getIdCompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compra with id " + id + " no longer exists.", enfe);
            }
            Proveedor idProveedor = compra.getIdProveedor();
            if (idProveedor != null) {
                idProveedor.getCompraList().remove(compra);
                idProveedor = em.merge(idProveedor);
            }
            List<Detallecompra> detallecompraList = compra.getDetallecompraList();
            for (Detallecompra detallecompraListDetallecompra : detallecompraList) {
                detallecompraListDetallecompra.setIdCompra(null);
                detallecompraListDetallecompra = em.merge(detallecompraListDetallecompra);
            }
            em.remove(compra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Compra> findCompraEntities() {
        return findCompraEntities(true, -1, -1);
    }

    public List<Compra> findCompraEntities(int maxResults, int firstResult) {
        return findCompraEntities(false, maxResults, firstResult);
    }

    private List<Compra> findCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Compra.class));
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

    public Compra findCompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compra.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Compra> rt = cq.from(Compra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
