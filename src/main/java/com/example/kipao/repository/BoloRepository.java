package com.example.kipao.repository;

import com.example.kipao.model.Bolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoloRepository extends JpaRepository<Bolo, Integer> {
}
