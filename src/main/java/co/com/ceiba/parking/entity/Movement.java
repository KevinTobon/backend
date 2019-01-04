package co.com.ceiba.parking.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movement")
public class Movement implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "plate")
	private VehicleEntity vehicleEntity;
	
	@Column(name = "entryDate")
	private LocalDateTime entryDate;
	
	@Column(name = "exitDate")
	private LocalDateTime exitDate;
	
	@Column(name = "price")
	private double price;
	
	public Movement() {
	}
	
	public Movement(Long id, VehicleEntity vehicleEntity, LocalDateTime entryDate, LocalDateTime exitDate,
			double price) {
		super();
		this.id = id;
		this.vehicleEntity = vehicleEntity;
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

	public VehicleEntity getVehicleEntity() {
		return vehicleEntity;
	}

	public void setVehicleEntity(VehicleEntity vehicleEntity) {
		this.vehicleEntity = vehicleEntity;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
