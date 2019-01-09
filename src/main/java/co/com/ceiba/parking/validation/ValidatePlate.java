package co.com.ceiba.parking.validation;

import java.time.DayOfWeek;
import java.util.Random;

import org.springframework.stereotype.Component;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.dto.ValidateDTO;
import co.com.ceiba.parking.entity.Movement;
import co.com.ceiba.parking.exception.ParkingException;

@Component
public class ValidatePlate implements Validation{
	
	private static final String PLATE_INVALID_EXCEPTION= "No tiene permisos para ingresar este día";
	private static final String[] PLATE_INVALID = {"A"};
	private static final String VEHICLE_ACTIVE_EXCEPTION = "Esta placa se encuentra activa en el parqueadero";

	@Override
	public void validate(MovementDTO movementDTO, ValidateDTO validateDTO) throws ParkingException {
		validatePlateRegister(movementDTO, validateDTO.getMovement());
		
		for(String plateInvalid: PLATE_INVALID) {
			
			boolean isMonday = movementDTO.getEntryDate().getDayOfWeek().equals(DayOfWeek.MONDAY);
			boolean isSunday = movementDTO.getEntryDate().getDayOfWeek().equals(DayOfWeek.SUNDAY);
			
			if(!(isMonday || isSunday)) {
				if(movementDTO.getPlate().toUpperCase().startsWith(plateInvalid)) {
					throw new ParkingException(PLATE_INVALID_EXCEPTION);
				}
			}
		}
	}
	
	private void validatePlateRegister(MovementDTO movementDTO, Movement movementEntity) throws ParkingException {
		if(movementEntity != null){
			if(movementEntity.getExitDate() != null) {
				movementDTO.setId(movementEntity.getId());
			} else {
				throw new ParkingException(VEHICLE_ACTIVE_EXCEPTION);
			}
		} else {
			movementDTO.setId(new Random().nextLong());
		}
	}
}
