package co.com.ceiba.parking.service;

import java.util.List;

import co.com.ceiba.parking.dto.MovementDTO;

public interface MovementService {

public String registerMovement(MovementDTO movement);
	
	public int consultQuantityVehicleByType(String typeVehicle);
	
	public MovementDTO consultMovementyPlate(String plate);

	public List<MovementDTO> consultMovementActivated();
}
