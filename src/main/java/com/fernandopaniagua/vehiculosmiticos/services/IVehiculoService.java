package com.fernandopaniagua.vehiculosmiticos.services;

import java.util.List;

import com.fernandopaniagua.vehiculosmiticos.entities.Vehiculo;

public interface IVehiculoService {
	public void create(Vehiculo v);
	public List<Vehiculo> readAll();
	public Vehiculo readById(int id);
	public void update(Vehiculo v);
	public void delete(int identificador);
	
	public List<Vehiculo> readByMarca(String marca);
	public void clear();
	
	public Integer getNumberOfPages(int vehiculosByPage);
	/**
	 * Obtiene un conjunto de registros dada una posición y un offset.
	 * 
	 * @param initial Primer registro (el primero es 0)
	 * @param offset Número de registros
	 * @return Listado de vehículos
	 */
	public List<Vehiculo> readRange(int initial, int offset);
}
