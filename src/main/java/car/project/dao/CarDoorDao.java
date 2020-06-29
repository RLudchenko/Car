package car.project.dao;

import car.project.model.CarDoor;
import java.util.List;

public interface CarDoorDao {
    CarDoor add(CarDoor carDoor);

    List<CarDoor> getAll();
}
