package com.fernandopaniagua.vehiculosmiticos.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fernandopaniagua.vehiculosmiticos.entities.Vehiculo;

public interface IVehiculosRepo extends JpaRepository<Vehiculo, Integer>{
	@Query ("select v from vehiculos v where nombre like %:marca%")
	List<Vehiculo> findAllByMarca(String marca);
}
