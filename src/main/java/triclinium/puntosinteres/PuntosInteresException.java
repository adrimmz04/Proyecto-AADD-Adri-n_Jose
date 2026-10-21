package triclinium.puntosinteres;

/**
 * Fallo al obtener los puntos de interés de la fuente externa
 * (error de red, respuesta inválida, límite de peticiones de GeoNames...).
 */
@SuppressWarnings("serial")
public class PuntosInteresException extends Exception {

	public PuntosInteresException(String msg, Throwable causa) {
		super(msg, causa);
	}

	public PuntosInteresException(String msg) {
		super(msg);
	}
}
