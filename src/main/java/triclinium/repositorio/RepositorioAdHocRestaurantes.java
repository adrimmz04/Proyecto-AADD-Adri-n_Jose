package triclinium.repositorio;

import java.util.List;

import repositorio.RepositorioException;
import repositorio.RepositorioString;
import triclinium.modelo.PlatoResumen;
import triclinium.modelo.Restaurante;
import triclinium.modelo.RestauranteResumen;
import triclinium.modelo.TipoCocina;

/**
 * Repositorio ad hoc de restaurantes: añade al repositorio genérico las
 * consultas específicas que necesita el servicio.
 *
 * En todos los métodos, un parámetro de filtro a null significa
 * "no aplicar ese filtro".
 */
public interface RepositorioAdHocRestaurantes extends RepositorioString<Restaurante> {

	/**
	 * Restaurantes que cumplen todos los criterios indicados.
	 *
	 * @param nombre         contenido en el nombre, sin distinguir mayúsculas
	 * @param tipoCocina     igual al indicado
	 * @param precioMedioMax precio medio (platos en carta) menor o igual; los
	 *                       restaurantes sin platos en carta no lo cumplen
	 * @param direccion      contenido en la dirección, sin distinguir mayúsculas
	 */
	List<RestauranteResumen> buscar(String nombre, TipoCocina tipoCocina, Double precioMedioMax, String direccion)
			throws RepositorioException;

	/**
	 * Platos del restaurante que NO están incluidos en la carta.
	 */
	List<PlatoResumen> getPlatosExcluidos(String idRestaurante) throws RepositorioException;

	/**
	 * Platos incluidos en la carta del restaurante que cumplen todos los filtros.
	 *
	 * @param precioMax precio menor o igual
	 * @param categoria igual, sin distinguir mayúsculas
	 * @param texto     contenido en el nombre o en la descripción, sin distinguir
	 *                  mayúsculas
	 */
	List<PlatoResumen> getCarta(String idRestaurante, Double precioMax, String categoria, String texto)
			throws RepositorioException;
}
