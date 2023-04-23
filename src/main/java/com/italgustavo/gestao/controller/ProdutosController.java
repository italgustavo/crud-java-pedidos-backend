package com.italgustavo.gestao.controller;

import com.italgustavo.gestao.model.Produtos;
import com.italgustavo.gestao.repository.ProdutosRepository;
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
public class ProdutosController {

    @Autowired
    ProdutosRepository produtosRepository;

    @GetMapping("/produtos")
    public ResponseEntity<List<Produtos>> getAllProdutos(@RequestParam(required = false) String nomeProduto) {
        try {
            List<Produtos> produtos = new ArrayList<Produtos>();

            if (nomeProduto == null)
                produtosRepository.findAll().forEach(produtos::add);
            else
                produtosRepository.findByNameContaining(nomeProduto).forEach(produtos::add);

            if (produtos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produtos> getProdutosById(@PathVariable("id") long id) {
        Optional<Produtos> produtosData = produtosRepository.findById(id);

        if (produtosData.isPresent()) {
            return new ResponseEntity<>(produtosData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produtos> createProdutos(@RequestBody Produtos produtos) {
        try {
            Produtos _produtos = produtosRepository
                    .save(new Produtos(produtos.getName(), produtos.getDescription(), produtos.getPrice()));
            return new ResponseEntity<>(_produtos, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produtos> updateProdutos(@PathVariable("id") long id, @RequestBody Produtos produtos) {
        Optional<Produtos> pedidosData = produtosRepository.findById(id);

        if (pedidosData.isPresent()) {
            Produtos _produtos = pedidosData.get();
            _produtos.setName(produtos.getName());
            _produtos.setDescription(produtos.getDescription());
            _produtos.setPrice(produtos.getPrice());
            return new ResponseEntity<>(produtosRepository.save(_produtos), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<HttpStatus> deleteProdutos(@PathVariable("id") long id) {
        try {
            produtosRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/produtos")
    public ResponseEntity<HttpStatus> deleteAllProdutos() {
        try {
            produtosRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
