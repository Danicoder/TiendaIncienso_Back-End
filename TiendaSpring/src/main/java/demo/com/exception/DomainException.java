package demo.com.exception;

@SuppressWarnings("serial")
public class DomainException extends Exception {
	public DomainException(){}
	public DomainException(String msj) {
		super("Domain: " + msj);
	}
}
