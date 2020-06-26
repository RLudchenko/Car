package car.project.service.impl;

import car.project.dao.CarDao;
import car.project.lib.Inject;
import car.project.lib.Service;
import car.project.model.Car;
import car.project.service.CarService;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Inject
    private CarDao carDao;

    @Override
    public Car add(Car car) {
        return carDao.add(car);
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }
}
