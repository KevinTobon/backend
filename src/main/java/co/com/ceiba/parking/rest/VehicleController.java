package co.com.ceiba.parking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parking.entity.VehicleEntity;
import co.com.ceiba.parking.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Autowired
	@Qualifier("vehicleService")
	VehicleService vehicleService;
	
	@PostMapping("/enter_vehicles")
	public String enterVehicle(@RequestBody VehicleEntity vehicleEntity) {
		vehicleService.registerVehicle(vehicleEntity);
		return vehicleEntity.getPlate();
	}
}
