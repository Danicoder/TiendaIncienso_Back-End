package demo.com.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import demo.com.exception.ControllerException;
import demo.com.exception.DAOException;
import demo.com.service.CategoriaService;
import demo.com.util.ErrorMessages;

/**
 * @author Daniela García Millán
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired // llama a Spring para indicar que será una instancia
	private CategoriaService CategoriaService;

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> listarCategoria() throws ControllerException {
		List<Categoria> categoria = CategoriaService.getlistaCategoria();
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		if(!categoria.isEmpty()) {
			map.put("status", 1);
			map.put("datos", categoria);
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		else {
			throw new ControllerException(ErrorMessages.PROERR_008);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getRegistro(@PathVariable("id") String id) throws ControllerException {
		String mensaje;
		Categoria c = null;
		if (id != null) {
			try {
				int idNum = Integer.parseInt(id);
				c = CategoriaService.getCategoriaById(idNum);
				if (c == null) {
					return new ResponseEntity<>(ControllerException.montaError(0,c),HttpStatus.OK);
				} else {
					mensaje = ErrorMessages.PROERR_001;
				}
			} catch (NumberFormatException convert) {
				mensaje = "Formato erroeno";
			}
		} else {
			mensaje = ErrorMessages.PROERR_001;
		}
		return new ResponseEntity<>(ControllerException.montaError(0,c),HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> sinDatos() {
		return new ResponseEntity<>(ControllerException.montaError(1,null),HttpStatus.BAD_REQUEST);
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Categoria c) {
		c.setId_categoria(0);
		try {
			CategoriaService.actualizar(c);
			return new ResponseEntity<>(ControllerException.montaError(0,c),HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(ControllerException.montaError(1,c),HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> insertById(@RequestBody Categoria c, @PathVariable String id) {
		try {
			if (id != null && c != null) {
				int idNum = Integer.parseInt(id);
				CategoriaService.actualizarById(c, idNum);
				return new ResponseEntity<>(ControllerException.montaError(0,c),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(ControllerException.montaError(1,c),HttpStatus.BAD_REQUEST);
			}
		} catch (DataAccessException e) {
			return new ResponseEntity<>(ControllerException.montaError(1,c),HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) throws DAOException {																			// caso de no existir la id
		Map<String, Object> response = new LinkedHashMap<>();
		if (id != null) {
			try {
				int idNum = Integer.parseInt(id);
				CategoriaService.deleteById(idNum);
				response.put("Mensaje:", ErrorMessages.PROERR_014);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			} catch (NumberFormatException e) {
				return new ResponseEntity<>(ControllerException.montaError(1,null),HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>(ControllerException.montaError(1,null),HttpStatus.BAD_REQUEST);
		}
	}
}
