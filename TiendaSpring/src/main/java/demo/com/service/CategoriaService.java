package demo.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.com.dominio.Categoria;
import demo.com.exception.DomainException;
import demo.com.interfaces.daos.ICategoria;
import demo.com.objetos.Repository.ICategoriaRepo;
import demo.com.util.Validator;

@Service
public class CategoriaService implements ICategoria {
	@Autowired // para que carge en el DAO Spring
	private ICategoriaRepo CategoriaRepository;

	@Override
	public Categoria getCategoriaById(int id) {
		return CategoriaRepository.findById(id).get();
	}

	@Override
	public List<Categoria> getlistaCategoria() {
		return CategoriaRepository.findAll();
	}

	// Hace un insert sí existe, de lo contrario lo actualiza
	@Override
	public Categoria actualizar(Categoria categoria) {
		if (CategoriaRepository.existsById(categoria.getId_categoria()) 
			&& !Validator.isVacio(categoria.getCat_nombre()) //obligo a que el nombre no este vacio
			&& categoria.getId_categoria() != 0 //como al insertar siempre la id será 0 porque no se pone
			|| !Validator.cumpleLongitudMax(categoria.getCat_descripcion(), 200)
			|| categoria.getCat_descripcion() == null) 
			{
			new DomainException("Error 404 Not_found, Categoria no encontrada");
		}
		return CategoriaRepository.save(categoria);
	}

	@Override
	public Categoria actualizarById(Categoria c, int id) {
		if (!CategoriaRepository.existsById(c.getId_categoria())) {
			new DomainException("Error 404 Not_found, Categoria no encontrada");
		}
		c.setId_categoria(id);
		return CategoriaRepository.save(c);
	}

	@Override
	public void deleteById(int id) {
		CategoriaRepository.deleteById(id);
	}
}
