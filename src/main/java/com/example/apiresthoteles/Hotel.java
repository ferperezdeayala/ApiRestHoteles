package com.example.apiresthoteles;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase que representa un hotel en el sistema.
 *
 *
 * @author Fernando Perez de Ayala Blazquez
 */
@Data
@Entity
@Table(name = "hoteles")
public class Hotel {
    /**
     * Identificador del hotel.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del hotel.
     */
    private String nombre;

    /**
     * Puntuación del hotel (1 a 5).
     */
    private Integer puntuacion;

    /**
     * Ubicación del hotel.
     */
    private String ubicacion;


    /**
     * Indica si el hotel tiene barra libre.
     */
    private Boolean barra;


    /**
     * Media de precio del hotel.
     */
    private Double precio;
}

