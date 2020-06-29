package car.project.model.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class CarResponseDto {
    private Long carId;
    private final LocalDate localDate = LocalDate.now();
    private String engineType;
    private int maxSpeed;
    private int accelerationTime;
    private int passengerCapacity;
    private int passengerQuantity;
    private int currentSpeed;

    private List<CarWheelResponseDto> wheels;
    private List<CarDoorResponseDto> doors;
}
