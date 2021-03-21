package br.com.ficticiusclean.FleetManagement.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.ficticiusclean.FleetManagement.model.Veiculo;
import br.com.ficticiusclean.FleetManagement.repository.VeiculoRepository;

public class PrevisaoGastoVeiculoDto {

	private String nome;
	private String marca;
	private String modelo;
	private Long anoFabricacao;
	private Float litrosTotalCombustivelGasto;
	private Float valorTotalCombustivelGasto;

	public PrevisaoGastoVeiculoDto(Veiculo veiculo, Float litrosTotalCombustivelGasto, Float valorTotalCombustivelGasto) {
		this.nome = veiculo.getNome();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.anoFabricacao = veiculo.getAnoFabricacao();
		this.litrosTotalCombustivelGasto = litrosTotalCombustivelGasto;
		this.valorTotalCombustivelGasto = valorTotalCombustivelGasto;
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

	public Float getLitrosTotalCombustivelGasto() {
		return litrosTotalCombustivelGasto;
	}

	public Float getValorTotalCombustivelGasto() {
		return valorTotalCombustivelGasto;
	}

	public static List<PrevisaoGastoVeiculoDto> converter(VeiculoRepository veiculoRepository, Float valorGasolina, Float kmCidade, Float kmRodovia) {
		List<Veiculo> veiculos = veiculoRepository.findAllByConsumo(kmCidade, kmRodovia);
		List<PrevisaoGastoVeiculoDto> ranqueDto = new ArrayList<PrevisaoGastoVeiculoDto>();

		veiculos.forEach(veiculo -> {
			Float litrosTotalCombustivelGasto = (kmCidade / veiculo.getKmPorLitroCidade()) + (kmRodovia / veiculo.getKmPorLitroRodovia());
			Float valorTotalCombustivelGasto = valorGasolina * litrosTotalCombustivelGasto;
			ranqueDto.add(new PrevisaoGastoVeiculoDto(veiculo, litrosTotalCombustivelGasto, valorTotalCombustivelGasto));
		});
		
		return ranqueDto;
	}
}
