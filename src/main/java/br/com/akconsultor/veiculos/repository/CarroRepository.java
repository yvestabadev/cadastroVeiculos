package br.com.akconsultor.veiculos.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import br.com.akconsultor.veiculos.modelos.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{
	
	List<Carro> findAllByVendido(Boolean isVendido);
	
//	@Query("select c from carros c where c.created = :data")
//	List<Carro> registroUltimaSemana(@Param("data") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDateTime data);

}
