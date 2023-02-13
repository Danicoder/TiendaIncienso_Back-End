package demo.com.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.com.dominio.Categoria;
import demo.com.exception.DAOException;
import demo.com.interfaces.daos.ICategoria;
import demo.com.objetos.Repository.ICategoriaRepo;
import demo.com.util.Validator;

@Service
public class CategoriaService implements ICategoria {
	@Autowired // para que carge en el DAO Spring
	private ICategoriaRepo CategoriaRepository;

	@Override
	public Categoria getCategoriaById(int id) {
		try {
			if(CategoriaRepository.existsById(id)) {
				return CategoriaRepository.findById(id).get();
			}
			else
				new DAOException("Error 404 Not_found, Categoria no encontrada");
		}catch(NoSuchElementException e) {
			e.fillInStackTrace();
		}
		return CategoriaRepository.findById(id).get();
	}

	@Override
	public List<Categoria> getlistaCategoria() {
		try {
			if(CategoriaRepository.count() > 0) {
				return CategoriaRepository.findAll();
			}
			else
				new DAOException("Error: no existe la categoria");
		}catch(NoSuchElementException e) {
			e.fillInStackTrace();
		}
		return CategoriaRepository.findAll();
	}

	// Hace un insert sí existe, de lo contrario lo actualiza
	@Override
	public Categoria actualizar(Categoria categoria) {
		try {
			if (!Validator.isVacio(categoria.getCat_nombre())
				&& (!Validator.isVacio(categoria.getCat_nombre()) &&
					categoria.getId_categoria() != 0) )
				{
				new DAOException("Error 404 Not_found, Categoria no encontrada");
				}
				return CategoriaRepository.save(categoria);
		}catch(NullPointerException e)
		{
			new DAOException("Error 404 Not_found, Categoria no encontrada");
		}
		return categoria;
	}

	@Override
	public Categoria actualizarById(Categoria c, int id) {
		if (!CategoriaRepository.existsById(c.getId_categoria())) {
			new DAOException("Error 404 Not_found, Categoria no encontrada");
		}
		c.setId_categoria(id);
		return CategoriaRepository.save(c);
	}

	@Override
	public void deleteById(int id) {
		CategoriaRepository.deleteById(id);
	}
}
