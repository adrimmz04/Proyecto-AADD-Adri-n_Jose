package triclinium.puntosinteres;

import java.util.List;

import triclinium.modelo.PuntoInteres;
import utils.PropertiesReader;

/**
 * Puntos de interés obtenidos de la operación findNearbyWikipedia de GeoNames.
 */
public class ServicioPuntosInteresGeoNames implements IServicioPuntosInteres {

	private static final String URL_BASE = "http://api.geonames.org/findNearbyWikipedia";

	private final String username;
	private final String lang;

	public ServicioPuntosInteresGeoNames() {
		try {
			PropertiesReader properties = new PropertiesReader("geonames.properties");
			this.username = properties.getProperty("geonames.username");
			this.lang = properties.getProperty("geonames.lang");
		} catch (Exception e) {
			throw new RuntimeException("No se ha podido leer geonames.properties", e);
		}
	}

	@Override
	public List<PuntoInteres> getPuntosInteres(double latitud, double longitud, int max)
			throws PuntosInteresException {
		throw new UnsupportedOperationException();
	}
}
