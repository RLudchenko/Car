package car.project.dao;

import car.project.model.Car;
import java.util.List;

public interface CarDao {
    Car add(Car car);

    List<Car> getAll();
}
