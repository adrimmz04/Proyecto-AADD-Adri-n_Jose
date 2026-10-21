package triclinium.servicio;

import java.util.List;

import repositorio.EntidadNoEncontrada;
import repositorio.FactoriaRepositorios;
import repositorio.RepositorioException;
import servicio.FactoriaServicios;
import triclinium.modelo.PlatoResumen;
import triclinium.modelo.Restaurante;
import triclinium.modelo.RestauranteResumen;
import triclinium.modelo.TipoCocina;
import triclinium.puntosinteres.IServicioPuntosInteres;
import triclinium.puntosinteres.PuntosInteresException;
import triclinium.repositorio.RepositorioAdHocRestaurantes;

/**
 * Implementación del servicio de restaurantes.
 */
public class ServicioRestaurantes implements IServicioRestaurantes {

	private final RepositorioAdHocRestaurantes repositorio = FactoriaRepositorios.getRepositorio(Restaurante.class);

	private final IServicioPuntosInteres servicioPuntosInteres = FactoriaServicios
			.getServicio(IServicioPuntosInteres.class);

	@Override
	public String altaRestaurante(String nombre, String propietario, String descripcion, String telefono,
			String direccion, double latitud, double longitud, String horario, TipoCocina tipoCocina)
			throws RepositorioException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void asignarPuntosInteres(String idRestaurante, int max)
			throws RepositorioException, EntidadNoEncontrada, PuntosInteresException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void modificarRestaurante(String idRestaurante, String horario, String telefono, String descripcion,
			String direccion, Double latitud, Double longitud) throws RepositorioException, EntidadNoEncontrada {
		throw new UnsupportedOperationException();
	}

	@Override
	public Restaurante recuperarRestaurante(String idRestaurante) throws RepositorioException, EntidadNoEncontrada {
		throw new UnsupportedOperationException();
	}

	@Override
	public String altaPlato(String idRestaurante, String nombre, String descripcion, String categoria, double precio)
			throws RepositorioException, EntidadNoEncontrada {
		throw new UnsupportedOperationException();
	}

	@Override
	public void modificarPlato(String idRestaurante, String idPlato, String nombre, String descripcion,
			Double precio, String categoria) throws RepositorioException, EntidadNoEncontrada {
		throw new UnsupportedOperationException();
	}

	@Override
	public void cambiarEstadoPlato(String idRestaurante, String idPlato, boolean enCarta)
			throws RepositorioException, EntidadNoEncontrada {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<PlatoResumen> getPlatosExcluidos(String idRestaurante)
			throws RepositorioException, EntidadNoEncontrada {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<RestauranteResumen> buscarRestaurantes(String nombre, TipoCocina tipoCocina, Double precioMedioMax,
			String direccion) throws RepositorioException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<PlatoResumen> consultarCarta(String idRestaurante, Double precioMax, String categoria, String texto)
			throws RepositorioException, EntidadNoEncontrada {
		throw new UnsupportedOperationException();
	}
}
