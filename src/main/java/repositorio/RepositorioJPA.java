package repositorio;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import utils.EntityManagerHelper;

/**
 * Implementación genérica del repositorio con JPA.
 *
 * El repositorio asigna a cada entidad un identificador UUID al añadirla.
 * Cada operación abre su propio EntityManager y su propia transacción; si algo
 * falla se hace rollback, de modo que la base de datos no queda modificada.
 */
public abstract class RepositorioJPA<T extends Identificable> implements RepositorioString<T> {

	/** Clase de la entidad gestionada. */
	public abstract Class<T> getClase();

	/** Nombre de la entidad en JPQL (por defecto, el nombre simple de la clase). */
	public String getNombre() {
		return getClase().getSimpleName();
	}

	@Override
	public String add(T entity) throws RepositorioException {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			String id = UUID.randomUUID().toString();
			entity.setId(id);
			em.persist(entity);
			em.getTransaction().commit();
			return id;
		} catch (RuntimeException e) {
			rollback(em);
			throw new RepositorioException("Error al guardar la entidad: " + e.getMessage(), e);
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	@Override
	public void update(T entity) throws RepositorioException, EntidadNoEncontrada {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			if (entity.getId() == null || em.find(getClase(), entity.getId()) == null) {
				em.getTransaction().rollback();
				throw new EntidadNoEncontrada(entity.getId() + " no existe en el repositorio");
			}
			em.merge(entity);
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			rollback(em);
			throw new RepositorioException("Error al actualizar la entidad: " + e.getMessage(), e);
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	@Override
	public void delete(T entity) throws RepositorioException, EntidadNoEncontrada {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			em.getTransaction().begin();
			T instancia = entity.getId() == null ? null : em.find(getClase(), entity.getId());
			if (instancia == null) {
				em.getTransaction().rollback();
				throw new EntidadNoEncontrada(entity.getId() + " no existe en el repositorio");
			}
			em.remove(instancia);
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			rollback(em);
			throw new RepositorioException("Error al borrar la entidad: " + e.getMessage(), e);
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	@Override
	public T getById(String id) throws RepositorioException, EntidadNoEncontrada {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			T instancia = em.find(getClase(), id);
			if (instancia == null)
				throw new EntidadNoEncontrada(id + " no existe en el repositorio");
			return instancia;
		} catch (RuntimeException e) {
			throw new RepositorioException("Error al recuperar la entidad con id " + id, e);
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	@Override
	public List<T> getAll() throws RepositorioException {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			String query = "SELECT t FROM " + getNombre() + " t";
			TypedQuery<T> consulta = em.createQuery(query, getClase());
			return consulta.getResultList();
		} catch (RuntimeException e) {
			throw new RepositorioException("Error al recuperar todas las entidades de " + getNombre(), e);
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	@Override
	public List<String> getIds() throws RepositorioException {
		EntityManager em = EntityManagerHelper.getEntityManager();
		try {
			String query = "SELECT t.id FROM " + getNombre() + " t";
			return em.createQuery(query, String.class).getResultList();
		} catch (RuntimeException e) {
			throw new RepositorioException("Error al recuperar los ids de " + getNombre(), e);
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
	}

	protected void rollback(EntityManager em) {
		if (em.getTransaction().isActive())
			em.getTransaction().rollback();
	}
}
