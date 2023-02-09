package demo.com.dominio;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductoTest {
	
	final String NULL = null;
	final String VACIO = "";
	
	final String ID_PRODUCT = "IN325";
	
	final String DESCRIPCION = "Tengo cómo máximo 100 caracteres y mínimo 5";//43
	final String DESCRIPCION_ERROR = "hol";//3
	
	final String EXPLICACION = "soy alfanumérico y tengo entre 5 y 2000, peor no soy obligarotio";//64
	final String EXPLICACION_ERROR = "ho";
	
	final double PRECIO = 1.25;
	final double PRECIO_ERROR = 1.250;
	
	final int STOCK = 125;
	
	final LocalDate FECHA_REPO_ACTIVACION_DESASTIVACION = LocalDate.of(2016, 10, 10);//dd/mm/yyyy
	final LocalDate FECHA_HOY = LocalDate.now();
	
	final String UNIDAD_VENTA = "Caja";//entre 1 y 10
	final String UNIDAD_VENTA_ERROR = "Voy a pasarme de longitud";//25
	
	final double CANTIDAD_ULTIMAS_UNIDADES = 10.00;
	final double CANTIDAD_ULTIMAS_UNIDADES_ERROR = 10.500;
	
	final String ULTIMA_UNIDAD = "sticks";
	
	final int ID_PAIS = 1;
	final int ID_CATEGORIA = 1;
	
	final String USO_RECOMENDADO = "El uso de producto no debe ser superior 2000 carateres";//54
	
	final int STOCK_RESERVADO = 22;
	final int STOCK_NIVELALTO = 100;
	final int STOCK_NIVELBAJO = 10;
	
	final char ESTADO = 'A'; //es A o B
	final char ESTADO_ERROR = 'D';
	
	Producto pro;
	
	@BeforeEach
	void creacion() {
		pro = new Producto();
	}
	@Test
	void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	void testProducto() {
		fail("Not yet implemented");
	}

	@Test
	void testGetId_producto() {
		fail("Not yet implemented");
	}

	@Test
	void testSetId_producto() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_descripcion() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_descripcion() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_desLarga() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_desLarga() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_precio() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_precio() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_stock() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_stock() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_fecRepos() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_fecRepos() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_fecActi() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_fecActi() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_fecDesacti() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_fecDesacti() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_uniVenta() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_uniVenta() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_cantXUniVenta() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_cantXUniVenta() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_uniUltNivel() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_uniUltNivel() {
		fail("Not yet implemented");
	}

	@Test
	void testGetId_pais() {
		fail("Not yet implemented");
	}

	@Test
	void testSetId_pais() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_usoRecomendado() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_usoRecomendado() {
		fail("Not yet implemented");
	}

	@Test
	void testGetId_categoria() {
		fail("Not yet implemented");
	}

	@Test
	void testSetId_categoria() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_stkReservado() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_stkReservado() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_nStkAlto() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_nStkAlto() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_nStkBajo() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_nStkBajo() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPro_stat() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPro_stat() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
