package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Lee un fichero .properties del classpath (src/main/resources).
 */
public class PropertiesReader {

	private final Properties properties = new Properties();

	public PropertiesReader(String fichero) throws IOException {
		InputStream entrada = PropertiesReader.class.getClassLoader().getResourceAsStream(fichero);
		if (entrada == null)
			throw new IOException("No se encuentra el fichero " + fichero + " en el classpath");
		try (InputStreamReader lector = new InputStreamReader(entrada, StandardCharsets.UTF_8)) {
			properties.load(lector);
		}
	}

	public String getProperty(String clave) {
		return properties.getProperty(clave);
	}
}
