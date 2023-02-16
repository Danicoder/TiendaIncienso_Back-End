package demo.com.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import demo.com.dominio.Categoria;

/**
 * Controla los erroes sí trabajo en dominios 
 * y voy pasando comunicaciones al mismo.
 * Puede ser el caso de un resultado Null.
 * @author Daniela García Millán
 */
@SuppressWarnings("serial")
public class ControllerException extends Exception{

	public ControllerException(){}
	public ControllerException(String msj) {
		super(msj);
	}
	public static Map<String, Object> montaError(int code, Categoria cat) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("Estado", code);
		map.put("Datos", cat);
		return map;
	}
}
