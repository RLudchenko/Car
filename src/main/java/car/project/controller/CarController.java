package car.project.controller;

import car.project.mapper.CarMapper;
import car.project.model.Car;
import car.project.model.dto.CarRequestDto;
import car.project.model.dto.CarResponseDto;
import car.project.service.CarService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
@Data
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    @PostMapping
    public void addCars(@RequestBody CarRequestDto carRequestDto) {
        carService.add(carMapper.dtoToCar(carRequestDto));
    }

    @GetMapping
    public List<CarResponseDto> getCars() {
        List<Car> car = carService.getAll();

        return car.stream()
                .map(carMapper::carToDto)
                .collect(Collectors.toList());
    }
}
