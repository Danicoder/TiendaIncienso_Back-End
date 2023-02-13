package demo.com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.ModuleLayer.Controller;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import demo.com.controller.CategoriaController;
import demo.com.dominio.Categoria;
import demo.com.objetos.Repository.ICategoriaRepo;
import demo.com.util.Mensajes;

class CategoriaServiceTest {
	
	@Mock
	private ICategoriaRepo Repository;
	@InjectMocks
	private CategoriaService service;
	private Categoria categoria_uno;
	private Categoria categoria_dos;
	private CategoriaController controller;
	
	@BeforeEach
	void setUp() throws Exception {
		service = mock(CategoriaService.class);
		Repository = mock(ICategoriaRepo.class);
		controller = mock(CategoriaController.class);
		
		categoria_uno = new Categoria();
		categoria_uno.setCat_descripcion("Soy una descripción larga");
		categoria_uno.setCat_nombre("Incienso");
		categoria_uno.setId_categoria(2);
		
		categoria_dos = new Categoria();
		categoria_dos.setCat_descripcion("Soy otra descripción larga");
		categoria_dos.setCat_nombre("otro incienso mas");
		categoria_dos.setId_categoria(3);
	}

	@Test
	final void testGetCategoriaById() {
		assertNotNull(when(service.getCategoriaById(1)).thenReturn(categoria_uno));
		assertNotNull(when(service.getCategoriaById(2)).thenReturn(categoria_dos));
	}

	@Test
	final void testGetlistaCategoria() {
		assertNotNull(when(service.getlistaCategoria()).thenReturn(List.of(categoria_uno,categoria_dos)));
		List<Categoria> listCat = service.getlistaCategoria();
		assertEquals(2,listCat.size());
		assertNotNull(when(service.getlistaCategoria()).thenReturn(List.of(categoria_dos)));
		List<Categoria> listaCat = service.getlistaCategoria();
		assertEquals(1,listaCat.size());
	}

	@Test
	final void testActualizar() {
		assertNotNull(when(service.actualizar(categoria_uno)).thenReturn(categoria_uno));
		assertNotNull(when(service.actualizar(categoria_dos)).thenReturn(categoria_dos));
	}

	@Test
	final void testActualizarById() {
		assertNotNull(when(Repository.save(any(Categoria.class))).thenReturn(categoria_uno));
		assertNotNull(when(service.actualizarById(categoria_dos, 2)).thenReturn(categoria_dos));
	}

	@Test
	final void testDeleteById() {
		service.deleteById(2);
		assertEquals(controller.getRegistro("5"),service.getCategoriaById(5));
	}
}
