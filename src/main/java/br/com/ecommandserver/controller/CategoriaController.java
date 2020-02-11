package br.com.ecommandserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommandserver.entity.CategoriaEntity;
import br.com.ecommandserver.repository.CategoriaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("categoria")
public class CategoriaController {

	@Autowired
	CategoriaRepository categoria;

	@GetMapping(path = "/{id}", produces = "application/json")
	public CategoriaEntity getCategoriaById(@PathVariable long id) throws Exception {
		return categoria.findById(id).get();
	}

	@GetMapping(path = "/listar")
	public List<CategoriaEntity> getListaCategorias() throws Exception {
		return categoria.findAll();
	}

}
