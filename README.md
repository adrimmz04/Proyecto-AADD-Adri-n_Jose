# TricliniUM

Gestión y promoción de restaurantes. Proyecto de Aplicaciones Distribuidas (Ejercicio 1).

**Autores:** Adrián Martínez Zamora y José Luis Fenoll Pardo

## Tecnologías

- Java 11 y Maven
- JPA 2.2 (EclipseLink) sobre MySQL 8, esquema `tricliniumMartinezZamora`
- API GeoNames (`findNearbyWikipedia`), procesada con DOM

## Estructura

| Paquete | Contenido |
|---|---|
| `repositorio` | Repositorio genérico, `RepositorioJPA`, excepciones y `FactoriaRepositorios` |
| `servicio` | `FactoriaServicios` |
| `utils` | `EntityManagerHelper`, `PropertiesReader` |
| `triclinium.modelo` | Entidades JPA (`Restaurante`, `Plato`, `PuntoInteres`, `TipoCocina`) y resúmenes |
| `triclinium.repositorio` | Repositorio ad hoc de restaurantes y su implementación JPA |
| `triclinium.puntosinteres` | Fuente externa de puntos de interés (GeoNames) |
| `triclinium.servicio` | `IServicioRestaurantes` y su implementación |
| `triclinium.servicio.test` | Programa de pruebas |

## Configuración

- `META-INF/persistence.xml`: conexión a la base de datos.
- `geonames.properties`: cuenta de GeoNames.
- `repositorios.properties` y `servicios.properties`: implementaciones de repositorios y servicios.
