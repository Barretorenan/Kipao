package com.example.kipao.controller;

import com.example.kipao.model.Usuario;
import com.example.kipao.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UsuarioRepository usuarioRepository;

    UserController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/cadastro")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        // Lógica para armazenar os dados de cadastro do usuário
        return usuarioRepository.save(usuario);
    }

    @PostMapping("logar")
    public Integer logar(@RequestBody Usuario usuario){
        return usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha()).getId();
    }

    @PutMapping("/alterar-cadastro/{id}")
    public Usuario alterarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario usarioRecuperado = usuarioRepository.findById(id).get();
        usarioRecuperado.setEmail(usuario.getEmail());
        usarioRecuperado.setSenha(usuario.getSenha());
        return  usuarioRepository.save(usarioRecuperado);
    }
    @GetMapping("recuperar-usuario/{id}")
    public Usuario recuperarUsuario(@PathVariable Integer id) {
      return  usuarioRepository.findById(id).get();
    }

}