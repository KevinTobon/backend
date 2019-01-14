package co.com.ceiba.parking.util;

import java.time.LocalDateTime;

import co.com.ceiba.parking.dto.MovementDTO;

public class MovementTestDataBuilder {
	
	

	private Long id;
	private String plate;
	private String type;
	private double displacement;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;
	private double price;
	
	public MovementTestDataBuilder() {
		this.id = new Long(0);
		this.plate = Constants.PLATE_VEHICLE_CAR;
		this.type = Constants.TYPE_VEHICLE_CAR;
		this.displacement = 0;
		this.entryDate = LocalDateTime.now();
		this.exitDate = null;
		this.price = 0;
	}
	
	public MovementTestDataBuilder byPlate(String plate) {
		this.plate = plate;
		return this;
	}
	
	public MovementTestDataBuilder byType(String type, String plate) {
		this.type = type;
		this.plate = plate;
		return this;
	}
	
	public MovementTestDataBuilder byDisplacement(double displacement) {
		this.displacement = displacement;
		this.type = Constants.TYPE_VEHICLE_MOTORCYCLE;
		return this;
	}
	
	public MovementTestDataBuilder byPlateAndDate(String plate, LocalDateTime date) {
		this.plate = plate;
		this.entryDate = date;
		return this;
	}

	public MovementTestDataBuilder byPlateAndExitDate(String plate, LocalDateTime date) {
		this.plate = plate;
		this.exitDate = date;
		return this;
	}
	
	public MovementDTO build() {
		return new MovementDTO(id, plate, type, displacement, entryDate, exitDate, price);
	}
	
	public LocalDateTime getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}
	public LocalDateTime getExitDate() {
		return exitDate;
	}
	public void setExitDate(LocalDateTime exitDate) {
		this.exitDate = exitDate;
	}
	
	
}
