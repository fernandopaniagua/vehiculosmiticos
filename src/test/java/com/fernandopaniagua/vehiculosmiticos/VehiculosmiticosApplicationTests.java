package com.fernandopaniagua.vehiculosmiticos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fernandopaniagua.vehiculosmiticos.entities.Vehiculo;
import com.fernandopaniagua.vehiculosmiticos.repos.IVehiculosRepo;
import com.fernandopaniagua.vehiculosmiticos.services.IVehiculoService;

import java.util.List;


@SpringBootTest
class VehiculosmiticosApplicationTests {

	@Autowired
	IVehiculosRepo vehiculosRepo;
	@Autowired
	IVehiculoService vehiculosService;
	
	
	void findAllVehiculos() {
		List<Vehiculo> vehiculos = vehiculosRepo.findAll();	
		for (Vehiculo vehiculo : vehiculos) {
			System.out.println(vehiculo.getNombre());
		}
	}
	
	
	void findAllVehiculosServicio() {
		List<Vehiculo> vehiculos = vehiculosService.findAll();	
		for (Vehiculo vehiculo : vehiculos) {
			System.out.println(vehiculo.getNombre());
		}
	}
	
	@Test
	void findAllVehiculosServicioByMarca() {
		List<Vehiculo> vehiculos = vehiculosService.findAllByMarca("Nissan");	
		for (Vehiculo vehiculo : vehiculos) {
			System.out.println(vehiculo.getNombre());
		}
	}
	
}
