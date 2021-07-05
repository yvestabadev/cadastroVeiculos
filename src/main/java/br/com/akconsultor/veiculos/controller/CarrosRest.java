package br.com.akconsultor.veiculos.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.akconsultor.veiculos.modelos.Carro;
import br.com.akconsultor.veiculos.repository.CarroRepository;

@RestController
@RequestMapping("rest")
public class CarrosRest {
	
	@Autowired
	CarroRepository repository;
	
	@GetMapping()
	List<Carro> ultimosCarros(){
		return repository.findByIntervalo(LocalDateTime.now().minusDays(7), LocalDateTime.now());
	}

}
