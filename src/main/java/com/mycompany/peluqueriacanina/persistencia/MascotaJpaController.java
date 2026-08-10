package com.mycompany.peluqueriacanina.persistencia;

import java.io.Serializable;
import java.util.List;

import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.excepciones.NonExistentEntityException;
import com.mycompany.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 * Clase controladora de persistencia para las mascotas
 * MascotaJpaController
 */
public class MascotaJpaController implements Serializable {

    private final EntityManagerFactory emf;

    /**
     * Constructor
     * 
     * @param emf EntityManagerFactory
     */
    public MascotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Constructor por defecto que crea la EntityManagerFactory con la unidad de
     * persistencia
     */
    public MascotaJpaController() {
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
     * Método que crea una mascota en la base de datos
     * 
     * @param mascota Mascota a crear
     */
    public void create(Mascota mascota) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(mascota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Método que edita una mascota en la base de datos
     * 
     * @param mascota Mascota a editar
     * @throws NonExistentEntityException Si la mascota no existe
     * @throws Exception                  Si ocurre otro error
     */
    public void edit(Mascota mascota) throws NonExistentEntityException, Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            mascota = em.merge(mascota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mascota.getId();
                if (findMascota(id) == null) {
                    throw new NonExistentEntityException("La mascota con id " + id + " no existe.");
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
     * Método que elimina una mascota de la base de datos por su id
     * 
     * @param id Id de la mascota a eliminar
     * @throws NonExistentEntityException Si la mascota no existe
     */
    public void destroy(int id) throws NonExistentEntityException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Mascota mascota;
            try {
                mascota = em.getReference(Mascota.class, id);
                mascota.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonExistentEntityException("La mascota con id " + id + " no existe.", enfe);
            }
            em.remove(mascota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Método que cuenta las mascotas en la base de datos
     * 
     * @return Count de mascotas
     */
    public Long getMascotaCount() {
        EntityManager em = getEntityManager();
        try {
            Long count = em.createQuery(
                    "SELECT COUNT(m) FROM Mascota m",
                    Long.class)
                    .getSingleResult();
            return count.longValue();
        } catch (Exception e) {
            throw new RuntimeException("Error al contar las Mascotas: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Método que encuentra todas las mascotas en la base de datos
     * 
     * @return Listado de mascotas
     */
    public List<Mascota> findMascotaEntities() {
        return findMascotaEntities(true, -1, -1);
    }

    /**
     * Método que encuentra las mascotas dado un máximo y un mínimo de resultados
     * 
     * @param maxResult   Máximo de resultados a obtener
     * @param firstResult Mínimo de resultados a obtener
     * @return Listado de mascotas
     */
    public List<Mascota> findMascotaEntities(int maxResult, int firstResult) {
        return findMascotaEntities(false, maxResult, firstResult);
    }

    /**
     * Método privado que encuentra las mascotas en la base de datos
     * 
     * @param all         Si es true, encuentra todas las mascotas
     * @param maxResult   Máximo de resultados a obtener
     * @param firstResult Mínimo de resultados a obtener
     * @return Listado de mascotas
     */
    private List<Mascota> findMascotaEntities(boolean all, int maxResult, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Mascota> cq = cb.createQuery(Mascota.class);
            Root<Mascota> root = cq.from(Mascota.class);
            cq.select(root);
            TypedQuery<Mascota> q = em.createQuery(cq);
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
     * Método que encuentra una mascota por su id
     * 
     * @param id Id de la mascota a buscar
     * @return Mascota encontrada
     */
    public Mascota findMascota(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mascota.class, id);
        } finally {
            em.close();
        }
    }
}
