package br.com.projeto.repository;

import java.util.Optional;

import br.com.projeto.domain.Precos;

public interface PrecosRepository {
	public Optional<Precos> findByprecoatual(Double precoatual);
}
