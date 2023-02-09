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

	private CategoriaService CategoriaService;

	@GetMapping("{id}")
	public Categoria leerById(@PathVariable("id") int id) {
		return CategoriaService.getById(id);
	}

	@GetMapping()
	public List<Categoria> listarCategoria() {
		return CategoriaService.getList();
	}

	@PostMapping // insert
	public Categoria insert(@RequestBody Categoria c) {
		return CategoriaService.update(c);
	}
	@PutMapping("/{id}") // modificar un único campo
	public Categoria insertById(@RequestBody Categoria c, @PathVariable int id) {
		return CategoriaService.actualizarById(c,id);
	}
	@DeleteMapping()
	public void delete(Categoria c) {
		CategoriaService.delete(c);
	}
}
