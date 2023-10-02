package com.example.simulado.service;

import com.example.simulado.entity.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private List<Produto> produtos;

    public ProdutoService() {
        produtos = new ArrayList<>();
    }

    public List<Produto> procurarProdutos(){
        return produtos;
    }

    public Produto criarProduto(Produto produto) throws Exception {
        if(produto.getNomeProduto().length() < 5)
            throw new Exception("Nome do produto precisa ter pelo menos 5 caracteres");
        produtos.add(produto);
        return produto;
    }

    public Produto procurarProduto(Long codigo) throws Exception{
        Optional<Produto> produto = produtos.stream().filter(e -> e.getCodigo() == codigo).findFirst();
        if(produto.isPresent()){
            return produto.get();
        } else {
            throw new Exception("Produto não encontrado!");
        }
    }



}
