package com.example.apiresthoteles;

import org.springframework.stereotype.Service;

/**
 * Servicio encargado de validar tokens de seguridad en la aplicación.
 *
 * <p>
 * Esta clase contiene el método {@link #validateToken(String)} que permite validar la autenticidad de un token.
 * </p>
 *
 * @see org.springframework.stereotype.Service
 *
 * @author Fernando Perez de Ayala Blazquez
 */
@Service
public class SecurityService {

    /**
     * Valida la autenticidad de un token.
     *
     * @param token El token a validar.
     * @return {@code true} si el token es válido, {@code false} si no lo es.
     */
    public Boolean validateToken(String token) {
        return (token.equals("t0k3n"));
    }
}
