package com.example.kipao.controller;

import com.example.kipao.model.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/cadastro")
    public String cadastrarUsuario(@RequestBody Usuario usuario) {
        // Lógica para armazenar os dados de cadastro do usuário
        salvarUsuario(usuario);
        return "Novo usuário cadastrado!";
    }

    private void salvarUsuario(Usuario usuario) {
        // Lógica para salvar os dados do usuário em algum repositório (exemplo simplificado)
        // Neste exemplo, apenas exibimos os dados no console
        System.out.println("Usuário cadastrado: " + usuario);
    }
}