package co.com.ceiba.parking.dto;

import co.com.ceiba.parking.entity.Movement;

public class ValidateDTO {

	private int quantityMotorcycle;
	private int quantityCar;
	private Movement movement;

	
	public ValidateDTO() {	
	}

	public ValidateDTO(int quantityMotorcycle, int quantityCar, Movement movement) {
		super();
		this.quantityMotorcycle = quantityMotorcycle;
		this.quantityCar = quantityCar;
		this.movement = movement;

	}


	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	public int getQuantityMotorcycle() {
		return quantityMotorcycle;
	}

	public void setQuantityMotorcycle(int quantityMotorcycle) {
		this.quantityMotorcycle = quantityMotorcycle;
	}

	public int getQuantityCar() {
		return quantityCar;
	}

	public void setQuantityCar(int quantityCar) {
		this.quantityCar = quantityCar;
	}
	
	
	
}
