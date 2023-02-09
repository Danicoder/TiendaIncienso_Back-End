package demo.com.interfaces.daos;

import java.util.List;

import demo.com.dominio.Categoria;



public interface ICategoria {
	public Categoria getCategoriaById(int id);
	public List<Categoria> getlistaCategoria();
	public Categoria actualizar(Categoria categoria);
	public Categoria actualizarById(Categoria c,int id);
	public void deleteById(int id);
}
