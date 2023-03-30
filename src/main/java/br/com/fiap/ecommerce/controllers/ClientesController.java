package br.com.fiap.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.fiap.ecommerce.models.Cliente;
import br.com.fiap.ecommerce.repositories.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClientesController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("cliente/index");
		List<Cliente> listaCliente = clienteRepository.findAll();
		model.addObject("clientes", listaCliente);
		return model;
	}
	
	@GetMapping("/create")
	public String create() {		
		return "cliente/create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("cliente") Cliente objCliente) {
		clienteRepository.save(objCliente);
		return "redirect:/cliente";
	}
}
