package br.com.akconsultor.veiculos.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.akconsultor.veiculos.modelos.Carro;
import br.com.akconsultor.veiculos.modelos.Marca;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{
	
	List<Carro> findAllByVendido(Boolean isVendido);
	
	@Query("select c from Carro c where c.created between :dataInicial and :dataFinal")
	List<Carro> findByIntervalo(@Param("dataInicial") LocalDateTime dataInicial, @Param("dataFinal") LocalDateTime dataFinal);
	
	@Query("select c from Carro c where c.ano between :anoInicial and :anoFinal")
	List<Carro> findByDecada(@Param("anoInicial") Integer anoInicial, @Param("anoFinal") Integer anoFinal);
	
	List<Carro> findAllByMarca(Marca marca);

}
