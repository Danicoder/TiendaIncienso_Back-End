package demo.com.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
		
		ResponseEntity<Integer> responseEntity =
				ResponseEntity.status(HttpStatus.OK).header("status", "datos", "categoria").body(42);

		assertThat(responseEntity).isNotNull();
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getHeaders().containsKey(1)).isTrue();
		assertThat(responseEntity.getHeaders().get(1)).containsKey(1).isTrue();
		assertThat(responseEntity.getBody()).isEqualTo(1);
	}

	@Test
	final void testGetRegistro() throws ControllerException {
		ResponseEntity<?> responseEntity = controller.listarCategoria();

		assertThat(responseEntity).isNotNull();
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNull();
	}

	@Test
	final void testListarCategoria() throws ControllerException {
		ResponseEntity<?> responseEntity = controller.getRegistro(IDS);

		assertThat(responseEntity).isNotNull();
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNull();
	}

	@Test
	final void testInsert() throws Exception {
		ResponseEntity<?> responseEntity = controller.insert(categoria_uno);

		assertThat(responseEntity).isNotNull();
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNull();
	}

	@Test
	final void testInsertById() {
		ResponseEntity<?> responseEntity = controller.insertById(categoria_uno, IDS);

		assertThat(responseEntity).isNotNull();
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNull();
	}

	@Test
	final void testDelete() throws DAOException {
		ResponseEntity<?> responseEntity = controller.delete(IDS);

		assertThat(responseEntity).isNotNull();
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isNull();
	}

}
