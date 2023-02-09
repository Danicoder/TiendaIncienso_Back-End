/**
 * 
 */
package demo.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.com.dominio.Categoria;
import demo.com.service.CategoriaService;

/**
 * @author d.garcia.millan
 *
 */
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired//llama a Spring para indicar que será una instancia
	private CategoriaService CategoriaService;

	@GetMapping("{id}")
	public Categoria getRegistro(@PathVariable("id") int id) {
		return CategoriaService.getCategoriaById(id);
	}

	@GetMapping()
	public List<Categoria> listarCategoria() {
		return CategoriaService.getlistaCategoria();
	}

	@PostMapping // insert
	public Categoria insert(@RequestBody Categoria c) {
		return CategoriaService.actualizar(c);
	}
	@PutMapping("/{id}") // modificar un único campo
	public Categoria insertById(@RequestBody Categoria c, @PathVariable int id) {
		return CategoriaService.actualizarById(c,id);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		CategoriaService.deleteById(id);
	}
}
