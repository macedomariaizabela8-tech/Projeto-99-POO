package com.app99;

import com.app99.model.*;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA APP 99 INICIADO ===\n");

        // 1. Criando Usuários
        Cliente cliente = new Cliente("C01", "Lucas Mendes", "lucas@email.com", "99999-1111", "Rua A, 123");
        Motorista motorista = new Motorista("M01", "Carlos Andrade", "carlos@email.com", "99999-2222", "123456789", "ABC-1234", "Toyota Sedan");
        Entregador entregador = new Entregador("E01", "Roberto Lima", "roberto@email.com", "99999-3333", "Moto");

        // 2. Simulando uma Corrida
        System.out.println("--- Criando Solicitacao de Corrida ---");
        Corrida corrida = new Corrida("CORR01", LocalDateTime.now(), "SOLICITADO", "Rua A, 123", "Av. Central, 1000", 12.5, 3.0, cliente, motorista);
        
        motorista.aceitarSolicitacao(corrida.getId());
        corrida.atualizarStatus("EM_ANDAMENTO");
        System.out.println("Valor total da corrida: R$ " + corrida.getValorTotal());
        motorista.concluirAtendimento(corrida.getId());
        corrida.atualizarStatus("CONCLUIDO");

        // 3. Simulando um Pedido de Delivery
        System.out.println("\n--- Criando Solicitacao de Delivery ---");
        Estabelecimento restaurante = new Estabelecimento("EST01", "Burger House", "Av. Brasil, 500");
        Produto burger = new Produto("P01", "X-Burguer", 25.0);
        Produto refri = new Produto("P02", "Refrigerante 350ml", 7.0);
        
        restaurante.adicionarProduto(burger);
        restaurante.adicionarProduto(refri);

        PedidoDelivery pedido = new PedidoDelivery("DELIV01", LocalDateTime.now(), "PENDENTE", cliente, restaurante, entregador, 8.0);
        pedido.adicionarItem(new ItemPedido(burger, 2));
        pedido.adicionarItem(new ItemPedido(refri, 1));

        entregador.aceitarSolicitacao(pedido.getId());
        System.out.println("Valor total do delivery: R$ " + pedido.getValorTotal());
        entregador.concluirAtendimento(pedido.getId());
        pedido.atualizarStatus("ENTREGUE");

        // 4. Criando uma Avaliação
        System.out.println("\n--- Registrando Avaliacao ---");
        Avaliacao avaliacao = new Avaliacao("AV01", corrida, cliente, 5, "Excelente motorista, muito seguro!");
        System.out.println("Cliente: " + avaliacao.getAvaliador().getNome());
        System.out.println("Nota: " + avaliacao.getNota() + " estrelas");
        System.out.println("Comentário: " + avaliacao.getComentario());
    }
}