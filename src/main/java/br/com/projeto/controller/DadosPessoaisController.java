package br.com.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.domain.Dadospessoais;
import br.com.projeto.repository.DadosPessoaisRepository;

@RestController
@RequestMapping("/dadospessoais")
public class DadosPessoaisController {
	@Autowired
	private DadosPessoaisRepository dpr;
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Dadospessoais dp) {
		dpr.save(dp);
		return "dados cadastrados";
	}
	@GetMapping("/listar")
	public List<Dadospessoais> listar(){
		return dpr.findAll();
	}
	@GetMapping("/consultar/{id}")
	public Optional<Dadospessoais> consultar(@PathVariable Integer id){
		return dpr.findById(id);
	}
	@GetMapping("/consultarcpf/{cpf}")
	public Optional<Dadospessoais> consultarcpf(@PathVariable String cpf) {
		return dpr.findByCpf(cpf);
	}
	@GetMapping("/consultaremail/{email}")
	public Optional<Dadospessoais> consultaremail(@PathVariable String email) {
		return dpr.findByEmail(email);
	}
	@PatchMapping("/alterarnome/{id}")
	public String alterarnome(@PathVariable Integer id,@RequestBody Dadospessoais dp) {
		Optional<Dadospessoais> pessoa = dpr.findById(id);
		if (!pessoa.isPresent()) {
			return "[{msg:'Não foi possível encontrar a pessoa']}";
		}
		dp.setIddadospessoais(id);
		dp.setCpf(pessoa.get().getCpf());
		dp.setEmail(pessoa.get().getEmail());
		dp.setEndereco(pessoa.get().getEndereco());
		dp.setIdusuario(pessoa.get().getIdusuario());
		dp.setTelefone(pessoa.get().getTelefone());
		dpr.save(dp);
		return "[{msg:'Nome Atualizado com sucesso'}]";
	}
	@PatchMapping("/alteraremail/{id}")
	public String alteraremail(@PathVariable Integer id,@RequestBody Dadospessoais dp) {
		Optional<Dadospessoais> email = dpr.findById(id);
		if (!email.isPresent()) {
			return "[{msg:'Não foi possível encontrar o email']}";
		}
		dp.setIddadospessoais(id);
		dp.setNomecompleto(email.get().getNomecompleto());
		dp.setCpf(email.get().getCpf());
		dp.setEndereco(email.get().getEndereco());
		dp.setIdusuario(email.get().getIdusuario());
		dp.setTelefone(email.get().getTelefone());
		dpr.save(dp);
		return "[{msg:'Email Atualizado com sucesso'}]";
	}
	@PatchMapping("/alterartelefone/{id}")
	public String alterartelefone(@PathVariable Integer id,@RequestBody Dadospessoais dp) {
		Optional<Dadospessoais> telefone = dpr.findById(id);
		if (!telefone.isPresent()) {
			return "[{msg:'Não foi possível encontrar o telefone']}";
		}
		dp.setIddadospessoais(id);
		dp.setNomecompleto(telefone.get().getNomecompleto());
		dp.setCpf(telefone.get().getCpf());
		dp.setEndereco(telefone.get().getEndereco());
		dp.setEmail(telefone.get().getEmail());
		dp.setIdusuario(telefone.get().getIdusuario());
		dpr.save(dp);
		return "[{msg:'telefone Atualizado com sucesso'}]";
	}
	@PatchMapping("/alterarendereco/{id}")
	public String alterarendereco(@PathVariable Integer id,@RequestBody Dadospessoais dp) {
		Optional<Dadospessoais> endereco = dpr.findById(id);
		if (!endereco.isPresent()) {
			return "[{msg:'Não foi possível encontrar o endereco']}";
		}
		dp.setIddadospessoais(id);
		dp.setNomecompleto(endereco.get().getNomecompleto());
		dp.setCpf(endereco.get().getCpf());
		dp.setEmail(endereco.get().getEmail());
		dp.setTelefone(endereco.get().getTelefone());
		dp.setIdusuario(endereco.get().getIdusuario());
		dpr.save(dp);
		return "[{msg:'endereco Atualizado com sucesso'}]";
	}
}
