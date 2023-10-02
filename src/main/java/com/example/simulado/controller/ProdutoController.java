package com.example.simulado.controller;

import com.example.simulado.entity.Produto;
import com.example.simulado.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulado/produto")
public class ProdutoController {

    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping("procurar_produtos")
    public ResponseEntity<?> procurarProdutos(){
        try {
            List<Produto> list = produtoService.procurarProdutos();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>("Error", HttpStatus.BAD_GATEWAY);
        }
    }
    @PostMapping("add")
    public ResponseEntity<?> criarProduto(@RequestBody Produto produto){
        try {
            produto = produtoService.criarProduto(produto);
            return new ResponseEntity<>(produto, HttpStatus.CREATED);
        } catch (Exception ex){
            return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> procurarProduto(@PathVariable("codigo") Long codigo){
        try {
            Produto produto = produtoService.procurarProduto(codigo);
            return new ResponseEntity(produto, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }



}
