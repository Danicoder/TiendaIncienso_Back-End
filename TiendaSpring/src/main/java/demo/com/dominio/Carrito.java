package demo.com.dominio;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//colocar cantidad,codigo y precio como array
//el objeto de línea pedido se engancha a una colección
public class Carrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id_pedido;
	@Column(nullable = false)
	private int id_usuario;
	@Column(nullable = false)
	private String id_producto;
	@Column(nullable = false)
	private int car_cantidad;
	@Column(nullable = true)
	private int car_precio;
	@Column(nullable = true)
	private int car_envio;
	@Column(nullable = true)
	private int car_pago;
	@Column(nullable = true, length = 16)
	private int car_tarjeta;
	@Column(nullable = true)
	private int car_feCaducidad;
	@Column(nullable = true, length = 3)
	private int car_ccvTarjeta;
	@Column(nullable = true)
	private int car_nombre;
	@Column(nullable = true)
	private int car_stat;
	@Column(nullable = true)
	private int car_feCambio;
	
	transient private Usuario id_user;
	
	public Carrito() {
		super();
	}

	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		if(id_user.getId_usuario() > 0) {
			this.id_usuario = id_usuario;
		}
	}
	public String getId_producto() {
		return id_producto;
	}
	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}
	public int getCar_cantidad() {
		return car_cantidad;
	}
	public void setCar_cantidad(int car_cantidad) {
		this.car_cantidad = car_cantidad;
	}
	public int getCar_precio() {
		return car_precio;
	}
	public void setCar_precio(int car_precio) {
		this.car_precio = car_precio;
	}
	public int getCar_envio() {
		return car_envio;
	}
	public void setCar_envio(int car_envio) {
		this.car_envio = car_envio;
	}
	public int getCar_pago() {
		return car_pago;
	}
	public void setCar_pago(int car_pago) {
		this.car_pago = car_pago;
	}
	public int getCar_tarjeta() {
		return car_tarjeta;
	}
	public void setCar_tarjeta(int car_tarjeta) {
		this.car_tarjeta = car_tarjeta;
	}
	public int getCar_feCaducidad() {
		return car_feCaducidad;
	}
	public void setCar_feCaducidad(int car_feCaducidad) {
		this.car_feCaducidad = car_feCaducidad;
	}
	public int getCar_ccvTarjeta() {
		return car_ccvTarjeta;
	}
	public void setCar_ccvTarjeta(int car_ccvTarjeta) {
		this.car_ccvTarjeta = car_ccvTarjeta;
	}
	public int getCar_nombre() {
		return car_nombre;
	}
	public void setCar_nombre(int car_nombre) {
		this.car_nombre = car_nombre;
	}
	public int getCar_stat() {
		return car_stat;
	}
	public void setCar_stat(int car_stat) {
		this.car_stat = car_stat;
	}
	public int getCar_feCambio() {
		return car_feCambio;
	}
	public void setCar_feCambio(int car_feCambio) {
		this.car_feCambio = car_feCambio;
	}
	@Override
	public int hashCode() {
		return Objects.hash(car_cantidad, car_ccvTarjeta, car_envio, car_feCaducidad, car_feCambio, car_nombre,
				car_pago, car_precio, car_stat, car_tarjeta, id_pedido, id_producto, id_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrito other = (Carrito) obj;
		return car_cantidad == other.car_cantidad && car_ccvTarjeta == other.car_ccvTarjeta
				&& car_envio == other.car_envio && car_feCaducidad == other.car_feCaducidad
				&& car_feCambio == other.car_feCambio && car_nombre == other.car_nombre && car_pago == other.car_pago
				&& car_precio == other.car_precio && car_stat == other.car_stat && car_tarjeta == other.car_tarjeta
				&& id_pedido == other.id_pedido && Objects.equals(id_producto, other.id_producto)
				&& id_usuario == other.id_usuario;
	}

	@Override
	public String toString() {
		return "Carrito [id_pedido=" + id_pedido + ", id_usuario=" + id_usuario + ", id_producto=" + id_producto
				+ ", car_cantidad=" + car_cantidad + ", car_precio=" + car_precio + ", car_envio=" + car_envio
				+ ", car_pago=" + car_pago + ", car_tarjeta=" + car_tarjeta + ", car_feCaducidad=" + car_feCaducidad
				+ ", car_ccvTarjeta=" + car_ccvTarjeta + ", car_nombre=" + car_nombre + ", car_stat=" + car_stat
				+ ", car_feCambio=" + car_feCambio + "]";
	}
	
	/**
	 * Método que añade al carrito
	 */
	public void añadirCarrito() {
		
	}
	/**
	 * Método que elimina el carrito
	 */
	public void EliminarCarrito() {
		
	}
}
