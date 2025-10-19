package com.user_service.user_service.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera automáticamente getters, setters, toString, etc.
@AllArgsConstructor // Genera un constructor con todos los argumentos
@NoArgsConstructor // Genera un constructor vacío
public class User {
    private String username;
    private String password;
    private String nombre;
    private String pedidoFavorito;
}
