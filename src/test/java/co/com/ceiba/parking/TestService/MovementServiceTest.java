package co.com.ceiba.parking.TestService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.entity.Movement;
import co.com.ceiba.parking.entity.Vehicle;
import co.com.ceiba.parking.repository.MovementRepository;
import co.com.ceiba.parking.repository.VehicleRepository;
import co.com.ceiba.parking.service.impl.MovementServiceImpl;
import co.com.ceiba.parking.util.Constants;
import co.com.ceiba.parking.util.MapDTO;
import co.com.ceiba.parking.util.MovementTestDataBuilder;
import co.com.ceiba.parking.util.TimeMovement;
import co.com.ceiba.parking.validation.PaymentTypeCar;
import co.com.ceiba.parking.validation.PaymentTypeMotorcycle;
import co.com.ceiba.parking.validation.ValidatePlate;
import co.com.ceiba.parking.validation.ValidateQuantityVehicles;
import co.com.ceiba.parking.validation.ValidateTypeVehicle;

@RunWith(MockitoJUnitRunner.class)
public class MovementServiceTest {

	@InjectMocks
	MovementServiceImpl movementService = new MovementServiceImpl();
	
	@Mock
	MovementRepository movementRepository;
	
	@Mock
	VehicleRepository vehieRepository;
	
	@Mock
	ValidatePlate validatePlate;
	
	@Mock
	ValidateTypeVehicle validateTypeVehicle;
	
	@Mock
	ValidateQuantityVehicles validateQuantityVehicles;
	
	@Mock
	TimeMovement timeMovement;
	
	@Mock
	PaymentTypeCar paymentTypeCar;
	
	@Mock
	PaymentTypeMotorcycle paymentTypeMotorcycle;
	
	MapDTO mapDTO = new MapDTO();
	
	@Test
	public void generateNewMovement() {
		//Arrange
		MovementDTO movementDto = new MovementTestDataBuilder().byType(Constants.TYPE_VEHICLE_CAR, Constants.PLATE_VEHICLE_CAR).build();
		Movement movement = mapDTO.convertMovementDTO(movementDto);
		
		when(movementRepository.save(Mockito.any(Movement.class))).thenReturn(movement);
		when(vehieRepository.save(Mockito.any(Vehicle.class))).thenReturn(new Vehicle());
		
		//Act
		String result = movementService.registerMovement(movementDto);
		
		//Assert
		assertEquals(result, movementDto.getId().toString());
	}
	
	@Test
	public void consultQuantityVehicles() {
		
		//Arrange
		when(movementService.consultQuantityVehicleByType(Constants.TYPE_VEHICLE_CAR)).thenReturn(Constants.CAPACITY_CARS_LESS);
		
		//Act
		int quantity = movementService.consultQuantityVehicleByType(Constants.TYPE_VEHICLE_CAR);
		
		//Assert
		assertEquals(quantity, 10);
	}
	
	@Test
	public void removeVehicleCar() {
		MovementDTO movementDto = new MovementTestDataBuilder().build();
		Movement movement = mapDTO.convertMovementDTO(movementDto);
		
		when(movementRepository.consultMovementyPlate(Constants.PLATE_VEHICLE_CAR)).thenReturn(movement);
		timeMovement.days = 10;
		timeMovement.hours = 2;
		
		MovementDTO result = movementService.removeVehicle(Constants.PLATE_VEHICLE_CAR);
		
		assertTrue(result.getExitDate() != null);
	}
	
}
