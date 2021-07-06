package br.com.akconsultor.veiculos.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.akconsultor.veiculos.dto.CadastraCarro;
import br.com.akconsultor.veiculos.modelos.Carro;
import br.com.akconsultor.veiculos.modelos.Marca;
import br.com.akconsultor.veiculos.repository.CarroRepository;

@Controller
@RequestMapping("/veiculos")
public class CarrosController {

	@Autowired
	private CarroRepository repository;



	@GetMapping
	public String carros(Model model) {

		List<Carro> carrosSemana = repository.findByIntervalo(LocalDateTime.now().minusDays(7), LocalDateTime.now());
		model.addAttribute("carros", carrosSemana);

		List<Carro> carrosNaoVendidos = repository.findAllByVendido(false);
		model.addAttribute("numeroCarros", carrosNaoVendidos.size());

		List<Carro> volkswagen = repository.findAllByMarca(Marca.VOLKSWAGEN);
		model.addAttribute("volkswagen", volkswagen.size());

		List<Carro> honda = repository.findAllByMarca(Marca.HONDA);
		model.addAttribute("honda", honda.size());

		List<Carro> peugeot = repository.findAllByMarca(Marca.PEUGEOT);
		model.addAttribute("peugeot", peugeot.size());

		List<Carro> fiat = repository.findAllByMarca(Marca.FIAT);
		model.addAttribute("fiat", fiat.size());

		List<Carro> chevrolet = repository.findAllByMarca(Marca.CHEVROLET);
		model.addAttribute("chevrolet", chevrolet.size());

		List<Carro> anos90 = repository.findByDecada(1990, 1999);
		model.addAttribute("anos90", anos90.size());

		List<Carro> anos2000 = repository.findByDecada(2000, 2009);
		model.addAttribute("anos2000", anos2000.size());

		List<Carro> anos10 = repository.findByDecada(2010, 2019);
		model.addAttribute("anos10", anos10.size());

		List<Carro> anos20 = repository.findByDecada(2020, 2029);
		model.addAttribute("anos20", anos20.size());

		return "home";
	}
	
	@GetMapping("{id}")
	public String carroEspecifico(@PathVariable Long id, Model model) {
		Optional<Carro> carro = repository.findById(id);
		
		if(carro.isPresent()) {
			model.addAttribute("carro", carro.get());

		} else {
			return "redirect:/veiculos";
		}
		
		return "carro";
	}

	@PostMapping
	public String cadastraCarro(@Valid CadastraCarro carro, BindingResult result) {
		if(result.hasErrors()) {
			return "home";
		}
		
		Carro novo = new Carro();
		
		try {
		novo = carro.toCarro();
		} catch(IllegalArgumentException e) {
			result.addError(null);
		}
		
		
		repository.save(novo);
		
		return "redirect:/veiculos";
	}

}
