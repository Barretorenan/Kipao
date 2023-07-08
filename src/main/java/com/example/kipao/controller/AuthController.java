package com.example.kipao.controller;

import com.example.kipao.model.UserCredentials;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @PostMapping("/login")
    public String login(@RequestBody UserCredentials credentials) {
        // Lógica de validação dos dados do usuário
        if (isValidCredentials(credentials)) {
            return "Usuário autenticado!";
        } else {
            return "Dados de login inválidos!";
        }
    }

    private boolean isValidCredentials(UserCredentials credentials) {
        // Lógica de validação dos dados do usuário (exemplo simplificado)
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        // Aqui você pode implementar a lógica de validação adequada, como verificar no banco de dados
        return "admin".equals(username) && "senha123".equals(password);
    }
}