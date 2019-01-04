package co.com.ceiba.parking.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class VehicleEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "plate")
	private String plate;
	
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "displacement")
	private double displacement;
	
	public VehicleEntity(String plate, String type, double displacement) {
		super();
		this.plate = plate;
		this.type = type;
		this.displacement = displacement;
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

	public String getPlate() {
		return plate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
