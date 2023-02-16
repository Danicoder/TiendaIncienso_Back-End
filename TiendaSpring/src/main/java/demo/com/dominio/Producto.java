package demo.com.dominio;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import demo.com.exception.DomainException;
import demo.com.util.Validator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

/**
 * Nombre Producto Descripcion Lista de categorías
 * 
 * @author Daniela García
 */
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(length = 5)
	private String id_producto;
	@Column(nullable = false, length = 100)
	private String pro_descripcion;
	@Column(nullable = true, length = 2000)
	private String pro_desLarga;
	@Column(nullable = false)
	private double pro_precio;
	@Column(nullable = true)
	private int pro_stock = 0;
	@Column(nullable = true, name = "FECHA_REPOSICION")
	private LocalDate pro_fecRepos;
	@Column(nullable = true, name = "FECHA_ACTIVACION")
	private LocalDate pro_fecActi;
	@Column(nullable = true, name = "FECHA_DESACTIVACION")
	private LocalDate pro_fecDesacti;
	@Column(nullable = false)
	private String pro_uniVenta;
	@Column(nullable = true)
	private double pro_cantXUniVenta = 0;
	@Column(nullable = false)
	private String pro_uniUltNivel;
	@Column(nullable = true)
	private int id_pais;
	@Column(nullable = true)
	private String pro_usoRecomendado;
	@Column(nullable = true, name = "STOCK_RESERVADO")
	private int pro_stkReservado = 0;
	@Column(nullable = true, name = "STOCK_NIVEL_ALTO")
	private int pro_nStkAlto = 0;
	@Column(nullable = true, name = "STOCK_NIVEL_BAJO")
	private int pro_nStkBajo = 0;
	@Column(nullable = true, name = "ESTADO")
	private char pro_stat = 'A';
	
	//Relación de tabla con Categoria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_categoria")
	private Categoria id_categoria;
	
	@JsonIgnore
	@Transient
	private final LocalDate FECHA_HOY = LocalDate.now();
	@JsonIgnore
	@Transient
	private final int MAX = 5;
	@JsonIgnore
	@Transient
	private final int MIN = 5;
	@JsonIgnore
	@Transient
	private final int MAX_2 = 100;
	@JsonIgnore
	@Transient
	private final int MAX_3 = 2000;
	@JsonIgnore
	@Transient
	private final int MIN_2 = 1;

	public Producto() {
		super();
	}

	public String getId_producto() {
		return id_producto;
	}

	public void setId_producto(String id_producto) throws DomainException {
		if (Validator.cumpleLongitud(id_producto, MIN, MAX) && Validator.isAlfanumeric_Mayus(id_producto)) {
			this.id_producto = id_producto;
		} else
			throw new DomainException("Debe contener 5 carácteres cómo máximo, letras y números");
	}

	public String getPro_descripcion() {
		return pro_descripcion;
	}

	public void setPro_descripcion(String pro_descripcion) throws DomainException {
		if (Validator.cumpleLongitud(pro_descripcion, MIN, MAX_2))
			this.pro_descripcion = pro_descripcion;
		else
			throw new DomainException("Debe contener entre 5 y 100 carácteres");
	}

	public String getPro_desLarga() {
		return pro_desLarga;
	}

	public void setPro_desLarga(String pro_desLarga) throws DomainException {
		if (Validator.isAlfanumeric(pro_desLarga) && Validator.cumpleLongitud(pro_desLarga, MIN, MAX_3))
			this.pro_desLarga = pro_desLarga;
		else
			throw new DomainException("Debe contener entre 5 y 2000 carácteres, letras y números");
	}

	public double getPro_precio() {
		return pro_precio;
	}

	public void setPro_precio(double pro_precio) throws DomainException {
		if (Validator.cumpleRango(pro_precio, 0, 100)) {
			DecimalFormat df = new DecimalFormat("#.00");
			this.pro_precio = Double.parseDouble(df.format(pro_precio));
		} else {
			throw new DomainException("Debe contener como máximo 100 valores");
		}
	}

	public int getPro_stock() {
		return pro_stock;
	}

	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}

	public LocalDate getPro_fecRepos() {
		return pro_fecRepos;
	}

	public void setPro_fecRepos(LocalDate pro_fecRepos) throws DomainException {
		if (Validator.esFechaValida(pro_fecRepos.toString()) && Validator.valDateMin(pro_fecRepos, FECHA_HOY))
			this.pro_fecRepos = pro_fecRepos;
		else
			throw new DomainException("El formato de la fecha debeser de dd/mm/yyyy");
	}

	public LocalDate getPro_fecActi() {
		return pro_fecActi;
	}

	public void setPro_fecActi(LocalDate pro_fecActi) throws DomainException {
		if (Validator.valDateMin(pro_fecActi, FECHA_HOY) && Validator.esFechaValida(pro_fecActi.toString()))
			this.pro_fecActi = pro_fecActi;
		else
			throw new DomainException("El formato de la fecha debeser de dd/mm/yyyy");
	}

	public LocalDate getPro_fecDesacti() {
		return pro_fecDesacti;
	}

	/**
	 * Método que comprueba que la fecha de desactivación del producto sea mayor a
	 * la actual, así pues, sí existe la fecha de activación,esta será mayor a la
	 * fecha de activación.
	 * 
	 * @param fecha de desactivación
	 * @throws DomainException
	 */
	public void setPro_fecDesacti(LocalDate pro_fecDesacti) throws DomainException {
		if (Validator.esFechaValida(pro_fecDesacti.toString()) && (Validator.valDateMin(pro_fecDesacti, FECHA_HOY)))
			this.pro_fecDesacti = pro_fecDesacti;
		else if (pro_fecActi != null) {
			Validator.valDateMin(pro_fecDesacti, getPro_fecActi());
			this.pro_fecDesacti = pro_fecDesacti;
		}
		throw new DomainException("El formato de la fecha debeser de dd/mm/yyyy");
	}

	public String getPro_uniVenta() {
		return pro_uniVenta;
	}

	public void setPro_uniVenta(String pro_uniVenta) throws DomainException {
		this.pro_uniVenta = pro_uniVenta;
	}

	public double getPro_cantXUniVenta() {
		return pro_cantXUniVenta;
	}

	public void setPro_cantXUniVenta(double pro_cantXUniVenta) {
		DecimalFormat df = new DecimalFormat("#.00");
		this.pro_precio = Double.parseDouble(df.format(pro_cantXUniVenta));
	}

	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}

	public void setPro_uniUltNivel(String pro_uniUltNivel) {
		this.pro_uniUltNivel = pro_uniUltNivel;
	}

	public int getId_pais() {
		return id_pais;
	}

	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}

	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}

	public void setPro_usoRecomendado(String pro_usoRecomendado) {
		this.pro_usoRecomendado = pro_usoRecomendado;
	}

	public Categoria getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Categoria id_categoria) {
		this.id_categoria = id_categoria;
	}

	public int getPro_stkReservado() {
		return pro_stkReservado;
	}

	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}

	public int getPro_nStkAlto() {
		return pro_nStkAlto;
	}

	public void setPro_nStkAlto(int pro_nStkAlto) {
		this.pro_nStkAlto = pro_nStkAlto;
	}

	public int getPro_nStkBajo() {
		return pro_nStkBajo;
	}

	public void setPro_nStkBajo(int pro_nStkBajo) {
		this.pro_nStkBajo = pro_nStkBajo;
	}

	public char getPro_stat() {
		return pro_stat;
	}

	public void setPro_stat(char pro_stat) throws DomainException {
		if ((pro_stat == 'A' || pro_stat == 'B') && Validator.cumpleLongitud(id_producto + "", MIN_2, MIN_2))
			this.pro_stat = pro_stat;
		else
			throw new DomainException("Debe ser A o B solamente");
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_categoria, id_pais, id_producto, pro_cantXUniVenta, pro_desLarga, pro_descripcion,
				pro_fecActi, pro_fecDesacti, pro_fecRepos, pro_nStkAlto, pro_nStkBajo, pro_precio, pro_stat,
				pro_stkReservado, pro_stock, pro_uniUltNivel, pro_uniVenta, pro_usoRecomendado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return id_categoria == other.id_categoria && id_pais == other.id_pais
				&& Objects.equals(id_producto, other.id_producto)
				&& Double.doubleToLongBits(pro_cantXUniVenta) == Double.doubleToLongBits(other.pro_cantXUniVenta)
				&& Objects.equals(pro_desLarga, other.pro_desLarga)
				&& Objects.equals(pro_descripcion, other.pro_descripcion)
				&& Objects.equals(pro_fecActi, other.pro_fecActi)
				&& Objects.equals(pro_fecDesacti, other.pro_fecDesacti)
				&& Objects.equals(pro_fecRepos, other.pro_fecRepos) && pro_nStkAlto == other.pro_nStkAlto
				&& pro_nStkBajo == other.pro_nStkBajo
				&& Double.doubleToLongBits(pro_precio) == Double.doubleToLongBits(other.pro_precio)
				&& pro_stat == other.pro_stat && pro_stkReservado == other.pro_stkReservado
				&& pro_stock == other.pro_stock && Objects.equals(pro_uniUltNivel, other.pro_uniUltNivel)
				&& Objects.equals(pro_uniVenta, other.pro_uniVenta)
				&& Objects.equals(pro_usoRecomendado, other.pro_usoRecomendado);
	}

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", pro_descripcion=" + pro_descripcion + ", pro_desLarga="
				+ pro_desLarga + ", pro_precio=" + pro_precio + ", pro_stock=" + pro_stock + ", pro_fecRepos="
				+ pro_fecRepos + ", pro_fecActi=" + pro_fecActi + ", pro_fecDesacti=" + pro_fecDesacti
				+ ", pro_uniVenta=" + pro_uniVenta + ", pro_cantXUniVenta=" + pro_cantXUniVenta + ", pro_uniUltNivel="
				+ pro_uniUltNivel + ", id_pais=" + id_pais + ", pro_usoRecomendado=" + pro_usoRecomendado
				+ ", id_categoria=" + id_categoria + ", pro_stkReservado=" + pro_stkReservado + ", pro_nStkAlto="
				+ pro_nStkAlto + ", pro_nStkBajo=" + pro_nStkBajo + ", pro_stat=" + pro_stat + "]";
	}
}
