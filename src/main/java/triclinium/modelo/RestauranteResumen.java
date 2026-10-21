package triclinium.modelo;

/**
 * Listado resumen de restaurantes (búsqueda).
 * El constructor permite crearlo directamente en JPQL con SELECT NEW.
 */
public class RestauranteResumen {

	private final String id;
	private final String nombre;
	private final TipoCocina tipoCocina;
	private final String direccion;
	/** Media de los platos en carta; null si no tiene platos en carta. */
	private final Double precioMedio;

	public RestauranteResumen(String id, String nombre, TipoCocina tipoCocina, String direccion, Double precioMedio) {
		this.id = id;
		this.nombre = nombre;
		this.tipoCocina = tipoCocina;
		this.direccion = direccion;
		this.precioMedio = precioMedio;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoCocina getTipoCocina() {
		return tipoCocina;
	}

	public String getDireccion() {
		return direccion;
	}

	public Double getPrecioMedio() {
		return precioMedio;
	}

	@Override
	public String toString() {
		return "RestauranteResumen [id=" + id + ", nombre=" + nombre + ", tipoCocina=" + tipoCocina + ", direccion="
				+ direccion + ", precioMedio=" + (precioMedio == null ? "-" : String.format("%.2f", precioMedio)) + "]";
	}
}
