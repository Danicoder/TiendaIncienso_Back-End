package demo.com.dominio;

import demo.com.util.Validator;

public interface Modelo {
	Categoria c = new Categoria();
	public default boolean isValid() {
		return !Validator.isVacio(c.getCat_nombre());
	}
}
