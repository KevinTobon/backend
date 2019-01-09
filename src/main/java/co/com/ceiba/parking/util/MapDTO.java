package co.com.ceiba.parking.util;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.entity.Movement;
import co.com.ceiba.parking.entity.Vehicle;

public class MapDTO {

	public Movement convertMovementDTO(MovementDTO movementDTO) {
		Movement movement = new Movement();
		movement.setId(movementDTO.getId());
		movement.setEntryDate(movementDTO.getEntryDate());
		movement.setExitDate(movementDTO.getExitDate());
		movement.setPrice(movementDTO.getPrice());
		movement.setVehicle(new Vehicle(movementDTO.getPlate(), movementDTO.getTypeVehicle(), movementDTO.getDisplacement()));
		
		return movement;
	}
	
	public MovementDTO convertToMovementEntity(Movement movement) {
		MovementDTO movementDTO = new MovementDTO();
		movementDTO.setId(movement.getId());
		movementDTO.setPrice(movement.getPrice());
		movementDTO.setDisplacement(movement.getVehicle().getDisplacement());
		movementDTO.setEntryDate(movement.getEntryDate());
		movementDTO.setExitDate(movement.getExitDate());
		movementDTO.setPlate(movement.getVehicle().getPlate());
		movementDTO.setTypeVehicle(movement.getVehicle().getType());
		
		return movementDTO;
	}
}
