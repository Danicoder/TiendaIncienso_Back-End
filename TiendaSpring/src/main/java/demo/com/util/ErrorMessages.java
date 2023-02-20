package demo.com.util;


/* *****************************************************
 * NOMBRE: ErrorMessages.java
 * 
 * DESCRIPCION:  
 * 			Clase con los String que contienen los mensajes de error 
 * 			especificados por las reglas de negocio.
 * 
 *  @author 	Daniela Garcia
 *  
 *  *****************************************************/
public class ErrorMessages {	
	/**
	 * Codigo erroneo
	 */
	public final static String PROERR_000 = "Formato correcto";
	public final static String PROERR_001 = "Formato codigo erroneo";
	public final static String PROERR_002 = "Longitud de codigo erroneo o inexistente";
	
	/**
	 * Campo con longitud erronea
	 */
	public final static String PROERR_003 = "La longitud de nombre ha de estar entre 5 y 50";
	public final static String PROERR_004 = "El texto debe contener menos de 200 caracteres";
	public final static String PROERR_005 = "El nombre ha de contener entre 5 y 100 caracteres";
	public final static String PROERR_006 = "Debe ser minúscula, mayúscula con dígitos entre 0 y 9. Evita los puntos finales antes del @";
	public final static String PROERR_007 = "La longitud de nombre ha de estar entre 5 y 100";
	
	/**
	 * Campo de mensajes de error
	 */
	public final static String PROERR_008 = "La categoria no se ha definido";
	public final static String PROERR_009 = "La id no se ha definido";
	public final static String PROERR_010 = "La id de la categoria no esta definida correctamente";
	public final static String PROERR_011 = "La id o la categoria no se han definido correctamente";
	public final static String PROERR_012 = "Formato de escritura incorrecto, revisa la URL";
	public final static String PROERR_013 = "Formato de escritura correcto";
	public final static String PROERR_014 = "Se elimino la categoria correctamente";
}
