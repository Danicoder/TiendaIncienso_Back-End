package demo.com.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.com.dominio.Categoria;
import demo.com.exception.DAOException;
import demo.com.interfaces.daos.ICategoria;
import demo.com.objetos.Repository.ICategoriaRepo;
import demo.com.util.ErrorMessages;
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
				new DAOException(ErrorMessages.PROERR_009);
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
				new DAOException(ErrorMessages.PROERR_008);
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
				new DAOException(ErrorMessages.PROERR_008);
				}
				return CategoriaRepository.save(categoria);
		}catch(NullPointerException e)
		{
			new DAOException(ErrorMessages.PROERR_012);
		}
		return categoria;
	}

	@Override
	public void deleteById(int id) {
		CategoriaRepository.deleteById(id);
	}
}
