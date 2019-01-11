package co.com.ceiba.parking.validation;

import org.springframework.stereotype.Component;

import co.com.ceiba.parking.entity.Movement;
import co.com.ceiba.parking.util.Constants;
import co.com.ceiba.parking.util.TimeMovement;

@Component
public class PaymentTypeCar implements PaymentVehicle{

	private static final double PRICE_REGISTRY_MOVEMENT = 0;
	private static final double PRYCE_DAY_CAR = 8000;
	private static final double PRICE_HOURS_CAR = 1000;
	
	
	@Override
	public void payment(TimeMovement timeMovement, Movement movement) {
		double price = PRICE_REGISTRY_MOVEMENT;
		
		price += PRYCE_DAY_CAR * timeMovement.days;
		price += (timeMovement.hours >= Constants.LIMIT_HOURS_PAYMENT_DAY ? PRYCE_DAY_CAR : PRICE_HOURS_CAR * timeMovement.hours);
		
		movement.setPrice(price);
	}

}
