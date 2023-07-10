package com.example.kipao.controller;

import com.example.kipao.model.Endereco;
import com.example.kipao.model.Usuario;
import com.example.kipao.repository.EnderecoRepository;
import com.example.kipao.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnderecoController {
    private final EnderecoRepository enderecoRepository;
    private final UsuarioRepository usuarioRepository;

    public EnderecoController(EnderecoRepository enderecoRepository, UsuarioRepository usuarioRepository){
        this.enderecoRepository = enderecoRepository;
        this.usuarioRepository = usuarioRepository;
    }
    @GetMapping("/enderecos")
    public List<Endereco> recuperarEnderecos(){
        return enderecoRepository.findAll();
    }

    @GetMapping("/enderecos/{id}")
    public Endereco recuperarEndereco(@PathVariable int id){
        return enderecoRepository.findById(id).get();
    }

    @PostMapping("/criar-endereco/{id}")
    public Endereco criarEndereco(@PathVariable int id, @RequestBody Endereco endereco){
        Usuario usuarioRecuperado = usuarioRepository.findById(id).get();
        endereco.setUsuario(usuarioRecuperado);
        return enderecoRepository.save(endereco);
    }

    @PutMapping("/enderecos-alterar/{id}")
    public Endereco alterarEndereco(@PathVariable int id, @RequestBody Endereco endereco){
        Endereco enderecoRecuperado = enderecoRepository.findById(id).get();

        enderecoRecuperado.setBairro(endereco.getBairro());
        enderecoRecuperado.setLogradouro(endereco.getLogradouro());
        enderecoRecuperado.setNumero(endereco.getNumero());

        return enderecoRepository.save(enderecoRecuperado);
    }
}
