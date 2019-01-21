package co.com.ceiba.parking.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.service.MovementService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/movement")
public class MovementController {

	@Autowired
	MovementService movementService;
	
	@PostMapping("/register_movement")
	public String registerMovement(@RequestBody MovementDTO movementDTO) {
		return movementService.registerMovement(movementDTO);
	}
	
	@GetMapping("/consult_quantity_by_type")
	public int consultQuantity(@RequestBody String type) {
		return movementService.consultQuantityVehicleByType(type);
	}
	
	@DeleteMapping("/remove_vehicle")
	public MovementDTO removeVehicle(@RequestParam(value = "plate") String plate) {
		return movementService.removeVehicle(plate);
	}
	
	@GetMapping("/consult_vehicle_parking")
	public List<MovementDTO> consultMovementActive(){
		return movementService.consultMovementActivated();
	}
}
