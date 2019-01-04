package co.com.ceiba.parking.dto;

import java.time.LocalDateTime;

public class MovementDTO {

	private Long id;
	private String typeVehicle;
	private String plate;
	private double displacement;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;
	private double price;
	
	public MovementDTO() {
	}
	
	public MovementDTO(Long id, String typeVehicle, String plate, double displacement, LocalDateTime entryDate,
			LocalDateTime exitDate, double price) {
		super();
		this.id = id;
		this.typeVehicle = typeVehicle;
		this.plate = plate;
		this.displacement = displacement;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public double getDisplacement() {
		return displacement;
	}

	public void setDisplacement(double displacement) {
		this.displacement = displacement;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
