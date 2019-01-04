package co.com.ceiba.parking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.service.MovementService;

@RestController
@RequestMapping("/movemenet")
public class MovementController {

	@Autowired
	@Qualifier("movementService")
	MovementService movementService;
	
	public String registerMovement(@RequestBody MovementDTO movementDTO) {
		return movementService.registerMovement(movementDTO);
	}
}
