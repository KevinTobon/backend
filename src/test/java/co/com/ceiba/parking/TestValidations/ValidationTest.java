package co.com.ceiba.parking.TestValidations;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.dto.ValidateDTO;
import co.com.ceiba.parking.util.Constants;
import co.com.ceiba.parking.util.MapDTO;
import co.com.ceiba.parking.util.MovementTestDataBuilder;
import co.com.ceiba.parking.util.ValidationDtoDataBuilder;
import co.com.ceiba.parking.validation.ValidatePlate;
import co.com.ceiba.parking.validation.ValidateQuantityVehicles;
import co.com.ceiba.parking.validation.ValidateTypeVehicle;

@RunWith(MockitoJUnitRunner.class)
public class ValidationTest {
	
	public static final String TYPE_VEHICLE_INVALID = "CAMION";
	public static final String EXCEPTION_VEHICLE_NOT_ALLOWED = "No se permite este vehiculo";
	public static final String EXCEPTION_NOT_SPACE_CARS = "No hay espacio para carros";
	public static final String EXCEPTION_NOT_SPACE_MOTORCYCLES= "No hay espacio para motos";
	public static final String PLATE_INITIAL_A = "AEI78B";
	public static final String EXCEPTION_PLATE_DAY_MONDAY_AND_SUNDAY = "No puede entrar este dia";
	public static final String EXCEPTION_PLATE_INACTIVE  ="Esta placa no se encuentra activa en el parqueadero";

	@InjectMocks
	ValidatePlate validatePlate;
	
	@Mock
	ValidateQuantityVehicles validateQuantityVehicles;
	
	@Mock
	ValidateTypeVehicle validateTypeVehicle;
	
	MapDTO mapDTO = new MapDTO();
	
	@Test
	public void trhowExceptionByTypeVehicle() {
		//Arrange
		MovementDTO movementDto = new MovementTestDataBuilder().byType(TYPE_VEHICLE_INVALID, Constants.TYPE_VEHICLE_MOTORCYCLE).build();
		ValidateDTO validation = new ValidationDtoDataBuilder().build();
		
		try {
			//Act
			validateTypeVehicle.validate(movementDto, validation);
		} catch(Exception e) {
			//Assert
			assertTrue(e.getMessage().equals(EXCEPTION_VEHICLE_NOT_ALLOWED));
		}
	}
	
	@Test
	public void validateByTypeVehicleCar() {
		//Arrange
		MovementDTO movementDto = new MovementTestDataBuilder().byType(Constants.TYPE_VEHICLE_CAR, Constants.PLATE_VEHICLE_CAR).build();
		ValidateDTO validation = new ValidationDtoDataBuilder()	.build();
		
		try {
			//Act
			validateTypeVehicle.validate(movementDto, validation);
		} catch(Exception e) {
			//Assert
			assertTrue(e.getMessage().equals(EXCEPTION_VEHICLE_NOT_ALLOWED));
		}
	}
	
	@Test
	public void validateByTypeVehicleMotorcycle() {
		//Arrange
		MovementDTO movementDto = new MovementTestDataBuilder().byType(Constants.PLATE_VEHICLE_MOTORCYCLE, Constants.PLATE_VEHICLE_MOTORCYCLE).build();
		ValidateDTO validation = new ValidationDtoDataBuilder().build();
		
		try {
			//Act
			validateTypeVehicle.validate(movementDto, validation);
		} catch(Exception e) {
			//Assert
			assertTrue(e.getMessage().equals(EXCEPTION_VEHICLE_NOT_ALLOWED));
		}
	}
	
	@Test
	public void throwExceptionByQuantityCarsMaximum() {
		//Arrange
		MovementDTO movementDto = new MovementTestDataBuilder().byType(Constants.TYPE_VEHICLE_CAR, Constants.PLATE_VEHICLE_CAR).build();
		ValidateDTO validation = new ValidationDtoDataBuilder().build();
		
		try {
			//Act
			validateQuantityVehicles.validate(movementDto, validation);
		} catch(Exception e) {
			//Assert
			assertTrue(e.getMessage().equals(EXCEPTION_NOT_SPACE_CARS));
		}
	}
	
