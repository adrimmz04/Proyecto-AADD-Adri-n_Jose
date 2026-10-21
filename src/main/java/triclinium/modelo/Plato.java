package triclinium.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Plato de la carta de un restaurante.
 *
 * El identificador (UUID) lo asigna el servicio al dar de alta el plato,
 * ya que los platos se gestionan a través del restaurante (no tienen
 * repositorio propio).
 */
@Entity
@Table(name = "plato")
@SuppressWarnings("serial")
public class Plato implements Serializable {

	@Id
	@Column(name = "id", length = 36)
	private String id;

	@Column(name = "nombre")
	private String nombre;

	@Lob
	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "precio")
	private double precio;

	@Column(name = "categoria")
	private String categoria;

	@Column(name = "en_carta")
	private boolean enCarta;

	public Plato() {
	}

	public Plato(String id, String nombre, String descripcion, String categoria, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.precio = precio;
		this.enCarta = true; // un plato nuevo se crea incluido en la carta
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isEnCarta() {
		return enCarta;
	}

	public void setEnCarta(boolean enCarta) {
		this.enCarta = enCarta;
	}

	@Override
	public String toString() {
		return "Plato [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria
				+ ", enCarta=" + enCarta + "]";
	}
}
