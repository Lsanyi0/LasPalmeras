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
import Entities.Estadousuario;
import Entities.Historialsalario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class HistorialsalarioJpaController implements Serializable {

    public HistorialsalarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Historialsalario historialsalario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estadousuario idEstado = historialsalario.getIdEstado();
            if (idEstado != null) {
                idEstado = em.getReference(idEstado.getClass(), idEstado.getIdEstado());
                historialsalario.setIdEstado(idEstado);
            }
            em.persist(historialsalario);
            if (idEstado != null) {
                idEstado.getHistorialsalarioList().add(historialsalario);
                idEstado = em.merge(idEstado);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Historialsalario historialsalario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Historialsalario persistentHistorialsalario = em.find(Historialsalario.class, historialsalario.getIdHistorial());
            Estadousuario idEstadoOld = persistentHistorialsalario.getIdEstado();
            Estadousuario idEstadoNew = historialsalario.getIdEstado();
            if (idEstadoNew != null) {
                idEstadoNew = em.getReference(idEstadoNew.getClass(), idEstadoNew.getIdEstado());
                historialsalario.setIdEstado(idEstadoNew);
            }
            historialsalario = em.merge(historialsalario);
            if (idEstadoOld != null && !idEstadoOld.equals(idEstadoNew)) {
                idEstadoOld.getHistorialsalarioList().remove(historialsalario);
                idEstadoOld = em.merge(idEstadoOld);
            }
            if (idEstadoNew != null && !idEstadoNew.equals(idEstadoOld)) {
                idEstadoNew.getHistorialsalarioList().add(historialsalario);
                idEstadoNew = em.merge(idEstadoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = historialsalario.getIdHistorial();
                if (findHistorialsalario(id) == null) {
                    throw new NonexistentEntityException("The historialsalario with id " + id + " no longer exists.");
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
            Historialsalario historialsalario;
            try {
                historialsalario = em.getReference(Historialsalario.class, id);
                historialsalario.getIdHistorial();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historialsalario with id " + id + " no longer exists.", enfe);
            }
            Estadousuario idEstado = historialsalario.getIdEstado();
            if (idEstado != null) {
                idEstado.getHistorialsalarioList().remove(historialsalario);
                idEstado = em.merge(idEstado);
            }
            em.remove(historialsalario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Historialsalario> findHistorialsalarioEntities() {
        return findHistorialsalarioEntities(true, -1, -1);
    }

    public List<Historialsalario> findHistorialsalarioEntities(int maxResults, int firstResult) {
        return findHistorialsalarioEntities(false, maxResults, firstResult);
    }

    private List<Historialsalario> findHistorialsalarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Historialsalario.class));
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

    public Historialsalario findHistorialsalario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Historialsalario.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistorialsalarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Historialsalario> rt = cq.from(Historialsalario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
