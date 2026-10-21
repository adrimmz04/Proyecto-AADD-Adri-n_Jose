package triclinium.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import repositorio.Identificable;

/**
 * Restaurante: raíz del agregado. Los platos y los puntos de interés se
 * gestionan siempre a través de él.
 *
 * Las colecciones se cargan de forma inmediata (EAGER) porque el
 * EntityManager se cierra al terminar cada operación del repositorio.
 */
@Entity
@Table(name = "restaurante")
@SuppressWarnings("serial")
public class Restaurante implements Identificable, Serializable {

	@Id
	@Column(name = "id", length = 36)
	private String id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "propietario")
	private String propietario;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "latitud")
	private double latitud;

	@Column(name = "longitud")
	private double longitud;

	@Lob
	@Column(name = "descripcion")
	private String descripcion;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_cocina")
	private TipoCocina tipoCocina;

	@Column(name = "horario")
	private String horario;

	/** Ordenados de menor a mayor distancia; @OrderColumn conserva ese orden. */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "punto_interes", joinColumns = @JoinColumn(name = "restaurante_fk"))
	@OrderColumn(name = "orden")
	private List<PuntoInteres> puntosInteres = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "restaurante_fk")
	private List<Plato> carta = new ArrayList<>();

	public Restaurante() {
	}

	public Restaurante(String nombre, String propietario, String descripcion, String telefono, String direccion,
			double latitud, double longitud, String horario, TipoCocina tipoCocina) {
		this.nombre = nombre;
		this.propietario = propietario;
		this.descripcion = descripcion;
		this.telefono = telefono;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.horario = horario;
		this.tipoCocina = tipoCocina;
	}

	// ---- Operaciones del dominio ----

	public void addPlato(Plato plato) {
		carta.add(plato);
	}

	public Optional<Plato> getPlato(String idPlato) {
		return carta.stream().filter(p -> p.getId().equals(idPlato)).findFirst();
	}

	/** Cambia las coordenadas; los puntos de interés dejan de ser válidos. */
	public void setCoordenadas(double latitud, double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
		this.puntosInteres.clear();
	}

	// ---- Getters y setters ----

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoCocina getTipoCocina() {
		return tipoCocina;
	}

	public void setTipoCocina(TipoCocina tipoCocina) {
		this.tipoCocina = tipoCocina;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public List<PuntoInteres> getPuntosInteres() {
		return puntosInteres;
	}

	public void setPuntosInteres(List<PuntoInteres> puntosInteres) {
		this.puntosInteres = puntosInteres;
	}

	public List<Plato> getCarta() {
		return carta;
	}

	public void setCarta(List<Plato> carta) {
		this.carta = carta;
	}

	@Override
	public String toString() {
		return "Restaurante [id=" + id + ", nombre=" + nombre + ", propietario=" + propietario + ", telefono="
				+ telefono + ", direccion=" + direccion + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", tipoCocina=" + tipoCocina + ", horario=" + horario + ", puntosInteres=" + puntosInteres.size()
				+ ", platos=" + carta.size() + "]";
	}
}
