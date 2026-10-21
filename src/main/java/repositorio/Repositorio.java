package repositorio;

import java.util.List;

/**
 * Abstracción de una colección persistente de entidades (patrón Repositorio).
 *
 * @param <T> tipo de la entidad
 * @param <K> tipo del identificador
 */
public interface Repositorio<T, K> {

	K add(T entity) throws RepositorioException;

	void update(T entity) throws RepositorioException, EntidadNoEncontrada;

	void delete(T entity) throws RepositorioException, EntidadNoEncontrada;

	T getById(K id) throws RepositorioException, EntidadNoEncontrada;

	List<T> getAll() throws RepositorioException;

	List<K> getIds() throws RepositorioException;
}
