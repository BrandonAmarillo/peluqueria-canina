package com.mycompany.peluqueriacanina.persistencia;

import java.io.Serializable;
import java.util.List;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.persistencia.excepciones.NonExistentEntityException;
import com.mycompany.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class DuenioJpaController implements Serializable {

    private final EntityManagerFactory emf;

    /**
     * Constructor
     * 
     * @param emf EntityManagerFactory
     */
    public DuenioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Constructor por defecto que crea la EntityManagerFactory con la unidad de
     * persistencia
     */
    public DuenioJpaController() {
        emf = JPAUtil.getEntityManagerFactory();
    }

    /**
     * Método que crea y retorna una EntityManager para trabajar con la base de
     * datos
     * 
     * @return EntityManager
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Método que crea un Dueño en la base de datos
     * 
     * @param Duenio Dueño a crear
     */
    public void create(Duenio Duenio) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(Duenio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Método que edita un Dueño en la base de datos
     * 
     * @param Duenio Dueño a editar
     * @throws NonExistentEntityException Si el Dueño no existe
     * @throws Exception                  Si ocurre otro error
     */
    public void edit(Duenio duenio) throws NonExistentEntityException, Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            duenio = em.merge(duenio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = duenio.getId();
                if (findDuenio(id) == null) {
                    throw new NonExistentEntityException("El Duenio con id " + id + " no existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Método que elimina un Dueño de la base de datos por su id
     * 
     * @param id Id del Dueño a eliminar
     * @throws NonExistentEntityException Si el Dueño no existe
     */
    public void destroy(int id) throws NonExistentEntityException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Duenio duenio;
            try {
                duenio = em.getReference(Duenio.class, id);
                duenio.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonExistentEntityException("El Duenio con id " + id + " no existe.", enfe);
            }
            em.remove(duenio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Método que cuenta los Dueños en la base de datos
     * 
     * @return Count de Dueños
     */
    public Long getDuenioCount() {
        EntityManager em = getEntityManager();
        try {
            Long count = em.createQuery(
                    "SELECT COUNT(d) FROM Duenio d",
                    Long.class)
                    .getSingleResult();
            return count.longValue();
        } catch (Exception e) {
            throw new RuntimeException("Error al contar los Dueños: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Método que encuentra todos los Dueños en la base de datos
     * 
     * @return Listado de Dueños
     */
    public List<Duenio> findDuenioEntities() {
        return findDuenioEntities(true, -1, -1);
    }

    /**
     * Método que encuentra los Dueños dado un máximo y un mínimo de resultados
     * 
     * @param maxResult   Máximo de resultados a obtener
     * @param firstResult Mínimo de resultados a obtener
     * @return Listado de Dueños
     */
    public List<Duenio> findDuenioEntities(int maxResult, int firstResult) {
        return findDuenioEntities(false, maxResult, firstResult);
    }

    /**
     * Método privado que encuentra los Dueños en la base de datos
     * 
     * @param all         Si es true, encuentra todos los Dueños
     * @param maxResult   Máximo de resultados a obtener
     * @param firstResult Mínimo de resultados a obtener
     * @return Listado de Dueños
     */
    private List<Duenio> findDuenioEntities(boolean all, int maxResult, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Duenio> cq = cb.createQuery(Duenio.class);
            Root<Duenio> root = cq.from(Duenio.class);
            cq.select(root);
            TypedQuery<Duenio> q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResult);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Método que encuentra un Dueño por su id
     * 
     * @param id Id del Dueño a buscar
     * @return Dueño encontrado
     */
    public Duenio findDuenio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Duenio.class, id);
        } finally {
            em.close();
        }
    }
}
