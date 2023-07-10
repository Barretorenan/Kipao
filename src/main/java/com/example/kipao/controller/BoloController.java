package com.example.kipao.controller;

import com.example.kipao.model.Bolo;
import com.example.kipao.repository.BoloRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoloController {

    private final BoloRepository boloRepository;

    public BoloController(BoloRepository boloRepository){
        this.boloRepository = boloRepository;
    }

    @GetMapping("/recuperar-bolos")
    public List<Bolo> recuperarBolos(){
        return boloRepository.findAll();
    }

    @GetMapping("/recupera-bolo/{id}")
    public Bolo recuperarBolos(@PathVariable int id){
        return boloRepository.findById(id).get();
    }

    @PostMapping("/criar-bolo")
    public Bolo criarBolo(@RequestBody Bolo bolo){
        return boloRepository.save(bolo);
    }

    @PutMapping("/alterar-bolo/{id}")
    public Bolo alterarBolo(@PathVariable int id, @RequestBody Bolo bolo){
        Bolo boloRecuperado = boloRepository.findById(id).get();

        boloRecuperado.setCobertura(bolo.getCobertura());
        boloRecuperado.setMassa(bolo.getMassa());
        boloRecuperado.setRecheio(bolo.getRecheio());

        return boloRepository.save(boloRecuperado);
    }
}
