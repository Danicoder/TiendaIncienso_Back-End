 package demo.com.dominio;

import java.time.LocalDate;
import java.util.Objects;

import demo.com.exception.DomainException;
import demo.com.util.Validator;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Nombre Usuario Descripcion Lista de categorías
 * 
 * @author Daniela García
 */
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id_usuario; 									// Identificador de usuario
	@Column(nullable = false, length = 100)
	private String user_nombre; 								// nombre de usuario
	@Column(nullable = false, length = 100, unique = true)
	private String user_email; 									// correo electrónico del usuario
	@Column(nullable = false, length = 20, name = "PASSWORD")
	private String user_pass; 									// Contraseña del usuario
	@Column(nullable = true, length = 12)
	private String user_dni; 									// DNI del usuario
	@Column(nullable = true, name = "FECHA_ALTA")
	private LocalDate user_fecAlta; 							// Fecha de alta del usuario
	@Column(nullable = true, name = "FECHA_CONFIRMACION")
	private LocalDate user_fecConfirmacion; 					// Fecha de confirmación del usuario
	
	/**
	 * Relación con la clase Usuario de muchos a uno,
	 * puesto que un tipo de usuario pertenece a muchos 
	 * usuarios.
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TIPO_USUARIO")
	private Usuario user_tipo; 										// Tipo de usuario
	
	/**
	 * Forma de insertar en la tabla usuario las direcciones de cada usuario
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "dir_nombre", column = @Column(name = "nombreDireccionEnvio")),
			@AttributeOverride(name = "dir_direccion", column = @Column(name = "dir_direccion_envio")),
			@AttributeOverride(name = "dir_poblacion", column = @Column(name = "dir_poblacion_envio")),
			@AttributeOverride(name = "dir_cPostal", column = @Column(name = "dir_cPostal_envio")),
			@AttributeOverride(name = "dir_provincia", column = @Column(name = "dir_provincia_envio")),
			@AttributeOverride(name = "dir_pais", column = @Column(name = "dir_pais_envio")),
			@AttributeOverride(name = "dir_correoE", column = @Column(name = "dir_correoE_envio")) })

	private Direccion user_envio; //Datos de la dirección de envío del usuario
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "dir_nombre", column = @Column(name = "nombreFacturaPagada")),
			@AttributeOverride(name = "dir_direccion", column = @Column(name = "direccion_pago")),
			@AttributeOverride(name = "dir_poblacion", column = @Column(name = "poblacion_pago")),
			@AttributeOverride(name = "dir_cPostal", column = @Column(name = "cPostal_pago")),
			@AttributeOverride(name = "dir_provincia", column = @Column(name = "provincia_pago")),
			@AttributeOverride(name = "dir_pais", column = @Column(name = "pais_pago")),
			@AttributeOverride(name = "dir_correoE", column = @Column(name = "correoE_pago")) })
	private Direccion user_pago; //Datos de la dirección de pago del usuario

	private final int MIN_1 = 5;
	private final int MAX_1 = 100;
	private final int MIN_2 = 6;
	private final int MAX_2 = 20;
	private final int MIN_3 = 8;
	private final int MIN_4 = 12;
	private final LocalDate FECHA_ACTUAL = LocalDate.now();

	public Usuario() {
		super();
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUser_nombre() {
		return user_nombre;
	}

	public void setUser_nombre(String user_nombre) throws DomainException {
		if (Validator.cumpleLongitud(user_nombre, MIN_1, MAX_1))
			this.user_nombre = user_nombre;
		else
			throw new DomainException("El nombre debe contener entre 5 y 100 carácteres");
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) throws DomainException {
		if (Validator.isEmailValido(user_email) && Validator.cumpleLongitud(user_email, MIN_2, MAX_1))
			this.user_email = user_email;
		else
			throw new DomainException("El nombre debe contener entre 5 y 100 carácteres");
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) throws DomainException {
		if (Validator.esPasswordValida(user_pass) && Validator.cumpleLongitud(user_pass, MIN_3, MAX_2))
			this.user_pass = user_pass;
		else
			throw new DomainException("La constraseña a de tener al menos 1 número, 1 letra y un carácter especial");
	}

	public Usuario getUser_tipo() {
		return user_tipo;
	}

	public void setUser_tipo(Usuario user_tipo) {
		this.user_tipo = user_tipo;
	}

	public String getUser_dni() {
		return user_dni;
	}

	public void setUser_dni(String user_dni) throws DomainException {
		if (Validator.cumpleDNI(user_dni) && Validator.cumpleLongitud(user_dni, MIN_4, MIN_4))
			this.user_dni = user_dni;
		else
			throw new DomainException("El DNI debe cumplir con el formato xx.xxx.xxx-X");
	}

	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}

	public void setUser_fecAlta(LocalDate user_fecAlta) throws DomainException {
		if (Validator.esFechaValida(user_fecAlta.toString()) && user_fecAlta.equals(FECHA_ACTUAL))
			this.user_fecAlta = user_fecAlta;
		else
			throw new DomainException("Fecha de alta incorrecta");
	}

	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}

	public void setUser_fecConfirmacion(LocalDate user_fecConfirmacion) throws DomainException {
		if (Validator.esFechaValida(user_fecAlta.toString()) && user_fecConfirmacion.equals(FECHA_ACTUAL))
			this.user_fecConfirmacion = user_fecConfirmacion;
		else
			throw new DomainException("Fecha de confirmación incorrecta");
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_usuario, user_dni, user_email, user_fecAlta, user_fecConfirmacion, user_nombre,
				user_pass, user_tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return id_usuario == other.id_usuario && Objects.equals(user_dni, other.user_dni)
				&& Objects.equals(user_email, other.user_email) && Objects.equals(user_fecAlta, other.user_fecAlta)
				&& Objects.equals(user_fecConfirmacion, other.user_fecConfirmacion)
				&& Objects.equals(user_nombre, other.user_nombre) && Objects.equals(user_pass, other.user_pass)
				&& user_tipo == other.user_tipo;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", user_nombre=" + user_nombre + ", user_email=" + user_email
				+ ", user_pass=" + user_pass + ", user_tipo=" + user_tipo + ", user_dni=" + user_dni + ", user_fecAlta="
				+ user_fecAlta + ", user_fecConfirmacion=" + user_fecConfirmacion + "]";
	}
}
