package com.api.produtos.resources;

import com.api.produtos.domain.Produto;
import com.api.produtos.services.ProdutoService;
import com.api.produtos.services.impl.ProdutoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    private final ProdutoService produtoService;

    public ProdutoResource(final ProdutoServiceImpl produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.salvar(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        return ResponseEntity.ok(produtoService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable final Long id, @RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.atualizar(id, produto));
    }
}
