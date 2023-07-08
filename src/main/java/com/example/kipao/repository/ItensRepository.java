package com.example.kipao.repository;

import com.example.kipao.model.ItensModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensRepository extends JpaRepository<ItensModel, Integer> {
}
