package servicio;

import java.util.HashMap;
import java.util.Map;

import utils.PropertiesReader;

/**
 * Obtiene la implementación de un servicio a partir del fichero
 * servicios.properties. Gestiona una única instancia por servicio (singleton).
 */
public class FactoriaServicios {

	private static final String PROPERTIES = "servicios.properties";

	private static final Map<Class<?>, Object> servicios = new HashMap<>();

	@SuppressWarnings("unchecked")
	public static synchronized <T> T getServicio(Class<T> servicio) {
		try {
			if (servicios.containsKey(servicio))
				return (T) servicios.get(servicio);

			PropertiesReader properties = new PropertiesReader(PROPERTIES);
			String clase = properties.getProperty(servicio.getName());
			if (clase == null)
				throw new RuntimeException("No hay implementación configurada para " + servicio.getName());

			T instancia = (T) Class.forName(clase).getConstructor().newInstance();
			servicios.put(servicio, instancia);
			return instancia;
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("No se ha podido obtener la implementación de " + servicio.getName(), e);
		}
	}
}
