package com.example.echo;

//import com.example.echo.Repository.ItensRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
//public class KipaoApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(KipaoApplication.class, args);
//    }
//
//    public String helloWorld() {
//        return "Hello, World!";
//    }
//
//}


//caso 1
@RestController
class AuthController {


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
class UserCredentials {

    private String username;
    private String password;

    // Getters e Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
//caso 2


@RestController
class DeliveryController {

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
class Endereco {

    private String logradouro;
    private String numero;
    private String cidade;
    // Outros atributos do endereço

    // Getters e Setters
}

//caso 3

@RestController
class UserController {

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
class Usuario {

    private String nome;
    private String email;
    // Outros atributos do usuário

    // Getters e Setters
}

//caso 4


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

class PlanoAssinatura {

    private String nomePlano;
    // Outros atributos do plano de assinatura

    // Getters e Setters
}
// Caso 5

@RestController
class GroceryController {

    @PostMapping("/realizar-compra")
    public String realizarCompra(@RequestBody CarrinhoCompra carrinho) {
        // Lógica para realizar a compra na mercearia
        double valorTotal = calcularValorTotal(carrinho);
        return "Compra realizada com sucesso! Valor total: R$" + valorTotal;
    }

    private double calcularValorTotal(CarrinhoCompra carrinho) {
        // Lógica para calcular o valor total da compra (exemplo simplificado)
        double valorTotal = 0.0;
        for (ItemCompra item : carrinho.getItens()) {
            valorTotal += item.getPreco() * item.getQuantidade();
        }
        return valorTotal;
    }
}


class CarrinhoCompra {

    public List<ItemCompra> getItens() {
        return itens;
    }

    public void setItens(List<ItemCompra> itens) {
        this.itens = itens;
    }

    private List<ItemCompra> itens;

    // Getters e Setters
}
class ItemCompra {

    private String nome;
    private double preco;
    private int quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Getters e Setters
}
//caso 6



@RestController
class ProductController {
//    private final ItensRepository itensRepository;

    private List<Product> products = new ArrayList<>();

//    public ProductController(ItensRepository itensRepository) {
//        this.itensRepository = itensRepository;
//    }

    @PostMapping("/adicionar-produto")
    public String adicionarProduto(@RequestBody Product product) {
        // Lógica para adicionar um novo produto
        products.add(product);
        return "Produto adicionado com sucesso!";
    }

    @DeleteMapping("/remover-produto/{id}")
    public String removerProduto(@PathVariable int id) {
        // Lógica para remover um produto pelo ID
        if (id >= 0 && id < products.size()) {
            products.remove(id);
            return "Produto removido com sucesso!";
        }
        return "Produto não encontrado!";
    }

    @PutMapping("/atualizar-produto/{id}")
    public String atualizarProduto(@PathVariable int id, @RequestBody Product product) {
        // Lógica para atualizar um produto pelo ID
        if (id >= 0 && id < products.size()) {
            products.set(id, product);
            return "Produto atualizado com sucesso!";
        }
        return "Produto não encontrado!";
    }

    @GetMapping("/listar-produtos")
    public List<ItensModel> listarProdutos() {
        // Retorna a lista de produtos
//        return itensRepository.findAll();/**/
        return null;
    }
}
class Product {

    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private String tipo;

    // Getters e Setters
}

//caso 7

@RestController
class PedidoController2 {

    private List<Pedido2> pedido2s = new ArrayList<>();

    @PutMapping("/atualizar-pedido/{id}")
    public String atualizarPedido(@PathVariable int id, @RequestBody PedidoStatus status) {
        // Lógica para atualizar o status de um pedido pelo ID
        if (id >= 0 && id < pedido2s.size()) {
            Pedido2 pedido2 = pedido2s.get(id);
            pedido2.setStatus(status);
            return "Status do pedido atualizado com sucesso!";
        }
        return "Pedido não encontrado!";
    }

