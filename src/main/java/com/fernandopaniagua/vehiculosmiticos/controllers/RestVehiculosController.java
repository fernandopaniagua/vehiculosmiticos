package com.fernandopaniagua.vehiculosmiticos.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fernandopaniagua.vehiculosmiticos.entities.Vehiculo;
import com.fernandopaniagua.vehiculosmiticos.services.IVehiculoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RestVehiculosController {
	class Respuesta {
		int code;
		String message;
		public Respuesta() {}
		public Respuesta(int code, String message) {
			super();
			this.code = code;
			this.message = message;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	}
	
	
	@Autowired
	IVehiculoService vehiculoService;
	
	@GetMapping(path = "/vehiculos", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Vehiculo> getVehiculos() {
		return vehiculoService.findAll();
	}
	
	@GetMapping(path = "/vehiculos/findByMarca", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Vehiculo> getVehiculosByMarca(@RequestParam(required = true) String marca) {
		return vehiculoService.findAllByMarca(marca);
	}
	
	@PostMapping(path = "/vehiculos", produces = { MediaType.APPLICATION_JSON_VALUE })
	Respuesta addVehiculo(
			@RequestParam(required=true) String nombre,
			@RequestParam(required=true) String descripcion,
			@RequestParam(required=true) String imagen){
		vehiculoService.Save(new Vehiculo(0, nombre, descripcion, imagen));
		return new Respuesta(0,"OK");
	}
}
