package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Gestiona los objetos EntityManager (uno por hilo).
 */
public class EntityManagerHelper {

	private static final String UNIDAD_PERSISTENCIA = "triclinium";

	private static final EntityManagerFactory entityManagerFactory;
	private static final ThreadLocal<EntityManager> entityManagerHolder;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);
		entityManagerHolder = new ThreadLocal<>();
	}

	public static EntityManager getEntityManager() {
		EntityManager em = entityManagerHolder.get();
		if (em == null || !em.isOpen()) {
			em = entityManagerFactory.createEntityManager();
			entityManagerHolder.set(em);
		}
		return em;
	}

	public static void closeEntityManager() {
		EntityManager em = entityManagerHolder.get();
		if (em != null) {
			entityManagerHolder.set(null);
			if (em.isOpen())
				em.close();
		}
	}

	/** Cierra la factoría al terminar la aplicación. */
	public static void close() {
		closeEntityManager();
		if (entityManagerFactory.isOpen())
			entityManagerFactory.close();
	}
}
