package co.com.ceiba.parking.validation;

import org.springframework.stereotype.Component;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.dto.ValidateDTO;
import co.com.ceiba.parking.exception.ParkingException;

@Component
public class ValidateQuantityVehicles implements Validation{

	private static final String TIPO_VEHICULO_CARRO = "CAR";
	private static final double CANTIDAD_MAXIMA_CARROS = 20;
	private static final double CANTIDAD_MAXIMA_MOTOS = 10;
	private static final String CAPACIDAD_MAXIMA_CARROS_EXCEPTION = "No hay suficientes espacios para carros disponibles";
	private static final String CAPACIDAD_MAXIMA_MOTOS_EXCEPTION = "No hay suficientes espacios para motos disponibles";
	private static final String TIPO_VEHICULO_MOTO = "MOTORCYCLE";
	
	@Override
	public void validate(MovementDTO movementDTO, ValidateDTO validateDTO) throws ParkingException {
		
		if(movementDTO.getTypeVehicle().equals(TIPO_VEHICULO_CARRO) && 
				validateDTO.getQuantityCar() >= CANTIDAD_MAXIMA_CARROS) {
			throw new ParkingException(CAPACIDAD_MAXIMA_CARROS_EXCEPTION);
		}
		
		if(movementDTO.getTypeVehicle().equals(TIPO_VEHICULO_MOTO) && 
				validateDTO.getQuantityMotorcycle() >= CANTIDAD_MAXIMA_MOTOS) {
			throw new ParkingException(CAPACIDAD_MAXIMA_MOTOS_EXCEPTION);
		}		
		
	}

}
