package car.project.dao;

import car.project.model.CarWheel;
import java.util.List;

public interface CarWheelDao {
    CarWheel add(CarWheel carWheel);

    List<CarWheel> getAll();
}
