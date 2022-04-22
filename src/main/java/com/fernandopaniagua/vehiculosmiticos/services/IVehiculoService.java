package com.fernandopaniagua.vehiculosmiticos.services;

import java.util.List;

import com.fernandopaniagua.vehiculosmiticos.entities.Vehiculo;

public interface IVehiculoService {
	public List<Vehiculo> findAll();
	public List<Vehiculo> findAllByMarca(String marca);
	public void Save(Vehiculo v);
}
