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

	public int getCantidadMotos() {
		return quantityMotorcycle;
	}
	public void setCantidadMotos(int cantidadMotos) {
		this.quantityMotorcycle = cantidadMotos;
	}
	public int getCantidadCarros() {
		return quantityCar;
	}
	public void setCantidadCarros(int cantidadCarros) {
		this.quantityCar = cantidadCarros;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}
	
	
	
}
