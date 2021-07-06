package br.com.akconsultor.veiculos.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.akconsultor.veiculos.modelos.Carro;
import br.com.akconsultor.veiculos.modelos.Marca;

public class CadastraCarro {
	
	@NotNull @NotEmpty
	private String veiculo;
	@NotNull @NotEmpty
	private String marca;
	@NotNull
	private Integer ano;
	private String descricao;
	
	public Carro toCarro() {
		Carro carro = new Carro();
		carro.setVeiculo(this.veiculo);
		carro.setMarca(Marca.valueOf(marca.toUpperCase()));
		carro.setAno(this.ano);
		carro.setDescricao(this.descricao);
		carro.setVendido(false);
		carro.setCreated(LocalDateTime.now());
		carro.setUpdated(LocalDateTime.now());
		
		return carro;
	}
	


	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
