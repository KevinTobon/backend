package co.com.ceiba.parking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "PLATE")
	private String plate;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "DISPLACEMENT")
	private int displacement;
	
	@Column(name = "ENTRY_DATE")
	private String entryDate;
	
	public Vehicle() {
	}
	
	public Vehicle(long id, String plate, String type, int displacement, String entryDate) {
		super();
		this.id = id;
		this.plate = plate;
		this.type = type;
		this.displacement = displacement;
		this.entryDate = entryDate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlate(Vehicle vehicle) {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public String getPlate() {
		return plate;
	}


}