    @DeleteMapping("/finalizar-pedido/{id}")
    public String finalizarPedido(@PathVariable int id) {
        // Lógica para finalizar um pedido pelo ID
        if (id >= 0 && id < pedido2s.size()) {
            Pedido2 pedido2 = pedido2s.get(id);
            pedido2.setStatus(PedidoStatus.FINALIZADO);
            return "Pedido finalizado com sucesso!";
        }
        return "Pedido não encontrado!";
    }

    @GetMapping("/listar-pedidos")
    public List<Pedido2> listarPedidos() {
        // Retorna a lista de pedidos
        return pedido2s;
    }
}
class PedidoS {

    private int id;
    private String descricao;
    private PedidoStatus status;

    // Getters e Setters
}
enum PedidoStatus {
    PREPARANDO,
    SAIU_PARA_ENTREGA,
    FINALIZADO
}
//Caso 8

@RestController
class HistoricoController {

    private List<Pedido2> historicoPedido2s = new ArrayList<>();

    @GetMapping("/historico-pedidos/{clienteId}")
    public List<Pedido2> exibirHistoricoPedidos(@PathVariable int clienteId) {
        // Lógica para recuperar o histórico de pedidos de um cliente pelo ID
        List<Pedido2> historicoCliente = new ArrayList<>();
        for (Pedido2 pedido2 : historicoPedido2s) {
            if (pedido2.getClienteId() == clienteId) {
                historicoCliente.add(pedido2);
            }
        }
        return historicoCliente;
    }
}
class Pedido2 {

    private int id;
    private int clienteId;
    private String descricao;
    private double valorTotal;
    private PedidoStatus status;
    private Boolean agendado;
    private Boolean CriarEventoAgenda;

    private Boolean EncomendadarBolo;
    private Double PrecoTotal;
    private LocalDate DataEntrega;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }

    public Boolean getAgendado() {
        return agendado;
    }

    public void setAgendado(Boolean agendado) {
        this.agendado = agendado;
    }

    public Boolean getCriarEventoAgenda() {
        return CriarEventoAgenda;
    }

    public void setCriarEventoAgenda(Boolean criarEventoAgenda) {
        CriarEventoAgenda = criarEventoAgenda;
    }

    public Boolean getEncomendadarBolo() {
        return EncomendadarBolo;
    }

    public void setEncomendadarBolo(Boolean EncomendadarBolo) {
        EncomendadarBolo = EncomendadarBolo;
    }

    public Double getPrecoTotal() {
        return PrecoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        PrecoTotal = precoTotal;
    }

    public LocalDate getDataEntrega() {
        return DataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        DataEntrega = dataEntrega;
    }

    public boolean GetEncomendarBolo() {
        return EncomendadarBolo;
    }

    // Getters e Setters
}
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
class Pedido3 {

    private int id;
    private int clienteId;
    private String descricao;
    private boolean agendado;
    private boolean criarEventoAgenda;

    // Getters e Setters
}
//Caso 10

@RestController
class PedidoController {

    @PostMapping("/pedidos")
    public String criarPedido(@RequestBody Pedido2 pedido2) {
        // Lógica para criar um novo pedido no sistema
        // ...

        if (pedido2.GetEncomendarBolo()) {
            // Verifica se o pedido é para encomendar um bolo personalizado
            encomendarBolo(pedido2);
        }

        return "Pedido criado com sucesso!";
    }

    private void encomendarBolo(Pedido2 pedido2) {
        // Lógica para encomendar um bolo personalizado
        // Pode envolver o cálculo do preço total, confirmação do pedido, etc.
        // ...

        // Exemplo de código para mostrar o preço total e a data/horário da entrega
        System.out.println("Preço Total: " + pedido2.getPrecoTotal());
        System.out.println("Data de Entrega: " + pedido2.getDataEntrega());
    }
}
class Pedido {

    private int id;
    private int clienteId;
    private String descricao;
    private boolean encomendarBolo;
    private String cobertura;
    private String recheio;
    private String massa;
    private double precoTotal;
    private String dataEntrega;

    // Getters e Setters
}

//Caso 11

