package co.com.ceiba.parking.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.parking.model.Vehicle;
import co.com.ceiba.parking.repository.VehicleRepository;

@RestController
public class VehicleController {
	
	public static final String VEHICULO_CREADO = "Vehiculo creado correctamente";
	public static final String VEHICULO_EXISTE = "El vehiculo ya existe";

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@RequestMapping(value = "/getVehicles", method = RequestMethod.GET)
	public List<Vehicle> findAll(@RequestParam(required = false) String plate){
		List<Vehicle> vehicles = new ArrayList<>();
		
		if(plate == null) {
			Iterable<Vehicle> results = this.vehicleRepository.findAll();
			results.forEach(vehicle->{
				vehicles.add(vehicle);
			});
		} else {
			Vehicle vehicle = this.vehicleRepository.findByPlate(plate);
			
			if(vehicle != null) {
				vehicles.add(vehicle);
			}
		}
		return vehicles;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Vehicle insert(@RequestBody Vehicle vehicle) {
		this.vehicleRepository.save(vehicle);
		return vehicle;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public Vehicle delete(@RequestBody Vehicle vehicle) {
		this.vehicleRepository.delete(vehicle);
		return vehicle;
	}
	
}
