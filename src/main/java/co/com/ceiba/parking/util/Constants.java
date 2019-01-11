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
	public static final LocalDateTime ENTRY_DATE_TEST = LocalDateTime.of(2018, 12, 1, 8, 20);
	
}
