package demo.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.com.dominio.Categoria;
import demo.com.service.CategoriaService;
import demo.com.util.ErrorMessages;
import demo.com.util.Mensajes;

/**
 * @author Daniela García Millán
 *
 */
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired // llama a Spring para indicar que será una instancia
	private CategoriaService CategoriaService;

	@GetMapping("/{id}")
	public Mensajes getRegistro(@PathVariable("id") String id) {
		if (id != null) {
			try {
				int idNum = Integer.parseInt(id);
				Categoria c = CategoriaService.getCategoriaById(idNum);
				if (c == null) {
					return Mensajes.mensaje("500", ErrorMessages.PROERR_002, null);
				} else {
					return Mensajes.mensaje("200", ErrorMessages.PROERR_001, c);
				}
			} catch (NumberFormatException convert) {
				return Mensajes.mensaje("500", ErrorMessages.PROERR_001, null);
			}
		} else {
			return Mensajes.mensaje("500", ErrorMessages.PROERR_009, null);
		}
	}

	@GetMapping("/")
	public Mensajes sinDatos() {
		return Mensajes.mensaje("500", ErrorMessages.PROERR_012, null);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Categoria> listarCategoria() {
		return CategoriaService.getlistaCategoria();
	}

	@PostMapping
	public Mensajes insert(@RequestBody Categoria c) {
		if (c != null) {
			try {
				CategoriaService.actualizar(c);
				return Mensajes.mensaje("200", ErrorMessages.PROERR_000, c);
			} catch (DataAccessException e) {
				return Mensajes.mensaje("500", ErrorMessages.PROERR_002, null);
			}
		}
		return Mensajes.mensaje("500", ErrorMessages.PROERR_012, null);
	}

	@PutMapping("/actualizar/{id}") 
	public Mensajes insertById(@RequestBody Categoria c, @PathVariable String id) {
		try {
			if (id != null && c != null) {
				int idNum = Integer.parseInt(id);
				Categoria cat = CategoriaService.actualizarById(c, idNum);
				return Mensajes.mensaje("200", ErrorMessages.PROERR_001, cat);
			} else {
				Mensajes.mensaje("500", ErrorMessages.PROERR_009, null);
			}
		} catch (DataAccessException e) {
			Mensajes.mensaje("500", ErrorMessages.PROERR_010, null);
		}
		return Mensajes.mensaje("500", ErrorMessages.PROERR_012, null);
	}

	@DeleteMapping("/eliminar/{id}")
	public Mensajes delete(@PathVariable("id") String id) {
		if (id != null) {
			int idNum = Integer.parseInt(id);
			CategoriaService.deleteById(idNum);
			return Mensajes.mensaje("200", ErrorMessages.PROERR_001, null);
		} else {
			Mensajes.mensaje("500", ErrorMessages.PROERR_009, null);
		}
		return Mensajes.mensaje("500", ErrorMessages.PROERR_012, null);
	}
}
