package com.fernandopaniagua.vehiculosmiticos.services;

import java.util.List;

import com.fernandopaniagua.vehiculosmiticos.entities.Vehiculo;

public interface IVehiculoService {
	public List<Vehiculo> findAll();
}
