package com.example.kipao.repository;

import com.example.kipao.model.Pessoa;
import com.example.kipao.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    Pessoa findByUsuario(Usuario usuario);
}
