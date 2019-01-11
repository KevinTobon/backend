package co.com.ceiba.parking.validation;

import org.springframework.stereotype.Component;

import co.com.ceiba.parking.entity.Movement;
import co.com.ceiba.parking.util.Constants;
import co.com.ceiba.parking.util.TimeMovement;

@Component
public class PaymentTypeMotorcycle implements PaymentVehicle{

	private static final double PRICE_REGISTRY_MOVEMENT = 0;
	private static final double PRICE_DAY_MOTORCYCLE = 4000;
	private static final double PRICE_HOURS_MOTORCYCLE = 500;
	private static final double LIMIT_DISPLACEMENT = 500;
	private static final double PRICE_SURPLUS_MOTORCYCLE = 2000;
	
	
	@Override
	public void payment(TimeMovement timeMovement, Movement movement) {
		double price = PRICE_REGISTRY_MOVEMENT;
		
		price += PRICE_DAY_MOTORCYCLE * timeMovement.days;
		price += (timeMovement.hours >= Constants.LIMIT_HOURS_PAYMENT_DAY ? PRICE_DAY_MOTORCYCLE : PRICE_HOURS_MOTORCYCLE * timeMovement.hours);
		
		movement.setPrice(movement.getVehicle().getDisplacement() > LIMIT_DISPLACEMENT ? price += PRICE_SURPLUS_MOTORCYCLE : price);
	}

}
