package car.project.service;

import car.project.model.Car;
import java.util.List;

public interface CarService {
    Car add(Car car);

    List<Car> getAll();
}
