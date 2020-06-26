package car.project.service;

import car.project.model.CarWheel;
import java.util.List;

public interface CarWheelService {
    CarWheel add(CarWheel carWheel);

    List<CarWheel> getAll();
}
