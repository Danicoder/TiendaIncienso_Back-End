package demo.com.objetos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.com.dominio.Categoria;
public interface ICategoriaRepo extends JpaRepository<Categoria, Integer> {
}
