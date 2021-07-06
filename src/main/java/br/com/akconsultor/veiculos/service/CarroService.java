package br.com.akconsultor.veiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.akconsultor.veiculos.dto.CadastraCarro;
import br.com.akconsultor.veiculos.modelos.Carro;
import br.com.akconsultor.veiculos.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	CarroRepository repository;
	
	public void novoCarro(CadastraCarro novo) {
		Carro carro = novo.toCarro();
		repository.save(carro);
		
	}

}
