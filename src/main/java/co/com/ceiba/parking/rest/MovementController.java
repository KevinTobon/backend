package co.com.ceiba.parking.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.service.MovementService;

@RestController
@RequestMapping("/movemenet")
public class MovementController {

	@Autowired
	MovementService movementService;
	
	@RequestMapping("/register_movement")
	public String registerMovement(@RequestBody MovementDTO movementDTO) {
		return movementService.registerMovement(movementDTO);
	}
	
	@RequestMapping("/consult_quantity_by_type")
	public int consultQuantity(@RequestBody String type) {
		return movementService.consultQuantityVehicleByType(type);
	}
	
	@RequestMapping("/remove_vehicle")
	public MovementDTO removeVehicle(@RequestBody String plate) {
		return movementService.removeVehicle(plate);
	}
	
	@RequestMapping("/consult_vehicle_parking")
	public List<MovementDTO> consultMovementActive(){
		return movementService.consultMovementActivated();
	}
}
