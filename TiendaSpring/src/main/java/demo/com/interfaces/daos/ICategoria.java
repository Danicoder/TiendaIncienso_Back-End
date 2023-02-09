package demo.com.interfaces.daos;

import java.util.List;

import demo.com.dominio.Categoria;



public interface ICategoria {
	public Categoria getRegistro(int num);
	public List<Categoria> lista(Categoria c);
	public boolean guardar(Categoria c);
}
