package com.api.produtos.services.impl;

import com.api.produtos.domain.Produto;
import com.api.produtos.repositories.ProdutoRepository;
import com.api.produtos.services.ProdutoService;
import com.api.produtos.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(final ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado com o id: "+id));
    }

    @Override
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        buscarPorId(id);
        produtoRepository.deleteById(id);
    }

    @Override
    public Produto atualizar(Long id, Produto produto) {
        Produto prod = buscarPorId(id);
        produto.setId(prod.getId());
        return produtoRepository.save(produto);
    }
}
