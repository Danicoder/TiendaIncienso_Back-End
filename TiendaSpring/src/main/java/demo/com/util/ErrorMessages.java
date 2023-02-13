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
	 * Codigo de producto
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
	public final static String PROERR_006 = "Debe ser minúscula, mayúscula con dígitos entre 0 y 9";
	public final static String PROERR_007 = "Debe ser minúscula, mayúscula con dígitos entre 0 y 9. Evita los puntos finales antes del @";
	public final static String PROERR_008 = "La longitud de nombre ha de estar entre 5 y 100";
	public final static String PROERR_009 = "No se encontro la categoria con esa id";
	public final static String PROERR_010 = "Se ha actualizado correctamente la categoria";
	public final static String PROERR_011 = "Ocurrio un error al eliminar la categoria, verifica la id";
	public final static String PROERR_012 = "No se encontro la categoria";
	public final static String PROERR_013 = "Eliminado correctamente";
}
