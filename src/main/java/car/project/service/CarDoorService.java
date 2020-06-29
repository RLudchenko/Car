package car.project.service;

import car.project.model.CarDoor;
import java.util.List;

public interface CarDoorService {
    CarDoor add(CarDoor carDoor);

    List<CarDoor> getAll();
}
