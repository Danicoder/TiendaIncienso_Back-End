/**
 * 
 */
package demo.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import demo.com.util.Mensajes;
import demo.com.util.ErrorMessages;

/**
 * @author d.garcia.millan
 *
 */
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired // llama a Spring para indicar que será una instancia
	private CategoriaService CategoriaService;

	// Otra forma de lanzar exception pero sin cambiar el estado de postman
	@GetMapping("/{id}")
	public Mensajes getRegistro(@PathVariable("id") String id) {
		if (id != null) {
			try {
				int idNum = Integer.parseInt(id);
				Categoria c = CategoriaService.getCategoriaById(idNum);
				if (c == null) {
					return Mensajes.mensaje("500", ErrorMessages.PROERR_002, null);
				} else {
					return Mensajes.mensaje("200",ErrorMessages.PROERR_001, c);
				}
			} catch (NumberFormatException convert) {// convertir de string a int
				return Mensajes.mensaje("500", ErrorMessages.PROERR_001, null);
			}
		} else {
			return Mensajes.mensaje("500", "La categoria no existe", null);
		}
	}

	@GetMapping("/")
	public Mensajes sinDatos() {
		return Mensajes.mensaje("500", "La categoria no existe", null);
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Categoria> listarCategoria() {
		return CategoriaService.getlistaCategoria();
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Categoria c) {
		Map<String, Object> response = new HashMap<>();
		try {
			CategoriaService.actualizar(c);
			response.put("Mensaje: ", ErrorMessages.PROERR_010);
		}
		catch(DataAccessException e) {
			response.put("Mensaje: ", ErrorMessages.PROERR_009);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping("/actualizar/{id}") // modificar un único campo
	public ResponseEntity<?> insertById(@RequestBody Categoria c, @PathVariable int id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Categoria categoria = null;
			try {
				categoria = CategoriaService.actualizarById(categoria, id);
				if (!categoria.isValid()) {// sí el valor del objeto no es nulo
					response.put("Mensaje:", ErrorMessages.PROERR_010);
				} else {
					response.put("Mensaje:", ErrorMessages.PROERR_009);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} catch (DataAccessException e) {
				response.put("Mensaje: ", ErrorMessages.PROERR_009);
			}
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}catch(NullPointerException n) {
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(NumberFormatException f) {
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(UnknownError e) {
			e.getStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// Otra forma de capturar errores cambiando el estado de Postman
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		Map<String, Object> response = new HashMap<>();
		try {
			try {
				CategoriaService.deleteById(id);
				response.put("Mensaje:", "Se elimino la categoria correctamente");
			} catch (DataAccessException e) {
				response.put("Mensaje: ", ErrorMessages.PROERR_011);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("Mensaje: ", ErrorMessages.PROERR_011);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}	
}
