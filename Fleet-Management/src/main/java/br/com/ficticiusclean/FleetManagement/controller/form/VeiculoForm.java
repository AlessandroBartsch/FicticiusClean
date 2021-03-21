package br.com.ficticiusclean.FleetManagement.controller.form;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.ficticiusclean.FleetManagement.model.Veiculo;

public class VeiculoForm {

	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	private String marca;
	@NotNull
	@NotEmpty
	private String modelo;
	@NotNull
	@Digits(integer = 4, fraction = 0)
	private Long anoFabricacao;
	@NotNull
	private Float kmPorLitroCidade;
	@NotNull
	private Float kmPorLitroRodovia;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Long getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(Long anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public Float getKmPorLitroCidade() {
		return kmPorLitroCidade;
	}
	public void setKmPorLitroCidade(Float kmPorLitroCidade) {
		this.kmPorLitroCidade = kmPorLitroCidade;
	}
	public Float getKmPorLitroRodovia() {
		return kmPorLitroRodovia;
	}
	public void setKmPorLitroRodovia(Float kmPorLitroRodovia) {
		this.kmPorLitroRodovia = kmPorLitroRodovia;
	}
	
	
	public Veiculo converter() {
		return new Veiculo(nome, marca, modelo, anoFabricacao, kmPorLitroCidade, kmPorLitroRodovia);
	}
}
