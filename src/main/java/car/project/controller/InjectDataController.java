package car.project.controller;

import car.project.model.Car;
import car.project.model.CarDoor;
import car.project.model.CarWheel;
import car.project.service.CarDoorService;
import car.project.service.CarService;
import car.project.service.CarWheelService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/inject")
@RestController
public class InjectDataController {
    private final CarService carService;
    private final CarDoorService carDoorService;
    private final CarWheelService carWheelService;

    @GetMapping
    public ResponseEntity injectData() {
        CarDoor carDoor1 = new CarDoor();
        carDoor1.setOpenCarWindow(true);
        carDoor1.setOpenCarDoor(true);
        carDoorService.add(carDoor1);

        CarDoor carDoor2 = new CarDoor();
        carDoor2.setOpenCarWindow(false);
        carDoor2.setOpenCarDoor(false);
        carDoorService.add(carDoor2);

        CarWheel carWheel1 = new CarWheel();
        carWheel1.setWheelCondition(1.0);
        carWheelService.add(carWheel1);

        CarWheel carWheel2 = new CarWheel();
        carWheel2.setWheelCondition(1.0);
        carWheelService.add(carWheel2);

        Car car1 = new Car();
        car1.setEngineType("electric");
        car1.setMaxSpeed(240);
        car1.setAccelerationTime(2);
        car1.setPassengerCapacity(4);
        car1.setPassengerQuantity(4);
        car1.setDoors(List.of(carDoor1, carDoor2));
        car1.setWheels(List.of(carWheel1, carWheel2));
        carService.add(car1);
        return new ResponseEntity(HttpStatus.OK);
    }
}
