package com.example.kipao.repository;

import com.example.kipao.model.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssinaturaRepository extends JpaRepository<Assinatura, Integer> {
    List<Assinatura> findAllByPedido_ClienteId(int id);
}
