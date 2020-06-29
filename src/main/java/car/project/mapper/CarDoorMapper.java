package car.project.mapper;

import car.project.model.CarDoor;
import car.project.model.dto.CarDoorRequestDto;
import car.project.model.dto.CarDoorResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CarDoorMapper {
    public CarDoor dtoToCarDoor(CarDoorRequestDto carDoorRequestDto) {
        CarDoor carDoor = new CarDoor();
        carDoor.setOpenCarDoor(carDoorRequestDto.isDoorOpen());
        carDoor.setOpenCarWindow(carDoorRequestDto.isWindowOpen());

        return carDoor;
    }

    public CarDoorResponseDto carDoorToDto(CarDoor carDoor) {
        CarDoorResponseDto carDoorResponseDto = new CarDoorResponseDto();
        carDoorResponseDto.setDoorOpen(carDoor.isOpenCarDoor());
        carDoorResponseDto.setWindowOpen(carDoor.isOpenCarWindow());

        return carDoorResponseDto;
    }
}
