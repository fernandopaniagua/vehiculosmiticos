package com.fernandopaniagua.vehiculosmiticos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandopaniagua.vehiculosmiticos.entities.Vehiculo;
import com.fernandopaniagua.vehiculosmiticos.repos.IVehiculosRepo;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

	@Autowired
	IVehiculosRepo vehiculosRepo;
	
	@Override
	public List<Vehiculo> findAll() {
		List<Vehiculo> vehiculos = vehiculosRepo.findAll();
		return vehiculos;
	}
	
	@Override
	public List<Vehiculo> findAllByMarca(String marca){
		List<Vehiculo> vehiculos = vehiculosRepo.findAllByMarca(marca);
		return vehiculos;
	}
}
