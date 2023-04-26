package com.italgustavo.gestao.controller;

import com.italgustavo.gestao.model.Pedidos;
import com.italgustavo.gestao.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PedidosControllers {

    @Autowired
    PedidosRepository pedidosRepository;

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedidos>> getAllPedidos(@RequestParam(required = false) String title) {
        try {
            List<Pedidos> pedidos = new ArrayList<Pedidos>();

            if (title == null)
                pedidosRepository.findAll().forEach(pedidos::add);
            else
                pedidosRepository.findByTitleContaining(title).forEach(pedidos::add);

            if (pedidos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pedidos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Pedidos> getPedidosById(@PathVariable("id") long id) {
        Optional<Pedidos> pedidosData = pedidosRepository.findById(id);

        if (pedidosData.isPresent()) {
            return new ResponseEntity<>(pedidosData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Pedidos> createPedidos(@RequestBody Pedidos pedidos) {
        try {
            Pedidos _pedidos = pedidosRepository
                    .save(new Pedidos(pedidos.getTitle(), pedidos.getDescription(), false, pedidos.getProdutosPedidos()));
            return new ResponseEntity<>(_pedidos, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pedidos/{id}")
    public ResponseEntity<Pedidos> updatePedidos(@PathVariable("id") long id, @RequestBody Pedidos pedidos) {
        Optional<Pedidos> pedidosData = pedidosRepository.findById(id);

        if (pedidosData.isPresent()) {
            Pedidos _pedidos = pedidosData.get();
            _pedidos.setTitle(pedidos.getTitle());
            _pedidos.setDescription(pedidos.getDescription());
            _pedidos.setPublished(pedidos.isPublished());
            _pedidos.setProdutosPedidos(pedidos.getProdutosPedidos());
            return new ResponseEntity<>(pedidosRepository.save(_pedidos), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deletePedidos(@PathVariable("id") long id) {
        try {
            pedidosRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/pedidos")
    public ResponseEntity<HttpStatus> deleteAllPedidos() {
        try {
            pedidosRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/pedidos/published")
    public ResponseEntity<List<Pedidos>> findByPublished() {
        try {
            List<Pedidos> pedidos = pedidosRepository.findByPublished(true);

            if (pedidos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pedidos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
