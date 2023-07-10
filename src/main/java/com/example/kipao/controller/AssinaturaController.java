package com.example.kipao.controller;

import com.example.kipao.model.Assinatura;
import com.example.kipao.model.Pedido;
import com.example.kipao.repository.AssinaturaRepository;
import com.example.kipao.repository.PedidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class AssinaturaController {
    private final AssinaturaRepository assinaturaRepository;
    private final PedidoRepository pedidoRepository;

    public AssinaturaController(AssinaturaRepository assinaturaRepository, PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.assinaturaRepository = assinaturaRepository;
    }

    @GetMapping("/recuperar-assinaturas")
    public List<Assinatura> recuperarAssinaturas(){
     return  assinaturaRepository.findAll();
    }

    @GetMapping("/recuperar-assinaturas-usuario/{id}")
    public List<Assinatura> recuperarAssinaturasUsuario(@PathVariable int id){
     return  assinaturaRepository.findAllByPedido_ClienteId(id);
    }

    @PostMapping("/assinar-plano/{id}")
    public Assinatura assinarPlano(@RequestBody Assinatura assinatura, @PathVariable int id) {
        Pedido pedidorecuperado = pedidoRepository.findById(id).get();
        assinatura.setPedido(pedidorecuperado);
        return assinaturaRepository.save(assinatura);
    }

    @PutMapping("/alterar-assinatura/{id}")
    public Assinatura alterarAssinatura(@PathVariable int id, @RequestBody Assinatura assinatura){
        Assinatura assinaturaRecuperada = assinaturaRepository.findById(id).get();

        assinaturaRecuperada.setRecorrencia(assinatura.getRecorrencia());
        assinaturaRecuperada.setTipo(assinatura.getTipo());
        assinaturaRecuperada.setHorario(assinatura.getHorario());
        assinaturaRecuperada.setStatus(assinatura.getStatus());

        return assinaturaRepository.save(assinatura);
    }
}