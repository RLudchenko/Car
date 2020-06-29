package car.project.mapper;

import car.project.model.CarWheel;
import car.project.model.dto.CarWheelRequestDto;
import car.project.model.dto.CarWheelResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CarWheelMapper {
    public CarWheel dtoToCarWheel(CarWheelRequestDto carWheelRequestDto) {
        CarWheel carWheel = new CarWheel();
        carWheel.setWheelCondition(carWheelRequestDto.getWheelCondition());

        return carWheel;
    }

    public CarWheelResponseDto carWheelToDto(CarWheel carWheel) {
        CarWheelResponseDto carWheelResponseDto = new CarWheelResponseDto();
        carWheelResponseDto.setCarWheelId(carWheel.getCarWheelId());
        carWheelResponseDto.setWheelCondition(carWheel.getWheelCondition());

        return carWheelResponseDto;
    }
}
