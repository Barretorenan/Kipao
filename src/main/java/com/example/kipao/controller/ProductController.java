package com.example.kipao.controller;

import com.example.kipao.model.ItensModel;
import com.example.kipao.model.Product;
import com.example.kipao.repository.ItensRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private final ItensRepository itensRepository;

    private List<Product> products = new ArrayList<>();

    public ProductController(ItensRepository itensRepository) {
        this.itensRepository = itensRepository;
    }

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
        return itensRepository.findAll();/**/
    }
}