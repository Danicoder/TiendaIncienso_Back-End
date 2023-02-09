package demo.com.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ValidatorTest {
	
	final String TEXTOOK = "dAN IELA5";
	final String TEXTOER = "$Da%&";
	
	final String VACIA = "";
	final String NULL = null;
	
	final String NUMBEROK1 = "1234567891";//10
	final String NUMBEROK2 = "23 876 67 0860";//14
	final String NUMBERERRORLONG = "23 876 6745673628767889 0860";//28
	final String NUMBERVACIO = "";
	final String NUMBERNULL = NULL;
	final String NUMBERER3 = "+34$6427&fggh67856";//18
	
	final String EMAILOK1 = "texto1@texto2.tld";
	final String EMAILERROR1 = "Concha.hotmail.com";
	final String EMAILERROR2 = "Concha@hotmailcom";
	final String EMIALERROR3 = "Conchahotmailcom";
	final String EMAILERROR4 = "Concha@@hotmailcom";
	
	final String DNIOK = "48.764.757-L";
	final String DNIERR1 = "48764757-O";
	final String DNIERR2 = "48.678.4-A";
 
	final String CONTRASEYA1 = "332@Daniela";
	final String CONTRASEYA2 = "";
	final String CONTRASEYA3= "23Dani";
	
	final LocalDate HOY = LocalDate.now();
	final LocalDate FECHAMENOR= LocalDate.of(2022,01,12);
	final LocalDate FECHAMAYOR= LocalDate.of(2024,03,19);
	final String FECHAOK= "12/03/2019";
	final String FECHAERROR2= "24122023";
	final String FECHAERROR3= "ab-cd-ef";
	final String FECHAERROR4= "21-03-2020";
	
	final String PRODUCTOOK1 = "HO333";
	final String PRODUCTOERROR = "A123B";
	final String PRODUCTOERROR1 = "ad45687P";
	final String PRODUCTOERROR2 = "1Holik";
	final String PRODUCTOERROR3 = "1Av";
	final String PRODUCTOERROR4 = "hola";
	final String PRODUCTOERROR5 = "123";
	final String PRODUCTOERROR6 = "0AB123";
	
	@Test
	void testIsAlfanumeric() {
		assertTrue(Validator.isAlfanumeric(TEXTOOK));
		assertFalse(Validator.isAlfanumeric(TEXTOER));
	}
	
	@Test
	void testIsVacio() {
		assertTrue(Validator.isVacio(VACIA));
		assertTrue(Validator.isVacio(NULL));
	}

	@Test
	void testCumplePhoneNumber() {
		assertTrue(Validator.cumplePhoneNumber(NUMBEROK1));
		assertTrue(Validator.cumplePhoneNumber(NUMBEROK2));
		assertFalse(Validator.cumplePhoneNumber(NUMBERERRORLONG));
		assertFalse(Validator.cumplePhoneNumber(NUMBERVACIO));
		assertFalse(Validator.cumplePhoneNumber(NUMBERNULL));
		assertFalse(Validator.cumplePhoneNumber(NUMBERER3));
	}

	@Test
	void testIsEmailValido() {
		assertTrue(Validator.isEmailValido(EMAILOK1));
		assertFalse(Validator.isEmailValido(EMAILERROR1));
		assertFalse(Validator.isEmailValido(EMAILERROR2));
		assertFalse(Validator.isEmailValido(EMIALERROR3));
		assertFalse(Validator.isEmailValido(EMAILERROR4));
	}

	@Test
	void testCumpleDNI() {
		assertTrue(Validator.cumpleDNI(DNIOK));
		assertFalse(Validator.cumpleDNI(DNIERR1));
		assertFalse(Validator.cumpleDNI(DNIERR2));
	}

	@Test
	void testCumpleRangoIntIntInt() {
		assertTrue(Validator.cumpleRango(27, 20, 30));
		assertTrue(Validator.cumpleRango(5, 3, 8));
		assertFalse(Validator.cumpleRango(2, 3, 3));
		assertFalse(Validator.cumpleRango(4, 6, 10));
	}

	@Test
	void testCumpleRangoDoubleIntInt() {
		assertTrue(Validator.cumpleRango(65.70, 60, 85));
		assertTrue(Validator.cumpleRango(5.09, 3, 8));
		assertFalse(Validator.cumpleRango(2.87, 5, 3));
		assertTrue(Validator.cumpleRango(5.50, 5, 10));
	}

	@Test
	void testCumpleLongitudMin() {
		assertTrue(Validator.cumpleLongitudMin("Hola caracola",5));//13
		assertTrue(Validator.cumpleLongitudMin("Good morning",10));//12
		assertFalse(Validator.cumpleLongitudMin("I am try programming, because I like it",40));//39
		assertFalse(Validator.cumpleLongitudMin("Hola holita",12));//11
	}

	@Test
	void testCumpleLongitudMax() {
		assertTrue(Validator.cumpleLongitudMax("Hola caracola",14));//13
		assertTrue(Validator.cumpleLongitudMax("Good morning",13));//12
		assertFalse(Validator.cumpleLongitudMax("I am try programming, because I like it",4));//39
		assertFalse(Validator.cumpleLongitudMax("Hola holita",1));//11
	}

	@Test
	void testCumpleLongitud() {
		assertTrue(Validator.cumpleLongitud("Hola Caracola",12,15));//13
		assertTrue(Validator.cumpleLongitud("Good morning",10,15));//12
		assertFalse(Validator.cumpleLongitud("I am try programming, because I like it",50,5));//39
		assertFalse(Validator.cumpleLongitud("Hola holita",1,6));//11
	}

	@Test
	void testValDateMin() {
		assertTrue(Validator.valDateMin(FECHAMAYOR,HOY));
		assertTrue(Validator.valDateMin(FECHAMAYOR,FECHAMENOR));
		assertFalse(Validator.valDateMin(FECHAMENOR, FECHAMAYOR));
	}

	@Test
	void testValDateMax() {
		assertTrue(Validator.valDateMax(FECHAMENOR,HOY));
		assertTrue(Validator.valDateMax(FECHAMENOR,FECHAMAYOR));
		assertFalse(Validator.valDateMax(FECHAMAYOR,FECHAMENOR));
	}

	@Test
	void testEsFechaValida() {
		assertTrue(Validator.esFechaValida(FECHAOK));
		assertFalse(Validator.esFechaValida(FECHAERROR2));
		assertFalse(Validator.esFechaValida(FECHAERROR3));
		assertFalse(Validator.esFechaValida(FECHAERROR4));
	}

	@Test
	void testEsPasswordValida() {
		assertTrue(Validator.esPasswordValida(CONTRASEYA1));
		assertFalse(Validator.esPasswordValida(CONTRASEYA2));
		assertFalse(Validator.esPasswordValida(CONTRASEYA3));
	}
	
	@Test
	void testCodProducto() {
		assertTrue(Validator.codProducto(PRODUCTOOK1));
		assertFalse(Validator.codProducto(PRODUCTOERROR));
		assertFalse(Validator.codProducto(PRODUCTOERROR1));
		assertFalse(Validator.codProducto(PRODUCTOERROR2));
		assertFalse(Validator.codProducto(PRODUCTOERROR3));
		assertFalse(Validator.codProducto(PRODUCTOERROR4));
		assertFalse(Validator.codProducto(PRODUCTOERROR5));
		assertFalse(Validator.codProducto(PRODUCTOERROR6));
	}
}
