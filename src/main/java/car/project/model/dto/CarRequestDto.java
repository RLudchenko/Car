package car.project.model.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CarRequestDto {
    private final LocalDate localDate = LocalDate.now();
    private String engineType;
    private int maxSpeed;
    private int accelerationTime;
    private int passengerCapacity;
    private int passengerQuantity;
    private int currentSpeed;
    private int numOfWheels;
    private int numOfDoors;
}
