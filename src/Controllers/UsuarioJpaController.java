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
import Entities.Rol;
import Entities.Cargo;
import Entities.Venta;
import java.util.ArrayList;
import java.util.List;
import Entities.Estadousuario;
import Entities.Telefono;
import Entities.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getVentaList() == null) {
            usuario.setVentaList(new ArrayList<Venta>());
        }
        if (usuario.getEstadousuarioList() == null) {
            usuario.setEstadousuarioList(new ArrayList<Estadousuario>());
        }
        if (usuario.getTelefonoList() == null) {
            usuario.setTelefonoList(new ArrayList<Telefono>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol idRol = usuario.getIdRol();
            if (idRol != null) {
                idRol = em.getReference(idRol.getClass(), idRol.getIdRol());
                usuario.setIdRol(idRol);
            }
            Cargo idCargo = usuario.getIdCargo();
            if (idCargo != null) {
                idCargo = em.getReference(idCargo.getClass(), idCargo.getIdCargo());
                usuario.setIdCargo(idCargo);
            }
            List<Venta> attachedVentaList = new ArrayList<Venta>();
            for (Venta ventaListVentaToAttach : usuario.getVentaList()) {
                ventaListVentaToAttach = em.getReference(ventaListVentaToAttach.getClass(), ventaListVentaToAttach.getIdVenta());
                attachedVentaList.add(ventaListVentaToAttach);
            }
            usuario.setVentaList(attachedVentaList);
            List<Estadousuario> attachedEstadousuarioList = new ArrayList<Estadousuario>();
            for (Estadousuario estadousuarioListEstadousuarioToAttach : usuario.getEstadousuarioList()) {
                estadousuarioListEstadousuarioToAttach = em.getReference(estadousuarioListEstadousuarioToAttach.getClass(), estadousuarioListEstadousuarioToAttach.getIdEstado());
                attachedEstadousuarioList.add(estadousuarioListEstadousuarioToAttach);
            }
            usuario.setEstadousuarioList(attachedEstadousuarioList);
            List<Telefono> attachedTelefonoList = new ArrayList<Telefono>();
            for (Telefono telefonoListTelefonoToAttach : usuario.getTelefonoList()) {
                telefonoListTelefonoToAttach = em.getReference(telefonoListTelefonoToAttach.getClass(), telefonoListTelefonoToAttach.getIdTelefono());
                attachedTelefonoList.add(telefonoListTelefonoToAttach);
            }
            usuario.setTelefonoList(attachedTelefonoList);
            em.persist(usuario);
            if (idRol != null) {
                idRol.getUsuarioList().add(usuario);
                idRol = em.merge(idRol);
            }
            if (idCargo != null) {
                idCargo.getUsuarioList().add(usuario);
                idCargo = em.merge(idCargo);
            }
            for (Venta ventaListVenta : usuario.getVentaList()) {
                Usuario oldIdUsuarioOfVentaListVenta = ventaListVenta.getIdUsuario();
                ventaListVenta.setIdUsuario(usuario);
                ventaListVenta = em.merge(ventaListVenta);
                if (oldIdUsuarioOfVentaListVenta != null) {
                    oldIdUsuarioOfVentaListVenta.getVentaList().remove(ventaListVenta);
                    oldIdUsuarioOfVentaListVenta = em.merge(oldIdUsuarioOfVentaListVenta);
                }
            }
            for (Estadousuario estadousuarioListEstadousuario : usuario.getEstadousuarioList()) {
                Usuario oldIdUsuarioOfEstadousuarioListEstadousuario = estadousuarioListEstadousuario.getIdUsuario();
                estadousuarioListEstadousuario.setIdUsuario(usuario);
                estadousuarioListEstadousuario = em.merge(estadousuarioListEstadousuario);
                if (oldIdUsuarioOfEstadousuarioListEstadousuario != null) {
                    oldIdUsuarioOfEstadousuarioListEstadousuario.getEstadousuarioList().remove(estadousuarioListEstadousuario);
                    oldIdUsuarioOfEstadousuarioListEstadousuario = em.merge(oldIdUsuarioOfEstadousuarioListEstadousuario);
                }
            }
            for (Telefono telefonoListTelefono : usuario.getTelefonoList()) {
                Usuario oldIdUsuarioOfTelefonoListTelefono = telefonoListTelefono.getIdUsuario();
                telefonoListTelefono.setIdUsuario(usuario);
                telefonoListTelefono = em.merge(telefonoListTelefono);
                if (oldIdUsuarioOfTelefonoListTelefono != null) {
                    oldIdUsuarioOfTelefonoListTelefono.getTelefonoList().remove(telefonoListTelefono);
                    oldIdUsuarioOfTelefonoListTelefono = em.merge(oldIdUsuarioOfTelefonoListTelefono);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdUsuario());
            Rol idRolOld = persistentUsuario.getIdRol();
            Rol idRolNew = usuario.getIdRol();
            Cargo idCargoOld = persistentUsuario.getIdCargo();
            Cargo idCargoNew = usuario.getIdCargo();
            List<Venta> ventaListOld = persistentUsuario.getVentaList();
            List<Venta> ventaListNew = usuario.getVentaList();
            List<Estadousuario> estadousuarioListOld = persistentUsuario.getEstadousuarioList();
            List<Estadousuario> estadousuarioListNew = usuario.getEstadousuarioList();
            List<Telefono> telefonoListOld = persistentUsuario.getTelefonoList();
            List<Telefono> telefonoListNew = usuario.getTelefonoList();
            if (idRolNew != null) {
                idRolNew = em.getReference(idRolNew.getClass(), idRolNew.getIdRol());
                usuario.setIdRol(idRolNew);
            }
            if (idCargoNew != null) {
                idCargoNew = em.getReference(idCargoNew.getClass(), idCargoNew.getIdCargo());
                usuario.setIdCargo(idCargoNew);
            }
            List<Venta> attachedVentaListNew = new ArrayList<Venta>();
            for (Venta ventaListNewVentaToAttach : ventaListNew) {
                ventaListNewVentaToAttach = em.getReference(ventaListNewVentaToAttach.getClass(), ventaListNewVentaToAttach.getIdVenta());
                attachedVentaListNew.add(ventaListNewVentaToAttach);
            }
            ventaListNew = attachedVentaListNew;
            usuario.setVentaList(ventaListNew);
            List<Estadousuario> attachedEstadousuarioListNew = new ArrayList<Estadousuario>();
            for (Estadousuario estadousuarioListNewEstadousuarioToAttach : estadousuarioListNew) {
                estadousuarioListNewEstadousuarioToAttach = em.getReference(estadousuarioListNewEstadousuarioToAttach.getClass(), estadousuarioListNewEstadousuarioToAttach.getIdEstado());
                attachedEstadousuarioListNew.add(estadousuarioListNewEstadousuarioToAttach);
            }
            estadousuarioListNew = attachedEstadousuarioListNew;
            usuario.setEstadousuarioList(estadousuarioListNew);
            List<Telefono> attachedTelefonoListNew = new ArrayList<Telefono>();
            for (Telefono telefonoListNewTelefonoToAttach : telefonoListNew) {
                telefonoListNewTelefonoToAttach = em.getReference(telefonoListNewTelefonoToAttach.getClass(), telefonoListNewTelefonoToAttach.getIdTelefono());
                attachedTelefonoListNew.add(telefonoListNewTelefonoToAttach);
            }
            telefonoListNew = attachedTelefonoListNew;
            usuario.setTelefonoList(telefonoListNew);
            usuario = em.merge(usuario);
            if (idRolOld != null && !idRolOld.equals(idRolNew)) {
                idRolOld.getUsuarioList().remove(usuario);
                idRolOld = em.merge(idRolOld);
            }
            if (idRolNew != null && !idRolNew.equals(idRolOld)) {
                idRolNew.getUsuarioList().add(usuario);
                idRolNew = em.merge(idRolNew);
            }
            if (idCargoOld != null && !idCargoOld.equals(idCargoNew)) {
                idCargoOld.getUsuarioList().remove(usuario);
                idCargoOld = em.merge(idCargoOld);
            }
            if (idCargoNew != null && !idCargoNew.equals(idCargoOld)) {
                idCargoNew.getUsuarioList().add(usuario);
                idCargoNew = em.merge(idCargoNew);
            }
            for (Venta ventaListOldVenta : ventaListOld) {
                if (!ventaListNew.contains(ventaListOldVenta)) {
                    ventaListOldVenta.setIdUsuario(null);
                    ventaListOldVenta = em.merge(ventaListOldVenta);
                }
            }
            for (Venta ventaListNewVenta : ventaListNew) {
                if (!ventaListOld.contains(ventaListNewVenta)) {
                    Usuario oldIdUsuarioOfVentaListNewVenta = ventaListNewVenta.getIdUsuario();
                    ventaListNewVenta.setIdUsuario(usuario);
                    ventaListNewVenta = em.merge(ventaListNewVenta);
                    if (oldIdUsuarioOfVentaListNewVenta != null && !oldIdUsuarioOfVentaListNewVenta.equals(usuario)) {
                        oldIdUsuarioOfVentaListNewVenta.getVentaList().remove(ventaListNewVenta);
                        oldIdUsuarioOfVentaListNewVenta = em.merge(oldIdUsuarioOfVentaListNewVenta);
                    }
                }
            }
            for (Estadousuario estadousuarioListOldEstadousuario : estadousuarioListOld) {
                if (!estadousuarioListNew.contains(estadousuarioListOldEstadousuario)) {
                    estadousuarioListOldEstadousuario.setIdUsuario(null);
                    estadousuarioListOldEstadousuario = em.merge(estadousuarioListOldEstadousuario);
                }
            }
            for (Estadousuario estadousuarioListNewEstadousuario : estadousuarioListNew) {
                if (!estadousuarioListOld.contains(estadousuarioListNewEstadousuario)) {
                    Usuario oldIdUsuarioOfEstadousuarioListNewEstadousuario = estadousuarioListNewEstadousuario.getIdUsuario();
                    estadousuarioListNewEstadousuario.setIdUsuario(usuario);
                    estadousuarioListNewEstadousuario = em.merge(estadousuarioListNewEstadousuario);
                    if (oldIdUsuarioOfEstadousuarioListNewEstadousuario != null && !oldIdUsuarioOfEstadousuarioListNewEstadousuario.equals(usuario)) {
                        oldIdUsuarioOfEstadousuarioListNewEstadousuario.getEstadousuarioList().remove(estadousuarioListNewEstadousuario);
                        oldIdUsuarioOfEstadousuarioListNewEstadousuario = em.merge(oldIdUsuarioOfEstadousuarioListNewEstadousuario);
                    }
                }
            }
            for (Telefono telefonoListOldTelefono : telefonoListOld) {
                if (!telefonoListNew.contains(telefonoListOldTelefono)) {
                    telefonoListOldTelefono.setIdUsuario(null);
                    telefonoListOldTelefono = em.merge(telefonoListOldTelefono);
                }
            }
            for (Telefono telefonoListNewTelefono : telefonoListNew) {
                if (!telefonoListOld.contains(telefonoListNewTelefono)) {
                    Usuario oldIdUsuarioOfTelefonoListNewTelefono = telefonoListNewTelefono.getIdUsuario();
                    telefonoListNewTelefono.setIdUsuario(usuario);
                    telefonoListNewTelefono = em.merge(telefonoListNewTelefono);
                    if (oldIdUsuarioOfTelefonoListNewTelefono != null && !oldIdUsuarioOfTelefonoListNewTelefono.equals(usuario)) {
                        oldIdUsuarioOfTelefonoListNewTelefono.getTelefonoList().remove(telefonoListNewTelefono);
                        oldIdUsuarioOfTelefonoListNewTelefono = em.merge(oldIdUsuarioOfTelefonoListNewTelefono);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getIdUsuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            Rol idRol = usuario.getIdRol();
            if (idRol != null) {
                idRol.getUsuarioList().remove(usuario);
                idRol = em.merge(idRol);
            }
            Cargo idCargo = usuario.getIdCargo();
            if (idCargo != null) {
                idCargo.getUsuarioList().remove(usuario);
                idCargo = em.merge(idCargo);
            }
            List<Venta> ventaList = usuario.getVentaList();
            for (Venta ventaListVenta : ventaList) {
                ventaListVenta.setIdUsuario(null);
                ventaListVenta = em.merge(ventaListVenta);
            }
            List<Estadousuario> estadousuarioList = usuario.getEstadousuarioList();
            for (Estadousuario estadousuarioListEstadousuario : estadousuarioList) {
                estadousuarioListEstadousuario.setIdUsuario(null);
                estadousuarioListEstadousuario = em.merge(estadousuarioListEstadousuario);
            }
            List<Telefono> telefonoList = usuario.getTelefonoList();
            for (Telefono telefonoListTelefono : telefonoList) {
                telefonoListTelefono.setIdUsuario(null);
                telefonoListTelefono = em.merge(telefonoListTelefono);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
