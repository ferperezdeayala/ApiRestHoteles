package com.example.apiresthoteles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Clase principal que inicia la aplicación Spring Boot para el sistema de gestión de hoteles.
 * Esta clase contiene el método principal {@link #main(String[])} que inicia la aplicación Spring Boot.
 *
 * @see org.springframework.boot.SpringApplication
 * @see org.springframework.boot.autoconfigure.SpringBootApplication
 *
 * @author Fernando Pérez de Ayala Blazquez
 */
@SpringBootApplication
public class ApiRestHotelesApplication {

    /**
     * Método principal que inicia la aplicación Spring Boot.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiRestHotelesApplication.class, args);
    }

}

