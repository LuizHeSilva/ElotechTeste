package com.teste.elotech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teste.elotech.model.Pessoa;

@Service
public interface PessoaService {
	
	List<Pessoa> listar();
	Pessoa buscarPorCodigo(Long codigo);
	Pessoa salvar (Pessoa pessoa);
	void excluir (Long codigo);
}
