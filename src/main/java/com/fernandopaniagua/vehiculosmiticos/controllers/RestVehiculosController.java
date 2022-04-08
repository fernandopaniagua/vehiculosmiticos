package com.fernandopaniagua.vehiculosmiticos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fernandopaniagua.vehiculosmiticos.entities.Vehiculo;
import com.fernandopaniagua.vehiculosmiticos.services.IVehiculoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RestVehiculosController {
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
}
