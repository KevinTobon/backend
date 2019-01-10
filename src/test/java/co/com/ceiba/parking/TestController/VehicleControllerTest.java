package co.com.ceiba.parking.TestController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.rest.MovementController;
import co.com.ceiba.parking.service.MovementService;
import co.com.ceiba.parking.util.MovementTestDataBuilder;

@RunWith(MockitoJUnitRunner.class)
public class VehicleControllerTest {

	@InjectMocks
	MovementController movementController;
	
	@Mock
	MovementService movementService;
	
	@Test
	public void callServiceToRegisterMovement() {
		
		//Arrange
		MovementDTO movementDTO = new MovementTestDataBuilder().build();
		when(movementService.registerMovement(movementDTO)).thenReturn(movementDTO.getId().toString());
		
		//Act
		String result = movementController.registerMovement(movementDTO);
		
		//Assert
		assertEquals(result, movementDTO.getId().toString());
	}
}
