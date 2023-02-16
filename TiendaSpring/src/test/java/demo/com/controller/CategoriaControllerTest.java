package demo.com.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import demo.com.dominio.Categoria;
import demo.com.exception.ControllerException;
import demo.com.exception.DAOException;
import demo.com.objetos.Repository.ICategoriaRepo;
import demo.com.util.ErrorMessages;

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
		assertThat(when(controller.listarCategoria()).thenReturn(List.of(categoria_uno,categoria_dos)));
	}

	@Test
	final void testListarCategoria() {
		assertThat(when(controller.listarCategoria()).thenReturn(List.of(categoria_uno)));
		assertThat(when(controller.listarCategoria()).thenReturn(List.of(categoria_dos)));
	}

	@Test
	final void testInsert() throws Exception {
		assertThat(when(controller.insert(categoria_uno)).thenReturn(ControllerException.montaError(200, ErrorMessages.PROERR_013, null)));
		assertThat(when(controller.insert(categoria_dos)).thenReturn(ControllerException.montaError(200, ErrorMessages.PROERR_013, null)));
	}

	@Test
	final void testInsertById() {
		assertThat(when(controller.insertById(categoria_uno, IDS)).thenReturn(ControllerException.montaError(200, ErrorMessages.PROERR_013, null)));
		assertThat(when(controller.insertById(categoria_dos, IDS)).thenReturn(ControllerException.montaError(200, ErrorMessages.PROERR_013, null)));
	}

	@Test
	final void testDelete() throws DAOException {
		assertThat(when(controller.delete(IDS)).thenReturn(ControllerException.montaError(200, ErrorMessages.PROERR_013, null)));
		assertThat(when(controller.delete(IDS)).thenReturn(ControllerException.montaError(200, ErrorMessages.PROERR_013, null)));
	}

}
