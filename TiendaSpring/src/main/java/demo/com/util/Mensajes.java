package demo.com.util;

import demo.com.dominio.Categoria;

public class Mensajes {
	public String codigo;
	public String mensaje;
	public Categoria categoria;
	
	public static Mensajes mensaje(String error, String mensaje, Categoria c) {
		Mensajes resp = new Mensajes();
		resp.codigo = error;
		resp.mensaje = mensaje;
		resp.categoria = c;
		return resp;
	}
}
