package br.com.ficticiusclean.FleetManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String marca;
	private String modelo;
	private Long anoFabricacao;
	private Float kmPorLitroCidade;
	private Float kmPorLitroRodovia;
	
	
	public Veiculo() {
	}
	
	public Veiculo(String nome, String marca, String modelo, Long anoFabricacao, Float kmPorLitroCidade,
			Float kmPorLitroRodovia) {
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.kmPorLitroCidade = kmPorLitroCidade;
		this.kmPorLitroRodovia = kmPorLitroRodovia;
	}
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (anoFabricacao == null) {
			if (other.anoFabricacao != null)
				return false;
		} else if (!anoFabricacao.equals(other.anoFabricacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kmPorLitroCidade == null) {
			if (other.kmPorLitroCidade != null)
				return false;
		} else if (!kmPorLitroCidade.equals(other.kmPorLitroCidade))
			return false;
		if (kmPorLitroRodovia == null) {
			if (other.kmPorLitroRodovia != null)
				return false;
		} else if (!kmPorLitroRodovia.equals(other.kmPorLitroRodovia))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
