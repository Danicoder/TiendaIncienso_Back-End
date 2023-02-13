package demo.com.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import demo.com.util.Validator;
import jakarta.persistence.Transient;

public interface Modelo {
	static Categoria c = new Categoria();
	@JsonIgnore	
	@Transient
	public default boolean isValid() {
		return !Validator.isVacio(c.getCat_nombre());
	}
}
