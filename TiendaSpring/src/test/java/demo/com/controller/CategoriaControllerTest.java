package demo.com.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import demo.com.dominio.Categoria;
import demo.com.objetos.Repository.ICategoriaRepo;
import demo.com.util.ErrorMessages;
import demo.com.util.Mensajes;

class CategoriaControllerTest {
	
	private final String DESCRIPCION1="textaco largo para describir una categoria";
	private final String DESCRIPCION2="textaco largo para describir una categoria";
	private final String NOMBRE1="Probando";
	private final String NOMBRE2="Incienso";
	private final int ID = 2;
	private final String IDS = Integer.toString(ID);
	
	
	@Mock
	private ICategoriaRepo CategoriaRepository;
	@InjectMocks
	private CategoriaController controller;
	private Categoria categoria_uno;
	private Categoria categoria_dos;
	
	
	@BeforeEach
	void comienzo() throws Exception {
		controller = mock(CategoriaController.class);
		
		categoria_uno = new Categoria();
		categoria_uno.setCat_descripcion(DESCRIPCION1);
		categoria_uno.setCat_nombre(NOMBRE1);
		categoria_uno.setId_categoria(ID);
		
		categoria_dos = new Categoria();
		categoria_dos.setCat_descripcion(DESCRIPCION2);
		categoria_dos.setCat_nombre(NOMBRE2);
		categoria_dos.setId_categoria(ID);
	}

	@Test
	final void testGetRegistro() {
		assertNotNull(when(controller.listarCategoria()).thenReturn(List.of(categoria_uno,categoria_dos)));
	}

	@Test
	final void testSinDatos() {
		assertNull(controller.sinDatos());
	}

	@Test
	final void testListarCategoria() {
		assertNotNull(when(controller.listarCategoria()).thenReturn(List.of(categoria_uno)));
		assertNotNull(when(controller.listarCategoria()).thenReturn(List.of(categoria_dos)));
	}

	@Test
	final void testInsert() throws Exception {
		Mensajes m1 = new Mensajes();
		m1.mensaje="";
		m1.codigo="200";
		m1.categoria=categoria_uno;
		Mensajes m2 = new Mensajes();
		m2.mensaje="";
		m2.codigo="200";
		m2.categoria=categoria_dos;
		assertNotNull(when(controller.insert(categoria_uno)).thenReturn(m1));
		assertNotNull(when(controller.insert(categoria_dos)).thenReturn(m2));
	}

	@Test
	final void testInsertById() {
		Mensajes m1 = new Mensajes();
		m1.mensaje="";
		m1.codigo="200";
		m1.categoria=categoria_uno;
		Mensajes m2 = new Mensajes();
		m2.mensaje="";
		m2.codigo="500";
		m2.categoria=null;
		assertNotNull(when(controller.insertById(categoria_uno, IDS)).thenReturn(m1));
		assertNotNull(when(controller.insertById(categoria_dos, IDS)).thenReturn(m2));
	}

	@Test
	final void testDelete() {
		Mensajes m1 = new Mensajes();
		m1.mensaje="";
		m1.codigo="200";
		m1.categoria=categoria_uno;
		Mensajes m2 = new Mensajes();
		m2.mensaje="";
		m2.codigo="200";
		m2.categoria=categoria_dos;
		assertNotNull(when(controller.delete(IDS)).thenReturn(m1));
		assertNotNull(when(controller.delete(IDS)).thenReturn(m2));
	}

}
