package co.com.ceiba.parking.util;

import java.time.LocalDateTime;

public class Constants {

	private Constants() {
	}
	
	//Types vehicles
	public static final String TYPE_VEHICLE_CAR = "CARRO";
	public static final String TYPE_VEHICLE_MOTORCYCLE = "MOTO";
	
	//value payment
	public static final double LIMIT_HOURS_PAYMENT_DAY = 9;
	public static final int CAPACITY_MAXIMUM_CARS = 20;
	public static final double CAPACITY_MAXIMUM_MOTORCYCLES = 10;
	
	//tests unit
	public static final String PLATE_VEHICLE_MOTORCYCLE = "GPZ06E";
	public static final String PLATE_VEHICLE_CAR = "FUM78B";
	public static final int CAPACITY_CARS_LESS = 10;
	public static final int CAPACITY_MOTORCYCLE_LESS = 9;
	public static final LocalDateTime DATE_NOT_PERMITTED_MONDAY_PLATE_A = LocalDateTime.of(2018, 12, 12, 8, 28);
	public static final LocalDateTime DATE_PERMITTED_MONDAY_PLATE_A = LocalDateTime.of(2018, 12, 17, 8, 28);
	public static final LocalDateTime DATE_PERMITTED_SUNDAY_PLATE_A = LocalDateTime.of(2018, 12, 16, 8, 28);
	public static final LocalDateTime ENTRY_DATE_TEST = LocalDateTime.of(2018, 12, 1, 8, 20);
	public static final LocalDateTime EXIT_DATE_TEST = LocalDateTime.of(2018, 12, 12, 10, 30);
	public static final LocalDateTime EXIT_DATE_TEST_SECONS = LocalDateTime.of(2018, 12, 13, 11, 06, 8);
	public static final LocalDateTime EXIT_DATE_TEST_MINUTES = LocalDateTime.of(2018, 12, 12, 8, 20, 10);
	public static final LocalDateTime EXIT_DATE_TEST_HOURS = LocalDateTime.of(2018, 12, 12, 11, 20, 0);

	
}
