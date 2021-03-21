package br.com.ficticiusclean.FleetManagement.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ficticiusclean.FleetManagement.controller.dto.PrevisaoGastoVeiculoDto;
import br.com.ficticiusclean.FleetManagement.controller.dto.VeiculoDto;
import br.com.ficticiusclean.FleetManagement.controller.form.VeiculoForm;
import br.com.ficticiusclean.FleetManagement.model.Veiculo;
import br.com.ficticiusclean.FleetManagement.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping
	public List<VeiculoDto> Listar(String marca) {	
		if(marca == null) {
			List<Veiculo> veiculos = veiculoRepository.findAll();
			return VeiculoDto.converter(veiculos);
		} else {
			List<Veiculo> veiculos = veiculoRepository.findAllByMarca(marca);
			return VeiculoDto.converter(veiculos);
		}
	}
	
	@GetMapping("/prever_consumo")
	public List<PrevisaoGastoVeiculoDto> ranquearPorConsumo(Float valorGasolina, Float kmCidade, Float kmRodovia) {
		if(valorGasolina != null & kmCidade != null & kmRodovia != null) {
			return PrevisaoGastoVeiculoDto.converter(veiculoRepository, valorGasolina, kmCidade, kmRodovia);
		}
		return null;
	}
	
	@PostMapping
	public ResponseEntity<VeiculoDto> cadastrar(@RequestBody @Valid VeiculoForm veiculoForm, UriComponentsBuilder uriBuilder) {
		Veiculo veiculo = veiculoForm.converter();
		veiculoRepository.save(veiculo);
		
		URI uri = uriBuilder.path("/veiculo/{id}").buildAndExpand(veiculo.getId()).toUri();
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
	}
	
	
	
}
