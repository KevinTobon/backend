package co.com.ceiba.parking.validation;

import org.springframework.stereotype.Component;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.dto.ValidateDTO;
import co.com.ceiba.parking.exception.ParkingException;
import co.com.ceiba.parking.util.Constants;

@Component
public class ValidateQuantityVehicles implements Validation{

	private static final String CAPACITY_MAXIMUM_CARS_EXCEPTION = "No hay suficientes espacios para carros disponibles";
	private static final String CAPACITY_MAXIMUM_MOTORCYCLES_EXCEPTION = "No hay suficientes espacios para motos disponibles";

	
	@Override
	public void validate(MovementDTO movementDTO, ValidateDTO validateDTO) throws ParkingException {
		
		if(movementDTO.getTypeVehicle().equals(Constants.TYPE_VEHICLE_CAR) && 
				validateDTO.getQuantityCar() >= Constants.CAPACITY_MAXIMUM_CARS) {
			throw new ParkingException(CAPACITY_MAXIMUM_CARS_EXCEPTION);
		}
		
		if(movementDTO.getTypeVehicle().equals(Constants.TYPE_VEHICLE_MOTORCYCLE) && 
				validateDTO.getQuantityMotorcycle() >= Constants.CAPACITY_MAXIMUM_MOTORCYCLES) {
			throw new ParkingException(CAPACITY_MAXIMUM_MOTORCYCLES_EXCEPTION);
		}		
		
	}

}
