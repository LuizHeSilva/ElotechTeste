package com.teste.elotech;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.teste.elotech.model.Pessoa;
import com.teste.elotech.repository.PessoaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PessoaRepositoryTest {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void inserirPessoa(){
		Pessoa pessoa = new Pessoa(1L, "João", "012.345.678-10");
		this.pessoaRepository.save(pessoa);
		Assertions.assertThat(pessoa.getCodigo()).isNotNull();
		Assertions.assertThat(pessoa.getNome()).isEqualTo("João");
		Assertions.assertThat(pessoa.getCpf()).isEqualTo("012.345.678-10");
	}
	
	@Test
	public void removerPessoa(){
		Pessoa pessoa = new Pessoa(1L, "João", "012.345.678-10");
		this.pessoaRepository.save(pessoa);
		System.out.println("------------------------------");
		System.out.println(pessoa.getCodigo());
		System.out.println("------------------------------");
		this.pessoaRepository.deleteById(1L);
 		Assertions.assertThat(this.pessoaRepository.findAll().isEmpty());
	}
	
	@Test
	public void alterarAndSalvarPessoa(){
		Pessoa pessoa = new Pessoa(1L, "João", "012.345.678-10");
		this.pessoaRepository.save(pessoa);
		pessoa.setNome("Pedro");
		pessoa.setCpf("012.345.678-11");
		pessoa = this.pessoaRepository.save(pessoa);
		Assertions.assertThat(pessoa.getNome()).isEqualTo("Pedro");
		Assertions.assertThat(pessoa.getCpf()).isEqualTo("012.345.678-11");
	}
	
	@Test
	public void buscarPessoa(){
		Pessoa pessoa = new Pessoa(1L, "João", "012.345.678-10");
		this.pessoaRepository.save(pessoa);
		List<Pessoa> pessoas = this.pessoaRepository.findAll();
		Assertions.assertThat(pessoas).isNotEmpty();
	}
	
	@Test
	public void buscarPessoaPorCodigo(){
		Pessoa pessoa = new Pessoa(1L, "João", "012.345.678-10");
		this.pessoaRepository.save(pessoa);
		Optional<Pessoa> pessoaRetorno = this.pessoaRepository.findById(pessoa.getCodigo());
		Assertions.assertThat(pessoaRetorno).isNotNull();
	}
	
}
