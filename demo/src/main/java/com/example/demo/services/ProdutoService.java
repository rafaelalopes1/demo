package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
@Service
public class ProdutoService {
	@Autowired
	public ProdutoRepository produtoRepository;
	
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	public Produto returnId() {
		List<Produto> produto = produtoRepository.findAll();
		for (Produto lista : produto) {
			if (lista.getId() == 1) {
				return lista;
			}
		}
		return null;
	}
}
