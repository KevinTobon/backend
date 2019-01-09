package co.com.ceiba.parking.validation;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.dto.ValidateDTO;

public interface Validation {

	public void validate(MovementDTO movementDTO, ValidateDTO validateDTO);
	
}
