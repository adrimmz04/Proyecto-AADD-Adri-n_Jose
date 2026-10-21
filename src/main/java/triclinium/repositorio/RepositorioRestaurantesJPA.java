package triclinium.repositorio;

import java.util.List;

import repositorio.RepositorioException;
import repositorio.RepositorioJPA;
import triclinium.modelo.PlatoResumen;
import triclinium.modelo.Restaurante;
import triclinium.modelo.RestauranteResumen;
import triclinium.modelo.TipoCocina;

/**
 * Implementación JPA del repositorio de restaurantes.
 */
public class RepositorioRestaurantesJPA extends RepositorioJPA<Restaurante> implements RepositorioAdHocRestaurantes {

	@Override
	public Class<Restaurante> getClase() {
		return Restaurante.class;
	}

	@Override
	public List<RestauranteResumen> buscar(String nombre, TipoCocina tipoCocina, Double precioMedioMax,
			String direccion) throws RepositorioException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<PlatoResumen> getPlatosExcluidos(String idRestaurante) throws RepositorioException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<PlatoResumen> getCarta(String idRestaurante, Double precioMax, String categoria, String texto)
			throws RepositorioException {
		throw new UnsupportedOperationException();
	}
}
