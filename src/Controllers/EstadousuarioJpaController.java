/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.exceptions.NonexistentEntityException;
import Entities.Estadousuario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Usuario;
import Entities.Historialsalario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class EstadousuarioJpaController implements Serializable {

    public EstadousuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estadousuario estadousuario) {
        if (estadousuario.getHistorialsalarioList() == null) {
            estadousuario.setHistorialsalarioList(new ArrayList<Historialsalario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario idUsuario = estadousuario.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getIdUsuario());
                estadousuario.setIdUsuario(idUsuario);
            }
            List<Historialsalario> attachedHistorialsalarioList = new ArrayList<Historialsalario>();
            for (Historialsalario historialsalarioListHistorialsalarioToAttach : estadousuario.getHistorialsalarioList()) {
                historialsalarioListHistorialsalarioToAttach = em.getReference(historialsalarioListHistorialsalarioToAttach.getClass(), historialsalarioListHistorialsalarioToAttach.getIdHistorial());
                attachedHistorialsalarioList.add(historialsalarioListHistorialsalarioToAttach);
            }
            estadousuario.setHistorialsalarioList(attachedHistorialsalarioList);
            em.persist(estadousuario);
            if (idUsuario != null) {
                idUsuario.getEstadousuarioList().add(estadousuario);
                idUsuario = em.merge(idUsuario);
            }
            for (Historialsalario historialsalarioListHistorialsalario : estadousuario.getHistorialsalarioList()) {
                Estadousuario oldIdEstadoOfHistorialsalarioListHistorialsalario = historialsalarioListHistorialsalario.getIdEstado();
                historialsalarioListHistorialsalario.setIdEstado(estadousuario);
                historialsalarioListHistorialsalario = em.merge(historialsalarioListHistorialsalario);
                if (oldIdEstadoOfHistorialsalarioListHistorialsalario != null) {
                    oldIdEstadoOfHistorialsalarioListHistorialsalario.getHistorialsalarioList().remove(historialsalarioListHistorialsalario);
                    oldIdEstadoOfHistorialsalarioListHistorialsalario = em.merge(oldIdEstadoOfHistorialsalarioListHistorialsalario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estadousuario estadousuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estadousuario persistentEstadousuario = em.find(Estadousuario.class, estadousuario.getIdEstado());
            Usuario idUsuarioOld = persistentEstadousuario.getIdUsuario();
            Usuario idUsuarioNew = estadousuario.getIdUsuario();
            List<Historialsalario> historialsalarioListOld = persistentEstadousuario.getHistorialsalarioList();
            List<Historialsalario> historialsalarioListNew = estadousuario.getHistorialsalarioList();
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdUsuario());
                estadousuario.setIdUsuario(idUsuarioNew);
            }
            List<Historialsalario> attachedHistorialsalarioListNew = new ArrayList<Historialsalario>();
            for (Historialsalario historialsalarioListNewHistorialsalarioToAttach : historialsalarioListNew) {
                historialsalarioListNewHistorialsalarioToAttach = em.getReference(historialsalarioListNewHistorialsalarioToAttach.getClass(), historialsalarioListNewHistorialsalarioToAttach.getIdHistorial());
                attachedHistorialsalarioListNew.add(historialsalarioListNewHistorialsalarioToAttach);
            }
            historialsalarioListNew = attachedHistorialsalarioListNew;
            estadousuario.setHistorialsalarioList(historialsalarioListNew);
            estadousuario = em.merge(estadousuario);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getEstadousuarioList().remove(estadousuario);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getEstadousuarioList().add(estadousuario);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            for (Historialsalario historialsalarioListOldHistorialsalario : historialsalarioListOld) {
                if (!historialsalarioListNew.contains(historialsalarioListOldHistorialsalario)) {
                    historialsalarioListOldHistorialsalario.setIdEstado(null);
                    historialsalarioListOldHistorialsalario = em.merge(historialsalarioListOldHistorialsalario);
                }
            }
            for (Historialsalario historialsalarioListNewHistorialsalario : historialsalarioListNew) {
                if (!historialsalarioListOld.contains(historialsalarioListNewHistorialsalario)) {
                    Estadousuario oldIdEstadoOfHistorialsalarioListNewHistorialsalario = historialsalarioListNewHistorialsalario.getIdEstado();
                    historialsalarioListNewHistorialsalario.setIdEstado(estadousuario);
                    historialsalarioListNewHistorialsalario = em.merge(historialsalarioListNewHistorialsalario);
                    if (oldIdEstadoOfHistorialsalarioListNewHistorialsalario != null && !oldIdEstadoOfHistorialsalarioListNewHistorialsalario.equals(estadousuario)) {
                        oldIdEstadoOfHistorialsalarioListNewHistorialsalario.getHistorialsalarioList().remove(historialsalarioListNewHistorialsalario);
                        oldIdEstadoOfHistorialsalarioListNewHistorialsalario = em.merge(oldIdEstadoOfHistorialsalarioListNewHistorialsalario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estadousuario.getIdEstado();
                if (findEstadousuario(id) == null) {
                    throw new NonexistentEntityException("The estadousuario with id " + id + " no longer exists.");
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
            Estadousuario estadousuario;
            try {
                estadousuario = em.getReference(Estadousuario.class, id);
                estadousuario.getIdEstado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadousuario with id " + id + " no longer exists.", enfe);
            }
            Usuario idUsuario = estadousuario.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getEstadousuarioList().remove(estadousuario);
                idUsuario = em.merge(idUsuario);
            }
            List<Historialsalario> historialsalarioList = estadousuario.getHistorialsalarioList();
            for (Historialsalario historialsalarioListHistorialsalario : historialsalarioList) {
                historialsalarioListHistorialsalario.setIdEstado(null);
                historialsalarioListHistorialsalario = em.merge(historialsalarioListHistorialsalario);
            }
            em.remove(estadousuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estadousuario> findEstadousuarioEntities() {
        return findEstadousuarioEntities(true, -1, -1);
    }

    public List<Estadousuario> findEstadousuarioEntities(int maxResults, int firstResult) {
        return findEstadousuarioEntities(false, maxResults, firstResult);
    }

    private List<Estadousuario> findEstadousuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estadousuario.class));
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

    public Estadousuario findEstadousuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estadousuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadousuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estadousuario> rt = cq.from(Estadousuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
