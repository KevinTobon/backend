package co.com.ceiba.parking.validation;

import org.springframework.stereotype.Component;

import co.com.ceiba.parking.entity.Movement;
import co.com.ceiba.parking.util.TimeMovement;

@Component
public class PaymentTypeCar implements PaymentVehicle{

	private static final double PRECIO_REGISTRO_FACTURA = 0;
	private static final double PRECIO_DIA_CARRO = 8000;
	private static final double LIMITE_HORAS_COBRO_DIA = 9;
	private static final double PRECIO_HORA_CARRO = 1000;
	
	
	@Override
	public void payment(TimeMovement timeMovement, Movement movement) {
		double price = PRECIO_REGISTRO_FACTURA;
		
		price += PRECIO_DIA_CARRO * timeMovement.days;
		price += (timeMovement.hours >= LIMITE_HORAS_COBRO_DIA ? PRECIO_DIA_CARRO : PRECIO_HORA_CARRO * timeMovement.hours);
		
		movement.setPrice(price);
	}

}
