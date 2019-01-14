package co.com.ceiba.parking.TestValidations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.entity.Movement;
import co.com.ceiba.parking.util.Constants;
import co.com.ceiba.parking.util.MapDTO;
import co.com.ceiba.parking.util.MovementTestDataBuilder;
import co.com.ceiba.parking.validation.PaymentTypeCar;
import co.com.ceiba.parking.validation.PaymentTypeMotorcycle;

@RunWith(MockitoJUnitRunner.class)
public class PaymenVehicleTest {

	@InjectMocks
	PaymentTypeCar paymentTypeCar;
	
	@InjectMocks
	PaymentTypeMotorcycle paymentTypeMotorcycle;
	
	MapDTO mapDTO = new MapDTO();
	
	@Test
	public void calculateQuantityCarBy11days2Hours() {
		MovementDTO movementDto = new MovementTestDataBuilder().build();
		Movement movement = mapDTO.convertMovementDTO(movementDto);
		
		paymentTypeCar.payment(Constants.TIME_MOVEMENT_TEST, movement);
		
		assertEquals(90000, movement.getPrice(), 90000);
	}
}
