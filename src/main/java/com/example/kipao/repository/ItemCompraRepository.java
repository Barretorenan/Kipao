package com.example.kipao.repository;

import com.example.kipao.model.ItemCompra;
import com.example.kipao.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCompraRepository extends JpaRepository<ItemCompra, Integer> {
    List<ItemCompra> findAllByPedido(Pedido Pedido);
}