	@Test
	public void throwExceptionByQuantityMotorcyclesMaximum() {
		//Arrange
		MovementDTO movementDto = new MovementTestDataBuilder().byType(Constants.TYPE_VEHICLE_MOTORCYCLE, Constants.PLATE_VEHICLE_MOTORCYCLE).build();
		ValidateDTO validation = new ValidationDtoDataBuilder().build();
		
		try {
			//Act
			validateQuantityVehicles.validate(movementDto, validation);
		} catch(Exception e) {
			//Assert
			assertTrue(e.getMessage().equals(EXCEPTION_NOT_SPACE_MOTORCYCLES));
		}
	}
	
	@Test
	public void validateQuantityCarsLess() {
		MovementDTO movementDto = new MovementTestDataBuilder().byType(Constants.TYPE_VEHICLE_CAR, Constants.PLATE_VEHICLE_CAR).build();
		ValidateDTO validation = new ValidationDtoDataBuilder().build();
		
		try {
			validateQuantityVehicles.validate(movementDto, validation);
		}catch(Exception e) {
			assertTrue(e.getMessage().equals(EXCEPTION_NOT_SPACE_CARS));
		}
	}
	
	@Test
	public void validateQuantityMotorcyclesLess() {
		//Arrange
		MovementDTO movementDto = new MovementTestDataBuilder().byType(Constants.TYPE_VEHICLE_MOTORCYCLE, Constants.PLATE_VEHICLE_MOTORCYCLE).build();
		ValidateDTO validation = new ValidationDtoDataBuilder().build();
		
		try {
			//Act
			validateQuantityVehicles.validate(movementDto, validation);
		}catch(Exception e) {
			//Assert
			assertTrue(e.getMessage().equals(EXCEPTION_NOT_SPACE_MOTORCYCLES));
		}
	}
	
	@Test
	public void throwExceptionByPlateInvalidity() {
		//Arrange
		MovementDTO movementDto = new MovementTestDataBuilder().byPlateAndDate(PLATE_INITIAL_A, Constants.DATE_NOT_PERMITTED_MONDAY_PLATE_A).build();
		ValidateDTO validation = new ValidationDtoDataBuilder().build();
		
		try {
			//Act
			validatePlate.validate(movementDto, validation);
		}catch(Exception e) {
			//Assert
			assertTrue(e.getMessage().equals(EXCEPTION_PLATE_DAY_MONDAY_AND_SUNDAY));
		}
	}
	
	@Test
	public void validateTheDaysValidOfThePlateSunday() {
		//Arrange
		MovementDTO movementDto = new MovementTestDataBuilder().byPlateAndDate(PLATE_INITIAL_A, Constants.DATE_PERMITTED_SUNDAY_PLATE_A).build();
		ValidateDTO validation = new ValidationDtoDataBuilder().build();
		
		try {
			//Act
			validatePlate.validate(movementDto, validation);
		}catch(Exception e) {
			//Assert
			assertTrue(e.getMessage().equals(EXCEPTION_PLATE_DAY_MONDAY_AND_SUNDAY));
		}
	}
	
	@Test
	public void validateDaysAndPlate() {
		//Arrange
		MovementDTO movementDto = new MovementTestDataBuilder().byPlateAndDate(Constants.PLATE_VEHICLE_CAR, Constants.DATE_NOT_PERMITTED_MONDAY_PLATE_A).build();
		ValidateDTO validation = new ValidationDtoDataBuilder().build();
		try {
			//Act
			validatePlate.validate(movementDto, validation);
		}catch(Exception e) {
			//Assert
			assertTrue(e.getMessage().equals(EXCEPTION_PLATE_DAY_MONDAY_AND_SUNDAY));
		}
	}
	
}
