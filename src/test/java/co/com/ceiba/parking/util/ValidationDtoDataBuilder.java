package co.com.ceiba.parking.util;

import co.com.ceiba.parking.dto.ValidateDTO;
import co.com.ceiba.parking.entity.Movement;
import co.com.ceiba.parking.entity.Vehicle;

public class ValidationDtoDataBuilder {

	private int QuantityCar;
	private int quantityMotrocycles;
	private Movement movement;
	
	public ValidationDtoDataBuilder() {
		super();
		this.QuantityCar = Constants.CAPACITY_CARS_LESS;
		this.quantityMotrocycles = Constants.CAPACITY_MOTORCYCLE_LESS;
		this.movement = null;
	}
	
	public ValidateDTO build() {
		return new ValidateDTO(QuantityCar, quantityMotrocycles, movement);
	}
	
	public ValidationDtoDataBuilder withMovement() {
		this.movement = new Movement(
					new Long(1), 
					new Vehicle(Constants.PLATE_VEHICLE_CAR, Constants.TYPE_VEHICLE_CAR, 0), 
					Constants.ENTRY_DATE_TEST,
					null, 
					0
				);
		
		return this;
	}

	public int getQuantityCar() {
		return QuantityCar;
	}

	public void setQuantityCar(int quantityCar) {
		QuantityCar = quantityCar;
	}

	public int getQuantityMotrocycles() {
		return quantityMotrocycles;
	}

	public void setQuantityMotrocycles(int quantityMotrocycles) {
		this.quantityMotrocycles = quantityMotrocycles;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}
}
