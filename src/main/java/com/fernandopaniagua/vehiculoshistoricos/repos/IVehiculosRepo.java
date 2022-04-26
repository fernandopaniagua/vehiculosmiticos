package com.fernandopaniagua.vehiculoshistoricos.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.fernandopaniagua.vehiculoshistoricos.entities.Vehiculo;


public interface IVehiculosRepo extends JpaRepository<Vehiculo, Integer>{
	@Query("select v from vehiculos v where nombre like %:marca%")
	List<Vehiculo> findAllByMarca(String marca);
	
	@Transactional
	@Modifying
	@Query("delete from vehiculos where id>101")
	void clear();
	
	@Query("select count(*) from vehiculos")
	Integer getNumberOfVehiculos();
	
	@Query(nativeQuery = true, value = "select * from vehiculos limit :initial,:offset")
	List<Vehiculo> getVehiculosRange(int initial, int offset);
	
	//@Query(nativeQuery = true, value = "SELECT * FROM SLSNotification s WHERE s.userId = :userId ORDER BY snumber DESC LIMIT 20")
	//List<SLSNotification> getUserIdforManage(@Param("userId") String userId);
}
