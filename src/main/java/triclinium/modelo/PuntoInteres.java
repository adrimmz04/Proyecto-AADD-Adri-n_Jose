package triclinium.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

/**
 * Punto de interés cercano a un restaurante. No tiene identidad propia:
 * se almacena embebido en la colección del restaurante.
 */
@Embeddable
@SuppressWarnings("serial")
public class PuntoInteres implements Serializable {

	@Column(name = "nombre")
	private String nombre;

	@Lob
	@Column(name = "descripcion")
	private String descripcion;

	/** Distancia al restaurante en km (tal como la devuelve GeoNames). */
	@Column(name = "distancia")
	private double distancia;

	@Column(name = "url_wikipedia", length = 1000)
	private String urlWikipedia;

	public PuntoInteres() {
	}

	public PuntoInteres(String nombre, String descripcion, double distancia, String urlWikipedia) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.distancia = distancia;
		this.urlWikipedia = urlWikipedia;
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

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public String getUrlWikipedia() {
		return urlWikipedia;
	}

	public void setUrlWikipedia(String urlWikipedia) {
		this.urlWikipedia = urlWikipedia;
	}

	@Override
	public String toString() {
		return "PuntoInteres [nombre=" + nombre + ", distancia=" + distancia + " km, url=" + urlWikipedia + "]";
	}
}
