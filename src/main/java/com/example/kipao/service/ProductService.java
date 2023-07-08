package com.example.kipao.service;

import com.example.kipao.model.ItemModel;
import com.example.kipao.model.Product;
import com.example.kipao.repository.ItensRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ItensRepository itensRepository;

    ProductService(ItensRepository itensRepository) {
        this.itensRepository = itensRepository;
    }

    public ItemModel alterarProduto(Integer id, ItemModel produto) {
        ItemModel itemRecuperado = itensRepository.findById(id).get();
        itemRecuperado.setCategoria(produto.getCategoria());
        itemRecuperado.setDescricao(produto.getDescricao());
        itemRecuperado.setNome(produto.getNome());

        return itensRepository.save(itemRecuperado);
    }

    public ItemModel removerProduto(Integer id) {
        ItemModel itemRecuperado = itensRepository.findById(id).get();
        itensRepository.delete(itemRecuperado);
        return itemRecuperado;
    }

    public ItemModel criarProduto(ItemModel itemModel){
        return itensRepository.save(itemModel);
    }
}
