package com.example.kipao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KipaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KipaoApplication.class, args);
	}

	public String helloWorld() {
		return "Hello, World!";
	}

}
import org.springframework.web.bind.annotation.PostMapping;
		import org.springframework.web.bind.annotation.RequestBody;
		import org.springframework.web.bind.annotation.RestController;

		//caso 1
@RestController
public class AuthController {

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
public class UserCredentials {

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
public class Endereco {

	private String logradouro;
	private String numero;
	private String cidade;
	// Outros atributos do endereço

	// Getters e Setters
}

//caso 3
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
public class Usuario {

	private String nome;
	private String email;
	// Outros atributos do usuário

	// Getters e Setters
}

//caso 4

import org.springframework.web.bind.annotation.PostMapping;
		import org.springframework.web.bind.annotation.RequestBody;
		import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {

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

public class PlanoAssinatura {

	private String nomePlano;
	// Outros atributos do plano de assinatura

	// Getters e Setters
}
// Caso 5
import org.springframework.web.bind.annotation.PostMapping;
		import org.springframework.web.bind.annotation.RequestBody;
		import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroceryController {

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

import java.util.List;

public class CarrinhoCompra {

	private List<ItemCompra> itens;

	// Getters e Setters
}
public class ItemCompra {

	private String nome;
	private double preco;
	private int quantidade;

	// Getters e Setters
}
//caso 6

import org.springframework.web.bind.annotation.*;

		import java.util.ArrayList;
		import java.util.List;

@RestController
public class ProductController {

	private List<Product> products = new ArrayList<>();

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
	public List<Product> listarProdutos() {
		// Retorna a lista de produtos
		return products;
	}
}
public class Product {

	private int id;
	private String nome;
	private String descricao;
	private double preco;
	private String tipo;

	// Getters e Setters
}

//caso 7
import org.springframework.web.bind.annotation.*;

		import java.util.ArrayList;
		import java.util.List;

@RestController
public class PedidoController {

	private List<Pedido> pedidos = new ArrayList<>();

	@PutMapping("/atualizar-pedido/{id}")
	public String atualizarPedido(@PathVariable int id, @RequestBody PedidoStatus status) {
		// Lógica para atualizar o status de um pedido pelo ID
		if (id >= 0 && id < pedidos.size()) {
			Pedido pedido = pedidos.get(id);
			pedido.setStatus(status);
			return "Status do pedido atualizado com sucesso!";
		}
		return "Pedido não encontrado!";
	}

	@DeleteMapping("/finalizar-pedido/{id}")
	public String finalizarPedido(@PathVariable int id) {
		// Lógica para finalizar um pedido pelo ID
		if (id >= 0 && id < pedidos.size()) {
			Pedido pedido = pedidos.get(id);
			pedido.setStatus(PedidoStatus.FINALIZADO);
			return "Pedido finalizado com sucesso!";
		}
		return "Pedido não encontrado!";
	}

	@GetMapping("/listar-pedidos")
	public List<Pedido> listarPedidos() {
		// Retorna a lista de pedidos
		return pedidos;
	}
}
public class Pedido {

	private int id;
	private String descricao;
	private PedidoStatus status;

	// Getters e Setters
}
public enum PedidoStatus {
	PREPARANDO,
	SAIU_PARA_ENTREGA,
	FINALIZADO
}
//Caso 8
import org.springframework.web.bind.annotation.*;

		import java.util.ArrayList;
		import java.util.List;

@RestController
public class HistoricoController {

	private List<Pedido> historicoPedidos = new ArrayList<>();

	@GetMapping("/historico-pedidos/{clienteId}")
	public List<Pedido> exibirHistoricoPedidos(@PathVariable int clienteId) {
		// Lógica para recuperar o histórico de pedidos de um cliente pelo ID
		List<Pedido> historicoCliente = new ArrayList<>();
		for (Pedido pedido : historicoPedidos) {
			if (pedido.getClienteId() == clienteId) {
				historicoCliente.add(pedido);
			}
		}
		return historicoCliente;
	}
}
public class Pedido {

	private int id;
	private int clienteId;
	private String descricao;
	private double valorTotal;

	// Getters e Setters
}
//Caso 9
import org.springframework.web.bind.annotation.*;

@RestController
public class PedidoController {

	@PostMapping("/pedidos")
	public String criarPedido(@RequestBody Pedido pedido) {
		// Lógica para criar um novo pedido no sistema
		// ...

		if (pedido.isAgendado()) {
			// Verifica se o pedido é agendado
			if (pedido.isCriarEventoAgenda()) {
				// Verifica se o cliente deseja criar um evento na agenda
				criarEventoAgenda(pedido);
			}
		}

		return "Pedido criado com sucesso!";
	}

	private void criarEventoAgenda(Pedido pedido) {
		// Lógica para criar o evento na agenda do cliente
		// Utilize uma biblioteca externa ou serviço de calendário para realizar essa operação
		// Por exemplo, pode-se utilizar a API do Google Calendar ou o Calendário do Outlook
		// ...
		// Código para criar o evento na agenda
	}
}
public class Pedido {

	private int id;
	private int clienteId;
	private String descricao;
	private boolean agendado;
	private boolean criarEventoAgenda;

	// Getters e Setters
}
//Caso 10
import org.springframework.web.bind.annotation.*;

@RestController
public class PedidoController {

	@PostMapping("/pedidos")
	public String criarPedido(@RequestBody Pedido pedido) {
		// Lógica para criar um novo pedido no sistema
		// ...

		if (pedido.isEncomendarBolo()) {
			// Verifica se o pedido é para encomendar um bolo personalizado
			encomendarBolo(pedido);
		}

		return "Pedido criado com sucesso!";
	}

	private void encomendarBolo(Pedido pedido) {
		// Lógica para encomendar um bolo personalizado
		// Pode envolver o cálculo do preço total, confirmação do pedido, etc.
		// ...

		// Exemplo de código para mostrar o preço total e a data/horário da entrega
		System.out.println("Preço Total: " + pedido.getPrecoTotal());
		System.out.println("Data de Entrega: " + pedido.getDataEntrega());
	}
}
public class Pedido {

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






