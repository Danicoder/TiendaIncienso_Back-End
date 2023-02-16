package demo.com.dominio;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id_pais;
	private String pais_nombre;
	
	public Pais() {
		super();
	}
	
	public int getId_pais() {
		return id_pais;
	}
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}
	public String getPais_nombre() {
		return pais_nombre;
	}
	public void setPais_nombre(String pais_nombre) {
		this.pais_nombre = pais_nombre;
	}
	@Override
	public String toString() {
		return "Pais [id_pais=" + id_pais + ", pais_nombre=" + pais_nombre + "]";
	}
}
