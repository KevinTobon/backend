package co.com.ceiba.parking.validation;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.dto.ValidateDTO;
import co.com.ceiba.parking.exception.ParkingException;

public interface Validation {

	public void validate(MovementDTO movementDTO, ValidateDTO validateDTO) throws ParkingException;
}
