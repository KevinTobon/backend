package co.com.ceiba.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.ceiba.parking.entity.Movement;
import co.com.ceiba.parking.entity.VehicleEntity;

@Repository("movementRepository")
public interface MovementRepository extends JpaRepository<VehicleEntity, Long>{

	@Query(
			value = "SELECT COUNT(*) FROM Movement m LEFT OUTER JOIN VehicleEntity v ON v.placa = m.plate WHERE v.tipe = ?1 AND m.exitDate IS null",
			nativeQuery = true)
	
	public int consultQuantityVehicleByType(String type);
	
	public Movement consultMovementyPlate(String plate);
	
	public List<Movement> consultMovementActivated();
}
