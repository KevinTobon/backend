package co.com.ceiba.parking.TestController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
	
	private static final String TYPE_VEHICLE_CAR = "CARRO";
	private static final int QUANTITY_MAX_CARS = 20;
	private static final String PLATE_VEHICLE_CAR = "FUM78B";

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
	
	@Test
	public void callServiceByConsultQuantityVehicles() {
		
		//Arrange
		when(movementService.consultQuantityVehicleByType(TYPE_VEHICLE_CAR)).thenReturn(QUANTITY_MAX_CARS);
		
		//Act
		int result = movementController.consultQuantity(TYPE_VEHICLE_CAR);
		//Assert
		assertEquals(result, 20);
	}
	
	@Test
	public void callServiceByRemoveVehicle() {
		
		//Arrange
		MovementDTO movementDto = new MovementTestDataBuilder().build();
		when(movementService.removeVehicle(PLATE_VEHICLE_CAR)).thenReturn(movementDto);
		
		//Act
		MovementDTO result = movementController.removeVehicle(PLATE_VEHICLE_CAR);
		
		//Assert
		assertEquals(result, movementDto);
	}
	
	private List<MovementDTO> createListMovement(){
		List<MovementDTO> ToListMovementAssets = new ArrayList<>();
		ToListMovementAssets.add(new MovementTestDataBuilder().build());
		ToListMovementAssets.add(new MovementTestDataBuilder().byPlate(PLATE_VEHICLE_CAR).build());
		
		return ToListMovementAssets;
	}
	
	@Test
	public void callServiceByConsultMovementsAssets() {
		
		//Arrange
		List<MovementDTO> ToListMovementAssets = createListMovement();
		when(movementService.consultMovementActivated()).thenReturn(ToListMovementAssets);
		
		//Act
		List<MovementDTO> result = movementController.consultMovementActive();
		
		//Assert
		assertEquals(result, ToListMovementAssets);
	}
	
}
