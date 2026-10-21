package triclinium.servicio.test;

import servicio.FactoriaServicios;
import triclinium.servicio.IServicioRestaurantes;
import utils.EntityManagerHelper;

/**
 * Programa de prueba del servicio de restaurantes.
 */
public class Programa {

	public static void main(String[] args) {

		IServicioRestaurantes servicio = FactoriaServicios.getServicio(IServicioRestaurantes.class);

		try {
			System.out.println("Servicio obtenido: " + servicio.getClass().getName());

		} catch (Exception e) {
			System.err.println("Error inesperado: " + e);
			e.printStackTrace();
		} finally {
			EntityManagerHelper.close();
		}
	}
}
