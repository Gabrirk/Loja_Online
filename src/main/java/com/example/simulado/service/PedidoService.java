package com.example.simulado.service;

import com.example.simulado.entity.Pedido;
import com.example.simulado.entity.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    /*aaa*/
    private List<Pedido> pedidos;

    public PedidoService() {
        pedidos = new ArrayList<>();
    }

    public List<Pedido> procurarPedidos(){
        return pedidos;
    }

    public List<Pedido> criarPedido(Pedido pedido){
        pedidos.add(pedido);
        return pedidos;
    }



}
