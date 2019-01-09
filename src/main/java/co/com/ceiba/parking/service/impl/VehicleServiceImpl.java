package co.com.ceiba.parking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.com.ceiba.parking.entity.Vehicle;
import co.com.ceiba.parking.repository.VehicleRepository;
import co.com.ceiba.parking.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	@Qualifier("vehicleRepository")
	VehicleRepository vehicleRepository;

	@Override
	public void registerVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	
}
