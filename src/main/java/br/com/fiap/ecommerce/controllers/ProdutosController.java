package br.com.fiap.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.ecommerce.models.Categoria;
import br.com.fiap.ecommerce.models.Fornecedor;
import br.com.fiap.ecommerce.models.Produto;
import br.com.fiap.ecommerce.repositories.CategoriaRepository;
import br.com.fiap.ecommerce.repositories.FornecedorRepository;
import br.com.fiap.ecommerce.repositories.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutosController {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("produto/index");
		List<Produto> listaProduto = produtoRepository.findAll();
		model.addObject("produtos", listaProduto);
		return model;
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView model = new ModelAndView();
		List<Categoria> listaCategoria = categoriaRepository.findAll();
		List<Fornecedor> listaFornecedor = fornecedorRepository.findAll();
		model.addObject("categorias", listaCategoria);
		model.addObject("fornecedores", listaFornecedor);
		return model;
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("produto") Produto objProduto) {
		produtoRepository.save(objProduto);
		return "redirect:/produto";
	}
}
