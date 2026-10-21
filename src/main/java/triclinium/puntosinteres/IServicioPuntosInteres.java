package triclinium.puntosinteres;

import java.util.List;

import triclinium.modelo.PuntoInteres;

/**
 * Fuente externa de puntos de interés.
 */
public interface IServicioPuntosInteres {

	/**
	 * Puntos de interés cercanos a las coordenadas, ordenados de menor a mayor
	 * distancia. Devuelve como máximo {@code max} (menos si la fuente no tiene
	 * suficientes).
	 */
	List<PuntoInteres> getPuntosInteres(double latitud, double longitud, int max) throws PuntosInteresException;
}
