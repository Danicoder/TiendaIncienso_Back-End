package demo.com.dominio;

import java.util.Objects;

import demo.com.exception.DomainException;
import demo.com.util.ErrorMessages;
import demo.com.util.Validator;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

/**
 * Nombre Direccion Descripcion Lista de categorías
 * 
 * @author Daniela García
 */
@Embeddable //indicamos que la clase puede ser integrada dentro de una entidad
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String dir_nombre;
	@Column(nullable = true)
	private String dir_direccion;
	@Column(nullable = true)
	private String dir_poblacion;
	@Column(nullable = true)
	private String dir_cPostal;
	@Column(nullable = true)
	private String dir_provincia;
	@Column(nullable = true)
	private int id_pais;
	@Column(nullable = true)
	private String dir_correoE;
	@Transient // transient porqué no siempre se tendrá acceso al valor de la variable
	private Pais dir_pais; 
	
	public Direccion() {
		super();
	}

	/**
	 * Getter para el nombre de la dirección
	 * 
	 * @return String con el nombre de la dirección
	 */
	public String getDir_nombre() {
		return dir_nombre;
	}

	/**
	 * Setter para el nombre
	 * 
	 * @param dir_nombre
	 * @throws Exception
	 */
	public void setDir_nombre(String dir_nombre) throws Exception {
		if (Validator.cumpleLongitud(dir_nombre, 5, 100))
			this.dir_nombre = dir_nombre;
		else
			throw new Exception(ErrorMessages.PROERR_005);
	}

	/**
	 * Getter para la dirección
	 * 
	 * @return String con el nombre
	 * @throws DomainException
	 */
	public String getDir_direccion() throws DomainException {
		return dir_direccion;

	}

	/**
	 * Setter para la dirección
	 * 
	 * @param dir_direccion
	 * @throws Exception
	 */
	public void setDir_direccion(String dir_direccion) throws Exception {
		this.dir_direccion = dir_direccion;
	}

	/**
	 * Getter para la población
	 * 
	 * @return String con el nombre de la población
	 */
	public String getDir_poblacion() {
		return dir_poblacion;
	}

	/**
	 * Setter para la población
	 * 
	 * @param dir_poblacion
	 * @throws Exception
	 */
	public void setDir_poblacion(String dir_poblacion) throws Exception {
		this.dir_poblacion = dir_poblacion;
	}

	/**
	 * Getter para el código postal
	 * 
	 * @return String del código postal
	 */
	public String getDir_cPostal() {
		return dir_cPostal;
	}

	/**
	 * Setter para el código postal
	 * 
	 * @param dir_cPostal
	 * @throws Exception
	 */
	public void setDir_cPostal(String dir_cPostal) throws Exception {
		this.dir_cPostal = dir_cPostal;
	}

	/**
	 * Getter que devuevle la provincia
	 * 
	 * @return la provincia
	 */
	public String getDir_provincia() {
		return dir_provincia;
	}

	/**
	 * Setter para la provincia
	 * 
	 * @param dir_provincia
	 * @throws Exception
	 */
	public void setDir_provincia(String dir_provincia) throws Exception {
		this.dir_provincia = dir_provincia;
	}

	/**
	 * Getter que devuelve el país
	 * 
	 * @return el país
	 */
	public Pais getDir_pais() {
		return dir_pais;
	}

	/**
	 * Setter para el país
	 * 
	 * @param dir_pais
	 * @throws Exception
	 */
	public void setDir_pais(int id_pais) throws Exception {
		this.id_pais = id_pais;
	}

	/**
	 * Getter que devuelve un String del e-mail
	 * 
	 * @return
	 */
	public String getDir_correoE() {
		return dir_correoE;
	}

	/**
	 * Setter para el a-mail
	 * 
	 * @param dir_correoE
	 * @throws Exception
	 */
	public void setDir_correoE(String dir_correoE) throws Exception {
		if (Validator.isEmailValido(dir_correoE))
			this.dir_correoE = dir_correoE;
		else
			throw new Exception(ErrorMessages.PROERR_007);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dir_cPostal, dir_correoE, dir_direccion, dir_nombre, dir_pais, dir_poblacion,
				dir_provincia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return Objects.equals(dir_cPostal, other.dir_cPostal) && Objects.equals(dir_correoE, other.dir_correoE)
				&& Objects.equals(dir_direccion, other.dir_direccion) && Objects.equals(dir_nombre, other.dir_nombre)
				&& Objects.equals(dir_pais, other.dir_pais) && Objects.equals(dir_poblacion, other.dir_poblacion)
				&& Objects.equals(dir_provincia, other.dir_provincia);
	}

	@Override
	public String toString() {
		return "Direccion [dir_nombre=" + dir_nombre + ", dir_direccion=" + dir_direccion + ", dir_poblacion="
				+ dir_poblacion + ", dir_cPostal=" + dir_cPostal + ", dir_provincia=" + dir_provincia + ", dir_pais="
				+ dir_pais + ", dir_correoE=" + dir_correoE + "]";
	}
}
