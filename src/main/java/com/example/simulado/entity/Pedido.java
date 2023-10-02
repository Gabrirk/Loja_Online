package com.example.simulado.entity;

import java.util.List;

public class Pedido {

    private int idPedido;
    private List<Produto> pedidoList;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public List<Produto> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Produto> pedidoList) {
        this.pedidoList = pedidoList;
    }





}
