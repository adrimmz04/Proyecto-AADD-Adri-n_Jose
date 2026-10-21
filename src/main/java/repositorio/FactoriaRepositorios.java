package repositorio;

import utils.PropertiesReader;

/**
 * Obtiene la implementación del repositorio de una entidad a partir del
 * fichero de configuración repositorios.properties (inversión de dependencias).
 */
public class FactoriaRepositorios {

	private static final String PROPERTIES = "repositorios.properties";

	@SuppressWarnings("unchecked")
	public static <T, K, R extends Repositorio<T, K>> R getRepositorio(Class<?> entidad) {
		try {
			PropertiesReader properties = new PropertiesReader(PROPERTIES);
			String clase = properties.getProperty(entidad.getName());
			if (clase == null)
				throw new RuntimeException("No hay repositorio configurado para " + entidad.getName());
			return (R) Class.forName(clase).getConstructor().newInstance();
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("No se ha podido obtener el repositorio para " + entidad.getName(), e);
		}
	}
}
