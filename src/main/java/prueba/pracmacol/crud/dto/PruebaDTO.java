package prueba.pracmacol.crud.dto;

import java.util.Map;

import prueba.pracmacol.crud.dao.PruebaDAO;

public class PruebaDTO {
	
	private PruebaDAO prueba;
	
	public PruebaDTO() {
		prueba = new PruebaDAO();
	}
	
	public String obtenerDato(String key) {
		return prueba.getObjeto().get(key);
	}
	
	public void insertarDato(String key, String value) {
		prueba.getObjeto().put(key, value);
	}
	
	public void modificarDato(String key, String value) {
		prueba.getObjeto().put(key, value);
	}
	
	public void borrarDato (String key) {
		prueba.getObjeto().remove(key);
	}

}
