package car.project.mapper;

import car.project.model.Car;
import car.project.model.CarDoor;
import car.project.model.CarWheel;
import car.project.model.dto.CarDoorResponseDto;
import car.project.model.dto.CarRequestDto;
import car.project.model.dto.CarResponseDto;
import car.project.model.dto.CarWheelResponseDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CarMapper {
    private final CarDoorMapper carDoorMapper;
    private final CarWheelMapper carWheelMapper;

    public Car dtoToCar(CarRequestDto carRequestDto) {
        Car car = new Car();
        car.setEngineType(carRequestDto.getEngineType());
        car.setMaxSpeed(carRequestDto.getMaxSpeed());
        car.setAccelerationTime(carRequestDto.getAccelerationTime());
        car.setPassengerCapacity(carRequestDto.getPassengerCapacity());
        car.setPassengerQuantity(carRequestDto.getPassengerQuantity());
        car.setCurrentSpeed(carRequestDto.getCurrentSpeed());

        List<CarWheel> wheels = new ArrayList<>();
        for (int i = 0; i < carRequestDto.getNumOfWheels(); i++) {
            wheels.add(new CarWheel());
        }

        List<CarDoor> doors = new ArrayList<>();
        for (int i = 0; i < carRequestDto.getNumOfDoors(); i++) {
            doors.add(new CarDoor());
        }

        return car;
    }

    public CarResponseDto carToDto(Car car) {
        CarResponseDto carResponseDto = new CarResponseDto();
        carResponseDto.setCarId(car.getCarId());
        carResponseDto.setEngineType(car.getEngineType());
        carResponseDto.setMaxSpeed(car.getMaxSpeed());
        carResponseDto.setAccelerationTime(car.getAccelerationTime());
        carResponseDto.setPassengerCapacity(car.getPassengerCapacity());
        carResponseDto.setPassengerCapacity(car.getPassengerQuantity());
        carResponseDto.setCurrentSpeed(car.getCurrentSpeed());
        List<CarDoorResponseDto> doors =
                car.getDoors()
                .stream()
                .map(carDoorMapper::carDoorToDto)
                .collect(Collectors.toList());
        carResponseDto.setDoors(doors);

        List<CarWheelResponseDto> wheels =
                car.getWheels()
                .stream()
                .map(carWheelMapper::carWheelToDto)
                .collect(Collectors.toList());
        carResponseDto.setWheels(wheels);

        return carResponseDto;
    }
}
