package co.com.ceiba.parking.TestValidations;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.ceiba.parking.util.Constants;
import co.com.ceiba.parking.util.TimeMovement;

@RunWith(MockitoJUnitRunner.class)
public class TimeVehicleTest {

	@InjectMocks
	TimeMovement timeMovement;
	
	@Test
	public void calculateTimeOfPayment() {
	
		timeMovement.calculateVehicleTime(Timestamp.valueOf(Constants.ENTRY_DATE_TEST), Timestamp.valueOf(Constants.EXIT_DATE_TEST));
		
		assertEquals(11, timeMovement.days);
		assertEquals(3, timeMovement.hours);
		assertEquals(10, timeMovement.minutes);
		assertEquals(0, timeMovement.seconds);
	}
	
	@Test
	public void calculateTimeQuantityWithSecons() {
		
		timeMovement.calculateVehicleTime(Timestamp.valueOf(Constants.ENTRY_DATE_TEST), Timestamp.valueOf(Constants.EXIT_DATE_TEST_SECONS));
		
		assertEquals(12, timeMovement.days);
		assertEquals(3, timeMovement.hours);
		assertEquals(41, timeMovement.minutes);
		assertEquals(1, timeMovement.seconds);
	}
	
	@Test
	public void calculateTimeQuantityWithMinutes() {
		
		timeMovement.calculateVehicleTime(Timestamp.valueOf(Constants.ENTRY_DATE_TEST), Timestamp.valueOf(Constants.EXIT_DATE_TEST_MINUTES));
		
		assertEquals(11, timeMovement.days);
		assertEquals(1, timeMovement.hours);
		assertEquals(1, timeMovement.minutes);
		assertEquals(10, timeMovement.seconds);
	}
	
	@Test
	public void calculateTimeQuantityWithHours() {
		
		timeMovement.calculateVehicleTime(Timestamp.valueOf(Constants.ENTRY_DATE_TEST), Timestamp.valueOf(Constants.EXIT_DATE_TEST_HOURS));
		
		assertEquals(11, timeMovement.days);
		assertEquals(3, timeMovement.hours);
		assertEquals(0, timeMovement.minutes);
		assertEquals(0, timeMovement.seconds);
	}
}
