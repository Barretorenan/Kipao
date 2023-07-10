package com.example.kipao.controller;

import com.example.kipao.model.Pessoa;
import com.example.kipao.model.Usuario;
import com.example.kipao.repository.PessoaRepository;
import com.example.kipao.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaController {
    private final PessoaRepository pessoaRepository;
    private final UsuarioRepository usuarioRepository;

    public PessoaController(PessoaRepository pessoaRepository, UsuarioRepository usuarioRepository) {
        this.pessoaRepository = pessoaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/recuperar-pessoas")
    public List<Pessoa> adicionarProduto() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/recuperar-pessoa/usuario/{id}")
    public Pessoa adicionarProduto(@PathVariable int id) {
        Usuario usuarioRecuperado = usuarioRepository.findById(id).get();
        return pessoaRepository.findByUsuario(usuarioRecuperado);
    }

    @PutMapping("/recuperar-pessoa/usuario/{id}")
    public Pessoa adicionarProduto(@PathVariable int id, @RequestBody Pessoa pessoa) {
        Pessoa pessoaRecuperada = pessoaRepository.findById(id).get();

        pessoaRecuperada.setCelular(pessoa.getCelular());
        pessoaRecuperada.setNome(pessoa.getNome());

        return pessoaRepository.save(pessoaRecuperada);
    }

    @PostMapping("/criar-pessoa")
    public Pessoa adicionarPessoa( @RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
