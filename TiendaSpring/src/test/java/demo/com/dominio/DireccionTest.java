package demo.com.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demo.com.util.ErrorMessages;

class DireccionTest {

	final String NO_ALFANUMERIC = "@#%{) _";

	final String NOMBREOK = "Daniela Garcia";
	final String NOMBRERRORMIN = "Noa";
	final String NOMBRERRORMAX = "Hola estoy escribiendo algo de relleno para pasarme de longitud y hacer pruebas, me estoy intentando pasar de 100";

	final String DIRECCIONOK = "Calle de Gravina 4";

	final String POBLACION = "Alicante";

	final String C_POSTAL = "03002";

	final String PROVINCIA = "Alicante";

	final String PAIS = "Espana";
	final int ID_PAIS = 1;

	final String EMAIL = "daniela@hotmail.com";
	final String EMAIL_ERROR = "Concha.$hotmail.com";

	Direccion dir;
	Pais pais;
	
	@BeforeEach
	void creacion() {
		dir = new Direccion();
		pais = new Pais();
	}

	@Test
	void testDireccion() {
		creacion();
	}

	@Test
	void testSetDir_nombre() throws Exception {
		dir.setDir_nombre(NOMBREOK);
		assertEquals(NOMBREOK, dir.getDir_nombre());
	}

	@Test
	void testSetDir_nombre_error1() {
		assertThrows(Exception.class, () -> dir.setDir_nombre(NOMBRERRORMAX), ErrorMessages.PROERR_008);
	}

	@Test
	void testSetDir_nombre_error2() {
		assertThrows(Exception.class, () -> dir.setDir_nombre(NOMBRERRORMIN), ErrorMessages.PROERR_008);
	}

	@Test
	void testGetDir_direccion() throws Exception {
		dir.setDir_direccion(DIRECCIONOK);
		assertEquals(DIRECCIONOK, dir.getDir_direccion());
	}

	@Test
	void testSetDir_direccion() throws Exception {
		dir.setDir_direccion(DIRECCIONOK);
		assertEquals(DIRECCIONOK, dir.getDir_direccion());
	}

	@Test
	void testGetDir_poblacion() throws Exception {
		dir.setDir_poblacion(POBLACION);
		assertEquals(POBLACION, dir.getDir_poblacion());
	}

	@Test
	void testSetDir_poblacion() throws Exception {
		dir.setDir_poblacion(POBLACION);
		assertEquals(POBLACION, dir.getDir_poblacion());
	}

	@Test
	void testGetDir_cPostal() throws Exception {
		dir.setDir_cPostal(C_POSTAL);
		assertEquals(C_POSTAL, dir.getDir_cPostal());
	}

	@Test
	void testSetDir_cPostal1() throws Exception {
		dir.setDir_cPostal(C_POSTAL);
		assertEquals(C_POSTAL, dir.getDir_cPostal());
	}

	@Test
	void testGetDir_provincia() throws Exception {
		dir.setDir_provincia(PROVINCIA);
		assertEquals(PROVINCIA, dir.getDir_provincia());
	}

	@Test
	void testSetDir_provincia() throws Exception {
		dir.setDir_provincia(PROVINCIA);
		assertEquals(PROVINCIA, dir.getDir_provincia());
	}

	@Test
	void testGetDir_pais() throws Exception {
		pais.setId_pais(ID_PAIS);
		dir.setDir_pais(pais.getId_pais());
		assertEquals(ID_PAIS, dir.getDir_pais());
	}

	@Test
	void testSetDir_pais() throws Exception {
		pais.setId_pais(ID_PAIS);
		dir.setDir_pais(pais.getId_pais());
		assertEquals(ID_PAIS, dir.getDir_pais());
	}

	@Test
	void testGetDir_correoE() throws Exception {
		dir.setDir_correoE(EMAIL);
		assertEquals(EMAIL, dir.getDir_correoE());
	}

	@Test
	void testSetDir_correoE() throws Exception {
		dir.setDir_correoE(EMAIL);
		assertEquals(EMAIL, dir.getDir_correoE());
	}

	@Test
	void testSetDir_correoE_error() {
		assertThrows(Exception.class, () -> dir.setDir_nombre(EMAIL_ERROR), ErrorMessages.PROERR_007);
	}
}
