package com.example.kipao.controller;

import com.example.kipao.model.PlanoAssinatura;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SubscriptionController {

    @PostMapping("/assinar-plano")
    public String assinarPlano(@RequestBody PlanoAssinatura planoAssinatura) {
        // Lógica para adicionar o plano de assinatura em Minhas Assinaturas
        adicionarPlanoAssinatura(planoAssinatura);
        return "Assinatura realizada com sucesso!";
    }

    private void adicionarPlanoAssinatura(PlanoAssinatura planoAssinatura) {
        // Lógica para adicionar o plano de assinatura em algum repositório ou na conta do cliente (exemplo simplificado)
        // Neste exemplo, apenas exibimos os dados do plano no console
        System.out.println("Plano assinado: " + planoAssinatura);
    }
}