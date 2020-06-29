package car.project.controller;

import car.project.mapper.CarWheelMapper;
import car.project.model.CarWheel;
import car.project.model.dto.CarWheelRequestDto;
import car.project.model.dto.CarWheelResponseDto;
import car.project.service.CarWheelService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car-wheels")
@Data
public class CarWheelController {
    private final CarWheelService carWheelService;
    private final CarWheelMapper carWheelMapper;

    @PostMapping
    public void addWheels(@RequestBody CarWheelRequestDto carWheelRequestDto) {
        carWheelService.add(carWheelMapper.dtoToCarWheel(carWheelRequestDto));
    }

    @GetMapping
    public List<CarWheelResponseDto> getWheels() {
        List<CarWheel> carWheels = carWheelService.getAll();
        return carWheels.stream()
                .map(carWheelMapper::carWheelToDto)
                .collect(Collectors.toList());
    }
}
