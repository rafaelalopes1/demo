package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired 
	private ProdutoRepository produtoRepository;
	
	
	private final ProdutoService produtoService;
	
	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	
	
	@GetMapping
	public Produto listar() {
		return produtoService.returnId();
	}
	
	@PostMapping
	public void incluir(@RequestBody Produto produto) {
		System.out.print("teste  nome" + produto.getNome());
		produtoRepository.save(produto);
		
	}
	
	@PutMapping
	public void alterar(@RequestBody Produto produto) {
		produtoRepository.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}
}
