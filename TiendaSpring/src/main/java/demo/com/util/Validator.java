package demo.com.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/********************************************************************************************
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: Clase auxiliar para validar los datos que sean introducidos en
 * la aplicación.
 * 
 * @version 30/01/2023
 * @author Daniela García
 * 
 ******************************************************************************************/
public class Validator {

	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z\\s]+$";

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	/**
	 * Patrón para validar el email, evitando puntos finales antes de la @ y que
	 * solo contenga carácteres alfanuméricos
	 */
	private final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Permite verificar que un DNI cumple con el patrón XX.XXX.XXX-L
	 */
	private final static String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[a-zA-Z]";

	/**
	 * Permite validar un teléfono, el cual debe contener de 10 a 20 dígitos y donde
	 * los espacios estan permitidos
	 */
	private final static String PHONE_PATTERN = "[\\d ]{10,20}";

	/**
	 * Orden de las letras con las cuales se comprobar la validez del DNI
	 */
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

	/**
	 * Longitud que debe tener todo DNI pasado a la aplicación.
	 */
	private final static int LONGITUD_DNI = 12;
	/**
	 * Patrón para aceptar dos letras, tres números y solo mayúsculas.
	 */
	private final static String CODPRODUCT_PATTERN = "^[A-Z]{2}+\\d{3}$";
	/*
	 * *****************************************************************************
	 * ********** NOMBRE: isAlfanumeric *
	 * 
	 * DESCRIPCIóN:
	 *//**
		 * Permite verificar que el texto pasado solo contiene caracters alfanuméricos
		 * 
		 * @param texto String a verificar que solo tenga carácteres alfanuméricos
		 * 
		 * @return true, si cumple solo contiene caracters alfanuméricos. <br>
		 *         false en caso contrario FECHA: Enero 2023
		 * 
		 *         AUTOR: Daniela García - Alicante
		 * 
		 **************************************************************************************/
	/**
	 * Método que verifica sí es minúscula, mayúscula con dígitos entre 0 y 9
	 * 
	 * @param texto
	 * @return verdadero si cumple con la definición
	 */
	public static boolean isAlfanumeric(String texto) {
		return texto.matches(ALFANUMERIC_PATTERN);
	}

	/**
	 * Método que verifica si son iguales ignorando las diferencias entre mayúsculas
	 * y minúsculas
	 * 
	 * @param prueba
	 * @return
	 */
	public static boolean isVacio(String prueba) {
		return prueba == null || prueba.isEmpty();
	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: cumplePhoneNumber *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * El phone number debe tener un total de entre 10 y 20, contando dígitos y
		 * espacios. M�nimo aceptable son 10 dígitos.
		 * 
		 * @param phoneNumber String con el número de telefono de entre 10 y 20 dígitos.
		 *                    Puede tener espacios, pero siempre con 10 dígitos como
		 *                    mínimo.
		 * 
		 * @return true, si cumple todas las condiciones
		 *
		 * FECHA: Enero 2023 
		 * AUTOR: Daniela García
		 * 
		 **************************************************************************************/
	public static boolean cumplePhoneNumber(String phoneNumber) {
		return !isVacio(phoneNumber) && phoneNumber.matches(PHONE_PATTERN);
	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: isEmailValido *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprueba si el email tiene un formato que pueda ser válido.
		 * 
		 * @param email String a comprobar
		 * 
		 * @return true, en caso que el formato sea válido 
		 * FECHA: Enero 2023 
		 * AUTOR: Daniela García
		 * 
		 **************************************************************************************/
	public static boolean isEmailValido(String email) {
		return email.matches(EMAIL_PATTERN);
	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: cumpleDNI *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Esta función verifica que el DNI cumple el siguiente formato: xx.xxx.xxx-L
		 * <br>
		 * El DNI ha de tener longitud 12
		 * 
		 * @param dni String con DNI a ser validado
		 * 
		 * @return true, si el DNI cumple el estandar nacional. FECHA: Enero 2023 AUTOR:
		 *         Daniela García
		 * 
		 **************************************************************************************/
	public static boolean cumpleDNI(String dni) {
		dni.toUpperCase();
		char[] numerosDni = dni.toCharArray();
		String numeros = "";
		char letraUser;
		char LetraDni;
		int resto = 0;

		if (dni.matches(DNI_PATTERN) && dni.length() == LONGITUD_DNI) {
			letraUser = dni.charAt(LONGITUD_DNI - 1);
			
			for (int i = 0; i < dni.length() - 1; i++) {
				if (Character.isDigit(numerosDni[i])) {
					numeros += numerosDni[i];
				}
				resto = Integer.parseInt(numeros) % 23;
				LetraDni = LETRA_DNI.charAt(resto);
				if (LetraDni == letraUser) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * ***************************************************************************************
	 * NOMBRE: cumpleRango *
	 * 
	 * DESCRIPCI�N:
	 */
	/**
	 * Comprueba que un Número se necuentra entre 2 valores
	 * 
	 * @param valor       (int)/(double) N�mero a comprobar
	 * @param valorMinimo (int) N�mero valor aceptable
	 * @param valorMaximo (int) M�N�mero valor aceptable
	 * 
	 * @return true si valorMinimo < valor < valorMaximo FECHA: Enero 2023 AUTOR:
	 *         Daniela García
	 * 
	 **************************************************************************************/
	public static boolean cumpleRango(int valor, int valorMinimo, int valorMaximo) {
		return valor > valorMinimo && valor < valorMaximo;
	}

	public static boolean cumpleRango(double valor, int valorMinimo, int valorMaximo) {
		return valor > valorMinimo && valor < valorMaximo;
	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: cumpleLongitudMin *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprobar que el texto pasado tiene una longitud de al menos x caracteres,
		 * siendo x el entero pasado como parámetro
		 * 
		 * @param texto          String texto a comprobar
		 * @param longitudMinima int que indique longitud mínima.
		 * 
		 * @return cierto, si la longitud del texto es mayor o igual que longitudMinima
		 *         FECHA: Enero 2023 AUTOR: Daniela García
		 * 
		 **************************************************************************************/
	public static boolean cumpleLongitudMin(String texto, int longitudMinima) {
		return texto.length() > longitudMinima;
	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: cumpleLongitudMax *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprobar que el texto pasado tiene una longitud de, como mucho, x
		 * caracteres, siendo x el entero pasado como par�metro
		 * 
		 * @param texto          String con el texto a comprobar
		 * @param longitudMaxima int con la longitud máxima del texto
		 * 
		 * @return true, si el texto es menor o igual que la longitud máxima. FECHA:
		 *         Enero 2023 AUTOR: Daniela García
		 * 
		 **************************************************************************************/
	public static boolean cumpleLongitudMax(String texto, int longitudMaxima) {
		return texto.length() < longitudMaxima;

	}

	/****************************************************************************************
	 * NOMBRE: cumpleLongitud *
	 * 
	 * DESCRIPCI�N:
	 */
	/**
	 * Comprobar que la longitud de un texto se encuentra entre unos valores máximos
	 * y m�nimos
	 * 
	 * @param texto          String con el texto que a validar
	 * @param longitudMinima (int) M�nima longitud del texto
	 * @param longitudMaxima (int) M�xima longitud válida para el texo
	 * 
	 * @return true, si la longitud del texto cumple: longitudMinima <=
	 *         longitudTexto <=longitudMaxima 
	 *FECHA: Febrero 2023 
	 *AUTOR: Daniela García
	 * 
	 **************************************************************************************/
	public static boolean cumpleLongitud(String texto, int longitudMinima, int longitudMaxima) {
		return longitudMinima <= texto.length() && texto.length() <= longitudMaxima;
	}

	/**
	 * Valida una fecha calendar con mínimo min
	 * 
	 * @param fecha
	 * @param min
	 * @return verdadero siempre quue la fecha no sea menor a la mínima
	 */

	public static boolean valDateMin(LocalDate fecha, LocalDate min) {
		return fecha.isAfter(min);
	}

	/**
	 * Valida una fecha calendar con máximo max
	 * 
	 * @param fecha
	 * @param max
	 * @return verdadero siempre que la fecha no sea superior a la fecha máxima
	 */
	public static boolean valDateMax(LocalDate fecha, LocalDate max) {
		return fecha.isBefore(max);
	}

	/**
	 * esFechaValida Recibe una string con formato fecha dd/mm/aaaa y comprueba el
	 * formato
	 * Confirma que el formato es correcto, nada mas.
	 * @param fecha
	 * @return verdadero siempre que no este vacío el campo y cumpla con el formato
	 *         indicado
	 */
	public static boolean esFechaValida(String fecha) {
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			LocalDate.parse(fecha,formater);
			return true;
		}catch(DateTimeParseException e) {}
		return false;
	}

	/**
	 * Nombre esPasswordValida Descripcion Comprueba que la cadena recibida cumpla
	 * con las normas de contraseña
	 * 
	 * @param password string con la contraseña introducida
	 * @return true si cumple con las especificaciones
	 */
	public static boolean esPasswordValida(String password) {
		return password.matches(PASSWORD_PATTERN) && !isVacio(password);
	}
	/**
	 * Filtro de código de producto. Debe contener:
	 * Mayúsculas (iniciales, no entre números), números, 2 letras y 3 números
	 */
	public static boolean codProducto(String codigo) {
		return codigo.matches(CODPRODUCT_PATTERN) && !isVacio(codigo);
	}
}
