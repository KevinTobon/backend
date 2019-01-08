package co.com.ceiba.parking.validation;

import co.com.ceiba.parking.entity.Movement;
import co.com.ceiba.parking.util.TimeMovement;

public interface PaymentVehicle {

	public void payment(TimeMovement timeMovement, Movement movement);
}
