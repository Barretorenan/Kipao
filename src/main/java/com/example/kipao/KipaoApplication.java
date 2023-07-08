package com.example.kipao;

//import com.example.echo.Repository.ItensRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("com.*")
@ComponentScan(basePackages = { "com.*" })
@EntityScan("com.*")
public class KipaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KipaoApplication.class, args);
    }

    public String helloWorld() {
        return "Hello, World!";
    }

}


//caso 1


//caso 2





//caso 3




//caso 4





// Caso 5






//caso 6





//caso 7




//Caso 8



//Caso 9

//@RestController
// class PedidoController3 {
//
//    @PostMapping("/pedidos")
//    public String criarPedido(@RequestBody Pedido2 pedido2) {
//        // Lógica para criar um novo pedido no sistema
//        // ...
//
//        if (pedido2.getAgendado()) {
//            // Verifica se o pedido é agendado
//            if (pedido2.getCriarEventoAgenda()) {
//                // Verifica se o cliente deseja criar um evento na agenda
//                criarEventoAgenda(pedido2);
//            }
//        }
//
//        return "Pedido criado com sucesso!";
//    }
//
//    private void criarEventoAgenda(Pedido2 pedido2) {
//        // Lógica para criar o evento na agenda do cliente
//        // Utilize uma biblioteca externa ou serviço de calendário para realizar essa operação
//        // Por exemplo, pode-se utilizar a API do Google Calendar ou o Calendário do Outlook
//        // ...
//        // Código para criar o evento na agenda
//    }
//}

//Caso 10




//Caso 11

