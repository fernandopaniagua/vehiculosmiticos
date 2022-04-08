package com.fernandopaniagua.vehiculosmiticos.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernandopaniagua.vehiculosmiticos.entities.Vehiculo;

public interface IVehiculosRepo extends JpaRepository<Vehiculo, Integer>{

}
