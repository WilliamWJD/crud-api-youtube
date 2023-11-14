package com.api.produtos.services;

import com.api.produtos.domain.Produto;

import java.util.List;

public interface ProdutoService {
    /**
     * Salvar produto.
     *
     * @param produto the produto
     * @return the produto
     */
    Produto salvar(Produto produto);

    /**
     * Buscar por id produto.
     *
     * @param id the id
     * @return the produto
     */
    Produto buscarPorId(final Long id);

    /**
     * Listar list.
     *
     * @return the list
     */
    List<Produto> listar();

    /**
     * Deletar.
     *
     * @param id the id
     */
    void deletar(final Long id);

    /**
     * Atualizar produto.
     *
     * @param id      the id
     * @param produto the produto
     * @return the produto
     */
    Produto atualizar(final Long id, Produto produto);
}
