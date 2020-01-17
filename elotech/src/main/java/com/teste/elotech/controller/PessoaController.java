package com.teste.elotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.elotech.model.Pessoa;
import com.teste.elotech.service.serviceImpl.PessoaServiceImpl;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaServiceImpl pessoaService;
	
	@GetMapping("/listar")
	public List<Pessoa> listar(){
		return pessoaService.listar();
	}
	
	@PostMapping("/salvar")
	public Pessoa salvarPessoa(@RequestBody Pessoa pessoa){
		return pessoaService.salvar(pessoa);
	}
	
	@DeleteMapping("/excluir/{codigo}")
	public void excluirPessoa(@PathVariable Long codigo) {
		pessoaService.excluir(codigo);
	}
	
	@PutMapping("/alterar")
	public Pessoa alterarPessoa(@RequestBody Pessoa pessoa){
		return pessoaService.salvar(pessoa);
	}

}
