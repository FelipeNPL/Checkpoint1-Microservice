package br.com.fiap.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import br.com.fiap.ecommerce.models.Categoria;
import br.com.fiap.ecommerce.repositories.CategoriaRepository;

@Controller
@RequestMapping("/categoria")
public class CategoriasController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("categoria/index");
		List<Categoria> listaCategoria = categoriaRepository.findAll();
		model.addObject("categorias", listaCategoria);
		return model;
	}
	
	@GetMapping("/create")
	public String create() {		
		return "categoria/create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("categoria") Categoria objCategoria) {
		categoriaRepository.save(objCategoria);
		return "redirect:/categoria";
	}
	
}
