package demo.com.exception;
/**
 * Controla los erroes sí trabajo en dominios 
 * y voy pasando comunicaciones al mismo.
 * Puede ser el caso de un resultado Null.
 * @author Daniela García Millán
 */
@SuppressWarnings("serial")
public class DomainException extends Exception {
	public DomainException(){}
	public DomainException(String msj) {
		super("Domain: " + msj);
	}
}
