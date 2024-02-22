package com.example.apiresthoteles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Interfaz que define operaciones de acceso a datos para la entidad {@link Hotel}.
 * Extiende la interfaz {@link JpaRepository} para heredar operaciones CRUD estándar de Spring Data JPA.
 *
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @see org.springframework.data.jpa.repository.Query
 * @see Hotel
 *
 * @author Fernando Perez de Ayala Blazquez
 */
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // Consultas simples tipo GET
    /**
     * Obtiene un hotel por su identificador único.
     *
     * @param id Identificador único del hotel.
     * @return El hotel con el identificador proporcionado.
     */
    Hotel getHotelById(Long id);

    /**
     * Obtiene un hotel por su nombre.
     *
     * @param nombre Nombre del hotel.
     * @return El hotel con el nombre proporcionado.
     */
    Hotel getHotelByNombre(String nombre);

    /**
     * Obtiene una lista de hoteles con la puntuación dada.
     *
     * @param puntuacion Puntuación de los hoteles a buscar.
     * @return Lista de hoteles con la puntuación proporcionada.
     */
    List<Hotel> getHotelesByPuntuacion(Integer puntuacion);

    /**
     * Obtiene un hotel por su ubicación.
     *
     * @param ubicacion Ubicación del hotel.
     * @return El hotel en la ubicación proporcionada.
     */
    Hotel getHotelByUbicacion(String ubicacion);


    /**
     * Obtiene una lista de hoteles con la barra libre especificada.
     *
     * @param barra Indica si el hotel tiene menú.
     * @return Lista de hoteles con la opción de menú proporcionada.
     */
    List<Hotel> getHotelesByBarra(Boolean barra);


    /**
     * Obtiene una lista de hoteles con el precio igual al proporcionado.
     *
     * @param precio Precio de los hoteles a buscar.
     * @return Lista de hoteles con el precio proporcionado.
     */
    List<Hotel> getHotelesByPrecio(Double precio);


    /**
     * Obtiene una lista de nombres de todos los hoteles.
     *
     * @return Lista de nombres de hoteles.
     */
    @Query("SELECT r.nombre FROM Hotel r")
    List<String> nombreHoteles();

    /**
     * Obtiene la cantidad total de hoteles en la API.
     *
     * @return Cantidad total de hoteles.
     */
    @Query("SELECT count(r) FROM Hotel r")
    Integer cantidadDeHoteles();

    /**
     * Obtiene una lista de hoteles con una puntuación igual o mayor a la proporcionada.
     *
     * @param puntuacion Puntuación mínima de los hoteles a buscar.
     * @return Lista de hoteles con una puntuación igual o mayor a la proporcionada.
     */
    @Query("SELECT r FROM Hotel r WHERE r.puntuacion >= :puntuacion")
    List<Hotel> getHotelesConPuntuacionMayorOIgual(Integer puntuacion);

    /**
     * Obtiene una lista de hoteles con un precio máximo indicado.
     *
     * @param precioMedio Precio máximo de los hoteles a buscar.
     * @return Lista de hoteles con un precio máximo indicado.
     */
    @Query("SELECT r FROM Hotel  r WHERE r.precio <= :precioMedio")
    List<Hotel> hotelesPorPrecioMaximo(Double precioMedio);

    /**
     * Obtiene una lista de hoteles con un precio mínimo indicado.
     *
     * @param precioMedio Precio mínimo de los hoteles a buscar.
     * @return Lista de hoteles con un precio mínimo indicado.
     */
    @Query("SELECT r FROM Hotel  r WHERE r.precio >= :precioMedio")
    List<Hotel> hotelesPorPrecioMinimo(Double precioMedio);

    List<Hotel> findByNombre(String nombre);
}
