package br.com.fiap.ecommerce.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.fiap.ecommerce.models.Fornecedor;
import br.com.fiap.ecommerce.repositories.FornecedorRepository;

@Controller
@RequestMapping("/fornecedor")
public class FornecedoresController {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("fornecedor/index");
		List<Fornecedor> listaFornecedor = fornecedorRepository.findAll();
		model.addObject("fornecedores", listaFornecedor);
		return model;
	}
	
	@GetMapping("/create")
	public String create() {		
		return "fornecedor/create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("fornecedor") Fornecedor objFornecedor) {
		fornecedorRepository.save(objFornecedor);
		return "redirect:/fornecedor";
	}
}
