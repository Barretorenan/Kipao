package com.example.kipao.controller;

import com.example.kipao.model.Endereco;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {

    @PostMapping("/calcular-entrega")
    public String calcularEntrega(@RequestBody Endereco endereco) {
        // Lógica para calcular a distância da padaria até o endereço de entrega
        double distancia = calcularDistancia(endereco);

        if (distancia <= 10.0) { // Defina o valor de alcance de entrega adequado
            return "Endereço está no alcance de entrega!";
        } else {
            return "Endereço está fora do alcance de entrega!";
        }
    }

    private double calcularDistancia(Endereco endereco) {
        // Lógica para calcular a distância da padaria até o endereço de entrega (exemplo simplificado)
        // Aqui você pode usar uma API de geolocalização para calcular a distância real
        // Neste exemplo, usaremos uma distância fixa de 5 km para demonstração
        return 5.0;
    }
}
