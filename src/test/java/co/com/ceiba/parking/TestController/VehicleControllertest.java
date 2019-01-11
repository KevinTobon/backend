package co.com.ceiba.parking.TestController;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.parking.entity.Movement;
import co.com.ceiba.parking.rest.VehicleController;
import co.com.ceiba.parking.service.VehicleService;
import co.com.ceiba.parking.util.Constants;
import co.com.ceiba.parking.util.MapDTO;
import co.com.ceiba.parking.util.MovementTestDataBuilder;

@RunWith(MockitoJUnitRunner.class)
public class VehicleControllertest {

	@InjectMocks
	VehicleController vehicleController;
	
	@Mock
	VehicleService vehicleService;
	
	MapDTO mapDTO = new MapDTO();
	
	@Test
	public void callServiceByRegisterVehicle() {
		
		//Arrange
		Movement movement = mapDTO.convertMovementDTO(new MovementTestDataBuilder().build());
		
		//Act
		String result = vehicleController.enterVehicle(movement.getVehicle());
		
		//Assert
		assertEquals(result, Constants.TYPE_VEHICLE_CAR);
	}
}
