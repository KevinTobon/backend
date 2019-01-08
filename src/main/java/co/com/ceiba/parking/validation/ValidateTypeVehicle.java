package co.com.ceiba.parking.validation;

import org.springframework.stereotype.Component;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.dto.ValidateDTO;
import co.com.ceiba.parking.exception.ParkingException;

@Component
public class ValidateTypeVehicle implements Validation{
	
	private static final String TYPE_VEHICLE_CAR = "CAR";
	private static final String TYPE_VEHICLE_MOTORCYCLE = "MOTORCYCLE";
	private static final String VEHICLE_NO_PERMITTED_EXCEPTION = "No se permite este tipo de vehículo";
	

	public void validate(MovementDTO movementDTO, ValidateDTO validateDTO) {
		if(!(movementDTO.getTypeVehicle().equals(TYPE_VEHICLE_CAR) || movementDTO.getTypeVehicle().equals(TYPE_VEHICLE_MOTORCYCLE)));
		throw new ParkingException(VEHICLE_NO_PERMITTED_EXCEPTION);
	}
}
