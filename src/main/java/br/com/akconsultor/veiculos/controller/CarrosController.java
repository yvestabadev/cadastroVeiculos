package br.com.akconsultor.veiculos.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.akconsultor.veiculos.modelos.Carro;
import br.com.akconsultor.veiculos.repository.CarroRepository;

@Controller
@RequestMapping("home")
public class CarrosController {
	
	@Autowired
	private CarroRepository repository;
	
	@GetMapping("carros")
	public List<Carro> carros() {
		
		
		return repository.findAllByVendido(false);
	}
	
	

}
