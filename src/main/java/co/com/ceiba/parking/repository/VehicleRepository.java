package co.com.ceiba.parking.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.parking.entity.VehicleEntity;

@Repository("vehicleRepository")
public interface VehicleRepository extends JpaRepository<VehicleEntity, String>{

	VehicleEntity findByPlate(String plate);
	List<VehicleEntity> findByType(String type);
}
