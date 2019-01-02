package co.com.ceiba.parking.repository;


import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.parking.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long>{

	Vehicle findByPlate(String plate);
	
	
}
