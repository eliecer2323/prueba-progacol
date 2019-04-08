package prueba.pracmacol.crud.controller;

import java.sql.ResultSet;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import prueba.pracmacol.crud.dao.PruebaDAO;
import prueba.pracmacol.crud.dto.PruebaDTO;

@RestController
public class CrudController {
	
	PruebaDTO prueba;
	
	public CrudController() {
		 prueba = new PruebaDTO();
	}
	
	@GetMapping("/obtener/{key}")
	public String get(@PathVariable("key") String key) {
		System.out.println("Ingresa al servicio "+ key);
		JSONObject json = new JSONObject();
		json.put(key, prueba.obtenerDato(key));
		return json.toString();
	}
	
	@PostMapping("/guardar")
	public String post(@RequestBody String body) {
		JSONObject json = new JSONObject(body);
		System.out.println("Ingresa al servicio "+ body);
		JSONObject res = new JSONObject();
		prueba.insertarDato(json.getString("key"), json.getString("value"));
		res.put("OK", true);
		return res.toString();
	}
	
	@PutMapping("/modificar/{key}")
	public String put(@PathVariable("key") String key, @RequestBody String body) {
		JSONObject json = new JSONObject(body);
		System.out.println("Ingresa al servicio "+ body);
		JSONObject res = new JSONObject();
		prueba.modificarDato(key, json.getString("value"));
		res.put("OK", true);
		return res.toString();
	}
	
	@DeleteMapping("/eliminar/{key}")
	public String delete(@PathVariable("key") String key) {
		System.out.println("Ingresa al servicio "+ key);
		JSONObject res = new JSONObject();
		prueba.borrarDato(key);
		res.put("OK", true);
		return res.toString();
	}

}
