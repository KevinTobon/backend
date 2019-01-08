package co.com.ceiba.parking.validation;

import org.springframework.stereotype.Component;

import co.com.ceiba.parking.entity.Movement;
import co.com.ceiba.parking.util.TimeMovement;

@Component
public class PaymentTypeMotorcycle implements PaymentVehicle{

	private static final double PRECIO_REGISTRO_FACTURA = 0;
	private static final double PRECIO_DIA_MOTO = 4000;
	private static final double LIMITE_HORAS_COBRO_DIA = 9;
	private static final double PRECIO_HORA_MOTO = 500;
	private static final double LIMITE_CILINDRAJE = 500;
	private static final double PRECIO_EXCEDENTE_MOTO = 2000;
	
	
	@Override
	public void payment(TimeMovement timeMovement, Movement movement) {
		double price = PRECIO_REGISTRO_FACTURA;
		
		price += PRECIO_DIA_MOTO * timeMovement.days;
		price += (timeMovement.hours >= LIMITE_HORAS_COBRO_DIA ? PRECIO_DIA_MOTO : PRECIO_HORA_MOTO * timeMovement.hours);
		
		movement.setPrice(movement.getVehicleEntity().getDisplacement() > LIMITE_CILINDRAJE ? price += PRECIO_EXCEDENTE_MOTO : price);
	}

}
