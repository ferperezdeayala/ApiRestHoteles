package com.example.apiresthoteles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Controlador que gestiona las operaciones relacionadas con los hoteles en la API.
 *
 * @author Fernando Pérez de Ayala Blázquez
 */
@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelRepository repository;

    @Autowired
    private SecurityService security;

    /**
     * Obtiene la lista de todos los hoteles.
     *
     * @return Lista de todos los hoteles.
     */
    @GetMapping("/")
    public List<Hotel> getAll() {
        return repository.findAll();
    }

    /**
     * Obtiene un hotel por su identificador único.
     *
     * @param id Identificador único del hotel.
     * @return El hotel con el identificador proporcionado.
     */
    @GetMapping("/id/{id}")
    public Hotel getHotelPorId(@PathVariable Long id) {
        return repository.getHotelById(id);
    }

    /**
     * Obtiene un hotel por su nombre.
     *
     * @param nombre Nombre del hotel.
     * @return El hotel con el nombre proporcionado.
     */
    @GetMapping("/nombre/{nombre}")
    public Hotel getHotelPorNombre(@PathVariable String nombre) {
        return repository.getHotelByNombre(nombre);
    }

    /**
     * Obtiene una lista de hoteles con la puntuación dada.
     *
     * @param puntuacion Puntuación de los hoteles a buscar.
     * @return Lista de hoteles con la puntuación proporcionada.
     */
    @GetMapping("/puntuacion/{puntuacion}")
    public List<Hotel> getHotelesPorPuntuacion(@PathVariable Integer puntuacion) {
        return repository.getHotelesByPuntuacion(puntuacion);
    }

    /**
     * Obtiene un hotel por su ubicación.
     *
     * @param ubicacion Ubicación del hotel.
     * @return El hotel en la ubicación proporcionada.
     */
    @GetMapping("/ubicacion/{ubicacion}")
    public Hotel getHotelPorUbicacion(@PathVariable String ubicacion) {
        return repository.getHotelByUbicacion(ubicacion);
    }

    @GetMapping("/barraLibre/{barraLibreBebida}")
    public List<Hotel> getHotelesPorBarraLibre(@PathVariable Boolean barraLibreBebida) {
        return repository.getHotelesByBarra(barraLibreBebida);
    }


    /**
     * Obtiene una lista de hoteles con el precio medio indicado.
     *
     * @param precioMedio Precio medio de los hoteles a buscar.
     * @return Lista de hoteles con el precio medio proporcionado.
     */
    @GetMapping("/precioMedio/{precioMedio}")
    public List<Hotel> getHotelesPorPrecioMedio(@PathVariable Double precioMedio) {
        return repository.getHotelesByPrecio(precioMedio);
    }

    /**
     * Obtiene una lista con los nombres de todos los hoteles.
     *
     * @return Lista de nombres de hoteles.
     */
    @GetMapping("/listaNombres")
    public List<String> getListaNombres() {
        return repository.nombreHoteles();
    }

    /**
     * Obtiene la cantidad total de hoteles en la API.
     *
     * @return Cantidad total de hoteles.
     */
    @GetMapping("/cantidad")
    public Integer getNumeroHoteles() {
        return repository.cantidadDeHoteles();
    }

    /**
     * Obtiene una lista de hoteles con una puntuación igual o mayor a la indicada.
     *
     * @param puntuacionMinima Puntuación mínima de los hoteles a buscar.
     * @return Lista de hoteles con una puntuación igual o mayor a la indicada.
     */
    @GetMapping("/puntuacionMinima/{puntuacionMinima}")
    public List<Hotel> getHotelesPuntuacionMinima(@PathVariable Integer puntuacionMinima) {
        return repository.getHotelesConPuntuacionMayorOIgual(puntuacionMinima);
    }

    /**
     * Obtiene una lista de hoteles con un precio máximo indicado.
     *
     * @param precioMax Precio máximo de los hoteles a buscar.
     * @return Lista de hoteles con un precio máximo indicado.
     */
    @GetMapping("/precioMaximo/{precioMax}")
    public List<Hotel> getHotelesPrecioMaximo(@PathVariable Double precioMax) {
        return repository.hotelesPorPrecioMaximo(precioMax);
    }

    /**
     * Obtiene una lista de hoteles con un precio mínimo indicado.
     *
     * @param precioMin Precio mínimo de los hoteles a buscar.
     * @return Lista de hoteles con un precio mínimo indicado.
     */
    @GetMapping("/precioMinimo/{precioMin}")
    public List<Hotel> getHotelesPrecioMinimo(@PathVariable Double precioMin) {
        return repository.hotelesPorPrecioMinimo(precioMin);
    }

    /**
     * Crea un nuevo hotel y lo guarda en la base de datos.
     *
     * @param hotel El nuevo hotel a ser creado y guardado.
     * @param token       El token de seguridad para autorizar la operación.
     * @return ResponseEntity con el hotel creado y el código de estado correspondiente.
     */
    @PostMapping("/post")
    public ResponseEntity<Hotel> nuevo(@RequestBody Hotel hotel, @RequestParam String token) {
        if (security.validateToken(token)) {
            return new ResponseEntity<>(repository.save(hotel), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Actualiza la información de un hotel existente.
     *
     * @param id              Identificador único del hotel a actualizar.
     * @param hotelNuevo La nueva información del hotel.
     * @param token           El token de seguridad para autorizar la operación.
     * @return ResponseEntity con el hotel actualizado y el código de estado correspondiente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> put(@PathVariable Long id, @RequestBody Hotel hotelNuevo, @RequestParam String token) {
        if (!security.validateToken(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            var hotel = new Hotel();
            var hotelSeleccionado = repository.findById(id);

            if (hotelSeleccionado.isEmpty()) {
                hotel = hotelNuevo;
            } else {
                hotel = hotelSeleccionado.get();
                hotel.setNombre(hotelNuevo.getNombre());
                hotel.setPuntuacion(hotelNuevo.getPuntuacion());
                hotel.setUbicacion(hotelNuevo.getUbicacion());
                hotel.setBarra(hotelNuevo.getBarra());
                hotel.setPrecio(hotelNuevo.getPrecio());
            }

            return new ResponseEntity<>(repository.save(hotel), HttpStatus.OK);
        }
    }

    /**
     * Elimina un hotel por su identificador único.
     *
     * @param id    Identificador único del hotel a eliminar.
     * @param token El token de seguridad para autorizar la operación.
     * @return ResponseEntity con el hotel eliminado y el código de estado correspondiente.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Hotel> delete(@PathVariable Long id, @RequestParam String token) {
        ResponseEntity<Hotel> response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        if (security.validateToken(token)) {
            Hotel salida = new Hotel();
            if (repository.existsById(id)) {
                salida = repository.findById(id).get();
                repository.deleteById(id);
                response = new ResponseEntity<>(salida, HttpStatus.OK);
            } else {
                response = new ResponseEntity<>(salida, HttpStatus.NOT_FOUND);
            }
        }

        return response;
    }
}
