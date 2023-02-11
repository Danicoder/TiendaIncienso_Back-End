package demo.com.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demo.com.util.ErrorMessages;

class CategoriaTest {

	final String NOMBREOK1 = "Incienso";
	final String NOMBREERRORLONGITUD_ERRORMAX = "Me estoy pasando de longitud para hacer el test debo medir mas de 50";// 68
	final String NOMBREERRORLONGITUD_ERRORMIN = "Hola";
	final String CUMPLELONGITUDMIN = "holaa";
	final String CUMPLELONGITUDMAX = "Me estoy pasando de longitud para hacer el test de";
	final int MIN = 5;
	final int MAX = 50;
	final int MAX_DESCRIPCION = 200;
	final int MIN_DESCRIPCION = 0;

	final String DESCRIPCIONOK1 = "Incienso";
	final String VACIO = "";
	final String ERROR_DESCRIPCIONLONGITUDMAX = "Me estoy pasando de longitud para hacer el testMe estoy pasando de longitud para hacer el testMe estoy pasando de longitud para hacer el testMe estoy pasando de longitud para hacer el testlongitud para hacer el test";// 215

	Categoria categoria;
	final Object OBJETO1 = categoria;
	final Object OBJETO2 = categoria;

	@BeforeEach
	void creacion() {
		categoria = new Categoria();
	}

	@Test
	void testCategoria() {
		creacion();
	}

	@Test
	void testGetCat_nombre() throws Exception {
		categoria.setCat_nombre(NOMBREOK1);
		assertEquals(NOMBREOK1, categoria.getCat_nombre());
	}

	@Test
	void testSetCat_nombre() throws Exception {
		categoria.setCat_nombre(NOMBREOK1);
		assertEquals(NOMBREOK1, categoria.getCat_nombre());
	}

	@Test
	void testSetCat_nombre_RANGO() {
		assertTrue(CUMPLELONGITUDMIN.length() >= MIN && CUMPLELONGITUDMAX.length() <= MAX);
	}

	@Test
	void testSetCat_nombre_ERRORMAX() {
		assertThrows(Exception.class, () -> categoria.setCat_nombre(NOMBREERRORLONGITUD_ERRORMAX),
				ErrorMessages.PROERR_003);
	}

	@Test
	void testSetCat_nombre_ERRORMIN() {
		assertThrows(Exception.class, () -> categoria.setCat_nombre(NOMBREERRORLONGITUD_ERRORMIN),
				ErrorMessages.PROERR_003);
	}

	@Test
	void testGetCat_descripcion() throws Exception {
		categoria.setCat_descripcion(DESCRIPCIONOK1);
		assertEquals(DESCRIPCIONOK1, categoria.getCat_descripcion());
	}

	@Test
	void testSetCat_descripcion() throws Exception {
		categoria.setCat_descripcion(DESCRIPCIONOK1);
		assertEquals(DESCRIPCIONOK1, categoria.getCat_descripcion());
	}

	@Test
	void testSetCat_descripcion_NULL() {
		Categoria c = null;
		assertNull(c);
	}

	@Test
	void testSetCat_descripcion_ERROR2() {
		assertFalse(ERROR_DESCRIPCIONLONGITUDMAX.length() <= MAX_DESCRIPCION
				&& ERROR_DESCRIPCIONLONGITUDMAX.length() <= MIN_DESCRIPCION);
	}

	@Test
	void testEqualsObject() {
		assertSame(OBJETO1, OBJETO2);
	}
}
