package demo.com.exception;
/**
 * Controlo los problemas de acceso a BD
 * Cómo puedes ser una IOEXCEPTION o un registro no existente.
 * @author Daniela García Millán
 */
@SuppressWarnings("serial")
public class DAOException extends Exception {
	DAOException(){}
	public DAOException(String msj) {
		super("DAO: " + msj);
	}
}