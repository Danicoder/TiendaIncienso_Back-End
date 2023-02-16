package demo.com.dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Tipo_usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id_tipo;
	@Column
	private String tipo;

	/**
	 * Lo mapeo con la relación que estableci en Usuario
	 */
	@OneToMany(mappedBy="user_tipo", cascade = CascadeType.ALL)
	private List<Usuario> listaUsuario = new ArrayList<Usuario>();

	public Tipo_usuario() {
		super();
	}

	public int getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	@Override
	public String toString() {
		return "Tipo_usuario [id_tipo=" + id_tipo + ", tipo=" + tipo + ", listaUsuario=" + listaUsuario + "]";
	}
}
