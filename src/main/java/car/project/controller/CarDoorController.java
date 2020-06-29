package car.project.controller;

import car.project.mapper.CarDoorMapper;
import car.project.model.CarDoor;
import car.project.model.dto.CarDoorRequestDto;
import car.project.model.dto.CarDoorResponseDto;
import car.project.service.CarDoorService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car-doors")
@Data
public class CarDoorController {
    private final CarDoorService carDoorService;
    private final CarDoorMapper carDoorMapper;

    @PostMapping
    public void addDoors(@RequestBody CarDoorRequestDto carDoorRequestDto) {
        carDoorService.add(carDoorMapper.dtoToCarDoor(carDoorRequestDto));
    }

    @GetMapping
    public List<CarDoorResponseDto> getDoors() {
        List<CarDoor> carDoors = carDoorService.getAll();
        return carDoors.stream()
                .map(carDoorMapper::carDoorToDto)
                .collect(Collectors.toList());
    }
}
