package br.com.ficticiusclean.FleetManagement.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ficticiusclean.FleetManagement.model.Veiculo;

public class VeiculoDto {

	private Long id;
	private String nome;
	private String marca;
	private String modelo;
	private Long anoFabricacao;
	private Float kmPorLitroCidade;
	private Float kmPorLitroRodovia;

	public VeiculoDto(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.nome = veiculo.getNome();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.anoFabricacao = veiculo.getAnoFabricacao();
		this.kmPorLitroCidade = veiculo.getKmPorLitroCidade();
		this.kmPorLitroRodovia = veiculo.getKmPorLitroRodovia();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Long getAnoFabricacao() {
		return anoFabricacao;
	}

	public Float getKmPorLitroCidade() {
		return kmPorLitroCidade;
	}

	public Float getKmPorLitroRodovia() {
		return kmPorLitroRodovia;
	}

	public static List<VeiculoDto> converter(List<Veiculo> veiculos) {
		return veiculos.stream().map(VeiculoDto::new).collect(Collectors.toList());
	}
}
