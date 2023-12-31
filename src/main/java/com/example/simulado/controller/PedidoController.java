package com.example.simulado.controller;

import com.example.simulado.entity.Pedido;
import com.example.simulado.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulado/pedido")
public class PedidoController {

    final PedidoService pedidoService;
    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @PostMapping("/add_pedido")
    public ResponseEntity<?> adicionarPedido(@RequestBody Pedido pedido){
        try {
            List<Pedido> list = pedidoService.criarPedido(pedido);
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("procurar_pedidos")
    public ResponseEntity<?> procurarPedidos(){
        try {
            List<Pedido> list = pedidoService.procurarPedidos();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    /*@GetMapping("/pedido/{idPedido}")
    public ResponseEntity<?> pesquisarPedido(@PathVariable("idPedido") int idPedido){
        try {

        }
    }*/




}
