package com.fernandopaniagua.vehiculoshistoricos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandopaniagua.vehiculoshistoricos.entities.Vehiculo;
import com.fernandopaniagua.vehiculoshistoricos.repos.IVehiculosRepo;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

	@Autowired
	IVehiculosRepo vehiculosRepo;
	
	@Override
	public void create(Vehiculo v) {
		vehiculosRepo.save(v);
	}
	
	@Override
	public List<Vehiculo> readAll() {
		List<Vehiculo> vehiculos = vehiculosRepo.findAll();
		return vehiculos;
	}
	
	@Override
	public List<Vehiculo> readByMarca(String marca){
		List<Vehiculo> vehiculos = vehiculosRepo.findAllByMarca(marca);
		return vehiculos;
	}

	@Override
	public Vehiculo readById(int id) {
		Vehiculo vehiculo = vehiculosRepo.findById(id).get();
		return vehiculo;
	}

	@Override
	public void update(Vehiculo v) {
		vehiculosRepo.save(v);
	}

	@Override
	public void delete(int identificador) {
		vehiculosRepo.deleteById(identificador);
	}

	@Override
	public Integer getNumberOfPages(int vehiculosByPage) {
		Integer numberOfVehiculos = vehiculosRepo.getNumberOfVehiculos();
		float nop = (float)numberOfVehiculos/(float)vehiculosByPage;
		return (int)Math.ceil(nop);
	}

	@Override
	public void clear() {
		vehiculosRepo.clear();
	}

	@Override
	public List<Vehiculo> readRange(int initial, int offset) {
		return vehiculosRepo.getVehiculosRange(initial, offset);
	}

}
