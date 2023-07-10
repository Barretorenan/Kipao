package com.example.kipao.repository;

import com.example.kipao.model.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Integer> {
    List<Assinatura> findAllByPedido_ClienteId(int id);
}
