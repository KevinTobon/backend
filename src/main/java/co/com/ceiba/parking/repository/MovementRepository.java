package co.com.ceiba.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.ceiba.parking.entity.Movement;

@Repository("movementRepository")
public interface MovementRepository extends JpaRepository<Movement, Long>{

	@Query(
			value = "SELECT COUNT(*) FROM Movement m LEFT OUTER JOIN VehicleEntity v ON v.placa = m.plate WHERE v.tipe = ?1 AND m.exitDate IS null",
			nativeQuery = true)
	
	public int consultQuantityVehicleByType(String type);
	
	@Query(
			value = "SELECT * FROM Movement m LEFT OUTER JOIN VehicleEntity v ON v.plate = m.plate WHERE m.plate = ?1",
			nativeQuery = true)
	public Movement consultMovementyPlate(String plate);
	
	
	@Query(
			value = "SELECT * FROM Movement m LEFT OUTER JOIN VehicleEntity v ON v.plate = m.plate WHERE m.exitDate IS null",
			nativeQuery = true)
	public List<Movement> consultMovementActivated();

}
