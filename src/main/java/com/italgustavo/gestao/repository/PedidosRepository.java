package com.italgustavo.gestao.repository;

import com.italgustavo.gestao.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    List<Pedidos> findByPublished(boolean published);
    List<Pedidos> findByTitleContaining(String title);
}
