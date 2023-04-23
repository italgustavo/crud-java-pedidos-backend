package com.italgustavo.gestao.repository;

import com.italgustavo.gestao.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
    List<Produtos> findByNameContaining(String name);
}
