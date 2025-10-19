package com.user_service.user_service.controller;
import com.user_service.user_service.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    // Cuando alguien haga una petición GET a /users, se ejecutará este método
    @GetMapping
    public List<User> getAllUsers() {
        // Creamos una lista de usuarios de prueba en el momento
        return List.of(
            new User("jperez", "pass123", "Juan Pérez", "Hamburguesa Doble"),
            new User("amartinez", "clave456", "Ana Martínez", "Pizza Pepperoni"),
            new User("clopez", "seguro789", "Carlos López", "Alitas BBQ")
        );
    }
}