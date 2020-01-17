package com.teste.elotech.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.elotech.model.Pessoa;
import com.teste.elotech.repository.PessoaRepository;
import com.teste.elotech.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public List<Pessoa> listar(){
		return pessoaRepository.findAll();
	}
	
	@Override
	public Pessoa buscarPorCodigo(Long codigo) {
		return pessoaRepository.findById(codigo).get();
	}
	
	@Override
	public Pessoa salvar (Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@Override
	public void excluir (Long codigo) {
		pessoaRepository.deleteById(codigo);
	}
}
