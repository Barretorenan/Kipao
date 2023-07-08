package com.example.kipao.controller;

import com.example.kipao.model.ItemModel;
import com.example.kipao.repository.ItensRepository;
import com.example.kipao.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ItensRepository itensRepository;
    private final ProductService productService;

    public ProductController(ItensRepository itensRepository, ProductService productService) {
        this.itensRepository = itensRepository;
        this.productService = productService;
    }

    @PostMapping("/adicionar-produto")
    public ItemModel adicionarProduto(@RequestBody ItemModel itemModel) {
        // Lógica para adicionar um novo produto
        return productService.criarProduto(itemModel);
    }

    @DeleteMapping("/remover-produto/{id}")
    public ItemModel removerProduto(@PathVariable Integer id) {
        // Lógica para remover um produto pelo ID
        return productService.removerProduto(id);
    }

    @PutMapping("/atualizar-produto/{id}")
    public ItemModel atualizarProduto(@PathVariable Integer id, @RequestBody ItemModel itemModel) {
        // Lógica para atualizar um produto pelo ID
        return productService.alterarProduto(id, itemModel);
    }

    @GetMapping("/listar-produtos")
    public List<ItemModel> listarProdutos() {
        // Retorna a lista de produtos
        return itensRepository.findAll();/**/
    }
}