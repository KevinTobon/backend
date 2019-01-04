package co.com.ceiba.parking.util;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.entity.Movement;
import co.com.ceiba.parking.entity.VehicleEntity;

public class mapDTO {

	public Movement convertMovementDomain(MovementDTO movementDTO) {
		Movement movement = new Movement();
		movement.setId(movementDTO.getId());
		movement.setEntryDate(movementDTO.getEntryDate());
		movement.setExitDate(movementDTO.getExitDate());
		movement.setPrice(movementDTO.getPrice());
		movement.setVehicleEntity(new VehicleEntity(movementDTO.getPlate(), movementDTO.getTypeVehicle(), movementDTO.getDisplacement()));
		return movement;
	}
	
	public MovementDTO convertToMovementEntity(Movement movement) {
		MovementDTO movementDTO = new MovementDTO();
		movementDTO.setId(movement.getId());
		movementDTO.setPrice(movement.getPrice());
		movementDTO.setDisplacement(movement.getVehicleEntity().getDisplacement());
		movementDTO.setEntryDate(movement.getEntryDate());
		movementDTO.setExitDate(movement.getExitDate());
		movementDTO.setPlate(movement.getVehicleEntity().getPlate());
		movementDTO.setTypeVehicle(movement.getVehicleEntity().getType());
		
		return movementDTO;
	}
}
