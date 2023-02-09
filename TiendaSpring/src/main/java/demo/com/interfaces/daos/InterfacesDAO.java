package demo.com.interfaces.daos;




public interface InterfacesDAO<T> {
	public boolean insert(T t);
	public boolean update(T t);
	public boolean deleteById(S s);
	public List<T> listAll(S s);
	public T leerUno(S s);
}
