package br.com.ficticiusclean.FleetManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ficticiusclean.FleetManagement.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

	List<Veiculo> findAllByMarca(String marca);

	@Query("SELECT v FROM Veiculo v ORDER BY ( :kmCidade / km_por_litro_cidade + :kmRodovia / km_por_litro_rodovia ) ASC") 
	List<Veiculo> findAllByConsumo(Float kmCidade, Float kmRodovia);
	
}
