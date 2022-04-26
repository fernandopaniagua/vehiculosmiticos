package com.fernandopaniagua.vehiculosmiticos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping(path = "/vehiculos", produces = { MediaType.APPLICATION_JSON_VALUE })
	Respuesta addVehiculo(
			@RequestParam(required=true) String nombre,
			@RequestParam(required=true) String descripcion,
			@RequestParam(required=true) String imagen){
		vehiculoService.create(new Vehiculo(0, nombre, descripcion, imagen));
		return new Respuesta(0,"OK");
	}
	
	@GetMapping(path = "/vehiculos", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Vehiculo> getVehiculos() {
		return vehiculoService.readAll();
	}
	
	@GetMapping(path = "/vehiculos/findByMarca", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Vehiculo> getVehiculosByMarca(@RequestParam(required = true) String marca) {
		return vehiculoService.readByMarca(marca);
	}
	
	@GetMapping(path = "/vehiculos/findById", produces = { MediaType.APPLICATION_JSON_VALUE })
	Vehiculo getVehiculoById(@RequestParam(required = true) Integer id) {
		return vehiculoService.readById(id);
	}
	
	@PutMapping(path = "/vehiculos", produces = { MediaType.APPLICATION_JSON_VALUE })
	Respuesta updateVehiculo(
			@RequestParam(required=true) Integer id,
			@RequestParam(required=true) String nombre,
			@RequestParam(required=true) String descripcion,
			@RequestParam(required=true) String imagen){
		vehiculoService.update(new Vehiculo(id, nombre, descripcion, imagen));
		return new Respuesta(0,"OK");
	}
	
	@DeleteMapping(path = "/vehiculos", produces = { MediaType.APPLICATION_JSON_VALUE })
	Respuesta updateVehiculos(@RequestParam(required=true) Integer id) {
		vehiculoService.delete(id);
		return new Respuesta(0,"OK");
	}
	
	@DeleteMapping(path = "vehiculos/clear", produces = {MediaType.APPLICATION_JSON_VALUE })
	Respuesta clearGreaterThan110() {
		vehiculoService.clear();
		return new Respuesta(0,"OK");	
	}
	
	@GetMapping(path ="/vehiculos/numberOfPages", produces = { MediaType.APPLICATION_JSON_VALUE })
	Respuesta getNumberOfPages(@RequestParam(required=true) Integer vehiculosByPage) {
		return new Respuesta(0, String.valueOf(vehiculoService.getNumberOfPages(vehiculosByPage)));
	}
	
	@GetMapping(path ="/vehiculos/range", produces = {MediaType.APPLICATION_JSON_VALUE })
	List<Vehiculo> getRange(@RequestParam(required=true) Integer initial, @RequestParam(required=true) Integer offset) {
		return vehiculoService.readRange(initial, offset);
	}
}
