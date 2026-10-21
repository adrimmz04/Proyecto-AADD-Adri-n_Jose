package triclinium.servicio;

import java.util.List;

import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;
import triclinium.modelo.PlatoResumen;
import triclinium.modelo.Restaurante;
import triclinium.modelo.RestauranteResumen;
import triclinium.modelo.TipoCocina;
import triclinium.puntosinteres.PuntosInteresException;

/**
 * Casos de uso de TricliniUM: gestión de restaurantes y de su carta.
 *
 * Todas las operaciones validan sus parámetros y lanzan
 * IllegalArgumentException si no son correctos, sin modificar los datos.
 */
public interface IServicioRestaurantes {

	/** HU1. Alta de un restaurante. Devuelve el identificador asignado. */
	String altaRestaurante(String nombre, String propietario, String descripcion, String telefono,
			String direccion, double latitud, double longitud, String horario, TipoCocina tipoCocina)
			throws RepositorioException;

	/**
	 * HU2. Asigna los {@code max} puntos de interés más cercanos (max > 0),
	 * reemplazando los anteriores.
	 */
	void asignarPuntosInteres(String idRestaurante, int max)
			throws RepositorioException, EntidadNoEncontrada, PuntosInteresException;

	/**
	 * HU3. Modifica los datos del restaurante. Un parámetro a null indica que
	 * ese dato no se modifica. Latitud y longitud se indican juntas; cambiar las
	 * coordenadas elimina los puntos de interés.
	 */
	void modificarRestaurante(String idRestaurante, String horario, String telefono, String descripcion,
			String direccion, Double latitud, Double longitud) throws RepositorioException, EntidadNoEncontrada;

	/** HU4. Recupera toda la información del restaurante, incluidos sus puntos de interés. */
	Restaurante recuperarRestaurante(String idRestaurante) throws RepositorioException, EntidadNoEncontrada;

	/** HU5. Alta de un plato (queda incluido en la carta). Devuelve su identificador. */
	String altaPlato(String idRestaurante, String nombre, String descripcion, String categoria, double precio)
			throws RepositorioException, EntidadNoEncontrada;

	/** HU6. Modifica un plato. Un parámetro a null indica que ese dato no se modifica. */
	void modificarPlato(String idRestaurante, String idPlato, String nombre, String descripcion, Double precio,
			String categoria) throws RepositorioException, EntidadNoEncontrada;

	/** HU7. Incluye (true) o excluye (false) un plato de la carta. */
	void cambiarEstadoPlato(String idRestaurante, String idPlato, boolean enCarta)
			throws RepositorioException, EntidadNoEncontrada;

	/** HU8. Platos que actualmente no están incluidos en la carta. */
	List<PlatoResumen> getPlatosExcluidos(String idRestaurante) throws RepositorioException, EntidadNoEncontrada;

	/** HU9. Búsqueda de restaurantes. Todos los criterios son opcionales (null). */
	List<RestauranteResumen> buscarRestaurantes(String nombre, TipoCocina tipoCocina, Double precioMedioMax,
			String direccion) throws RepositorioException;

	/** HU10. Consulta y filtrado de la carta. Todos los filtros son opcionales (null). */
	List<PlatoResumen> consultarCarta(String idRestaurante, Double precioMax, String categoria, String texto)
			throws RepositorioException, EntidadNoEncontrada;
}
