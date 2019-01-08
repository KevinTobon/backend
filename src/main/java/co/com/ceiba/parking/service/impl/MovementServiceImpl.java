package co.com.ceiba.parking.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parking.dto.MovementDTO;
import co.com.ceiba.parking.dto.ValidateDTO;
import co.com.ceiba.parking.entity.Movement;
import co.com.ceiba.parking.repository.MovementRepository;
import co.com.ceiba.parking.repository.VehicleRepository;
import co.com.ceiba.parking.service.MovementService;
import co.com.ceiba.parking.util.MapDTO;
import co.com.ceiba.parking.util.TimeMovement;
import co.com.ceiba.parking.validation.PaymentTypeCar;
import co.com.ceiba.parking.validation.PaymentTypeMotorcycle;
import co.com.ceiba.parking.validation.ValidatePlate;
import co.com.ceiba.parking.validation.ValidateQuantityVehicles;
import co.com.ceiba.parking.validation.ValidateTypeVehicle;
import co.com.ceiba.parking.validation.Validation;

@Service("movementService")
public class MovementServiceImpl implements MovementService{

	private static final double PRICE_REGISTER_MOVEMENT = 0;
	private static final String TYPE_VEHICLE_CAR = "CAR";
	private static final String TIPO_VEHICULO_MOTORCYCLE = "MOTORCYCLE";
	
	
	@Autowired
	MovementRepository movementRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	ValidatePlate validatePlate;
	
	@Autowired
	ValidateQuantityVehicles validateQuantityVehicles;
	
	@Autowired
	ValidateTypeVehicle validateTypeVehicle;
	
	@Autowired
	TimeMovement timeMovement;
	
	@Autowired
	PaymentTypeCar paymentTypeCar;
	
	@Autowired
	PaymentTypeMotorcycle paymentTypeMotorcycle;
	
	List<Validation> validationsMovement;
	
	MapDTO mapDTO = new MapDTO();
	
	@Override
	public String registerMovement(MovementDTO movementDTO) {
		
		movementDTO.setEntryDate(LocalDateTime.now());
		movementDTO.setPrice(PRICE_REGISTER_MOVEMENT);
		
		validationsMovement = new ArrayList<>();
		validationsMovement.add(validateTypeVehicle);
		validationsMovement.add(validatePlate);
		validationsMovement.add(validateQuantityVehicles);
		
		ValidateDTO validateDTO = new ValidateDTO();
		validateDTO.setQuantityCar(movementRepository.consultQuantityVehicleByType(TYPE_VEHICLE_CAR));
		validateDTO.setQuantityMotorcycle(movementRepository.consultQuantityVehicleByType(TIPO_VEHICULO_MOTORCYCLE));
		validateDTO.setMovement(movementRepository.consultMovementyPlate(movementDTO.getPlate()));
		
		for(Validation validation: validationsMovement) {
			validation.validate(movementDTO, validateDTO);
		}
		
		Movement movement = mapDTO.convertMovementDTO(movementDTO);
		vehicleRepository.save(movement.getVehicleEntity());
		return movementRepository.save(movement).getId().toString();
	}

	@Override
	public int consultQuantityVehicleByType(String typeVehicle) {
		return movementRepository.consultQuantityVehicleByType(typeVehicle);
	}

	@Override
	public MovementDTO removeVehicle(String plate) {
		Movement movement = movementRepository.consultMovementyPlate(plate);
		movement.setExitDate(LocalDateTime.now());
		
		timeMovement.calculateVehicleTime(Timestamp.valueOf(movement.getEntryDate()), Timestamp.valueOf(movement.getExitDate()));
		
		if(movement.getVehicleEntity().getType().equals(TYPE_VEHICLE_CAR)) {
			paymentTypeCar.payment(timeMovement, movement);
		} else {
			paymentTypeMotorcycle.payment(timeMovement, movement);
		}
		
		movementRepository.save(movement);
		return mapDTO.convertToMovementEntity(movement);
	}
	
	@Override
	public List<MovementDTO> consultMovementActivated() {
		List<MovementDTO> listMovement = new ArrayList<>();
		for(Movement movement : movementRepository.consultMovementActivated()) {
			listMovement.add(mapDTO.convertToMovementEntity(movement));
		}
		return listMovement;
	}

}
