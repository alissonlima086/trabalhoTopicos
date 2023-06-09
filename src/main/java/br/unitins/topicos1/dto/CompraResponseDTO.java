package br.unitins.topicos1.dto;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unitins.topicos1.model.Compra;
import br.unitins.topicos1.model.ItemCompra;

public record CompraResponseDTO(
    Long id,
    double totalCompra,
    List<Map<String, Object>> listaDeItens
) {
    public CompraResponseDTO(Compra compra) {
        this(compra.getId(),compra.getTotalCompra(), vizualizarProdutos(compra.getListaDeItens()));
    }

    public static Map<String, Object> encontrarProduto(String nome, double valor, int quant) {

        Map<String, Object> produto = new HashMap<>();

        produto.put("nome", nome);
        produto.put("valor", valor);
        produto.put("quant", quant);

        return produto;
    }

    private static List<Map<String, Object>> vizualizarProdutos(List<ItemCompra> lista) {

        List<Map<String, Object>> listaProdutos = new ArrayList<>();

        for (ItemCompra produtos : lista) {

            Map<String, Object> produto = new HashMap<>();

            produto = encontrarProduto(produtos.getQuadrinho().getNome(), produtos.getQuadrinho().getPreco(), produtos.getQuant());

            listaProdutos.add(produto);
        }

        return listaProdutos;
    }
}