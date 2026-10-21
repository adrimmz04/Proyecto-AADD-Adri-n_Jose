package triclinium.modelo;

/**
 * Listado resumen de platos (carta filtrada y platos excluidos).
 * El constructor permite crearlo directamente en JPQL con SELECT NEW.
 */
public class PlatoResumen {

	private final String id;
	private final String nombre;
	private final String descripcion;
	private final double precio;
	private final String categoria;

	public PlatoResumen(String id, String nombre, String descripcion, double precio, String categoria) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public String getCategoria() {
		return categoria;
	}

	@Override
	public String toString() {
		return "PlatoResumen [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria
				+ "]";
	}
}
